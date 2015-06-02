<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.util.Map"%>
<%@page import="org.apache.struts2.dispatcher.SessionMap"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Apps</title>
</head>
<body>

<table id="appsTable" width="400px" align="center">
		<tr>
			<th><b>Applications</b></th>
		</tr>
		<s:iterator value="apps" status="status">
		<tr><td align="left"> <input type="checkbox" checked="checked" width=""><s:property value="apps[#status.index]" /></td></tr>
		</s:iterator>
</table>
</body>
</html>