<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>class4-마이페이지 질문/답변</title>
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
#hiredateList{ width: 380px; height: 45px; background-color: #F3F3F3; border: 1px solid #C3C3C3  }
#subjectList{ width: 490px; height: 45px; background-color: #F3F3F3; border-bottom: 1px solid #C3C3C3; border-top: 1px solid #C3C3C3 }
#statusList{ width: 230px; height: 45px; background-color: #F3F3F3; border: 1px solid #C3C3C3 }
#qaJob{position: relative; bottom: 200px; left: 300px}
#readFrm{background-color: #FFFFFF; border: 1px solid #CCCCCC;
			box-shadow: 5px 5px 5px #444444; width:450px;
			padding: 10px}
#IndexList{ height: 30px; text-align: center; }
.status{margin:0px auto; border-top: 1px solid #30B7BF; border-spacing: 0px;}
.tableBody{font-family:NanumGothic, '돋움', dotum, Helvetica, sans-serif; 
			font-size: 13px; font-weight:300; color:#2B2B2B; text-align:center; height:50px;}
.tableBodyEmpty{font-family:NanumGothic, '돋움', dotum, Helvetica, sans-serif; 
			font-size: 13px; font-weight:300; color:#2B2B2B; text-align:center; height:60px; color: #666666}
td{ border-bottom: 1px solid #EEEEEE; }
.searchDetail:hover { background-color: #F3F3F3 }
</style>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%
	DecimalFormat df = new DecimalFormat("00");
	Calendar currentCalendar = Calendar.getInstance();
	//현재 날짜 구하기
	String strYear = Integer.toString(currentCalendar.get(Calendar.YEAR));
	String strMonth = df.format(currentCalendar.get(Calendar.MONTH) + 1);
	String strDay = df.format(currentCalendar.get(Calendar.DATE));
	String strDate = strYear+"-"+strMonth+"-"+strDay;
	//일주일 전 날짜 구하기
	currentCalendar.add(currentCalendar.DATE, -7);
	String strYear7 = Integer.toString(currentCalendar.get(Calendar.YEAR));
	String strMonth7 = df.format(currentCalendar.get(Calendar.MONTH) + 1);
	String strDay7 = df.format(currentCalendar.get(Calendar.DATE));
	String strDate7 =strYear7+"-"+strMonth7+"-"+strDay7;
	//한달 전 날짜 구하기
	currentCalendar.add(currentCalendar.DATE, -24);
	String strYear31 = Integer.toString(currentCalendar.get(Calendar.YEAR));
	String strMonth31 = df.format(currentCalendar.get(Calendar.MONTH) + 1);
	String strDay31 = df.format(currentCalendar.get(Calendar.DATE));
	String strDate31 = strYear31 +"-"+ strMonth31 +"-"+ strDay31;
	//두달전
	currentCalendar.add(currentCalendar.DATE, -30);
	String str2Year31 = Integer.toString(currentCalendar.get(Calendar.YEAR));
	String str2Month31 = df.format(currentCalendar.get(Calendar.MONTH) + 1);
	String str2Day31 = df.format(currentCalendar.get(Calendar.DATE));
	String str2Date31 = str2Year31 +"-"+ str2Month31 +"-"+ str2Day31;
	//세달전
	currentCalendar.add(currentCalendar.DATE, -28);
	String str3Year31 = Integer.toString(currentCalendar.get(Calendar.YEAR));
	String str3Month31 = df.format(currentCalendar.get(Calendar.MONTH) + 1);
	String str3Day31 = df.format(currentCalendar.get(Calendar.DATE));
	String str3Date31 = str3Year31 +"-"+ str3Month31 +"-"+ str3Day31;
%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btnReadClose").click(function(){
			$("[name='pageFlag']").val("");
			$("[name='mypageFrm']").submit();
		})
		
		$("#btnAll").click(function(){
			$("[name='fromDate']").val("1900-01-01");
			$("[name='toDate']").val("5000-12-30");
			$("[name='dateFrm']").submit();
		})
		$("#btnWeek").click(function(){
			$("[name='fromDate']").val('<%=strDate7%>');
			$("[name='toDate']").val("5000-12-30");
			$("[name='dateFrm']").submit();
		})
		
		$("#btn1Month").click(function(){
			$("[name='fromDate']").val('<%=strDate31%>');
			$("[name='toDate']").val("5000-12-30");
			$("[name='dateFrm']").submit();
		})
		
		$("#btn2Month").click(function(){
			$("[name='fromDate']").val('<%=str2Date31%>');
			$("[name='toDate']").val("5000-12-30");
			$("[name='dateFrm']").submit();
		})
		
		$("#btn3Month").click(function(){
			$("[name='fromDate']").val('<%=str3Date31%>');
			$("[name='toDate']").val("5000-12-30");
			$("[name='dateFrm']").submit();
		})
	});//ready
	
	function readEvt(pageFlag, evtCnt, qcode){
		$("[name='qcode']").val(qcode);
		$("[name='pageFlag']").val(pageFlag);
		$("[name='mypageFrm']").submit();
	}//writeEvt
</script>
<script>

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
	<form action="mypage_q&a.do" name="mypageFrm" method="get">
		<input type="hidden" name="num"/>
		<input type="hidden" name="param_month"/>
		<input type="hidden" name="param_year"/>
		<input type="hidden" name="param_day"/>
		<input type="hidden" name="pageFlag"/>
		<input type="hidden" name="qcode"/>
	</form>
		<div style="float: right"><img src="http://localhost:8080/team_prj3_class4/common/images/class4.png"/></div>
		<div id="mypageTitle">마이페이지</div>
		<div id="headerTitle2">회원님의 소중한 정보들을 관리하실 수 있습니다.</div>
		<div style="padding-top: 30px; padding-bottom: 20px;">
			<c:import url="/common/class_jsp/main_menu.jsp"></c:import>
		</div>
	<div style="padding-top: 25px; padding-left: 30px; background-color: #F3F3F3; height: 50px;">
	<form action="mypage_q&a.do" name="dateFrm" method="get">
		<input type="button" value="전체" class="btn" id="btnAll"/>
		<input type="button" value="1주일" class="btn" id="btnWeek"/>
		<input type="button" value="1달" class="btn" id="btn1Month"/>
		<input type="button" value="2달" class="btn" id="btn2Month"/>
		<input type="button" value="3달" class="btn" id="btn3Month"/>
		
		<label for="fromDate"></label>
		<input type="date" id="fromDate" required="" name="fromDate" />
		<label for="toDate">~</label>
		<input type="date" id="toDate" required="" name="toDate" />
		<input type="submit" value="검색" id="dateSearch"/>
	</form>
	</div>
	<div style="padding-top: 20px">
		<div style="float: left">
			<div style=" font-weight: normal; color:#757575;">
				총 <c:out value="${qnaList.size()}"/>개의 질문/답변이 있습니다.
			</div>
		</div>
		<div style="float: right">
		<a href="mypage_q&a.do" >전체보기</a> | 
		<a href="?status=N" >답변대기</a> | 
		<a href="?status=Y" >답변완료</a> 
		</div>
	</div>
	<br/>
	<div id="listContents">
	<table id=listTab>
		<tr>
			<th id="hiredateList">등록일</th>
			<th id="subjectList">클래스명</th>
			<th id="statusList">답변여부</th>
		</tr>
		<c:set var="i" value="${0 }"/>
		<c:forEach var="qnaList" items="${ qnaList }">
			<tr class=searchDetail>
				<td class=tableBody>
					<c:if test="${ qnaList.get(i).status == 'Y'}">
						<c:out value="${ qnaList.get(i).qDate}"></c:out>
					</c:if>
					<c:if test="${ qnaList.get(i).status == 'N'}">
						<c:out value="${ qnaList.get(i).qDate}"></c:out>
					</c:if>
				</td>
				<td class=tableBody>
					<c:if test="${ qnaList.get(i).status == 'Y'}">
					<a href="#void" onclick="readEvt('read_form',1,'${qnaList.get(i).qcode }')">
						<c:out value="${ qnaList.get(i).lname }"></c:out>
					</a>
					</c:if>
					<c:if test="${ qnaList.get(i).status == 'N'}">
						<c:out value="${ qnaList.get(i).lname }"></c:out>
					</c:if>
				</td>
				<td class=tableBody>
					<c:choose>
						<c:when test="${ qnaList.get(i).status == 'Y'}">
							답변완료
						</c:when>
						<c:when test="${ qnaList.get(i).status == 'N'}">
							답변대기
						</c:when>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
		<c:if test="${ empty qnaList }">
		<tr>
			<td colspan="5" align="center" class=tableBodyEmpty>등록된 클래스 정보가 없습니다.</td>
		</tr>
		</c:if>
	
	</table>
	<div id="qaJob">
		<c:if test="${ not empty param.pageFlag }">
			<c:import url="${param.pageFlag }.jsp"></c:import>
		</c:if>
	</div>
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