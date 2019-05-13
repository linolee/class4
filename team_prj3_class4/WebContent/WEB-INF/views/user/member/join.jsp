<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>당신을 위한 수업★Class4★</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- css -->
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/join.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/header.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/footer.css" />" rel="stylesheet">
<!-- google font -->
<link href="https://fonts.googleapis.com/css?family=PT+Sans"
	rel="stylesheet">
<!-- Bootstrap core CSS -->
<link
	href="<c:url value="/resources/startbootstrap-modern-business-gh-pages/vendor/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link
	href="<c:url value="/resources/startbootstrap-modern-business-gh-pages/css/modern-business.css" />"
	rel="stylesheet">
<!-- CSS -->
<style type="text/css">
body {padding-top: 0px;}
</style>
<script type="text/javascript">

	function ChangeDomain() {
		$('#input_domain').val($('#emailSelect').val());
		$('#input_domain').attr('readonly', 'readonly');
		if ($('#emailSelect').val() == "직접 입력") {
			$('#input_domain').val('');
			$('#input_domain').attr('placeholder', '직접 입력');
			$('#input_domain').removeAttr('readonly');
		}
	}
	idFlag = true;
	function CheckId() {//id가 중복되는지, 길이는 맞는지 체크
		//DB로 중복되는지 체크
		//json으로 id를 보낸다
		$.ajax({
			type:"POST",
			url:"checkId.do",
			data : {client_id : $('#client_id').val()},
			dataType : "json",
			success: function(json){
				if (json.checkId) {//아이디가 이미 존재 하면
					$('#idWarning').text("이미 사용 중인 아이디입니다.").css("color", "red");
					idFlag = false;
				}else{
					$('#idWarning').text("사용 가능한 아이디입니다.").css("color", "green");
					idFlag = true;
				}
			},
			error: function(xhr) {
				console.log(xhr.status);
			}	
		});
		return idFlag;
	}

	function CheckPassword() {
		var passwordFlag = false;
		if ($('#input_pass').val() != $('#input_pass2').val()) {//비밀번호가 서로 같은지 체크
			$('#passwordWarning').text('비밀번호가 서로 다릅니다.');
			passwordFlag = false;
		} else {
			if ($('#input_pass').val().length < 4
					|| $('#input_pass').val().length > 13) {//비밀번호 길이를 체크
				$('#passwordWarning').text('4~13자 사이의 비밀번호를 입력해주세요.');
				passwordFlag = false;
			} else {
				$('#passwordWarning').text('');
				passwordFlag = true;
			}
		}
		return passwordFlag;
	}

	function CheckName() {//널이나 공백이 아니면 true를 반환
		return ($('#input_name').val().trim() != '' && $('#input_name').val()
				.trim() != null)
	}

	function CheckBirth() {
		return ($('#input_year').val().trim() != '' && $('#input_year').val()
				.trim() != null)
	}
	telFlag = true;
	function CheckTel() {//하나라도 공백이거나 null이면 false
		$.ajax({
			type:"POST",
			url:"checkTel.do",
			data : {tel : $('#input_tel1').val()+"-"+$('#input_tel2').val()+"-"+$('#input_tel3').val()},
			dataType : "json",
			success: function(json){
				if (json.checkTel) {
					$('#telWarning').text("이미 사용 중인 전화번호입니다.").css("color", "red");
					telFlag = false;
				}else{
					$('#telWarning').text("사용 가능한 전화번호입니다.").css("color", "green");
					telFlag = true;
				}
			},
			error: function(xhr) {
				console.log(xhr.status);
			}	
		});
		
		
		return ($('#input_tel1').val().trim() != ''
				&& $('#input_tel1').val().trim() != null
				&& $('#input_tel2').val().trim() != ''
				&& $('#input_tel2').val().trim() != null
				&& $('#input_tel3').val().trim() != '' && $('#input_tel3')
				.val().trim() != null && telFlag)
	}
	
	emailFlag = true;
	function CheckEmail() {
		$.ajax({
			type:"POST",
			url:"checkEmail.do",
			data : {email : $('#input_email').val().trim()+"@"+$('#input_domain').val().trim()},
			dataType : "json",
			success: function(json){
				if (json.checkEmail) {//아이디가 이미 존재 하면
					$('#emailWarning').text("이미 사용 중인 이메일입니다.").css("color", "red");
					emailFlag = false;
				}else{
					$('#emailWarning').text("사용 가능한 이메일입니다.").css("color", "green");
					emailFlag = true;
				}
			},
			error: function(xhr) {
				console.log(xhr.status);
			}	
		});
		return ($('#input_email').val().trim() != ''
				&& $('#input_email').val().trim() != null
				&& $('#input_domain').val().trim() != '' && $('#input_domain')
				.val().trim() != null && emailFlag)
	}

	function CheckJoin() {
		if (CheckId() && CheckPassword() && CheckName() && CheckBirth()
				&& CheckTel() && CheckEmail()) {
			$('#joinFrm').submit();
		} else {
			alert("양식을 다시 확인해주세요.");
		}
	}
</script>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<c:import url="../header/header.jsp"/>
		</div>

			<div class="areaFix">
				<div id="joinDiv">
					<form action="memberJoin.do" id="joinFrm" method="post">
					<div id="memberJoinInputDiv">
						<ul>
							<li>
								<label>아이디</label><br>
								<input type="text" class="form-control" placeholder="UserID" aria-label="UserID" aria-describedby="basic-addon1" id="client_id" name="client_id" onchange="CheckId()" maxlength="20">
							</li>
							<li>
								<label class="warning" id="idWarning"></label>
							</li>
							<li>
								<label>비밀번호</label><br>
								<input type="password" class="form-control" placeholder="Password" aria-label="Password" aria-describedby="basic-addon1" onchange="CheckPassword()" name="pass" id="input_pass">
							</li>
							<li>
								<label>비밀번호 재확인</label><br>
								<input type="password" class="form-control" placeholder="Password" aria-label="Password" aria-describedby="basic-addon1" onchange="CheckPassword()" id="input_pass2">
							</li>
							<li>
								<label class="warning" id="passwordWarning"></label>
							</li>
							<li>
								<label>이름</label><br> 
								<input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1" onchange="CheckPassword()" name="name" id="input_name" maxlength="30">
							</li>
							<li>
								<label>생년월일</label><br>
								<div class="input-group">
								  <input type="text" aria-label="Year" placeholder="Year" class="form-control" name="birth" id="input_year" maxlength="4">
								  <div class="input-group-append">
								    <span class="input-group-text">년</span>
								  </div>
								<select id="input_month" class="form-control" name="birth">
									<c:forEach var="i" begin="1" end="12">
									<option value="${i}"><c:out value="${i}" /></option>
									</c:forEach>
								</select>
								  <div class="input-group-append">
								    <span class="input-group-text">월</span>
								  </div>
								<select id="input_day" class="form-control" name="birth">
									<c:forEach var="i" begin="1" end="31">
									<option value="${i}"><c:out value="${i}" /></option>
									</c:forEach>
								</select>
								  <div class="input-group-append">
								    <span class="input-group-text">일</span>
								  </div>
								</div>
							<li>
								<label>성별</label><br>
								<select id="input_gender" class="form-control" name="gender">
									<option value="M">남자</option>
									<option value="F">여자</option>
								</select>
							</li>
							<li>
								<label>휴대전화</label><br>
								<select class="form-control d-inline" id="input_tel1" name="tel" onchange="CheckTel()">
									<option>010</option>
									<option>011</option>
									<option>016</option>
									<option>017</option>
									<option>018</option>
									<option>019</option>
								</select>-
								<input type="text" name="tel" class="form-control d-inline" id="input_tel2" maxlength="4" onchange="CheckTel()">-
								<input type="text" name="tel" class="form-control d-inline" id="input_tel3" maxlength="4" onchange="CheckTel()">
							</li>
							<li>
								<label class="warning" id="telWarning"></label>
							</li>
							<li>
								<label>이메일</label><br>
								<input type="text" id="input_email" class="form-control d-inline" name="email" maxlength="15" onchange="CheckEmail()">@
								<input type="text" id="input_domain" class="form-control d-inline" value="" placeholder="직접 입력" name="email" maxlength="15" onchange="CheckEmail()">
								<select id="emailSelect" onchange="ChangeDomain();CheckEmail()" class="form-control d-inline">
									<option>직접 입력</option>
									<c:forEach var="emailDomain" items="${emailDomainList }">
									<option value="${emailDomain }">${emailDomain }</option>
									</c:forEach>
								</select>
							</li>
							<li>
								<label class="warning" id="emailWarning"></label>
							</li>
							<li>
								<label>관심사</label><br>
								<table class="table table-striped">
									<c:forEach var="categorys" items="${categoryMapping }">
									<tr>
										<c:forEach var="category" items="${categorys}">
										<c:if test="${category ne null}">
										<td class="checkBoxTd"><input type="checkbox" class="checkBox mx-0" name="favors" value="${category }"></td>								
										<td>${category }</td>
										</c:if>
									</c:forEach>
									</tr>
									</c:forEach>
								</table>
							</li>
						</ul>
					</div>
					</form>
					<div id="joinBtnDiv">
						<input type="button" class="btn btn-primary btn-lg" value="회원 가입" onclick="CheckJoin()">
					</div>
				</div>
			</div>
		</div>
		<div id="footer">
			<c:import url="../footer/footer.jsp" />
		</div>


</body>
</html>
