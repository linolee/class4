<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="modalAddBlackList" tabindex="-1" role="dialog"
	aria-labelledby="modal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="modal"><strong>블랙리스트 등록</strong></h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">


					<table class="table table-responsive-sm table-bordered" style="text-align: center">
						<tbody>
							<tr>
								<td width="50px" style="background: #C8CED3">아이디</td>
								<td width="50px" id="addBid"></td>
								<td width="50px" style="background: #C8CED3">이름</td>
								<td width="50px" id="addBname"></td>
							</tr>
							<tr>
								<td style="background: #C8CED3">생년월일</td>
								<td id="addBbirth"></td>
								<td style="background: #C8CED3">성별</td>
								<td id="addBgender"></td>
							</tr>
							<tr>
								<td style="background: #C8CED3">연락처</td>
								<td id="addBtel"></td>
								<td style="background: #C8CED3">가입일자</td>
								<td id="addBinputdate"></td>
							</tr>
							<tr style="border-bottom: 1px solid #C8CED3;">
								<td style="background: #C8CED3">이메일</td>
								<td colspan="3" id="addBemail"></td>
							</tr>
						</tbody>
					</table>

					<div class="form-group">
						<label>사유</label>
						<textarea id="reportReason" name="reportContent" class="form-control" maxlength="2048"
								style="height:180px; resize: none;"></textarea>
					</div>
					
					<div style="text-align: center">
						<div style="display: inline-block;">
							<div class="form-row">
								<div class="modal-footer" style="border-top:none;">
									<form action="member.do" method="post" name="addFrm">
										<button type="button" class="btn btn-danger" id="addBlack">확인</button>
									</form>
									<button type="button" class="btn btn-secondary"	data-dismiss="modal" id="addBlackCancle">취소</button>
								</div>
							</div>
						</div>
					</div>

			</div>
		</div>
	</div>
</div>