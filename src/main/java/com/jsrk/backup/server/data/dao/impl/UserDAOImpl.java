package com.jsrk.backup.server.data.dao.impl;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.jsrk.backup.server.data.dao.UserDAO;
import com.jsrk.backup.server.globals.TimeZoneConvertor;
import com.jsrk.backup.server.model.User;

/**
 * Contains implementation of UserDAO
 */
@Repository
public class UserDAOImpl implements UserDAO {

	@Override
	public void saveOrUpdate(Session session, User user)
			throws HibernateException {

		Date now = TimeZoneConvertor.getCurrentGMTDate();
		if (user.getId() == null) {
			user.setCreatedDateTime(now);
		}
		user.setUpdatedDateTime(now);

		session.saveOrUpdate(user);
	}

	@Override
	public User getUserByUsername(Session session, String username)
			throws HibernateException {

		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));

		return (User) criteria.uniqueResult();
	}

}
