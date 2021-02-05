package com.hm.hardwareorderapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.hardwareorderapp.dto.HardwareRequestDTO;
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
	public List<HardwareRequest> getAllRequests() {
		List<HardwareRequest> requestList = hardwareRequestRepository.findAll();
		if (requestList.isEmpty()) {
			return null;
		}
		return requestList;
	}

	@Override
	public Optional<UserDetails> getUserDataByUserId(Integer userId) {
		return userRepository.findById(userId);
	}
	
	@Override
	public HardwareRequest updateStatusById(Integer id, HardwareRequestDTO hardwareRequestDTO) {
		Optional<UserDetails> requestData = this.getUserDataByUserId(id);
//		requestData.updateStatusById(hardwareRequestDTO);
//		return hardwareRequestRepository.save(requestData);
		return null;
	}

}
