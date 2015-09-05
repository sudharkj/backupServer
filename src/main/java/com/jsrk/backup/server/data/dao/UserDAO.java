package com.jsrk.backup.server.data.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.jsrk.backup.server.model.User;

/**
 * Contains user related hibernate functions. All functions take session as one
 * of the parameter and may throw HibernateException.
 */
public interface UserDAO {

	/**
	 * Saves or updates a user object.
	 * 
	 * @param session
	 *            Session sent by a service
	 * @param user
	 *            User that is to be inserted in the database
	 * @throws HibernateException
	 *             If the expected properties of User model is not set in user
	 */
	public void saveOrUpdate(Session session, User user)
			throws HibernateException;

	/**
	 * Returns user by username.
	 * 
	 * @param session
	 *            Session sent by a service
	 * @param username
	 *            Username of the user which is to be returned
	 * @return User with username
	 * @throws HibernateException
	 *             If there are more than one user with the username
	 */
	public User getUserByUsername(Session session, String username)
			throws HibernateException;

}
