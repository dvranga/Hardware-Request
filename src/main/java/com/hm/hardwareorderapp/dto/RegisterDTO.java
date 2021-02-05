package com.hm.hardwareorderapp.dto;

import javax.persistence.Column;

import lombok.Data;

@Data
public class RegisterDTO {
	
	@Column(name = "user_name")
	public String userName;
	
	@Column(name = "first_name")
	public String firstName;
	
	@Column(name = "designation")
	public int designation;
	
	@Column(name = "email_address")
	public String emailAddress;
	
	@Column(name = "address")
	public String address;
	
	@Column(name = "user_password")
	public String userPassword;
	
	@Column(name = "manager")
	public int manager;
}
