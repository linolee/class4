<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>당신을 위한 수업★Class4★</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- css -->
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/header.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/footer.css" />" rel="stylesheet">
<!-- google font -->
<link href="https://fonts.googleapis.com/css?family=PT+Sans"
	rel="stylesheet">
<!-- CSS -->
<!-- Bootstrap core CSS -->
<link
	href="<c:url value="/resources/startbootstrap-modern-business-gh-pages/vendor/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link
	href="<c:url value="/resources/startbootstrap-modern-business-gh-pages/css/modern-business.css" />"
	rel="stylesheet">
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
	var checkCurPass = false;
	//////////////////////////////비밀번호 수정//////////////////////////////////////////////
	$("#changePasswordBtn").click(function (){
		if (CheckPassword()&&checkCurPass) {
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
					checkCurPass = true;
				}else{
					$('#passwordWarning0').text('비밀번호가 일치하지 않습니다.').css("color", "red");
					checkCurPass = false;
				}
			},
			error: function(xhr) {
				console.log(xhr.status);
			}	
		});
	});
	//////////////////////////////////문의/////////////////////////////////////////
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
	////////////////////////////////////////회원정보/////////////////////////////
	$("#deleteClientInfoBtn").click(function(){
		location.href = "deleteUserAgreement.do"
	});
	
	$("#changeClientInfoBtn").click(function(){
		if($("#changeClientInfoBtn").val()=="회원정보 수정"){///////수정 버튼을 누르고 새로운 정보를 입력할 상태를 만들어 줌
			$(".clientInfo").attr("readonly", false);
			$.ajax({
				type:"POST",
				url:"memberPageRequestFavorInfo.do",
				dataType : "json",
				success: function(json){
					/////////////DB에서 카테고리 목록을 받아와서 테이블로 보여준다./////////////////////
					var favorList = json.favorList;
					var tableCode = "";
					tableCode += "<th>관심목록</th>"
					tableCode += "<td><table>"
					tableCode += "<tr>"
					for (var i = 0; i < favorList.length; i++) {
						if (favorList[i] != null) {
							if (i%3 == 0 && i != 0) {
								tableCode += "</tr><tr>"
							}
							tableCode += "<td><input type='checkbox' name='favor' value = "+favorList[i]+"></td>"
							tableCode += "<td>"+favorList[i]+"</td>"
						}
					}
					if (tableCode.slice(tableCode.length-4) == "<tr>") {
						tableCode = tableCode.slice(0, length-4)
					}
					tableCode += "</td></table>"
					
					$("#favorListTr").html(tableCode);
					///////////////////////내가 원래 가지고 있던 애들은 체크해준다//////////
					autoFavorCheck(convertClientFavor());					
					
				},
				error: function(xhr) {
					console.log(xhr.status);
				}	
			});
		
			$("#changeClientInfoBtn").val('회원정보 수정 완료');
		}else{///////////수정을 완료하고 입력 버튼을 누름
			$("#clientInfo").submit();
		}
	});
	////////////////////////////////////////////////////////////////////////////////////////
	
	$('#summernote').summernote({
		placeholder : '신고 내용을 입력해주세요.',
		tabsize : 2,
		height : 300
	});
	
	$('#myTab li:first-child a').tab('show')
	if ("${param.currentPage}" != "") {
		$('#myTab li:last-child a').tab('show')
	}
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

function convertClientFavor(){
	var clientFavor = "${client_favor}".slice(1, "${client_favor}".length-1).split(",");
	for (var i = 0; i < clientFavor.length; i++) {
		clientFavor[i] = clientFavor[i].trim();
	}
	return clientFavor;
}

function autoFavorCheck(clientFavor){
	for (var i = 0; i < clientFavor.length; i++) {
		$("[value = '"+clientFavor[i]+"']").attr("checked", "checked");
	}
}


</script>
	
<style type="text/css">
body {padding-top: 0px;}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<c:import url="../header/header.jsp"></c:import>
		</div>
		<div class="container my-5" id="container">
			<!-- Page Heading/Breadcrumbs -->
			<h1 class="mt-4 mb-3">
				회원 정보 <small>Client Info</small>
			</h1>
			<ul class="nav nav-tabs"  id="myTab" role="tablist">
			  <li class="nav-item">
			    <a class="nav-link" id="clientInfoTab-tab" data-toggle="tab" href="#clientInfoTab" role="tab" aria-controls="clientInfo" aria-selected="false">회원정보</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" id="changePass-tab" data-toggle="tab" href="#changePass" role="tab" aria-controls="changePass" aria-selected="false">비밀번호 변경</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" id="report-tab" data-toggle="tab" href="#report" role="tab" aria-controls="report" aria-selected="false">관리자 문의</a>
			  </li>
			</ul>
			<div class="tab-content">
			  	<div class="tab-pane" id="clientInfoTab" role="tabpanel" aria-labelledby="home-tab">
					<div class="mb-8 col-lg-8 mx-auto">
						<form id="clientInfo" action="changeClientInfo.do" method="post">
						<table class="table">
							<tr>
								<th>이름</th>
								<td colspan="${fn:length(client_favor) }"><input type="text" name="name" class="form-control clientInfoNoChange" value="${clientInfo.name}" disabled="disabled" ></td>
							</tr>
							<tr>
								<th>아이디</th>
								<td colspan="${fn:length(client_favor) }"><input type="text" name="client_id" class="form-control clientInfoNoChange" value="${clientInfo.client_id}" disabled="disabled"></td>
							</tr>
							<tr>
								<th>생년월일</th>
								<td colspan="${fn:length(client_favor) }"><input type="text" name="birth" class="form-control clientInfoNoChange" value="${clientInfo.birth}" disabled="disabled"></td>
							</tr>
							<tr>
								<th>휴대전화</th>
								<td colspan="${fn:length(client_favor) }"><input type="text" name="tel" class="form-control clientInfo" value="${clientInfo.tel}" readonly="readonly" maxlength="14"></td>
							</tr>
							<tr>
								<th>이메일</th>
								<td colspan="${fn:length(client_favor) }"><input type="text" name="email" class="form-control clientInfo" value="${clientInfo.email }" readonly="readonly"></td>
							</tr>
							<tr id="favorListTr">
								<th>관심목록</th>
								<c:if test="${fn:length(client_favor) == 0}">
									<td>관심 목록이 없습니다.</td>
								</c:if>
								<c:forEach var="favor" items="${client_favor }">
									<td>${favor }</td>
								</c:forEach>
							</tr>
						</table>
						</form>
					<input type="button" class="btn btn-secondary inputBtn" value="회원정보 수정" id="changeClientInfoBtn" name="change">
					<input type="button" class="btn btn-secondary inputBtn" value="회원 탈퇴" id="deleteClientInfoBtn">
					</div>
				</div>
			  <div class="tab-pane" id="changePass" role="tabpanel" aria-labelledby="changePass-tab">
			  	<div class="mb-5 col-lg-5 mx-auto">
				<table class="table">
					<tr>
						<td>현재 비밀번호 입력</td>
						<td><input class="form-control" type="password" id="pass0"></td>
					</tr>
					<tr>
						<td colspan="2"><label id="passwordWarning0"></label></td>
					</tr>
					<tr>
						<td>비밀번호 입력</td>
						<td><input class="form-control" type="password" id="pass1" onchange="CheckPassword()"></td>
					</tr>
					<tr>
						<td>비밀번호 재입력</td>
						<td><input class="form-control" type="password" id="pass2" onchange="CheckPassword()"></td>
					</tr>
					<tr>
						<td colspan="2"><label id="passwordWarning"></label></td>
					</tr>
				</table>
				<br> <input type="button" value="비밀번호 변경" id="changePasswordBtn" class="btn btn-secondary inputBtn">
			  	</div>
			  </div>
			  <div class="tab-pane" id="report" role="tabpanel" aria-labelledby="report-tab">
			  	<div class="mb-10 col-lg-10 mx-auto">
					<c:forEach var="listItem" items="${list }" varStatus="i" begin="0" step="1">
					  <div class="card">
					    <div class="card-header" id="heading${i.index }">
					    	<table class="table">
					    		<tr>
					    			<th rowspan="2">
					    				<c:choose>
				    					<c:when test="${listItem.a_contents ne null}">
								        <button class="btn btn-info collapsed" type="button" data-toggle="collapse" data-target="#collapse${i.index }" aria-expanded="false" aria-controls="collapse${i.index }">
								          	열기
								        </button>
				    					</c:when>
				    					<c:otherwise>
								        <button class="btn btn-light collapsed" type="button" data-toggle="collapse" data-target="#collapse${i.index }" aria-expanded="false" aria-controls="collapse${i.index }">
								          	열기
								        </button>
				    					</c:otherwise>
					    				</c:choose>
					    			</th>
					    			<th>문의 제목</th>
					    			<th>질문 날짜</th>
					    		</tr>
					    		<tr>
					    			<td>${listItem.q_subject }</td>
					    			<td>${listItem.q_date }</td>
					    		</tr>
					    	</table>
					      <h5 class="mb-0">
					      </h5>
					    </div>
					    <div id="collapse${i.index }" class="collapse" aria-labelledby="heading${i.index }" data-parent="#accordionExample">
					      <div class="card-body">
					      	<table class="table">
					    		<tr>
					    			<th>문의 내용</th>
					    			<td>${listItem.q_contents }</td>
					    		</tr>
					    		<c:if test="${listItem.a_contents ne null}">
					    		<tr>
					    			<th>답변 내용</th>
					    			<td>${listItem.a_contents }</td>
					    		</tr>
					    		<tr>
					    			<th>답변 날짜</th>
					    			<td>${listItem.a_date}</td>
					    		</tr>
					    		</c:if>
					    	</table>
					      </div>
					    </div>
					  </div>
					  </c:forEach>
	  				<div style="text-align: center">
						<div style="display: inline-block;">
							<ul class="pagination ">
								<c:out value="${ indexList }" escapeXml="false" />
								<!-- escapeXml은 c:out으로 태그를 출력하게 만든다 -->
							</ul>
						</div>
					</div>
			  		
			  		
				    	<div class="card-header text-center" id="headingQna">
					      <button class="btn btn-info collapsed" type="button" data-toggle="collapse" data-target="#collapseQna" aria-expanded="false" aria-controls="collapseQna">
					      	관리자에게 문의
					      </button>
					    </div>
					    <div id="collapseQna" class="collapse" aria-labelledby="headingQna" data-parent="#accordionExample">
					      <div class="card-body">
							<input type="text" id="reportSubject" placeholder="제목을 입력해주세요.">
							<div id="summernote"></div>
							<div id="reportBtnDiv" class="text-center">
								<input type="button" value="제출하기" id="reportSubmitBtn" class="btn btn-secondary inputBtn">
							</div>
					      </div>
					    </div>
					  </div>
			  	</div>
			  </div>
			</div>

			<!-- /.row -->

		</div>
		<!-- /.container -->

		<div id="footer">
			<c:import url="../footer/footer.jsp" />
		</div>


	</div>

</body>
</html>
