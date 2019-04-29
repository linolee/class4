<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!/* String serverDomain = "http://211.63.89.152:8080"; */
	String serverDomain = "http://localhost:8080";
	/* 바꿀 때 푸터도 바꿀 것 */%>
<div class="areaFix">
	<!-- Navigation -->
	<nav
		class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark text-white fixed-top">
		<div class="container">
			<a class="navbar-brand" href="<%=serverDomain%>/team_prj3_class4/user/main.do">Class4</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<form class="form-inline">
				  <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
				  <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
				</form>
				<ul class="navbar-nav ml-auto">
				<c:choose>
				<c:when test="${sessionScope.client_id ne null }">
					<!-- 로그인이 되어 있을 때 -->
					<li class="nav-item">
						<a class="nav-link" href="<%=serverDomain%>/team_prj3_class4/user/member/logout.do">로그아웃</a>
					</li>
					<li class="nav-item dropdown">
					  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					    	마이 페이지
					  </a>
					  <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
					    <a class="dropdown-item" href="<%=serverDomain%>/team_prj3_class4/user/student/mypage_list.do">학생 페이지</a>
					    <a class="dropdown-item" href="<%=serverDomain%>/team_prj3_class4/user/teacher/teacherPage.do">선생님 페이지</a>
					    <a class="dropdown-item" href="<%=serverDomain%>/team_prj3_class4/user/member/userPage.do">회원 정보</a>
					  </div>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="<%=serverDomain%>/team_prj3_class4/user/member/report.do">관리자 문의</a>
				</c:when>
				<c:when test="${sessionScope.client_id eq null }">
					<!-- 로그인이 되어 있지 않을 때 -->
					<li class="nav-item">
						<a class="nav-link" href="<%=serverDomain%>/team_prj3_class4/user/member/loginPage.do">로그인</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="<%=serverDomain%>/team_prj3_class4/user/member/joinAgreement.do">회원가입</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="<%=serverDomain%>/team_prj3_class4/user/member/guest_report.do">관리자 문의</a>
					</li>
				</c:when>
				</c:choose>
				
				</ul>
			</div>
		</div>
	</nav>
	<!-- Bootstrap core JavaScript -->
	<script src="<c:url value="/resources/startbootstrap-modern-business-gh-pages/vendor/jquery/jquery.min.js" />"></script>
	<script src="<c:url value="/resources/startbootstrap-modern-business-gh-pages/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>
</div>