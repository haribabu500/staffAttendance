<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="/StaffAtendance/resources/css/bootstrap.css" type="text/css" rel="stylesheet" />
<style type="text/css">
	.loginbox{background: #ffffff; width: 350px; height: 300px; margin: 100px auto auto; padding: 10px; border-radius: 5px;}
	.loginbox tr{height: 50px;}
	.label{font-size: medium; background: #6BB5E2; display: block; height: 50px;font-size: 20px; line-height:40px;}
	.input{height: 50px; width: 220px; font-size: medium; padding:0 15px;}
	.input:FOCUS{border: 2px solid #6BB5E2 ;}
	.submit{height: 50px; width: 350px; background: #6BB5E2; font-size: 20px;}
	table{background: none repeat scroll 0 0 rgba(58, 146, 200, 0.15);}
</style>
<link href="/StaffAtendance/resources/css/style.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<form:form modelAttribute="staff" action="validate.htm">
		<div class="loginbox">
			<%-- <div>
				Welcome to Staff Attendance System<br>
				Please login to continue....<br/>
				<font color="red">${invalid}</font> 
			</div>
			<table>
				<tr><td width="100"><label class="label">Username:</label> </td><td width="250"><form:input path="usernam" class="input" type="text" /></td></tr>
				<tr><td><label class="label">Password:</label></td><td><form:input path="password" class="input" type="password"/></td></tr>
				<tr><td colspan="2"><input class="submit" type="submit" value="login"/></td></tr>
			</table> --%>
		<!-- 	 <img src="" alt="..." class="img-circle"> -->
			<div ><h3>Staff Atendance System....</h3><br></div>
			  <div class="form-group">
			    <label for="username">Username</label>
			    <form:input type="text" path="usernam" class="form-control" id="username" placeholder="Username" />
			  </div>
			  <div class="form-group">
			    <label for="password">Password</label>
			    <form:input type="password" path="password" class="form-control" id="password" placeholder="Password" />
			  </div>
			  <input type="submit" class="btn btn-primary" value="Login"></button>
			
		</div>
	</form:form>
</body>
</html>