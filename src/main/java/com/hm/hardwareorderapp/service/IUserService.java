package com.hm.hardwareorderapp.service;

import com.hm.hardwareorderapp.dto.RegisterDTO;
import com.hm.hardwareorderapp.model.UserDetails;

public interface IUserService {

	UserDetails register(RegisterDTO registerDTO);

}
