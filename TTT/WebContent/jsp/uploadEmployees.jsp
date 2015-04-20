<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Training Tracker - Employee Upload</title>
</head>
<body>
<h3 align="center">Upload Employees</h3>

<form method="POST" action="employeeUpload" enctype="multipart/form-data">
	
	
	<br>
	<input style="margin-left: 42%" type="file" name="uploadFile" class="changeFont"/>
	<br /><br />
	<input style="margin-left: 42%"  type="submit" value="Upload" class="buttonStyle"/>
	<input type="reset" value="Reset" class="buttonStyle"/> 
</form>

</body>
</html>
