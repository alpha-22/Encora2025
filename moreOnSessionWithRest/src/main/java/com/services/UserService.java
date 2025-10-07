package com.services;

import java.util.UUID;

import com.model.Users;

public interface UserService {
	
	public Users login( Users user);
	public Users signup( Users user);
	public void logout( UUID id);
}
