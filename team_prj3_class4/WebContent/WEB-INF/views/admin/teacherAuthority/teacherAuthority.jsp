<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  -->
<div class="card">
	<div class="card-header">
		<i class="fa fa-align-justify"></i> 강사 권한 승인
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
		<table class="table table-responsive-sm" style="text-align:center">
			<thead>
				<tr>
					<th width="100px">번호</th>
					<th width="200px">아이디</th>
					<th width="200px">이름</th>
					<th width="200px">생년월일</th>
					<th width="100px">성별</th>
					<th width="300px">이메일</th>
					<th width="200px">비고</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty teacherPermitList }">
				<tr>
					<td colspan="6" align="center">
						<strong>승인 대기중인 강사가 없습니다</strong>
					</td>
				</tr>
				</c:if>
				
				<c:forEach var="teacherPermit" items="${teacherPermitList }">
				<c:set var="i" value="${i+1}"/>
				<tr>
					<td><c:out value="${ (totalCount-(currentPage-1)*pageScale-i)+1 }"/></td>
					<td><c:out value="${teacherPermit.client_id }"/></td>
					<td><c:out value="${teacherPermit.teacher_name }"/></td>
					<td><c:out value="${teacherPermit.birth }"/></td>
					<td><c:out value="${teacherPermit.gender }"/></td>
					<td><c:out value="${teacherPermit.email }"/></td>
					<td>
						<form method="get" action="./member.jsp" class="form-inline">
							<a data-toggle="modal" href="#modalTAuthority"><span
								class="badge badge-primary">상세정보</span></a>
						</form>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<div style="text-align: center">
			<div style="display: inline-block;">
				<ul class="pagination ">
					<c:out value="${ indexList }" escapeXml="false"/>
				</ul>
			</div>
		</div>
	</div>
</div>


<c:import url="teacherAuthority/modalTAuthority.jsp"/>
