<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<div class="modal fade" id="modalCategory" tabindex="-1" role="dialog"
	aria-labelledby="modal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content" style="width:650px;">
			<div class="modal-header">
				<h5 class="modal-title" id="modal"><strong>사진 변경</strong></h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">

                    <div style="display: inline-block;">
                    
				<div>
						<input type="hidden" name="page" value="category">
						
					<form action="cateUpload.do" method="post" name="uploadImgFrm" enctype="multipart/form-data">
						<input type="file" id="file" name="file"/>
						<c:forEach var="cate" items="${categoryList }">
							<input type="hidden" value=${cate.category } name="hdnCateName" id="hdnCateName"/>
						</c:forEach>
						<button type="button" id="btn-upload" name="temp" value="temp" style="margin-top:10px;">
	                  		<img src="http://211.63.89.148:8080/team_prj3_class4/resources/admin/default.jpg" class="upCategoryImg2" id="foo">
						</button>
			         </form>
			         
				</div>

                </div>
					<div style="text-align: center">
						<div style="display: inline-block;">
							<div class="form-row">
								<div class="modal-footer" style="border-top:none;">
									<button type="button" class="btn btn-secondary" id="uploadCateImg">확인</button>
								</div>
							</div>
						</div>
					</div>
			</div>
		</div>
	</div>
</div>