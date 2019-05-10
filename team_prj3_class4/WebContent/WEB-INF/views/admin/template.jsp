<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% response.setContentType("text/html"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HI</title>
<style type="text/css">
#file, #file2, #file3 { display:none; } 	
.titleImg, .categoryImg{width:900px; height:300px; width:100%; height:100%;}
.upCategoryImg{width:900px;height:300px}
.upCategoryImg2{width:600px;height:200px}
</style>

<link href="<c:url value="/resources/admin/css/style.css" />" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="<c:url value="/resources/admin/js/bootstrap.min.js" />"></script>
	
<!-- 구글 태그 매니져  -->	
<!-- Global site tag (gtag.js) - Google Analytics-->
<!-- <script async="" src="https://www.googletagmanager.com/gtag/js?id=UA-118965717-3"></script> -->	

<script>

function printClock() {
    
    var clock = document.getElementById("clock");            // 출력할 장소 선택
    var currentDate = new Date();                                     // 현재시간
    var calendar = currentDate.getFullYear() + "-" + (currentDate.getMonth()+1) + "-" + currentDate.getDate() // 현재 날짜
    var amPm = 'AM'; // 초기값 AM
    var currentHours = addZeros(currentDate.getHours(),2); 
    var currentMinute = addZeros(currentDate.getMinutes() ,2);
    var currentSeconds =  addZeros(currentDate.getSeconds(),2);
    
    if(currentHours >= 12){ // 시간이 12보다 클 때 PM으로 세팅, 12를 빼줌
    	amPm = 'PM';
    	currentHours = addZeros(currentHours - 12,2);
    }

    if(currentSeconds >= 50){// 50초 이상일 때 색을 변환해 준다.
       currentSeconds = '<span style="color:#de1951;">'+currentSeconds+'</span>'
    }
    clock.innerHTML = currentHours+":"+currentMinute+":"+currentSeconds +" <span style='font-size:50px;'>"+ amPm+"</span>"; //날짜를 출력해 줌
    
    setTimeout("printClock()",1000);         // 1초마다 printClock() 함수 호출
}

function addZeros(num, digit) { // 자릿수 맞춰주기
	  var zero = '';
	  num = num.toString();
	  if (num.length < digit) {
	    for (i = 0; i < digit - num.length; i++) {
	      zero += '0';
	    }
	  }
	  return zero + num;
}

</script>		
	
<script type="text/javascript">

$(function(){
	$("#logout").click(function() {
		if(confirm("로그아웃 하시겠습니까?")){
			location.href="AdminLogin.do";
		};
	});
 	$(document).on('click', 'a[href="#"]', function(e){
		e.preventDefault();
	});
	$(document).on('click', 'a[href="#void"]', function(e){
		e.preventDefault();
	});
	
});

</script>
    
</head>
	
  <body class="app header-fixed sidebar-fixed aside-menu-fixed sidebar-lg-show">
<div class="sidebar">

        <nav class="sidebar-nav">
          <ul class="nav">
            <li class="nav-title">고객센터</li>
            <li class="nav-item">
              <!-- <a class="nav-link" href="template.do?page=question"> -->
              <a class="nav-link" href="question.do"> 
                <i class="nav-icon icon-drop"></i> 문의관리</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="charge.do">
                <i class="nav-icon icon-pencil"></i> 신고관리</a>
            </li>
            <li class="nav-title">강의관리</li>
            <li class="nav-item nav-dropdown">
              <a class="nav-link nav-dropdown-toggle" href="lecturePermit.do">
                <i class="nav-icon icon-puzzle"></i> 강의 개설 승인</a>

            </li>
            <li class="nav-item nav-dropdown">
              <a class="nav-link nav-dropdown-toggle" href="lecture.do">
                <i class="nav-icon icon-cursor"></i> 강의 조회</a>
            </li>
           
            <li class="nav-title">회원관리</li>
            <li class="nav-item nav-dropdown">
              <a class="nav-link nav-dropdown-toggle" href="member.do" >
                <i class="nav-icon icon-star" ></i> 회원 조회</a>
              <a class="nav-link nav-dropdown-toggle" href="teacher.do">
                <i class="nav-icon icon-star"></i> 강사 조회 </a>
              <a class="nav-link nav-dropdown-toggle" href="teacherAuthority.do">
                <i class="nav-icon icon-star"></i> 강사 권한 승인 </a>
              <a class="nav-link nav-dropdown-toggle" href="blacklist.do">
                <i class="nav-icon icon-star"></i> 블랙리스트</a>
                
            <li class="nav-title">기타</li>
            <li class="nav-item nav-dropdown">
              <a class="nav-link nav-dropdown-toggle" href="category.do">
                <i class="nav-icon icon-star"></i> 카테고리</a>
              <a class="nav-link nav-dropdown-toggle" href="title.do">
                <i class="nav-icon icon-star"></i> 타이틀</a>
          </ul>
        </nav>
      </div>
  </body>

<div id="container" class="main">
  
      <ol class="breadcrumb">
          <li class="breadcrumb-item">
		        <a href="template.do">SIST Class4 Group1</a>
		        <span>:: 2019 Web Project</span>
          </li>
          <li class="breadcrumb-menu d-md-down-none">
            <div class="btn-group" role="group" aria-label="Button group">
                <input type="button" id="logout" value="Logout" class="btn" />
            </div>
          </li>
        </ol>
	
	<div class="container-fluid">
	
	<c:if test="${ not empty page }">
		<c:import url="${ page }.jsp"/>
	</c:if>
	<c:if test="${ empty page }">
		
		
              <div class="animated fadeIn" style="border-bottom:1px solid #c8ced3;">
            <div class="row">
              <div class="col-sm-6 col-lg-3">
                <div class="card text-white bg-primary">
                  <div class="card-body pb-0">
                    <div class="text-value"><c:out value="${ stats.totalClient }"/>명</div>
                    <div>총 회원 수</div>
                  </div>
                  <div class="chart-wrapper mt-3 mx-3" style="height:70px;">
                    <canvas class="chart" id="card-chart1" height="70"></canvas>
                  </div>
                </div>
              </div>
              <!-- /.col-->
              <div class="col-sm-6 col-lg-3">
                <div class="card text-white bg-info">
                  <div class="card-body pb-0">
                    <div class="text-value"><c:out value="${ stats.todayClient }"/>명</div>
                    <div>오늘 가입자 수</div>
                  </div>
                  <div class="chart-wrapper mt-3 mx-3" style="height:70px;">
                    <canvas class="chart" id="card-chart2" height="70"></canvas>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 col-lg-3">
                <div class="card text-white bg-warning">
                  <div class="card-body pb-0">
                    <div class="text-value"><c:out value="${ stats.monthClient }"/>명</div>
                    <div>이번달 가입자 수</div>
                  </div>
                  <div class="chart-wrapper mt-3" style="height:70px;">
                    <canvas class="chart" id="card-chart3" height="70"></canvas>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 col-lg-3">
                <div class="card text-white bg-danger">
                  <div class="card-body pb-0">
                    <div class="text-value"><c:out value="${ stats.exitClient }"/>명</div>
                    <div>탈퇴한 회원 수</div>
                  </div>
                  <div class="chart-wrapper mt-3 mx-3" style="height:70px;">
                    <canvas class="chart" id="card-chart4" height="70"></canvas>
                  </div>
                </div>
              </div>
            </div>
          </div>
		
		<!-- clock test -->
		<body onload="printClock()">
		
		<div style="text-align: center">
			<div style="display: inline-block;">
				<div style="width:600px; height:250px; line-height:250px; color:#666;font-size:100px; text-align:center;" id="clock">
				</div>
			</div>
		</div>
		
		</body>
		<!-- clock test -->
		
		<div class="animated fadeIn" style="border-top:1px solid #c8ced3; padding-top: 25px;">
            <div class="row">
              <!-- /.col-->
              <div class="col-sm-6 col-lg-3">
                <div class="card text-white bg-danger">
                  <div class="card-body pb-0">
                    <div class="text-value"><c:out value="${ stats.totalTeacher }"/>명</div>
                    <div>총 강사 수</div>
                  </div>
                  <div class="chart-wrapper mt-3 mx-3" style="height:70px;">
                    <canvas class="chart" id="card-chart4" height="70"></canvas>
                  </div>
                </div>
              </div>
              
              <!-- /.col-->
              <div class="col-sm-6 col-lg-3">
                <div class="card text-white bg-warning">
                  <div class="card-body pb-0">
                    <div class="text-value"><c:out value="${ stats.totalLecture }"/>개</div>
                    <div>전체 강좌 수</div>
                  </div>
                  <div class="chart-wrapper mt-3" style="height:70px;">
                    <canvas class="chart" id="card-chart3" height="70"></canvas>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 col-lg-3">
                <div class="card text-white bg-info">
                  <div class="card-body pb-0">
                    <div class="text-value"><c:out value="${ stats.ingLecture }"/>개</div>
                    <div>진행중인 강좌 수</div>
                  </div>
                  <div class="chart-wrapper mt-3 mx-3" style="height:70px;">
                    <canvas class="chart" id="card-chart2" height="70"></canvas>
                  </div>
                </div>
              </div>
              
              <div class="col-sm-6 col-lg-3">
                <div class="card text-white bg-primary">
                  <div class="card-body pb-0">
                    <div class="text-value"><c:out value="${ stats.totalCategory }"/>개</div>
                    <div>카테고리 수</div>
                  </div>
                  <div class="chart-wrapper mt-3 mx-3" style="height:70px;">
                    <canvas class="chart" id="card-chart1" height="70"></canvas>
                  </div>
                </div>
              </div>
            </div>
          </div>
		
	</c:if>
	
	
		<br/><br/>
	</div>
	
</div>

</body>
</html>	