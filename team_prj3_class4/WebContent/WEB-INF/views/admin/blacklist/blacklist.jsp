<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
$(function(){
	
/* 	$("[name='detailBlackList']").click(function(){
		var blackDetailName=$("[name='detailBlackList']").attr("id");
		alert(blackDetailName);
	}); */
	
	$("[name='detailBlackList']").click(function(){
		var blackDetailName="";
		blackDetailName=$(this).attr("id");

				$.ajax({
					//url:"../WEB-INF/views/admin/blacklist/ajaxTest.jsp",
					url:"blackDetail.do",
					type:"get",
					data: "userID="+blackDetailName,
					dataType:"json",
					error:function( xhr ){
						alert(xhr.status+" " + xhr.statusText);
					},
					success:function( json ){
						var space = /\+/g;
						$("#bId").text(json.idResult);
						$("[name='hdnBlack']").val(json.idResult);
						$("#bName").text(decodeURIComponent(json.name));
						//$("[name='hdnBlack']").val(decodeURIComponent(json.Id));
						$("#bBirth").text(json.birth);
						$("#bGender").text(json.gender);
						$("#bTel").text(json.tel);
						$("#bInputdate").text(json.inputdate);
						$("#bEmail").text(json.email);
						$("#bReason").text(decodeURIComponent(json.reason.replace(space," ")));
						$("#bBinputdate").val(json.b_date);

					}//success
				});//ajax

		/* ajax */
	}); // click
	
 	 	$("#deleteBlack").click(function(){
			if(confirm("정말 블랙리스트에서 해제하시겠습니까?")){
				$("[name='delFrm']").submit();	
			};
		}); 
	
});


</script>
<!--  -->
<div class="card">
	<div class="card-header">
		<h5 style="margin-bottom: 0px;"><strong>블랙리스트</strong></h5>
	</div>
	<div class="card-body">

					<form name="blackSearch" class="form-inline" action="blacklist.do" method="get">
				        <select name="searchOption" id="searchOption" class="form-control input-sm">
				            <option value="c.name">이름</option>
				            <option value="c.client_id">아이디</option>
				        </select>
				        <div class="input-group input-group-sm">
				            <input type="text" name="keyword" id="keyword" value="" class="form-control input-search" placeholder="검색어" style="height:35px;">
				            <span class="input-group-btn">
				                <span class="input-group-btn">
				               		 <button type="submit" id="searchBtn" class="btn btn-secondary" title="검색"><i class="glyphicon glyphicon-search"></i></button>
				           		</span>
				            </span>
				        </div>
				  </form>

					<br/>

                    <table class="table table-responsive-sm table-striped" style="text-align:center">
                      <thead>
                        <tr>
                          <th width="100px">번호</th>
                          <th width="200px">아이디</th>
                          <th width="200px">이름</th>
                          <th width="200px">생년월일</th>
                          <th width="100px">성별</th>
                          <th width="300px">이메일</th>
                          <th width="200px">비고</th>
                        </tr>
                      </thead>
                      <tbody>
                      	<c:if test="${empty blackList }">
                      	<tr>
                      		<td colspan="7" align="center">
                      			<strong>등록된 블랙리스트가 없습니다</strong>
                      		</td>
                      	</tr>
                      	</c:if>
                      	
                      	<c:forEach var="black" items="${blackList }">
                      	<c:set var="i" value="${i+1 }"/>
                      	<tr>
                      		<!-- <input type="hidden" value="" id="hdnBlackList"/> -->
                      		<td><c:out value="${ (totalCount-(currentPage-1)*pageScale-i)+1 }"/></td>
                      		<td><c:out value="${black.client_id }"/></td>
                      		<td><c:out value="${black.name }"/></td>
                      		<td><c:out value="${black.birth }"/></td>
                      		<td><c:out value="${black.gender }"/></td>
                      		<td><c:out value="${black.email }"/></td>
                      		<td>
	                           <form method="get" action="./member.jsp" class="form-inline">
	                          <a data-toggle="modal" href="#modalBlackList"  name="detailBlackList" id="${black.client_id }" ><span class="badge badge-danger">상세정보</span></a> 
	                          <%-- <a data-toggle="modal" href="#modalBlackList" id="detailBlackList" name="${black.client_id }_detail"><span class="badge badge-danger">상세정보</span></a> --%> 
                          	</form>
                          </td> 
                      	</tr>
                      	</c:forEach>
                      </tbody>
                    </table>
                    <div style="text-align: center">
                    <div style="display: inline-block;">
                    <ul class="pagination "  >
                    	<c:out value="${ indexList }" escapeXml="false"/>
                    </ul>
                    </div>
                    </div>
                  </div>
</div>
            

<!--  -->

<!-- modal -->

<div class="modal fade" id="reportModal" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal">상세정보</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="./reportAction.jsp" method="post">
						
						<div class="form-group">
							<label>제목</label>
							<input type="text" name="reportTitle" class="form-control" maxlength="30">
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea name="reportContent" class="form-control" maxlength="2048"
								style="height:180px;"></textarea>
						</div>
						<div class="form-row">
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
								<button type="submit" class="btn btn-danger">ㄱㄱ</button> 
							</div>
						</div>
					</form>
				
				</div>
			</div>
		</div>
	</div>

<!-- modal -->

<c:import url="blacklist/modalBlackList.jsp"/>