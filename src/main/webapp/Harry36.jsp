<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="tw.harry.api.HarryUtil" %>
<%
	request.getLocale();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Method: ${pageContext.request.method} <br/>
		Locale: ${pageContext.request.locale} <br/>
		Display: ${pageContext.request.locale.displayCountry} <br/>
		Country: ${pageContext.request.locale.displayCountry} <br/>
	</body>
</html>