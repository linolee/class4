<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	session.setAttribute("writeFlag", false);
%>
<table id="writeTab">
	<tr>
		<th colspan="2" style="text-align: left">
			<span style="font-size: 40px">답변내용</span>
			<span style="float:right; padding-right: 20px">
			<a href="#void" id="btnCloseFrm"><!-- <img src="images/close.png"/> --></a>
			</span>
		</th>
	</tr>
	<tr>
		<td style="width: 100px; height: 30px; " valign="top">내용</td>
		<td style="width: 600px">
			<textarea rows="10" cols="45" id="review"></textarea>
		</td>
	</tr>
	<tr>
		<td style="width: 100px">작성일</td>
		<td style="width: 600px">
		<fmt:formatDate value="<%=new Date() %>" 
				pattern="yyyy-MM-dd a EEEE HH:mm"/>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="button" value="닫기" class="btn" id="btnReadClose"/>
		</td>
	</tr>
</table>
