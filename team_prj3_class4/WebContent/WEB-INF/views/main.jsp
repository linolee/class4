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
<link href="<c:url value="/resources/startbootstrap-modern-business-gh-pages/css/modern-business.css" />" rel="stylesheet">
<style type="text/css">
	#container{min-height: 780px;}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<c:import url="user/header/header.jsp"></c:import>
		</div>
		<div id="container">
			<div class="areaFix">
				<a href="member/userPage.do">회원정보</a><br>
				<a href="teacher/classStatus.do">강사마이페이지</a><br/>
				<a href="student/mypage_list.do">수강생마이페이지</a><br/>
				<a href="mainContents/mainContents.do">메인</a><br>
				<a href="member/testSession.do">세션 테스트</a>
			</div>
		</div>
		<div id="footer">
			<c:import url="user/footer/footer.jsp" />
		</div>


	</div>

</body>
</html>