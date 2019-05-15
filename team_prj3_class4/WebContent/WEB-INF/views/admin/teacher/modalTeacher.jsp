<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal fade" id="modalTeacher" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="modal"><strong>강사 상세 정보</strong></h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">

					<table class="table table-responsive-sm table-bordered" style="text-align: center">
						<tbody>
							<tr>
								<td rowspan="5" colspan="2" style="width:55%;">
									<img id="tImg" style="width:100%; height:50%;"  onerror="this.src='http://211.63.89.148:8080/team_prj3_class4/upload/common/default.jpg'">
									
								</td>
							</tr>
							<tr>
								<td width="60px" style="background: #C8CED3">아이디</td>
								<td width="50px" id="tId"></td>
							</tr>
							<tr>
								<td width="50px" style="background: #C8CED3">강사명</td>
								<td width="50px" id="tnName"></td>
							</tr>
							<tr>
								<td width="50px" style="background: #C8CED3">이름</td>
								<td width="50px" id="tName"></td>
							</tr>
							<tr>
								<td width="50px" style="background: #C8CED3">카테고리</td>
								<td width="50px" id="tCategory"></td>
							</tr>
							<tr>
								<td style="background: #C8CED3">생년월일</td>
								<td id="tBirth"></td>
								<td style="background: #C8CED3">성별</td>
								<td id="tGender"></td>
							</tr>
							<tr>
								<td style="background: #C8CED3">연락처</td>
								<td id="tTel"></td>
								<td style="background: #C8CED3">가입일자</td>
								<td id="tInputdate"></td>
							</tr>
							<tr style="border-bottom: 1px solid #C8CED3;">
								<td style="background: #C8CED3">이메일</td>
								<td colspan="3" id="tEmail"></td>
							</tr>
						</tbody>
					</table>

					<div class="form-group">
						<label><strong>진행중인 강의</strong></label>

						<table class="table table-responsive-sm" style="text-align: center">
							<tbody id="lesson">
							</tbody>
						</table>
					</div>
					<div class="form-group">
						<label><strong>경력사항</strong></label>

						<table class="table table-responsive-sm" style="text-align: center">
							<tbody id="career">
							</tbody>
						</table>
					</div>
					
					<div class="form-group">
						<label><strong>자기소개</strong></label>
						<textarea name="reportContent" class="form-control" maxlength="2048"
								style="height:180px; resize: none;" readonly="readonly" id="tIntro"></textarea>
					</div>
					
			</div>
		</div>
	</div>
</div>