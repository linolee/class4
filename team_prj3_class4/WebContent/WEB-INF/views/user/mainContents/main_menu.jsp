<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- smartmenu 시작 -->
   <!-- SmartMenus core CSS (required) -->
   <link href="http://localhost:8080/team_prj3_class4/resources/smartmenu/css/sm-core-css.css" rel="stylesheet" type="text/css" />
   
   <!-- "sm-blue" menu theme (optional, you can use your own CSS, too) -->
   <link href="http://localhost:8080/team_prj3_class4/resources/smartmenu/css/sm-simple/sm-simple.css" rel="stylesheet" type="text/css" />
   
   <!-- jQuery -->
    <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> -->

    <!-- SmartMenus jQuery plugin -->
    <script type="text/javascript" src="http://localhost:8080/team_prj3_class4/resources/smartmenu/jquery.smartmenus.js"></script>

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
      <ul id="main-menu" class="sm sm-simple">
        <li><a href="#void">음악</a></li>
        <li><a href="#void">아트</a></li>
        <li><a href="#void">핸드메이드</a></li>
        <li><a href="#void">뷰티/헬스</a></li>
        <li><a href="#void">쿠킹</a></li>
        <li><a href="#void">가드닝</a></li>
        <li><a href="#void">액티비티</a></li>
        <li><a href="#void">여행</a></li>
        <li><a href="#void">자기계발</a></li>
        <li><a href="#void">취미</a></li>
        <li><a href="#void">IT</a></li>
        <li><a href="#void">모임</a></li>
       </ul>
	</nav>
        
        