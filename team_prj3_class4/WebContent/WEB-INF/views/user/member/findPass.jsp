<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Class4-비밀번호 찾기</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- css -->
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/findPass.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/header.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/footer.css" />" rel="stylesheet">
<!-- google font -->
<link href="https://fonts.googleapis.com/css?family=PT+Sans"
	rel="stylesheet">
<style type="text/css">
#wrapper {
	font-family: 'PT Sans', sans-serif;
}
</style>

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<c:import url="../header/header.jsp"></c:import>
		</div>
		<div id="container">
<div class="areaFix">
	<form action="" method="post">
		<div id="findPassDiv">
			<div>
				<h3>비밀번호 찾기</h3>
			</div>
			<div>
				<label>아이디</label>
			</div>
			<div>
				<input type="text" class="inputBox">
			</div>
			<div>
				<label>휴대폰 번호</label>
			</div>
			<div>
				<input type="text" class="inputBox">
			</div>
			<div>
				<input type="submit" value="비밀번호 찾기" id="findPassBtn"><br>
				<input type="submit" value="아이디 찾기" id="findIDBtn">
			</div>
		</div>
	</form>
</div>


		</div>
		<div id="footer">
			<c:import url="../footer/footer.jsp" />
		</div>


	</div>

</body>
</html>
