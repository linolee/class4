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
	
</script>

<body>
	<div id="wrapper">
		<div id="header">
			<c:import url="../header/header.jsp"></c:import>
		</div>
		<div class="container my-5" id="container">
			<!-- Page Heading/Breadcrumbs -->
			<h1 class="mt-4 mb-3">
				비밀번호 찾기 결과
			</h1>

			<div class="card text-center">
				<div class="card-header"></div>

				<form action="findIDResult.do" method="post" id="frm">
					<div class="card-body text-center">
						<div class="input-group mb-3 col-lg-5 mx-auto">
							<c:choose>
								<c:when test="${ flag eq false }">
									<strong>입력된 정보로 검색된 회원이 없습니다.</strong>
								</c:when>
								<c:otherwise>
									입력하신 이메일(<strong><c:out value="${ email }"/></strong>)로 임시 비밀번호를 발송하였습니다.<br>
									메일을 확인하여 로그인 해 주시기 바랍니다.
								</c:otherwise>
							</c:choose> 
						</div>
					</div>
				</form>

				<div class="card-footer text-center">
					<button type="button" class="btn btn-outline-secondary"
						onclick="location.href='loginPage.do'">로그인 화면으로</button>
 					<button type="button" class="btn btn-outline-secondary"
						onclick="location.href='findID.do'">아이디 찾기</button>
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
