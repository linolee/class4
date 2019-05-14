<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<div class="modal fade" id="modalLectureRefuse" tabindex="-1" role="dialog"
	aria-labelledby="modal" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content" style="width:700px; ">
			<div class="modal-header">
				<h5 class="modal-title" id="modal"><strong>거절 사유</strong></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">

                    <div style="display: inline-block;">
                    
				<div>
			         <textarea name="lectureRefuseContent" class="form-control input-search" style="width:650px; height:250px; resize:none;" placeholder="내용을 입력해주세요"></textarea>
				</div>

                </div>
					<div style="text-align: center">
						<div style="display: inline-block;">
							<div class="form-row">
								<div class="modal-footer" style="border-top:none;">
									<button type="button" class="btn btn-primary" id="lectureRefuse">확인</button>
								</div>
							</div>
						</div>
					</div>
			</div>
		</div>
	</div>
</div>