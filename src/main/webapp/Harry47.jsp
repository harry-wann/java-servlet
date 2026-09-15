<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.sql" prefix="sql" %>
<%@ page import="tw.harry.api.HarryUtil" %>

<c:import var="data" url="https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelStay.aspx"></c:import>

<sql:setDataSource
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/harry"
	user="root"
	password="root"
/>

${data}
<c:set var="farms" value="${HarryUtil.parseFarms(data)}"></c:set>