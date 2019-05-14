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
<link href="<c:url value="/resources/css/header.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/footer.css" />"
	rel="stylesheet">
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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

</head>
<style type="text/css">
body {
	padding-top: 0px;
}
</style>
<script type="text/javascript">
	function findId() {
		var name = $("#name").val();
		var email = $("#email").val();
		if (name == null || name == '') {
			alert("이름을 입력해주세요.");
			$("#name").focus();
			return;
		}
		if (email == null || email == '') {
			alert("이메일을 입력해주세요.");
			$("#email").focus();
			return;
		}
		$("#frm").submit();
	}
</script>

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
				<div class="card-header"></div>

				<form action="findIDResult.do" method="post" id="frm">
					<div class="card-body text-center">
						<div class="input-group mb-3 col-lg-5 mx-auto">
 							<input type="text" class="form-control"
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-default" placeholder="이름"
								name="name" id="name">
						</div>
						<div class="input-group mb-3 col-lg-5 mx-auto">
							<input type="text" class="form-control"
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-default" placeholder="이메일"
								name="email" id="email">
						</div>
						<div class="input-group mb-3 col-lg-5 mx-auto">
							<button type="button" class="btn btn-secondary"
								style="margin: 0px auto;" onclick="findId()">아이디 찾기</button>
						</div>
					</div>
				</form>

				<div class="card-footer text-center">
					<button type="button" class="btn btn-outline-secondary"
						onclick="location.href='loginPage.do'">로그인 화면으로</button>
					<button type="button" class="btn btn-outline-secondary"
						onclick="location.href='findPass.do'">비밀번호 찾기</button>
					<button type="button" class="btn btn-outline-primary"
						onclick="location.href='joinAgreement.do'">회원 가입</button>
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