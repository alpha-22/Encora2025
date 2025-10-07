<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h1>welcomee</h1>
<form:form action="/form1/login" method="Post" modelAttribute="userObj">

	Username:<form:input path="username"/>
	<form:errors path="username"></form:errors><br>
	PassWord:<form:password path="userpass"/><br>
	<input type="submit" value="click">
	
</form:form>
<form action="${pageContext.request.contextPath}/form2/register" method="post">
        <button type="submit">Sign Up</button>
</form>