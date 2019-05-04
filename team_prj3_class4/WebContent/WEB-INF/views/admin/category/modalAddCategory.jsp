<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<div class="modal fade" id="modalAddCategory" tabindex="-1" role="dialog"
	aria-labelledby="modal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="modal">카테고리 추가</h5>
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
						사진
						<button type="button" id="btn-upload2" name="temp" value="temp" style="margin-top:10px;">사진 변경</button>
						<br/>
						<input type="file" id="file2" name="file" class="file"/>
						<img src="http://localhost:8080/team_prj3_class4/resources/admin/default.jpg" class="upCategoryImg" id="foo2">
	                  	<!-- <img src="category.png" align="left" style="padding-bottom:30px; max-width: 70%; height: auto; margin-right:10px;" id="foo2"> -->
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
						<select id="small2" name="small" size='5' style="width:200px;" class="col-3">
						    <option value="축구">축구</option>
						    <option value="야구">야구</option>
						    <option value="농구">농구</option>
						    <option value="배구">배구</option>
						    <option value="미식축구">미식축구</option>
						</select>
						<div>
						<br/><br/>
						<input type="text" id="textCate2" style="width:110px; margin-left:10px; margin-bottom:5px;" maxlength="7" value="abc"/><br/>
						<input type="button" id="addCate2" value="추가" style="margin-left:10px;"/>
						<input type="button" id="delCate2" value="삭제"/>
						</div>
						</div>
					</div>
					</div>
					<div style="text-align: center">
						<div style="display: inline-block;">
							<div class="form-row">
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary" data-dismiss="modal">확인</button>
									<input type="submit" value="sdfsdfsdfsdfsdfsd"/>
								</div>
							</div>
						</div>
					</div>
	         </form>
			</div>
		</div>
	</div>
</div>