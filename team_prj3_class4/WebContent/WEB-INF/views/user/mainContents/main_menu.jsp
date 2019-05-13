<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- smartmenu 시작 -->
   <!-- SmartMenus core CSS (required) -->
   <link href="<c:url value="/resources/smartmenu/css/sm-core-css.css"/>"rel="stylesheet">
   
   <!-- "sm-blue" menu theme (optional, you can use your own CSS, too) -->
   <link href="<c:url value="/resources/smartmenu/css/sm-simple/sm-simple.css"/>"rel="stylesheet">
   
   <!-- jQuery -->
    <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> -->

    <!-- SmartMenus jQuery plugin -->
    <script type="text/javascript" src="<c:url value="/resources/smartmenu/jquery.smartmenus.js"/>"></script>

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


        
        