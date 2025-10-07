package com.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.MoreOnSessionWithRestApplication;
import com.model.Users;
import com.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {


	@Autowired
	UserRepo userRepo;

   
	
	@Override
	public Users login(Users user) {
		Users currentUser = userRepo.findByNameAndPass(user.getName(), user.getPass());
		System.out.println(" current user"+ currentUser);
		if(currentUser != null)
		{
		currentUser.setFlag(true);
		userRepo.save(currentUser);
		}
		
		return currentUser;
	}

	@Override
	public Users signup(Users user) {
		Users newUser = new Users();
		newUser.setName(user.getName());
		newUser.setPass(user.getPass());
		newUser.setFlag(true);
		userRepo.save(newUser);
		return newUser;
	}

	@Override
	public void logout(UUID id) {
		Users currentUser = userRepo.findById(id).orElse(null);
		System.out.println("called logout" + id);
		currentUser.setFlag(false);	
		userRepo.save(currentUser);
	}
}
