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
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/header.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/footer.css" />" rel="stylesheet">
<!-- google font -->
<link href="https://fonts.googleapis.com/css?family=PT+Sans"
	rel="stylesheet">
<style type="text/css">
#wrapper {
	font-family: 'PT Sans', sans-serif;
}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="http://localhost:8080/team_prj3_class4/resources/maincontents/touchslider.js"></script>
<script type="text/javascript">
 $(function(){
	 
 });//ready
</script>
</head>
<body>
<div id="wrap">
	<div id="header">
		<c:import url="../header/header.jsp"></c:import>
	</div>
	<div id="container">
	
	<div id="headImg" style="width:1100px;height:500px;border:1px solid #333;margin-top: 15px;margin-bottom: 15px;">
		<div class='swipe' style='margin:10px ;height:350px;width:2000px;'>
			<ul id='slider4'>
			    <li style='display:block'>
			    <div id="TitleImg1">
			    	1번 이미지      
				</div></li>
			    <li><div id="TitleImg2">
					2번 이미지
				</div></li>
			    <li><div id="TitleImg3">
					3번 이미지
				</div></li>
			  </ul>
		</div>
		<input type="button" value="&lt;" class="lbtn" id="tilbtn" onclick="t00.prev();"/>
		<input type="button" value="&gt;" class="rbtn" id="tirbtn" onclick="t00.next();"/>
		<br/><div id="pagenavi"></div>
	</div>
	<c:import url="../mainContents/main_menu.jsp"></c:import>
	<div id="content">
		<div id="category">
		<span id="cgTitle">카테고리</span>
		<div class='swipe' style='margin:10px ;height:350px;width:2000px;'>
			<ul id='slider3'>
			    <li style='display:block'><div>
					<div id="cg01">음악</div>
					<div id="cg02">아트</div>
					<div id="cg03">핸드메이드</div>
				</div></li>
			    <li><div>
					<div id="cg04">뷰티/헬스</div>
					<div id="cg05">쿠킹</div>
					<div id="cg06">가드닝</div>
				</div></li>
			    <li><div>
					<div id="cg07">액티비티</div>
					<div id="cg08">자기계발</div>
					<div id="cg09">취미</div>
				</div></li>
			  </ul>
		</div>
		<input type="button" value="&lt;" class="lbtn" id="cglbtn" onclick="t01.prev();"/>
		<input type="button" value="&gt;" class="rbtn" id="cgrbtn" onclick="t01.next();"/>
		<br/><div id="pagenavi"></div>
		</div>
		
		<div id="recomnend">
		<span id="rcTitle">추천 클래스</span>
		<div class='swipe' style='margin:10px ;height:350px;width:2000px;'>
			<ul id='slider2'>
				<li style='display:block'><div>
					<div id="rc01">
					
					</div>
					<div id="rc02"></div>
					<div id="rc03"></div>
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
			<div class='swipe' style='margin:10px;width:2000px;'>
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
<!-- 		<input type="button" value="letf" class="lbtn" id="rvlbtn"/>
		<input type="button" value="right" class="rbtn" id="rvrbtn"/> -->

	</div>
	</div>

<script type="text/javascript">
console=window.console || {dir:new Function(),log:new Function()};
var active=0,
	as=document.getElementById('pagenavi').getElementsByTagName('a');
for(var i=0;i<as.length;i++){
	(function(){
		var j=i;
		as[i].onclick=function(){
			t4.slide(j);
			return false;
		}
	})();
}

var t00=new TouchSlider('slider4',{duration:1000, interval:1000, direction:0, autoplay:false, align:'center', mousewheel:false, mouse:false, fullsize:true});
var t01=new TouchSlider('slider3',{duration:1000, interval:3000, direction:0, autoplay:true, align:'center', mousewheel:false, mouse:false, fullsize:true});
var t02=new TouchSlider('slider2',{duration:1000, interval:3000, direction:0, autoplay:true, align:'middle', mousewheel:false, mouse:false, fullsize:true});
var t03=new TouchSlider('slider1',{duration:1000, interval:3000, direction:0, autoplay:true, align:'center', mousewheel:false, mouse:false, fullsize:true});
t4.on('before',function(m,n){
    as[m].className='';
	as[n].className='active';
})
</script>

	<div id="footer">
		<c:import url="../footer/footer.jsp" />
	</div>
</div>
</body>
</html>
