<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- smartmenu 시작 -->
	<!-- SmartMenus core CSS (required) -->
    <link href="http://211.63.89.148:8080/team_prj3_class4/common/smartmenu/css/sm-core-css.css" rel="stylesheet" type="text/css" />

    <!-- "sm-blue" menu theme (optional, you can use your own CSS, too) -->
    <link href="http://211.63.89.148:8080/team_prj3_class4/common/smartmenu/css/sm-mint/sm-mint.css" rel="stylesheet" type="text/css" />
    
    <!-- jQuery -->
<!-- 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> -->

    <!-- SmartMenus jQuery plugin -->
    <script type="text/javascript" src="http://211.63.89.148:8080/team_prj3_class4/common/smartmenu/jquery.smartmenus.min.js"></script>

    <!-- SmartMenus jQuery init -->
    <script type="text/javascript">
    	$(function() {
    		$('#main-menu').smartmenus({
    			subMenusSubOffsetX: 1,
    			subMenusSubOffsetY: -8
    		});
    	});
    </script>
    
<!-- smartmenu 끝 -->
<nav id="main-nav">
    <!-- Sample menu definition -->
    <ul id="main-menu" class="sm sm-mint">
       <li><a href="http://211.63.89.148:8080/team_prj3_class4/user/student/mypage_list.do">수강이력</a></li>
       <li><a href="http://211.63.89.148:8080/team_prj3_class4/user/student/mypage_assess.do">수강평</a></li>
       <li><a href="http://211.63.89.148:8080/team_prj3_class4/user/student/mypage_jjim.do">찜강의</a></li>
       <li><a href="http://211.63.89.148:8080/team_prj3_class4/user/student/mypage_cancel.do">수강철회</a>
       <li><a href="http://211.63.89.148:8080/team_prj3_class4/user/student/mypage_q&a.do">질문/답변</a></li>
       <li><a href="http://211.63.89.148:8080/team_prj3_class4/user/student/mypage_report.do">강의신고</a></li>
    </ul>
</nav>
