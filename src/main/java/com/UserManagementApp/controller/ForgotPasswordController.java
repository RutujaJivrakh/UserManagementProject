package com.UserManagementApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.UserManagementApp.service.UserServiceI;

@RestController
public class ForgotPasswordController {

	@Autowired
	private UserServiceI userServiceI;


	@GetMapping("/forgotPassword/{email}")
	public String forgotPassword(@PathVariable String email)
	{
		String forgotPassword = userServiceI.forgotPassword(email);
		return forgotPassword;
		
	}

}
