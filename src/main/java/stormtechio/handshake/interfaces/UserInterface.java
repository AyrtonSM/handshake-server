package stormtechio.handshake.interfaces;

import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import stormtechio.handshake.controller.UserController;
import stormtechio.handshake.model.User;

@RestController
public interface UserInterface {
	
	@PostMapping("user/create")
	default String addUser(@RequestBody String body) {
		
		
		UserController userController = new UserController();
		JSONObject requestedBody =  new JSONObject(body);
		User user = new User();
		
		user.setFirstName(requestedBody.getString("first_name"));
		user.setLastName(requestedBody.getString("last_name"));
		user.setEmail(requestedBody.getString("email"));
		user.setPhone(requestedBody.getString("phone"));
		user.setUsername(requestedBody.getString("username"));
		
		
		if(userController.addUser(user)) {
			return new JSONObject().put("response",200).toString();
		}else {
			return new JSONObject().put("response",500).toString();
		}
		
	}
	
	@GetMapping("user/all")
	default ArrayList<User> getUsers() {
		
		UserController userController = new UserController();
		return userController.getUsers(); 
	
	}
}
