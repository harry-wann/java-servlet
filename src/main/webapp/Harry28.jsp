<%@ page 
	language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="Harry29.jsp"
%>

<%
	String name = request.getParameter("name");
	char c2 = name.charAt(1);
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Big Harry Company</title>
	</head>
	<body>
		<div>Hello world</div>
	</body>
</html>