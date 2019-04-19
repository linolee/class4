<%@page import="javafx.scene.control.Alert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% response.setContentType("text/html"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LMS</title>
<!-- <link href="css/style.css" rel="stylesheet"> -->
<link href="<c:url value="/resources/admin/css/style.css" />" rel="stylesheet">
<style type="text/css">
#file { display:none; } 
</style>
<%--     <!-- jQuery -->
	<!-- <script src="./js/jquery.min.js"></script> -->
<link href="<c:url value="/resources/admin/js/jquery.min.js" />" rel="stylesheet">
	<!-- 파퍼 자바스크립트 -->
	<!-- <script src="./js/popper.min.js"></script> -->
<link href="<c:url value="/resources/admin/js/popper.min.js" />" rel="stylesheet">
	<!-- 부트스트랩 자바스크립트 -->
	<!-- <script src="./js/bootstrap.min.js"></script> -->
<link href="<c:url value="/resources/admin/js/bootstrap.min.js" />" rel="stylesheet"> --%>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"> -->
<!-- 합쳐지고 최소화된 최신 CSS --><!-- 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"> -->
<!-- <link href="//netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"> -->

<%
	String filename=request.getParameter("file");
	pageContext.setAttribute("filename", filename);
%>
	
<script type="text/javascript">

$(function(){
	$("#logout").click(function() {
		confirm("로그아웃 하시겠습니까?");
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
              <a class="nav-link" href="#void">
                <i class="nav-icon icon-drop"></i> 문의관리</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#void">
                <i class="nav-icon icon-pencil"></i> 신고관리</a>
            </li>
            <li class="nav-title">강의관리</li>
            <li class="nav-item nav-dropdown">
              <a class="nav-link nav-dropdown-toggle" href="#void">
                <i class="nav-icon icon-puzzle"></i> 강의개설 승인</a>
         
            </li>
            <li class="nav-item nav-dropdown">
              <a class="nav-link nav-dropdown-toggle" href="template.do?page=lecture">
                <i class="nav-icon icon-cursor"></i> 강의조회</a>
            </li>
           
            <li class="nav-title">회원관리</li>
            <li class="nav-item nav-dropdown">
              <a class="nav-link nav-dropdown-toggle" href="template.do?page=member" >
                <i class="nav-icon icon-star" ></i> 회원조회</a>
              <a class="nav-link nav-dropdown-toggle" href="template.do?page=teacherAuthority">
                <i class="nav-icon icon-star"></i> 강사 권한 승인 </a>
              <a class="nav-link nav-dropdown-toggle" href="template.do?page=blacklist">
                <i class="nav-icon icon-star"></i> 블랙리스트</a>
                
            <li class="nav-title">기타</li>
            <li class="nav-item nav-dropdown">
              <a class="nav-link nav-dropdown-toggle" href="template.do?page=category">
                <i class="nav-icon icon-star"></i> 카테고리</a>
              <a class="nav-link nav-dropdown-toggle" href="template.do?page=title">
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
	<c:if test="${ not empty param.page }">
		<c:import url="${ param.page }.jsp"/>
	</c:if>
		<br/><br/>
	</div>
	<!-- 메인 -->
	
	
</div>
	

</body>
</html>	