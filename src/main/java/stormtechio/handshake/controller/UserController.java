package stormtechio.handshake.controller;

import java.util.ArrayList;

import stormtechio.handshake.model.User;
import stormtechio.handshake.service.UserService;

public class UserController {
	
	private UserService userService;
	public UserController() {
		this.userService =  new UserService();
	}
	
	public boolean addUser(User user) {
		return this.userService.addUser(user);
	}

	public ArrayList<User> getUsers() {	
		return this.userService.getUsers();
	}
	
	public boolean deleteUserById(int id) {
		return this.userService.deleteUserById(id);
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return this.userService.getUserById(id);
	}
}
