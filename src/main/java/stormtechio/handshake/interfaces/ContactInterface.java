package stormtechio.handshake.interfaces;

import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import stormtechio.handshake.controller.ContactController;
import stormtechio.handshake.model.Contact;
import stormtechio.handshake.service.ContactService;

@RestController
public interface ContactInterface {
	
	@GetMapping("/friends")
    default ArrayList<Contact> friends() {
    	
    	ContactController contactController = new ContactController();
    	return contactController.getFriends();
    
    }
	
	@PostMapping("/invitation")
    default boolean invite(@RequestBody String body) {
    	
    	ContactService contactService = new ContactService();
    	return contactService.invite(body);
    	
    }
    
    @PostMapping("/invitation/answer")
    default boolean invitationAnswer(@RequestBody String body) {
    	
    	JSONObject answer = new JSONObject(body);
    	ContactService contactService = new ContactService();
    	boolean result = contactService.invitationAnswer(answer);
    	
    	if(result) return answer.getBoolean("answer");
    	else return false;
    	
    }
    
    @PostMapping("/contact/favorite")
    default boolean setFavoriteContact(@RequestBody String body) {
    	ContactController contactController = new ContactController();
    	return contactController.setFavoriteContact(body);
    }
    
    
}
