package com.hm.hardwareorderapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
	@PostMapping("/create/status/{id}/{status}")
	public ResponseEntity<Response> createStatusData(@PathVariable("id") Integer id, @PathVariable("status") String status) {
		Optional<HardwareRequest> requestList = hardwareRequestService.updateStatusById(id, status);
		return new ResponseEntity<>(new Response(200, "Inserted status data successfully!!", requestList), HttpStatus.OK);
	}

}
