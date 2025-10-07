<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>

<h1> User Login </h1>

<form:form action="/user/" method="POST" modelAttribute="userObj">
	UserName:<form:input path="name"/>	
	PassWord:<form:input path="pass"/><br>
	
	<input type="submit" value="click...">
	
</form:form>

</body>
</html>