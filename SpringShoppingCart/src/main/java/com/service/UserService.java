package com.service;
import com.model.User;
public interface UserService {
	public User getUser(String username) throws UserNotFoundException;
	public boolean checkUser(String username,String userpass)  throws UserNotFoundException ;
	public boolean checkFlag(String username);
	
	public User createUser(String username, String password);
	public User checkUserByNameAndPassword(String username, String password) throws UserNotFoundException;
	public void updateFlag(String username, int flag);
}