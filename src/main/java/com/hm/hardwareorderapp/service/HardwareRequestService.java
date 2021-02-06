package com.hm.hardwareorderapp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	public Optional<HardwareRequest> updateStatusById(Integer id, String status) {
		Optional<HardwareRequest> findById = hardwareRequestRepository.findById(id);
		findById.get().setStatus(status);
		hardwareRequestRepository.save(findById.get());
		return findById;
	}

	@Override
	public List<HardwareRequest> logIn(LoginDTO loginDTO) {
		List<UserDetails> findByEmail = userRepository.findByEmail(loginDTO.getEmailAddress());
		if (findByEmail.get(0).getDesignation()!=3) {
			return hardwareRequestRepository.findUserDetails(findByEmail.get(0).getUserId());
		}
		else {
			return hardwareRequestRepository.findManagerEmployees(findByEmail.get(0).getUserId());
		}
	}
}
