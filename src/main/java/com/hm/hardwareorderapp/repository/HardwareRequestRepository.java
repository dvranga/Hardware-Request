package com.hm.hardwareorderapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hm.hardwareorderapp.model.HardwareRequest;
import com.hm.hardwareorderapp.model.UserDetails;

public interface HardwareRequestRepository extends JpaRepository<HardwareRequest, Integer>{
	

	@Query(value = "Select * from user_details where id=:userId",nativeQuery = true)
	UserDetails findByUserId(int userId);


}
