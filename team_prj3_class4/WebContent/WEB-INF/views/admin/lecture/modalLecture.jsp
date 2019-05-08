<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<style type="text/css">
#wrapper {
	font-family: 'PT Sans', sans-serif;
}
#wrap{margin:0px auto; width:1100px; min-height:2500px;}
#header{width:1100px; height:140px;position: relative; }
#container2{clear:both; width:1100px; min-height:1500px; }
/* #footer{clear:both;position:static;width:1100px; height: 140px; clear:both }
#footerTitle{float: right; font-size:15px; padding-top:20px; padding-right:20px; } */

 /* 내부 */
/* table{align : center; text-align: center;}
td{font-size: 17px;}  */ 
.contentTitle{font-size: 24px;font-weight: bold;}
.clear_fix{border-bottom: 1px solid #cdcdcd;height: 30px;}

dt{float:left; font-weight: bold; font-size:15px; height: 30px;font-color: #adadad;}
dd{font-size: 15px; font-color: #adadad; float: right;} 
#qnaBtn{width: 50%; height:40px; background-color:#4944A0; float: right; color: #ffffff; font-weight: bold;}
#joinBtn{width: 50%; height:40px; background-color:#4944A0; float: left; color: #ffffff; font-weight: bold;}
#likeBtn{width: 50%; height:40px; background-color:#4944A0; float: right; color: #ffffff; font-weight: bold;}
#reportBtn{width: 50%; height:40px; background-color:#4944A0; float: left; color: #ffffff; font-weight: bold;}

</style>	
	
	
	
<div class="modal fade" id="modalLecture" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
		
	<!-- ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★ -->	
		
		<div id="wrap">
	<div id="header">
		<c:import url="../header/header.jsp"></c:import>
	</div>
	<div id="container2">
	<input type="hidden" name="lcode" value="${param.lcode}"/>
	<div id="detailContent" style="clear:both; position:relative; width: 700px; float: left; margin: 10px;">
		<div id="detail">
			<div id="classTitleImg" style="height: 400px; border: 1px solid #333; top:20px; ">
				<!-- 대표이미지 -->
				<img style="width: 100%; height: 400px;" src="http://localhost:8080/team_prj3_class4/resources/img/${summary.banner_img}">
			</div>
            <div id="summary" style="margin: 5px;">
             <h1 class="c_title" style="line-height: 1.2;"><c:out value="${summary.lname}"/></h1>
             <p class="c_summary">
				<c:out value="${summary.lintro}"/>
			 </p>
            	<table style="margin: 20px;">
            	<tr>
            		<td rowspan="4" style="width: 180px; height: 180px;">
            			<img style="border: 1px solid #333; width: 50px; height: 50px;" src="http://localhost:8080/team_prj3_class4/resources/img/${summary.img}">
            			<br/>
						<c:out value="${summary.teacher_name}"/>
					</td>
            		<td width="150px">위치</td>
            		<td width="150px">시간</td>
            		<td width="150px">인원수</td>
            	</tr>
            	<tr>
            		<td><c:out value="${summary.address}"/><br/></td>
            		<td><c:out value="${summary.class_time}"/><br/></td>
            		<td><c:out value="${summary.max_member}"/>명</td>
           		</tr>
           		<tr style="align-content: center">
           			<td colspan="3">
           				<%-- <c:out value="${star.starAvg}"/> --%>
           				<c:choose>
						<c:when test="${star.starAvg le 0}">
						☆☆☆☆☆
						</c:when>
						<c:when test="${star.starAvg le 1}">
						★☆☆☆☆
						</c:when>
						<c:when test="${star.starAvg le 2}">
						★★☆☆☆
						</c:when>
						<c:when test="${star.starAvg le 3}">
						★★★☆☆
						</c:when>
						<c:when test="${star.starAvg le 4}">
						★★★★☆
						</c:when>
						<c:when test="${star.starAvg le 5}">
						★★★★★
						</c:when>
						</c:choose>
						(<c:out value="${star.starCount}"/>)
           			</td>
           			
           		</tr>
            	</table>
			</div>	
        	<div class="class_detail">
            	<div class="area">
                <article class="cont" >

                   <div class="default" style="padding:20px; ">
                  	<div class="group" style="margin-bottom: 15px; border-top: 1px solid #cfcfcf;">
                  		<span class="contentTitle">강사 프로필</span>
                  		<div style="background-color: transparent; margin:20px; font-size: 15px;">
                  		<c:forEach var="career" items="${ requestScope.career }">
                  			<c:out value="${career}"/><br/>
                  		</c:forEach>
                  		<c:if test="${empty career}">
                  			등록된 강사 경력이 없습니다.
                  		</c:if>
                      	</div>
                  	</div>
                      <div class="group" style="margin-bottom: 15px;border-top: 1px solid #cfcfcf;">
                          <div class="detail_info_title"><span class="contentTitle">클래스를 소개해요</span></div>
                          <div style="margin:20px; font-size: 15px;">
                          <textarea name="contents" class="summernote_contents" id="summernote" style="width: 90%; margin: 15px;">
                          <c:out value="${detailc.contents}"/> 
                          	<%-- <%=dd_vo.getContents()%> --%>	
                          </textarea>
                          </div>
                          <span style="line-height: 1.5;font-size: 12pt; font-family: NanumGothic, sans-serif;">
                           </span>
                      </div>
                      <div class="group" style="border-top: 1px solid #cfcfcf;">
                          <div class="detail_info_title"><span class="contentTitle">수업 정보</span></div>
                          <div style="margin:20px; font-size: 15px;">
                           <textarea name="contents" class="summernote_contents" id="summernote" style="width: 90%; margin: 15px;">
                          <c:out value="${detailc.curriculum}"/> 
                          	<%-- <%=dd_vo.getContents()%> --%>	
                          </textarea>
                          </div>
                          <span style="line-height: 1.5;font-size: 12pt; font-family: NanumGothic, sans-serif;">
                          
                          </span>
                      </div>
                      <div class="group" style="border-top: 1px solid #cfcfcf;">
                          <div class="detail_info_title"><span class="contentTitle">포함/불포함 사항</span></div>
                          <table style="margin: 20px;">
                          	<tr>
                          		<th style="width: 150px;font-size: 17px;border-right: 1px solid #cdcdcd; ">포함 사항</th>
                          		<th style="width: 150px;font-size: 17px;">불 포함 사항</th>
                          	</tr>
                          	<tr>
                          		<td style="font-size: 15px;border-right: 1px solid #cdcdcd; ">
									<c:forEach var="optlist" items="${ requestScope.optlist }">
			                  			<c:out value="${optlist}"/><br/>
			                  		</c:forEach>
			                  		<c:if test="${empty optlist}">
			                  			포함사항이 없습니다.
			                  		</c:if>
								</td>
                          		<td style="font-size: 15px;">
                          			<c:forEach var="noptlist" items="${ requestScope.noptlist }">
			                  			<c:out value="${noptlist}"/><br/>
			                  		</c:forEach>
                          		</td>
                          	</tr>
                          </table>
                      </div>
                      <div class="group" style="border-top: 1px solid #cfcfcf;">
                          <div class="detail_info_title"><span class="contentTitle">기타 사항</span></div>
                          <div style="margin: 20px; font-size:15px;">
                          	<c:out value="${detailc.others}"/>
                          	<c:if test="${empty detailc.others}">
                          		기타사항이 없습니다.
                          	</c:if>
                          </div>
                      </div>


                       <div class="group" style="border-top: 1px solid #cfcfcf;">
                          <div class="detail_info_title"><span class="contentTitle">클래스 위치</span></div>
                          <p class="detail editor_st" style="margin: 15px;font-size: 15px;">
                          		<!-- 서울 용산구 동빙고동 262-6 B1 -->
                          		 <c:out value="${detailc.address}"/>
                          		</p>
							<div id="kakaoMap">
							</div>

 							<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=acbead349136da6f3bb665febdb9861f&libraries=services"></script>
							<script type="text/javascript">
							$(function(){
								mapContainer = document.getElementById('map'), // 지도를 표시할 div 
							    mapOption = {
							        center: new daum.maps.LatLng(37.499490, 127.033167), // 지도의 중심좌표
							        level: 3 // 지도의 확대 레벨
							    };  
 							setMarker("<c:out value="${detailc.address}"/>","클래스 위치");
							});//ready
							
							function setMarker(addr,dong){	
								// 지도를 생성합니다    
								var map = new daum.maps.Map(mapContainer, mapOption); 
								
								// 주소-좌표 변환 객체를 생성합니다
								var geocoder = new daum.maps.services.Geocoder();
								
								// 주소로 좌표를 검색합니다
								geocoder.addressSearch(addr, function(result, status) {
								
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
							            content: '<div style="width:150px;text-align:center;padding:6px 0;">클래스 위치</div>'
							        });
							        infowindow.open(map, marker);
							
							        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
							        map.setCenter(coords);
							    }//end if 
								}); //end addressSerch
							}//setMarker
							</script>
							<div id="map" style="width:600px;height:400px; border: 1px solid #cdcdcd;margin: 15px;"></div>
							<div class="group" style="border-top: 1px solid #cfcfcf; margin-bottom: 15px;">
								<table width="640" style="margin-left: 10px;">
									<c:forEach var="rvlist" items="${ requestScope.rvlist }">
										<tr>
											<td><c:out value="${rvlist.subject}"/></td>
										</tr>
										<tr>
											<td>
												<c:out value="${rvlist.contents}"/><br/>
												<c:out value="${rvlist.r_date}"/>
											</td>
										</tr>
									</c:forEach> 
									</tr>
								</table>
							</div>					
                       </div>
                      </div>
                </article>
            </div>
           </div>
           </div>
           </div>     

 		<div id="moveBar" style="position:relative; float:right; width:350px; height: 425px; top:20px; margin: 5px; max-height: 1500px; ">
		</div>

     </div>
	<div id="footer">
		<c:import url="../footer/footer.jsp" />
	</div>
</div>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	<!-- ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★ -->	
			<!-- <div class="modal-header">
				<h5 class="modal-title" id="modal">강사 상세 정보</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form action="./reportAction.jsp" method="post">

					temp table

					<table class="table table-responsive-sm" style="text-align: center">
						<tbody>
							<tr>
								<td width="50px" style="background: #C8CED3">아이디</td>
								<td width="50px" id="tId"></td>
								<td width="50px" style="background: #C8CED3">카테고리</td>
								<td width="50px" id="tCategory"></td>
							</tr>
							<tr>
								<td width="50px" style="background: #C8CED3">이름</td>
								<td width="50px" id="tName"></td>
								<td width="50px" style="background: #C8CED3">강사명</td>
								<td width="50px" id="tnName"></td>
							</tr>
							<tr>
								<td style="background: #C8CED3">생년월일</td>
								<td id="tBirth"></td>
								<td style="background: #C8CED3">성별</td>
								<td id="tGender"></td>
							</tr>
							<tr>
								<td style="background: #C8CED3">연락처</td>
								<td id="tTel"></td>
								<td style="background: #C8CED3">가입일자</td>
								<td id="tInputdate"></td>
							</tr>
							<tr style="border-bottom: 1px solid #C8CED3;">
								<td style="background: #C8CED3">이메일</td>
								<td colspan="3" id="tEmail"></td>
							</tr>
						</tbody>
					</table>

					temp table

					<div class="form-group">
						<label>진행중인 강의</label>

						<table class="table table-responsive-sm"
							style="text-align: center">
							<tbody id="lesson">
								<tr>
									<td width="50px" class="col-10">강의1</td>
								</tr>
								<tr>
									<td width="50px" class="col-10">강의2</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="form-group">
						<label>경력사항</label>

						<table class="table table-responsive-sm"
							style="text-align: center">
							<tbody id="career">
								<tr>
									<td width="50px" class="col-10">경력경력경력경력경력경력경력</td>
								</tr>
								<tr style="border-bottom: 1px solid #C8CED3;">
									<td width="50px" class="col-10">경력2경력2경력2경력2경력2경력2경력2</td>
								</tr>
							</tbody>
						</table>
					</div>
					
					<div class="form-group">
						<label>자기소개</label>
						<textarea name="reportContent" class="form-control" maxlength="2048"
								style="height:180px; resize: none;" readonly="readonly" id="tIntro"></textarea>
					</div>
					
					<div style="text-align: center">
						<div style="display: inline-block;">
							<div class="form-row">
								<div class="modal-footer">
									<button type="button" class="btn btn-primary"
										data-dismiss="modal">승인</button>
									<button type="button" class="btn btn-danger"
										data-dismiss="modal">거절</button>
								</div>
							</div>
						</div>
					</div>
				</form>

			</div> -->
		</div>
	</div>
</div>