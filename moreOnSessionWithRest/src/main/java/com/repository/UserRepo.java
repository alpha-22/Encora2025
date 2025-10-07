package com.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Users;


@Repository
public interface UserRepo extends JpaRepository<Users, UUID> {
	
	public Users findByNameAndPass(String username, String password);

}

