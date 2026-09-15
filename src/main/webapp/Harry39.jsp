<%@page import="tw.harry.api.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="tw.harry.api.HarryUtil" %>
<%
	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Big Harry Company</title>
	</head>
	<body>
		Name: ${name} <br />
		Name(page): ${pageScope.name} <br />
		Name(request): ${requestScope.name} <br />
		Name(session): ${sessionScope.name} <br />
		Name(application): ${applicationScope.name} <br />
	</body>
</html>