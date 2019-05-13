<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=acbead349136da6f3bb665febdb9861f&libraries=services"></script>
<link href="http://localhost:8080/team_prj3_class4/resources/summernote/summernote-lite.css" rel="stylesheet">
<script src="http://localhost:8080/team_prj3_class4/resources/summernote/summernote-lite.js"></script>
<script src="http://localhost:8080/team_prj3_class4/resources/summernote/lang/summernote-ko-KR.js"></script>
<script type="text/javascript">
$(function () {
	$('.summernote_q').summernote({ airMode: true });
	$('.summernote_q').summernote('disable');
})
function lecturePermitDetail(lcode) {
	var detailAddress="";
 	var queryString="lcode="+lcode;
 	$("#lcodeHdn").val(queryString);
 	$.ajax({
		url: "lecturePermitDetail.do",
		data: queryString,
		type: "get",
		dataType: "json",
		error: function(xhr) {
			alert("ERROR");
			console.log(xhr.status + "/" + xhr.statusText);
		},
		success:function( json ){
			var space = /\+/g;
			
			$("#ls_lname").text(decodeURIComponent(json.lname.replace(space," ")));
			if(null!=json.lintro){
				$("#ls_lintro").text(decodeURIComponent(json.lintro.replace(space," ")));
			} else{
				$("#ls_intro").text("입력되지 않았습니다");
			}
			$("#ls_address").text(decodeURIComponent(json.detailAddress.replace(space," ")));
			$("#ls_class_time").text(json.class_time+"시간");
			$("#ls_max_member").text(json.max_member+"명");
			$("#ls_teacher_name").text(decodeURIComponent(json.teacher_name.replace(space," ")));
			
			if(null!=json.detailContents){
				/* $("#ls_contents").text(decodeURIComponent(json.detailContents.replace(space," "))); */ 
				$("#ls_contents .note-editable").html(decodeURIComponent(json.detailContents.replace(space," "))); 
				/* $("#ls_contents").append('<textarea class="summernote_q" >'+json.detailContents+'</textarea>'); */
			} else{
				$("#ls_contents .note-editable").text("입력되지 않았습니다");
			}
/* 			if(null!=json.detailContents){
				$("#ls_contents").val(decodeURIComponent(json.detailContents.replace(space," ")));
			} else{
				$("#ls_contents").val("입력되지 않았습니다");
			} */
			
			if(null!=json.detailCurriculum){
				/* $("#ls_curriculum").text(decodeURIComponent(json.detailCurriculum.replace(space," "))); */
				$("#ls_curriculum .note-editable").html(decodeURIComponent(json.detailCurriculum.replace(space," ")));
			} else{
				$("#ls_curriculum .note-editable").text("입력되지 않았습니다");
			}
			
			if(null!=json.detailOthers){
				$("#ls_others .note-editable").html(decodeURIComponent(json.detailOthers.replace(space," ")));
			} else{
				$("#ls_others .note-editable").text("입력되지 않았습니다");
			}
			/* $("#ls_detailAddress").text(decodeURIComponent(json.detailAddress.replace(space," "))); */
			$("#addressHdn").val(decodeURIComponent(json.detailAddress.replace(space," ")));
			detailAddress=decodeURIComponent(json.detailAddress.replace(space," "));
			
			/*  */
			var bannerImg="http://localhost:8080/team_prj3_class4/upload/common/default.jpg";
			var teacherImg="http://localhost:8080/team_prj3_class4/upload/common/default.jpg";
			if(null!=json.banner_img){
				bannerImg="http://localhost:8080/team_prj3_class4/upload/lessonBanner/"+json.banner_img;
			}
			
			if(null!=json.teacher_img){
				teacherImg="http://localhost:8080/team_prj3_class4/upload/teacher/"+json.teacher_img
			}
			$("#ls_bannerImg").attr("src", bannerImg);
			$("#ls_teacherImg").attr("src", teacherImg);
			/*  */
			
			var output="";
			
			$("#ls_career *").remove();
			if(json.career.length != 0){
				for(var i=0; i<json.career.length;i++){
					$("#ls_career").text("");
					output+=decodeURIComponent(json.career[i].replace(space," "))+"<br/>";
					$("#ls_career").append(output);
					output="";
				}
 			} else{
				$("#ls_career").text("경력사항이 없습니다");
			}
			
			
			$("#ls_optlist *").remove();
			if(json.optList.length != 0){
				for(var i=0; i<json.optList.length;i++){
					$("#ls_optlist").text("");
					output+=decodeURIComponent(json.optList[i])+"<br/>";
					$("#ls_optlist").append(output);
					output="";
				}
 			} else{
				$("#ls_optlist").text("포함사항이 없습니다");
			}
			
			$("#ls_noptlist *").remove();
			if(json.noptList.length != 0){
				for(var i=0; i<json.noptList.length;i++){
					output+=decodeURIComponent(json.noptList[i])+"<br/>";
					$("#ls_noptlist").text("");
					$("#ls_noptlist").append(output);
					output="";
				}
 			}
			
			
			mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = {
		        center: new daum.maps.LatLng(37.499490, 127.033167), // 지도의 중심좌표
		        level: 3 // 지도의 확대 레벨
		    };  
			//alert(detailAddress);
			//setMarker(detailAddress,"클래스 위치");
			setMarker(detailAddress,"테스트");
			
		}
	});//ajax 
	
	/* 지도지도지도지도지도지도지도지도지도지도지도지도지도지도지도지도지도지도지도지도 */
	
	$(function (){
		//alert(detailAddress);
		/* setMarker("서울시 송파구 오륜동","클래스 위치"); */
		//setMarker(detailAddress,"클래스 위치");
	});//ready
	
	function setMarker(addr,dong){
		// 지도를 생성합니다    
		var map = new daum.maps.Map(mapContainer, mapOption); 
		
		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new daum.maps.services.Geocoder();
		
		// 주소로 좌표를 검색합니다
		geocoder.addressSearch(addr, function(result, status) {
			
		/* alert(addr);
		alert(result);			
		alert(status);
		alert(daum.maps.services.Status.OK); */
		
	    // 정상적으로 검색이 완료됐으면 
	     if (status === daum.maps.services.Status.OK) {
	
	        var coords = new daum.maps.LatLng(result[0].y, result[0].x);
	
	        // 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new daum.maps.Marker({
	            map: map,
	            position: coords
	        });
	
	        // 인포윈도우로 장소에 대한 설명을 표시합니다
	        var infowindow = new daum.maps.InfoWindow({
	            content: '<div style="width:150px;text-align:center;padding:3px 0;">클래스 위치</div>'
	        });
	        infowindow.open(map, marker);
	
	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
	    }//end if 
	    if(status != daum.maps.services.Status.OK){
	    	alert("잘못된 위치정보로 인해 위치를 표시할 수 없습니다");
	    }
		}); //end addressSerch
	}//setMarker	

	/* 지도지도지도지도지도지도지도지도지도지도지도지도지도지도지도지도지도지도지도지도 */
	
}


$(function(){
	$("#lecturePermission").click(function(){
		if(confirm("정말 강의를 승인하시겠습니까?")){
			
		/* function lecturePermission() { */
		 	var queryString = $("#lcodeHdn").val();
		 	alert(queryString);
		 	$.ajax({
				url: "lecturePermission.do",
				data: queryString,
				type: "get",
				//dataType: "json",
				error: function(xhr) {
					alert("실패");
					console.log(xhr.status + "/" + xhr.statusText);
				},
				success:function( json ){
					alert("승인되었습니다.");
				 	window.location.href="<c:url value='/admin/lecturePermit.do'/>";
				}
			});//ajax 
	
		} // if
	});// click
});

$(function(){
	$("#lectureRefuse").click(function(){
		var refuseReason=$("[name='lectureRefuseContent']").val();
		if(""!=refuseReason){
			if(confirm("정말 거절하시겠습니까?")){
				
			 	var queryString = $("#lcodeHdn").val()+"&reason="+refuseReason;
			 	//alert(queryString);
			 	$.ajax({
					url: "lectureRefuse.do",
					data: queryString,
					type: "get",
					//dataType: "json",
					error: function(xhr) {
						alert("실패");
						console.log(xhr.status + "/" + xhr.statusText);
					},
					success:function( json ){
						alert("거절되었습니다.");
					 	window.location.href="<c:url value='/admin/lecturePermit.do'/>";
					}
				});//ajax 
		
			} // if
		} else{
			alert("사유를 입력해주세요");
		}
		
	});// click
}); 

</script>




<!--  -->
<div class="card">
	<div class="card-header">
		<h5 style="margin-bottom: 0px;"><strong>강의 개설 승인</strong></h5>
	</div>
	<div class="card-body">
		<form name="lecturePermitSearch" class="form-inline" action="lecturePermit.do" method="get">
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
					<td colspan="5" align="center">
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
<input type="hidden" id="lcodeHdn" value=""/>
<!--  -->
<c:import url="lecturePermit/modalLecturePermit.jsp"/>
<c:import url="lecturePermit/modalLectureRefuse.jsp"/>
