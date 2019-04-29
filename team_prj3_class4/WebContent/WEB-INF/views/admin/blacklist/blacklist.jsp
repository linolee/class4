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
		/* var hdnModal="<input type='hidden' value='"+blackDetailName+"'/>"; */
		/* $("#hdnBlackList").html(hdnModal); */
 		/* $("#hdnBlackList").val(blackDetailName);  */
		/* $("[name='detailBlackList']").val(blackDetailName); */
		/* ajax */
		alert(blackDetailName+"1");
		/* if(!""==$(this).attr("id")){ */
		/* if(!""==blackDetailName){ */

				$.ajax({
					url:"../WEB-INF/views/admin/blacklist/ajaxTest.jsp", 
					type:"post",
					data: "userID="+blackDetailName,
					dataType:"json",
					error:function( xhr ){
						alert(xhr.status+" " + xhr.statusText);
					},
					success:function( json_obj ){

						var result= json_obj.result;
						if(result){

							var output="";

							var json_arr=json_obj.resultData;

								output+="<tr><td width='50px' style='background: #C8CED3'>아이디</td><td width='50px'>"
								+itswings+"</td><td width='50px' style='background: #C8CED3'>이름</td><td width='50px'>"
								+문지훈+"</td></tr><tr><td style='background: #C8CED3'>생년월일</td><td>"
								+2012/01/01+"</td><td style='background: #C8CED3'>성별</td><td>"
								+남+"</td></tr><tr><td style='background: #C8CED3'>연락처</td><td>"
								+119+"</td><td style='background: #C8CED3'>가입일자</td><td>"
								+2018-18-18+"</td></tr><tr style='border-bottom: 1px solid #C8CED3;'><td style='background: #C8CED3'>이메일</td><td colspan='3'>"
								+itswings골뱅이gmail.com+"</td></tr>";

							$("tbody").html(output);

						}else{
							/* var img="<img src='../common/images/sist_logo.jpg'><br/>부서에 사원정보가 존재하지 않습니다.";
							$("#empView").html(img); */
						}//end else 
					}//success
				});//ajax
		alert(blackDetailName+"2");

			/* }//if */
			return;
		/* ajax */
	});


});

</script>
<!--  -->
                <div class="card">
                  <div class="card-header">
                    <i class="fa fa-align-justify"></i>블랙리스트</div>
                  <div class="card-body">

					<form name="membersearchf" class="form-inline" action="<?php echo $link_url;?>">
				        <input type="hidden" name="orderby" value="<?php echo $xorderby;?>" />
				        <select name="where" class="form-control input-sm">
				            <option value="userNM">이름</option>
				            <option value="userID">아이디</option>
				        </select>
				        <div class="input-group input-group-sm">
				            <input type="text" name="keyword" value="" class="form-control input-search" placeholder="검색어" style="height:35px;">
				            <span class="input-group-btn">
				                <span class="input-group-btn">
				               		 <button type="submit" class="btn btn-info" title="검색"><i class="glyphicon glyphicon-search"></i></button>
				           		</span>
				            </span>
				        </div>
			  	  </form>

					<br/>

                    <table class="table table-responsive-sm">
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
                      		<td colspan="6" align="center">
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
	                          <a data-toggle="modal" href="#modalBlackList"  name="detailBlackList" id="${black.client_id }" value=""><span class="badge badge-danger">상세정보</span></a> 
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