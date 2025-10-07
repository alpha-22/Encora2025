package com.service;
import com.model.UserMaster;
public interface UserService {
	public UserMaster getUser(String username) throws UserNotFoundException;
	public boolean checkUser(String username,String userpass)  throws UserNotFoundException ;
	public boolean checkFlag(String uname);
	
	public UserMaster createUser(String uname, String password);
	public UserMaster checkUserByNameAndPassword(String uname, String password) throws UserNotFoundException;
	public void updateFlag(String uname, int flag);
}