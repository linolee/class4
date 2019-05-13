<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Class4-Main</title>
<link href="<c:url value="/resources/common/main_v190130.css"/>"rel="stylesheet">
<link href="<c:url value="/resources/maincontents/mainContents.css"/>"rel="stylesheet">
<link href="<c:url value="/resources/maincontents/style.css"/>"rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/footer.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/header.css" />" rel="stylesheet">
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
	 $(".imgcategory").click(function(){
			//location.href="http://localhost:8080/team_prj3_class4/user/search/search.do?category="+$("[name='category']").val();	
	 });
	 $(".recommend").click(function(){
			//location.href="http://localhost:8080/team_prj3_class4/user/classDetail/detail.do?lcode="+$("[name='recommend']").val();	
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
	
	<div id="headImg" style="width:1100px;height:500px;border:1px solid #333;margin-bottom: 25px;position: relative;">
		<div class='swipe'>
			<ul id='slider4'>
			    <li style='display:block; width: 1100px;height: 500px;'>
			    <div id="TitleImg1">
			    	<!-- <img src="http://localhost:8080/team_prj3_class4/resources/img/headerImg1.jpg" width="100%" height="100%" /> -->
			    	<img src="http://localhost:8080/team_prj3_class4/upload/title/titleImg01.jpg" width="100%" height="100%" />
				</div></li>
			    <li style="width: 1100px;"><div id="TitleImg2">
			    	<img src="http://localhost:8080/team_prj3_class4/upload/title/titleImg02.jpg" width="100%" height="100%" />
				</div></li>
			    <li style="width: 1100px;"><div id="TitleImg3">
			    	<img src="http://localhost:8080/team_prj3_class4/upload/title/titleImg03.jpg" width="100%" height="100%" />
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
      <li><a href="../categorySearch.do?keyword=${clist}"><c:out value="${clist}"/></a></li>
      </c:forEach>
       </ul>
	</nav>
	
	<div id="content">
		<div id="category">
		<span id="cgTitle" >카테고리</span>
		<div class='swipe' style='margin:10px ;height:350px;padding-top: 40px;padding-bottom: 20px;' >
			<ul id='slider3'>
			<%-- <c:forEach var="clist" items="${ requestScope.clist }">
      		<li><a href="#void"><c:out value="${clist}"/></a></li>
      		<c:set var="i" value="${ i + 1 }"/>
      		</c:forEach> --%>
			    <li style='display:block;height: 300px'>
		    	<c:forEach var="imgCate1" items="${ requestScope.imgCate1}">
		    		<c:set var="i" value="${ i + 1 }"/>
		    		<div id="cg0${i}" class="imgcategory" onclick="location.href='../categorySearch.do?keyword=${imgCate1.category}'">
		    		<img style="float: left;position:none; width:100%;height:100%;" src="http://localhost:8080/team_prj3_class4/upload/category/${imgCate1.img}">
	    			<div style="width:100%;clear:both;text-align:center;position: absolute;font-size: 24px; top:75px; font-weight:bold;font-family: NanumGothic, '돋움', dotum, Helvetica, sans-serif;">
	    				<label><c:out value="${imgCate1.category}"/></label>
	    			</div>
		    		</div>
		    	</c:forEach>
				</li>
			    <li>
		    	<c:forEach var="imgCate2" items="${ requestScope.imgCate2}">
		    		<c:set var="i" value="${ i + 1 }"/>
		    		<div id="cg0${i}" class="imgcategory" onclick="location.href='../categorySearch.do?keyword=${imgCate2.category}'">
		    		<img style="float: left;position:none; width:100%;height:100%;" src="http://localhost:8080/team_prj3_class4/upload/category/${imgCate2.img}">
	    			<div style="width:100%;clear:both;text-align:center;position: absolute;font-size: 24px; top:75px; font-weight:bold;font-family: NanumGothic, '돋움', dotum, Helvetica, sans-serif;">
	    				<label><c:out value="${imgCate2.category}"/></label>
	    			</div>
		    		</div>
		    	</c:forEach>
				</li>
			    <li>
		    	<c:forEach var="imgCate3" items="${ requestScope.imgCate3}">
		    		<c:set var="i" value="${ i + 1 }"/>
		    		<div id="cg0${i}" class="imgcategory" onclick="location.href='../categorySearch.do?keyword=${imgCate3.category}'">
		    		<img style="float: left;position:none; width:100%;height:100%;" src="http://localhost:8080/team_prj3_class4/upload/category/${imgCate3.img}">
	    			<div style="width:100%;clear:both;text-align:center;position: absolute;font-size: 24px; top:75px; font-weight:bold;font-family: NanumGothic, '돋움', dotum, Helvetica, sans-serif;">
	    				<label><c:out value="${imgCate3.category}"/></label>
	    			</div>
		    		</div>
		    	</c:forEach>
				</li>
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
				<li style='display:block; height: 300px'><div>
					<c:forEach var="recommend1" items="${ requestScope.recommend1}">
			    		<c:set var="a" value="${a + 1 }"/>
			    		<div id="rc0${a}" class="recommend" onclick="location.href='http://localhost:8080/team_prj3_class4/user/classDetail/detail.do?lcode=${recommend1.lcode}'">
			    		<input type="hidden" name="recommend" value="${recommend1.lcode}"/>
			    		<img style="float:left;position:none; width:100%;height:50%;" src="http://localhost:8080/team_prj3_class4/upload/lessonMain/${recommend1.main_img}">
			    			<div style="width:250px; height:105px;position: absolute;top:130px; margin: 5px;">
			    				<div style="width:250px; height:42px;font-size: 17px; font-weight:bold;">
			    					<c:out value="${recommend1.lname}"/>
			    				</div>
			    				<div style="margin:5px;height:33px;">
			    				<div style="float: left">
			    					<c:out value="${recommend1.teacher_name}"/>
			    				</div>
			    				<div style="float: right;">
			    					<c:out value="${recommend1.si}"/>><c:out value="${recommend1.gu}"/>
			    				</div>
			    				<br/>
			    				<div style="margin:5px;height:33px;float: left;position:absolute;">
			    					<c:choose>
									<c:when test="${recommend1.star le 0}">☆☆☆☆☆</c:when>
									<c:when test="${recommend1.star le 1}">★☆☆☆☆</c:when>
									<c:when test="${recommend1.star le 2}">★★☆☆☆</c:when>
									<c:when test="${recommend1.star le 3}">★★★☆☆</c:when>
									<c:when test="${recommend1.star le 4}">★★★★☆</c:when>
									<c:when test="${recommend1.star le 5}">★★★★★</c:when>
									</c:choose>
		    					</div>
			    				</div>
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
					<c:forEach var="recommend2" items="${ requestScope.recommend2}">
			    		<c:set var="a" value="${a + 1 }"/>
			    		<div id="rc0${a}" class="recommend" onclick="location.href='http://localhost:8080/team_prj3_class4/user/classDetail/detail.do?lcode=${recommend2.lcode}'">
			    		<img style="float:left;position:none; width:100%;height:50%;" src="http://localhost:8080/team_prj3_class4/upload/lessonMain/${recommend2.main_img}">
			    			<div style="width:250px; height:105px;position: absolute;top:130px; margin: 5px;">
			    				<div style="width:250px; height:42px;font-size: 17px; font-weight:bold;">
			    					<c:out value="${recommend2.lname}"/>
			    				</div>
			    				<div style="margin:5px;height:33px;">
			    				<div style="float: left">
			    					<c:out value="${recommend2.teacher_name}"/>
			    				</div>
			    				<div style="float: right;">
			    					<c:out value="${recommend2.si}"/>><c:out value="${recommend2.gu}"/>
			    				</div>
			    				<br/>
			    				<div style="margin:5px;height:33px;float: left;position:absolute;">
			    					<c:choose>
									<c:when test="${recommend2.star le 0}">☆☆☆☆☆</c:when>
									<c:when test="${recommend2.star le 1}">★☆☆☆☆</c:when>
									<c:when test="${recommend2.star le 2}">★★☆☆☆</c:when>
									<c:when test="${recommend2.star le 3}">★★★☆☆</c:when>
									<c:when test="${recommend2.star le 4}">★★★★☆</c:when>
									<c:when test="${recommend2.star le 5}">★★★★★</c:when>
									</c:choose>
		    					</div>
			    				</div>
			    			</div>
			    		</div>
			    	</c:forEach>
					<!-- <div id="rc04"></div>
					<div id="rc05"></div>
					<div id="rc06"></div> -->
				</div></li>
			    <li><div>
			    <c:forEach var="recommend3" items="${ requestScope.recommend3}">
		    		<c:set var="a" value="${a + 1 }"/>
		    		<div id="rc0${a}" class="recommend" onclick="location.href='http://localhost:8080/team_prj3_class4/user/classDetail/detail.do?lcode=${recommend3.lcode}'">
		    		<img style="float:left;position:none; width:100%;height:50%;" src="http://localhost:8080/team_prj3_class4/upload/lessonMain/${recommend3.main_img}">
		    			<div style="width:250px; height:105px;position: absolute;top:130px; margin: 5px;">
		    				<div style="width:250px; height:42px;font-size: 17px; font-weight:bold;">
		    					<c:out value="${recommend3.lname}"/>
		    				</div>
		    				<div style="margin:5px;height:33px;">
		    				<div style="float: left">
		    					<c:out value="${recommend3.teacher_name}"/>
		    				</div>
		    				<div style="float: right;">
		    					<c:out value="${recommend3.si}"/>><c:out value="${recommend3.gu}"/>
		    				</div>
		    				<br/>
		    				<div style="margin:5px;height:33px;float: left;position:absolute;">
		    					<c:choose>
								<c:when test="${recommend3.star le 0}">☆☆☆☆☆</c:when>
								<c:when test="${recommend3.star le 1}">★☆☆☆☆</c:when>
								<c:when test="${recommend3.star le 2}">★★☆☆☆</c:when>
								<c:when test="${recommend3.star le 3}">★★★☆☆</c:when>
								<c:when test="${recommend3.star le 4}">★★★★☆</c:when>
								<c:when test="${recommend3.star le 5}">★★★★★</c:when>
								</c:choose>
	    					</div>
		    				</div>
		    			</div>
			    		</div>
			    	</c:forEach>
					<!-- <div id="rc07"></div>
					<div id="rc08"></div>
					<div id="rc09"></div> -->
				</div></li>
			</ul>
		</div>
		<input type="button" value="&lt;" class="lbtn" id="rclbtn" onclick="t02.prev();"/>
		<input type="button" value="&gt;" class="rbtn" id="rcrbtn" onclick="t02.next();"/>
		<br/><div id="pagenavi"></div>
		</div>
	
		<div id="review">
			<span id="rvTitle">최신 리뷰</span>
			<div class='swipe' style='margin:10px;padding-top: 40px;padding-bottom: 50px;'>
			  <ul id='slider1'>
			    <li style='display:block; height: 300px'>
			    	<c:forEach var="latestreview1" items="${ requestScope.latestreview1}">
		    		<c:set var="j" value="${j + 1 }"/>
		    		<div id="rv0${j}" class="recommend" onclick="location.href='http://localhost:8080/team_prj3_class4/user/classDetail/detail.do?lcode=${latestreview1.lcode}#review'">
		    		<img style="float:left;position:none; width:100%;height:50%;" src="http://localhost:8080/team_prj3_class4/upload/lessonMain/${latestreview1.main_img}">
		    			<div style="width:250px; height:105px;position: absolute;top:130px; margin: 5px;">
		    				<div style="width:250px; height:35px;font-size: 15px; font-weight:bold;">
		    					<c:out value="${latestreview1.lname}"/>
		    					<%-- -<c:out value="${latestreview1.}"/> --%>
		    				</div>
		    				<div style="margin:5px;height:25px;font-size: 12px;">
		    				<div style="float: left">
		    					<c:out value="${latestreview1.client_id}"/>
		    				</div>
		    				<div style="float: right;">
		    					<c:out value="${latestreview1.r_date}"/>
		    				</div>
		    				<br/>
		    				<div style="margin:4px;height:36px;float: left;position:absolute;font-size: 13px;">
		    					<span >
		    						<c:out value="${latestreview1.contents}"/>
		    					</span>
	    					</div>
		    				</div>
		    			</div>
			    		</div>
			    	</c:forEach>
				</li>
			    <li><div>
			    	<c:forEach var="latestreview2" items="${ requestScope.latestreview2}">
		    		<c:set var="j" value="${j + 1 }"/>
		    		<div id="rv0${j}" class="recommend" onclick="location.href='http://localhost:8080/team_prj3_class4/user/classDetail/detail.do?lcode=${latestreview2.lcode}#review'">
		    		<img style="float:left;position:none; width:100%;height:50%;" src="http://localhost:8080/team_prj3_class4/upload/lessonMain/${latestreview2.main_img}">
		    			<div style="width:250px; height:105px;position: absolute;top:130px; margin: 5px;">
		    				<div style="width:250px; height:35px;font-size: 15px; font-weight:bold;">
		    					<c:out value="${latestreview2.lname}"/>
		    				</div>
		    				<div style="margin:5px;height:25px;font-size: 12px;">
		    				<div style="float: left">
		    					<c:out value="${latestreview2.client_id}"/>
		    				</div>
		    				<div style="float: right;">
		    					<c:out value="${latestreview2.r_date}"/>
		    				</div>
		    				<br/>
		    				<div style="margin:4px;height:36px;float: left;position:absolute;font-size: 13px;">
		    					<span >
		    						<c:out value="${latestreview2.contents}"/>
		    					</span>
	    					</div>
		    				</div>
		    			</div>
			    		</div>
			    	</c:forEach>
				</div></li>
			    <li><div>
			    	<c:forEach var="latestreview3" items="${ requestScope.latestreview3}">
		    		<c:set var="j" value="${j + 1 }"/>
		    		<div id="rv0${j}" class="recommend" onclick="location.href='http://localhost:8080/team_prj3_class4/user/classDetail/detail.do?lcode=${latestreview3.lcode}#review'">
		    		<img style="float:left;position:none; width:100%;height:50%;" src="http://localhost:8080/team_prj3_class4/upload/lessonMain/${latestreview3.main_img}">
		    			<div style="width:250px; height:105px;position: absolute;top:130px; margin: 5px;">
		    				<div style="width:250px; height:35px;font-size: 15px; font-weight:bold;">
		    					<c:out value="${latestreview3.lname}"/>
		    				</div>
		    				<div style="margin:5px;height:25px;font-size: 12px;">
		    				<div style="float: left">
		    					<c:out value="${latestreview3.client_id}"/>
		    				</div>
		    				<div style="float: right;">
		    					<c:out value="${latestreview3.r_date}"/>
		    				</div>
		    				<br/>
		    				<div style="margin:4px;height:36px;float: left;position:absolute;font-size: 13px;">
		    					<span >
		    						<c:out value="${latestreview3.contents}"/>
		    					</span>
	    					</div>
		    				</div>
		    			</div>
			    		</div>
			    	</c:forEach>
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
