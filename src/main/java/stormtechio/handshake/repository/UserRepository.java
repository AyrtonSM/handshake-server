package stormtechio.handshake.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import stormtechio.handshake.database.DBConnection;
import stormtechio.handshake.model.User;

public class UserRepository {

	public boolean addUser(User user) {
		
		String sql = "INSERT INTO user (first_name, last_name, email, phone, username) VALUES (?,?,?,?,?)";
		Connection connection = DBConnection.getConnection();
				
		try {
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getPhone());
			statement.setString(5, user.getUsername());
			
			statement.execute();
			return (statement.getUpdateCount() > 0);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	
	public ArrayList<User> getUsers() {

		String sql = "SELECT * FROM user";
		Connection connection = DBConnection.getConnection();
				
		try {
			
			PreparedStatement statement = connection.prepareStatement(sql);		
			ResultSet rs = statement.executeQuery();
			
			ArrayList<User> users = new ArrayList<User>();
			User user;
			while(rs.next()) {
				
				user = new User();
				
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				
				users.add(user);
				
			}
			
			return users;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
