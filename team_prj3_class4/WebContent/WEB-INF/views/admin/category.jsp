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
	
	// input file 선택된이름 안나오게 설정
	$('#btn-upload').click(function (e) {
		e.preventDefault();
	$('#file').click();
			});
	$('#btn-upload2').click(function (e) {
		e.preventDefault();
	$('#file2').click();
			});

///////////////////////// 서브밋하면 파일네임에 시간정보를 추가하여 서버에 저장 /////////////////////////
///////////////////////// 본문 사진, 메인화면에 사진 변경 /////////////////////////
///////////////////////// 이미지 크기, 용량 제한 /////////////////////////

   	var ext=["jpg","png"];
   	var flag=null;
    $("#file,#file2").change(function(){
		 flag=false;
	   	 /* alert("파일바뀜"); */
	   	 alert("클릭");
	   	 if($("#file").val()!=""){
	   		 alert("파일이 빈칸이 아닐때");
			var fileValue = $("#file,#file2").val().split("\\");
		   	var fileValue2 = $("#file,#file2").val(); // path
		   	var fileValue3 = $("#file,#file2").val().split("."); // path
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

</script>

<!-- 주석주석주석주석주석주석주석주석주석주석주석주석주석 -->

<!--  -->
                <div class="card">
                  <div class="card-header">
                    <i class="fa fa-align-justify"></i> 카테고리 관리</div>
                  <div class="card-body">
                <div style="text-align: right">
	                <div style="display: inline-block;">
	                  	<button type="button" class="btn btn-pill btn-block btn-light active" align="right" data-toggle="modal" data-target="#modalAddCategory">카테고리 추가</button>
	                </div>
                 </div>
                  
				<div class="card">
                  <div class="card-body">
                    <table class="table table-responsive-sm">
             <tbody>
					<tr>
                          <td>음악</td>
                          <td><img src="http://localhost:8080/team_prj3_class4/resources/admin/default.jpg" class="categoryImg"></td>
                          <td><a data-toggle="modal" href="#modalCategory">카테고리 수정</a></td> 
                  </tr>
					<tr>
                          <td>음악</td>
                          <td><img src="category.png" style="max-width: 70%; height: auto;"></td>
                          <td><a data-toggle="modal" href="#modalCategory">카테고리 수정</a></td> 
                  </tr>
					<tr>
                          <td>음악</td>
                          <td><img src="category.png" style="max-width: 70%; height: auto;"></td>
                          <td><a data-toggle="modal" href="#modalCategory">카테고리 수정</a></td> 
                  </tr>
			</tbody>
                    </table>
                    <div style="text-align: center">
                    <div style="display: inline-block;">
                    <ul class="pagination "  >
                      <li class="page-item">
                        <a class="page-link" href="#">Prev</a>
                      </li>
                      <li class="page-item active">
                        <a class="page-link" href="#">1</a>
                      </li>
                      <li class="page-item">
                        <a class="page-link" href="#">2</a>
                      </li>
                      <li class="page-item">
                        <a class="page-link" href="#">3</a>
                      </li>
                      <li class="page-item">
                        <a class="page-link" href="#">4</a>
                      </li>
                      <li class="page-item">
                        <a class="page-link" href="#">5</a>
                      </li>
                      <li class="page-item">
                        <a class="page-link" href="#">Next</a>
                      </li>
                    </ul>
                    </div>
                    </div>
                  </div>
                </div>	            
                  </div>
                </div>
                

<!--  -->

<!--  -->

<%-- <%
	request.setCharacterEncoding("utf-8");

	Enumeration params = request.getParameterNames();
	System.out.println("----------------------------");
	while (params.hasMoreElements()){
	    String name = (String)params.nextElement();
	    System.out.println(name + " : " +request.getParameter(name));
	}
	System.out.println("----------------------------");


	String flag = request.getParameter("uploadFlag");
	
	if(flag=="true"){

	request.setCharacterEncoding("UTF-8");
	// 파일업로드에 적합한 요청인지를 얻는다. 
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	if( isMultipart ){//파일업로드에 적합한 요청
		File repository=new File("C:/dev/workspace/practice/WebContent/practice/upload");
		
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();
	
		// 업로드파일이 메모리에 저장되는 최대 크기
		factory.setSizeThreshold(1024*1024*1);
		factory.setRepository(repository);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// 업로드파일의 최대 크기 설정
		upload.setSizeMax(1024*1024*5);
		
		try{
		// Parse the request
		List<FileItem> items = upload.parseRequest(request);
		
		// Process the uploaded items
		Iterator<FileItem> iter = items.iterator();
		String fieldName="" , fileName="", contentType="";
        long sizeInBytes=0;
		
		while (iter.hasNext()) {
		    FileItem item = iter.next();

		    if (item.isFormField()) {// 일반 HTML Form Control 인지? <input type="file"이 아닌 것
		    	 String controlName = item.getFieldName();
		    	 String controlValue = item.getString();
		    
		    	 
		    } else { //File Upload Control인지 <input type="file">
		    	fieldName = item.getFieldName();//File Control명
		        fileName = item.getName();//  FileControl 값
		        contentType = item.getContentType();//업로드 파일 종류
		        sizeInBytes = item.getSize();//크기
		        
		        File selectFile=new File(fileName);
		        File uploadedFile = new File(repository.getAbsolutePath()+"/"
		        	+selectFile.getName());//업로드파일의 저장경로와 파일명을 설정
		        item.write(uploadedFile);//설정된 파일을 업로드 
		        
		    }//end else 
		}//end while
		}catch(SizeLimitExceededException slee){
			//브라우저로 출력이 되지 않는다.
			out.println("예외!!!!");
		}//end catch
	}else{//파일업로드에 부적합 요청
		response.sendRedirect("upload_form.jsp");
	}//end else 
	}
		%> --%>


<!--  -->
<c:import url="modalCategory.jsp"/>
<c:import url="modalAddCategory.jsp"/>

