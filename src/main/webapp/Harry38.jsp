<%@page import="tw.harry.api.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="tw.harry.api.HarryUtil" %>
<%
	String name1 = "Harry page";
	pageContext.setAttribute("name", name1);
	
	String name2 = "Harr request";
	request.setAttribute("name", name2);
	
	String name3 = "Harry session";
	session.setAttribute("name", name3);
	
	String name4 = "Harry application";
	application.setAttribute("name", name4);
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
		
		<%
			session.invalidate();
		%>
		
	</body>
</html>