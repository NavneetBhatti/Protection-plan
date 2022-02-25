package ProtectionPlan.dbhelper;
import java.util.Properties;
import java.util.logging.Level;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

import ProtectionPlan.model.claims;
import ProtectionPlan.model.protectionPlan;
import ProtectionPlan.model.users;



public class readQuery {

 private static Connection connection;

 private ResultSet results;


	public readQuery() {
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
	

 
 
//Login user
public String authenticateUser(users user)
{
    String username = user.getUsername(); //Assign user entered values to temporary variables.
    String password = user.getPassword();

    
    String userNameDB = "";
    String passwordDB = "";

    try
    {
    	 String query = "SELECT * FROM users WHERE username = ? and password = ?";

		 PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
	        ps.setString(1, username);
	        ps.setString(2, password);

	        ResultSet result = ps.executeQuery();

        while(result.next()) // Until next row is present otherwise it return false
        {
         userNameDB = result.getString("username"); //fetch the values present in database
         passwordDB = result.getString("password");

          if(username.equals(userNameDB) && password.equals(passwordDB))
          {
             return "SUCCESS"; ////If the user entered values are already present in the database, which means user has already registered so return a SUCCESS message.
          }
        }}
        catch(SQLException e)
        {
           e.printStackTrace();
        }
        return "Invalid user credentials"; // Return appropriate message in case of failure
    }


  
//list of products registered by the user - admin
public void customerRegisteredProducts(String username) {

	 try {

		 String query = "Select * from protectionplan where username=" + username + ";";

		 PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);

		 this.results = ps.executeQuery();

	 }catch(SQLException e) {

		 java.util.logging.Logger.getLogger(readQuery.class.getName()).log(Level.SEVERE, "Cannot Establish Connection");

	 } 

}

 

public String getHTMLTable2() throws SQLException {

	 String table = "";
	 
	

	 table += "<table border=1>";

	 while(this.results.next()) {

		 protectionPlan pp = new  protectionPlan();

		

		 pp.setUsername(this.results.getString("username"));

		 pp.setProductname(this.results.getString("productname"));

		 pp.setSerialnumber(this.results.getString("serialnumber"));

		 pp.setPurchasedate(this.results.getString("purchasedate"));
		 

		 table += "<tr>";

		  table += "<td>";

		    table += pp.getUsername();

		  table += "</td>";

		  table += "<td>";

	      table += pp.getProductname();
		  

	    table += "</td>";

	    table += "<td>";

   		table += pp.getSerialnumber();

   	table += "</td>";

   	table += "<td>";

    table += pp.getPurchasedate();

  		table += "</td>";
  		table += "<td>";

    	 table += "</tr>";  

	 }

	 table += "</table>";
	 
	 return table;

}



//get users List - admin
public void userList() {

	 try {

		 String query = "Select * from users";

		 PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);

		 this.results = ps.executeQuery();

	 }catch(SQLException e) {

		 java.util.logging.Logger.getLogger(readQuery.class.getName()).log(Level.SEVERE, "Cannot Establish Connection");

	 } 

}



public String getHTMLTable() throws SQLException {

	 String table = "";
	 
	

	 table += "<table border=1>";

	 while(this.results.next()) {

		 users user = new  users();

		// user.setFriendID(this.results.getInt("friendID"));

		 user.setUsername(this.results.getString("username"));

		 user.setPassword(this.results.getString("password"));

		 user.setCell(this.results.getString("cell"));

		 user.setEmail(this.results.getString("email"));
		 user.setName(this.results.getString("name"));
		 user.setAddress(this.results.getString("address"));

		 table += "<tr>";

		  table += "<td>";

		    table += user.getUsername();

		  table += "</td>";

		  table += "<td>";

	    	table += user.getPassword();

	    table += "</td>";

	    table += "<td>";

  		table += user.getCell();

  	table += "</td>";

  	table += "<td>";

 		  table += user.getEmail();

 		table += "</td>";
 		table += "<td>";

   table += user.getName();

     table += "</td>";	

 		table += "<td>";

		  	table += user.getAddress();

		  table += "</td>";
		  
		

		 table += "</tr>";  

	 }

	 table += "</table>";
	 
	 return table;

}
// view list of products - user and admin
public void productList() {

	 try {

		 String query = "Select * from products";

		 PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);

		 this.results = ps.executeQuery();

	 }catch(SQLException e) {

		 java.util.logging.Logger.getLogger(readQuery.class.getName()).log(Level.SEVERE, "Cannot Establish Connection");

	 } 

}



public String getHTMLTableProducts() throws SQLException {

	 String table = "";
	 
	

	 table += "<table border=1>";

	 while(this.results.next()) {

//		 users user = new  users();
//
//		// user.setFriendID(this.results.getInt("friendID"));
//
//		 user.setUsername(this.results.getString("username"));
//
//		 user.setPassword(this.results.getString("password"));
//
//		 user.setCell(this.results.getString("cell"));
//
//		 user.setEmail(this.results.getString("email"));
//		 user.setName(this.results.getString("name"));
//		 user.setAddress(this.results.getString("address"));
//
//		 table += "<tr>";
//
//		  table += "<td>";
//
//		    table += user.getUsername();
//
//		  table += "</td>";
//
//		  table += "<td>";
//
//	    	table += user.getPassword();
//
//	    table += "</td>";
//
//	    table += "<td>";
//
// 		table += user.getCell();
//
// 	table += "</td>";
//
// 	table += "<td>";
//
//		  table += user.getEmail();
//
//		table += "</td>";
//		table += "<td>";
//
//  table += user.getName();
//
//    table += "</td>";	
//
//		table += "<td>";
//
//		  	table += user.getAddress();
//
//		  table += "</td>";
//		  
//		
//
//		 table += "</tr>";  

	 }

	 table += "</table>";
	 
	 return table;

}




// view claims submitted by the user - user and admin 
public void readUserClaims(String username) {
try {
	String query = "Select * from claims where username =" + username + ";";
	
	PreparedStatement ps = connection.prepareStatement(query);
	this.results = ps.executeQuery();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}		
}

public String getUserClaimTable() throws SQLException {
String table = "";
 table += "<table border=1>"
 		+ "<tr>"
 		+ "<th>ID</th>"
 		+ "<th>Username</th>"
 		+ "<th>Protection ID</th>"
 		+ "<th>Claim Date</th>"
 		+ "<th>Description</th>"
 		+ "<th>Issue</th>"
 		+ "<th>Status</th>"
 		+ "</tr>";
 
 while(this.results.next()) {
	 claims claim = new claims();
	 claim.setId(this.results.getInt("id"));
	 claim.setUsername(this.results.getString("username"));
	 claim.setProtectionid(this.results.getInt("protectionid"));
	 claim.setClaimdate(this.results.getString("claimdate"));			 
	 //this.results.getDate("claimdate")
	 claim.setDescription(this.results.getString("description"));
	 claim.setIssue(this.results.getString("issue"));
	 claim.setStatus(this.results.getInt("status"));
	 
	 table += "<tr>";
	 table += "<td>";
	 table += claim.getId();
	 table += "</td>";
	 table += "<td>";
	 table += claim.getUsername();
	 table += "</td>";
	 table += "<td>";
	 table += claim.getProtectionid();
	 table += "</td>";
	 table += "<td>";
	 table += claim.getClaimdate();
	 table += "</td>";
	 table += "<td>";
	 table += claim.getDescription();
	 table += "</td>";		
	 table += "<td>";
	 table += claim.getIssue();
	 table += "</td>";
	 table += "<td>";
	 table += claim.getStatus();
	 table += "</td>";
	 table += "</tr>";
 }
 table += "</table>";
 return table;
}

public void userSpecificList(String username) {

	 try {

		 String query = "Select * from users where username =" + username + ";";

		 PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);

		 this.results = ps.executeQuery();

	 }catch(SQLException e) {

		 java.util.logging.Logger.getLogger(readQuery.class.getName()).log(Level.SEVERE, "Cannot Establish Connection");

	 } 

}



public String getHTMLTableForUser() throws SQLException {

	 String table = "";
	 
	

	 table += "<table border=1>";

	 while(this.results.next()) {

		 users user = new  users();

		// user.setFriendID(this.results.getInt("friendID"));

		 user.setUsername(this.results.getString("username"));

		 user.setPassword(this.results.getString("password"));

		 user.setCell(this.results.getString("cell"));

		 user.setEmail(this.results.getString("email"));
		 user.setName(this.results.getString("name"));
		 user.setAddress(this.results.getString("address"));

		 table += "<tr>";

		  table += "<td>";

		    table += user.getUsername();

		  table += "</td>";

		  table += "<td>";

	    	table += user.getPassword();

	    table += "</td>";

	    table += "<td>";

 		table += user.getCell();

 	table += "</td>";

 	table += "<td>";

		  table += user.getEmail();

		table += "</td>";
		table += "<td>";

  table += user.getName();

    table += "</td>";	

		table += "<td>";

		  	table += user.getAddress();

		  table += "</td>";
		  
		

		 table += "</tr>";  

	 }

	 table += "</table>";
	 
	 return table;

}


public void productSpecificList(String name) {

	 try {

		 String query = "Select * from products where name =" + name + ";";

		 PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);

		 this.results = ps.executeQuery();

	 }catch(SQLException e) {

		 java.util.logging.Logger.getLogger(readQuery.class.getName()).log(Level.SEVERE, "Cannot Establish Connection");

	 } 

}



public String getHTMLTableProduct() throws SQLException {

	 String table = "";
	 
	

	 table += "<table border=1>";

	 while(this.results.next()) {

//		 users user = new  users();
//
//		// user.setFriendID(this.results.getInt("friendID"));
//
//		 user.setUsername(this.results.getString("username"));
//
//		 user.setPassword(this.results.getString("password"));
//
//		 user.setCell(this.results.getString("cell"));
//
//		 user.setEmail(this.results.getString("email"));
//		 user.setName(this.results.getString("name"));
//		 user.setAddress(this.results.getString("address"));
//
//		 table += "<tr>";
//
//		  table += "<td>";
//
//		    table += user.getUsername();
//
//		  table += "</td>";
//
//		  table += "<td>";
//
//	    	table += user.getPassword();
//
//	    table += "</td>";
//
//	    table += "<td>";
//
//		table += user.getCell();
//
//	table += "</td>";
//
//	table += "<td>";
//
//		  table += user.getEmail();
//
//		table += "</td>";
//		table += "<td>";
//
// table += user.getName();
//
//   table += "</td>";	
//
//		table += "<td>";
//
//		  	table += user.getAddress();
//
//		  table += "</td>";
//		  
//		
//
//		 table += "</tr>";  

	 }

	 table += "</table>";
	 
	 return table;

}


// admin can see list of recent claims
public void readRecentClaims() {
try {
	String query = "Select * from claims"
			+ "order by id desc "
			+ "limit 10;";
	// will get the top ten results by most recent id
	
	PreparedStatement ps = connection.prepareStatement(query);
	this.results = ps.executeQuery();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}		
}

public String getRecentClaimTable() throws SQLException {
String table = "";
 table += "<table border=1>"
 		+ "<tr>"
 		+ "<th>ID</th>"
 		+ "<th>Username</th>"
 		+ "<th>Protection ID</th>"
 		+ "<th>Claim Date</th>"
 		+ "<th>Description</th>"
 		+ "<th>Issue</th>"
 		+ "<th>Status</th>"
 		+ "</tr>";
 
 while(this.results.next()) {
	 claims claim = new claims();
	 claim.setId(this.results.getInt("id"));
	 claim.setUsername(this.results.getString("username"));
	 claim.setProtectionid(this.results.getInt("protectionid"));
	 claim.setClaimdate(this.results.getString("claimdate"));			 
	 //this.results.getDate("claimdate")
	 claim.setDescription(this.results.getString("description"));
	 claim.setIssue(this.results.getString("issue"));
	 claim.setStatus(this.results.getInt("status"));
	 
	 table += "<tr>";
	 table += "<td>";
	 table += claim.getId();
	 table += "</td>";
	 table += "<td>";
	 table += claim.getUsername();
	 table += "</td>";
	 table += "<td>";
	 table += claim.getProtectionid();
	 table += "</td>";
	 table += "<td>";
	 table += claim.getClaimdate();
	 table += "</td>";
	 table += "<td>";
	 table += claim.getDescription();
	 table += "</td>";		
	 table += "<td>";
	 table += claim.getIssue();
	 table += "</td>";
	 table += "<td>";
	 table += claim.getStatus();
	 table += "</td>";
	 table += "</tr>";
 }
 table += "</table>";
 return table;
}


//The list of all users, their registered products and
//their claims
public void joinUserRegProdandClaims(String username) {

	 try {

		 String query = "Select users.username, users.name, "
		 		+ "protectionplan.productname, protectionplan.purchasedate"
		 		+ "claims.claimdate, claims.description, claims.status from users"
		 		+ "join protectionplan on users.username = protectionplan.username"
		 		+ "join claims on users.username = claims.username;";

		 PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);

		 this.results = ps.executeQuery();

	 }catch(SQLException e) {

		 java.util.logging.Logger.getLogger(readQuery.class.getName()).log(Level.SEVERE, "Cannot Establish Connection");

	 } 

}



public String getHTMLTableForJoin() throws SQLException {

	 String table = "";
	 
	

	 table += "<table border=1>";

	 while(this.results.next()) {

//		 users user = new  users();
//
//		// user.setFriendID(this.results.getInt("friendID"));
//
//		 user.setUsername(this.results.getString("username"));
//
//		 user.setPassword(this.results.getString("password"));
//
//		 user.setCell(this.results.getString("cell"));
//
//		 user.setEmail(this.results.getString("email"));
//		 user.setName(this.results.getString("name"));
//		 user.setAddress(this.results.getString("address"));
//
//		 table += "<tr>";
//
//		  table += "<td>";
//
//		    table += user.getUsername();
//
//		  table += "</td>";
//
//		  table += "<td>";
//
//	    	table += user.getPassword();
//
//	    table += "</td>";
//
//	    table += "<td>";
//
//		table += user.getCell();
//
//	table += "</td>";
//
//	table += "<td>";
//
//		  table += user.getEmail();
//
//		table += "</td>";
//		table += "<td>";
//
// table += user.getName();
//
//   table += "</td>";	
//
//		table += "<td>";
//
//		  	table += user.getAddress();
//
//		  table += "</td>";
//		  
//		
//
//		 table += "</tr>";  

	 }

	 table += "</table>";
	 
	 return table;

}




}








