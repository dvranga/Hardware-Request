package com.hm.hardwareorderapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hm.hardwareorderapp.dto.RegisterDTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "user_details")
@ToString
@Data
@NoArgsConstructor
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	public int userId;
	
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

	public UserDetails(RegisterDTO registerDTO) {
		this.userName = registerDTO.userName;
		this.firstName = registerDTO.firstName;
		this.designation = registerDTO.designation;
		this.emailAddress = registerDTO.emailAddress;
		this.address = registerDTO.address;
		this.userPassword = registerDTO.userPassword;
		this.manager = registerDTO.manager;
	}
	
	
}
