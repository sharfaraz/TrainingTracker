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
	<s:set name="trngApprover" value="#session.isTA"></s:set>
	<s:set name="userName" value="#session.userName"></s:set>
	
<TABLE width="100%" border="0" style="padding: 0px 0px 0px 0px; margin: 0px 0px 0px 0px;">

	<TR >
	<TD width="80%">
	<ul id="nav">
		<li><a>Employee</a>
			<ul> 
      			 <li><a href="viewTrainingFilters" >View/Update Training</a></li>
      			 <li><a href="contactUsLink" >Request Training</a></li> 
     		</ul> 
   		</li>
   		<s:if test="%{#superUser == \"S\"}">
		<li>
		<a>Super User</a>
		<ul> 
      			 <li><a href="trainingsLoadLink">Trainings Upload</a></li> 
      			 <li><a href="employeesLoadLink">Employee Upload</a></li> 
      			 <li><a href="createNewTraining" >Create New Training</a></li> 
      			 <li><a href="applicationLoadLink" >Upload Applications</a></li> 
<!--       			 <li><a href="organization" >Assign Training</a></li> -->
     		</ul>
		</li>
		</s:if>
		
		<s:if test="%{#delMgr == \"D\"}">
		<li>
		<a>Manager</a>
		<ul> 
				<li><a href="trainingsLoadLink">Trainings Upload</a></li>
				<li><a href="createNewTraining" >Create New Training</a></li>
      			<li><a href="fetchReport" >Reports</a></li>
      			<li><a href="applicationsManaged" >My applications</a></li>
      			<li><a href="employeesManaged" >Employees I manage</a></li>
      			<li><a href="assignTrainings" >Assign Trainings</a></li>
      			<li><a href="assignApplications" >Assign Applications</a></li>		 
     		</ul> 
     	
		</li>
		</s:if>
		<s:if test="%{#trngApprover == \"A\"}">
		<li>
		<a>Approvals</a>
		<ul>
				<li><a href="trainingApprovals">Approve Training Completed</a></li>
		</ul>
		</li>
		</s:if>
		<li><a href="contactUsLink">Contact Us</a></li>


	</ul>
	</TD>
	<TD width="20%" align="center">
	
	<ul id="nav">
		<li>
			<a><s:property value="#session.userName" /></a>
			<ul>
				<li><a href="logoutAction">Logout</a></li>
			</ul>
		</li>
	</ul>
	
	</TD>
	</TR>
	</TABLE>
		
</body>
</html>
