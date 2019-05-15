<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- SmartMenu 시작 -->
<!-- SmartMenus core CSS (required) -->
<link href="http://localhost:8080/spring_mvc/common/smartmenu/css/sm-core-css.css" rel="stylesheet" type="text/css" />

<!-- "sm-blue" menu theme (optional, you can use your own CSS, too) -->
<link href="http://localhost:8080/spring_mvc/common/smartmenu/css/sm-simple/sm-simple.css" rel="stylesheet" type="text/css" />
<!-- jQuery -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> -->

<!-- SmartMenus jQuery plugin -->
<script type="text/javascript" src="http://localhost:8080/team_prj3_class4/common/smartmenu/jquery.smartmenus.min.js"></script>

<!-- SmartMenus jQuery init -->
<script type="text/javascript">
    $(function() {
    	$('#main-menu').smartmenus({
    		subMenusSubOffsetX: 1,
    		subMenusSubOffsetY: -8
    	});
    });

</script>
<!-- SmartMenu 끝 -->

		<nav id="main-nav">
	      <!-- Sample menu definition -->
	      <ul id="main-menu" class="sm sm-simple">
	        <li><a href="../main.do">홈으로</a></li>
	        <li><a href="classStatus.do">클래스 현황</a></li>
	        <li><a href="classRegist.do">클래스 등록</a></li>
	        <li><a href="classReview.do">후기/문의</a></li>
<!-- 	        <li><a href="adminQuestion.do">관리자 문의</a></li> -->
	        <li><a href="teacherProfile.do">강사 프로필 관리</a></li>
	      </ul>
        </nav>
		