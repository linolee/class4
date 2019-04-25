<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- smartmenu 시작 -->
	<!-- SmartMenus core CSS (required) -->
    <link href="http://211.63.89.151:8080/team_prj3_class4/common/smartmenu/css/sm-core-css.css" rel="stylesheet" type="text/css" />

    <!-- "sm-blue" menu theme (optional, you can use your own CSS, too) -->
    <link href="http://211.63.89.151:8080/team_prj3_class4/common/smartmenu/css/sm-mint/sm-mint.css" rel="stylesheet" type="text/css" />
    
    <!-- jQuery -->
<!-- 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> -->

    <!-- SmartMenus jQuery plugin -->
    <script type="text/javascript" src="http://211.63.89.151:8080/team_prj3_class4/common/smartmenu/jquery.smartmenus.min.js"></script>

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
       <li><a href="http://211.63.89.151:8080/team_prj3_class4/diary/diary2.jsp#void">홈으로</a></li>
       <li><a href="#void">일정관리</a>
         <ul>
           <li><a href="http://211.63.89.151:8080/team_prj3_class4/diary/diary2.jsp">캘린더</a></li>
           <li><a href="http://211.63.89.151:8080/team_prj3_class4/diary/list.jsp">게시판</a></li>
           <li><a href="http://sist.co.kr">쌍용교육센터</a></li>
           <li><a href="#void">1조</a>
             <ul>
               <li><a href="http://youtube.com">이재찬</a></li>
               <li><a href="http://comic.naver.com">김민정</a></li>
               <li><a href="http://google.com">김정운</a></li>
               <li><a href="http://naver.com">정택성</a></li>
             </ul>
           </li>
         </ul>
       </li>
       <li><a href="http://211.63.89.151:8080/team_prj3_class4/day0319/file_list.jsp">Download</a></li>
       <li><a href="http://211.63.89.151:8080/team_prj3_class4/day0320/mr_upload_form.jsp">당신도 김본좌!!!</a>
       <li><a href="http://localhost:8080/team_prj3_class4/xml0326/jtbc_rss.jsp">JTBC RSS</a></li>
       </li>
    </ul>
</nav>
