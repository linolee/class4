<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!
	/* String serverDomain = "http://211.63.89.151:8080"; */
	String serverDomain = "http://localhost:8080";
	/* 바꿀 때 푸터도 바꿀 것 */
%>
			<div class="areaFix">
				<div id="personalMenu">
					<ul>
						<c:choose>
							<c:when test="${sessionScope.client_id ne null }"><!-- 로그인이 되어 있을 때 -->
								<li><a href="<%= serverDomain %>/team_prj3_class4/user/student/mypage_list.do">수강생 페이지</a></li>
								<li><a href="<%= serverDomain %>/team_prj3_class4/user/teacher/teacherPage.do">강사 페이지</a></li>
								<li><a href="<%= serverDomain %>/team_prj3_class4/user/member/userPage.do">회원정보</a></li>
								<li><a href="<%= serverDomain %>/team_prj3_class4/user/member/logout.do">로그아웃</a></li>
							</c:when>
							<c:otherwise><!-- 로그인이 되어 있지 않을 때 -->
								<li><a href="<%= serverDomain %>/team_prj3_class4/user/member/guest_report.do">관리자 문의</a></li>
								<li><a href="<%= serverDomain %>/team_prj3_class4/user/member/joinAgreement.do">회원가입</a></li>
								<li><a href="<%= serverDomain %>/team_prj3_class4/user/member/loginPage.do">로그인</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
				<div id="headerContent">
				<form action="<%= serverDomain %>/team_prj3_class4/user/search.do">
					<a href="<%= serverDomain %>/team_prj3_class4/user/main.do"><img alt="로고" src="<c:url value="/resources/img/logo.png" />" id="logoImg"></a>
					<span id="searchWindow">
						<input type='text' name="keyword" class='input_text' />
						<button type='submit' class='sch_smit'>검색</button>
					</span>
				</form>
				</div>
			</div>