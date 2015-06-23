<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", -1);
%>
<!DOCTYPE HTML>
<html>
<head>
<sx:head/>
<title>Create New Training</title>
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
 <script>   
 $(function() {
	 $( "#datepicker" ).datepicker();
	 });  

createEditableSelect(document.forms[0].myText);
 </script>
 
 <script>
 
 </script>
</head>

<body onload="loadTable();">

<s:set name="theme" value="'simple'"  scope="page" /> 
<h3>
	<center>Generate Report  </center>
</h3>
<div style="color:blue; ;" id="messageDiv"></div>
<s:form id="myForm" action="FetchReportInExcel">
<s:set name="theme" value="'simple'"  scope="page" /> 


<table cellspacing="10" cellpadding="0" class="dynamicView" id="light">
		<tr><td colspan="4" align="left"><b>Filter Rows</b></td></tr>
		<tr>
			<td>
				<table>
	<tr><td>Training Name : </td><td>
	<s:select id="trainingName" list="trainingNameData" name="trainingName" headerKey="-1" headerValue="----Select----" cssClass="changeFont" />
	</td></tr>
	<tr><td><label id="targetDateLabel">Training Start date : </label></td><td> <s:textfield key="NewTrainingStDate" cssClass="changeFont" id="NewTrainingStDate"  readonly="true" /> </td></tr>
	<tr>
	<td><label id="targetDateLabel">Training End date : </label></td><td> <s:textfield key="NewTrainingEndDate" cssClass="changeFont" id="NewTrainingEndDate"  readonly="true"  /> </td></tr>
	<tr> <td>Training Type : </td><td><s:select id="trainingType" name="trainingType" cssClass="changeFont" headerKey="-1" headerValue="----Select----" list="NewTrainingType"/></td></tr>
	<tr><td>Status : </td><td><s:select name="statusType" id="statusType" name="trainingStatus" cssClass="changeFont" headerKey="-1" headerValue="----Select----" list="NewStatus"/></td></tr>
	<tr><td>Tower : </td><td><s:select id="tower" name="towerName" cssClass="changeFont" list="towerData" headerKey="-1" headerValue="----Select----" onchange= "getSdmForReport()"  /> [OR] 
	<input type="submit" value="My Employees" name="reports" onclick="return myEmployeesReport()" class="buttonStyle"/></td></tr>
	<tr><td><s:div style="clear:both" id="SdmValue" ></s:div></td>
	<td><s:div  style="clear:both" id="DmValue"></s:div></td>
	<!-- <td><s:div  style="clear:both" id="AppValue"></s:div></td></tr>  -->
	</tr>

</table>

</tr>
	
	
<tr><td colspan="2" align="left">

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
	
<input type="submit" value="Generate Report" name="reports" onclick="return validateReports();" class="buttonStyle"/>
	<input type="button" value="Cancel" name="Cancel" onclick="toCancel()" class="buttonStyle" /></td>
</tr>

</table>




	
	

</s:form>




</body>
</html>



