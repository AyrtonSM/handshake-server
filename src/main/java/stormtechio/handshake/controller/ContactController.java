package stormtechio.handshake.controller;

import java.util.ArrayList;

import org.json.JSONObject;

import stormtechio.handshake.model.Contact;
import stormtechio.handshake.service.ContactService;

public class ContactController {
	
	private ContactService contactService;
	public ContactController() {
		this.contactService = new ContactService();
	}
	
    public ArrayList<Contact> getFriends() {
    
    	return this.contactService.getFriends();
    	
    }
    
    public boolean invite(String body) {
  
    	return this.contactService.invite(body);
    	
    }
    
    public boolean invitationAnswer(String body) {
    	
    	JSONObject answer = new JSONObject(body);
    	boolean result = this.contactService.invitationAnswer(answer);
 
    	if(result) return answer.getBoolean("answer");
    	else return false;
    	
    }
    

	public boolean setFavoriteContact(String body) {
		return this.contactService.setFavoriteContact(body);
	}
}
