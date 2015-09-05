package com.jsrk.backup.server.globals;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * A singleton bean configured at server startup to contain user configured
 * messages
 * <ul>
 * <li>{@link #DATABASE_CORRUPTED_MESSAGE}</li>
 * <li>{@link #USER_USERNAME_INVALID_MESSAGE}</li>
 * <li>{@link #USER_USERNAME_TAKEN_MESSAGE}</li>
 * <li>{@link #USER_USERNAME_FIXED_MESSAGE}</li>
 * <li>{@link #USER_PASSWORD_INVALID_MESSAGE}</li>
 * <li>{@link #USER_SAVE_FAILED_MESSAGE}</li>
 * <li>{@link #USER_UPDATE_FAILED_MESSAGE}</li>
 * </ul>
 */
@Startup
@Singleton
@Component
public class MessageConfig {

	/**
	 * Database corrupted message.
	 */
	@Value("${database.corrupt}")
	public String DATABASE_CORRUPTED_MESSAGE;

	/**
	 * Invalid user's username message.
	 */
	@Value("${user.username.invalid}")
	public String USER_USERNAME_INVALID_MESSAGE;

	/**
	 * User with username already exists in database message.
	 */
	@Value("${user.username.taken}")
	public String USER_USERNAME_TAKEN_MESSAGE;

	/**
	 * User's username cannot be changed message.
	 */
	@Value("${user.username.fixed}")
	public String USER_USERNAME_FIXED_MESSAGE;

	/**
	 * Invalid user's password message.
	 */
	@Value("${user.password.invalid}")
	public String USER_PASSWORD_INVALID_MESSAGE;

	/**
	 * User save failed message.
	 */
	@Value("${user.save.failed}")
	public String USER_SAVE_FAILED_MESSAGE;

	/**
	 * User update failed message.
	 */
	@Value("${user.update.failed}")
	public String USER_UPDATE_FAILED_MESSAGE;

}
