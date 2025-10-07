<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome Page</title>
</head>
<body>
      Welcome to our website
    <form action="${pageContext.request.contextPath}/form1/logout" method="post">
    <button type="submit">Logout</button>
    </form>
    <form action="/form1/shop1" method="get">
    <button type="submit">Shop1</button>
	</form>
</body>
</html>