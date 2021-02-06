package com.hm.hardwareorderapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hm.hardwareorderapp.dto.HardwareRequestDTO;
import com.hm.hardwareorderapp.dto.LoginDTO;
import com.hm.hardwareorderapp.dto.RegisterDTO;
import com.hm.hardwareorderapp.model.HardwareRequest;
import com.hm.hardwareorderapp.model.UserDetails;
import com.hm.hardwareorderapp.response.Response;
import com.hm.hardwareorderapp.service.IHardwareRequestService;
import com.hm.hardwareorderapp.service.IUserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/hardwarerequest")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	public IHardwareRequestService hardwareRequestService;
	
	
	@ApiOperation("For User Register")
	@PostMapping("/register")
	public ResponseEntity<Response> register(@RequestBody RegisterDTO registerDTO){
		UserDetails user=userService.register(registerDTO);
		return new ResponseEntity<Response>(new Response(200, "Successfull", user),HttpStatus.OK);
	}

	
	@ApiOperation("For User Login")
	@PostMapping("/login")
	public ResponseEntity<Response> login(@RequestBody LoginDTO loginDTO){
		List<HardwareRequest> user=hardwareRequestService.logIn(loginDTO);
		return new ResponseEntity<Response>(new Response(200, "Successfull", user),HttpStatus.OK);
	}
}

