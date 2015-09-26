package com.jsrk.backup.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jsrk.backup.server.controller.introduction.DeviceControllerIntroduction;
import com.jsrk.backup.server.globals.Request;
import com.jsrk.backup.server.globals.Response;

/**
 * Contains controller-actions for device related requests.
 */
@Controller
public class DeviceController {

	private DeviceControllerIntroduction deviceControllerIntroduction;

	@Autowired
	public void setUserControllerIntroduction(
			DeviceControllerIntroduction deviceControllerIntroduction) {
		this.deviceControllerIntroduction = deviceControllerIntroduction;
	}

	/**
	 * home - Returns home page of the logged user
	 * 
	 * @param model
	 *            Model on which the attributes are to be set
	 * @return Model with the concerned view and attributes
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView showHome(Model model) {

		ModelAndView mv = new ModelAndView();
		Request<Integer> request = new Request<Integer>();
		request.setUrl("/home");

		Response<Integer> response = deviceControllerIntroduction
				.showHome(request);

		mv.setViewName(response.getViewName());

		return mv;
	}

}
