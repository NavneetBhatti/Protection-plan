package ProtectionPlan.dbhelper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class updateQuery {

	private Connection connection;
	
	public updateQuery() {
		try {
			InputStream inputStream = getClass().getResourceAsStream("properties.txt");
			Properties prop = new Properties();
			try {
				prop.load(inputStream);
			}catch(IOException Notcatching) {}
			try {
				inputStream.close();
			}catch(IOException noop) {}
			
			String username = prop.getProperty("username2");
			String driver = prop.getProperty("driver2");
			String server = prop.getProperty("server2");
			String pass = prop.getProperty("password2");
			
			Class.forName(driver);
			connection = DriverManager.getConnection(server, username, pass);
			

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public void updateProduct(String id, String name, String price, String quantity, String serialnumber) {
		try {
			String query = "UPDATE products SET name = ?, price = ?, "
					+ "quantity = ?, serialnumber = ?"
					+ "WHERE id =" + id +";";
			
					int quant = Integer.parseInt(quantity);
					int sNum = Integer.parseInt(serialnumber);
					double Price = Double.parseDouble(price);
					
					PreparedStatement ps = connection.prepareStatement(query);
					//ps.setInt(1,);
					ps.setString(2, name); 
					ps.setDouble(3, Price);
					ps.setInt(4, quant); // setDate(); do date logic in view
					ps.setInt(5, sNum);					
					ps.executeUpdate();

					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	public void updateClaim(String id, String status) {
		try {
			String query = "UPDATE claims SET status = ?"
					+ "WHERE id =" + id +";";
			
					int stat = Integer.parseInt(status);
					
					
					PreparedStatement ps = connection.prepareStatement(query);
					//ps.setInt(1,);
					// setDate(); do date logic in view
					ps.setInt(1, stat);		// not sure if i use the column number or 1 here			
					ps.executeUpdate();

					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
}
