package stormtechio.handshake.repository;

import java.util.ArrayList;

import org.json.JSONObject;

import stormtechio.handshake.model.Contact;

public class ContactRepository {

	public boolean invite(String body) {
		// TODO Auto-generated method stub
		JSONObject postBody =  new JSONObject(body);
		String fromAddress = postBody.getString("fromAddress");
		String toAddress = postBody.getString("toAddress");
		
		// INSERT INTO INVITATIONS TABLE
		
		return false;
	}

	public boolean invitationAnswer(JSONObject answer) {
		// TODO Auto-generated method stub
		
		// UPDATE INVITATIONS TABLE
		return answer.has("answer");
	}

	public ArrayList<Contact> getFriends() {
		// TODO Auto-generated method stub
		
		ArrayList<Contact> contacts = new ArrayList<Contact>();
    	
    	Contact contact = new Contact();
    	contact.setTitle("Ayrton");
    	
    	contacts.add(contact);    	
    	
    	return contacts;
		
	}
	
	public boolean setFavoriteContact(String body) {
		
		JSONObject postBody = new JSONObject(body);
		String user = postBody.getString("userIdentification");
		String favoriteContact = postBody.getString("userIdentification");
		boolean isFavorite = postBody.getBoolean("isFavorite");
		
		
		
		return true;
	}

}
