package com.jsrk.backup.server.controller.introduction;

import org.springframework.stereotype.Component;

import com.jsrk.backup.server.globals.Request;
import com.jsrk.backup.server.globals.Response;

@Component
public class DeviceControllerIntroduction {

	public Response<Integer> showHome(Request<Integer> request) {

		Response<Integer> response = new Response<Integer>();
		response.setViewName("home");

		return response;

	}

}
