<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
			
			var tImg="http://211.63.89.152/upload/common/default.jpg";
			if(null!=json.img){
				tImg="http://211.63.89.152/upload/teacher/"+decodeURIComponent(json.img);
			}
			$("#tImg").attr("src", tImg);

			var output;
	 		$("#lesson *").remove();
			if( json.lessonList.length != 0){
 				for(var i=0; i<json.lessonList.length; i++){
 					var jsonStatus=json.lessonList[i].lessonStatus;
 					var status="";
 					if(jsonStatus=="A"){
 						status="<span class='btn btn-brand btn-sm btn-secondary'>승인 대기 중";
 					} else if(jsonStatus=="R"){
 						status="<span class='btn btn-brand btn-sm btn-spotify'>준비 중";
 					} else if(jsonStatus=="Y"){
 						status="<span class='btn btn-brand btn-sm btn-vine'>오픈";
 					} else if(jsonStatus=="F"){
 						status="<span class='btn btn-brand btn-sm btn-dribble'>마감";
 					} else if(jsonStatus=="I"){
 						status="<span class='btn btn-brand btn-sm btn-github'>진행 중";
 					} else if(jsonStatus=="E"){
 						status="<span class='btn btn-brand btn-sm btn-twitter'>종료";
 					} else if(jsonStatus=="C"){
 						status="<span class='btn btn-brand btn-sm btn-danger'>취소/거절";
 					}
 					
 					
					output += "<tr><td style='width:350px;'>"+ decodeURIComponent(json.lessonList[i].lessonName.replace(space," "))+"</td>";
					output += "<td>"+status+"</span></td></tr>";
					$("#lesson").append(output);
					output = "";
				} 
			}
			if( json.lessonList.length == 0){
				output += "<tr><td width='50px' class='col-10'>강의가 없습니다.</td></tr>";
				$("#lesson").append(output);
				output = "";
			}
			
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

</script>
<div class="card">
	<div class="card-header">
		<h5 style="margin-bottom: 0px;"><strong>강사 조회</strong></h5>
	</div>
	<div class="card-body">
		<form name="teacherSearch" class="form-inline" action="teacher.do" method="get">
        <select name="searchOption" id="searchOption" class="form-control input-sm">
            <option value="t.teacher_name">강사명</option>
            <option value="c.name">이름</option>
            <option value="t.client_id">아이디</option>
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
							<a data-toggle="modal" href="#modalTeacher" onclick="teacherInfo('${ teacher.teacherName }')"><span class="badge badge-primary">상세정보</span></a>
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

<c:import url="teacher/modalTeacher.jsp"/>