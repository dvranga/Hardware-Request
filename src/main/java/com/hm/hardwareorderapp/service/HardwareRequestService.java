package com.hm.hardwareorderapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.hardwareorderapp.dto.HardwareRequestDTO;
import com.hm.hardwareorderapp.dto.LoginDTO;
import com.hm.hardwareorderapp.model.HardwareRequest;
import com.hm.hardwareorderapp.model.UserDetails;
import com.hm.hardwareorderapp.repository.HardwareRequestRepository;
import com.hm.hardwareorderapp.repository.UserRepository;

@Service
public class HardwareRequestService implements IHardwareRequestService {
	

	@Autowired
	public HardwareRequestRepository hardwareRequestRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public HardwareRequest updateStatusById(Integer id, HardwareRequestDTO hardwareRequestDTO) {
//		Optional<UserDetails> requestData = this.getUserDataByUserId(id);
//		requestData.updateStatusById(hardwareRequestDTO);
//		return hardwareRequestRepository.save(requestData);
		return null;
	}

	@Override
	public List<HardwareRequest> updateRequestDetails(HardwareRequestDTO hardwareRequestDTO) {
		List<UserDetails> findByEmail = userRepository.findByEmail("sincy1@gmail.com");
		HardwareRequest hardwareRequest= new HardwareRequest(hardwareRequestDTO, findByEmail.get(0));
		return null;
	}
	
	@Override
	public List<HardwareRequest> logIn(LoginDTO loginDTO) {
		List<UserDetails> findByEmail = userRepository.findByEmail(loginDTO.getEmailAddress());
		if (findByEmail.get(0).getDesignation()!=3) {
			return hardwareRequestRepository.findByEmail(findByEmail.get(0).getEmailAddress());
		}
		else {
			return hardwareRequestRepository.findManagerEmployees(findByEmail.get(0).getManager());
		}
		
	}

}
