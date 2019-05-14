<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<link href="<c:url value="/resources/admin/css/loginStyle.css"/>" rel="stylesheet">
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
	</head>
<body>
	<div class="box">
		<h2>SIST Class4 Group1 <br/>:::::<br/> 2019 Web Project</h2>
		<form action="AdminLoginProcess.do" method="post" name="lognFrm">
			<div class="inputBox">
				<input type="text" required="" id="loginId" name="loginId"/>
				<label>Username</label>
			</div>
			<div class="inputBox">
				<input type="password" required="" id="loginPass" name="loginPass"/>
				<label>password</label>
			</div>
			<input type="submit" id="loginBtn" value="Login">
		</form>
	
	</div>
</body>
</html>