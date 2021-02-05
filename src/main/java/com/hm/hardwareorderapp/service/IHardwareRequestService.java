package com.hm.hardwareorderapp.service;

import java.util.List;

import javax.validation.Valid;

import com.hm.hardwareorderapp.dto.HardwareRequestDTO;
import com.hm.hardwareorderapp.model.HardwareRequest;
import com.hm.hardwareorderapp.model.UserDetails;
import java.util.Optional;

public interface IHardwareRequestService {
	
	List<HardwareRequest> getAllRequests();

	Optional<UserDetails> getUserDataByUserId(Integer userId);

	HardwareRequest updateStatusById(Integer id, HardwareRequestDTO hardwareRequestDTO);

}
