package com.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
	public User findByUsername(String username);
	public User findByUsernameAndUserpass(String username, String password);
	public Optional findById(int id);
}







