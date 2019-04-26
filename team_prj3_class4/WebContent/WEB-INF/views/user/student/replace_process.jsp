<%-- <%@page import="java.sql.SQLException"%>
<%@page import="kr.co.sist.diary.dao.DiaryDAO"%>
<%@page import="kr.co.sist.util.ShaUtill"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="d_vo" class="kr.co.sist.diary.vo.DiaryVO" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="d_vo"/>
<jsp:setProperty property="ip" name="d_vo" value="<%=request.getRemoteAddr()%>"/>

<script type="text/javascript">
$(window).load(function(){
<%
	d_vo.setPass(ShaUtill.shaEncoding(d_vo.getPass()));
	//새로고침(F5)로 중복 실행 방지 세션
	Boolean flag=(Boolean)session.getAttribute("writeFlag");
	if(flag != null && !flag){
		
	DiaryDAO d_dao=DiaryDAO.getInstance();
	try{
		d_dao.insertEvent(d_vo);
		session.setAttribute("writeFlag", true);
		%>
		alert("이벤트가 정상적으로 등록 되었읍니다.");
		location.href="diary2.jsp?param_year=${param.param_year}&param_month=${param.param_month}";
		<%
	}catch(SQLException se){
		%>
		alert("이벤트가 정상적으로 등록되지 아니한 점 ㅈㅅ");
		<%
		se.printStackTrace();
	}//end catch
	}//end if
%>
});//ready 
</script>--%>