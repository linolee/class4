<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	session.setAttribute("writeFlag", false);
%>
<div id="writeFrm">
<form action="mypage_jjim.jsp" method="post" name="writeFrm">
<input type="hidden" name="pageFlag" value="write_process"/>
<input type="hidden" name="param_year" value="${param.param_year }"/>
<input type="hidden" name="param_month" value="${param.param_month }"/>
<table id="writeTab">
	<tr>
		<th colspan="2" style="text-align: left">
			<span style="font-size: 40px">클래스 후기 작성</span>
			<span style="float:right; padding-right: 20px">
			<a href="#void" id="btnCloseFrm"><!-- <img src="images/close.png"/> --></a>
			</span>
		</th>
	</tr>
	<tr>
		<td style="width: 100px; height: 30px;">별점</td>
		<td style="width: 600px; height: 30px;">
		<select id="point">
		<option value="1">★☆☆☆☆</option>
		<option value="2">★★☆☆☆</option>
		<option value="3">★★★☆☆</option>
		<option value="4">★★★★☆</option>
		<option value="5">★★★★★</option>
		</select>
		</td>
	</tr>
	<tr>
		<td style="width: 100px; height: 30px; " valign="top">내용</td>
		<td style="width: 600px">
			<textarea rows="10" cols="45" id="review"></textarea>
		</td>
	</tr>
	<tr>
		<td style="width: 100px">작성자</td>
		<td style="width: 600px">
			<input type="text" name="writer" id="writer" class="inputBox"
				style="width: 150px; height: 30px;" value="${client_id }" readonly="readonly"/>
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
			<input type="button" value="이벤트 작성" class="btn" id="btnWrite" onclick="write1('${param.lcode}')"/>
			<input type="button" value="닫기" class="btn" id="btnWriteClose"/>
		</td>
	</tr>
</table>
</form>
</div>