package com.UserManagementApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.UserManagementApp.model.UnlockAccount;
import com.UserManagementApp.service.UserServiceI;

@RestController
public class UnlockAccountController {

	@Autowired
	private UserServiceI userServiceI;
	
	@PutMapping("/unlockAccount")
	public ResponseEntity<String> unlockAccount(@RequestBody UnlockAccount unlockAccount)
	{
		boolean unlockAccount2 = userServiceI.unlockAccount(unlockAccount);
		
		if(unlockAccount2)
		{
			return new ResponseEntity<String>("Account Unlock Successful", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Account Not Unlock", HttpStatus.OK);

		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
