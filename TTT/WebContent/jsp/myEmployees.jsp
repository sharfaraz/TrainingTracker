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
<link href="${pageContext.request.contextPath}/css/buttons.css"	rel="stylesheet" type="text/css" />
<script type="text/javascript" src="javascript/trainings.js"></script>
<title>My Apps</title>
</head>
<body>

<table id="employeesTable" width="70%" align="center">
	<thead>
		<tr>
			<th width="30%" align="left"><b>Employee Name</b></th>
			<th width="20%" align="left"><b>Employee ID</b></th>
			<th width="30%" align="left"><b>Role</b></th>
			<th width="10%" align="left"><b>ATTUID</b></th>
		</tr>
	</thead>
		<s:iterator value="emps" status="status">
			<tr>
				<td align="left"> <s:property value="fname" /> <s:property value="lname" /></td>
				<td align="left"><s:property value="empId" /> </td>
				<td align="left"><s:property value="jobTitle" /> </td>
				<td align="left"><s:property value="attuid" /> </td>
				
			</tr>
			<tr></tr>
		</s:iterator>
</table>
</body>
</html>