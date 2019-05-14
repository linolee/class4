<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal fade" id="modalUserInfo" tabindex="-1" role="dialog"
	aria-labelledby="modal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="modal"><strong>회원정보</strong></h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form action="./reportAction.jsp" method="post">


					<table class="table table-responsive-sm table-bordered" style="text-align: center">
						<tbody>
							<tr>
								<td width="50px" style="background: #C8CED3">아이디</td>
								<td width="50px" id="mId"></td>
								<td width="50px" style="background: #C8CED3">이름</td>
								<td width="50px" id="mName"></td>
							</tr>
							<tr>
								<td style="background: #C8CED3">생년월일</td>
								<td id="mBirth"></td>
								<td style="background: #C8CED3">성별</td>
								<td id="mGender"></td>
							</tr>
							<tr>
								<td style="background: #C8CED3">연락처</td>
								<td id="mTel"></td>
								<td style="background: #C8CED3">가입일자</td>
								<td id="mInputdate"></td>
							</tr>
							<tr style="border-bottom: 1px solid #C8CED3;">
								<td style="background: #C8CED3">이메일</td>
								<td colspan="3" id="mEmail"></td>
							</tr>
						</tbody>
					</table>

					<div class="form-group">
						<label><strong>수강 강의 목록</strong></label>

						<table class="table table-responsive-sm"
							style="text-align: center">
							<tbody id="lessons">

							</tbody>
						</table>

					</div>
					<div style="text-align: center">
						<div style="display: inline-block;">
							<div class="form-row">
								<div class="modal-footer" style="border-top:none;">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">확인</button>
								</div>
							</div>
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>
</div>