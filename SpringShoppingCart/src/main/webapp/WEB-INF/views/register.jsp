<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form"%>
 <form:form action="/form2/register" method="POST" modelAttribute="userRegister">
<body>
    <h1>Register User</h1>
    Username : <form:input path="username" /><br>
    Password:<form:input path="userpass" type="password"/><br>
    <input type="submit" value="Register">
 </form:form>