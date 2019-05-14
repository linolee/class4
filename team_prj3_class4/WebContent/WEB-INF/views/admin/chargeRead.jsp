<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- include summernote css/js -->
<link href="http://211.63.89.152/resources/summernote/summernote-lite.css" rel="stylesheet">
<script src="http://211.63.89.152/resources/summernote/summernote-lite.js"></script>
<script src="http://211.63.89.152/resources/summernote/lang/summernote-ko-KR.js"></script>
<script type="text/javascript">
$(function () {
	$('.summernote_q').summernote({ airMode: true });
	$('.summernote_q').summernote('disable');
})
</script>
<!-- summernote 관련 library 끝 -->    
<script type="text/javascript">
	function chargeRefuse(chk) {
		var rcode = $("#rcode").val();
		var subject = $("#subject").val();
		var con 
		if(chk == 'N'){
			con = confirm("신고명 : " + subject + "\n신고코드 : " + rcode + "\n정말로 반려하시겠습니까?");
			if (con) {
				alert(subject+"["+rcode+"]"+"신고가 반려되었습니다.");
				$("#frm_N").submit();
			}
		}else{
			con = confirm("신고명 : " + subject + "\n신고코드 : " + rcode + "\n정말로 승인하시겠습니까?");
			if (con) {
				alert(subject+"["+rcode+"]"+"신고가 승인되었습니다.");
				$("#frm_Y").submit();
			}
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
					<th width="100px">신고</th>
					<th width="500px"><c:out value="${ searchData.subject }" /></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>고객아이디</td>
					<td><c:out value="${ searchData.client_id }" /></td>
				</tr>
				<tr height="250px">
					<td>내용</td>
					<td>
						<textarea class="summernote_q"><c:out value="${ searchData.contents }" /></textarea>
					</td>
				</tr>
			</tbody>
		</table>
		<div style="text-align: right">
			<div style="display: inline-block;">
				<ul class="pagination ">
					<li class="page-item"><a class="page-link" href="chargeReadList.do?lcode=${ param.lcode }">목록으로</a></li>
					<!-- <li class="page-item"><a class="page-link" href="#" onclick="lessonClosure()">강사경고</a></li> -->
					<c:if test="${ searchData.status eq 'N' }">
						<li class="page-item"><a class="page-link" href="#" onclick="chargeRefuse('Y')">신고승인</a></li>
					</c:if>
					<li class="page-item"><a class="page-link" href="#" onclick="chargeRefuse('N')">신고반려</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<input type="hidden" id="subject" name="subject" value="${ searchData.subject }">
<form id="frm_Y" action="chargeRefuse.do" method="post">
	<input type="hidden" id="rcode" name="rcode" value="${ param.rcode }">
	<input type="hidden" id="refuse" name="refuse" value="Y">
</form>
<form id="frm_N" action="chargeRefuse.do" method="post">
	<input type="hidden" id="rcode" name="rcode" value="${ param.rcode }">
	<input type="hidden" id="refuse" name="refuse" value="N">
</form>

<!--  -->
