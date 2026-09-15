<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${title}, ${name}</h1>
	<h1><%= request.getAttribute("title") %>, <%= request.getAttribute("name") %></h1>
	<div>Server time: ${time}</div>
	<a href="Harry33.html">Home</a>
</body>
</html>