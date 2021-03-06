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
<script type="text/javascript">
$(function() {
	$("[name=id]").val("${param.id}");
	if ("${param.result}" == 'success') {
		history.back();
	}
	
});
</script>
</head>
<style type="text/css">
body {padding-top: 0px;}
</style>
<body>
	<div id="wrapper">
		<div id="header">
			<c:import url="../header/header.jsp"></c:import>
		</div>
		<div class="container my-5" id="container">
			<!-- Page Heading/Breadcrumbs -->
			<h1 class="mt-4 mb-3">
				회원 로그인 <small>Login</small>
			</h1>

			<div class="card text-center">
				<div class="card-header">
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
				<form action="login.do" method="post">
					<div class="card-body text-center">
						<div class="input-group mb-3 col-lg-3 mx-auto">
							<input type="text" class="form-control"
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-default" placeholder="아이디"
								name="id">
						</div>
						<div class="input-group mb-3 col-lg-3 mx-auto">
							<input type="password" class="form-control"
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-default" placeholder="비밀번호"
								name="pass">
						</div>
					</div>
					<div class="card-footer text-muted">
						<button type="submit" class="btn btn-secondary btn-lg">로그인</button>
					</div>
					<div class="card-footer text-muted">
						<button type="button" class="btn btn-outline-secondary" onclick="location.href='findID.do'">아이디
							찾기</button>
						<button type="button" class="btn btn-outline-secondary" onclick="location.href='findPass.do'">비밀번호
							찾기</button>
						<button type="button" class="btn btn-outline-primary" onclick="location.href='joinAgreement.do'">회원
							가입</button>
					</div>
				</form>
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
