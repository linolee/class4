<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Class4-회원가입</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- css -->
<link href="<c:url value="/resources/css/join.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/header.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/footer.css" />"
	rel="stylesheet">
<!-- google font -->
<link href="https://fonts.googleapis.com/css?family=PT+Sans"
	rel="stylesheet">
<style type="text/css">
#wrapper {
	font-family: 'PT Sans', sans-serif;
}
</style>

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<c:import url="../header/header.jsp"></c:import>
		</div>
		<div id="container">
			<div class="areaFix">
				<div id="joinDiv">
					<div id="memberJoinInputDiv">
						<h3>회원가입</h3>
						<ul>
							<li><label>아이디</label><br> <input type="text"
								id="input_id" class="inputBox"></li>
							<li><label>비밀번호</label><br> <input type="password"
								id="input_pass" class="inputBox"></li>
							<li><label>비밀번호 재확인</label><br> <input type="password"
								id="input_pass2" class="inputBox"></li>
							<li><label>이름</label><br> <input type="text"
								id="input_name" class="inputBox"></li>
							<li><label>생년월일</label><br> <input type="text"
								id="input_year" class="inputBox">년 <select
								id="input_month" class="selectBox">
									<c:forEach var="i" begin="1" end="12">
										<option><c:out value="${i}" /></option>
									</c:forEach>
							</select>월 <select id="input_day" class="selectBox">
									<c:forEach var="i" begin="1" end="31">
										<option><c:out value="${i}" /></option>
									</c:forEach>
							</select>일</li>
							<li><label>성별</label><br> <select id="input_gender"
								class="selectBox">
									<option>남자</option>
									<option>여자</option>
							</select></li>
							<li><label>휴대전화</label><br> <input type="text"
								id="input_phone" class="inputBox"></li>
							<li><label>이메일</label><br>
							<input type="text" id="input_email" class="inputBox"></li>
							<li><label>관심사</label><br> <input type="checkbox"
								class="checkBox">스포츠 <input type="checkbox"
								class="checkBox">음악 <input type="checkbox"
								class="checkBox">미술 <input type="checkbox"
								class="checkBox">요리 <%-- <c:forEach var="" items=""></c:forEach> --%>
							</li>

						</ul>
					</div>
					<div id="joinBtnDiv">
						<a href="#void" id="inputBtn">회원가입</a>
					</div>
				</div>
			</div>
		</div>
		<div id="footer">
			<c:import url="../footer/footer.jsp" />
		</div>


	</div>

</body>
</html>
