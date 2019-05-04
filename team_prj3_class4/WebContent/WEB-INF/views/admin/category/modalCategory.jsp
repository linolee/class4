<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<div class="modal fade" id="modalCategory" tabindex="-1" role="dialog"
	aria-labelledby="modal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="modal">카테고리 수정</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">

			<form action="template.jsp?page=category" method="get" name="uploadImg" id="uploadImg"  value="temp" enctype="multipart/form-data">
                    <div style="display: inline-block;">
                    
				<div style="border: 1px solid gold; margin-bottom:30px; width:465px;" >
						카테고리명 
						<div>
						<input type="text" name="categoryTitle" class="form-control col-5" maxlength="30"  style="width:300px; margin-bottom:30px">
						</div>
				</div>
				<div style="border: 1px solid gold">
						<input type="hidden" name="page" value="category">
						<input type="file" id="file" name="file"/>
	                  	<img src="http://localhost:8080/team_prj3_class4/resources/admin/default.jpg" class="upCategoryImg" id="foo">
						<button type="button" id="btn-upload" name="temp" value="temp" style="margin-top:10px;">사진 변경</button>
				<!-- <img src="category.png" align="left" style="padding-bottom:30px; max-width: 70%; height: auto; margin-right:10px;" id="foo"> -->
				</div>

                </div>
                <div style="border: 1px solid gold">
					<div class="form-group">
						<div class="row">
						&nbsp;
						<div class="col-5 text-left">소분류</div>
						</div> 
						
						<div class="row">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</div>
					</div>
					</div>
					<div style="text-align: center">
						<div style="display: inline-block;">
							<div class="form-row">
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">확인</button>
										<input type="submit" value="ㅋㅋㅋ"/>
								</div>
							</div>
						</div>
					</div>
	         </form>
			</div>
		</div>
	</div>
</div>