<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", -1);
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


<br/>
<center><h3>Create New Training</h3></center>
<div style="color:blue; ;" id="messageDiv"></div>
<s:form id="myform">
<s:set name="theme" value="'simple'"  scope="page" /> 
	<table>
	
	<tr><td >Training Name : </td><td><s:textfield id="NewTrainingName" cssClass="changeFont" /></td> </tr>
	<tr> <td>Training Type : </td><td ><s:select id="trainingType" headerKey="" headerValue="----Select----" list="NewTrainingType" cssClass="changeFont"  /></td></tr>
	<tr><td>Category Type : </td><td ><s:select id="trainingCateg" headerKey="" headerValue="----Select----" list="NewCategoryType" cssClass="changeFont"/></td></tr>
	<tr><td>Applicable Criteria : </td><td ><s:select id="assignedType" key="assignedType"  headerKey="-1" headerValue="----Select----" onchange="myfunction()"  list="AssignedTo" cssClass="changeFont" /></td>
	<td><s:div  style="clear:both" id="AssignedValue" ></s:div></td> </tr>
	
	<%-- <tr><td>Training Start Date<font color="red">*</font> : </td>
	<td><div><s:textfield name='NewTrainingStDt' id='NewTrainingStDt' readonly='true'/></div>
	<div id='calendar1'></div></td></tr>
	<tr><td>Training End Date<font color="red">*</font> : </td>
	<td><div><s:textfield name='NewTrainingEndDt' id='NewTrainingEndDt' readonly='true' onClick='javascript:stringToDate_field(this,"calendar2");'/></div>
	<div id='calendar2'></div></td></tr> --%>
	<tr>
	<td><label id="targetDateLabel">Training Start date : </label></td><td> <s:textfield key="NewTrainingStDate" cssClass="changeFont" id="NewTrainingStDate"  readonly="true" /> </td>
	<tr>
	<td><label id="targetDateLabel">Training End date : </label></td><td> <s:textfield key="NewTrainingEndDate" cssClass="changeFont" id="NewTrainingEndDate"  readonly="true" /> </td>
	</table>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
	<input type="button" value="Create" onclick="createTraining();" class="buttonStyle" style="margin-left: 30%;"/>
	<input type="button"  value="CANCEL" name="Cancel" onclick="toCancel()" class="buttonStyle"/>
	

</s:form>
 
</body>
</html>


