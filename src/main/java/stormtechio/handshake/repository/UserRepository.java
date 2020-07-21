package stormtechio.handshake.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import stormtechio.handshake.database.DBConnection;
import stormtechio.handshake.model.User;

public class UserRepository {

	public boolean addUser(User user) {
		
		
		String sql = "INSERT INTO user (first_name, last_name, email, phone, username) VALUES (?,?,?,?,?)";
		Connection connection = DBConnection.getConnection();
				
		try {
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(0, user.getFirstName());
			statement.setString(1, user.getLastName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPhone());
			statement.setString(4, user.getUsername());
			
			
			return statement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
