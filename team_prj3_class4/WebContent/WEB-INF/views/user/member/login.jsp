<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Class4-로그인</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- css -->
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
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
				<div id="login">
					<div id="loginInput">
						<div id="loginNotice">가입하신 아이디와 비밀번호를 입력해주세요.</div>
						<div id="loginID">
							<input type="text" class="inputBox" name="id" placeholder="아이디">
						</div>
						<div id="loginPass">
							<input type="password" class="inputBox" name="pass" placeholder="*******">
						</div>
					</div>
					<div id="loginBtnDiv">
						<input type="submit" value="로그인">
					</div>
					
					<div id="loginOptionDiv">
						<table>
							<tr>
								<td><a href="findID.do">아이디 찾기</a></td>
								<td><a href="findPass.do">비밀번호 찾기</a></td>
								<td><a href="join.do">회원가입</a></td>
								
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div id="footer">
			<c:import url="../footer/footer.jsp" />
		</div>


	</div>

</body>
</html>