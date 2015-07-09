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
<sx:head />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Filters</title>

<link rel="stylesheet" type="text/css" href="css/SummaryView.css">
<link rel="stylesheet" type="text/css" href="css/buttons.css">


<script type="text/javascript" src="javascript/jquery-1.2.6.min.js"></script>
<script type="text/javascript"
	src="javascript/jquery-ui-personalized-1.5.2.packed.js"></script>
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
		/* 	alert("An email will be sent to respective person for Approval. Status will be changed to Completed.");
		 var params = "";
		 $(".case").each(function(){
		 if(this.checked){
		 params += "trainingId="+this.value+"&";
		 alert(params);
		 }
		 });
		 params = params.substring(0,params.length-1);
		 window.location.href = "mailto:bmahable@in.ibm.com?subject=Request for Approval&body=body";
		 window:location.href='updateTrainings?'+params; */
		alert("An email will be sent to respective person for Approval. Status will be changed to Completed.");
		var params = "";
		params += "trainingId=" + trainingId + "&";
		params = params.substring(0, params.length - 1);
		var body = "Auto Generated Mail to Request your approval for completion";
		window.location.href = "mailto:" + emailContact
				+ "?subject=Request for Approval&body=" + body;

		/* var xmlhttp;
		if (window.XMLHttpRequest)
		  {// code for IE7+, Firefox, Chrome, Opera, Safari
		  xmlhttp=new XMLHttpRequest();
		  }
		else
		  {// code for IE6, IE5
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		xmlhttp.onreadystatechange=function()
		  {
		  if (xmlhttp.readyState==4 && xmlhttp.status==200)
		    {
		   //var result=xmlhttp.responseText;
		   //alert("deleted");
		    }
		  };
		xmlhttp.open("GET","updateTrainings?"+params,true);
		xmlhttp.send(); */

		window: location.href = 'updateTrainings?' + params;
		alert("done");
	}
</script>


<script language="javascript">
	function expired() {
		document.getElementById("cell1").style.backgroundColor = "red";
	}
</script>


<body onload="loadTable();">
	<s:set name="theme" value="'simple'" scope="page" />
	<div>
		<div align="center">
			<font color="green"><s:property value="#session.successMsg" /></font>
		</div>
	</div>
	<div >
	<s:form action="viewTrainingAllFilters">
		<table >
			<tr>
				<td><label id="targetDateLabel">Training Start date : </label></td>
				<td><s:textfield key="selTrainingStDate" cssClass="changeFont"
						id="selTrainingStDate" readonly="true" /></td>
				<td><label id="targetDateLabel">Training End date : </label></td>
				<td><s:textfield key="selTrainingEndDate" cssClass="changeFont"
						id="selTrainingEndDate" readonly="true" /></td>
				<td>Training Type :</td>
				<td><s:select id="trainingType" name="selTrainingType"
						cssClass="changeFont" headerKey="-1" headerValue="----Select----"
						list="FilterTrainingType" /></td>
				<td><input type="submit" value="Apply Filter"
					class="buttonStyle2" /></td>
			</tr>
		</table>
	</s:form>
	</div>

	<div>
		<div align="center">
			<h3>
				<font color="red"><s:property value="#session.trainingsMsg" /></font>
			</h3>
		</div>
	</div>


	<s:if test="trngs.size() > 0">
		<s:form name="TrainingsView" id="trainingsGrid">
			<s:set name="theme" value="'simple'" scope="page" />
			<h2 align="center">All Trainings</h2>


			<table border="0" id="trainingsTable">
				<thead>
					<tr>

						<th><b>Training Name</b></th>
						<th><b>Training Type</b></th>
						<th><b>Start Date</b></th>
						<th><b>End Date</b></th>
					</tr>
				</thead>


				<s:iterator value="trngs" status="status">


					<tr>
 						<td> 
 							<input type="text" class="changeFont"
									value='<s:property value="trainingName"/>' 
									readonly="readonly"
									name='empTrngs[<s:property value="%{#status.index}"/>].trainingName'
									id="trainingName<s:property value="%{#status.index}"/>" />
						</td>
						<td>
							<input style="padding-bottom: 0px" type="text"
								class="changeFont" value='<s:property value="trainingType" />'
								readonly="readonly"
								name='empTrngs[<s:property value="%{#status.index}"/>].trainingType'
								id="trainingType<s:property value="%{#status.index}"/>" />
						</td>
						<td>
							<input type="text" class="changeFont"
								value='<s:property value="startDate" />' 
								readonly="readonly"
								name='empTrngs[<s:property value="%{#status.index}"/>].startDate'
								id="startDate<s:property value="%{#status.index}"/>" />
						</td>
						<td>
							<input type="text" class="changeFont"
								value='<s:property value="endDate" />' 
								readonly="readonly"
								name='empTrngs[<s:property value="%{#status.index}"/>].endDate'
								id="endDate<s:property value="%{#status.index}"/>" />
						</td>
						<%-- <td>
							<input type="submit" 
								title="Update"
								id="btn<s:property value="%{#status.index}"/>" 
								value="Request for completion"
								class="buttonStyle2"
								onclick="updateStatus('<s:property value="trainingId" />', '<s:property value="emailContact" />');" />
						</td> --%>

					</tr>
				</s:iterator>
			</table>
		</s:form>
	</s:if>
	<%
		Map session2 = (Map) ActionContext.getContext().get("session");
		session2.put("successMsg", "");
		session2.put("trainingsMsg", "");
	%>
</body>
</html>