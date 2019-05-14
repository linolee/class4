<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Libre+Baskerville|Nanum+Myeongjo" rel="stylesheet"> 
<link rel="stylesheet" type="text/css" href="http://211.63.89.152/resources/css/main_v190130.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="http://211.63.89.152/resources/css/class.css">

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
#wrap {margin: 0px auto; width: 1100px; height: 860px;}
#headerTitle {font-size: 30px; font-weight: bold; text-align: center; position: absolute; top: 40px; left: 290px;}
#mypageTitle {font-size: 50px; color:#2B2B2B; font-weight: bold; text-align: left; top: 40px; left: 290px;}
#headerTitle2 {font-size: 30px; font-weight: normal; color:#757575; text-align: left;
			top: 40px; left: 290px;}
#container {margin: 0px auto; width: 1100px; min-height: 600px;}
.status {margin:0px auto;}
.tableHeader {background-color: #F7F7F7;}
#hugi {font-size: 40px; color:#2B2B2B; font-weight: bold; text-align: left; top: 40px; left: 290px;}		
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
/* webshim.polyfill('forms forms-ext'); */

//모달 보이기
function view( url ) {
	if(url == "addQuestion"){
		$("#addQuestion").show();
	}
}

function clearModal() {
	$(".qnaFormTitle").val("");
	$("#qnaTxtArea").val("");
}

$(function(){
	$("#addQuestion").hide();
	$("[name='btnClose']").click(function() {
		$("#addQuestion").hide();
	});
	
	clearModal();

});//ready

</script>
</head>
<body>

<div id="wrap">
	<div id="header">
		<c:import url="../header/header.jsp"></c:import>
	</div>
	<div id="container" style="height: 800px">
		<div id="mypageTitle">마이페이지</div>
		<div id="headerTitle2">회원님의 소중한 정보들을 관리하실 수 있습니다.</div>
		<div style="padding-top: 30px">
			<c:import url="/resources/jsp/main_menu.jsp"/>
		</div><br>
			

<!-- row -->
<div class="row">
	<div>
		<div id="hugi">
			<strong>관리자 문의</strong>
		</div>
		강사님께서 관리자에게 필요한 카테고리 추가 요청 및 기타 문의를 할 수 있는 페이지 입니다.

	</div>
	
	<!-- listContents -->
	<div id="listContents">
		<table id="listTab" border="1">
			<colgroup>
				<col width="10%" />
				<col width="35%" />
				<col width="20%" />
			</colgroup>
			<thead>
				<tr class="content-list">
					<th class="class-th" id="listNum" style="margin: auto;">등록일</th>
					<th class="class-th" id="subjectName">제목</th>
					<th class="class-th" id="dateList">답변여부</th>
				</tr>
			</thead>
			<tbody>
				<tr class="content-list">
					<td colspan="6">문의사항이 없습니다</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!--// listContents -->
	
	<div class="addBtn">
		<input type="button" value="문의하기" class="btn btn-warning" style="float: right;" onclick="view('addQuestion')"/><br/>
	</div>
	<div id="addQuestion">
		<c:import url="add_Question.jsp"/>
	</div>
	
	<!-- prev & next btn -->
	<div class="paging" align="center">
		<nav class="pagenate purple">
			<a href="#" class="btn"><img src="http://211.63.89.152/resources/img/btn_page_nate_first.gif" alt="처음으로"></a>
			<a href="#" class="btn prev"><img src="http://211.63.89.152/resources/img/btn_page_nate_prev.gif" alt="이전"></a>
			<a href="#" class="btn last"><img src="http://211.63.89.152/resources/img/btn_page_nate_next.gif" alt="다음"></a>
			<a href="#" class="btn"><img src="http://211.63.89.152/resources/img/btn_page_nate_last.gif" alt="마지막으로"></a>
		</nav>
	</div>
	
	<!--// prev & next btn -->
</div>
<!--//row -->

</div>
	<div id="footer">
		<c:import url="../footer/footer.jsp" />
	</div>
</div>
</body>
</html>