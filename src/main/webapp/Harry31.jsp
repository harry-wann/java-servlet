<%@ page 
	language="java"
	contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"
    import="org.json.JSONObject"
%>
<% 
	String x = request.getParameter("x");
	String y = request.getParameter("y");
	String operator = request.getParameter("operator");
	
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