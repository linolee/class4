<%@page import="kr.co.sist.admin.service.BlackListService"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 	testtest -->

<div class="modal fade" id="modalBlackList" tabindex="-1" role="dialog"
	aria-labelledby="modal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="modal">블랙리스트</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<!-- <form action="/" method="get"> -->

					<!-- temp table -->

					<table class="table table-responsive-sm" style="text-align: center">
						<tbody>
							<tr>
								<td width="50px" style="background: #C8CED3">아이디</td>
								<td width="50px" id="bId"></td>
								<td width="50px" style="background: #C8CED3">이름</td>
								<td width="50px" id="bName" name="bName"></td>
							</tr>
							<tr>
								<td style="background: #C8CED3">생년월일</td>	
								<td id="bBirth"></td>
								<td style="background: #C8CED3">성별</td>
								<td id="bGender"></td>
							</tr>
							<tr>
								<td style="background: #C8CED3">연락처</td>
								<td id="bTel"></td>
								<td style="background: #C8CED3">가입일자</td>
								<td id="bInputdate"></td>
							</tr>
							<tr style="border-bottom: 1px solid #C8CED3;">
								<td style="background: #C8CED3">이메일</td>
								<td colspan="3" id="bEmail"></td>
							</tr>
						</tbody>
					</table>

					<!-- temp table -->

					<div class="form-group">
						<label>사유</label>
						<textarea name="reportContent" class="form-control" maxlength="2048"
								style="height:180px; resize: none;" readonly="readonly" id="bReason"></textarea>
					</div>
					<div class="form-group">
						<label>적용일시</label>
						<!-- <td id="bBinputdate"></td> -->
						 <input type="text" readonly="readonly" id="bBinputdate"/>
					</div>

					<div style="text-align: center">
						<div style="display: inline-block;">
							<div class="form-row">
								<div class="modal-footer">
								<form action="blacklist.do" method="post" name="delFrm">
									<input type="hidden" name="hdnBlack"  id="hdnBlack" value=""/>
									<button type="button" class="btn btn-danger" id="deleteBlack">블랙리스트 해제</button>
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">확인</button>
								</form>
								</div>
							</div>
						</div>
					</div>

			</div>
		</div>
	</div>
</div>