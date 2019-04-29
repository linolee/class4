<%@page import="kr.co.sist.admin.domain.MemberListDomain"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.admin.service.MemberListService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--  -->
<div class="card">
	<div class="card-header">
		<i class="fa fa-align-justify"></i> 문의관리

	</div>
	<div class="card-body">
		<form name="membersearchf" class="form-inline" action="<?php echo $link_url;?>">
        <input type="hidden" name="orderby" value="<?php echo $xorderby;?>" />
        <select name="where" class="form-control input-sm">
            <option value="userNM">이름</option>
            <option value="userID">아이디</option>
        </select>
        <div class="input-group input-group-sm">
            <input type="text" name="keyword" value="" class="form-control input-search" placeholder="검색어" style="height:35px;">
            <span class="input-group-btn">
                <span class="input-group-btn">
               		 <button type="submit" class="btn btn-info" title="검색"><i class="glyphicon glyphicon-search"></i></button>
           		</span>
            </span>
        </div>
  	  </form>
  	  
		<br/>
		<br />
		<table class="table table-responsive">
			<thead>
				<tr>
					<th width="100px">번호</th>
					<th width="400px">제목</th>
					<th width="100px">작성자</th>
					<th width="200px">등록일</th>
					<th width="100px">답변상태</th>
					<th width="100px">비고</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${ empty requestScope.list }">
				<tr>
					<td colspan="6" align="center">
						<strong>등록된 회원이 없습니다</strong>
					</td>
				</tr>
				</c:if>
				
				<c:forEach var="qlist" items="${ requestScope.list }">
				<c:set var="i" value="${ i + 1 }"/>
				<tr>
           			<td><c:out value="${ (totalCount-(currentPage-1)*pageScale-i)+1 }"/></td>
					<td><c:out value="${ qlist.qSubject }"/></td>
					<td><c:out value="${ qlist.name }"/></td>
					<td><c:out value="${ qlist.qDate }"/></td>
					<td><c:out value="${ qlist.aDate }"/></td>
					<td></td>
				</tr>
         		</c:forEach>
						
				<!--  -->
			</tbody>
		</table>
		
		<div style="text-align: center">
			<div style="display: inline-block;">
				<ul class="pagination ">
					<c:out value="${ indexList }" escapeXml="false"/> <!-- escapeXml은 c:out으로 태그를 출력하게 만든다 -->
				</ul>
			</div>
		</div>
		
	</div>
</div>
<c:import url="modalUserInfo.jsp"/>
<c:import url="modalAddBlackList.jsp"/>
<c:import url="modalTeacherInfo.jsp"/>
<!--  -->

