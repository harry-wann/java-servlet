<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page import="tw.harry.api.HarryUtil" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Big Harry Company</title>
	</head>
	<body>
		<c:set var="score" value="${ HarryUtil.createScore() }"></c:set>
	
		<div>Score: ${score}</div>
		<div>
			<c:if test="${score >= 60}">Pass</c:if>
			<c:if test="${score < 60}">Failed</c:if>
		</div>
		<hr>
		<c:choose>
			<c:when test="${score >= 90 }">A</c:when>
			<c:when test="${score >= 80 }">B</c:when>
			<c:when test="${score >= 70 }">C</c:when>
			<c:when test="${score >= 60 }">D</c:when>
			<c:otherwise>E</c:otherwise>
		</c:choose>
	</body>
</html>