package com.UserManagementApp.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UnlockAccount {

	
	private String email;
	
	private String tempPassword;
	
	private String newPassword;
	
	private String confirmPassword;
}
