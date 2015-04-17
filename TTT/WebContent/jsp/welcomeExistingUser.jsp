<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Opportunity Tracking and Governance Tool</title>
    
</head>
<body>
<div>
	<table  width="100%" border="1" style="margin-top: -100px;">
		<tr>
			<th>Completed Training</th>
			<th>Inprogress Training</th>
			
		</tr>
		<tr>
			<td>
				<jsp:include page="myArchiveTrainingsList.jsp"></jsp:include>
			</td>
			
			<td>
				<jsp:include page="myTrainingsList.jsp"></jsp:include>
			</td>
		</tr>
	</table>
</div>
</body>
</html>