package stormtechio.handshake.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection connection = null;
	
	public static Connection getConnection() {
		
		if(connection != null) {
			return connection;
		}
		
		String url = "jdbc:mysql://localhost/handshake?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String password = "";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
			
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			
		return connection;
			

	}
	
}
