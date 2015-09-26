package com.jsrk.backup.server.controller.introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsrk.backup.server.data.service.UserService;
import com.jsrk.backup.server.details.UserDetails;
import com.jsrk.backup.server.globals.Request;
import com.jsrk.backup.server.globals.Response;
import com.jsrk.backup.server.model.User;

/**
 * Introduction class for UserController to enable logging using AOP.
 */
@Component
public class UserControllerIntroduction {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Response<UserDetails> registerUser(Request<Integer> request) {

		Response<UserDetails> response = new Response<UserDetails>();
		response.setData(new UserDetails());
		response.setViewName("insert-user");

		return response;

	}

	public Response<User> insertUser(Request<UserDetails> request) {

		Response<User> response = userService.insertUser(request.getData());
		response.setViewName("redirect:/show_register");

		return response;

	}

	public Response<UserDetails> showLogin(Request<Integer> request) {

		Response<UserDetails> response = new Response<UserDetails>();
		response.setData(new UserDetails());
		response.setViewName("show-login");

		return response;

	}

}
