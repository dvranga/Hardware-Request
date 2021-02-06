package com.hm.hardwareorderapp.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.hm.hardwareorderapp.dto.RegisterDTO;
import com.hm.hardwareorderapp.model.UserDetails;
import com.hm.hardwareorderapp.repository.UserRepository;

@Service
public class UserService implements IUserService{

	@Autowired
	private UserRepository userRepository;
	

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDetails register(RegisterDTO registerDTO) {
		List<UserDetails> findByEmail = userRepository.findByEmail(registerDTO.getEmailAddress());
		if (findByEmail == null) {
			return null;
		}
		UserDetails userDetails = new UserDetails(registerDTO);
		userDetails.setUserPassword(bCryptPasswordEncoder.encode(registerDTO.getUserPassword()));
		return userRepository.save(userDetails);
	}

}
