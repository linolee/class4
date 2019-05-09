<%@page import="kr.co.sist.admin.domain.MemberListDomain"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.admin.service.MemberListService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">

function lecturePermitDetail(lcode) {
 	var queryString="lcode="+lcode;
 	$.ajax({
		url: "lecturePermitDetail.do",
		/* contentType: 'application/json; charset=utf-8', */
		data: queryString,
		type: "get",
		dataType: "json",
		error: function(xhr) {
			alert("ERROR");
			console.log(xhr.status + "/" + xhr.statusText);
		},
		success:function( json ){
			var space = /\+/g;
			
			$("#ls_lname").text(decodeURIComponent(json.lname));
			$("#ls_lintro").text(decodeURIComponent(json.lintro.replace(space," ")));
			$("#ls_address").text(decodeURIComponent(json.address.replace(space," ")));
			$("#ls_class_time").text(json.class_time);
			$("#ls_max_member").text(json.max_member);
			$("#ls_teacher_name").text(decodeURIComponent(json.teacher_name.replace(space," ")));
			$("#ls_contents").text(decodeURIComponent(json.detailContents.replace(space," ")));
			$("#ls_curriculum").text(decodeURIComponent(json.detailCurriculum.replace(space," ")));
			$("#ls_others").text(decodeURIComponent(json.detailOthers.replace(space," ")));
			$("#ls_detailAddress").text(decodeURIComponent(json.detailAddress.replace(space," ")));
			$("#addressHdn").val(decodeURIComponent(json.detailAddress.replace(space," ")));
			
			var output="";
			
			$("#ls_career *").remove();
			if(json.career.length != 0){
				for(var i=0; i<json.career.length;i++){
					output+=decodeURIComponent(json.career[i])+"<br/>";
					$("#ls_career").append(output);
					output="";
				}
 			} else{
				$("#ls_career").append("경력사항이 없습니다");
			}
			
			
			$("#ls_optlist *").remove();
			if(json.optList.length != 0){
				for(var i=0; i<json.optList.length;i++){
					output+=decodeURIComponent(json.optList[i])+"<br/>";
					$("#ls_optlist").append(output);
					output="";
				}
 			} else{
				$("#ls_optlist").append("포함사항이 없습니다");
			}
			
			$("#ls_noptlist *").remove();
			if(json.noptList.length != 0){
				for(var i=0; i<json.noptList.length;i++){
					output+=decodeURIComponent(json.noptList[i])+"<br/>";
					$("#ls_noptlist").append(output);
					output="";
				}
 			} 
				/* else{
				$("#ls_optlist").append("불포함사항이 없습니다");
			} */
			
			/* $("#tId").text(json.tId);
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
			$("#tIntro").text(decodeURIComponent(json.tIntroduce.replace(space," "))); */

			/* var output;
	 		$("#lesson *").remove();
			if( json.lessonList.length != 0){
 				for(var i=0; i<json.lessonList.length; i++){
					output += "<tr><td width='50px' class='col-10'>"+ decodeURIComponent(json.lessonList[i].lessonName.replace(space," "))+"</td>";
					output += "<td><span class='badge badge-secondary'>"+json.lessonList[i].lessonStatus+"</span></td></tr>";
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
			} */
		}
	});//ajax 
	
}


</script>




<!--  -->
<div class="card">
	<div class="card-header">
		<i class="fa fa-align-justify"></i> 강의개설 승인
		
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
		<table class="table table-responsive-sm table-striped" style="text-align:center">
			<thead>
				<tr>
					<th width="100px">번호</th>
					<th width="100px">강의코드</th>
					<th width="300px">강의명</th>
					<th width="100px">강사명</th>
					<th width="100px">카테고리</th>
				</tr>
			</thead>
			<tbody>
				<!--  -->
				<c:if test="${ empty lecturePermit }">
				<tr>
					<td colspan="4" align="center">
						<strong>승인 대기중인 강의가 없습니다</strong>
					</td>
				</tr>
				</c:if>
				
				<c:forEach var="permit" items="${lecturePermit }">
				<c:set var="i" value="${i+1 }"/>
				<tr>
					<td><c:out value="${ (totalCount-(currentPage-1)*pageScale-i)+1 }"/></td>
					<td><c:out value="${permit.lcode }"/></td>
					<td>
						<a data-toggle="modal" href="#modalLecturePermit" onclick="lecturePermitDetail('${ permit.lcode }')">
                      				<c:out value="${permit.lname }"/>
                      	</a>
					</td>
					<td><c:out value="${permit.teacher_name }"/></td>
					<td><c:out value="${permit.category }"/></td>
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
<input type="hidden" id="addressHdn" value=""/>
<!--  -->
<c:import url="lecturePermit/modalLecturePermit.jsp"/> 
