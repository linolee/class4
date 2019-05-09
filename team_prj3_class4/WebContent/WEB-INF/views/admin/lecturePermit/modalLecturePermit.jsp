<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<link href="http://localhost:8080/team_prj3_class4/resources/summernote/summernote-lite.css" rel="stylesheet">
<script src="http://localhost:8080/team_prj3_class4/resources/summernote/summernote-lite.js"></script>
<script src="http://localhost:8080/team_prj3_class4/resources/summernote/lang/summernote-ko-KR.js"></script>
<style type="text/css">
#wrapper {
	font-family: 'PT Sans', sans-serif;
}



/* --*-*-*-*-*--**--*수정해야함*-*-*-*-*--*-**-*--**--* */
/* #wrap{margin:0px auto; width:1100px; min-height:2500px;}
#header{width:1100px; height:140px;position: relative; }
#container2{clear:both; width:1100px; min-height:1500px; } */
/* --*-*-*-*-*--**--*수정해야함*-*-*-*-*--*-**-*--**--* */



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
	
	
	
<div class="modal fade" id="modalLecturePermit" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
		
		
		<!-- <div id="wrap"> -->
	<div id="header">
		<%-- <c:import url="../header/header.jsp"></c:import> --%>
	</div>
	<div id="container2">
	<input type="hidden" name="lcode" value="${param.lcode}"/>
	<div id="detailContent" style="clear:both; position:relative; width: 700px; float: left; margin: 10px;">
		<div id="detail">
			강의 개설 승인
			<div id="classTitleImg" style="height: 400px; border: 1px solid #333; top:20px; ">
				
				<!-- 대표이미지 -->
				<img style="width: 100%; height: 400px;" id="ls_bannerImg" src="http://localhost:8080/team_prj3_class4/upload/default.jpg">
			</div>
            <div id="summary" style="margin: 5px;">
             <h1 class="c_title" style="line-height: 1.2;" id="ls_lname"></h1>
             <p class="c_summary" id="ls_lintro"></p>
            	<table style="margin: 20px;">
            	<tr>
            		<td rowspan="4" style="width: 180px; height: 180px;">
            			<img style="border: 1px solid #333; width: 50px; height: 50px;" id="ls_teacherImg" src="http://localhost:8080/team_prj3_class4/upload/default.jpg">
            			<br/>
						<h3 id="ls_teacher_name"></h3>
					</td>
            		<td width="150px">위치</td>
            		<td width="150px">시간</td>
            		<td width="150px">인원수</td>
            	</tr>
            	<tr>
            		<td id="ls_address"><c:out value="${summary.address}"/><br/></td>
            		<td id="ls_class_time"><c:out value="${summary.class_time}"/><br/></td>
            		<td id="ls_max_member"><c:out value="${summary.max_member}"/>명</td>
           		</tr>
           		<tr style="align-content: center">
           			<td colspan="3">
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
                  		<div style="background-color: transparent; margin:20px; font-size: 15px;" id="ls_career">
                      	</div>
                  	</div>
                       <div class="group" style="margin-bottom: 15px;border-top: 1px solid #cfcfcf;">
                          <div class="detail_info_title"><span class="contentTitle">클래스를 소개해요</span></div>
                          <div style="margin:20px; font-size: 15px;" id="ls_contents">
                          <!-- <textarea name="contents" class="summernote_contents"  style="width: 90%; margin: 15px;"id="ls_contents">
                          </textarea> -->
                          </div>
                      </div>
                      <div class="group" style="border-top: 1px solid #cfcfcf;">
                          <div class="detail_info_title"><span class="contentTitle">수업 정보</span></div>
                          <div style="margin:20px; font-size: 15px;" id="ls_curriculum">
                           <!-- <textarea name="contents" class="summernote_contents" id="ls_curriculum" style="width: 90%; margin: 15px;">
                          </textarea> -->
                          </div>
                          <span style="line-height: 1.5;font-size: 12pt; font-family: NanumGothic, sans-serif;">
                          
                          </span>
                      </div>
                      <div class="group" style="border-top: 1px solid #cfcfcf;">
                          <div class="detail_info_title"><span class="contentTitle">포함/불포함 사항</span></div>
                          <table style="margin: 20px;">
                          	<tr>
                          		<th style="width: 150px;font-size: 17px;border-right: 1px solid #cdcdcd; ">포함 사항</th>
                          		<th style="width: 150px;font-size: 17px;">불포함 사항</th>
                          	</tr>
                          	<tr>
                          		<td style="font-size: 15px;border-right: 1px solid #cdcdcd; " id="ls_optlist">
									
								</td>
                          		<td style="font-size: 15px;" id="ls_noptlist">
                          		</td>
                          	</tr>
                          </table>
                      </div>
                      <div class="group" style="border-top: 1px solid #cfcfcf;">
                          <div class="detail_info_title"><span class="contentTitle">기타 사항</span></div>
                          <div style="margin: 20px; font-size:15px;" id="ls_others">
                          </div>
                      </div>


                       <div class="group" style="border-top: 1px solid #cfcfcf;">
                          <div class="detail_info_title"><span class="contentTitle">클래스 위치</span></div>
                          <p class="detail editor_st" style="margin: 15px;font-size: 15px;" id="ls_detailAddress">
                          </p>
							<div id="kakaoMap">
							</div>

							<div id="map" style="width:600px;height:400px; border: 1px solid #cdcdcd;margin: 15px;"></div>
							<div class="group" style="border-top: 1px solid #cfcfcf; margin-bottom: 15px;">
								
								<div style="text-align: center">
									<div style="display: inline-block;">
										<div class="form-row">
											<div class="modal-footer" style="border-top:none;">
												<button type="button" class="btn btn-primary"	data-dismiss="modal" id="lecturePermission">승인</button>
												<button type="button" class="btn btn-danger"	data-dismiss="modal" id="lectureRefuse">거절</button>
											</div>
										</div>
									</div>
								</div>
								
								
							</div>					
                       </div>
                      </div>
                </article>
            </div>
           </div>
           </div>
           </div>     


     </div>
<!-- </div> -->
		</div>
	</div>
</div>