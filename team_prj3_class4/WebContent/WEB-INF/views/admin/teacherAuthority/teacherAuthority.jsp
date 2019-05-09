<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
function teacherPermitInfo(id, tName) {
 	var queryString="id="+id+"&tName="+tName;
 	$.ajax({
		url: "teacherPermitDetail.do",
		data: queryString,
		type: "get",
		dataType: "json",
		error: function(xhr) {
			alert("강사정보 조회 실패");
			console.log(xhr.status + "/" + xhr.statusText);
		},
		success:function( json ){
			var space = /\+/g;
			$("#tId").text(json.tId);
			$("#tCategory").text(decodeURIComponent(json.tCate));
			$("#tName").text(decodeURIComponent(json.tName));
			$("#tnName").text(decodeURIComponent(json.tTName));
			$("#tBirth").text(json.tBirth);
			$("#tGender").text(json.tGender);
			$("#tTel").text(json.tTel);
			$("#tInputdate").text(json.tInputdate);
			$("#tEmail").text(json.tEmail);
			$("#tIntro").text(decodeURIComponent(json.tIntroduce));
			// 공백 변환처리
			$("#tIntro").text(decodeURIComponent(json.tIntroduce.replace(space," ")));

			var output2;
	 		$("#career *").remove();
			if( json.careerList.length != 0){
 				for(var i=0; i<json.careerList.length; i++){
					output2 += "<tr><td width='50px' class='col-10'>"+ decodeURIComponent(json.careerList[i].career.replace(space," "))+"</td>";
					$("#career").append(output2);
					output2 = "";
				} 
			}
			if( json.careerList.length == 0){
				output2 += "<tr><td width='50px' class='col-10'>경력이 없습니다.</td></tr>";
				$("#career").append(output2);
				output2 = "";
			}
		}
	});//ajax 
}

$(function(){		
 	$("#permission").click(function(){
		if(confirm("정말 강사 권한을 승인하시겠습니까?")){
			//$("#reportReason").val("");
			//$("[name='addFrm']").submit();
			
				//function addBlack(userId) {
				 	 var queryString = "id="+$("#tId").text();
				 	$.ajax({
						url: "teacherPermission.do",
						data: queryString,
						type: "get",
						//dataType: "text",
						error: function(xhr) {
							alert("실패");
							console.log(xhr.status + "/" + xhr.statusText);
						},
						success:function( json ){
							alert("승인되었습니다.");
						 	window.location.href="<c:url value='/admin/teacherAuthority.do' />";
						}
					});//ajax
			//} // addBlack
		};
	});
	
});		
$(function(){		
 	$("#refuse").click(function(){
		if(confirm("정말 강사 권한을 거절하시겠습니까?")){
			//$("#reportReason").val("");
			//$("[name='addFrm']").submit();
			
				//function addBlack(userId) {
				 	 var queryString = "id="+$("#tId").text();
				 	$.ajax({
						url: "teacherRefuse.do",
						data: queryString,
						type: "get",
						//dataType: "json",
						error: function(xhr) {
							alert("실패");
							console.log(xhr.status + "/" + xhr.statusText);
						},
						success:function( json ){
							alert("거절되었습니다.");
						 	//$("#addBlackCancle").trigger("click"); // 강제로 실행
						 	//location.href("/admin/member.do");
						 	window.location.href="<c:url value='/admin/teacherAuthority.do' />";
						}
					});//ajax
			//} // addBlack
		};
	});
	
});		

</script>
<!--  -->
<div class="card">
	<div class="card-header">
		<h5 style="margin-bottom: 0px;"><strong>강의 권한 승인</strong></h5>
	</div>
	<div class="card-body">
		<form name="teacherPermitSearch" class="form-inline" action="teacherAuthority.do" method="get">
        <select name="searchOption" id="searchOption" class="form-control input-sm">
            <option value="t.teacher_name">강사명</option>
            <option value="c.client_id">아이디</option>
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
		<table class="table table-responsive-sm table-striped" style="text-align:center">
			<thead>
				<tr>
					<th width="100px">번호</th>
					<th width="200px">아이디</th>
					<th width="200px">강사명</th>
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
						<!-- <form method="get" action="./member.jsp" class="form-inline"> -->
							<a data-toggle="modal" href="#modalTAuthority" onclick="teacherPermitInfo('${ teacherPermit.client_id }','${teacherPermit.teacher_name }')"><span
								class="badge badge-primary">상세정보</span></a>
						<!-- </form> -->
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
