<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="areaFix">
	<form action="">
	<div id="memberUpdateDiv">
		<div id="memberUpdateInputDiv">
			<h3>회원정보 수정</h3>
			<ul>
				<li><label>비밀번호</label><br> <input type="password"
					id="input_pass" class="inputBox"></li>
				<li><label>비밀번호 재확인</label><br> <input type="password"
					id="input_pass2" class="inputBox"></li>
				<li><label>휴대전화</label><br> <input type="text"
					id="input_phone" class="inputBox"></li>
				<li><label>이메일</label><br><input type="text"
					id="input_email" class="inputBox"></li>
				<li><label>관심사</label><br> <input type="checkbox"
					class="checkBox">스포츠 <input type="checkbox"
					class="checkBox">음악 <input type="checkbox" class="checkBox">미술
					<input type="checkbox" class="checkBox">요리 <%-- <c:forEach var="" items=""></c:forEach> --%>
				</li>

			</ul>
		</div>
		<div id="joinBtnDiv">
			<input type="button" value="회원정보 수정" id="inputBtn">
		</div>
	</div>
	</form>
</div>