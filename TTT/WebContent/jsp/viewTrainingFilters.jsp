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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Filters</title>

<link rel="stylesheet" type="text/css" href="css/SummaryView.css" > 
<link rel="stylesheet" type="text/css" href="css/buttons.css" >

<style type="text/css">

#trainingsTable table {
	 margin: 0px 0px 0px 0px;
	 display: none;
	 border-collapse: separate;
 	 background: none;
 	 -moz-border-radius: 0px;
 	 -webkit-border-radius: 0px;
  		border-radius: 0px;
 	-moz-box-shadow: 0px 0px 0px rgba(0, 0, 0, 0);
  	-webkit-box-shadow: 0px 0px 0px rgba(0, 0, 0, 0);
  	box-shadow: 0px 0px 0px rgba(0, 0, 0, 0);
  	padding: 0px 0px 0px 0px !important;
}

#trainingsTable tr td {
	padding: 0px 0px 0px 0px;
	
}

#trainingsTable input {
	background-color: #F0F0F0;
	border: none;
	width: 100%;
	padding-bottom: 0px;
}

.btn {
	background-color: #4F94CD;
	azimuth: center;
	width: 100px;
	height: 30px;
	color: white;
	font-weight: bold;
}
</style>

<script type="text/javascript" src="javascript/jquery-1.2.6.min.js"></script>
<script type="text/javascript" src="javascript/jquery-ui-personalized-1.5.2.packed.js"></script>
<script type="text/javascript" src="javascript/sprinkle.js"></script>
<script type="text/javascript" src="javascript/jquery-1.9.1.js"></script>
<script type="text/javascript" src="javascript/jquery-ui.js"></script>
<script type="text/javascript" src="javascript/TableManipulation.js"></script>
<script type="text/javascript">   
 $(function() {
	 $( "#datepicker" ).datepicker();
	 });  

createEditableSelect(document.forms[0].myText);

function updateStatus(){
	alert("An email will be sent to respective person for Approval. Status will be changed to Completed.");
	var params = "";
	$(".case").each(function(){
		if(this.checked){
			params += "trainingId="+this.value+"&";
			
		}
	});
	params = params.substring(0,params.length-1);
	window.location.href = "mailto:bmahable@in.ibm.com?cc=sharfarazbaari@in.ibm.com?subject=subject&body=body";
	window:location.href='updateTrainings?'+params;
	
	  
	
}

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
<td><input type="submit" value="Apply Filter" class="buttonStyle2" /></td></tr>
</table>
</s:form>

<div>
<div align="center">
	<h3><font color="red"><s:property value="#session.trainingsMsg" /></font> </h3> </div>
</div>


<s:if test="empTrngs.size() > 0" >
<s:form  name="TrainingsView" id="trainingsGrid">
	<s:set name="theme" value="'simple'" scope="page" />
	<h2 align="center">Trainings assigned to You</h2>


	<table border="0" id="trainingsTable">
		<thead><tr>
		 
			<th><b>Training Name</b></th>
			<th><b>Training Type</b></th>
			<th><b>Start Date</b></th>
			<th><b>End Date</b></th>
			<th><b>Status</b></th>
			<th><b>Request For<br>Completion</b></th>
		</tr></thead>

		
		<s:iterator value="empTrngs" status="status">
		
				
					<tr>
					
						<td width=300>
						    <input type="text" class="changeFont" value='<s:property value="trainingId"/>' hidden="hidden"
	        	 name='empTrngs[<s:property value="%{#status.index}"/>].trainingId' 
	        	 id="trainingId<s:property value="%{#status.index}"/>" />
	        <input type="text" class="changeFont" value='<s:property value="etId"/>' hidden="hidden"
	        	 name='empTrngs[<s:property value="%{#status.index}"/>].etId' 
	        	 id="etId<s:property value="%{#status.index}"/>" />
 	        <input type="text" class="changeFont" value='<s:property value="empId"/>' hidden="hidden"
	        	 name='empTrngs[<s:property value="%{#status.index}"/>].empId' 
	        	 id="empId<s:property value="%{#status.index}"/>" /> 
	        	 
						<s:if test='endDate < #session.currentDate && status != "Completed"'>
						<input type="text" class="changeFont" style="color: red"
							value='<s:property value="trainingName"/> '
							readonly="readonly"
							name='empTrngs[<s:property value="%{#status.index}"/>].trainingName'
							id="trainingName<s:property value="%{#status.index}"/>"  />
						</s:if>	
						<s:else>
						<input type="text" class="changeFont"
							value='<s:property value="trainingName"/>'
							readonly="readonly"
							name='empTrngs[<s:property value="%{#status.index}"/>].trainingName'
							id="trainingName<s:property value="%{#status.index}"/>"  />
						</s:else>
							
						</td>
						<td><input style="padding-bottom: 0px" type="text" class="changeFont"
							value='<s:property value="trainingType" />' readonly="readonly"
							name='empTrngs[<s:property value="%{#status.index}"/>].trainingType'
							id="trainingType<s:property value="%{#status.index}"/>" /></td>
						<td><input type="text" class="changeFont"
							value='<s:property value="startDate" />' readonly="readonly"
							name='empTrngs[<s:property value="%{#status.index}"/>].startDate'
							id="startDate<s:property value="%{#status.index}"/>" /></td>
						<td><input type="text" class="changeFont"
							value='<s:property value="endDate" />' readonly="readonly"
							name='empTrngs[<s:property value="%{#status.index}"/>].endDate'
							id="endDate<s:property value="%{#status.index}"/>" /></td>

						<td>
						<input type="text" class="changeFont"
							value='<s:property value="status" />' readonly="readonly"
							name='empTrngs[<s:property value="%{#status.index}"/>].status'
							id="status<s:property value="%{#status.index}"/>" /></td>
						<%-- <select class="changeFont"
							name='empTrngs[<s:property value="%{#status.index}"/>].status'
							id="status<s:property value="%{#status.index}"/>">
								<s:iterator value="statuses" status="stat">

									<option value='<s:property value="statuses[#stat.index]"/>'
										<s:if test="statuses[#stat.index]== status"> selected </s:if>>
										<s:property value="statuses[#stat.index]" />
									</option>
								</s:iterator>
						</select></td> --%>

					<td>
					<%-- <s:if test='status == "Completed"'>
					<input class="changeFont" type="checkbox" name="trng_ids"  class="case" align="middle" value="trainingId" />
					</s:if>
					<s:if test='status == "Pending"'>
					<input class="changeFont" type="checkbox" name="trng_ids"  class="case" align="middle" value="trainingId" disabled="disabled"/>
					</s:if> --%>
					<input type="checkbox" name="trainingId"  class="case" value="<s:property value="trainingId" />" />
					<%-- <h5 align="center"><a href="updateTrainingStatus" id="mailLink">  Send Email   </a> </h5>
					<script>
					document.getElementById("mailLink").onclick = function() {
						alert("An email will be sent to respective person for Approval. Status will be changed to Completed.");
					javascript:location.href='updateTrainingStatus?'+<s:property value="trainingId" />&<s:property value="empId" />;	
    			//	window.location = "mailto:bmahable@in.ibm.com?cc=sharfarazbaari@in.ibm.com?subject=subject&body=body";
					}
					</script> --%>
					</td>

					</tr>

				</s:iterator>

	</table>
	<div align="center">
			<input type="button" value ="Update" title="Update" id="myBtn" class="buttonStyle2" onclick="updateStatus();" />&nbsp;&nbsp;&nbsp;
			<input type="reset" value="Cancel" class="buttonStyle2"/>
		</div>
		
	<h5 style="color: red">*  - End date passed. Please complete Immediately.</h5>	
	<h5 style="color: red">** - Last day for completing training.</h5>
</s:form>

</s:if>

	<%
		Map session2 = (Map) ActionContext.getContext().get("session");
		session2.put("successMsg", "");
		session2.put("trainingsMsg", "");
	 %>

</body>
</html>