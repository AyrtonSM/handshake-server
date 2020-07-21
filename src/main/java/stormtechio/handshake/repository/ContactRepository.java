package stormtechio.handshake.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONObject;

import stormtechio.handshake.database.DBConnection;
import stormtechio.handshake.model.Contact;

public class ContactRepository {

	public boolean invite(String body) {
	
		JSONObject postBody =  new JSONObject(body);
		String fromAddress = postBody.getString("fromAddress");
		String toAddress = postBody.getString("toAddress");
		
		String sql = "INSERT INTO invitation (,) VALUES (?,?)";
		Connection connection = DBConnection.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(0, fromAddress);
			statement.setString(1, toAddress);
			
			return statement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
