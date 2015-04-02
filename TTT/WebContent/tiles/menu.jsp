<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
	response.setHeader("Cache-Control","no-cache");
	response.setHeader("Pragma","no-cache");
	response.setDateHeader ("Expires", -1);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.abc{
	border-width: 
	
}
</style>

</head>
<body>
	<!--<s:property value="#session.name"/>
	<s:property value="#sessionMap.loggedUserDetails"/>
	<s:property value="#sessionMap.email"/>
	-->

	<ul style="margin-top: -170px; width: 100%;">
	
		<li style="width: 100%;"><a>Administrator</a>
			<ul>
				
			<!-- 	<li style="width: 100%;"><a>Account Details</a></li>
				<li style="width: 100%;"><a>Tower Details</a></li>
				<li style="width: 100%;"><a>Cluster Details</a></li>
				<li style="width: 100%;"><a>Application Details</a></li> -->
				<li style="width: 100%;"><a href="../jsp/uploadTrainingList.jsp">Training Details</a></li>
			<!-- 	<li style="width: 100%;"><a>User Details</a></li>
				<li style="width: 100%;"><a>User Training Details</a></li>
				<li style="width: 100%;"><a>Reports</a></li> -->
			</ul>
		</li>
	 
		<li style="width: 100%;"><a href="myTrainingsList">Trainings</a></li>
		<li style="width: 100%;"><a href="myArchiveTrainingsList">Archive</a></li>
	</ul>
 </body>
</html>
