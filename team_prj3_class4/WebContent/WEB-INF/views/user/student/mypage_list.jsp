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
#headerTitle{font-family: 'Nanum Myeongjo', serif; font-size: 30px; font-weight: bold; text-align: center;
					position: absolute; top: 40px; left: 290px;}
#mypageTitle{font-family:NanumGothic, '돋움', dotum, Helvetica, sans-serif; 
			font-size: 50px; font-weight:300; color:#2B2B2B;  text-align: left; top: 40px; left: 290px;}
#headerTitle2{font-size: 30px; font-weight: normal; color:#757575; text-align: left;
			top: 40px; left: 290px;}
#container{ margin: 0px auto; width: 1100px; min-height: 600px;}
#listContents{ height: 400px; padding-top: 6px;}
#listTab{ border-spacing: 0px;}
#statusList{ width: 100px; height: 45px; background-color: #F3F3F3  }
#subjectList{ width: 350px; height: 45px; background-color: #F3F3F3  }
#periodList{ width: 300px; height: 45px; background-color: #F3F3F3 }
#peopleList{ width: 200px; height: 45px; background-color: #F3F3F3 }
#marsterList{ width: 140px; height: 45px; background-color: #F3F3F3 }
#footer{ margin: 0px auto; width: 1100px; height: 120px;}
#footerTitle{ float: right; font-size: 15px; padding-top: 20px; padding-right: 20px}
.status{margin:0px auto;}
.tableHeader{ background-color: #F7F7F7}
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
		<div id="mypageTitle">마이페이지</div>
		<div id="headerTitle2">회원님의 소중한 정보들을 관리하실 수 있습니다.</div>
		<div style="padding-top: 30px">
			<c:import url="/common/class_jsp/main_menu.jsp"></c:import>
		</div>
	<div style="padding-top:10px">
	<table border="1" class=status>
		<tr class=tableHeader>
			<th width=220px height=50>전체 클래스 수</th>
			<th width=220px height=50>예약완료</th>
			<th width=220px height=50>진행중</th>
			<th width=220px height=50>종료</th>
			<th width=220px height=50>예약취소</th>
		</tr>
		<tr>
			<td height=100></td>
			<td height=100></td>
			<td height=100></td>
			<td height=100></td>
			<td height=100></td>
		</tr>
	</table>
	</div>
	<div style="padding-top: 20px">
	<a href="#void" >전체보기</a> | 
	<a href="#void" >예약완료 클래스</a> | 
	<a href="#void" >종료된 클래스</a> | 
	<a href="#void" >취소된 클래스</a> | 
	</div>

	<div id="listContents">
	<table id="listTab">
		<thead style="border: 2px #C3C3C3;">
		<tr>
			<th id="statusList" style="border: 2px solid #333">상태</th>
			<th id="subjectList" style="border-bottom: 2px solid #333; border-top: 2px solid #333" >클래스명</th>
			<th id="periodList" style="border: 2px solid #333">클래스 기간</th>
			<th id="peopleList" style="border-bottom: 2px solid #333; border-top: 2px solid #333">예약인원</th>
			<th id="marsterList" style="border: 2px solid #333">마스터</th>
		</tr>
		</thead>
	<c:forEach var="classList" items="${ classList }">
		<tr>
			<td>${ classList.lcode }</td>
			<td></td>
		</tr>
	</c:forEach>
	<c:if test="${ empty classList }">
	<tr>
		<td colspan="5" align="center">등록된 클래스 정보가 없습니다.</td>
	</tr>
	</c:if>
	</table>
	
	<div id="classList">
	
	
	</div>
	
	</div>
	
	<div id="classSearch">
	</div>
	
	</div>
	<div id="footer">
		<c:import url="../footer/footer.jsp" />
	</div>
</div>
</body>
</html>