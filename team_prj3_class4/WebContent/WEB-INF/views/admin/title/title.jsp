<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<script type="text/javascript">

$(function () {
	
	// input file 선택된이름 안나오게 설정
	$('#btn-upload').click(function (e) {
		e.preventDefault();
	$('#file').click();
			});
	$('#btn-upload2').click(function (e) {
		e.preventDefault();
	$('#file2').click();
			});
	$('#btn-upload3').click(function (e) {
		e.preventDefault();
	$('#file3').click();
			});
	
   	var ext=["jpg"];
   	var flag=null;
    $("#file").change(function(){
		 flag=false;
	   	 if($("#file").val()!=""){
			var fileValue = $("#file").val().split("\\");
		   	var fileValue2 = $("#file").val(); // path
		   	var fileValue3 = $("#file").val().split("."); // path
		   	var inputExt=fileValue3[fileValue3.length-1].toLowerCase();
		   	var fileName = fileValue[fileValue.length-1]; // 파일명
	
		   	for(var i=0; i<ext.length; i++){
		   		if(ext[i] ==inputExt){
		   			flag=true;
		   			break;
		   		} // if
		   	} // for
		   	
		   	if(!flag){
		   		alert("업로드 불가한 확장자입니다");
		   		return;
		   	} else{
		   		function readURL(input) {
			        if (input.files && input.files[0]) {
			            var reader = new FileReader();
			            reader.onload = function(e) {
			                $('#foo').attr('src', e.target.result);
			            }
		            	$("#imgNullChk").val("true");
			            reader.readAsDataURL(input.files[0]);
			        }
			    }

			        readURL(this);
		   	}
   		 } // if
 	});//change
    $("#file2").change(function(){
		 flag=false;
	   	 if($("#file2").val()!=""){
			var fileValue = $("#file2").val().split("\\");
		   	var fileValue2 = $("#file2").val(); // path
		   	var fileValue3 = $("#file2").val().split("."); // path
		   	var inputExt=fileValue3[fileValue3.length-1].toLowerCase();
		   	var fileName = fileValue[fileValue.length-1]; // 파일명
	
		   	for(var i=0; i<ext.length; i++){
		   		if(ext[i] ==inputExt){
		   			flag=true;
		   			break;
		   		} // if
		   	} // for
		   	
		   	if(!flag){
		   		alert("업로드 불가한 확장자입니다");
		   		return;
		   	} else{
		   		function readURL(input) {
			        if (input.files && input.files[0]) {
			            var reader = new FileReader();
			            reader.onload = function(e) {
			            	$("#imgNullChk2").val("true");
			                $('#foo2').attr('src', e.target.result);
			            }
			            reader.readAsDataURL(input.files[0]);
			        }
			    }

			        readURL(this);
		   	}
   		 } // if
 	});//change
    $("#file3").change(function(){
		 flag=false;
	   	 if($("#file3").val()!=""){
	   		 //alert("파일이 빈칸이 아닐때");
			var fileValue = $("#file3").val().split("\\");
		   	var fileValue2 = $("#file3").val(); // path
		   	var fileValue3 = $("#file3").val().split("."); // path
		   	var inputExt=fileValue3[fileValue3.length-1].toLowerCase();
		   	var fileName = fileValue[fileValue.length-1]; // 파일명
	
		   	for(var i=0; i<ext.length; i++){
		   		if(ext[i] ==inputExt){
		   			flag=true;
		   			break;
		   		} // if
		   	} // for
		   	
		   	if(!flag){
		   		alert("업로드 불가한 확장자입니다");
		   		return;
		   	} else{
		   		function readURL(input) {
			        if (input.files && input.files[0]) {
			            var reader = new FileReader();
			            reader.onload = function(e) {
			            	$("#imgNullChk3").val("true");
			                $('#foo3').attr('src', e.target.result);
			            }
			            reader.readAsDataURL(input.files[0]);
			        }
			    }

			        readURL(this);
		   	}
   		 } // if
 	});//change
 	
 	$("[name='titleSubmit']").click(function(){
 		if($("#imgNullChk").val()=="true"){
	 		$("[name='titleUploadFrm']").submit();
 		} else{
 			alert("이미지를 선택해주세요");
 		}
 	});
 	$("[name='titleSubmit2']").click(function(){
 		if($("#imgNullChk2").val()=="true"){
	 		$("[name='titleUploadFrm2']").submit();
 		} else{
 			alert("이미지를 선택해주세요");
 		}
 	});
 	$("[name='titleSubmit3']").click(function(){
 		if($("#imgNullChk3").val()=="true"){
	 		$("[name='titleUploadFrm3']").submit();
 		} else{
 			alert("이미지를 선택해주세요");
 		}
 	});
 	
 	
});

</script>

<div class="card">
	<div class="card-header">
		<h5 style="margin-bottom: 0px;"><strong>타이틀</strong></h5>
	</div>
	<div class="card-body">
                    <div style="font-size:15px;"> ★ 이미지 최적사이즈는 가로1200px, 세로 400px입니다</div>
				
		<div>
				<table class="table table-responsive-sm">
						
					<tbody style="border-bottom: 1px solid #c8ced3;">
							<tr>
								<td>
									<h3>첫번째 이미지</h3>
								</td>
							</tr>
							<tr>
								<td>
									<div style="display:flex; align-items:center;">
										<input type="hidden" id="imgNullChk" value=""/>
										<form action="titleUpload.do" method="post" name="titleUploadFrm" enctype="multipart/form-data">
											<input type="hidden" name="titleNumber" value="01"/>
											<input type="file" id="file" name="file"/>
											<button type="button" id="btn-upload" name="btn-upload" value="temp" style="margin-top:10px; width:1200px; height:400px;">
												<img src="http://211.63.89.148:8080/team_prj3_class4/upload/title/titleImg01.jpg" class="categoryImg" id="foo">
											</button>
										</form>
										<span class="input-group-btn col-3" style="   padding-left: 50px;    padding-right: 30px;    padding-bottom: 20px;    padding-top: 50px;    border-bottom-width: 20px; margin-bottom: 0px;">
							                <span class="input-group-btn">
							               		 <button type="submit" name="titleSubmit" class="btn" style="font-size:100px; width:100%; height:100%;">
							               		 	<i class="glyphicon glyphicon-floppy-open"></i>
							               		 </button>
							           		</span>
							            </span>
										
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<h3>두번째 이미지</h3>
								</td>
							</tr>
							<tr>
								<td>
								<div style="display:flex; align-items:center;">
								<input type="hidden" id="imgNullChk2" value=""/>
									<form action="titleUpload.do" method="post" name="titleUploadFrm2" enctype="multipart/form-data">
										<input type="hidden" name="titleNumber" value="02"/>
										<input type="file" id="file2" name="file"/>
										<button type="button" id="btn-upload2" name="temp" value="temp" style="margin-top:10px; width:1200px; height:400px;">
											<img src="http://211.63.89.148:8080/team_prj3_class4/upload/title/titleImg02.jpg" class="categoryImg" id="foo2">
										</button>
									</form>
									<span class="input-group-btn col-3">
							                <span class="input-group-btn">
							               		 <button type="submit" name="titleSubmit2" class="btn" style="font-size:100px; width:100%; height:100%;"><i class="glyphicon glyphicon-floppy-open"></i></button>
							           		</span>
							        </span>
									</div>
								</td>
							</tr>
						<!-- </td>
						<td> -->
							<tr>
								<td>
									<h3>세번째 이미지</h3>
								</td>
							</tr>
							<tr>
								<td>
								<div style="display:flex; align-items:center;">
								<input type="hidden" id="imgNullChk3" value=""/>
									<form action="titleUpload.do" method="post" name="titleUploadFrm3" enctype="multipart/form-data">
										<input type="hidden" name="titleNumber" value="03"/>
										<input type="file" id="file3" name="file"/>
										<button type="button" id="btn-upload3" name="temp" value="temp" style="margin-top:10px; width:1200px; height:400px;">
											<img src="http://211.63.89.148:8080/team_prj3_class4/upload/title/titleImg03.jpg" class="categoryImg" id="foo3">
										</button>
									</form>
									<span class="input-group-btn col-3">
							                <span class="input-group-btn">
							               		 <button type="submit" class="btn" name="titleSubmit3" style="font-size:100px; width:100%; height:100%;"><i class="glyphicon glyphicon-floppy-open"></i></button>
							           		</span>
							       </span>
									</div>
								</td>
							</tr>
					</tbody>
				</table>
		</div>
				
	</div>
</div>
