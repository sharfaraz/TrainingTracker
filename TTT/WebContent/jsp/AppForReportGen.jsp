<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<s:set name="theme" value="'simple'"  scope="page" /> 
<table><tr><td>Application : </td><td>&nbsp;&nbsp;&nbsp;<s:select id="appId" name="appId" headerKey="-1" headerValue="----Select----" list="newAppData" onchange ="getApplicationForApp()"/></td></tr></table>


 
</body>
</html>