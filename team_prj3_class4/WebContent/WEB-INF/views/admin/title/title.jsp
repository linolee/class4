<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<script type="text/javascript">

$(function () {
	
	// input file 선택된이름 안나오게 설정
	$('#btn-upload').click(function (e) {
		e.preventDefault();
	$('#file').click();
			});
	
			// 업로드시키고 업로드장소에 파일네임을 더하여 본문에 추가해야함
			// 파일네임은 업로드시간정보를 추가해서 저장
   	var ext=["jpg","png"];
   	var flag=null;
    /* $("#file").change(function(){ */
    $("#file").change(function(){
		 flag=false;
	   	 /* alert("파일바뀜"); */
	   	 /* alert("클릭"); */
	   	 if($("#file").val()!=""){
	   		 alert("파일이 빈칸이 아닐때");
			var fileValue = $("#file").val().split("\\");
		   	var fileValue2 = $("#file").val(); // path
		   	var fileValue3 = $("#file").val().split("."); // path
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
		   		return;
		   	} else{
		   		function readURL(input) {
		   			//alert("1");
			        if (input.files && input.files[0]) {
			        	//alert("2");
			            var reader = new FileReader();
			            reader.onload = function(e) {
			            	//alert("3");
			                $('#foo').attr('src', e.target.result);
			            }
			            reader.readAsDataURL(input.files[0]);
			        }
			    }

			    	 //alert("4");
			        readURL(this);
		   	}
   		 } // if
 	});//change
 	
});

</script>


<!--  -->
                <div class="card">
                  <div class="card-header">
                    <i class="fa fa-align-justify"></i> 메인 헤더</div>
                  <div class="card-body">
                    이미지 최적사이즈는 가로1200px, 세로 400px입니다
				
				<!--  -->				
				
				<div>
				<form action="#void" method="post" name="uploadImg" id="uploadImg" enctype="multipart/form-data">
					<input type="file" id="file" name="file"/>
					<!-- <input type="file" id="file" name="file" onchange="changeValue(this)"/> -->
					<button type="button" id="btn-upload" name="temp" value="temp" class="btn btn-pill btn-block btn-light active col-2" align="right" style="margin-top:10px;">사진 변경</button><br/>
                  		<div>
                  		<!-- <img src="category.png" align="left" style="max-width: 70%; height: auto; margin-bottom:20px;" id="foo"><br/> -->
                  		<img src="http://localhost:8080/team_prj3_class4/resources/admin/default.jpg" id="foo" class="titleImg"><br/>
                  		</div><br/>
                  	<input class="btn btn-pill btn-block btn-light active col-2" type="button" value="적용하기"/><br/>
                </form>
				</div>
				
				<!--  -->
				
                  </div>
                </div>
					            

<!--  -->



