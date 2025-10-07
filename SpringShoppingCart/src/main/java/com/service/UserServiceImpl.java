package com.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.User;
import com.repository.UserRepo;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userrepo;
	@Override
	public User getUser(String name) throws UserNotFoundException {
		return Optional.ofNullable(userrepo.findByUsername(name))
				.map((n)->n)
				.orElseThrow(()->new UserNotFoundException("Invalid name..."));
	}
	
	public User getUserById(int uid) throws UserNotFoundException {
		Optional opt=userrepo.findById(uid);
		User user=(User)opt.get();
		return Optional.ofNullable(user)
				.map(n->n)
				.orElseThrow(()->new UserNotFoundException("invalid id.."));
	}
	
	public User checkUserByNameAndPassword(String username,String userpass)throws UserNotFoundException {
		return Optional.ofNullable(userrepo.findByUsernameAndUserpass(username, userpass))
				.map(n->n)
				.orElseThrow(()->new UserNotFoundException("Invalid Credentials..."));
	}
	@Override
	public boolean checkFlag(String uname) {
		return Optional.ofNullable(userrepo.findByUsername(uname))
		.filter(n->n.getFlag()==0)
		.map(n->true)
		.orElseGet(()->false);
	}
	@Override
	public void updateFlag(String uname, int flag) {
		Optional.ofNullable(userrepo.findByUsername(uname))
		.map(n->{n.setFlag(flag); userrepo.save(n);return n;});
		
	}
	@Override
	public boolean checkUser(String username, String userpass) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public User createUser(String uname, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
class UserNotFoundException extends Exception{
	String msg;
	public UserNotFoundException(String msg) {
		this.msg=msg;
	}
	@Override
	public String toString() {
		return "Exception...:"+msg;
	}
}
