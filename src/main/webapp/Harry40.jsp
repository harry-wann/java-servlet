<%@page import="tw.harry.api.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="tw.harry.api.HarryUtil" %>
<%
	int counter = 0;
	application.setAttribute("counter", counter);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Big Harry Company</title>
	</head>
	<body>
		counter = ${counter }
	</body>
</html>