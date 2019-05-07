<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	function lessonClosure() {
		var lcode = $("#lcode").val();
		var lname = $("#lname").val();
		var con = confirm("강의명 : " + lname + "\n강의코드 : " + lcode + "\n정말로 폐쇄하시겠습니까?");
		if (con) {
			alert(lname+"["+lcode+"]"+"강의가 폐쇄되었습니다.");
			$("#frm").submit();
		}
	}
</script>
<!--  -->
<div class="card">
	<div class="card-header">
		<i class="fa fa-align-justify"></i> 고객센터 - 신고관리
	</div>
	<div class="card-body">

		<table class="table table-responsive-sm">
			<thead>
				<tr style="border-bottom: 5px solid; border-top: 5px solid #444444; background-color: gray;">
					<th width="100px">강의명</th>
					<th width="500px"><c:out value="${ lessonInfo.lname }" /></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>강사명</td>
					<td><c:out value="${ lessonInfo.teacher_name }" /></td>
				</tr>
				<tr>
					<td>현재상태</td>
					<td><c:choose>
							<c:when test="${ lessonInfo.status eq 'Y' }">
								<span style="font-weight: bold;">강의 중</span>
							</c:when>
							<c:otherwise>
								<span style="font-weight: bold;">강의완료</span>
							</c:otherwise>
						</c:choose></td>
				</tr>
				<tr height="250px">
					<td>내용</td>
					<td>
						<table class="table table-responsive-sm">
							<thead>
								<tr>
									<th width="60px">번호</th>
									<th width="200px">신고코드</th>
									<th width="400px">신고사유</th>
									<th width="200px">고객아이디</th>
									<th width="200px">신고날짜</th>
									<th width="200px">신고승인여부</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="list" items="${ requestScope.detailList }">
									<c:set var="i" value="${ i + 1 }"/>
									<tr>
										<td><c:out value="${ (totalCount-(currentPage-1)*pageScale-i)+1 }"/></td>
										<td><c:out value="${ list.rcode }"/></td>
										<td><a href="chargeRead.do?lcode=${ param.lcode }&rcode=${ list.rcode }"><c:out value="${ list.subject }"/></a></td>
										<td><c:out value="${ list.client_id }"/></td>
										<td><c:out value="${ list.r_date }"/></td>
										<td>
											<c:choose>
												<c:when test="${ list.status eq 'T' }">
													<span style="font-weight: bold; color: #0000FF">승인됨</span>
												</c:when>
												<c:otherwise>
													<span style="font-weight: bold; color: #FF0000">대기중</span>
												</c:otherwise>
											</c:choose>
										</td>
									</tr>
								</c:forEach>
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
					</td>
				</tr>
			</tbody>
		</table>
		<div style="text-align: right">
			<div style="display: inline-block;">
				<ul class="pagination ">
					<li class="page-item"><a class="page-link" href="charge.do">목록으로</a></li>
					<li class="page-item"><a class="page-link" href="#" onclick="lessonClosure()">강의폐쇄</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<input type="hidden" id="lname" name="lname" value="${ lessonInfo.lname }">
<form id="frm" action="lessonClosure.do" method="post">
	<input type="hidden" id="lcode" name="lcode" value="${ param.lcode }">
</form>


<!--  -->
