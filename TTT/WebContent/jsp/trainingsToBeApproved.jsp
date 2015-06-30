<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.util.Map"%>
<%@page import="org.apache.struts2.dispatcher.SessionMap"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", -1);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="css/SummaryView.css">
<link rel="stylesheet" type="text/css" href="css/buttons.css">

<script type="text/javascript" src="javascript/jquery-1.2.6.min.js"></script>
<script type="text/javascript" src="javascript/jquery-ui-personalized-1.5.2.packed.js"></script>
<script type="text/javascript" src="javascript/sprinkle.js"></script>
<script type="text/javascript" src="javascript/jquery-1.9.1.js"></script>
<script type="text/javascript" src="javascript/jquery-ui.js"></script>
<script type="text/javascript" src="javascript/TableManipulation.js"></script>

<script type="text/javascript">
	$(function() {
		$("#datepicker").datepicker();
	});

	createEditableSelect(document.forms[0].myText);

	function updateStatus(trainingId, emailContact) {
		var params = "";
		params += "trainingId=" + trainingId + "&";
		params = params.substring(0, params.length - 1);
		window:location.href = 'updateTrainingsComplete?' + params;
		alert("Training Marked as Complete");
	}
</script>

</head>
<body onload="loadTable();">
	<s:set name="theme" value="'simple'" scope="page" />
	<div>
		<div align="center">
			<font color="green"><s:property value="#session.successMsg" /></font>
		</div>
	</div>
	
	<div>
		<div align="center">
			<h3>
				<font color="red"><s:property value="#session.TrainingsApprovalMsg" /></font>
			</h3>
		</div>
	</div>


	<s:if test="empTrngs.size() > 0">
		<s:form name="TrainingsView" id="trainingsGrid">
			<s:set name="theme" value="'simple'" scope="page" />
			<h2 align="center">Trainings to be approved</h2>
			<table border="0" id="trainingsTable">
				<thead>
					<tr>
						<th><b>Training Name</b></th>
						<th><b>Employee ID</b></th>
						<th><b>Start Date</b></th>
						<th><b>End Date</b></th>
						<th><b>Status</b></th>
						<th><b>Action</b></th>
					</tr>
				</thead>
				<s:iterator value="empTrngs" status="status">
						<tr>
						
						<td><input type="text" class="changeFont" 
							value='<s:property value="trainingName"/> ' readonly="readonly"
							name='empTrngs[<s:property value="%{#status.index}"/>].trainingName'
							id="trainingName<s:property value="%{#status.index}"/>" /></td>
						
						
						
						<td><input type="text" class="changeFont" 
							value="<s:property value='empId'/>" readonly="readonly"
							name='empTrngs[<s:property value="%{#status.index}"/>].empId'
							id="empId<s:property value="%{#status.index}"/>" /></td>
						
						
						
						<td><input type="text" class="changeFont"
							value='<s:property value="startDate" />' readonly="readonly"
							name='empTrngs[<s:property value="%{#status.index}"/>].startDate'
							id="startDate<s:property value="%{#status.index}"/>" /></td>
							
						<td><input type="text" class="changeFont"
							value='<s:property value="endDate" />' readonly="readonly"
							name='empTrngs[<s:property value="%{#status.index}"/>].endDate'
							id="endDate<s:property value="%{#status.index}"/>" /></td>
							
						<td><input type="text" class="changeFont"
							value='<s:property value="status" />' readonly="readonly"
							name='status[<s:property value="%{#status.index}"/>].endDate'
							id="status<s:property value="%{#status.index}"/>" /></td>
						
						<td><input type="submit" title="Update"
							id="btn<s:property value="%{#status.index}"/>" value="Mark as COMPLETE"
							class="buttonStyle2"
							onclick="updateStatus('<s:property value="trainingId" />');" /></td>
							
						</tr>
				</s:iterator>
			</table>
		</s:form>
	</s:if>
	<%
		Map session2 = (Map) ActionContext.getContext().get("session");
		session2.put("successMsg", "");
		session2.put("TrainingsApprovalMsg", "");
	%>
</body>
</html>