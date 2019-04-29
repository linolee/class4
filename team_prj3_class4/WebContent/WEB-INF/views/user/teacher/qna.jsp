<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Libre+Baskerville|Nanum+Myeongjo" rel="stylesheet"> 
<link rel="stylesheet" type="text/css" href="http://localhost:8080/team_prj3_class4/resources/css/main_v190130.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/team_prj3_class4/resources/css/class.css">

<!-- Bootstrap btn include -->
<!-- <link href="/docs/4.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> -->
<link href="https://cdn.jsdelivr.net/npm/docsearch.js@2/dist/cdn/docsearch.min.css" rel="stylesheet">
<!-- <link href="/docs/4.0/assets/css/docs.min.css" rel="stylesheet"> -->
<link href="<c:url value="/resources/css/header.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/footer.css" />" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<style type="text/css">
#wrap { margin: 0px auto; width: 1100px; height: 860px;}
#headerTitle{font-family: 'Nanum Myeongjo', serif; font-size: 30px; font-weight: bold; text-align: center;
					position: absolute; top: 40px; left: 290px;}
#mypageTitle{font-family:NanumGothic, '돋움', dotum, Helvetica, sans-serif;
			font-size: 50px; color:#2B2B2B; font-weight: bold; text-align: left; top: 40px; left: 290px;}
#headerTitle2{font-size: 30px; font-weight: normal; color:#757575; text-align: left;
			top: 40px; left: 290px;}
#container{ margin: 0px auto; width: 1100px; min-height: 600px;}
.status{margin:0px auto;}
.tableHeader{ background-color: #F7F7F7}
#review{ position: absolute; top: 220px; left: 500px; }
</style>

<script type="text/javascript">
webshim.polyfill('forms forms-ext');

jQuery(function($) {
    $('#fromDate').on('change', function() {
	$('#toDate').prop('min', $(this).val());
    });
    $('#toDate').on('change', function() {
	$('#fromDate').prop('max', $(this).val());
    });
});

function viewDetail() {
	$(".panel-modal").show();
}

function closeModal() {
	$(".panel-modal").hide();
}
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
					<div class="menu-title">
						<strong>후기/문의</strong>
					</div>
					회원들이 마스터님에게 남긴 궁금한 사항들을 답변하실 수 있고 클래스4에 문의하신 내역을 확인할 수 있습니다.
				</div>
				
				<div class="panel-tab">
					<ul class="nav nav-tabs">
						<li><a href="classReview.do">후기보기</a></li>
						<li class="on"><a href="qna.do">Q&A문의</a></li>
					</ul>
				</div>
				
				<div class="panel-search">
					<div class="panel-search-in">
						<label for="fromDate"></label>
						<input type="date" class="searchDate" id="fromDate"/>
						<label for="toDate">~</label>
						<input type="date" class="searchDate" id="toDate"/>
						<input type="submit" value="검색" class="btn btn-warning" id="dateSearch"/>
					</div>
				</div>	
				
				<!-- total_cnt -->
				<div class="total_cnt">
					총 0개의 게시글이 있습니다.
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
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>쌍용교육센터</td>
								<td><a href="#" onclick="viewDetail()">쌍용교육센터 맞나요?</a></td>
								<td>곽쌍용</td>
								<td>2019/04/21</td>
<!-- 								<td colspan="5">등록된 Q&A가 없습니다</td> -->
							</tr>
						</tbody>
					</table>
				</div>
				<!--// listContents -->
				
				<!-- prev & next btn -->
				<div class="paging" align="center">
					<nav class="pagenate purple">
						<a href="#" class="btn"><img src="http://localhost:8080/team_prj3_class4/resources/img/btn_page_nate_first.gif" alt="처음으로"></a>
						<a href="#" class="btn prev"><img src="http://localhost:8080/team_prj3_class4/resources/img/btn_page_nate_prev.gif" alt="이전"></a>
						<a href="#" class="btn last"><img src="http://localhost:8080/team_prj3_class4/resources/img/btn_page_nate_next.gif" alt="다음"></a>
						<a href="#" class="btn"><img src="http://localhost:8080/team_prj3_class4/resources/img/btn_page_nate_last.gif" alt="마지막으로"></a>	
					</nav>
				</div>
				<!--// prev & next btn -->
			</div>
			<!--//row -->
		</div>
	
	<!-- modal -->
	<div class="panel-modal" style="display: none;" id="review">
		<div class="modal-inner">
			<div class="modal-className">
				후기 - 쌍용교육센터 좋네요.
	<!-- 			<input type="text" class="inputBox"/> -->
			</div>
			<div class="modal-title">
				쌍용교육센터 맞나요?
			</div>
			<div class="modal-contents">
				<textarea rows="10" id="m-content">궁금</textarea>
				<div class="modal-info">
					<div class="modal-date">
						작성일 :
					</div>
					<div class="modal-writer">
						작성자 :
					</div>
				</div>
			</div>
			<div class="modal-btn">
				<input type="button" class="btn btn-warning" value="답글달기">
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