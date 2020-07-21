package stormtechio.handshake.controller;

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
}
