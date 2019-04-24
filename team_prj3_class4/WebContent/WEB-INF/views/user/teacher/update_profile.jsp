<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="updateProfileFrm">
	<div>
		<!-- margin: 0px auto; -->
		<div style="width: 100px; height: 120px; border: 1px solid #333; margin: 0px auto; margin-bottom: 10px;">
			사진
		</div>
		<div style="text-align: center;">
			<input type="button" value="사진 수정" class="btn" id="picUpload"><br>
		</div>
		<div style="margin-top: 10px;">
			강사명 
			<input type="text" name="teacherName" class="inputBox"><br><br>
			교육분야
			<input type="text" readonly="readonly" class="inputBox"><br>
		</div>
		<hr color="#888888">
		<div style="margin-top: 10px;">
			경력사항
			<input type="text" name="inputCareer" class="inputBox">
			<input type="button" value="추가" class="btn" id="addCareer"><br><br>
			<div id="careerList">
			</div>
			<input type="button" value="삭제" class="btn" id="delCareer" style="float: right;"><br>
		</div>
		<hr color="#888888">
		<div>
			자기소개<br>
			<textarea style="width: 300px; height: 150px;">
			</textarea><br><br>
		</div>
	</div>
	<div style="text-align: center;">
		<input type="button" value="수정신청" class="btn" name="btnUpdate">
		<input type="button" value="삭제" class="btn" name="btnDelete">
		<input type="button" value="취소" class="btn" name="btnClose">
	</div>

</div>