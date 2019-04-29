<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="modalUserInfo" tabindex="-1" role="dialog"
	aria-labelledby="modal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="modal">회원정보</h5>
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
								<td width="50px" style="background: #C8CED3">이름</td>
								<td width="50px">문지훈</td>
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
						<label>수강 강의 목록</label>

						<table class="table table-responsive-sm"
							style="text-align: center">
							<tbody>
								<tr>
									<td width="50px" class="col-10">강의강의강의강의강의강의강의</td>
									<td><span class="badge badge-secondary">종료</span></td>
								</tr>
								<tr style="border-bottom: 1px solid #C8CED3;">
									<td width="50px" class="col-10">강의2강의2강의2강의2강의2강의2강의2</td>
									<td><span class="badge badge-success">진행중</span></td>
								</tr>
							</tbody>
						</table>

					</div>
					<div style="text-align: center">
						<div style="display: inline-block;">
							<div class="form-row">
								<div class="modal-footer">
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