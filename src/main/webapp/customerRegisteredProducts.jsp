<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<% String table = (String) request.getAttribute("table"); %>

<body>

 

 

 <div>
<h1>Products Registered by users</h1>

  <%=table %><br><br>
  
 
  

 </div>

</body>
</html>