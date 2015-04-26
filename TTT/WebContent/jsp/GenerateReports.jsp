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
 <script language="javascript">   
 $(function() {
	 $( "#datepicker" ).datepicker();
	 });  

createEditableSelect(document.forms[0].myText);
 </script>
 
</head>
<body onload="loadTable();">

<s:set name="theme" value="'simple'"  scope="page" /> 
<h3>
	<center>Generate Report  </center>
</h3>
<s:form action="FetchReportInExcel">
<table>

	<tr>
	<td><label id="targetDateLabel">Training Start date : </label></td><td> <s:textfield key="NewTrainingStDate" cssClass="changeFont" id="NewTrainingStDate"  readonly="true" /> </td></tr>
	<tr>
	<td><label id="targetDateLabel">Training End date : </label></td><td> <s:textfield key="NewTrainingEndDate" cssClass="changeFont" id="NewTrainingEndDate"  readonly="true" /> </td></tr>
	<tr> <td>Training Type : </td><td ><s:select id="trainingType" name="trainingType" cssClass="changeFont" headerKey="-1" headerValue="----Select----" list="NewTrainingType"  /></td></tr>
	<tr><td>Status : </td><td><s:select name="statusType" name="trainingStatus" cssClass="changeFont" headerKey="-1" headerValue="----Select----" list="NewStatus"/></td></tr>
	<tr><td>Tower : </td><td><s:select id="tower" name="towerName" cssClass="changeFont" list="towerData" headerKey="-1" headerValue="----Select----" onchange= "getSdmForReport()"/></td></tr>
	<tr><td><s:div  style="clear:both" id="SdmValue"></s:div></td>
	<td><s:div  style="clear:both" id="DmValue"></s:div></td>
	<!-- <td><s:div  style="clear:both" id="AppValue"></s:div></td></tr>  -->
	
	</table>
	<%--<tr><td>DM : </td><td><s:select name="DM" headerKey="-1" headerValue="----Select----"	list="NewDMdata" /></td></tr>
	<tr><td>Application : </td><td><s:select name="Application"  headerKey="-1" headerValue="----Select----" list="NewApplicationData" /></td></tr> --%>
	<%-- <s:textfield name="Cluster" label="Cluster" /> --%>
	
	<input type="submit" value="Generate Report" class="buttonStyle" style="margin-left: 42.5%;"/>
	<input type="button"  value="Cancel" name="Cancel" onclick="toCancel()" class="buttonStyle"/>
<!-- 	<input type="button" value="Generate Report" class="buttonStyle" style="margin-left: 30%;"/>  -->
	

</s:form>



</body>
</html>



