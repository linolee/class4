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

<style type="text/css">
#wrap{ margin: 0px auto; width: 1100px; height: 860px;}
#headerTitle{font-family: 'Nanum Myeongjo', serif; font-size: 30px; font-weight: bold; text-align: center;
					position: absolute; top: 40px; left: 290px;}
#mypageTitle{font-family:NanumGothic, '돋움', dotum, Helvetica, sans-serif;
			font-size: 50px; color:#2B2B2B; font-weight: bold; text-align: left; top: 40px; left: 290px;}
#headerTitle2{font-size: 30px; font-weight: normal; color:#757575; text-align: left;
			top: 40px; left: 290px;}
#title3{font-family:NanumGothic, '돋움', dotum, Helvetica, sans-serif; font-size: 35px; color:#555555; font-weight: bold;}
#title4{font-family:NanumGothic, '돋움', dotum, Helvetica, sans-serif; color:#757575; }			
			
#container{ margin: 0px auto; width: 1100px; min-height: 600px;}
#listContents{ height: 400px; padding-top: 6px;}
#listTab{ border-top: 1px solid #333; border-spacing: 0px;}
#statusList{ width: 100px; height: 45px; background-color: #F3F3F3  }
#subjectList{ width: 300px; height: 45px; background-color: #F3F3F3  }
#periodList{ width: 270px; height: 45px; background-color: #F3F3F3 }
#peopleList{ width: 100px; height: 45px; background-color: #F3F3F3 }
#dateList{ width: 180px; height: 45px; background-color: #F3F3F3 }
#marsterList{ width: 140px; height: 45px; background-color: #F3F3F3 }
.status{margin:0px auto;}
.tableHeader{ background-color: #F7F7F7}

#applyPeoples{ position: absolute; top: 220px; left: 500px; }
#applyPeoplesFrm{ border: 1px solid #333333; background-color: #FFFFFF; padding: 10px;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#applyPeoples").hide();
		$("[name='btnClose']").click(function() {
			$("#applyPeoples").hide();
		});

	});//ready
	function viewImport( url ) {
		if(url == "applyPeoples"){
			$("#applyPeoples").show();
		}
	}
</script>
</head>
<body>
<div id="wrap">
	<div id="container">
		<div id="mypageTitle">마이페이지</div>
		<div id="headerTitle2">회원님의 소중한 정보들을 관리하실 수 있습니다.</div>
		<div style="padding-top: 30px">
			<c:import url="/resources/jsp/main_menu.jsp"/>
		</div><br>
		<div id="title3">클래스 현황</div>
		<div id="title4">지금 진행 중인 클래스 현황을 조회하고 예약내역을 확인하실 수 있습니다.</div>
		<br>
		<div style="padding-top:10px">
		<table border="1" class=status style="border-spacing: 0;">
			<tr class=tableHeader>
				<th width=220px height=50>전체 클래스 수</th>
				<th width=220px height=50>승인대기</th>
				<th width=220px height=50>준비중</th>
				<th width=220px height=50>오픈</th>
				<th width=220px height=50>신청마감</th>
				<th width=220px height=50>진행 중</th>
				<th width=220px height=50>종료</th>
				<th width=220px height=50>취소</th>
			</tr>
			<tr style="text-align: center; font-weight: bold;">
				<td height=100>0</td>
				<td height=100>0</td>
				<td height=100>0</td>
				<td height=100>0</td>
				<td height=100>0</td>
				<td height=100>0</td>
				<td height=100>0</td>
				<td height=100>0</td>
			</tr>
		</table>
		</div><br>
		<div style="padding-top: 20px">
		<a href="#void" >전체 클래스</a> | 
		<a href="#void" >승인 대기 클래스</a> | 
		<a href="#void" >준비중 클래스</a> | 
		<a href="#void" >오픈된 클래스</a> | 
		<a href="#void" >마감된 클래스</a> | 
		<a href="#void" >진행중인 클래스</a> | 
		<a href="#void" >종료된 클래스</a> | 
		<a href="#void" >취소된 클래스</a>
		</div>

		<div id="listContents">
			<table id="listTab" border="1">
				<tr>
					<th id="statusList">상태</th>
					<th id="subjectList">클래스명</th>
					<th id="periodList">클래스 기간</th>
					<th id="peopleList">신청인원</th>
					<th id="dateList">강사명</th>
					<th id="marsterList">상세보기</th>
				</tr>
				<tr style="text-align: center; height: 35px;">
					<td>-</td>
					<td>-</td>
					<td>-</td>
					<td><a href="#void" onclick="viewImport('applyPeoples')">-</a></td>
					<td>-</td>
					<td>-</td>
				</tr>
			</table>
			
			<div id="applyPeoples">
				<c:import url="apply_peoples.jsp"/>
			</div>

		</div>
	</div>

</div>
</body>
</html>