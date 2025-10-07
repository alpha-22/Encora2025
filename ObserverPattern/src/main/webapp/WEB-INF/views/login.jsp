<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h1>welcomee</h1>
<form:form action="/form1/register" method="Post" modelAttribute="userObj">

	Username:<form:input path="username"/>
	<form:errors path="username"></form:errors><br>
	PassWord:<form:password path="userpass"/><br>
	<input type="submit" value="click">
	
</form:form>