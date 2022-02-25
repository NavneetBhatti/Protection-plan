<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<div class="container">
	   <h1>Register</h1>
		<form method="POST" action="RegisterUser">
			
				<label for="username">Username</label> <input type="text"
					 id="user" name="user" placeholder="Enter Username"
					required /><br>
			
				<label for="password">Password</label> <input type="password"
					 id="pass" name="pass"
					placeholder="Enter Password" /><br>
			
				<label for="cell">Cell Number </label> <input type="text"
					 id="cell" name="cell"
					placeholder="Enter Cell Number" /><br>
			
				<label for="email">Email</label> <input type="text"
					 id="email" name="email"
					placeholder="Enter Email"  /><br>
				
				<label for="name">Name</label> <input type="text"
					 id="name" name="name"
					placeholder="Enter Name"  /><br>
				
				<label for="address">Address</label> <textarea name="address" 
				id= "address" placeholder="Enter Address"> </textarea><br><br>
				
				<!-- <label for="role">Role</label>
				<select name="role" id="role">
  					<option value="admin">Admin</option>
  					<option value="user">User</option>
 				</select> -->
				<button type="submit">Register</button>
			
		</form>
	</div>
</body>
</html>