<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.BufferedReader"%>
<%@ page 
	language="java"
	contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"
    import="org.json.JSONObject"
%>
<% 
	
	BufferedReader reader = request.getReader();
	String line;
	StringBuffer sb = new StringBuffer();
	while ((line = reader.readLine()) != null) {
		System.out.println(line);
		sb.append(line);
	}
	JSONObject obj = new JSONObject(sb.toString());
	
	/*
	InputStream in = request.getInputStream();
	byte[] all = in.readAllBytes();
	String strObj = new String(all, StandardCharsets.UTF_8);
	System.out.println(strObj);
	JSONObject obj = new JSONObject(strObj);
	*/
	String operator = obj.getString("operator");
	String x = obj.getJSONObject("params").getString("x");
	String y = obj.getJSONObject("params").getString("y");
	
	int xx = Integer.parseInt(x);
	int yy = Integer.parseInt(y);
	// out.print(result);
	
	/*
	{
		result: 13
	}
	*/
	
	StringBuffer result = new StringBuffer();
	
	switch (operator) {
	case "+": 
		result.append(xx + yy);
		break;

	case "-": 
		result.append(xx - yy);
		break;
	
	case "x": 
		result.append(xx * yy);
		break;
	
	default:
		result.append(xx / yy)
			.append("...")
			.append(xx % yy);
	}

	JSONObject object = new JSONObject();
	object.put("result", result.toString());
	out.print(object);
%>