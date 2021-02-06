package com.hm.hardwareorderapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hm.hardwareorderapp.dto.HardwareRequestDTO;
import com.hm.hardwareorderapp.dto.LoginDTO;
import com.hm.hardwareorderapp.model.HardwareRequest;
import com.hm.hardwareorderapp.response.Response;
import com.hm.hardwareorderapp.service.IHardwareRequestService;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/hardwarerequest")
public class HardwareRequestController {
	
	@Autowired
	public IHardwareRequestService hardwareRequestService;
	
	@ApiOperation("To set a status")
	@PostMapping("/create/status/{id}")
	public ResponseEntity<Response> createStatusData(@PathVariable("id") Integer id,@RequestBody HardwareRequestDTO hardwareRequestDTO) {
		HardwareRequest requestList = hardwareRequestService.updateStatusById(id, hardwareRequestDTO);
		return new ResponseEntity<>(new Response(200, "Inserted status data successfully!!", requestList), HttpStatus.OK);
	}
	
	@ApiOperation("For User Register")
	@PostMapping("/register")
	public ResponseEntity<Response> updateRequestDetails(@RequestBody HardwareRequestDTO hardwareRequestDTO){
		List<HardwareRequest> hardwareRequests= hardwareRequestService.updateRequestDetails(hardwareRequestDTO);
		return new ResponseEntity<Response>(new Response(200, "Successfull", hardwareRequests),HttpStatus.OK);
	}
	
	@ApiOperation("For User Login")
	@PostMapping("/login")
	public ResponseEntity<Response> login(@RequestBody LoginDTO loginDTO){
		List<HardwareRequest> user=hardwareRequestService.logIn(loginDTO);
		return new ResponseEntity<Response>(new Response(200, "Successfull", user),HttpStatus.OK);
	}
}
