<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Trainings</title>
</head>
<body>
<form method="POST" action="employeeUpload" enctype="multipart/form-data">
	<h3>Assign Trainings for Employees</h3>
	
	<br>
	<s:select label="Account" name="account" list="{'at&t', 'airtel', 'vodafone'}"/>
	<s:select label="Tower" name="tower" list="{'A', 'E', 'F', 'G'}"/> 
	<s:select label="Cluster" name="cluster" list="{'ICS', 'RUSS', 'PLUSS', 'SAART'}"/> 
	<s:select label="Application" name="app" list="{'INSP', 'IPRS', 'PLUSS', 'SAART'}"/>
	<br>
	<br>
	<div>
		<s:inputtransferselect
     label="Available Trainings"
     name="trainingsList"
     list="{'INSP', 'IPRS', 'ITAMAC', 'PTS', 'RUSS', 'PLUSS'}"
 />
    </div>
</form>

</body>
</html>