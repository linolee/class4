<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/team_prj3_class4/resources/css/class.css">
<script type="text/javascript">
var d = 0;
function addCareer() {
	if ($("#inputCareer").val() == '' || $("#inputCareer").val() == undefined) {
		alert("경력사항을 입력해주세요");
		return false;
	}
	
	$("#addProfileFrm").css("height", "640px");
	$("#careerList").show();
	var career = $("#inputCareer").val();
	
	var str = "";
	str += "<div class='careerDiv'>";
	str += 		"<span class='career'>"+career+"</span>";
	str += 		'<input type="button" value="삭제" class="btn btn-danger" id="delCareer" onclick="delCareer('+d+')">';
	str += "</div>";
	
	$("#inputCareer").val("");
	$("#careerList").append(str);
}

function closeModal() {
	$(".inputBox").val("");
	$(".classField").find("option:eq(0)").prop("selected", true);
	$("#teacher-intro").val("");
	$("#careerList").children().each(function() {
		$(this).remove();
	});
	$("#careerList").hide();
	$("#addProfileFrm").css("height", "480px");
}

$(document).ready(function() {
	$("#careerList").hide();
});
</script>

<div id="addProfileFrm">
	<div>
		<div class="picture-area">
			<div class="picture-panel">
				<span>사진</span>
			</div>
			<div class="picture-btn">
				<input type="button" value="사진등록" class="btn btn-primary" id="picUpload"><br>
			</div>
		</div>
		<div class="teacher-info">
			<div class="teacher-info-name-area">
				<div class="teacher-info-name">
					<span>프로필명</span>
					<input type="text" name="teacherName" class="inputBox">
					<input type="button" value="중복확인" class="btn btn-primary" id="doubleCheck">
				</div> 
			</div>
			<div class="teacher-edu">
				<span>교육분야</span>
				<select name="classField" class="classField">
					<option>========== 선택 ==========</option>
					<option>선택해주세요</option>
					<option>선택해주세요</option>
				</select>
			</div>
			<div class="teacher-career">
				<span>경력사항</span>
				<input type="text" name="inputCareer" id="inputCareer" class="inputBox">
				<input type="button" value="추가" class="btn btn-primary" id="addCareer" onclick="addCareer()">
				<div id="careerList"><!-- 경력 --></div>
			</div>
			<div class="teacher-intro-area">
				<span>자기소개</span>
				<textarea id="teacher-intro"></textarea>
			</div>
			<div style="text-align: center;">
				<input type="button" value="등록신청" class="btn btn-warning" name="btnApply">
				<input type="button" value="취소" class="btn btn-warning" name="btnClose" onclick="closeModal()">
			</div>
		</div>
	</div>
</div>