<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.util.Map"%>
<%@page import="org.apache.struts2.dispatcher.SessionMap"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", -1);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/css/menu.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript" src="javascript/dropdown.js"></script>
</head>
<body>
<%
		Map aSession = (Map) ActionContext.getContext().get("session");
		System.out.println(aSession);
	%>
	
	<s:set name="superUser" value="#session.isSU"></s:set>
	<s:set name="delMgr" value="#session.isDM"></s:set>
	<ul id="nav">
		<li><a>Employee</a>
			<ul> 
      			 <li><a href="viewTrainings" >View/Update Training</a></li>
      			 <li><a href="organization" >Request Training</a></li> 
     		</ul> 
   		</li>
   		<s:if test="%{#superUser == \"S\"}">
		<li>
		<a>Super User</a>
		<ul> 
      			 <li><a href="UploadFileAction">Employee Upload</a></li> 
      			 <li><a href="UploadFileAction">Trainings Upload</a></li>
      			 <li><a href="createNewTraining" >Create New Training</a></li> 
      			 <li><a href="organization" >Assign Training</a></li> 
     		</ul>
		</li>
		</s:if>
		
		<s:if test="%{#delMgr == \"D\"}">
		<li>
		<a>Super User</a>
		<ul> 
      			 <li><a href="UploadFileAction">Employee Upload</a></li> 
      			 <li><a href="UploadFileAction" >Trainings Upload</a></li> 
      			 <li><a href="createNewTraining" >Create New Training</a></li> 
      			 <li><a href="organization" >Assign Training</a></li> 
     		</ul>
		</li>
		<li>
		<a>Manager</a>
		<ul> 
      			 <li><a href="fetchreport" >Reports</a></li> 
      			 
     		</ul> 
     	
		</li>
		</s:if>
		<li><a href="ContactUs">Contact Us</a></li>

	</ul>
</body>
</html>
