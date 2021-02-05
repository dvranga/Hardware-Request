package com.hm.hardwareorderapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hm.hardwareorderapp.dto.HardwareRequestDTO;
import com.hm.hardwareorderapp.model.HardwareRequest;
import com.hm.hardwareorderapp.model.UserDetails;
import com.hm.hardwareorderapp.response.Response;
import com.hm.hardwareorderapp.service.IHardwareRequestService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/hardwarerequest")
public class HardwareRequestController {
	
	@Autowired
	public IHardwareRequestService hardwareRequestService;
	
	@ApiOperation("For getting all requests")
	@GetMapping("/getRequest")
	public ResponseEntity<Response> getAllRequests() {
		List<HardwareRequest> requestList =hardwareRequestService.getAllRequests();
		if (requestList != null)
			return new ResponseEntity<>(new Response(200, "Returned all requests successfully", requestList), HttpStatus.OK);
		return new ResponseEntity<>(new Response(400, "Don't have any requests!!"), HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ApiOperation("To get user by user id")
	@GetMapping("/getRequest/{userId}")
	public ResponseEntity<Response> getUserDataByUserId(@PathVariable("userId") Integer userId) {
		Optional<UserDetails> requestList = hardwareRequestService.getUserDataByUserId(userId);
		if (requestList != null)
			return new ResponseEntity<>(new Response(200, "Get call for ID successfull", requestList), HttpStatus.OK);
		return new ResponseEntity<>(new Response(400, "Request does not exists!!"), HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ApiOperation("To set a status")
	@PostMapping("/create/status/{id}")
	public ResponseEntity<Response> createStatusData(@PathVariable("id") Integer id,@RequestBody HardwareRequestDTO hardwareRequestDTO) {
		HardwareRequest requestList = hardwareRequestService.updateStatusById(id, hardwareRequestDTO);
		return new ResponseEntity<>(new Response(200, "Inserted status data successfully!!", requestList), HttpStatus.OK);
	}

}
