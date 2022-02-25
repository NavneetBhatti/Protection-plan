package ProtectionPlan.dbhelper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;

import ProtectionPlan.model.protectionPlan;
import ProtectionPlan.model.users;

//import com.mysql.jdbc.PreparedStatement;
import java.sql.*;  

//import ProtectionPlan.model. M_88_Friends;

public class writeQuery {
	
	
	private Connection connection;

	public writeQuery() {
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
	
	
	
	// register user 
	public int insertUser(users user) {
		try {
			String query = "INSERT INTO users "
					+ "(username, password, cell, email, name, address, role)"
					+ " VALUES(?,?,?,?,?,?,?);";
					// can remove role if we want to hard set it then update for user

			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);			
					ps.setString(1, user.getUsername());
					ps.setString(2, user.getPassword());
					ps.setString(3, user.getCell());
					ps.setString(4, user.getEmail());
					ps.setString(5, user.getName());
	                ps.setString(6, user.getAddress());
	                ps.setString(7,"User"); 
					
					ps.executeUpdate();
					ps.close();


			//doRead();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}	
		return 1;

	}
	
	// insert product to protection plan for user
	public int insertProductToPlan(protectionPlan pp) {
		try {
			String query = "INSERT INTO protectionplan "
					+ "(username, productname, serialnumber, purchasedate)"
					+ "VALUES (?,?,?,?);";
			System.out.println("-----inserted1---");
	
				//	int PID = Integer.parseInt(pp.getProductid());
			
					PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);			
					ps.setString(1, pp.getUsername()); 
					ps.setString(2, pp.getProductname());
					ps.setString(3, pp.getSerialnumber());
					ps.setString(4, pp.getPurchasedate()); // do date logic here or in view 
					//ps.setInt(6, pp.getProductid());
				//	ps.setString(5, pp.getProductid());
					System.out.println("-----inserted2---");

					ps.executeUpdate();
					ps.close();
					System.out.println("-----insert3---");

					
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}	
		return 1;
		
	}

	// insert claims for user
	public void insertClaim(String uname, String pid, String cdate, String desc, String issue) {
		try {
			String query = "INSERT INTO claims"
					+ "(username, protectionid, claimdate, description, issue, status)"
					+ "VALUES (?,?,?,?,?,?)";
			
					int PID = Integer.parseInt(pid);
					
					PreparedStatement ps = connection.prepareStatement(query);
					ps.setString(2, uname); 
					ps.setInt(3, PID);
					ps.setString(4, cdate); // setDate(); do date logic in view
					ps.setString(5, desc);
					ps.setString(6, issue);
					ps.setInt(7, 0); // 0 ill be not fixed, update to be fixed by admin
					ps.executeUpdate();

					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	
	public void insertProduct(String name, String price, String quantity, String serialnumber) {
		try {
			String query = "INSERT INTO products"
					+ "(name, price, quantity, serialnumber)"
					+ "VALUES (?,?,?,?,?,?)";
			
					int quant = Integer.parseInt(quantity);
					int sNum = Integer.parseInt(serialnumber);
					double Price = Double.parseDouble(price);
					
					PreparedStatement ps = connection.prepareStatement(query);
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




	


}

