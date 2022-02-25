<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
        <h1>Sign In</h1>
		<form method="POST" action="ValidateUser">
			
				<label for="username">Username</label> <input type="text"
					 id="user" name="user" placeholder="Enter Username"
					required /><br>
			
				<label for="password">Password</label> <input type="password"
					 id="pass" name="pass"
					placeholder="Enter Password" /><br>
					
		<button type="submit">Login</button><br><br>
		Have you created an account? <a href="register.jsp">Register</a>	
		</form>
	</div>
</body>
</html>