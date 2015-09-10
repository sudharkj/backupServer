package com.jsrk.backup.server.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jsrk.backup.server.data.service.UserService;
import com.jsrk.backup.server.details.UserDetails;

/**
 * Contains controller-actions for user related requests.
 */
@Controller
public class UserController {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * register - Returns a view where a user can register with the application.
	 * 
	 * @param model
	 *            Model on which the attributes are to be set
	 * @return Model with the concerned view and attributes
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerUser(Model model) {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("insert-user");
		model.addAttribute("userDetails", new UserDetails());

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
			BindingResult result, Model model, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		System.out.println("\n\tRequest=[url=/insert_user, " + userDetails
				+ "]\n\t" + userService.insertUser(userDetails));

		mv.setViewName("redirect:/register");

		return mv;
	}

}
