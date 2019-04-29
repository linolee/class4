<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>당신을 위한 수업 Class4</title>
<!-- Bootstrap core CSS -->
<link
	href="<c:url value="/resources/startbootstrap-modern-business-gh-pages/vendor/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link
	href="<c:url value="/resources/startbootstrap-modern-business-gh-pages/css/modern-business.css" />"
	rel="stylesheet">
<!-- CSS -->
<link href="<c:url value="/resources/css/join.css" />" rel="stylesheet">
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

	function checkId() {//id가 중복되는지, 길이는 맞는지 체크
		//DB로 중복되는지 체크해야함. ajax나 json필요.
		return true;
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

	function CheckTel() {//하나라도 공백이거나 null이면 false
		return ($('#input_tel1').val().trim() != ''
				&& $('#input_tel1').val().trim() != null
				&& $('#input_tel2').val().trim() != ''
				&& $('#input_tel2').val().trim() != null
				&& $('#input_tel3').val().trim() != '' && $('#input_tel3')
				.val().trim() != null)
	}

	function CheckMail() {
		return ($('#input_email').val().trim() != ''
				&& $('#input_email').val().trim() != null
				&& $('#input_domain').val().trim() != '' && $('#input_domain')
				.val().trim() != null)
	}

	function CheckJoin() {
		if (checkId() && CheckPassword() && CheckName() && CheckBirth()
				&& CheckTel() && CheckMail()) {
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
		<div class="container my-5">
					<!-- Page Heading/Breadcrumbs -->
					<h1 class="mt-4 mb-3">
						회원 가입 <small>Join</small>
					</h1>

					<ol class="breadcrumb">
						<li class="breadcrumb-item active">메인</li>
						<li class="breadcrumb-item active">회원 가입</li>
					</ol>

			<div class="areaFix">
				<div id="joinDiv">
					<form action="memberJoin.do" id="joinFrm" method="post">
					<div id="memberJoinInputDiv">
						<ul>
							<li>
								<label>아이디</label><br>
								<input type="text" class="form-control" placeholder="UserID" aria-label="UserID" aria-describedby="basic-addon1" name="client_id">
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
								<input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1" onchange="CheckPassword()" name="name" id="input_name">
							</li>
							<li>
								<label>생년월일</label><br>
								<div class="input-group">
								  <input type="text" aria-label="Year" placeholder="Year" class="form-control" name="birth" id="input_year">
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
								<select class="form-control d-inline" id="input_tel1" name="tel">
									<option>010</option>
									<option>011</option>
									<option>016</option>
									<option>017</option>
									<option>018</option>
									<option>019</option>
								</select>-
								<input type="text" name="tel" class="form-control d-inline" id="input_tel2">-
								<input type="text" name="tel" class="form-control d-inline" id="input_tel3">
							</li>
							<li>
								<label>이메일</label><br>
								<input type="text" id="input_email" class="form-control d-inline" name="email">@
								<input type="text" id="input_domain" class="form-control d-inline" value="" placeholder="직접 입력" name="email">
								<select id="emailSelect" onchange="ChangeDomain()" class="form-control d-inline">
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


	</div>

</body>
</html>
