<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trainings List</title>
</head>
<body>
<s:form action="updateTrainings" name="TrainingsView">
	<h3>Trainings List</h3>
	
	<br>
	<table>
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
			<tr><td><input type="text" class="changeFont" value='<s:property value="trainingName" />' readonly="readonly"  
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
			<%-- <td><input type="text" class="changeFont" value='<s:property value="status" />' 
				name='empTrngs[<s:property value="%{#status.index}"/>].status'
				id="status<s:property value="%{#status.index}"/>" /></td> --%>
			<td><select class="changeFont"  
				name='empTrngs[<s:property value="%{#status.index}"/>].status'
				id="status<s:property value="%{#status.index}"/>" >
  				<option value='<s:property value="status" />' ><s:property value="status" /></option>
  				<option value="completed">completed</option>
  				<option value="pending">Pending</option>
  				<option value="inprogress">In-progress</option>
           </select> </td>
		</tr>
		</s:iterator>
	</table>
	<div align="center">
			<input type="submit" value="Update" id="myBtn" class="buttonStyle" />&nbsp;&nbsp;&nbsp;
			<input type="reset" value="Cancel" class="buttonStyle"/>
		</div>
</s:form>

</body>
</html>