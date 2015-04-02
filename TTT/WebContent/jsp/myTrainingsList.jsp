<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", -1);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function showMsg(){
		var res = confirm("Approval request will go to you Manager. Do you want to continue?");
		if(res == true){
			return true;
		}else{
			return false;
		}
	}
</script>
</head>
<body>
	<table width="100%" border="1" style="margin-top: -150px;">
		<tr>
			<th>TRAINING NAME</th>
			<th>LAST DTAE TO COMPLET</th>
			<th>STATUS</th>
			<th>ACTION</th>
		</tr>
		
		<c:forEach var="lst" items="${myTrainingsList}">
			<c:if test='${lst.status == "Pending"}'>
				<tr>
					<td>${lst.trainingId}</td>
					<td>${lst.endDate}</td>
					<td>${lst.status}</td>
					<td><a href="#" onclick="showMsg();">confirm</a>
				</tr>	
			</c:if>
		</c:forEach>
		
		
	</table>
</body>
</html>