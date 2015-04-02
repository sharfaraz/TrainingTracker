<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trainings Upload</title>
</head>
<body>
<form method="POST" action="TrainingsUpload" enctype="multipart/form-data">
	<h3>Upload Training Details List</h3>	<br>
	
	<input type="file" name="uploadFile"/>
	<br /><br />
	<input type="submit" value="Upload"/>
	<input type="reset" value="Reset"/> 
</form>
</body>
</html>