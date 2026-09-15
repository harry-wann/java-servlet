<%@ page import="tw.harry.api.Bike"%>
<%@ page import="java.util.TreeSet"%>
<%@ page 
	language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
    
<% 
	String name = request.getParameter("name");
	if (name == null) {
		name = "world";
	}
	
	TreeSet<Integer> lottery = new TreeSet<Integer>();
	while (lottery.size() < 6) lottery.add((int) (Math.random()*49+1));
	
	Bike b1 = new Bike();
	b1.upSpeed().upSpeed().upSpeed().upSpeed();
%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Big Harry Company</title>
	</head>
	<body>
		<div>Hello <% out.print(name); %></div>
		<div>Hello <%= name %></div>
		<div>Lottery: <%= lottery %></div>
		<%
			for (Integer v : lottery) {
				out.print(v + " ");
			}
		%>
		<div>Bike: <%= b1 %></div>
	</body>
</html>