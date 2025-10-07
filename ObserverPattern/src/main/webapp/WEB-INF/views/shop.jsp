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
    <h1>Shop</h1>
    <br/>

   
<form:form action="/form1/logout" method="POST" modelAttribute="userObj">
	
	<input type="submit" value="Logout">
	
</form:form>

<form:form action="/form1/welcome" method="POST" modelAttribute="userObj">
	
	<input type="submit" value="Welcome">
	
</form:form>
    
  
    
  
</body>
</html>
