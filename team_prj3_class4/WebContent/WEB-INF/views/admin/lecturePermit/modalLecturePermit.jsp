<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<style type="text/css">
contentTitle{font-size: 24px;font-weight: bold;}
</style>	
	
<div class="modal fade" id="modalLecturePermit" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content" style="width:725px;">
		
		<div class="modal-header">
				<h5 class="modal-title" id="modal"><strong>강의 개설 승인</strong></h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
	<div id="header">
	</div>
	<div id="container2">
	<div id="detailContent" style="clear:both; position:relative; width: 700px; float: left; margin: 10px;">
		<div id="detail">
			<div id="classTitleImg" style="height: 400px;">
				
				<!-- 대표이미지 -->
				<img style="width: 100%; height: 400px;" id="ls_bannerImg" src="http://localhost:8080/team_prj3_class4/upload/common/default.jpg">
			</div>
            <div id="summary" style="margin: 5px;">
             <h1 class="c_title" style="line-height: 1.2;padding-left: 15px;" id="ls_lname"></h1>
             <p class="c_summary" id="ls_lintro" style="padding-left: 25px;"></p>
            	<table style="border-top:1px solid #cfcfcf;margin-left: 20px;margin-top: 20px;margin-right: 20px;margin-bottom: 0px;">
            	<tr>
            		<td rowspan="4" style="width: 180px; height: 160px;">
            			<img style="width: 100px;height: 100px;padding-top: 0px;margin-top: 25px;margin-bottom: 10px;" id="ls_teacherImg" src="http://localhost:8080/team_prj3_class4/upload/common/default.jpg">
            			<br/>
						<h3 id="ls_teacher_name" style="padding-left: 15px;"></h3>
					</td>
            		<td width="150px"><strong>위치</strong></td>
            		<td width="150px"><strong>시간</strong></td>
            		<td width="150px"><strong>최대 인원수</strong></td>
            	</tr>
            	<tr>
            		<td id="ls_address"><br/></td>
            		<td id="ls_class_time"><br/></td>
            		<td id="ls_max_member"></td>
           		</tr>
            	</table>
			</div>	
        	<div class="class_detail">
            	<div class="area">
                <article class="cont" >

                   <div class="default" style="padding:20px; ">
                  	<div class="group" style="margin-bottom: 15px; border-top: 1px solid #cfcfcf;">
                  		<span class="contentTitle"><strong>강사 프로필</strong></span>
                  		<div style="background-color: transparent; margin:20px; font-size: 15px;" id="ls_career">
                      	</div>
                  	</div>
                       <div class="group" style="margin-bottom: 15px;border-top: 1px solid #cfcfcf;">
                          <div class="detail_info_title"><span class="contentTitle"><strong>클래스를 소개해요</strong></span></div>
                          <div style="margin:20px; font-size: 15px;" id="ls_contents">
                          </div>
                      </div>
                      <div class="group" style="border-top: 1px solid #cfcfcf;">
                          <div class="detail_info_title"><span class="contentTitle"><strong>수업 정보</strong></span></div>
                          <div style="margin:20px; font-size: 15px;" id="ls_curriculum">
                          </div>
                          <span style="line-height: 1.5;font-size: 12pt; font-family: NanumGothic, sans-serif;">
                          
                          </span>
                      </div>
                      <div class="group" style="border-top: 1px solid #cfcfcf;">
                          <div class="detail_info_title"><span class="contentTitle"><strong>포함/불포함 사항</strong></span></div>
                          <table style="margin: 20px;">
                          	<tr>
                          		<th style="width: 150px;font-size: 17px; border-right: 1px solid #cdcdcd; ">포함 사항</th>
                          		<th style="width: 150px;font-size: 17px; padding-left: 30px;">불포함 사항</th>
                          	</tr>
                          	<tr>
                          		<td style="font-size: 15px;border-right: 1px solid #cdcdcd; " id="ls_optlist">
									
								</td>
                          		<td style="font-size: 15px;padding-left: 30px;" id="ls_noptlist">
                          		</td>
                          	</tr>
                          </table>
                      </div>
                      <div class="group" style="border-top: 1px solid #cfcfcf;">
                          <div class="detail_info_title"><span class="contentTitle"><strong>기타 사항</strong></span></div>
                          <div style="margin: 20px; font-size:15px;" id="ls_others">
                          </div>
                      </div>


                       <div class="group" style="border-top: 1px solid #cfcfcf;">
                          <div class="detail_info_title"><span class="contentTitle"><strong>클래스 위치</strong></span></div>
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
												<button type="button" class="btn btn-primary"	id="lecturePermission">승인</button>
												<!-- <button type="button" class="btn btn-danger"	id="lectureRefuse">거절</button> -->
												
												
												<a data-toggle="modal" class="btn btn-danger" href="#modalLectureRefuse" >거절</a>
												
												
												
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
		</div>
	</div>
</div>