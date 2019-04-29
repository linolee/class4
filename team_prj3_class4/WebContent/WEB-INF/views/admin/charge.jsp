<%@page import="kr.co.sist.admin.domain.MemberListDomain"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.admin.service.MemberListService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <%
	MemberListService as=new MemberListService();
	// if(MemberListDomain!=null){
		List<MemberListDomain> list=as.selectAllMember();
		pageContext.setAttribute("MemberListDomain", list);
	// }
%> --%>



<!--  -->
<div class="card">
	<div class="card-header">
		<i class="fa fa-align-justify"></i> 신고관리

		
		
		
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
		<table class="table table-responsive-sm">
			<thead>
				<tr>
					<th width="200px">강의코드</th>
					<th width="200px">강의명</th>
					<th width="200px">강사명</th>
					<th width="100px">누적횟수</th>
					<th width="300px">승인횟수</th>
					<th width="200px">현재상태</th>
				</tr>
			</thead>
			<tbody>
				<!--  -->
				<c:if test="${ empty MemberListDomain }">
				<tr>
					<td colspan="6" align="center">
						<strong>등록된 회원이 없습니다</strong>
					</td>
				</tr>
				</c:if>
				
				<c:forEach var="member" items="${ MemberListDomain }">
				<tr>		
					<td><c:out value="${ member.client_id }"/></td>
					<td><c:out value="${ member.name }"/></td>
					<td><c:out value="${ member.birth }"/></td>
					<td><c:out value="${ member.gender }"/></td>
					<td><c:out value="${ member.email }"/></td>
					<td>
						<form method="get" action="./member.jsp" class="form-inline">
							<a data-toggle="modal" href="#modalUserInfo"><span	class="badge badge-primary">상세정보</span></a> 
							<a data-toggle="modal" href="#modalAddBlackList"><span class="badge badge-primary">블랙리스트 등록</span></a> 
							<a data-toggle="modal" href="#modalTeacherInfo"><span class="badge badge-primary">강사정보</span></a>
						</form>
					</td>
				</tr>
				</c:forEach>
						
				<!--  -->
			</tbody>
		</table>
		<div style="text-align: center">
			<div style="display: inline-block;">
				<ul class="pagination ">
					<li class="page-item"><a class="page-link" href="#">Prev</a></li>
					<li class="page-item active"><a class="page-link" href="#">1</a>
					</li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#">4</a></li>
					<li class="page-item"><a class="page-link" href="#">5</a></li>
					<li class="page-item"><a class="page-link" href="#">Next</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<c:import url="modalUserInfo.jsp"/>
<c:import url="modalAddBlackList.jsp"/>
<c:import url="modalTeacherInfo.jsp"/>
<!--  -->

