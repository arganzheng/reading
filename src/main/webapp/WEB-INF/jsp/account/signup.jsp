<%@ page language="java" contentType="text/html; charset=UTF8" pageEncoding="UTF8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Reading</title>
</head>
<body>
	<h2>SignUp</h2>
	<form:form method="post" action="signup" commandName="userRegistrationForm">

		<table>
			<tr>
				<td><form:label path="username">Username</form:label></td>
				<td><form:input path="username" /></td>
				<td><font color="red"><form:errors path="username"></form:errors></font></td>  
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" /></td>
				<td><font color="red"><form:errors path="email"></form:errors></font></td>  
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:input path="password" /></td>
				<td><font color="red"><form:errors path="password"></form:errors></font></td>  
			</tr>
			<tr>
				<td><form:label path="confirmPassword">confirmPassword</form:label></td>
				<td><form:input path="confirmPassword" /></td>
				<td><font color="red"><form:errors path="confirmPassword"></form:errors></font></td>  
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Sign Up" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>