package com.jsrk.backup.server.data.service;

import com.jsrk.backup.server.details.UserDetails;
import com.jsrk.backup.server.globals.Response;
import com.jsrk.backup.server.model.User;

/**
 * Contains user-related services and returns Response
 */
public interface UserService {

	/**
	 * Inserts user based on user-details
	 * 
	 * @param userDetails
	 *            User-details to be inserted
	 * @return Response for the request
	 */
	Response<User> insertUser(UserDetails userDetails);

}
