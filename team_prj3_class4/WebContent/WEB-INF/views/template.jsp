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
<link href="<c:url value="/resources/startbootstrap-modern-business-gh-pages/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="<c:url value="/resources/startbootstrap-modern-business-gh-pages/vendor/bootstrap/css/modern-business.css" />" rel="stylesheet">
<!-- CSS -->
<link href="<c:url value="/resources/css/joinAgreement.css" />" rel="stylesheet">
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
		}else{
			$('#JoinAgreementFrm').submit();
		}

	}
</script>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<c:import url="user/header/header.jsp"></c:import>
		</div>
		<div id="container">
			<div class="areaFix">
				<h3>약관동의</h3>
				<form action="join.do" id="JoinAgreementFrm" name="joinAgreementFrm">
					<div id="agreementDiv">
						<ul id="agreementList">
							<li class="agreementSubject">약관1<br> <textarea rows="20"
									readonly="readonly">
								약관내용 어쩌고저쩌고
							</textarea></li>
							<li><input type="checkbox" class="checkBox" name="agreeCheckBox">약관에 동의합니다.</li>
							<li class="agreementSubject">약관2<br> <textarea rows="20"
									cols="200" readonly="readonly">
								약관내용 어쩌고저쩌고
							</textarea>
							</li>
							<li><input type="checkbox" class="checkBox" name="agreeCheckBox">약관에 동의합니다.</li>
							<li class="agreementSubject">약관3<br> <textarea rows="20"
									cols="200" readonly="readonly">
								약관내용 어쩌고저쩌고
							</textarea>
							</li>
							<li><input type="checkbox" class="checkBox" name="agreeCheckBox">약관에 동의합니다.</li>
	
						</ul>
						<input type="button" id="agreementBtn" value="다음단계" onclick="CheckForm()">
	
					</div>
				</form>
			</div>
		</div>
		<div id="footer">
			<c:import url="user/footer/footer.jsp" />
		</div>


	</div>

</body>
</html>
