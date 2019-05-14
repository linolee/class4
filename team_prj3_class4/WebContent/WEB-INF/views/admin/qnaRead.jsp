<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- include summernote css/js -->
<link href="http://211.63.89.152/resources/summernote/summernote-lite.css" rel="stylesheet">
<script src="http://211.63.89.152/resources/summernote/summernote-lite.js"></script>
<script src="http://211.63.89.152/resources/summernote/lang/summernote-ko-KR.js"></script>
<script type="text/javascript">
$(function () {
	$('.summernote_q').summernote({ airMode: true });
	$('.summernote_q').summernote('disable');
})
$(function () {
	$('.summernote_a').summernote({
        placeholder: '답변을 입력해 주세요', 
        //toolbar: false,
        tabsize: 2,
        height: 280,
        lang: 'ko-KR'
     });
})
</script>
<!-- summernote 관련 library 끝 -->    
    
    
<script type="text/javascript">
	function addAnswer() {
		qcode = $("#qcode").val();
		acontents = $("#acontents").val();
		if(acontents == ""){
			alert("답변을 입력해주세요.");
			return;
		}
		alert("답변이 등록되었습니다.");
		//location.href="addQnaAnswer.do?qcode="+qcode+"&acontents="+acontents;
		$("#frm").submit();
	}
	function editAnswer() {
		qcode = $("#qcode").val();
		acontents = $("#acontents").val();
		if(acontents == ""){
			alert("답변을 입력해주세요.");
			return;
		}
		alert("답변이 수정되었습니다.");
		$("#frm").submit();
	}
</script>
<!--  -->
<div class="card">
	<div class="card-header">
		<i class="fa fa-align-justify"></i> 고객센터 - 문의관리</div>
	<div class="card-body">      		 
		<table class="table table-responsive-sm">
			<thead>
				<tr style="border-bottom: 5px solid; border-top: 5px solid #444444; background-color: gray;" >
					<th width="100px" >제목</th>
					<th width="500px"><c:out value="${ searchData.q_subject }"/></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>작성자</td>
					<td><c:out value="${ searchData.client_id }"/></td>
				</tr>
				<tr height="250px">
					<td>내용</td>
					<%-- <td><c:out value="${ searchData.q_contents }"/></td> --%>
					<td>
						<textarea class="summernote_q"><c:out value="${ searchData.q_contents }"/></textarea>
					</td>
				</tr>
				<tr style="border-bottom: 5px solid; border-top: 5px solid #444444; background-color: gray;">
					<td>답변</td>
					<td><strong><c:out value=" RE : [${ searchData.q_subject }] 문의에 대한 답변입니다."/></strong></td>
				</tr>
				<tr height="250px">
					<td>내용</td>
					<td>
						<form id="frm" action="addQnaAnswer.do" method="post">
							<input type="hidden" id="qcode" name="qcode" value="${ param.qnum }">
<%-- 							<textarea id="acontents" name="acontents" class="form-control" rows="10" style="min-width: 100%;" placeholder="답변을 입력해주세요.">
								<c:out value="${ searchData.a_contents }" escapeXml="false"/>
							</textarea> --%>
							<textarea name="acontents" class="summernote_a" id="acontents"><c:out value="${ searchData.a_contents }"/></textarea>
						</form>
					</td>
				</tr>
			</tbody>
		</table>
		<div style="text-align: right">
			<div style="display: inline-block;">
				<ul class="pagination "  >
					<li class="page-item">
						<a class="page-link" href="#" onclick="history.back()">목록</a>
					</li>
					<li class="page-item">
						<c:choose>
							<c:when test="${ searchData.a_date eq null }">
								<a class="page-link" href="#" onclick="addAnswer()">등록</a>
							</c:when>
							<c:otherwise>
								<a class="page-link" href="#" onclick="editAnswer()">수정</a>
							</c:otherwise>
						</c:choose>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>

<!--  -->
