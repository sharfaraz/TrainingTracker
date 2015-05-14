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
<sx:head/>
<title>Select Filters</title>
<meta content="text/html;charset=utf-8" http-equiv="Content-Type">
<meta content="utf-8" http-equiv="encoding">
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/datepicker.css">
<link rel="stylesheet" type="text/css" href="css/baselayout.css" >

<style type="text/css">

  tr.spaceUnder > td
{
  padding-bottom: 1em;
}
</style>

<script type="text/javascript" src="javascript/jquery-1.2.6.min.js"></script>
<script type="text/javascript" src="javascript/jquery-ui-personalized-1.5.2.packed.js"></script>
<script type="text/javascript" src="javascript/sprinkle.js"></script>
<script type="text/javascript" src="javascript/jquery-1.9.1.js"></script>
<script type="text/javascript" src="javascript/jquery-ui.js"></script>
<script type="text/javascript" src="javascript/TableManipulation.js"></script>
<script language="javascript">   
 $(function() {
	 $( "#datepicker" ).datepicker();
	 });  

createEditableSelect(document.forms[0].myText);
 </script>
 
 <script language="javascript">
 function expired() {
	 document.getElementById("cell1").style.backgroundColor= "red";
 }
 </script>
 
<body onload="loadTable();">
<s:set name="theme" value="'simple'"  scope="page" /> 
<div>
<div align="center">
	<font color="green"><s:property value="#session.successMsg" /></font></div>
</div>
<s:form action="viewTrainingFilters" >
<table><tr>
<td><label id="targetDateLabel">Training Start date : </label></td>
<td><s:textfield key="selTrainingStDate" cssClass="changeFont" id="selTrainingStDate"  readonly="true" /> </td>
<td><label id="targetDateLabel">Training End date : </label></td>
<td> <s:textfield key="selTrainingEndDate" cssClass="changeFont" id="selTrainingEndDate"  readonly="true" /> </td>
<td>Training Type : </td><td ><s:select id="trainingType" name="selTrainingType" cssClass="changeFont" headerKey="-1" headerValue="----Select----" list="FilterTrainingType"  /></td>
<td>Status : </td><td><s:select id="statusType" name="selTrainingStatus" cssClass="changeFont"  list="FilterStatus"/></td>
<%-- <td>Level : </td><td><s:select id="level" name="selLevel" cssClass="changeFont" headerKey="-1" headerValue="----Select----" list="FilterLevel" /> </td> --%>
<td><input type="submit" value="Apply Filter" class="buttonStyle" /></td></tr>
</table>
</s:form>

<div>
<div align="center">
	<h3><font color="red"><s:property value="#session.trainingsMsg" /></font> </h3> </div>
</div>


<s:if test="empTrngs.size() > 0" >
<s:form action="updateTrainings" name="TrainingsView" id="trainingsGrid">
	<h2 align="center">Trainings assigned to You</h2>
	
	<br>
	<table id="trainingsTable">
		<tr>
		 
			<th><b>Training Name</b></th>
			<th><b>Training Type</b></th>
			<th><b>Start Date</b></th>
			<th><b>End Date</b></th>
			<th><b>Status</b></th>
		</tr>

		
		<s:iterator value="empTrngs" status="status">
		
		

	        <input type="text" class="changeFont" value='<s:property value="trainingId"/>' hidden="hidden"
	        	 name='empTrngs[<s:property value="%{#status.index}"/>].trainingId' 
	        	 id="trainingId<s:property value="%{#status.index}"/>" />
	        <input type="text" class="changeFont" value='<s:property value="etId"/>' hidden="hidden"
	        	 name='empTrngs[<s:property value="%{#status.index}"/>].etId' 
	        	 id="etId<s:property value="%{#status.index}"/>" />
 	        <input type="text" class="changeFont" value='<s:property value="empId"/>' hidden="hidden"
	        	 name='empTrngs[<s:property value="%{#status.index}"/>].empId' 
	        	 id="empId<s:property value="%{#status.index}"/>" />
	        	 
	        
			<tr id="cell1"><td><input type="text" class="changeFont" value='<s:property value="trainingName" />' readonly="readonly"  
				name='empTrngs[<s:property value="%{#status.index}"/>].trainingName'
				id="trainingName<s:property value="%{#status.index}"/>" /></td> 
			<td><input type="text" class="changeFont" value='<s:property value="trainingType" />' readonly="readonly"   
				name='empTrngs[<s:property value="%{#status.index}"/>].trainingType'
				id="trainingType<s:property value="%{#status.index}"/>" /></td>
			<td><input type="text" class="changeFont" value='<s:property value="startDate" />' readonly="readonly"   
				name='empTrngs[<s:property value="%{#status.index}"/>].startDate'
				id="startDate<s:property value="%{#status.index}"/>" /></td>
			<td><input type="text" class="changeFont" value='<s:property value="endDate" />' readonly="readonly"   
				name='empTrngs[<s:property value="%{#status.index}"/>].endDate'
				id="endDate<s:property value="%{#status.index}"/>"/></td>

			<td><select class="changeFont" 
				name='empTrngs[<s:property value="%{#status.index}"/>].status'
				id="status<s:property value="%{#status.index}"/>" >
				<s:iterator value="statuses" status="stat">
				
  				<option value='<s:property value="statuses[#stat.index]"/>' 
  				<s:if test="statuses[#stat.index]== status"> selected </s:if>  
  				> 
  				<s:property value="statuses[#stat.index]"/>
  				</option>
  				</s:iterator>
  				</select> </td>
  				
  		<s:if test='endDate < #session.currentDate && status != "Completed"'>
		<td ><font color="red">*End date passed. Please complete Immediately.</font></td>
		</s:if>
		
		<s:if test='endDate = #session.currentDate && status != "Completed"'>
		<td ><font color="red">*Last day for completing training</font></td>
		</s:if>
		
		</tr>

		</s:iterator>

	</table>
	<div align="center">
			<input type="submit" value="Update" id="myBtn" class="buttonStyle" />&nbsp;&nbsp;&nbsp;
			<input type="reset" value="Cancel" class="buttonStyle"/>
		</div>
</s:form>

</s:if>

	<%
		Map session2 = (Map) ActionContext.getContext().get("session");
		session2.put("successMsg", "");
		session2.put("trainingsMsg", "");
	 %>

</body>
</html>