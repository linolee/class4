<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">

$(function () {

	///////////////////////////////////////////////////////////////////* 모달  */////////////////////////////////////////////////////////////////////////
	
	// 버튼 대체
	$('#btn-upload').click(function (e) {
		e.preventDefault();
	$('#file').click();
			});

///////////////////////// 서브밋하면 파일네임에 시간정보를 추가하여 서버에 저장 /////////////////////////
///////////////////////// 본문 사진, 메인화면에 사진 변경 /////////////////////////
///////////////////////// 이미지 크기, 용량 제한 /////////////////////////

   	var ext=["jpg","png"];
   	var flag=null;
    $("#file").change(function(){
		 flag=false;
	   	 alert("클릭");
	   	 if($("#file").val()!=""){
	   		 alert("파일이 빈칸이 아닐때");
			var fileValue = $("#file").val().split("\\");
		   	var fileValue2 = $("#file").val(); // path
		   	var fileValue3 = $("#file").val().split("."); // path
		   	var inputExt=fileValue3[fileValue3.length-1].toLowerCase();
		   	var fileName = fileValue[fileValue.length-1]; // 파일명
	
		   	alert("filename : "+fileName); 
	   	 	
		   	for(var i=0; i<ext.length; i++){
		   		if(ext[i] ==inputExt){
		   			flag=true;
		   			break;
		   		} // if
		   	} // for
		   	
		   	if(!flag){
		   		alert("업로드 불가한 확장자입니다");
		   		$("#file").val("");
		   		return;
		   	} else{
		   		function readURL(input) {
			        if (input.files && input.files[0]) {
			            var reader = new FileReader();
			            reader.onload = function(e) {
			                $("#foo").attr("src", e.target.result);
			            }
			            reader.readAsDataURL(input.files[0]);
			        }
			    }
			        readURL(this);
		   	}
		   	
			/* $("#uploadImg").submit(); */
   		 } // if
 	});//change
	///////////////////////////////////////////////////////////////////* 모달  */////////////////////////////////////////////////////////////////////////
	
	$("#small").click(function(){
		$("#textCate").val($("#small").val());
		return;
	});
 	
 	$("#addCate").click(function(){
 		var varCate=$("#textCate").val();
 		alert(varCate+"추가");
 		
 	});
 	$("#delCate").click(function(){
 		var varCate=$("#textCate").val();
 		alert(varCate+"삭제");
 	});
 	
});

$(function () {

	///////////////////////////////////////////////////////////////////* 모달  */////////////////////////////////////////////////////////////////////////
	
	// 버튼 대체
	$('#btn-upload2').click(function (e) {
		e.preventDefault();
	$('#file2').click();
			});

   	var ext=["jpg","png"];
   	var flag=null;
    $("#file2").change(function(){
		 flag=false;
	   	 alert("클릭");
	   	 if($("#file2").val()!=""){
	   		 alert("파일이 빈칸이 아닐때");
			var fileValue = $("#file2").val().split("\\");
		   	var fileValue2 = $("#file2").val(); // path
		   	var fileValue3 = $("#file2").val().split("."); // path
		   	var inputExt=fileValue3[fileValue3.length-1].toLowerCase();
		   	var fileName = fileValue[fileValue.length-1]; // 파일명
	
		   	/* alert("path : "+fileValue2);
		   	alert("ext : "+inputExt);*/
		   	alert("filename : "+fileName); 
	   	 	
		   	for(var i=0; i<ext.length; i++){
		   		if(ext[i] ==inputExt){
		   			flag=true;
		   			break;
		   		} // if
		   	} // for
		   	
		   	if(!flag){
		   		alert("업로드 불가한 확장자입니다");
		   		$("#file2").val("");
		   		return;
		   	} else{
		   		function readURL(input) {
			        if (input.files && input.files[0]) {
			            var reader = new FileReader();
			            reader.onload = function(e) {
			                $("#foo2").attr("src", e.target.result);
			            }
			            reader.readAsDataURL(input.files[0]);
			        }
			    }
			        readURL(this);
		   	}
		   	
			/* $("#uploadImg").submit(); */
   		 } // if
 	});//change
	///////////////////////////////////////////////////////////////////* 모달  */////////////////////////////////////////////////////////////////////////
	
 	$("#addSCate").click(function(){
 		var input = prompt("추가할 소분류명을 입력해주세요");
 		if(input!=null){
 				var hdn=$("#hdnCate").val();
 				var page=Number($("#currentPage").val())+1-1;
			 	var queryString = "category="+hdn+"&innerCategory="+input+"&currentPage="+page;
			 	$.ajax({
					url: "addInnerCate.do",
					data: queryString,
					type: "get",
					dataType: "json",
					error: function(xhr) {
						alert("실패");
						
						console.log(xhr.status + "/" + xhr.statusText);
					},
					success:function( json ){
					 	alert("카테고리가 추가되었습니다");
						window.location.href="<c:url value='/admin/category.do"+"?currentPage="+page+"'/>";
					}
				});//ajax 
 		}
 			
 	});
 	
 	$("#uploadCateImg").click(function(){
		$("[name='uploadImgFrm']").submit();
	});
 	
 	$("#categoryNameEnter").click(function(){
 		var cateName=$("#newCategoryName").val();
 		var btn=$("#categoryNameEnter").val();
		if(cateName!=null && btn=="입력"){
			$("#2cateName").html("");
	 		$("#2cateName").html(cateName);
			$("#newCateHdn").val(cateName);
	 		$("#newCategoryName").css("display","none");
	 		$("#categoryNameEnter").val("수정");
			$("#newCategoryName").val("");
		}
		if(btn=="수정"){
			$("#newCategoryName").val("");
			$("#newCategoryName").css("display","");
			$("#categoryNameEnter").val("입력");
		}
		
		
 	});
 	
 	var sCateArray=new Array(); // 컨펌창에서 소카테고리 값 확인을 위한 배열
 	
 	$("#addSSCate").click(function(){
 		var sCateName=$("#sCateName").val();
 		if(""!=sCateName){
	 		$("#divScate").append("<input type='button' class='btn btn-brand btn-github' name='newSmallCate' value='"+sCateName+"' style='margin-bottom: 4px; width:150px;'/>&nbsp;");
	 		$("#divScate").append("<input type='hidden' name='sCateHdn' value='"+sCateName+"'/>");
	 		sCateArray.push(sCateName);
	 		$("#sCateName").val("");
 		}
 	});
 	
 	$("[name='newCateSubmit']").click(function(){
 		var cateName=$("#newCateHdn").val();
 		if(""==sCateArray){
 			sCateArray="없음";
 		}
 		var cateConfirm="\카테고리명 : "+cateName+"\n소카테고리 : "+sCateArray+"\n정말 새로운 카테고리를 만드시겠습니까?";
 	 	if(""!=cateName){
 	 		if(confirm(cateConfirm)){
			 	$("[name='newCateFrm']").submit();
 	 		} // confirm if
 	 	} 
 		else{
 			alert("카테고리명을 입력해주세요");
 			$("#newCategoryName").focus();
 		} 
 	});
 	
 	
 	
});

</script>

<!--  -->
<div class="card">
	<div class="card-header">
		<ol class="breadcrumb" style="background-color:#f0f3f5;border-bottom:none;margin-bottom:0px;padding-bottom:0px;padding-top:0px;padding-left: 0px;">
			<!-- <li class="breadcrumb-item"> -->
				<h5 style="margin-bottom: 0px;"><strong>카테고리</strong></h5>
			<!-- </li> -->
			<li class="breadcrumb-menu d-md-down-none">
				<div>
					<a data-toggle="modal" class="btn btn-pill btn-block btn-light active" href="#modalAddCategory" style="padding-top: 3px;padding-bottom: 5px;width:120px;height:25px;">카테고리 추가</a>
				</div> 
			</li>
		</ol>
	</div>
	<div class="card-body">
		<div class="card">
			<div class="card-body">
				<table class="table table-responsive-sm">
						
					<tbody style="border-bottom: 1px solid #c8ced3;">
						<c:if test="${empty categoryList }">
							<tr>
					             	
							</tr>
						</c:if>
						<c:forEach var="cate" items="${categoryList }">
							<tr>
								<td style="width:1350px; height:100px">
									<h3>${cate.category }</h3>
									<input type="hidden" id="hdnCate" value="${cate.category }"/>
									<%-- <c:forEach var="inner" items="${innerCate }"> --%>
									<%-- <c:forEach var="inner" items="${inCateList }"> --%>
									<%-- <c:if test="${not empty 운동 }"> --%>
									<c:forEach var="inner" items="${inner}">
										 <%-- <c:forEach var="btn" items="${btn }"> --%>
										
											<%-- <button class="btn btn-brand ${btn }" type="button" style="margin-bottom: 4px"> --%>
											<button class="btn btn-brand btn-twitter" type="button" style="margin-bottom: 4px">
												<span>${inner }</span>
											</button>
										<%-- </c:forEach> --%>
									</c:forEach>
									<%-- </c:if> --%>
									
									<input type="button" class="btn btn-brand btn-vine" value="소분류 추가" id="addSCate" style="margin-bottom: 4px;"/>
								</td>
							</tr>
							<tr>
								<td>
									<a data-toggle="modal" href="#modalCategory" style="width:150px;">
										<img src="http://localhost:8080/team_prj3_class4/upload/category/${cate.img }" class="categoryImg">
										<!-- <img src="http://localhost:8080/team_prj3_class4/resources/admin/default.jpg" class="categoryImg"> -->
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- 소분류 추가시 페이지 이동을 막기 위한 히든태그 -->
				<input type="hidden" id="currentPage" value="${currentPage }"/>
				<div style="text-align: center">
					<div style="display: inline-block;">
                    	<ul class="pagination">
                      		<c:out value="${ indexList }" escapeXml="false"/>
                   		</ul>
					</div>
				</div>
			</div>
		</div>	            
	</div>
</div>
                

<c:import url="category/modalCategory.jsp"/>
<c:import url="category/modalAddCategory.jsp"/>

