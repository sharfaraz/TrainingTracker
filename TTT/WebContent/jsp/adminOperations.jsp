<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.upload{
    border:5px;
    padding:10px 25px;
    -moz-border-radius:50px;
    border-radius:50px;
    background-color:#0097C5;
    color:white;
    font-size:10px;
}
</style>
</head>
<body>
<br>
	<form method="POST" action="employeeUpload" enctype="multipart/form-data">
	<table >
	
	<tr><td ><h3 align="center"> Employee details upload</h3></td> 
	</tr>
	<tr><td><input style="margin: 3%"  type="file" name="uploadFile" class="upload"/></td></tr>
	<tr><td><input style="margin: 3%" type="submit" value="Upload" class="buttonStyle"/>
	<input type="reset" value="Reset" class="buttonStyle"/> </td>
	</tr></table>
</form>

<form method="POST" action="trainingsUpload" enctype="multipart/form-data"> 
	<table >
	<tr><td><h3 align="center"> Training details upload</h3></td></tr>
	<tr><td ><input style="margin: 3%" type="file" name="uploadFile" class="upload"/></td></tr>
	<tr><td><input style="margin: 3%" type="submit" value="Upload" class="buttonStyle"/>
	<input type="reset" value="Reset" class="buttonStyle"/> </td></tr>
	</table>
</form>


</body>

</html>