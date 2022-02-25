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
	    <h1>Customer</h1>
	    <h2>Product Registeration</h2>
		<form method="POST" action="RegisterProductCustomer">
			
				<label for="username">Username</label> <input type="text"
					 id="user" name="user" placeholder="Enter Username"
					required /><br>
			
				<label for="productName">Product Name</label> <input type="text"
					 id="productName" name="productName"
					placeholder="Enter ProductName" /><br>
			
				<label for="serialNumber">Serial Number </label> <input type="text"
					 id="serialNumber" name="serialNumber"
					placeholder="Enter Serial Number" /><br>
			
				<label for="purchaseDate">Purchase Date</label> <input type="date"
					 id="purchaseDate" name="purchaseDate"
					placeholder="Enter Purchase Date"  /><br>
				
				<label for="productID">Product ID</label> <input type="text"
					 id="productID" name="productID"
					placeholder="Enter Product ID"  /><br>
				
				
				<button type="submit">Register Product</button>
			
		</form>
	</div>
</body>
</html>