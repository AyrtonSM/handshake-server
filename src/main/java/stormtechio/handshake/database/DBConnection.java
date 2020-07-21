package stormtechio.handshake.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection connection = null;
	
	public static Connection getConnection() {
		
		if(connection == null) {	
			String url = "jdbc:mysql://localhost/handshake";
			String user = "root";
			String password = "";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url, user, password);
				
			} catch(SQLException e){
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		return connection;
	}
	
}
