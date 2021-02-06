package com.hm.hardwareorderapp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hm.hardwareorderapp.model.HardwareRequest;
import com.hm.hardwareorderapp.model.UserDetails;

public interface HardwareRequestRepository extends JpaRepository<HardwareRequest, Integer>{
	

	@Query(value = "Select * from user_details where id=:userId",nativeQuery = true)
	UserDetails findByUserId(int userId);

	@Query(value = "select * from user_details ud join hw_request_order hro\r\n"
			+ "on ud.user_id=hro.user_id and ud.email_address=:emailId",nativeQuery = true)
	List<HardwareRequest> findByEmail(String emailId);


	@Query(value = "select * from user_details ud join hw_request_order hro\r\n"
			+ "on ud.user_id=hro.user_id and ud.manager=:manager",nativeQuery = true)
	List<HardwareRequest> findManagerEmployees(int manager);


}
