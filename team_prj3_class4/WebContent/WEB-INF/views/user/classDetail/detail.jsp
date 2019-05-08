<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Class4-detail</title>
<link href="<c:url value="/resources/css/main_v190130.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/header.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/footer.css" />" rel="stylesheet">
<!-- google font -->
<link href="https://fonts.googleapis.com/css?family=PT+Sans" rel="stylesheet">
<style type="text/css">
#wrapper {
	font-family: 'PT Sans', sans-serif;
}
#wrap{margin:0px auto; width:1100px; min-height:2500px;}
#header{width:1100px; height:140px;position: relative; }
#container{clear:both; width:1100px; min-height:1500px; }
#footer{clear:both;position:static;width:1100px; height: 140px; clear:both }
#footerTitle{float: right; font-size:15px; padding-top:20px; padding-right:20px; }

 /* 내부 */
table{align : center; text-align: center;}
td{font-size: 17px;}  
.contentTitle{font-size: 24px;font-weight: bold;}
.clear_fix{border-bottom: 1px solid #cdcdcd;height: 30px;}

dt{float:left; font-weight: bold; font-size:15px; height: 30px;font-color: #adadad;}
dd{font-size: 15px; font-color: #adadad; float: right;} 
#qnaBtn{width: 50%; height:40px; background-color:#4944A0; float: right; color: #ffffff; font-weight: bold;}
#joinBtn{width: 50%; height:40px; background-color:#4944A0; float: left; color: #ffffff; font-weight: bold;}
#likeBtn{width: 50%; height:40px; background-color:#4944A0; float: right; color: #ffffff; font-weight: bold;}
#reportBtn{width: 50%; height:40px; background-color:#4944A0; float: left; color: #ffffff; font-weight: bold;}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- include summernote css/js -->
<link href="http://localhost:8080/team_prj3_class4/resources/summernote/summernote-lite.css" rel="stylesheet">
<script src="http://localhost:8080/team_prj3_class4/resources/summernote/summernote-lite.js"></script>
<script src="http://localhost:8080/team_prj3_class4/resources/summernote/lang/summernote-ko-KR.js"></script>
<script type="text/javascript">
 $(function(){
/*   	// 주메뉴 스크롤링
	 $(window).on('scroll', function(){
	 scrollTop = $(window).scrollTop();
	 if(scrollTop >= 2000){
		 $("#other").addClass('scroll');
		 $("#other").stop(true).css({'position' : 'fixed'});
	 }else{
		 $("#other").removeClass('scroll');
		 $("#other").stop(true).css({'position' : 'relative'});
	 }//end else
	 });  */
 });//ready
</script>
<script type="text/javascript">
$(function () {
   $('.summernote_contents').summernote({ airMode: true });
   $('.summernote_contents').summernote('disable');
});
</script>
<!-- summernote 관련 library 끝 -->   
</head>
<body>
<div id="wrap">
	<div id="header">
		<c:import url="../header/header.jsp"></c:import>
	</div>
	<div id="container">
	<input type="hidden" name="lcode" value="${param.lcode}"/>
	<div id="detailContent" style="clear:both; position:relative; width: 700px; float: left; margin: 10px;">
		<div id="detail">
			<div id="classTitleImg" style="height: 400px; border: 1px solid #333; top:20px; ">
				<!-- 대표이미지 -->
				<img style="width: 100%; height: 400px;" src="http://localhost:8080/team_prj3_class4/resources/img/${summary.banner_img}">
			</div>
            <div id="summary" style="margin: 5px;">
            <%-- <c:forEach var="summary" items="${ requestScope.summary }">
      		<li><a href="#void"><c:out value="${summary.}"/></a></li>
      		<c:set var="i" value="${ i + 1 }"/>
      		</c:forEach> --%>
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
                          <!-- *강사 경력<br/>
                           oo대학교 oo과 졸업<br/>
                           oo자격증 1급<br/> 
                           <br/>
                          	제게 힐링이 되어준 하바리움, 함께 나누고 싶어요.<br/>
                          	저와 함께 하실래요? -->
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
                          	<%-- <c:out value="${dcontents.dcontents}"/> --%>
                          	<%-- <c:if test="${empty contents.contents}">
                          		등록된 클래스 소개가 없습니다.
                          	</c:if> --%>
                              <!-- <p style="text-align: center;"><br></p>
                              <p style="text-align: center;"><span style="background-color: transparent;">
                              	변하지 않는 아름다움을 더욱 오랫동안 간직할&nbsp;</span></p>
                              <p style="text-align: center;">하바리움 클래스로 당신을 초대합니다.</p>
                              <p><br></p>
                              <p>About 하바리움?</p>
                              <p>식물표본이란 뜻을 가진 &lsquo;하바리움(Herbarium)&rsquo;&nbsp;은</p>
                              <p><br>꽃(Flower)을 사용해서 만든다고 하여 하바플라리움(Herbaflorium) 이라고도 불리고 있어요.</p>
                              <p>가장 아름다운 상태로 특수 처리한 프리저브드 플라워를 이용하여 생화 느낌 그대로 감상할 수 있는 장점이 있답니다.<br>
                              	드라이 플라워를 사용한 하바리움은 빈티지한 고혹미를 오랫동안 간직할 수 있어서 더욱 매력적이에요 ;)</p> -->
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
                          
                              <!-- <p><span style="font-size: 12pt;"><br></span></p>
                              <p><span style="font-size: 12pt;"><strong>1. 강의 소개</strong>
                              <br>- 강사 소개<br>- 하바리움은?&nbsp;</span></p>
                              <p><span style="font-size: 12pt;"><br></span></p>
                              <p><span style="font-size: 12pt;"><strong>2. 하바리움 만들기</strong>
                              <br>- 꽃 다듬기<br>- 병에 배치하기<br>- 용액 주입</span></p>
                              <p><span style="font-size: 12pt;"><br></span></p>
                              <p><span style="font-size: 12pt;"><strong>3. 마무리</strong>
                              <br>- 완성작 촬영<br>- 보관 팁, 주의사항 안내<br>- 정리 및 인사</span></p>
                              <p><br></p><p><span style="font-size: 12pt;"><br></span></p>
                              <p><span style="font-size: 12pt;"><strong>* 하바리움은 100ml 용량의 PET용기로 진행됩니다.</strong></span></p>
                              <p><span style="font-size: 12pt;"><strong>* 소요 시간은 보통 1시간 내외로&nbsp;</strong><strong>소요됩니다.</strong></span></p><p><br></p><p><br></p> -->                            
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

                       <!-- <div class="group" style="border-top: 1px solid #cfcfcf;">
                          <div class="detail_info_title"><span class="contentTitle">기타 사항-환불규정</span></div>
                          <span style="line-height: 1.5;font-size: 12pt; font-family: NanumGothic, sans-serif;">
						<p>클래스볼의 결제 취소 및 환불 규정은 관련 법령인 &lt;학원의 설립ㆍ운영 및 과외교습에 관한 법률 시행령 [별표4] [시행 2017.3.21.]&gt;의 &lt;교습비 등 반환기준(제18조 제3항 관련)&gt;을 준수합니다.</p>
						<p><br></p>
						<p><strong>1. 클래스 수업 기간이 1개월 이내인 경우 환불 기준</strong>&nbsp;</p>
						<p>① 클래스 시작 전 - 이미 납부한 교습비 등의 전액&nbsp;</p>
						<p>② 총 클래스 수업시간의 1/3 경과 전 - 이미 납부한 교습비 등의 2/3에 해당하는 금액&nbsp;</p>
						<p>③ 총 클래스 수업시간의 1/2 경과 전 - 이미 납부한 교습비 등의 1/2에 해당하는 금액&nbsp;</p>
						<p>④ 총 클래스 수업시간의 1/2 경과 후 - 반환하지 않음&nbsp;</p>
						<p>
							<br>
						</p>
						<p><strong>2. 클래스 수업 기간이 1개월을 초과하는 경우</strong>&nbsp;</p>
						<p>① 클래스 수업 시작 전 - 이미 납부한 교습비 등의 전액&nbsp;</p>
						<p>② 클래스 수업 시작 후 - 환불사유가 발생한 해당 월의 환불 대상 교습비 등 (클래스 수업 기간이</p>
						<p>1개월 이내인 경우의 기준에 따라 산출한 금액을 말한다)과 나머지 월의 교습비 등의 전액을 합산한 금액&nbsp;</p>
						<p>
							<br>
						</p>
						<p>단 클래스의 특성상 사전 준비(수업재료 준비, 장소 및 식사 사전예약 등)과정에서 불가피하게 손해비용 및 위약금 발생이 예상되는 경우, 
						마스터는 법령에서 제시한 내용 외에 별도의 환불규정을 수강생에게 고지할 수 있고, 수강생은 마스터가 고지한 환불수수료를 제외한 금액을 환불받을 수 있습니다.</p>
						<br></span>
					  </div> -->

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
								<div class="detail_info_title" style="border-bottom: 2px solid #adadad;">
									<span class="contentTitle" style="float: letf">리뷰</span>
									<!-- <input style="float: right;" type="button" name="reviewBtn" id="reviewBtn" class="btn" value="리뷰 작성"/> -->
								</div>
								<table width="640" style="margin-left: 10px;">
									<c:forEach var="rvlist" items="${ requestScope.rvlist }">
										<tr>
											<td rowspan="2">
												<c:out value="${rvlist.client_id}"/><br/>
												<input type="hidden" value="${rvlist.score}" id="rvScore"/>
												<c:choose>
												<c:when test="${rvlist.score eq 0}">
												☆☆☆☆☆
												</c:when>
												<c:when test="${rvlist.score eq 1}">
												★☆☆☆☆
												</c:when>
												<c:when test="${rvlist.score eq 2}">
												★★☆☆☆
												</c:when>
												<c:when test="${rvlist.score eq 3}">
												★★★☆☆
												</c:when>
												<c:when test="${rvlist.score eq 4}">
												★★★★☆
												</c:when>
												<c:when test="${rvlist.score eq 5}">
												★★★★★
												</c:when>
												</c:choose>
												<%-- <c:out value="${rvlist.score}"/> --%>
											</td>
											<td><c:out value="${rvlist.subject}"/></td>
										</tr>
										<tr>
											<td>
												<c:out value="${rvlist.contents}"/><br/>
												<c:out value="${rvlist.r_date}"/>
											</td>
										</tr>
									</c:forEach> 
									<c:if test="${empty rvlist}">
										<tr>
											<td>등록된 후기정보가 없습니다.</td>
										</tr>
									</c:if>
										<!-- style="border-bottom: 1px solid #cdcdcd;" -->
									</tr>
								</table>
							</div>					
							<div class="group" style="border-top: 1px solid #cfcfcf; margin-bottom: 15px;">
								<div class="detail_info_title" style="border-bottom: 2px solid #adadad;">
									<span class="contentTitle"  style="float: letf">Q&A</span>
									<!-- <input style="float: right;" type="button" name="qnaWBtn" id="qnaWBtn" class="btn" value="Q&A 작성"/> -->
								</div>
								<table width="640" style="margin-left: 10px;">
									<c:forEach var="qnalist" items="${ requestScope.qnalist }">
										<tr>
											<td><c:out value="${qnalist.id}"/></td>
											<td><c:out value="${qnalist.subject}"/></td>
											<td><c:out value="${qnalist.inputdate}"/>
											</td>
										</tr>
									</c:forEach> 
									<c:if test="${empty qnalist}">
										<tr>
											<td>등록된 Q&A정보가 없습니다.</td>
										</tr>
									</c:if>
								</table>

 							</div>					
							<div class="group" style="border-top: 1px solid #cfcfcf; margin-bottom: 15px; height: 250px;">
								<div class="detail_info_title" style="border-bottom: 2px solid #adadad; margin-bottom: 15px;">
									<span class="contentTitle">강사가 강의중인 다른 클래스</span>
								</div>
								<div style="float: right; border-left: 1px solid #cfcfcf;width: 150px; height: 200px; text-align: center;">
									<div style="float:none;margin-top: 15px;margin-bottom:10px ; margin-left:35px;
										border:1px solid #cfcfcf; width: 50%; height: 40%;">
										<img src="http://localhost:8080/team_prj3_class4/resources/img/${summary.img}">
									</div>
									<span style=""><c:out value="${summary.teacher_name}"/></span><br/>
									<span style="">
									<!-- 강사 간단소개 -->
									<c:out value="${addr.introduce}"/>
									</span>
								</div>
								<c:forEach var="tclist" items="${requestScope.tclist}">
								<div style="border: 1px solid #333; width: 150px; height: 200px; float: left;">
									<div style="width: 150px; height: 100px;">
										<img style="width: 150px; height: 100px;" src="http://localhost:8080/team_prj3_class4/resources/img/${tclist.main_img}"/>
										<%-- <c:out value="${tclist.main_img}"/><br/> --%>
									</div>
									<div style="width: 150px; height: 100px;">
										<c:out value="${tclist.lname}"/><br/>
										<c:out value="${summary.teacher_name}"/>
									</div>
									<input type="hidden" value="${tclist.lcode}"/>
								</div>
								</c:forEach>
								<c:if test="${empty tclist}">
								<span style="text-align: center; margin: 15px; font-size: 15px;">등록된 다른 클래스가 없습니다.</span>
								</c:if>

 							</div>					
                       </div>
                      </div>
                </article>
            </div>
           </div>
           </div>
           </div>     

 		<div id="moveBar" style="position:relative; float:right; width:350px; height: 425px; top:20px; margin: 5px; max-height: 1500px; ">
			<aside class="other" style="clear:both; position:fixed; border: 1px solid #afafaf; width: 320px; height: 425px; float: right; padding: 10px;">
				<div id="barTitle">
				<span id="Title" style="font-size: 20px; font-weight: bold"><c:out value="${summary.lname}"/></span>
				</div>
	              <div class="sticky">
				  <div class="box m_info">
	                  <div class="clear_fix" style="height: 50px;">
	                      <div class="pic" style="float: left;">
	                        <img style="border: 1px solid #333; width: 40px; height: 40px; margin-right: 10px;" src="http://localhost:8080/team_prj3_class4/resources/img/${summary.img}">
						  </div>
	                      <div class="info" style=:float:right;>
	                          <p class="name"><br/><c:out value="${summary.teacher_name}"/></p>
	                      </div>
	                  </div>
                 	<div class="infos group">
	                      <div class="default_lecture" style="display:none;">
	                          <dl class="clear_fix">
	                              <dt>기간</dt>
	                              <dd style="position:absolute; right:9px;">2019.04.15 ~ 2019.04.21 (총 3회)</dd>
	                          </dl>
	                          <dl class="clear_fix">
	                              <dt>요일</dt>
	                              <dd style="position:absolute; right:9px;">월</dd>
	                          </dl>
	                          <dl class="clear_fix">
	                              <dt>시간</dt>
	                              <dd>09:00 ~ 10:00</dd>
	                          </dl>
	                      </div>
	                      <div class="select_day group" style="margin-bottom: 10px;">
	                          <div class="c_selectbox">
	                          <select onChange="setPeople(this.value)" style="width: 100%; height: 30px; margin-top: 10px;">
	                          <!-- <option value="0">
	                          2019.05 첫째주-월,수,금 19:00 ~ 20:00 &nbsp; &nbsp; &nbsp; &nbsp; 0 / 4
	                          </option> -->
	                          <option value="0">
	                          <c:out value="${classTime.start_date}"/>&nbsp;&nbsp;
	                           <c:forEach var="day" items="${requestScope.day}">
                                  <c:out value="${day}"/>,
                                </c:forEach>
                                 <c:out value="${classTime.start_time}"/>시 ~ <c:out value="${classTime.end_time}"/>시
                                  &nbsp; &nbsp; &nbsp; &nbsp; 
                                  <c:out value="${joinCount.now_member}"/>
                                  <c:if test="${empty joinCount.now_member}">0</c:if>
                                   / <c:out value="${summary.max_member}"/>
	                          </option>
                                  <!-- 	2019.05 첫째주-월,수,금 19:00 ~ 20:00 &nbsp; &nbsp; &nbsp; &nbsp; 0 / 4 -->
                                  <%-- <option value="0">
                                  <c:out value="${ctlist.start_date}"/>-
                                  <c:forEach var="day" items="${requestScope.day}">
                                  <c:out value="${day}"/>
                                  </c:forEach>
                                  <c:out value="${ctlist.start_time}"/> ~ <c:out value="${ctlist.end_time}"/>
                                  </option> --%>
	                              </select>
	                             <!--  <label for="">클릭해서 클래스날짜 선택하기</label> -->
	                             <!--  <select onChange="setPeople(this.value)" style="width: 100%; height: 30px; margin-top: 10px;">
                                  <option value="0">클릭해서 클래스날짜 선택하기</option>
                                  <option value="1_1000">2019.04.15(월) 19:00 ~ 20:00 &nbsp; &nbsp; &nbsp; &nbsp; 마감 </option>
                                  <option value="2_1000">2019.04.16(화) 19:00 ~ 20:00 &nbsp; &nbsp; &nbsp; &nbsp; 마감 </option>
                                  <option value="3_1">2019.04.21(일) 12:30 ~ 13:30 &nbsp; &nbsp; &nbsp; &nbsp; 0 / 4 </option>
                                  <option value="4_1">2019.04.21(일) 14:00 ~ 15:00 &nbsp; &nbsp; &nbsp; &nbsp; 0 / 4 </option>
                                  <option value="5_1">2019.04.21(일) 16:00 ~ 17:00 &nbsp; &nbsp; &nbsp; &nbsp; 0 / 4 </option>
                                  <option value="6_1">2019.04.21(일) 18:00 ~ 19:30 &nbsp; &nbsp; &nbsp; &nbsp; 0 / 4 </option>
                                  <option value="7_1">2019.04.27(토) 12:30 ~ 13:30 &nbsp; &nbsp; &nbsp; &nbsp; 0 / 4 </option>
                                  <option value="8_1">2019.04.27(토) 14:00 ~ 15:00 &nbsp; &nbsp; &nbsp; &nbsp; 0 / 4 </option>
                                  <option value="9_1">2019.04.27(토) 16:00 ~ 17:00 &nbsp; &nbsp; &nbsp; &nbsp; 0 / 4 </option>
                                  <option value="10_1">2019.04.29(월) 19:00 ~ 20:00 &nbsp; &nbsp; &nbsp; &nbsp; 0 / 4 </option>
                                  <option value="11_1">2019.04.30(화) 19:00 ~ 20:00 &nbsp; &nbsp; &nbsp; &nbsp; 0 / 4 </option>
	                              </select> -->
	                          </div>
	                      </div>
	                      <dl class="clear_fix" style="padding-top:10px;border-top:1px solid #cdcdcd;">
	                          <dt>지역정보</dt>
	                          <dd title="${addr.si}&gt;${addr.gu}"><c:out value="${addr.si}"/>&gt;<c:out value="${addr.gu}"/></dd>
	                      </dl>
	                      <dl class="clear_fix">
	                          <dt>수강인원</dt>
	                          <dd><span class="mark" id="lec_count_now">
	                          <c:out value="${joinCount.now_member}"/>
	                          <c:if test="${empty joinCount.now_member}">0
	                          </c:if>
	                          </span>
	                          	 / <span id="lec_count_max">
	                          	 <c:out value="${summary.max_member}"/></span>명</dd>
	                      </dl>
	                      <dl class="clear_fix">
	                          <dt>신청마감일</dt>
	                          <dd>
	                          	<c:out value="${addr.due_date}"/>
									<!-- 2019. 05. 29(월) -->
							  </dd>
	                      </dl>
	                      <dl class="clear_fix">
	                          <dt>찜한 회원</dt>
	                          <dd><span id="likeCnt"><c:out value="${like}"/></span>명</dd>
	                      </dl>
	                   <!--  <div class="tutor_t">
						<dl class="tutor_txt" style="height:200px;">
							<dt>강사 한마디</dt>
							<dd>						
								강남, 홍대, 마포, 잠실 등 협의 후에 장소 결정 가능합니다.
								서울지역, 인천지역, 경기지역 장소 협의 후 가능합니다 :)
								수업은 카페에서 진행하며, 음료비는 불포함입니다.
								<br>장소 : 
								서울 강남구 강남대로 476 투썸플레이스			
								<br>
								추가비용 : 카페 / 음료비 불포함						
							</dd>
						</dl>
						</div> -->
	                  </div>
	                  <div>
	                  	<input type="button" class="btn" id="likeBtn" value="찜하기" />
           				<input type="button" class="btn" id="reportBtn" value="신고하기" />
	                  	<input type="button" class="btn" id="qnaBtn" value="강사에게 문의하기"/>
	                  	<input type="button" class="btn" id="joinBtn" value="클래스 신청하기 "/>
	                  
	                  </div>
	                  
	                  <!-- <div class="btn group" id="btnQnA">
	                    <a href="#void"> 강사에게 문의하기</a>
	                  </div>
	                  <div class="btn group" id="btnOpen">
	                    <a href="javascript:commonLayerOpen('l_login');"> 클래스 신청하기</a>
	               	  </div> -->
	               	<div class="btn group" id="btnClose" style="display:none;">
	               		<a style="background:#888484;">클래스 신청 마감</a>
	               	</div>
				</div>
	              </div>
	          </aside>            
		</div>

     </div>
<!-- 	<script>
    var lec_type=2;
    var all_count_max='4';
    var all_count_min='1';
    var all_count_now='0';
    var arrText3=new Array();
	var arrText4=new Array();
    var arrCount=new Array();
      arrText3[0] = '1';
    arrText4[0] = '4';
    arrCount[0] = '0';
      arrText3[1] = '1';
    arrText4[1] = '4';
    arrCount[1] = '0';
      arrText3[2] = '1';
    arrText4[2] = '4';
    arrCount[2] = '0';
      arrText3[3] = '1';
    arrText4[3] = '4';
    arrCount[3] = '0';
      arrText3[4] = '1';
    arrText4[4] = '4';
    arrCount[4] = '0';
      arrText3[5] = '1';
    arrText4[5] = '4';
    arrCount[5] = '0';
      arrText3[6] = '1';
    arrText4[6] = '4';
    arrCount[6] = '0';
      arrText3[7] = '1';
    arrText4[7] = '4';
    arrCount[7] = '0';
      arrText3[8] = '1';
    arrText4[8] = '4';
    arrCount[8] = '0';
      arrText3[9] = '1';
    arrText4[9] = '4';
    arrCount[9] = '0';
      arrText3[10] = '1';
    arrText4[10] = '4';
    arrCount[10] = '0';
    var oneday = 0;
  var chk = '2019-04-15 > 19:0 > 20:0 > 1 > 4,2019-04-16 > 19:0 > 20:0 > 1 > 4,2019-04-21 > 12:30 > 13:30 > 1 > 4,
  2019-04-21 > 14:0 > 15:0 > 1 > 4,2019-04-21 > 18:0 > 19:30 > 1 > 4,2019-04-27 > 12:30 > 13:30 > 1 > 4,
  2019-04-27 > 14:0 > 15:0 > 1 > 4,2019-04-27 > 16:0 > 17:0 > 1 > 4,2019-04-29 > 19:0 > 20:0 > 1 > 4,
  2019-04-30 > 19:0 > 20:0 > 1 > 4,2019-04-21 > 16:0 > 17:0 > 1 > 4';
  function setPeople(num){
	var num_array = num.split("_");
	var num = num_array[0];
	var num2 = num_array[1];
    if (num==0){
        $("#lec_count_min").text(all_count_min+"명");
        $("#lec_count_now").text(all_count_now);
        $("#lec_count_max").text(all_count_max);
		if(all_count_max == all_count_now){
			$("#btnClose").show();
			$("#btnOpen").hide();
		}else{
			$("#btnClose").hide();
			$("#btnOpen").show();
		}
    } else{
		if(num2=="1000"){
			var arrs3 = arrText3[num-1];
			var arrs4 = arrText4[num-1];
			$("#lec_count_min").text(arrs3+"명");
			$("#lec_count_now").text(arrCount[num-1]);
			$("#lec_count_max").text(arrs4);
			oneday = Number(num-1)+1;
			$("#btnClose").show();
			$("#btnOpen").hide();
		}else{
			//var arrs = arrText[num-1].split(" > ");
			var arrs3 = arrText3[num-1];
			var arrs4 = arrText4[num-1];
			$("#lec_count_min").text(arrs3+"명");
			$("#lec_count_now").text(arrCount[num-1]);
			$("#lec_count_max").text(arrs4);
			oneday = Number(num-1)+1;
			console.log(arrCount[num-1]+" / "+arrs4);
			if(arrCount[num-1] == arrs4){
				$("#btnClose").show();
				$("#btnOpen").hide();
			}else{
				$("#btnClose").hide();
				$("#btnOpen").show();
			}
		}
    }
    chk = "";
  }
  function checkOneday(){
    if (lec_type==2){
        if(chk){
            alert("클래스 날짜를 선택해주세요");
            return;
        }
    }
    document.location.href = "/reservation/reservation_form.php?idx=341&oneday="+oneday;
  }
</script> -->
	<div id="footer">
		<c:import url="../footer/footer.jsp" />
	</div>
</div>
</body>
</html>
