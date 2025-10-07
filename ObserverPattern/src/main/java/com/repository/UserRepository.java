package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.UserMaster;
@Repository
public interface UserRepository extends JpaRepository<UserMaster,Integer> {
	public UserMaster findByUsername(String username);
	public UserMaster findByUsernameAndUserpass(String username, String password);
	public Optional findById(int id);
}