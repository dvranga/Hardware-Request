package com.hm.hardwareorderapp.service;

import java.util.List;

import javax.validation.Valid;

import com.hm.hardwareorderapp.dto.HardwareRequestDTO;
import com.hm.hardwareorderapp.dto.LoginDTO;
import com.hm.hardwareorderapp.model.HardwareRequest;

public interface IHardwareRequestService {
	
	HardwareRequest updateStatusById(Integer id, HardwareRequestDTO hardwareRequestDTO);

	List<HardwareRequest> updateRequestDetails(HardwareRequestDTO hardwareRequestDTO);

	List<HardwareRequest> logIn(@Valid LoginDTO loginDTO);
}
