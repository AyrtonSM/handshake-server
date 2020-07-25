package stormtechio.handshake.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import stormtechio.handshake.database.DBConnection;
import stormtechio.handshake.model.User;
import stormtechio.handshake.model.query.Query;
import stormtechio.handshake.utils.QueryUtils;

public class UserRepository {

	private static final String USER_TABLE = "user";
	private static final String USER_ID = "id";
	private static final String USER_FISTNAME = "first_name";
	private static final String USER_LASTNAME = "last_name";
	private static final String USER_EMAIL = "email";
	private static final String USER_USERNAME = "username";
	private static final String USER_PHONE = "phone";
	
	public boolean addUser(User user) {
				
		LinkedList<String> columns = new LinkedList<>();
		columns.add(USER_FISTNAME);
		columns.add(USER_LASTNAME);
		columns.add(USER_EMAIL);
		columns.add(USER_USERNAME);
		columns.add(USER_PHONE);
		
		Query query = new Query();
		query.setTableName(USER_TABLE);		
		query.setColumns(columns);
		
		
		String sql = "";
		try {
			sql = QueryUtils.queryInsertBuilder(query);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
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
				
				user.setId(rs.getInt(USER_ID));
				user.setFirstName(rs.getString(USER_FISTNAME));
				user.setLastName(rs.getString(USER_LASTNAME));
				user.setUsername(rs.getString(USER_USERNAME));
				user.setEmail(rs.getString(USER_EMAIL));
				user.setPhone(rs.getString(USER_PHONE));
				
				users.add(user);
				
			}
			
			return users;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public boolean deleleUserById(int id) {

		String sql = "DELETE FROM user WHERE id = ?";
		Connection connection = DBConnection.getConnection();
				
		try {
			
			PreparedStatement statement = connection.prepareStatement(sql);		
			statement.setInt(1, id);
			int rowCount = statement.executeUpdate();
			if(rowCount > 0) {
				return true;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}


	public User getUserById(int id) {
		
		String sql = "SELECT * FROM user WHERE id = ?";
		Connection connection = DBConnection.getConnection();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			
			User user;
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setUsername(rs.getString("username"));
				
			}
		
			
			
			
		}catch (SQLException e) {
			// TODO: handle exception
		}
		
		// TODO Auto-generated method stub
		return null;
	}
	
}
