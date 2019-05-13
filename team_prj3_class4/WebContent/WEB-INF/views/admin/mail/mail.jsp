<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">

function findEaddress() {
 	var queryString = "id="+$("#userId").val();
 	var flag=$("#idSearchFlag").val();
 	if(flag=="true"){
	 	$.ajax({
			url: "findEaddress.do",
			data: queryString,
			type: "get",
			dataType: "json",
			error: function(xhr) {
				alert("실패");
				console.log(xhr.status + "/" + xhr.statusText);
			},
			success:function( json ){
				
				var email=json.email;
				
				if(null==email){
					alert("이메일 조회 실패");
				}
				
				if(null!=email){
					$("#email").val(email);
					$("#idSearchFlag").val("false");
					$("#userId").attr("readonly", "readonly");
					$("#searchBtn").attr("class", "btn btn-danger");
					$("#glyphiconBtn").attr("class", "glyphicon glyphicon-minus-sign");
				}
				
			}
		});//ajax 
 	} // if
}

$(function(){
	
	$("#searchBtn").click(function(){
		var flag=$("#idSearchFlag").val();
		if(flag=="false"){
			$("#userId").removeAttr("readonly");
			$("#idSearchFlag").val("true");
			$("#userId").val("");
			$("#email").val("");
			$("#searchBtn").attr("class", "btn btn-secondary");
			$("#glyphiconBtn").attr("class", "glyphicon glyphicon-plus-sign");
		} // if
	}); // function
	
	$("#go").click(function(){
		
		var emailFlag=$("[name='email']").val();
		var titleFlag=$("[name='title']").val();
		var contentFlag=$("[name='content']").val();
		alert(contentFlag);
		
		if(""==emailFlag){
			alert("이메일을 입력해주세요");
			$("#userId").focus();
			return;
		}
		if(""==titleFlag){
			alert("제목을 입력해주세요");
			$("[name='title']").focus();
			return;
		}
		if(""==contentFlag){
			alert("내용을 입력해주세요");
			$("[name='content']").focus();
			return;
		}
		
		if(confirm("정말 메일을 전송하시겠습니까?")){
			$("[name='sendEmail']").submit();
		}
	});
});


</script>

<div class="card">
	<div class="card-header">
		<h5 style="margin-bottom: 0px;"><strong>메일 전송</strong></h5>
	</div>
	<div class="card-body">
	<input type="hidden" id="idSearchFlag" value="true"/>
		<div>
  	  		<strong>전체 회원에게 전송</strong>&nbsp;<input type="checkbox"/><br/> 
  	 	 </div>
		<div class="form-inline" style="padding-top: 10px; padding-bottom: 10px;">
            <strong>받는사람</strong>&nbsp; 
        <div class="input-group input-group-sm">
            <input type="text" id="userId" class="form-control input-search" placeholder="아이디" style="height:35px;">
            <span class="input-group-btn">
               		 <button id="searchBtn" class="btn btn-secondary" onclick="findEaddress()"><i class="glyphicon glyphicon-plus-sign" id="glyphiconBtn"></i></button>
           	</span>
        </div>
  	  </div>
	<form name="sendEmail" action="sendEmail.do" method="post">
  	  <div class="form-inline" style="padding-bottom: 10px;">
  	  	<strong style="padding-right: 17px;">이메일</strong>
  	  	<input type="text" id="email" name="email" class="form-control input-search" readonly style="width:30%; height:35px;"/>
  	  </div>
		<div class="form-inline">
			<input type="text" name="title" class="form-control input-search" placeholder="제목" maxlength="50" style="width:100%;height:35px;" >
		</div>
  	  
  	  <br/>
  	  <div>
  	  	<textarea name="content" class="form-control input-search" style="width:100%; height:500px;"></textarea>
  	  
  	  </div>
	  </form>
  	  <br/>
  	  <input type="button" class="btn btn-brand btn-vine" id="go" value="전송"/>
	</div>
</div>
