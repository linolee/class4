<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Libre+Baskerville|Nanum+Myeongjo" rel="stylesheet"> 
<link rel="stylesheet" type="text/css" href="http://localhost:8080/spring_mvc_prj/common/main_v190130.css">
<style type="text/css">
#wrap{ margin: 0px auto; width: 1100px; height: 860px;}
#header{ margin: 0px auto; width: 1100px; height: 140px; background: #FFFFFF url(http://localhost:8080/spring_mvc_prj/common/images/header_bg.png);
			position: relative}
#headerTitle{font-family: 'Nanum Myeongjo', serif; font-size: 30px; font-weight: bold; text-align: center;
					position: absolute; top: 40px; left: 290px;}
#mypageTitle{font-family:NanumGothic, '돋움', dotum, Helvetica, sans-serif; 
			font-size: 50px; font-weight:300; color:#2B2B2B;  text-align: left; top: 40px; left: 290px;}
#headerTitle2{font-size: 30px; font-weight: normal; color:#757575; text-align: left;
			top: 40px; left: 290px;}
#container{ margin: 0px auto; width: 1100px; min-height: 600px;}
#btnAll{ width:60px; height: 35px; color: #2FB7BF;}
#btnWeek{ width:60px; height: 35px; color: #2FB7BF; }
#btn1Month{ width:60px; height: 35px; color: #2FB7BF; }
#btn2Month{ width:60px; height: 35px; color: #2FB7BF; }
#btn3Month{ width:60px; height: 35px; color: #2FB7BF; }
#fromDate{ height: 30px;}
#toDate{ height: 30px;}
#dateSearch{ width: 60px; height: 35px; color:#393939}
#listContents{ height: 400px; padding-top: 6px;}
#listTab{ border-top: 1px solid #333; border-spacing: 0px;}
#statusList{ width: 100px; height: 45px; background-color: #F3F3F3 }
#subjectList{ width: 400px; height: 45px; background-color: #F3F3F3  }
#periodList{ width: 320px; height: 45px; background-color: #F3F3F3 }
#cancelDateList{ width: 280px; height: 45px; background-color: #F3F3F3 }
#footer{ margin: 0px auto; width: 1100px; height: 120px;}
#footerTitle{ float: right; font-size: 15px; padding-top: 20px; padding-right: 20px}
.status{margin:0px auto;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		
	});//ready
</script>
<script type='text/javascript' src="jquery-1.10.2.min.js"></script>
<script type='text/javascript' src="polyfiller.js"></script>
<script>
	webshim.polyfill('forms forms-ext');

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
		<div id="headerTitle">SIST Class4</div>
		<div style="padding-top: 100px">
		<c:import url="/common/jsp/main_menu.jsp"></c:import>
		</div>
	</div>
	<div id="container">
		<div id="mypageTitle">마이페이지</div>
		<div id="headerTitle2">회원님의 소중한 정보들을 관리하실 수 있습니다.</div>
		<div style="padding-top: 30px; padding-bottom: 20px;">
			<c:import url="/common/class_jsp/main_menu.jsp"></c:import>
		</div>
	<div style="padding-top: 25px; padding-left: 30px; background-color: #F3F3F3; height: 50px;">
		<input type="button" value="전체" class="btn" id="btnAll"/>
		<input type="button" value="1주일" class="btn" id="btnWeek"/>
		<input type="button" value="1달" class="btn" id="btn1Month"/>
		<input type="button" value="2달" class="btn" id="btn2Month"/>
		<input type="button" value="3달" class="btn" id="btn3Month"/>
		
		<label for="fromDate"></label>
		<input type="date" id="fromDate" required="" />
		<label for="toDate">~</label>
		<input type="date" id="toDate" required="" />
		<input type="submit" value="검색" id="dateSearch"/>
		
	</div>
	<div style="padding-top: 20px; font-weight: normal; color:#757575;">
		총 0개의 내역이 있습니다.
	</div>
	<div id="listContents">
	<table id="listTab" border="1">
		<tr>
			<th id="statusList">상태</th>
			<th id="subjectList">클래스명</th>
			<th id="periodList">클래스 기간</th>
			<th id="cancelDateList">취소일</th>
		</tr>
	</table>
	
	<div id="classList">
	
	
	</div>
	
	</div>
	
	<div id="classSearch">
	</div>
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved class 4</div>
	</div>
</div>
</body>
</html>