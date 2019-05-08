<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
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
	
   	var ext=["jpg","png"];
   	var flag=null;
    $("#file").change(function(){
		 flag=false;
	   	 if($("#file").val()!=""){
	   		 alert("파일이 빈칸이 아닐때");
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
	   		 alert("파일이 빈칸이 아닐때");
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
	   		 alert("파일이 빈칸이 아닐때");
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
			                $('#foo3').attr('src', e.target.result);
			            }
			            reader.readAsDataURL(input.files[0]);
			        }
			    }

			        readURL(this);
		   	}
   		 } // if
 	});//change
 	
});

</script>


<!--  -->
<div class="card">
	<div class="card-header">
                    <i class="fa fa-align-justify"></i> 메인 헤더
	</div>
	<div class="card-body">
                    이미지 최적사이즈는 가로1200px, 세로 400px입니다
				
		<div>
				<table class="table table-responsive-sm">
						
					<tbody style="border-bottom: 1px solid #c8ced3;">
						<td>
							<tr>
								<td>
									<h3>첫번째 이미지</h3>
								</td>
							</tr>
							<tr>
								<td>
									<div style="display:flex; align-items:center;">
										<form action="titleUpload.do" method="post" name="titleUploadFrm" enctype="multipart/form-data">
											<input type="hidden" name="firstTitle" value="1"/>
											<input type="file" id="file" name="file"/>
											<button type="button" id="btn-upload" name="btn-upload" value="temp" style="margin-top:10px;">
												<img src="http://localhost:8080/team_prj3_class4/upload/category/default.jpg" class="categoryImg" id="foo">
											</button>
										</form>
										&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;
										
										<span class="input-group-btn">
							                <span class="input-group-btn">
							               		 <button type="submit" class="btn" style="font-size:100px;"><i class="glyphicon glyphicon-floppy-open"></i></button>
							           		</span>
							            </span>
										
										
										
										
										
										
										<!-- <input type="button" value="버튼"/> -->
									</div>
								</td>
							</tr>
						</td>
						<td>
							<tr>
								<td>
									<h3>두번째 이미지</h3>
								</td>
							</tr>
							<tr>
								<td>
								<div style="display:flex; align-items:center;">
									<form action="titleUpload.do" method="post" name="titleUploadFrm2" enctype="multipart/form-data">
										<input type="hidden" name="secondTitle" value="2"/>
										<input type="file" id="file2" name="file"/>
										<button type="button" id="btn-upload2" name="temp" value="temp" style="margin-top:10px;">
											<img src="http://localhost:8080/team_prj3_class4/upload/category/default.jpg" class="categoryImg" id="foo2">
										</button>
									</form>
									<input type="button" value="버튼"/>
									</div>
								</td>
							</tr>
						</td>
						<td>
							<tr>
								<td>
									<h3>세번째 이미지</h3>
								</td>
							</tr>
							<tr>
								<td>
								<div style="display:flex; align-items:center;">
									<form action="titleUpload.do" method="post" name="titleUploadFrm3" enctype="multipart/form-data">
										<input type="hidden" name="thirdTitle" value="3"/>
										<input type="file" id="file3" name="file"/>
										<button type="button" id="btn-upload3" name="temp" value="temp" style="margin-top:10px;">
											<img src="http://localhost:8080/team_prj3_class4/upload/category/default.jpg" class="categoryImg" id="foo3">
										</button>
									</form>
									<input type="button" value="버튼"/>
									</div>
								</td>
							</tr>
						</td>
					</tbody>
				</table>
		</div>
				
	</div>
</div>
