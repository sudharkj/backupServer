package com.jsrk.backup.server.data.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsrk.backup.server.data.dao.UserDAO;
import com.jsrk.backup.server.data.service.UserService;
import com.jsrk.backup.server.details.UserDetails;
import com.jsrk.backup.server.globals.MessageConfig;
import com.jsrk.backup.server.globals.Response;
import com.jsrk.backup.server.globals.ResponseCodes;
import com.jsrk.backup.server.model.User;

@Service
public class UserServiceImpl implements UserService {

	private MessageConfig messageConfig;

	private SessionFactory sessionFactory;

	private UserDAO userDAO;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Autowired
	public void setMessageConfig(MessageConfig messageConfig) {
		this.messageConfig = messageConfig;
	}

	@Override
	public Response<User> insertUser(UserDetails userDetails) {
		Session session = sessionFactory.getCurrentSession();
		User user = null;

		Response<User> response = new Response<User>();
		List<String> errors = new ArrayList<String>();
		response.setErrors(errors);

		try {
			user = userDAO
					.getUserByUsername(session, userDetails.getUsername());
		} catch (HibernateException ex) {
			ex.printStackTrace();

			errors.add(messageConfig.DATABASE_CORRUPTED_MESSAGE);

			response.setCode(ResponseCodes.INTERNAL_SERVER_ERROR.getCode());
			response.setDescription(ResponseCodes.INTERNAL_SERVER_ERROR
					.getDescription());
		}

		// validation
		if (errors.isEmpty()) {
			if (userDetails.getUsername().isEmpty()) {
				errors.add(messageConfig.USER_USERNAME_INVALID_MESSAGE);
			}
			if (userDetails.getPassword().isEmpty()) {
				errors.add(messageConfig.USER_PASSWORD_INVALID_MESSAGE);
			}
		}

		if (errors.isEmpty()) {
			// if id of userDetails is null then he is a new user
			// insert only if no user with same name exists
			// <p>
			// else edit the user only if the id matches, in other words,
			// username cannot be changed
			if (userDetails.getId() == null) {
				if (user == null) {
					user = new User();
					user.setUsername(userDetails.getUsername());
					user.setPassword(userDetails.getPassword());
				} else {
					errors.add(messageConfig.USER_USERNAME_TAKEN_MESSAGE);
				}
			} else if (user != null && user.getId().equals(userDetails.getId())) {
				user.setPassword(userDetails.getPassword());
			} else {
				errors.add(messageConfig.USER_USERNAME_FIXED_MESSAGE);
			}
		}

		if (errors.isEmpty()) {
			try {
				userDAO.saveOrUpdate(session, user);

				response.setData(user);
				response.setCode(ResponseCodes.INSERTED.getCode());
				response.setDescription(ResponseCodes.INSERTED.getDescription());
			} catch (HibernateException ex) {
				ex.printStackTrace();

				if (userDetails.getId() == null) {
					errors.add(messageConfig.USER_SAVE_FAILED_MESSAGE);
				} else {
					errors.add(messageConfig.USER_UPDATE_FAILED_MESSAGE);
				}
			}
		}

		if (response.getCode() == null) {
			response.setCode(ResponseCodes.FORBIDDEN.getCode());
			response.setDescription(ResponseCodes.FORBIDDEN.getDescription());
		}

		return response;
	}
}
