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
		<form method="POST">
			
				<label for="pid">Product ID</label> <input type="text"
					 id="pid" name="pid" placeholder="Enter Product ID"
					required />
					
				<label for="pname">Product Name</label> <input type="text"
					 id="pname" name="pname"
					placeholder="Enter Product Name"  />
			
				<label for="price">Price</label> <input type="text"
					 id="price" name="price"
					placeholder="Enter Price" />
			
				<label for="quantity">Quantity </label> <input type="text"
					 id="quantity" name="quantity"
					placeholder="Enter Quantity" />
			
				<label for="sno">Serial Number</label> <input type="text"
					 id="email" name="email"
					placeholder="Enter Email"  />
				
				
				<button type="submit">Add</button>
			
		</form>
	</div>
</body>
</html>