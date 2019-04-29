<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Libre+Baskerville|Nanum+Myeongjo" rel="stylesheet"> 
<link rel="stylesheet" type="text/css" href="http://localhost:8080/team_prj3_class4/common/main_v190130.css">
<link href="<c:url value="/resources/css/header.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/footer.css" />" rel="stylesheet">
<style type="text/css">
#wrap{ margin: 0px auto; width: 1100px; height: 860px;}
#mypageTitle{font-family:NanumGothic, '돋움', dotum, Helvetica, sans-serif; 
			font-size: 50px; font-weight:300; color:#2B2B2B;  text-align: left; top: 40px; left: 290px;}
#headerTitle2{font-size: 30px; font-weight: normal; color:#757575; text-align: left;
			top: 40px; left: 290px;}
#container{ margin: 0px auto; width: 1100px; min-height: 600px;}
#listContents{ height: 400px; padding-top: 6px;}
#listTab{border-top: 1px solid #3E588E; border-spacing: 0px;}
#statusList{ width: 100px; height: 45px; background-color: #F3F3F3  }
#subjectList{ width: 350px; height: 45px; background-color: #F3F3F3  }
#periodList{ width: 300px; height: 45px; background-color: #F3F3F3 }
#peopleList{ width: 200px; height: 45px; background-color: #F3F3F3 }
#marsterList{ width: 140px; height: 45px; background-color: #F3F3F3 }
#IndexList{ height: 30px; text-align: center; }
.status{margin:0px auto; border-top: 1px solid #30B7BF; border-spacing: 0px;}
.tableHeader{ background-color: #F7F7F7}
.tableBody{font-family:NanumGothic, '돋움', dotum, Helvetica, sans-serif; 
			font-size: 13px; font-weight:300; color:#2B2B2B; text-align:center; height:30px;}
td{ border-bottom: 1px solid #EEEEEE; }
.searchDetail:hover { background-color: #F3F3F3 }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		
	});//ready
</script>

</head>
<body>
<div id="wrap">
	<div id="header">
		<c:import url="../header/header.jsp"></c:import>
	</div>
	<div id="container">
		<div style="float: right"><img src="http://localhost:8080/team_prj3_class4/common/images/class4.png"/></div>
		<div id="mypageTitle">마이페이지</div>
		<div id="headerTitle2">회원님의 소중한 정보들을 관리하실 수 있습니다.</div>
		<div style="padding-top: 30px">
			<c:import url="/common/class_jsp/main_menu.jsp"></c:import>
		</div>
	<div style="padding-top:10px">
	<table class=status>
		<tr class="tableHeader">
			<th width=220px height=50 style="border: 1px solid #C3C3C3; border-top:0px" >전체 클래스 수</th>
			<th width=220px height=50 style="border-bottom: 1px solid #C3C3C3;">예약완료</th>
			<th width=220px height=50 style="border: 1px solid #C3C3C3; border-top:0px">진행중</th>
			<th width=220px height=50 style="border-bottom: 1px solid #C3C3C3;">종료</th>
			<th width=220px height=50 style="border: 1px solid #C3C3C3; border-top:0px">예약취소</th>
		</tr>
		<tr>
			<td height=100 align="center" style="border: 1px solid #C3C3C3; border-top:0px; color: #F46A72; font-size: 40px;">
				${ statusCnt1+statusCnt2+statusCnt3+statusCnt4 }
			</td>
			<td height=100 align="center" height=50 style="border-bottom: 1px solid #C3C3C3; color: #45B7BF; font-size: 40px;" >${ statusCnt1 }</td>
			<td height=100 align="center" height=50 style="border: 1px solid #C3C3C3; border-top:0px; color: #F46A72; font-size: 40px;">${ statusCnt2 }</td>
			<td height=100 align="center" height=50 style="border-bottom: 1px solid #C3C3C3; color: #777777; font-size: 40px;">${ statusCnt3 }</td>
			<td height=100 align="center" height=50 style="border: 1px solid #C3C3C3; border-top:0px; color: #777777; font-size: 40px;">${ statusCnt4 }</td>
		</tr>
	</table>
	</div>
	<div style="padding-top: 20px">
	<a href="mypage_list.do" >전체보기</a> | 
	<a href="?status=Y" >예약완료 클래스</a> | 
	<a href="?status=X" >종료된 클래스</a> | 
	<a href="?status=C" >취소된 클래스</a> | 
	</div>

	<div id="listContents">
	<table id="listTab">
		<thead>
		<tr>
			<th id="statusList" style="border: 1px solid #C3C3C3">상태</th>
			<th id="subjectList" style="border-bottom: 1px solid #C3C3C3; border-top: 1px solid #C3C3C3" >클래스명</th>
			<th id="periodList" style="border: 1px solid #C3C3C3">클래스 기간</th>
			<th id="peopleList" style="border-bottom: 1px solid #C3C3C3; border-top: 1px solid #C3C3C3">예약인원</th>
			<th id="marsterList" style="border: 1px solid #C3C3C3">마스터</th>
		</tr>
		</thead>
		
	<c:if test="${ param.status==null }">
	<c:set var="i" value="${0 }"/>
	<c:forEach var="classList" items="${ classList }">
		<tr class=searchDetail>
			<td class=tableBody>
				<c:out value="${ classList.get(i).status}"></c:out>
			</td>
			<td class=tableBody>
				<c:out value="${ classList.get(i).lname}"></c:out>
			</td>
			<td class=tableBody>
				<c:out value="${ classList.get(i).startDate }~${ classList.get(i).endDate }"></c:out>
			</td>
			<td class=tableBody>
				<c:out value="${ classList.get(i).num}"></c:out>
			</td>
			<td class=tableBody>
				<c:out value="${ classList.get(i).teacherName}"></c:out>
			</td>
		</tr>
	</c:forEach>
	<c:if test="${ empty classList }">
	<tr>
		<td colspan="5" align="center">등록된 클래스 정보가 없습니다.</td>
	</tr>
	</c:if>
	</c:if>
	<c:if test="${ !(param.status==null) }">
	<c:set var="i" value="${0 }"/>
	<c:forEach var="classStatusList" items="${ classStatusList }">
		<tr class=searchDetail>
			<td class=tableBody>
				<c:out value="${ classStatusList.get(i).status}"></c:out>
			</td>
			<td class=tableBody>
				<c:out value="${ classStatusList.get(i).lname}"></c:out>
			</td>
			<td class=tableBody>
				<c:out value="${ classStatusList.get(i).startDate }~${ classStatusList.get(i).endDate }"></c:out>
			</td>
			<td class=tableBody>
				<c:out value="${ classStatusList.get(i).num}"></c:out>
			</td>
			<td class=tableBody>
				<c:out value="${ classStatusList.get(i).teacherName}"></c:out>
			</td>
		</tr>
	</c:forEach>
	<c:if test="${ empty classStatusList }">
	<tr>
		<td colspan="5" align="center">등록된 클래스 정보가 없습니다.</td>
	</tr>
	</c:if>
	</c:if>
	</table>
	
	</div>
	
	</div>
	<div id="IndexList" style="text-aling: center">
	<!-- escapeXml="false" c:out으로 태그를 출력 할 때 -->
		<c:out value="${indexList }" escapeXml="false"/>
	
	</div>
	<div id="footer">
		<c:import url="../footer/footer.jsp" />
	</div>
</div>
</body>
</html>