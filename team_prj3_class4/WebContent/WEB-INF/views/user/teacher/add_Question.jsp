<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="addQuestionFrm">
	<div class="qnaContentsForm">
		<div>
			<strong>제목</strong>
			<input type="text" class="qnaFormTitle"><br/>
		</div>
		<hr color="#888888">
		<textarea id="qnaTxtArea" placeholder="내용을 입력하세요."></textarea><br/>
	</div>
	<div style="text-align: center;">
		<input type="button" value="문의등록" class="btn btn-warning" name="btnAdd">
		<input type="button" value="취소" class="btn btn-warning" name="btnClose" onclick="clearModal()">
	</div>
</div>