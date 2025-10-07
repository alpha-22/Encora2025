<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop - Welcome</title>
</head>
<body>
    <h1>Welcome</h1>
    <br/>

   
<form:form action="/user/logout" method="POST" modelAttribute="userObj">
	
	<input type="submit" value="Logout">
	
</form:form>

<form:form action="/user/shop" method="POST" modelAttribute="userObj">
	
	<input type="submit" value="Shop">
	
</form:form>
    
  
    
  
</body>
</html>
