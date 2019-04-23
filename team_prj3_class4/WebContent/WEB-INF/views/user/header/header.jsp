<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!
	/* String serverDomain = "http://211.63.89.152:8080"; */
	String serverDomain = "http://localhost:8080";
	/* 바꿀 때 푸터도 바꿀 것 */
%>
			<div class="areaFix">
				<div id="personalMenu">
					<ul>
						<li><a href="<%= serverDomain %>/team_prj3_class4/user/member/guest_report.do">관리자 문의</a></li>
						<li><a href="<%= serverDomain %>/team_prj3_class4/user/member/join.do">회원가입</a></li>
						<li><a href="<%= serverDomain %>/team_prj3_class4/user/member/loginPage.do">로그인</a></li>
					</ul>
				</div>
				<div id="headerContent">
					<a href="<%= serverDomain %>/team_prj3_class4/user/main.do"><img alt="로고" src="<c:url value="/resources/img/logo.png" />" id="logoImg"></a>
					<span id="searchWindow">
						<input type='text' class='input_text' />
						<button type='submit' class='sch_smit'>검색</button>
					</span>
				</div>
			</div>