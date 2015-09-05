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

@Controller
public class UserController {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerUser(Model model) {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("insert-user");
		model.addAttribute("userDetails", new UserDetails());

		return mv;
	}

	@RequestMapping(value = "/insert_user", method = RequestMethod.POST)
	public ModelAndView insertUser(UserDetails userDetails,
			BindingResult result, Model model, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		System.out.println(userService.insertUser(userDetails));

		mv.setViewName("redirect:/register");

		return mv;
	}

}
