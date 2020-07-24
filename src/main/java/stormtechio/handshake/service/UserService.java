package stormtechio.handshake.service;

import java.util.ArrayList;

import stormtechio.handshake.model.User;
import stormtechio.handshake.repository.UserRepository;

public class UserService {

	private UserRepository userRepository;
	
	public UserService() {
		this.userRepository = new UserRepository();
	}
	
	
	public boolean addUser(User user) {
		
		if(user.getFirstName().isEmpty() || user.getLastName().isEmpty() || user.getEmail().isEmpty() || user.getPhone().isEmpty() || user.getUsername().isEmpty()) {
			return false;
		}
		
		return this.userRepository.addUser(user);
	
	}


	public ArrayList<User> getUsers() {
		return this.userRepository.getUsers();

	}

}
