<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<div class="modal fade" id="modalCategory" tabindex="-1" role="dialog"
	aria-labelledby="modal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content" style="width:650px;">
			<div class="modal-header">
				<h5 class="modal-title" id="modal">사진 변경</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">

			<form action="template.jsp?page=category" method="get" name="uploadImg" id="uploadImg"  value="temp" enctype="multipart/form-data">
                    <div style="display: inline-block;">
                    
				<div>
						<input type="hidden" name="page" value="category">
						<input type="file" id="file" name="file"/>
						<button type="button" id="btn-upload" name="temp" value="temp" style="margin-top:10px;">
	                  		<img src="http://localhost:8080/team_prj3_class4/resources/admin/default.jpg" class="upCategoryImg" id="foo">
						</button>
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