<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  -->
<div class="card">
	<div class="card-header">
		<i class="fa fa-align-justify"></i> 회원 조회
	</div>
	<div class="card-body">
		<form name="membersearchf" class="form-inline" action="<?php echo $link_url;?>">
        <input type="hidden" name="orderby" value="<?php echo $xorderby;?>" />
        <select name="where" class="form-control input-sm">
            <option value="userNM">이름</option>
            <option value="userID">아이디</option>
        </select>
        <div class="input-group input-group-sm">
            <input type="text" name="keyword" value="" class="form-control input-search" placeholder="검색어">
            <span class="input-group-btn">
                <button type="submit" class="btn btn-info" title="검색"><i class="glyphicon glyphicon-search"></i></button>
            </span>
        </div>
  	  </form>
		<br/>
		<br />
		<table class="table table-responsive-sm">
			<thead>
				<tr>
					<th width="200px">아이디</th>
					<th width="200px">이름</th>
					<th width="200px">생년월일</th>
					<th width="100px">성별</th>
					<th width="300px">이메일</th>
					<th width="200px">비고</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Samppa Nori</td>
					<td>2012/01/01</td>
					<td>Member</td>
					<td>Member</td>
					<td><span class="badge badge-success">Active</span></td>
					<td>
						<form method="get" action="./member.jsp" class="form-inline">
							<a data-toggle="modal" href="#modalUserInfo"><span	class="badge badge-primary">상세정보</span></a> 
							<a data-toggle="modal" href="#modalAddBlackList"><span class="badge badge-primary">블랙리스트 등록</span></a> 
							<a data-toggle="modal" href="#modalTeacherInfo"><span class="badge badge-primary">강사정보</span></a>
						</form>
					</td>
				</tr>
				<tr>
					<td>Estavan Lykos</td>
					<td>Simons</td>
					<td>19900230</td>
					<td>Staff</td>
					<td><span class="badge badge-danger">Banned</span></td>
					<td><span class="badge badge-danger">Banned</span></td>
				</tr>
				<tr>
					<td>Chetan Mohamed</td>
					<td>2012/02/01</td>
					<td>Admin</td>
					<td>Staff</td>
					<td><span class="badge badge-secondary">Inactive</span></td>
					<td><span class="badge badge-danger">Banned</span></td>
				</tr>
				<tr>
					<td>Derick Maximinus</td>
					<td>2012/03/01</td>
					<td>Member</td>
					<td>Staff</td>
					<td><span class="badge badge-warning">Pending</span></td>
					<td><span class="badge badge-danger">Banned</span></td>
				</tr>
				<tr>
					<td>Friderik Dávid</td>
					<td>2012/01/21</td>
					<td>Staff</td>
					<td>Staff</td>
					<td><span class="badge badge-success">Active</span></td>
					<td><span class="badge badge-danger">Banned</span></td>
				</tr>
			</tbody>
		</table>
		<div style="text-align: center">
			<div style="display: inline-block;">
				<ul class="pagination ">
					<li class="page-item"><a class="page-link" href="#">Prev</a></li>
					<li class="page-item active"><a class="page-link" href="#">1</a>
					</li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#">4</a></li>
					<li class="page-item"><a class="page-link" href="#">Next</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<c:import url="modalUserInfo.jsp"/>
<c:import url="modalAddBlackList.jsp"/>
<c:import url="modalTeacherInfo.jsp"/>
<!--  -->

