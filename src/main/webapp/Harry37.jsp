<%@page import="tw.harry.api.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="tw.harry.api.HarryUtil" %>
<%
	Student s1 = new Student("Harry");
	s1.getBike().upSpeed().upSpeed().upSpeed().upSpeed();
	pageContext.setAttribute("student", s1);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Big Harry Company</title>
	</head>
	<body>
		${student.name}<br />
		${student.bike.speed}<br />
	</body>
</html>