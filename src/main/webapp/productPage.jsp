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
			
				<label for="cid">Claim ID</label> <input type="text"
					 id="cid" name="cid" placeholder="Enter Claim ID"
					required />
					
				<label for="date">Date of Claim</label> <input type="date"
					 id="date" name="date"
					placeholder="Enter date of claim"  />
			
				<label for="desc">Description</label> <input type="text"
					 id="desc" name="desc"
					placeholder="Enter Description" />
			
				<label for="issue">Issue </label> <input type="text"
					 id="issue" name="issue"
					placeholder="Enter Issue" />
				
				
				<button type="submit">Claim</button>
			
		</form>
	</div>
</body>
</html>