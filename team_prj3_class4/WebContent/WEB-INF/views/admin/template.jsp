<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% response.setContentType("text/html"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hi</title>
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
                <i class="nav-icon icon-puzzle"></i> 강의개설 승인</a>

            </li>
            <li class="nav-item nav-dropdown">
              <a class="nav-link nav-dropdown-toggle" href="lecture.do">
                <i class="nav-icon icon-cursor"></i> 강의조회</a>
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
		        <a href="https://sist.co.kr">SIST Class4 Group1</a>
		        <span>:: 2019 Web Project</span>
          </li>
          <li class="breadcrumb-menu d-md-down-none">
            <div class="btn-group" role="group" aria-label="Button group">
                <input type="button" id="logout" value="Logout" class="btn" />
            </div>
          </li>
        </ol>
	
	<!-- 메인 -->
	<div class="container-fluid">
	<%-- <c:if test="${ not empty param.page }">
		<c:import url="${ param.page }.jsp"/>
	</c:if>  --%>
	
	<!-- 아래걸로 바꿀 것  -->
	<c:if test="${ not empty page }">
		<c:import url="${ page }.jsp"/>
	</c:if>
	<c:if test="${ empty page }">
		메인
	</c:if>
	
	
		<br/><br/>
	</div>
	<!-- 메인 -->
	
	
</div>
	

</body>
</html>	