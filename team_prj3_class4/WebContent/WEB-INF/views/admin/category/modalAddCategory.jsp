<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<div class="modal fade" id="modalAddCategory" tabindex="-1" role="dialog"
	aria-labelledby="modal" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content" style="width:1000px;">
			<div class="card-body" style="padding-bottom: 0px;">
						<form action="newCategory.do" method="post" name="newCateFrm" enctype="multipart/form-data">
				<table class="table table-responsive-sm" style="margin-bottom: 0px;">
						
					<tbody style="border-bottom: 1px solid #c8ced3;">
							<tr>
								<td><h3>카테고리 추가</h3></td>
							</tr>
							<tr>
								<td style="width:1350px; height:100px">
									<div class="modal-header" style="border-bottom:none;padding-left: 0px; justify-content:left;">
									<h3 id="2cateName" name="2cateName" ></h3>
									<input type="hidden" id="newCateHdn" name="newCateHdn" value=""/>
									<input type="text" placeholder="카테고리명" id="newCategoryName" class="form-control input-search" style="width:200px;"/>&nbsp;
									<input type="button" value="입력" id="categoryNameEnter" class="btn btn-pill btn-block btn-light active" style="width:70px;"/>
									</div>

								<div id="divScate">
									<input type="text"  id="sCateName"class="btn btn-brand btn-twitter" style="margin-bottom: 4px; width:150px;" placeholder="소분류명"/>
									
									<input type="button" class="btn btn-brand btn-vine" value="소분류 추가" id="addSSCate" style="margin-bottom: 4px;"/><br/>
								</div>
										
								</td>
							</tr>
							<tr>
								<td>
									<input type="file" id="file2" name="file2" class="file"/>
									<button type="button" id="btn-upload2" name="temp" value="temp" style="margin-top:10px;">
				                  		<img src="http://localhost:8080/team_prj3_class4/resources/admin/default.jpg" class="upCategoryImg" id="foo2">
									</button>
								</td>
							</tr>
					</tbody>
				</table>
						</form>
				<!-- 소분류 추가시 페이지 이동을 막기 위한 히든태그 -->
				<input type="hidden" id="currentPage" value="${currentPage }"/>
				<div style="text-align: center">
					<div style="display: inline-block;">
                    	<ul class="pagination" style="margin-bottom: 0px;">
                    	
                    	<div style="text-align: center">
						<div style="display: inline-block;">
							<div class="form-row">
								<div class="modal-footer" style="border-top:none;">
									<button type="button" class="btn btn-primary" data-dismiss="modal" name="newCateSubmit">확인</button>
									<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
								</div>
							</div>
						</div>
					</div>
                    	
                   		</ul>
					</div>
				</div>
			</div>
		<!-- </div>	   -->          
	<!-- </div> -->
	         
	         
			<!-- </div> -->
		</div>
	</div>
</div>