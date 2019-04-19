<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
			<div class="areaFix">
				<div id="personalMenu">
					<ul>
						<li><a href="report.do">관리자 문의</a></li>
						<li><a href="join.do">회원가입</a></li>
						<li><a href="login.do">로그인</a></li>
					</ul>
				</div>
				<div id="headerContent">
					<a href="main.do"><img alt="로고" src="<c:url value="/resources/img/logo.png" />" id="logoImg"></a>
					<span id="searchWindow">
						<input type='text' class='input_text' />
						<button type='submit' class='sch_smit'>검색</button>
					</span>
				</div>
			</div>