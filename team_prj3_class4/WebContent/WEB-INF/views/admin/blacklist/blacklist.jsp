<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
$(function(){
	
	$("[name='detailBlackList']").click(function(){
		var blackDetailName="";
		blackDetailName=$(this).attr("id");

				$.ajax({
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
						$("#bBirth").text(json.birth);
						$("#bTel").text(json.tel);
						$("#bInputdate").text(json.inputdate);
						$("#bEmail").text(json.email);
						$("#bReason").text(decodeURIComponent(json.reason.replace(space," ")));
						$("#bBinputdate").val(json.b_date);

						var jsonGender=json.gender;
						var gender="";
						if(jsonGender=="M"){
							gender="남자";
						}else{
							gender="여자";
						}
						$("#bGender").text(gender);
						
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
                      		<td><c:out value="${ (totalCount-(currentPage-1)*pageScale-i)+1 }"/></td>
                      		<td><c:out value="${black.client_id }"/></td>
                      		<td><c:out value="${black.name }"/></td>
                      		<td><c:out value="${black.birth }"/></td>
                      		<td><c:out value="${black.gender=='M'?'남자':'여자' }"/></td>
                      		<td><c:out value="${black.email }"/></td>
                      		<td>
	                          <a data-toggle="modal" href="#modalBlackList"  name="detailBlackList" id="${black.client_id }" ><span class="badge badge-danger">상세정보</span></a> 
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
            
<c:import url="blacklist/modalBlackList.jsp"/>