<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>당신을 위한 수업★Class4★</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- css -->
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/header.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/footer.css" />" rel="stylesheet">
<!-- google font -->
<link href="https://fonts.googleapis.com/css?family=PT+Sans"
	rel="stylesheet">
<!-- Bootstrap core CSS -->
<link
	href="<c:url value="/resources/startbootstrap-modern-business-gh-pages/vendor/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link
	href="<c:url value="/resources/startbootstrap-modern-business-gh-pages/css/modern-business.css" />"
	rel="stylesheet">
<!-- CSS -->
<!-- Bootstrap core CSS -->
<link
	href="<c:url value="/resources/startbootstrap-modern-business-gh-pages/vendor/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link
	href="<c:url value="/resources/startbootstrap-modern-business-gh-pages/css/modern-business.css" />"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

</head>
<style type="text/css">
body {padding-top: 0px;}
</style>
<body>
	<div id="wrapper">
		<div id="header">
			<c:import url="../header/header.jsp"></c:import>
		</div>
		<div class="container my-5">
			<!-- Page Heading/Breadcrumbs -->
			<h1 class="mt-4 mb-3">
				아이디 찾기 <small>Find ID</small>
			</h1>

			<div class="card text-center">
				<div class="card-header">
					아이디 조회 방법 선택
				</div>
					<div class="card-body text-center">
						<button type="button" class="btn btn-outline-secondary" onclick="location.href='findIdByEmail.do'"><i class="material-icons" style="font-size:50px">mail_outline</i><br>메일 주소로 찾기</button>
						<button type="button" class="btn btn-outline-secondary" onclick="location.href='findID.do'"><i class="material-icons" style="font-size:50px">phonelink_ring</i><br>휴대폰 번호로 찾기</button>
						
					</div>
					<div class="card-footer text-muted">
						<button type="button" class="btn btn-outline-secondary" onclick="location.href='loginPage.do'">로그인 화면으로</button>
						<button type="button" class="btn btn-outline-secondary" onclick="location.href='findPass.do'">비밀번호
							찾기</button>
						<button type="button" class="btn btn-outline-primary" onclick="location.href='joinAgreement.do'">회원
							가입</button>
					</div>
			</div>

			<!-- /.row -->

		</div>
		<!-- /.container -->

		<div id="footer">
			<c:import url="../footer/footer.jsp" />
		</div>


	</div>

</body>
</html>
