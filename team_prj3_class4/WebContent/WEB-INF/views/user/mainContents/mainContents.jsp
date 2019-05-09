<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Class4-Main</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/main_v190130.css"/>
<link href="<c:url value="/resources/maincontents/mainContents.css"/>"rel="stylesheet">
<link href="<c:url value="/resources/maincontents/style.css"/>"rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/header.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/footer.css" />" rel="stylesheet">
<!-- google font -->
<link href="https://fonts.googleapis.com/css?family=PT+Sans" rel="stylesheet">
<style type="text/css">
#wrapper {
	font-family: 'PT Sans', sans-serif;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="http://localhost:8080/team_prj3_class4/resources/maincontents/touchslider.js"></script>
<script type="text/javascript">
 $(function(){
	 $("#cg01").click(function(){
			location.href="http://localhost:8080/team_prj3_class4/user/search/search.do?category="+$("[name='category']").val();	
	 });
 });//ready
</script>
</head>
<body>
<div id="wrap">
	<div id="header">
		<c:import url="../header/header.jsp"></c:import>
	</div>
	<div id="container">
	
	<div id="headImg" style="width:1100px;height:500px;border:1px solid #333;margin-top: 15px;margin-bottom: 15px;position: relative;">
		<div class='swipe' style='margin:10px ;'>
			<ul id='slider4'>
			    <li style='display:block; width: 1310px;height: 480px;'>
			    <div id="TitleImg1">
			    	<img src="http://localhost:8080/team_prj3_class4/resources/img/headerImg1.jpg" width="1048" height="460" />
				</div></li>
			    <li style="width: 1310px;"><div id="TitleImg2">
					2번 이미지
				</div></li>
			    <li style="width: 1310px;"><div id="TitleImg3">
					3번 이미지
				</div></li>
			  </ul>
		</div>
		<input type="button" value="&lt;" class="lbtn" id="tilbtn" onclick="t00.prev();"/>
		<input type="button" value="&gt;" class="rbtn" id="tirbtn" onclick="t00.next();"/>
		<br/><div id="pagenavi"></div>
	</div>
	<c:import url="../mainContents/main_menu.jsp"></c:import>
	<nav id="main-nav">
      <!-- Sample menu definition -->
      <ul id="main-menu" class="sm sm-simple">
      <c:forEach var="clist" items="${ requestScope.clist }">
      <li><a href="#void"><c:out value="${clist}"/></a></li>
      </c:forEach>
       </ul>
	</nav>
	<div id="content">
		<div id="category">
		<span id="cgTitle">카테고리</span>
		<div class='swipe' style='margin:10px ;height:350px;padding-top: 40px;' >
			<ul id='slider3'>
			<%-- <c:forEach var="clist" items="${ requestScope.clist }">
      		<li><a href="#void"><c:out value="${clist}"/></a></li>
      		<c:set var="i" value="${ i + 1 }"/>
      		</c:forEach> --%>
			    <li style='display:block;'>
			    <div>
			    	<c:forEach var="imgCate1" items="${ requestScope.imgCate1}">
			    		<c:set var="i" value="${ i + 1 }"/>
			    		<div id="cg0${i}" >
			    		<img style="float: left;position:none; width:100%;height:100%;" src="http://localhost:8080/team_prj3_class4/upload/category/${imgCate1.img}">
			    			<span style="position: absolute;right:95px;"><c:out value="${imgCate1.category}"/></span>
			    		</div>
			    	</c:forEach>
				</div></li>
			    <li><div>
			    	<c:forEach var="imgCate2" items="${ requestScope.imgCate2}">
			    		<c:set var="i" value="${ i + 1 }"/>
			    		<div id="cg0${i}" >
			    		<img style="float: left;position:none; width:100%;height:100%;" src="http://localhost:8080/team_prj3_class4/upload/category/${imgCate2.img}">
			    		<span style="position: absolute;right:95px;"><c:out value="${imgCate2.category}"/></span>
			    		</div>
			    	</c:forEach>
				</div></li>
			    <li><div>
			    	<c:forEach var="imgCate3" items="${ requestScope.imgCate3}">
			    		<c:set var="i" value="${ i + 1 }"/>
			    		<div id="cg0${i}" >
			    		<img style="float: left;position:none; width:100%;height:100%;" src="http://localhost:8080/team_prj3_class4/upload/category/${imgCate3.img}">
			    		<span style="position: absolute;right:95px;"><c:out value="${imgCate3.category}"/></span>
			    		</div>
			    	</c:forEach>
				</div></li>
			  </ul>
		</div>
		<input type="button" value="&lt;" class="lbtn" id="cglbtn" onclick="t01.prev();"/>
		<input type="button" value="&gt;" class="rbtn" id="cgrbtn" onclick="t01.next();"/>
		<br/><div id="pagenavi"></div>
		</div>
		
		<div id="recomnend">
		<span id="rcTitle">추천 클래스</span>
		<div class='swipe' style='margin:10px ;height:350px;padding-top: 40px;'>
			<ul id='slider2'>
				<li style='display:block'><div>
					<c:forEach var="recommend1" items="${ requestScope.recommend1}">
			    		<c:set var="a" value="${a + 1 }"/>
			    		<div id="cg0${a}" >
			    		<img style="float:left;position:none; width:100%;height:50%;" src="http://localhost:8080/team_prj3_class4/upload/lessonMain/${recommend1.main_img}">
			    			<div style="width:240px; height:50%;position: absolute;top:130px;font-size: 15px; font-weight: normal; margin: 5px;">
			    				<c:out value="${recommend1.lname}"/><br/>
			    				<%-- <c:out value="${recommend1.cliend_id}"/> --%>
			    			</div>
			    		</div>
			    	</c:forEach>
					<!-- <div id="rc01">
					추천1
					</div>
					<div id="rc02"></div>
					<div id="rc03"></div> -->
				</div></li>
				<li><div>
					<div id="rc04"></div>
					<div id="rc05"></div>
					<div id="rc06"></div>
				</div></li>
			    <li><div>
					<div id="rc07"></div>
					<div id="rc08"></div>
					<div id="rc09"></div>
				</div></li>
			</ul>
		<input type="button" value="&lt;" class="lbtn" id="rclbtn" onclick="t02.prev();"/>
		<input type="button" value="&gt;" class="rbtn" id="rcrbtn" onclick="t02.next();"/>
		<br/><div id="pagenavi"></div>
		</div>
		</div>
	
		<div id="review">
			<span id="rvTitle">최신 리뷰</span>
			<div class='swipe' style='margin:10px;padding-top: 40px;'>
			  <ul id='slider1'>
			    <li style='display:block'><div>
					<div id="rv01">
						리뷰1
					</div>
					<div id="rv02"></div>
					<div id="rv03"></div>
				</div></li>
			    <li><div>
					<div id="rv04"></div>
					<div id="rv05"></div>
					<div id="rv06"></div>
				</div></li>
			    <li><div>
					<div id="rv07"></div>
					<div id="rv08"></div>
					<div id="rv09"></div>
				</div></li>
			  </ul>
			</div>
			<button id="rvlbtn" onclick="t03.prev();">&lt;</button>
			<button id="rvrbtn" onclick="t03.next();">&gt;</button>
			<br/>
			<div id="pagenavi"></div>
		</div>

	</div>
	</div>

<script type="text/javascript">

var t00=new TouchSlider('slider4',{duration:1000, direction:0, interval:3000, autoplay:false, mousewheel:false, mouse:false, align:'center', fullsize:true});
var t01=new TouchSlider('slider3',{duration:1000, interval:6000, direction:0, autoplay:true, align:'center', mousewheel:false, mouse:false, fullsize:true});
var t02=new TouchSlider('slider2',{duration:1000, interval:8000, direction:0, autoplay:true, align:'center', mousewheel:false, mouse:false, fullsize:true});
var t03=new TouchSlider('slider1',{duration:1000, interval:3000, direction:0, autoplay:false, align:'center', mousewheel:false, mouse:false, fullsize:true});

</script>

	<div id="footer">
		<c:import url="../footer/footer.jsp" />
	</div>
</div>
</body>
</html>
