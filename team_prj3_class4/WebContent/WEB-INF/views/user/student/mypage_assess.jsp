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
<link href="<c:url value="/resources/css/header.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/footer.css" />" rel="stylesheet">
<style type="text/css">
#wrap{ margin: 0px auto; width: 1100px; height: 860px;}
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
#listTab{ border-spacing: 0px;}
#statusList{ width: 100px; height: 45px; background-color: #F3F3F3  }
#subjectList{ width: 300px; height: 45px; background-color: #F3F3F3  }
#periodList{ width: 270px; height: 45px; background-color: #F3F3F3 }
#peopleList{ width: 100px; height: 45px; background-color: #F3F3F3 }
#dateList{ width: 180px; height: 45px; background-color: #F3F3F3 }
#marsterList{ width: 140px; height: 45px; background-color: #F3F3F3 }
#assessJob{position: relative; bottom: 50px; left: 300px}
#writeFrm{background-color: #FFFFFF; border: 1px solid #CCCCCC;
			box-shadow: 5px 5px 5px #444444; width:500px;
			padding: 10px}
.status{margin:0px auto;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btnWriteClose").click(function(){
			$("[name='pageFlag']").val("");
			$("[name='mypageFrm']").submit();
		})
	});//ready
	
	function writeEvt(pageFlag, evtCnt){
		$("[name='pageFlag']").val(pageFlag);
		$("[name='mypageFrm']").submit();
	}//writeEvt
	
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
		<c:import url="../header/header.jsp"></c:import>
	</div>
	<div id="container">
	<form action="mypage_assess.do" name="mypageFrm" method="get">
		<input type="hidden" name="num"/>
		<input type="hidden" name="param_month"/>
		<input type="hidden" name="param_year"/>
		<input type="hidden" name="param_day"/>
		<input type="hidden" name="pageFlag"/>
	</form>
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
	<div style="padding-top: 20px">
		<div style="float: left">
			<div style=" font-weight: normal; color:#757575;">
				총 0개의 게시글이 있습니다.
			</div>
		</div>
		<div style="float: right">
		<a href="#void" >전체보기</a> | 
		<a href="#void" >작성대기</a> | 
		<a href="#void" >작성완료</a> 
		</div>
	</div>
	<br/>
	<div id="listContents">
	<table id="listTab">
		<tr>
			<th id="statusList" style="border: 2px solid #333">상태</th>
			<th id="subjectList" style="border-bottom: 2px solid #333; border-top: 2px solid #333">클래스명</th>
			<th id="periodList" style="border: 2px solid #333">클래스 기간</th>
			<th id="peopleList" style="border-bottom: 2px solid #333; border-top: 2px solid #333">예약인원</th>
			<th id="dateList" style="border: 2px solid #333">결재일</th>
			<th id="marsterList" style="border-bottom: 2px solid #333; border-top: 2px solid #333; 
						border-right: 2px solid #333">마스터</th>
		</tr>
		<tr>
			<td>
			<div>
			<a href="#void" onclick="writeEvt('write_form',1)">dsds</a></div>
			</td>
			<td>dsds</td>
			<td>dsds</td>
		</tr>
	</table>
	<div id="assessJob">
		<c:if test="${ not empty param.pageFlag }">
			<c:import url="${param.pageFlag }.jsp"></c:import>
		</c:if>
	</div>
	
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