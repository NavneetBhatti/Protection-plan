package ProtectionPlan.dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {
private static Connection conn;
	
	public static Connection getConnection() throws Exception {
		if(conn == null || conn.isClosed()) {
			Class.forName("com.mysql.jdbc.Driver");  
			conn = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/j2ee-project?"
					+ "autoReconnect=true&useSSL=false", "root", "@Bhatti123");
			//TODO add in your own db if u changed it and username password 
		}
		return conn;
	}
	
}

