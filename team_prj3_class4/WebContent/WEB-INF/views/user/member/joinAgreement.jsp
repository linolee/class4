<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
<script type="text/javascript">
	function CheckForm() {

		//체크박스 체크여부 확인 [동일 이름을 가진 체크박스 여러개일 경우]
		var isAllChecked = true;
		var arr_agreeCheckBox = $('input[name=agreeCheckBox]');
		for (var i = 0; i < arr_agreeCheckBox.length; i++) {
			if (arr_agreeCheckBox[i].checked == false) {
				isAllChecked = false;
				break;
			}
		}

		if (!isAllChecked) {
			alert("모든 약관에 동의해주세요.");
			return false;
		} else {
			$('#JoinAgreementFrm').submit();
		}

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
				<div class="container my-5">
					<!-- Page Heading/Breadcrumbs -->
					<h1 class="mt-4 mb-3">
						회원 약관 동의 <small>Login</small>
					</h1>

					<ol class="breadcrumb">
						<li class="breadcrumb-item active">메인</li>
						<li class="breadcrumb-item active">회원 약관 동의</li>
					</ol>
					<form action="join.do" id="JoinAgreementFrm" name="joinAgreementFrm">
						
						<div id="agreementDiv" class="container my-5">
							<div class="input-group">
							  <div class="input-group-prepend">
							    <span class="input-group-text">약관 1</span>
							  </div>
							  <textarea class="form-control" aria-label="With textarea" readonly="readonly" rows="10">
약관 내용 어쩌고 저쩌고
이러쿵 저러쿵
소ㅑㄹ라소ㅑㄹ라
당신의 장기
클래스4의 자산으로
대체되었다.
							  </textarea>
							</div>
							<div class="container my-5 text-center">
								  약관 내용에 동의합니다.
							  	<input type="checkbox" aria-label="Checkbox for following text input" name="agreeCheckBox">
							</div>
							<div class="input-group">
							  <div class="input-group-prepend">
							    <span class="input-group-text">약관 2</span>
							  </div>
							  <textarea class="form-control" aria-label="With textarea" readonly="readonly" rows="10">
약관 내용 어쩌고 저쩌고
이러쿵 저러쿵
소ㅑㄹ라소ㅑㄹ라
당신의 장기
클래스4의 자산으로
대체되었다.
							  </textarea>
							</div>
							<div class="container my-5 text-center">
								  약관 내용에 동의합니다.
							  	<input type="checkbox" aria-label="Checkbox for following text input" name="agreeCheckBox">
							</div>
							<div class="input-group">
							  <div class="input-group-prepend">
							    <span class="input-group-text">약관 3</span>
							  </div>
							  <textarea class="form-control" aria-label="With textarea" readonly="readonly" rows="10">
약관 내용 어쩌고 저쩌고
이러쿵 저러쿵
소ㅑㄹ라소ㅑㄹ라
당신의 장기
클래스4의 자산으로
대체되었다.
							  </textarea>
							</div>
							<div class="container my-5 text-center">
								  약관 내용에 동의합니다.
							  	<input type="checkbox" aria-label="Checkbox for following text input" name="agreeCheckBox">
							</div>
							<div class="container my-5 text-center">
								<input class="btn btn-primary btn-lg" type="button" id="agreementBtn" value="다음단계"
									onclick="CheckForm()">
							</div>

						</div>
					</form>
				</div>
			</div>
			<div id="footer">
				<c:import url="../footer/footer.jsp" />
			</div>
		</div>
	</div>

</body>
</html>
