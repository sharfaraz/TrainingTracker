<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", -1);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Generate Report</title>
</head>
<body>
<style>
.label {
	float: left;
	text-align: left;
		}

</style>
<script type="text/javascript" src="javascripts/TableManipulation.js"></script>
<script type="text/javascript" src="javascripts/calendar.js"></script>
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
	<tr> <td>Training Type : </td><td ><s:select id="trainingType" name="trainingType" headerKey="-1" headerValue="----Select----" list="NewTrainingType"  /></td></tr>
	<tr><td>Status : </td><td><s:select name="statusType" name="trainingStatus" headerKey="-1" headerValue="----Select----" list="NewStatus"/></td></tr>
	<tr><td>Tower<font color="red">*</font> : </td><td><s:select id="tower" name="towerName" list="towerData" headerKey="-1" headerValue="----Select----" onchange= "getSdmForReport()"/></td></tr></table>
	<tr><td><s:div  style="clear:both" id="SdmValue"></s:div><td></td></td> </tr>
	<tr><td><s:div  style="clear:both" id="DmValue"></s:div><td></td></td> </tr>
	 <tr><td><s:div  style="clear:both" id="AppValue"></s:div><td></td></td> </tr> 
	<%--<tr><td>DM : </td><td><s:select name="DM" headerKey="-1" headerValue="----Select----"	list="NewDMdata" /></td></tr>
	<tr><td>Application : </td><td><s:select name="Application"  headerKey="-1" headerValue="----Select----" list="NewApplicationData" /></td></tr> --%>
	<%-- <s:textfield name="Cluster" label="Cluster" /> --%>
	<tr><td></td><td><s:submit value="Generate Report" /></td></tr></table>

</s:form>



</body>
</html>



