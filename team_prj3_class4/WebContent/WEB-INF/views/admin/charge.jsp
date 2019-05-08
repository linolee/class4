<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--  -->
<div class="card">
	<div class="card-header">
		<i class="fa fa-align-justify"></i> 신고관리
	</div>
	<div class="card-body">
<%-- 		<form name="membersearchf" class="form-inline"
			action="<?php echo $link_url;?>">
			<input type="hidden" name="orderby" value="<?php echo $xorderby;?>" />
			<select name="where" class="form-control input-sm">
				<option value="userNM">이름</option>
				<option value="userID">아이디</option>
			</select>
			<div class="input-group input-group-sm">
				<input type="text" name="keyword" value=""
					class="form-control input-search" placeholder="검색어"
					style="height: 35px;"> <span class="input-group-btn">
					<span class="input-group-btn">
						<button type="submit" class="btn btn-info" title="검색">
							<i class="glyphicon glyphicon-search"></i>
						</button>
				</span>
				</span>
			</div>
		</form>
		<br /> <br /> --%>
		<table class="table table-responsive-sm">
			<thead>
				<tr>
					<th width="60px">번호</th>
					<th width="200px">강의코드</th>
					<th width="400px">강의명</th>
					<th width="200px">강사명</th>
					<th width="100px">누적횟수</th>
					<th width="100px">승인횟수</th>
					<th width="100px">현재상태</th>
				</tr>
			</thead>
			<tbody>
				<!--  -->
				<c:if test="${ empty requestScope.list }">
					<tr>
						<td colspan="7" align="center"><strong>등록된 신고사항이
								없습니다</strong></td>
					</tr>
				</c:if>

				<c:forEach var="clist" items="${ requestScope.list }">
					<c:set var="i" value="${ i + 1 }" />
					<tr>
						<td><c:out
								value="${ (totalCount-(currentPage-1)*pageScale-i)+1 }" /></td>
						<td><c:out value="${ clist.lcode }" /></td>
						<td><a href="chargeReadList.do?lcode=${ clist.lcode }"><c:out
									value="${ clist.lname }" /></a></td>
						<td><c:out value="${ clist.teacher_name }" /></td>
						<td><c:out value="${ clist.all_report }" /></td>
						<td><c:out value="${ clist.apply_report }" /></td>
						<td><c:choose>
								<c:when test="${ clist.status eq 'Y' }">
									<span style="font-weight: bold;">강의 중</span>
								</c:when>
								<c:otherwise>
									<span style="font-weight: bold;">강의완료</span>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>

				<!--  -->
			</tbody>
		</table>
		<div style="text-align: center">
			<div style="display: inline-block;">
				<ul class="pagination ">
					<c:out value="${ indexList }" escapeXml="false" />
					<!-- escapeXml은 c:out으로 태그를 출력하게 만든다 -->
				</ul>
			</div>
		</div>

	</div>
</div>


