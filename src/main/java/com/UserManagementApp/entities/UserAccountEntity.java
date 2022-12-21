package com.UserManagementApp.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "user_account")
public class UserAccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID" )
	private int userId;
	
	@Column(name = "USER_FIRST_NAME")
	private String fname;
	
	@Column(name = "USER_LAST_NAME")
	private String lname;
	
	@Column(name = "USER_MAIL")
	private String email;
	
	@Column(name = "USER_PHNO")
	private String phone;
	
	@Column(name = "USER_DOB")
	private Date dob;
	
	@Column(name = "GENDER")
	private String gender;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "STATE")
	private String state;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "USER_PASSWORD")
	private String password;
	
	@Column(name = "ACTIVE_SW")
	private String accStatus;
	
	@CreationTimestamp
	@Column(name = "CREATED_DATE",updatable = false)
	private LocalDate CreatedDate;
	
	@UpdateTimestamp
	@Column(name = "UPDATED_DATE",insertable = false)
	private LocalDate UpdatedDate;



}
