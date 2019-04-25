<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Class4-약관동의</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- css -->
<link href="<c:url value="/resources/css/agreement.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
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
			<c:import url="../header/header.jsp"></c:import>
		</div>
		<div id="container">
			<div class="areaFix">
				<h3>약관동의</h3>
				<form action="join.do" id="JoinAgreementFrm" name="joinAgreementFrm">
					<div id="agreementDiv">
						<ul id="agreementList">
							<li class="agreementSubject">약관1<br> <textarea rows="20"
									readonly="readonly">
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
								블라블라
								오오
								1
								2
								3
								4
								5
								6
								7
								8
								9
								10
								11
								12
								13
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
			<c:import url="../footer/footer.jsp" />
		</div>


	</div>

</body>
</html>
