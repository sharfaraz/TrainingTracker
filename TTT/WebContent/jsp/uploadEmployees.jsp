<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Training Tracker - Employee Upload</title>
</head>
<body>

<form method="POST" action="employeeUpload" enctype="multipart/form-data">
	<h3>Upload Employees</h3>
	
	<br>
	<input type="file" name="uploadFile"/>
	<br /><br />
	<input type="submit" value="Upload"/>
	<input type="reset" value="Reset"/> 
</form>

</body>
</html>
