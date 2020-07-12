package stormtechio.handshake.service;

import java.util.ArrayList;

import org.json.JSONObject;

import stormtechio.handshake.model.Contact;
import stormtechio.handshake.repository.ContactRepository;

public class ContactService {
	
	private ContactRepository contactRepository;
	public ContactService() {
		this.contactRepository = new ContactRepository();
	}
	
	public boolean invite(String body) {
		// TODO Auto-generated method stub
		return this.contactRepository.invite(body);
		
	}

	public boolean invitationAnswer(JSONObject answer) {
		// TODO Auto-generated method stub
		return this.contactRepository.invitationAnswer(answer);
		
	}

	public ArrayList<Contact> getFriends() {
		// TODO Auto-generated method stub
		return this.contactRepository.getFriends();
		
	}
	

	public boolean setFavoriteContact(String userIdentification) {
		return this.contactRepository.setFavoriteContact(userIdentification);
		
	}

}
