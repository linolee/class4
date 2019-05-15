<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Libre+Baskerville|Nanum+Myeongjo" rel="stylesheet"> 
<link rel="stylesheet" type="text/css" href="http://211.63.89.148:8080/team_prj3_class4/resources/css/main_v190130.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="http://211.63.89.148:8080/team_prj3_class4/resources/css/class.css">

<!-- Bootstrap btn include -->
<!-- <link href="/docs/4.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> -->
<link href="https://cdn.jsdelivr.net/npm/docsearch.js@2/dist/cdn/docsearch.min.css" rel="stylesheet">
<!-- <link href="/docs/4.0/assets/css/docs.min.css" rel="stylesheet"> -->
<link href="<c:url value="/resources/css/header.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/footer.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<style type="text/css">
#wrap { margin: 0px auto; width: 1100px; height: 860px;}
#container{ margin: 0px auto; width: 1100px; min-height: 600px;}
.status {margin:0px auto;}
.tableHeader { background-color: #F7F7F7}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
/* webshim.polyfill('forms forms-ext'); */
function viewDetail(clientId,lcode) {
	
	$("#starScore").children().each(function() {
		$(this).remove();
	});
	
	var clientId = clientId;
	var lcode = lcode;
	var sendData = {"clientId":clientId, "lcode":lcode};
	
	$.ajax({
		url:"<c:url value= '/user/teacher/review_detail.do'/>",
		data : sendData,
		dataType:"json",
		success: function (msg) {
			$("#lname").text(msg.lname);
			$("#subject").text(msg.subject);
			$("#m-content").val(msg.contents);
			$("#rDate").text(msg.rDate);
			$("#wName").text(msg.name);
			
			var score = msg.score;
			var scoreStr = "";
			
			for(var i = 1; i <= 5; i++){
				if(i <= score){
	 				scoreStr += '<span class="fa fa-star checked"></span>';			
				}else{
		 			scoreStr += '<span class="fa fa-star"></span>';
				} // end else
			} // end for
			
			$("#starScore").append(scoreStr);
			
			$(".panel-modal").show();
		},
		error: function (data) {
			console.log(data);
		}
	}); // ajax
	
}

function closeModal() {
	$("#lname").text("");
	$("#subject").text("");
	$("#m-content").val("");
	$("#rDate").text("");
	$("#wName").text("");
	
	$(".panel-modal").hide();
}

function searchDate () {
	var fromDate = $("#fromDate").val();
	var toDate = $("#toDate").val();
	
	location.href = "http://211.63.89.148:8080/team_prj3_class4/user/teacher/classReview.do?fromDate="+fromDate+"&toDate="+toDate;
	
}

jQuery(function($) {
    $('#fromDate').on('change', function() {
	$('#toDate').prop('min', $(this).val());
    });
    $('#toDate').on('change', function() {
	$('#fromDate').prop('max', $(this).val());
    });
    
});



</script>
</head>
<body>

<div id="wrap">
	<div id="header">
		<c:import url="../header/header.jsp"></c:import>
	</div>
	<div id="container">
		<div id="mypageTitle">마이페이지</div>
		<div id="headerTitle2">회원님의 소중한 정보들을 관리하실 수 있습니다.</div>
		<div style="padding-top: 30px">
			<c:import url="/resources/jsp/main_menu.jsp"/>
		</div><br>
			
			<!-- row -->
			<div class="row">
				<div>
					<div class="menu-title-div">
						<p class="menu-title"><strong>후기/문의</strong></p>
						<span class="menu-title2">회원들이 마스터님에게 남긴 궁금한 사항들을 답변하실 수 있고 클래스4에 문의하신 내역을 확인할 수 있습니다.</span>
					</div>
				</div>
				
				<div class="panel-tab">
					<ul class="nav nav-tabs">
						<li class="on"><a href="classReview.do">후기보기</a></li>
						<li><a href="qna.do">Q&A 문의</a></li>
					</ul>
				</div>
				
				<div class="panel-search">
					<div class="panel-search-in">
						<label for="fromDate"></label>
						<input type="date" class="searchDate" id="fromDate" value="${param.fromDate}"/>
						<label for="toDate">~</label>
						<input type="date" class="searchDate" id="toDate" value="${param.toDate}"/>
						<input type="submit" value="검색" class="btn btn-warning" id="dateSearch" onclick="searchDate()"/>
					</div>
				</div>	
				
				<!-- total_cnt -->
				<div class="total_cnt">
					총 <strong>${totalCount}</strong>개의 게시글이 있습니다.
				</div>
				<!--// total_cnt -->
				
				<!-- listContents -->
				<div id="listContents">
					<table id="listTab" border="1">
						<colgroup>
							<col width="8%" />
							<col width="20%" />
							<col width="40%" />
							<col width="15%" />
							<col width="20%" />
						</colgroup>
						<thead>
							<tr style="margin: auto;">
								<th class="class-th" id="listNum">번호</th>
								<th class="class-th" id="className">클래스명</th>
								<th class="class-th" id="subjectName">제목</th>
								<th class="class-th" id="writer">작성자</th>
								<th class="class-th" id="dateList">등록일</th>
							</tr>
						<c:if test="${not empty requestScope.r_list}">
						<c:forEach var="List" items="${ requestScope.r_list }" varStatus="status">
						<c:set var="i" value="${i+1}"/>
							<tr class="content-list">
								<td>${ (totalCount-(currentPage-1)*pageScale-i)+1 }</td>
								<td><c:out value="${ List.lname }"/></td>
								<td><a href="#" onclick="viewDetail('${List.clientId}','${List.lcode}')"><c:out value="${ List.subject }"/></a></td>
								<td><c:out value="${ List.name }"/></td>
								<td><c:out value="${ List.rDate }"/></td>
							</tr>
						</c:forEach>
 						</c:if>						
						</thead>
						<tbody>
						<c:if test="${empty r_list}">
							<tr class="class-list">
								<td colspan="5"  align="center">클래스가 존재하지 않습니다.<br/></td>
							</tr>
						</c:if> 
						</tbody>
					</table>
				</div>
				<!--// listContents -->
				
				<div style="text-align: center">
					<div style="display: inline-block;">
						<ul class="pagination ">
							<c:out value="${ indexList }" escapeXml="false"/>
						</ul>
					</div>
				</div>	
				
			</div>
			<!--//row -->
		</div>
	
	<!-- modal -->
	<div class="panel-modal" style="display: none;" id="review">
		<div class="modal-inner">
			<div class="modal-className">
				후기 - <span id="lname"></span>
			</div>
			<div class="modal-title">
				<span id="subject"><strong></strong></span>
			</div>
			<div class="modal-contents">
				<textarea rows="10" id="m-content" readonly></textarea>
				<div class="modal-info">
					<div class="modal-date">
						작성일 : <span id="rDate"></span>
					</div>
					<div class="modal-writer">
						작성자 : <span id="wName"></span>
					</div>
					<div class="modal-rate">
						별&nbsp;&nbsp;&nbsp;점 : <span id="starScore"></span>
					</div>
				</div>
			</div>
			<div class="modal-btn">
				<input type="button" class="btn btn-warning" value="확인" onclick="closeModal()">
			</div>
		</div>
	</div>
	<!--// modal -->
		
	<div id="footer">
		<c:import url="../footer/footer.jsp" />
	</div>
</div>
</body>
</html>