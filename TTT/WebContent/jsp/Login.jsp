<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", -1);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Training Tracker-Login</title>
<link href="${pageContext.request.contextPath}/css/login.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript">
	window.history.forward();
</script>
</head>
<body>
	<div class="container">
		<section id="content">
			<s:form method="POST" action="ValidateLogin">
				<h1>Login Form</h1>
				<div>
					<s:textfield label="Email ID" key="email" size="50" maxlength="50"
						id="username" />
				</div>
				<div>
					<s:password label="Password" key="password" size="50"
						maxlength="50" id="password" />
				</div>
				<div>
					<s:if test="errorMsg!=''">
						<!-- Login failed. User ID or Password is invalid -->
						<s:property value="errorMsg" />
					</s:if>

					<s:submit value="Login" id="submit" align="center" />
				</div>
			</s:form>
		</section>
	</div>

</body>
</html>