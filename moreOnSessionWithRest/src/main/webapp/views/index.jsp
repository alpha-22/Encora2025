<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ERROR</title>
</head>
<body>

<h1> Your session has been exipred! </h1>

<form:form action="/" method="GET" modelAttribute="userObj">
	
	<input type="submit" value="login Again">
	
</form:form>

</body>
</html>