<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Class4-회원 페이지</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- css -->
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/userPage.css" />"
	rel="stylesheet">
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

<!-- summerNote -->
<!-- include libraries(jQuery, bootstrap) -->
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
<!-- include summernote css/js -->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.js"></script>

<!-- tab -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
  var jb = jQuery.noConflict();
</script>

<script type="text/javascript">
$(function(){
	
	$("#changePasswordBtn").click(function (){
		if (CheckPassword()) {
			$.ajax({
				type:"POST",
				url:"changePassword.do",
				data : {password : $('#pass1').val()},
				dataType : "json",
				success: function(json){
					if (json.resultFlag) {
						$('#pass0').val("");
						$('#pass1').val("");
						$('#pass2').val("");
						alert('비밀번호가 정상적으로 변경되었습니다.');
					}else{
						alert('비밀번호가 정상적으로 변경되지 않았습니다. 잠시 후에 다시 시도해주세요.');
					}
				},
				error: function(xhr) {
					console.log(xhr.status);
				}	
			});
		}else{
			alert("비밀번호를 다시 확인해주세요.");
		}
	});
	
	$("#pass0").change(function (){
		$.ajax({
			type:"POST",
			url:"checkPassword.do",
			data : {password : $('#pass0').val()},
			dataType : "json",
			success: function(json){
				if (json.resultFlag) {
					$('#passwordWarning0').text('');
				}else{
					$('#passwordWarning0').text('비밀번호가 일치하지 않습니다.').css("color", "red");
				}
			},
			error: function(xhr) {
				console.log(xhr.status);
			}	
		});
	});
	
	$("#reportSubmitBtn").click(function (){
		$.ajax({
			type:"POST",
			url:"memberReportSubmit.do",
			data : {q_subject : $('#reportSubject').val(), q_contents : $('#summernote').summernote('code')},
			dataType : "json",
			success: function(json){
				if (json.resultFlag) {
					$('#reportSubject').val("");
					$('#summernote').summernote('code', "");
					alert('문의가 정상적으로 제출되었습니다.');
				}else{
					alert('문의가 제출되지 않았습니다. 잠시 후에 다시 시도해주세요.');
				}
			},
			error: function(xhr) {
				console.log(xhr.status);
			}	
		});
	});
	
	jb("#tabs").tabs();
	
	$('#summernote').summernote({
		placeholder : '신고 내용을 입력해주세요.',
		tabsize : 2,
		height : 300
	});
	
	$("#deleteClientInfoBtn").click(function(){
		location.href = "deleteUserAgreement.do"
	});
	
});//ready

function CheckPassword() {
	var passwordFlag = false;
	if ($('#pass1').val() != $('#pass2').val()) {//비밀번호가 서로 같은지 체크
		$('#passwordWarning').text('비밀번호가 서로 다릅니다.').css("color", "red");
		passwordFlag = false;
	} else {
		if ($('#pass1').val().length < 4
				|| $('#pass1').val().length > 13) {//비밀번호 길이를 체크
			$('#passwordWarning').text('4~13자 사이의 비밀번호를 입력해주세요.').css("color", "red");
			passwordFlag = false;
		} else {
			$('#passwordWarning').text('');
			passwordFlag = true;
		}
	}
	return passwordFlag;
}

</script>	
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<c:import url="../header/header.jsp"></c:import>
		</div>
		<div id="container">
			<div class="areaFix">
				<div id="userPage">

					<label>회원 페이지</label>
					<div id="tabs">
						<ul>
							<li><a href="#fragment-1"><span>회원정보</span></a></li>
							<li><a href="#fragment-2"><span>비밀번호 변경</span></a></li>
							<li><a href="#fragment-3"><span>관리자 문의</span></a></li>
						</ul>
						<div id="fragment-1">
							<table>
								<tr>
									<th>이름</th>
									<td colspan="${fn:length(client_favor) }">${clientInfo.name}</td>
								</tr>
								<tr>
									<th>아이디</th>
									<td colspan="${fn:length(client_favor) }">${clientInfo.client_id }</td>
								</tr>
								<tr>
									<th>생년월일</th>
									<td colspan="${fn:length(client_favor) }">${clientInfo.birth }</td>
								</tr>
								<tr>
									<th>휴대전화</th>
									<td colspan="${fn:length(client_favor) }">${clientInfo.tel }</td>
								</tr>
								<tr>
									<th>이메일</th>
									<td colspan="${fn:length(client_favor) }">${clientInfo.email }</td>
								</tr>
								<tr>
									<th>관심목록</th>
									<c:if test="${fn:length(client_favor) == 0}">
										<td>관심 목록이 없습니다.</td>
									</c:if>
									<c:forEach var="favor" items="${client_favor }">
										<td>${favor }</td>
									</c:forEach>
								</tr>
							</table>
							<input type="button" value="회원정보 수정" id="changeClientInfoBtn" class="inputBtn">
							<input type="button" value="회원 탈퇴" id="deleteClientInfoBtn" class="inputBtn">
						</div>
						<div id="fragment-2">
							<table>
								<tr>
									<td>현재 비밀번호 입력</td>
									<td><input type="password" id="pass0"></td>
								</tr>
								<tr>
									<td colspan="2"><label id="passwordWarning0"></label></td>
								</tr>
								<tr>
									<td>비밀번호 입력</td>
									<td><input type="password" id="pass1" onchange="CheckPassword()"></td>
								</tr>
								<tr>
									<td>비밀번호 재입력</td>
									<td><input type="password" id="pass2" onchange="CheckPassword()"></td>
								</tr>
								<tr>
									<td colspan="2"><label id="passwordWarning"></label></td>
								</tr>
							</table>
							<br> <input type="button" value="비밀번호 변경" id="changePasswordBtn" class="inputBtn">
						</div>
						<div id="fragment-3">

							<input type="text" id="reportSubject" placeholder="제목을 입력해주세요.">
							<div id="summernote"></div>
							<div id="reportBtnDiv">
								<input type="button" value="제출하기" id="reportSubmitBtn" class="inputBtn">
							</div>
						</div>
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