<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="modalTAuthority" tabindex="-1" role="dialog"
	aria-labelledby="modal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="modal">강사 권한 부여</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form action="./reportAction.jsp" method="post">

					<!-- temp table -->

					<table class="table table-responsive-sm" style="text-align: center">
						<tbody>
							<tr>
								<td width="50px" style="background: #C8CED3">아이디</td>
								<td width="50px">itswings</td>
								<td width="50px" style="background: #C8CED3">카테고리</td>
								<td width="50px">돌겜</td>
							</tr>
							<tr>
								<td width="50px" style="background: #C8CED3">이름</td>
								<td width="50px">문지훈</td>
								<td width="50px" style="background: #C8CED3">강사명</td>
								<td width="50px">돈까스</td>
							</tr>
							<tr>
								<td style="background: #C8CED3">생년월일</td>
								<td>2012/01/01</td>
								<td style="background: #C8CED3">성별</td>
								<td>남</td>
							</tr>
							<tr>
								<td style="background: #C8CED3">연락처</td>
								<td>119</td>
								<td style="background: #C8CED3">가입일자</td>
								<td>2018-18-18</td>
							</tr>
							<tr style="border-bottom: 1px solid #C8CED3;">
								<td style="background: #C8CED3">이메일</td>
								<td colspan="3">itswings@gmail.com</td>
							</tr>
						</tbody>
					</table>

					<!-- temp table -->

					<div class="form-group">
						<label>경력사항</label>

						<table class="table table-responsive-sm"
							style="text-align: center">
							<tbody>
								<tr>
									<td width="50px" class="col-10">경력경력경력경력경력경력경력</td>
								</tr>
								<tr style="border-bottom: 1px solid #C8CED3;">
									<td width="50px" class="col-10">경력2경력2경력2경력2경력2경력2경력2</td>
								</tr>
							</tbody>
						</table>
					</div>
					
					<div class="form-group">
						<label>자기소개</label>
						<textarea name="reportContent" class="form-control" maxlength="2048"
								style="height:180px; resize: none;" readonly="readonly"></textarea>
					</div>
					
					<div style="text-align: center">
						<div style="display: inline-block;">
							<div class="form-row">
								<div class="modal-footer">
									<button type="button" class="btn btn-primary"
										data-dismiss="modal">승인</button>
									<button type="button" class="btn btn-danger"
										data-dismiss="modal">거절</button>
								</div>
							</div>
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>
</div>