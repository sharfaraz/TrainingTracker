<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Trainings</title>

<link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/datepicker.css">
<link rel="stylesheet" type="text/css" href="css/baselayout.css" >


</head>
<body>

<s:form method="POST" action="saveAssignedApplications">
<table><thead>
	<tr><th><h3>Select the employee and Application</h3></th></tr></thead>
	<tr>
	<td width="20%"><s:checkboxlist label="Employee Id" name="employee" list="employees" /></td></tr>
	<tr><td><s:checkboxlist label="Applications" name="selApplications" list="availableApplications" /></td></tr>
	<tr><td><s:submit value="submit"></s:submit></td></tr> 
</table>
</s:form>
</body>
</html>