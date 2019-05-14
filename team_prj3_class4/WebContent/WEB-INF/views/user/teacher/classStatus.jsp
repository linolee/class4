<%@page import="kr.co.sist.user.service.UserLectureService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
#wrap {margin: 0px auto; width: 1100px; height: 860px;}
#headerTitle {/* font-family:NanumGothic, '돋움', dotum, Helvetica, sans-serif; */ font-size: 30px; font-weight: bold; text-align: center;
					position: absolute; top: 40px; left: 290px;}
#mypageTitle {/* font-family:NanumGothic, '돋움', dotum, Helvetica, sans-serif; */ font-size: 50px; color:#2B2B2B; font-weight: bold; text-align: left; top: 40px; left: 290px;}
#headerTitle2 {font-size: 30px; font-weight: normal; color:#757575; text-align: left;
			top: 40px; left: 290px;}
#title3 {/* font-family:NanumGothic, '돋움', dotum, Helvetica, sans-serif; */ font-size: 35px; color:#555555; font-weight: bold;}
#title4 {/* font-family:NanumGothic, '돋움', dotum, Helvetica, sans-serif; */ color:#757575; }			
			
#container{ margin: 0px auto; width: 1100px; min-height: 600px;}
.status{margin:0px auto;}
.tableHeader{ background-color: #F7F7F7}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<script type="text/javascript">
//신청현황 //
function viewImport( code ) {
	var code = code;	//ClassCode
	var sendData = {"classCode":code};
	
	$.ajax({
		url: "<c:url value='/user/teacher/apply_peoples.do' />",
		type: "GET",
		data: sendData,
		async: true,
		dataType: "json",
		success : function (msg) {
			var str = "";
			for(var i=0; i < msg.length; i++){
				str += "<tr class=\"apply-tr\">";
				str += 		"<td>"+msg[i].clientId+"</td>";
				str += 		"<td>"+msg[i].name+"</td>";
				str += 		"<td>"+msg[i].tel+"</td>";
				str += "</tr>";
			} // end for 

			//div에 append
			$("#applyTr").append(str);
			
			//div 보이기
			$("#applyPeoples").show();
			
		},
		error : function (msg) {
			console.log(msg);
		}
	}); // ajax
} // viewImport


function viewClassStatus(status) {
	location.href="classStatus.do?status="+status;
} // viewClassStatus//

function changeOpenClass(lcode) {
	var check = confirm("오픈으로 상태를 변경하시겠습니까?");
	if(check){
		$.ajax({
			url: "<c:url value='/user/teacher/changeOpenClass.do' />",
			type: "GET",
			data: {"lcode":lcode},
			dataType: "text",
			success : function (msg) {
				if (msg == 1) {
					alert("변경되었습니다");
				} else {
					alert("변경에 실패했습니다");
				}
				location.href="";
			},
			error : function (msg) {
				console.log(msg);
			}
		}); // ajax
	}
}

$(function(){
	$("[name='btnClose']").click(function() {
		$("#applyPeoples").hide();
		$("#panel-tr").nextAll().remove();
	}); // click

});//ready
</script>
<link href="<c:url value="/resources/css/header.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/footer.css" />" rel="stylesheet">

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
		<div id="title3">클래스 현황</div>
		<div id="title4">지금 진행 중인 클래스 현황을 조회하고 예약내역을 확인하실 수 있습니다.</div>
		<br>
		
		<!-- listContents -->
		<div id="listContents">
			<table class="status" id="listTab" border="1">
				<colgroup>
					<col width="12%" />
					<col width="12%" />
					<col width="12%" />
					<col width="12%" />
					<col width="12%" />
					<col width="12%" />
					<col width="12%" />
					<col width="12%" />
				</colgroup>
				<thead>
					<tr class=tableHeader>
						<th class="class-th">전체 클래스 수</th>
						<th class="class-th">승인대기</th>
						<th class="class-th">준비중</th>
						<th class="class-th">오픈</th>
						<th class="class-th">신청마감</th>
						<th class="class-th">진행 중</th>
						<th class="class-th">종료</th>
						<th class="class-th">취소</th>
					</tr>
				</thead>	
				<tbody>
					<tr class="content-list">
						<td class="tdHeight"><a href="#" onclick="viewClassStatus('All')"><c:out value="${cntList.totalCnt}"/></a></td>
						<td class="tdHeight"><a href="#" onclick="viewClassStatus('A')">${cntList.A}</a></td>
						<td class="tdHeight"><a href="#" onclick="viewClassStatus('R')">${cntList.R}</a></td>
						<td class="tdHeight"><a href="#" onclick="viewClassStatus('Y')">${cntList.Y}</a></td>
						<td class="tdHeight"><a href="#" onclick="viewClassStatus('F')">${cntList.F}</a></td>
						<td class="tdHeight"><a href="#" onclick="viewClassStatus('I')">${cntList.I}</a></td>
						<td class="tdHeight"><a href="#" onclick="viewClassStatus('E')">${cntList.E}</a></td>
						<td class="tdHeight"><a href="#" onclick="viewClassStatus('C')">${cntList.C}</a></td>
					</tr>
				</tbody>
			</table>
		</div><br>
		<div class="panel-classList">
			<a href="#" onclick="viewClassStatus('All')">전체 클래스</a> | 
			<a href="#" onclick="viewClassStatus('A')">승인 대기 클래스</a> | 
			<a href="#" onclick="viewClassStatus('R')">준비중 클래스</a> | 
			<a href="#" onclick="viewClassStatus('Y')">오픈된 클래스</a> | 
			<a href="#" onclick="viewClassStatus('F')">마감된 클래스</a> | 
			<a href="#" onclick="viewClassStatus('I')">진행중인 클래스</a> | 
			<a href="#" onclick="viewClassStatus('E')">종료된 클래스</a> | 
			<a href="#" onclick="viewClassStatus('C')">취소된 클래스</a>
		</div>

		<div id="listContents">
			<table id="listTab" border="1">
				<colgroup>
					<col width="10%" />
					<col width="40%" />
					<col width="20%" />
					<col width="10%" />
					<col width="10%" />
					<col width="10%" />
				</colgroup>
				<thead>
					<tr>
						<th class="class-th" id="statusList">상태</th>
						<th class="class-th" id="subjectList">클래스명</th>
						<th class="class-th" id="periodList">클래스 기간</th>
						<th class="class-th" id="peopleList">신청인원</th>
						<th class="class-th" id="dateList">강사명</th>
						<th class="class-th" id="marsterList">상세보기</th>
					</tr>
				</thead>	
				<tbody>
				<c:if test="${not empty requestScope.l_list}">
				<c:forEach var="List" items="${ requestScope.l_list }">
					<c:choose>
						<c:when test="${ List.status eq 'A'}">
							<c:set var="css" value="ac"/>
							<c:set var="txt" value="승인대기"/>
						</c:when>
						<c:when test="${ List.status eq 'R'}">
							<c:set var="css" value="rd"/>
							<c:set var="txt" value="준비중"/>
						</c:when>
						<c:when test="${ List.status eq 'Y'}">
							<c:set var="css" value="ys"/>
							<c:set var="txt" value="오픈"/>
						</c:when>
						<c:when test="${ List.status eq 'F'}">
							<c:set var="css" value="fn"/>
							<c:set var="txt" value="마감"/>
						</c:when>
						<c:when test="${ List.status eq 'I'}">
							<c:set var="css" value="in"/>
							<c:set var="txt" value="진행중"/>
						</c:when>
						<c:when test="${ List.status eq 'E'}">
							<c:set var="css" value="ed"/>
							<c:set var="txt" value="종료"/>
						</c:when>
						<c:when test="${ List.status eq 'C'}">
							<c:set var="css" value="cc"/>
							<c:set var="txt" value="취소"/>
						</c:when>
					</c:choose>
					
					<tr class="class-list">
						<td>
							<c:choose>
								<c:when test="${ List.status eq 'R'}">
									<a href="#" onclick="changeOpenClass('${List.lcode}')"><span class="ico ${css}"><c:out value="${txt}"/></span></a>
								</c:when>
								<c:otherwise>
									<span class="ico ${css}"><c:out value="${txt}"/></span>
								</c:otherwise>
							</c:choose>
						</td>
						<td><c:out value="${ List.lname }"/></td>
						<td><c:out value="${ List.startDate }"/> ~ <c:out value="${ List.endDate }"/></td>
						<td>
							<a href="#void" onclick="viewImport('${List.lcode}')">
								<strong>
									(<c:out value="${List.nowMember}"/>/<c:out value="${ List.maxMember }"/>)
								</strong>
							</a>
						</td>
						<td><c:out value="${ List.teacherName }"/></td>
						<td><a href="http://localhost:8080/team_prj3_class4/user/classDetail/detail.do?lcode=${List.lcode}" target="_blank"><input type="button" class="btn btn-warning" name="btnDetail" value="상세보기"></a></td>
					</tr>
          
				</c:forEach>
				</c:if>
				<c:if test="${empty l_list}">
					<tr class="class-list">
						<td colspan="6"  align="center">클래스가 존재하지 않습니다.<br/></td>
					</tr>
				</c:if> 
			</table>
		</div>
		
		<div style="text-align: center">
			<div style="display: inline-block;">
				<ul class="pagination ">
					<c:out value="${ indexList }" escapeXml="false"/>
				</ul>
			</div>
		</div>		
		
		<div id="applyPeoples" class="applyPeoples" style="display: none;">
			<h2>신청인원</h2>
			<table id="applyTr" border="1" style="border-spacing: 0; margin: 0px auto;">
				<tr id="panel-tr" style="background-color: #BBBBBB;">
					<th class="apply-th" width="100">아이디</th>
					<th class="apply-th" width="80">이름</th>
					<th class="apply-th" width="150">휴대전화</th>
				</tr>
				<!-- append 영역 -->
				</tbody>
			</table><br>
			<input type="button" value="닫기" class="btn btn-warning" name="btnClose">
		</div>
	</div>
	
	<div id="footer">
		<c:import url="../footer/footer.jsp" />
	</div>
</div>
</body>
</html>