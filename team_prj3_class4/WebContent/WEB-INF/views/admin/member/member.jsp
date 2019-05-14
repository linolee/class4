<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">

function userInfo(userId) {
 	var queryString = "id="+userId;
 	$.ajax({
		url: "memberDetail.do",
		data: queryString,
		type: "get",
		dataType: "json",
		error: function(xhr) {
			alert("회원정보 조회 실패");
			console.log(xhr.status + "/" + xhr.statusText);
		},
		success:function( json ){
			var space = /\+/g;
			$("#mId").text(json.jid);
			$("#mName").text(decodeURIComponent(json.jname));
			$("#mBirth").text(json.jbirth);
			$("#mGender").text(json.jgender);
			$("#mTel").text(json.jtel);
			$("#mInputdate").text(json.jinputdate);
			$("#mEmail").text(json.jemail);

			var output;
	 		$("#lessons *").remove();
			if( json.lessonList.length != 0){
 				for(var i=0; i<json.lessonList.length; i++){
					output += "<tr><td width='50px' class='col-10'>"+ decodeURIComponent(json.lessonList[i].lessonName.replace(space," "))+"</td>";
					output += "<td><span class='badge badge-secondary'>"+json.lessonList[i].lessonStatus+"</span></td></tr>";
					$("#lessons").append(output);
					output = "";
				} 
			}
			if( json.lessonList.length == 0){
				output += "<tr><td width='50px' class='col-10'>수강중인 강의가 없습니다.</td></tr>";
				$("#lessons").append(output);
				output = "";
			}
		}
	});//ajax 
}
	
	function addBlack(userId) {
	 	var queryString = "id="+userId;
	 	$.ajax({
			url: "memberDetail.do",
			data: queryString,
			type: "get",
			dataType: "json",
			error: function(xhr) {
				alert("회원정보 조회 실패");
				console.log(xhr.status + "/" + xhr.statusText);
			},
			success:function( json ){
				$("#addBid").text(json.jid);
				$("#addBname").text(decodeURIComponent(json.jname));
				$("#addBbirth").text(json.jbirth);
				$("#addBgender").text(json.jgender);
				$("#addBtel").text(json.jtel);
				$("#addBinputdate").text(json.jinputdate);
				$("#addBemail").text(json.jemail);
			}
		});//ajax 
} // addBlack

$(function(){		
	 	$("#addBlack").click(function(){
	 		if($("#reportReason").val()==""){
	 			alert("사유를 입력해주세요");
	 			return;
	 		}
			if(confirm("정말 블랙리스트에 등록하시겠습니까?")){
				//$("#reportReason").val("");
				//$("[name='addFrm']").submit();
				
					//function addBlack(userId) {
					 	 var queryString = "id="+$("#addBid").text()+"&reason="+$("#reportReason").val();
					 	$.ajax({
							url: "addBlack.do",
							data: queryString,
							type: "get",
							dataType: "json",
							error: function(xhr) {
								alert("실패");
								console.log(xhr.status + "/" + xhr.statusText);
							},
							success:function( json ){
								alert("블랙리스트에 등록되었습니다.");
							 	$("#addBlackCancle").trigger("click"); // 강제로 실행
							 	window.location.href="<c:url value='/admin/member.do' />";
							}
						});//ajax
				//} // addBlack
			};
		});
	 	
});		
		
</script>

<div class="card">
	<div class="card-header">
		<h5 style="margin-bottom: 0px;"><strong>회원 조회</strong></h5>
	</div>
	<div class="card-body">
	
		<form name="memberSearch" class="form-inline" action="member.do" method="get">
        <select name="searchOption" id="searchOption" class="form-control input-sm">
            <option value="name">이름</option>
            <option value="client_id">아이디</option>
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
					<th width="150px">아이디</th>
					<th width="150px">이름</th>
					<th width="130px">생년월일</th>
					<th width="100px">성별</th>
					<th width="200px">이메일</th>
					<th width="50px">비고</th>
				</tr>
			</thead>
			<tbody>
				<!--  -->
				<c:if test="${ empty memberList }">
				<tr>
					<td colspan="7" align="center">
						<strong>등록된 회원이 없습니다</strong>
					</td>
				</tr>
				</c:if>
				
				<c:forEach var="member" items="${ requestScope.memberList }">
				<c:set var="i" value="${i+1}"/>
				<tr>		
					<td><c:out value="${ (totalCount-(currentPage-1)*pageScale-i)+1 }"/></td>
					<td><c:out value="${ member.client_id }"/></td>
					<td><c:out value="${ member.name }"/></td>
					<td><c:out value="${ member.birth }"/></td>
					<td><c:out value="${ member.gender }"/></td>
					<td><c:out value="${ member.email }"/></td>
					
					<td>
						<form method="get" action="./member.jsp" class="form-inline">
							<a data-toggle="modal" href="#modalUserInfo" onclick="userInfo('${ member.client_id }')"><span class="badge badge-primary">상세정보</span></a>
							<c:if test="${empty member.reason }">
								<a data-toggle="modal" href="#modalAddBlackList" onclick="addBlack('${ member.client_id }')"><span class="badge badge-warning">블랙리스트 등록</span></a>
							</c:if>
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

<c:import url="member/modalUserInfo.jsp"/> 
<c:import url="member/modalAddBlackList.jsp"/>