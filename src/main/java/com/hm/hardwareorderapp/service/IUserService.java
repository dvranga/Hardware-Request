package com.hm.hardwareorderapp.service;

import java.util.List;

import javax.validation.Valid;

import com.hm.hardwareorderapp.dto.LoginDTO;
import com.hm.hardwareorderapp.dto.RegisterDTO;
import com.hm.hardwareorderapp.model.UserDetails;

public interface IUserService {

	List<UserDetails> logIn(@Valid LoginDTO loginDTO);

	UserDetails register(RegisterDTO registerDTO);

}
