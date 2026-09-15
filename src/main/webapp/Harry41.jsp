<%@page import="tw.harry.api.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="tw.harry.api.HarryUtil" %>
<%
	Integer counter = (Integer) application.getAttribute("counter");
	counter++;
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