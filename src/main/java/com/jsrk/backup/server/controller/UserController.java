package com.jsrk.backup.server.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jsrk.backup.server.controller.introduction.UserControllerIntroduction;
import com.jsrk.backup.server.details.UserDetails;
import com.jsrk.backup.server.globals.Request;
import com.jsrk.backup.server.globals.Response;
import com.jsrk.backup.server.model.User;

/**
 * Contains controller-actions for user related requests.
 */
@Controller
public class UserController {

	private UserControllerIntroduction userControllerIntroduction;

	@Autowired
	public void setUserControllerIntroduction(
			UserControllerIntroduction userControllerIntroduction) {
		this.userControllerIntroduction = userControllerIntroduction;
	}

	/**
	 * register - Returns a view where a user can register with the application.
	 * 
	 * @param model
	 *            Model on which the attributes are to be set
	 * @return Model with the concerned view and attributes
	 */
	@RequestMapping(value = "/show_register", method = RequestMethod.GET)
	public ModelAndView registerUser(Model model) {

		ModelAndView mv = new ModelAndView();
		Request<Integer> request = new Request<Integer>();
		request.setUrl("/show_register");

		Response<UserDetails> response = userControllerIntroduction
				.registerUser(request);

		mv.setViewName(response.getViewName());
		model.addAttribute("userDetails", response.getData());

		return mv;
	}

	/**
	 * insert_user - Registers a user with the application.
	 * 
	 * @param userDetails
	 *            Details of the user who is to be registered
	 * @param result
	 *            Result after validating the userDetails
	 * @param model
	 *            Model on which attributes are to be set
	 * @param request
	 *            Request from the client
	 * @return Model with the concerned view and attributes
	 */
	@RequestMapping(value = "/insert_user", method = RequestMethod.POST)
	public ModelAndView insertUser(UserDetails userDetails,
			BindingResult result, Model model,
			HttpServletRequest httpServletRequest) {

		ModelAndView mv = new ModelAndView();
		Request<UserDetails> request = new Request<UserDetails>();

		request.setUrl("/insert_user");
		request.setData(userDetails);

		Response<User> response = userControllerIntroduction
				.insertUser(request);

		mv.setViewName(response.getViewName());

		return mv;
	}

	/**
	 * show_login - Returns a view for the user to login
	 * 
	 * @param model
	 *            Model on which the attributes are to be set
	 * @return Model with the concerned view and attributes
	 */
	@RequestMapping(value = "/show_login", method = RequestMethod.GET)
	public ModelAndView showLogin(Model model) {

		ModelAndView mv = new ModelAndView();
		Request<Integer> request = new Request<Integer>();
		request.setUrl("/show_login");

		Response<UserDetails> response = userControllerIntroduction
				.showLogin(request);

		mv.setViewName(response.getViewName());
		model.addAttribute("userDetails", response.getData());

		return mv;
	}

}
