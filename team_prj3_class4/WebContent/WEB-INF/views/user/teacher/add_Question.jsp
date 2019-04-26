<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="addQuestionFrm">
	<div>
		<!-- margin: 0px auto; -->
		<div>
			<strong>제목</strong>
			<input type="text" class="inputBox"><br/>
		</div>
		<hr color="#888888">
			<textarea style="width: 300px; height: 200px;">내용을 입력하세요.</textarea><br/>
	</div>
		<div style="text-align: center;">
			<input type="button" value="문의등록" class="btn" name="btnAdd">
			<input type="button" value="취소" class="btn" name="btnClose">
		</div>

</div>