package com.hm.hardwareorderapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hm.hardwareorderapp.model.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer> {

	@Query(value = "Select * from user_details where email_address=:emailId",nativeQuery = true)
	List<UserDetails> findByEmail(String emailId);

}
