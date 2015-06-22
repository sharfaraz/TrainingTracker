<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Trainings</title>

<link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/datepicker.css">
<link rel="stylesheet" type="text/css" href="css/baselayout.css" >
<link rel="stylesheet" type="text/css" href="css/buttons.css" >
<style>

label[for*=employee-]:after {
    content:"\A"; white-space:pre;
}
label[for*=selApplications-]:after {
    content:"\A"; white-space:pre;
}
</style>

</head>
<body>

<s:form method="POST" action="saveAssignedApplications">
<table width="70%">
<thead>
<tr><th width="50%"> Employees</th><th width="50%">Applications</th></tr>
</thead>
<tr><td height="50%">
<table>
	<tr>
	<s:checkboxlist  name="employee" list="employees" />
	</tr>
	
</table></td>

<td height="50%"><table>
<tr><td><s:checkboxlist name="selApplications" list="availableApplications"/>
</td></tr>
</table></td>
<tr><td align="center"><input type="submit" value="Assign Applications to selected employees" class="buttonStyle2"/></td></tr>
<tr></tr> 
</table>
</s:form>
</body>
</html>