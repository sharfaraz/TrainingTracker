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
<script type="text/javascript" src="javascript/trainings.js"></script>

</head>
<body>

<s:form method="POST" action="saveAssignedTrainings">
<table><thead>
	<tr><th><h3>Select the employees and Trainings to be associated</h3></th></tr></thead>
	<tr>
	<td width="20%"><s:checkboxlist label="Employee Id" name="employee" list="employees" /></td></tr>
	<tr><td><s:checkboxlist label="Trainings" name="selTrainings" list="availableTrainings" /></td></tr>
	<tr><td><s:submit value="submit"></s:submit></td></tr> 
</table>
</s:form>
</body>
</html>