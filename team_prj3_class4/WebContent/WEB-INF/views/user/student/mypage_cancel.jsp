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
#listTab{border-top: 1px solid #3E588E; border-spacing: 0px;}
#statusList{ width: 100px; height: 45px; background-color: #F3F3F3; border: 1px solid #C3C3C3 }
#subjectList{ width: 400px; height: 45px; background-color: #F3F3F3; border-bottom: 1px solid #C3C3C3; border-top: 1px solid #C3C3C3 }
#periodList{ width: 320px; height: 45px; background-color: #F3F3F3; border: 1px solid #C3C3C3 }
#cancelDateList{ width: 280px; height: 45px; background-color: #F3F3F3; border-bottom: 1px solid #C3C3C3; border-top: 1px solid #C3C3C3;
				border-right: 1px solid #C3C3C3; }
#IndexList{ height: 30px; text-align: center; }
.status{margin:0px auto; border-top: 1px solid #30B7BF; border-spacing: 0px;}
.tableBody{font-family:NanumGothic, '돋움', dotum, Helvetica, sans-serif; 
			font-size: 13px; font-weight:300; color:#2B2B2B; text-align:center; height:50px;}
.tableBodyEmpty{font-family:NanumGothic, '돋움', dotum, Helvetica, sans-serif; 
			font-size: 13px; font-weight:300; color:#2B2B2B; text-align:center; height:60px; color: #666666}
td{ border-bottom: 1px solid #EEEEEE; }
.searchDetail:hover { background-color: #F3F3F3 }
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
		<c:import url="../header/header.jsp"></c:import>
	</div>
	<div id="container">
		<div style="float: right"><img src="http://localhost:8080/team_prj3_class4/common/images/class4.png"/></div>
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
		총 <c:out value="${cancelList.size()}"/>개의 내역이 있습니다.
	</div>
	<div id="listContents">
	<table id="listTab">
		<tr>
			<th id="statusList">상태</th>
			<th id="subjectList">클래스명</th>
			<th id="periodList">클래스 기간</th>
			<th id="cancelDateList">취소일</th>
		</tr>
	
	<c:set var="i" value="${0 }"/>
	<c:forEach var="cancelList" items="${ cancelList }">
		<tr class=searchDetail>
			<td class=tableBody>
				취소완료
			</td>
			<td class=tableBody>
				<c:out value="${ cancelList.get(i).lname}"></c:out>
			</td>
			<td class=tableBody>
				<c:out value="${ cancelList.get(i).startDate }~${ cancelList.get(i).endDate }"></c:out>
			</td>
			<td class=tableBody>
				<c:out value="${ cancelList.get(i).cancelDate}"></c:out>
			</td>
		</tr>
	</c:forEach>
	<c:if test="${ empty cancelList }">
	<tr>
		<td colspan="5" align="center" class=tableBodyEmpty>등록된 클래스 정보가 없습니다.</td>
	</tr>
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