package com.UserManagementApp.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

	private String fname;
	
	private String lname;
	
	private String email;
	
	private String phone;
	
	private Date dob;

	private String gender;

	private String country;

	private String state;

	private String city;
	
	private String password;
	
	private String accStatus;
	
	
	
}
