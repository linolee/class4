<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  -->
<script type="text/javascript">

function teacherInfo(teacherName) {
 	var queryString="teacherName="+teacherName;
 	$.ajax({
		url: "teacherDetail.do",
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

			var output;
	 		$("#lessons *").remove();
			if( json.lessonList.length != 0){
 				for(var i=0; i<json.lessonList.length; i++){
					output += "<tr><td width='50px' class='col-10'>"+ decodeURIComponent(json.lessonList[i].lessonName)+"</td>";
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


</script>
<div class="card">
	<div class="card-header">
		<i class="fa fa-align-justify"></i> 강사 조회
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
					<th width="200px">강사명</th>
					<th width="200px">아이디</th>
					<th width="200px">이름</th>
					<th width="100px">성별</th>
					<th width="200px">생년월일</th>
					<th width="300px">이메일</th>
					<th width="200px">비고</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty teacherList }">
				<tr>
					<td colspan="8" align="center">
						<strong>강사가 없습니다</strong>
					</td>
				</tr>
				</c:if>
				
				<c:forEach var="teacher" items="${teacherList }">
				<c:set var="i" value="${i+1}"/>
				<tr>
					<td><c:out value="${ (totalCount-(currentPage-1)*pageScale-i)+1 }"/></td>
					<td><c:out value="${teacher.teacherName }"/></td>
					<td><c:out value="${teacher.clientId }"/></td>
					<td><c:out value="${teacher.name }"/></td>
					<td><c:out value="${teacher.gender }"/></td>
					<td><c:out value="${teacher.birth }"/></td>
					<td><c:out value="${teacher.email }"/></td>
					<td>
						<!-- <form method="get" action="./member.jsp" class="form-inline"> -->
							<a data-toggle="modal" href="#modalTeacher" onclick="teacherInfo('${ teacher.teacherName }')"><span class="badge badge-primary">상세정보</span></a>
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


<!--  -->

<c:import url="teacher/modalTeacher.jsp"/>
