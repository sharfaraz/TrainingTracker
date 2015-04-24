<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trainings List</title>
</head>
<body>
<form method="GET" action="viewTrainings" enctype="multipart/form-data">
	<h3>Trainings List</h3>
	
	<br>
	<table>
		<tr>
			<td><b>Training Name</b></td>
			<td><b>Start Date</b></td>
			<td><b>End Date</b></td>
			<td><b>Status</b></td>
		</tr>
		<s:iterator value="trainings">
		<tr>
			<td><s:property value="trainingName" /></td>
			<td><s:property value="startDate" /></td>
			<td><s:property value="endDate" /></td>
			<td><s:property value="status" /></td>
		</tr>
		</s:iterator>
	</table>
</form>

</body>
</html>