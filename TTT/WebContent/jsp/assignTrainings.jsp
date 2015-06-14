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

<s:form method="POST" action="saveAssignedTrainings">
<table><thead>
	<tr><th><h3>Assign Trainings for Employees</h3></th></tr></thead>
	<tr>
	<td><s:select label="Account" name="account" list="{'at&t', 'airtel', 'vodafone'}"/>
	<s:select label="Tower" name="tower" list="{'A', 'E', 'F', 'G'}"/> 
	<s:select label="Cluster" name="cluster" list="{'ICS', 'RUSS', 'PLUSS', 'SAART'}"/> 
	<s:select label="Application" name="app" list="{'INSP', 'IPRS', 'PLUSS', 'SAART'}"/>
		<s:inputtransferselect
     label="Available Trainings"
     name="trainingsList"
     list="{'INSP', 'IPRS', 'ITAMAC', 'PTS', 'RUSS', 'PLUSS'}"/></td></tr>
	 <tr><td><input type="submit" class="buttonStyle"/></td></tr>
</table>
</s:form>
</body>
</html>