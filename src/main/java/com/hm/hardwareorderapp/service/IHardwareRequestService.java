package com.hm.hardwareorderapp.service;

import java.util.List;
import java.util.Optional;

import com.hm.hardwareorderapp.dto.LoginDTO;
import com.hm.hardwareorderapp.model.HardwareRequest;

public interface IHardwareRequestService {
	
	Optional<HardwareRequest> updateStatusById(Integer id, String status);

	List<HardwareRequest> logIn(LoginDTO loginDTO);

}
