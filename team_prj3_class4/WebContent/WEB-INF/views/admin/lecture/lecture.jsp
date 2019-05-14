<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--  -->
<div class="card">
	<div class="card-header">
		<h5 style="margin-bottom: 0px;"><strong>강의 조회</strong></h5>
	</div>
	<div class="card-body">
               		 
		<div class='searchbox' style="height: 50px;">
    		<form name="lectureSearch" class="form-inline" action="lecture.do" method="get">
				<select name="searchOption" id="searchOption" class="form-control input-sm">
            		<option value="lcode">강의코드</option>
            		<option value="lname">강의명</option>
            		<option value="teacher_name">강사명</option>
				</select>
        <div class="input-group input-group-sm">
			<input type="text" name="keyword" id="keyword" value="" class="form-control input-search" placeholder="검색어" style="height:35px;">
            <span class="input-group-btn">
                <span class="input-group-btn">
               		 <button type="submit" id="searchBtn" class="btn btn-secondary" title="검색"><i class="glyphicon glyphicon-search"></i></button>
           		</span>
            </span>
        </div>
			</form>
		<br/>
		</div>
		
		<div style="padding-bottom: 10px;">
			<a href="lecture.do"><input type="button" class="btn btn-brand btn-instagram" value="전체" id="search" style="margin-bottom: 4px;"/></a>
			<a href="lecture.do?status=Y"><input type="button" class="btn btn-brand btn-vine" value="오픈" id="search" style="margin-bottom: 4px;"/></a>
			<a href="lecture.do?status=F"><input type="button" class="btn btn-brand btn-dribbble" value="마감" id="search" style="margin-bottom: 4px;"/></a>
			<a href="lecture.do?status=I"><input type="button" class="btn btn-brand btn-github" value="진행중" id="search" style="margin-bottom: 4px;"/></a>
			<a href="lecture.do?status=E"><input type="button" class="btn btn-brand btn-twitter" value="종료" id="search" style="margin-bottom: 4px;"/></a>
			<a href="lecture.do?status=R"><input type="button" class="btn btn-brand btn-spotify" value="준비중" id="search" style="margin-bottom: 4px;"/></a>
			<a href="lecture.do?status=C"><input type="button" class="btn btn-brand btn-youtube" value="취소/거절" id="search" style="margin-bottom: 4px;"/></a>
		</div>

	<table class="table table-responsive-sm table-striped" style="text-align:center">
		<thead>
			<tr>
				<th width="150px">강의코드</th>
				<th width="150px">카테고리</th>
				<th width="350px" align="center">강의명</th>
				<th width="250px">강사명</th>
				<th width="150px">진행상황</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty lectureList }">
				<tr>
					<td colspan="5" align="center">
						<strong>등록된 강의가 없습니다</strong>
					</td>
				</tr>
			</c:if>
                      	
			<c:forEach var="lecture" items="${lectureList }">
                      	<tr>
                      		<td><c:out value="${lecture.lcode }"/></td>
                      		<td><c:out value="${lecture.category }"/></td>
                      		<td>
                      			<a href="../user/classDetail/detail.do?lcode=${lecture.lcode }" target="_blank">
                      				<c:out value="${lecture.lname }"/>
                      			</a>
                      		</td>
                      		<td><c:out value="${lecture.teacher_name }"/></td>
                      		
                      		<c:set var="status" value="${lecture.status }" />
							<c:choose>
							    <c:when test="${status eq 'A'}">
							        <td>승인대기</td>
							    </c:when>
							    <c:when test="${status eq 'R'}">
							        <td>준비중</td>
							    </c:when>
							    <c:when test="${status eq 'Y'}">
							        <td>오픈</td>
							    </c:when>
							    <c:when test="${status eq 'F'}">
							        <td>마감</td>
							    </c:when>
							    <c:when test="${status eq 'I'}">
							        <td>진행중</td>
							    </c:when>
							    <c:when test="${status eq 'E'}">
							        <td>종료</td>
							    </c:when>
							    <c:when test="${status eq 'C'}">
							        <td>취소</td>
							    </c:when>
							    <c:otherwise>
							        <td>알수없음</td>
							    </c:otherwise>
							</c:choose>

                      	</tr>
			</c:forEach>
		</tbody>
	</table>
	<div style="text-align: center">
		<div style="display: inline-block;">
			<ul class="pagination">
				<c:out value="${ indexList }" escapeXml="false"/>
			</ul>
		</div>
	</div>
	</div>
</div>       
