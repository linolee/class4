<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Class4-관리자 문의</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- css -->
<link href="<c:url value="/resources/css/report.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/header.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/footer.css" />" rel="stylesheet">
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

<script type="text/javascript">
$(function(){
	$("#reportSubmitBtn").click(function (){
		$.ajax({
			type:"POST",
			url:"guestReportSubmit.do",
			data : {guest_email : $('#reportEmail').val(), q_subject : $('#reportSubject').val(), q_contents : $('#summernote').summernote('code')},
			dataType : "json",
			success: function(json){
				if (json.resultFlag) {
					$('#reportEmail').val("");
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
	
});//ready

</script>	
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<c:import url="../header/header.jsp"></c:import>
		</div>
		<div id="container">
			<div class="areaFix">
				<h3>관리자 문의</h3>
				<input type="text" id="reportSubject" placeholder="제목을 입력해주세요.">
				<input type="text" id="reportEmail" placeholder="회신을 받을 이메일을 입력해주세요.">
				<div id="summernote"></div>
				<script>
					$('#summernote').summernote({
						placeholder : '문의 내용을 입력해주세요.',
						tabsize : 2,
						height : 300
					});
				</script>
				<div id="reportBtnDiv">
					<input type="button" value="제출하기" id="reportSubmitBtn">
				</div>
			</div>
		</div>
		<div id="footer">
			<c:import url="../footer/footer.jsp" />
		</div>


	</div>

</body>
</html>
