<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>당신을 위한 수업 Class4</title>
<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/startbootstrap-modern-business-gh-pages/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="<c:url value="/resources/startbootstrap-modern-business-gh-pages/vendor/bootstrap/css/modern-business.css" />" rel="stylesheet">
<!-- CSS -->
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<c:import url="user/header/header.jsp"></c:import>
		</div>
		<div id="container">
			<div class="areaFix">
				<div id="login">
					<form action="login.do" method="post">
						<div id="loginInput">
							<div id="loginNotice">
							<c:choose>
							<c:when test="${param.result eq null }">
							<label>가입하신 아이디와 비밀번호를 입력해주세요.</label>
							</c:when>
							<c:when test="${param.result eq 'black' }">
							<label style="color: red;">차단 된 아이디입니다.</label>
							
							</c:when>
							<c:when test="${param.result eq 'deleted' }">
							<label style="color: red;">삭제 된 아이디입니다.</label>
							
							</c:when>
							<c:when test="${param.result eq 'fail' }">
							<label style="color: red;">아이디와 비밀번호를 다시 한 번 확인해주세요.</label>
							
							</c:when>
							</c:choose>
							</div>
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
					</form>
				</div>
			</div>
		</div>
		<div id="footer">
			<c:import url="user/footer/footer.jsp" />
		</div>


	</div>

</body>
</html>
