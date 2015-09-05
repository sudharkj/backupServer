package com.jsrk.backup.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jsrk.backup.server.details.UserDetails;

@Controller
public class UserController {

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerUser(Model model) {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("insert-user");
		model.addAttribute("userDetails", new UserDetails());

		return mv;
	}

}
