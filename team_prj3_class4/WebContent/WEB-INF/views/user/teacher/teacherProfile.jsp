<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Libre+Baskerville|Nanum+Myeongjo" rel="stylesheet"> 
<link rel="stylesheet" type="text/css" href="http://localhost:8080/team_prj3_class4/resources/css/main_v190130.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/team_prj3_class4/resources/css/class.css">

<!-- Bootstrap btn include -->
<!-- <link href="/docs/4.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> -->
<link href="https://cdn.jsdelivr.net/npm/docsearch.js@2/dist/cdn/docsearch.min.css" rel="stylesheet">
<!-- <link href="/docs/4.0/assets/css/docs.min.css" rel="stylesheet"> -->
<link href="<c:url value="/resources/css/header.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/footer.css" />" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<style type="text/css">
#wrap {margin: 0px auto; width: 1100px; height: 860px;}
#mypageTitle {font-size: 50px; font-weight:bold; color:#2B2B2B;  text-align: left; top: 40px; left: 290px;}
#headerTitle2 {font-size: 30px; font-weight: normal; color:#757575; text-align: left; top: 40px; left: 290px;}
#title3 {font-size: 35px; color:#555555; font-weight: bold;}
#title4 {color:#757575; }
#container {margin: 0px auto; width: 1100px; min-height: 600px;}
#listTab {border-top: 1px solid #333; border-spacing: 0px;}
#addProfileFrm {border: 1px solid #333333; background-color: #FFFFFF; padding: 10px;}
#updateProfile {position: absolute; top: 220px; left: 500px; }
#updateProfileFrm {border: 1px solid #333333; background-color: #FFFFFF; padding: 10px;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
var index = 0;
var flag = 1;
function addTeacherCareer() {
	
	//경력사항 입력 여부 확인
	if ($("#inputCareer").val() == '' || $("#inputCareer").val() == undefined) {
		alert("경력사항을 입력해주세요");
		return false;
	} // end if
	
	//경력은 5개까지만 등록 가능하도록
	var childrenLength = $("#careerList").children().length;
	if (childrenLength > 4) {
		alert("경력은 5개까지만 등록 가능합니다.");
		$("#inputCareer").val("");
		return false;
	}
	
	$("#addProfileFrm").css("height", "640px");
	$("#careerList").show();
	var career = $("#inputCareer").val();
	
	var str = "";
	str += "<div class='careerDiv' id='careerDiv"+index+"'>";
	str += 		"<span class='career-span'>"+career+"</span>";
	str += 		'<input type="button" value="삭제" class="btn btn-danger delCareer" id="delCareer'+index+'" onclick="delCareer('+index+')">';
	str += "</div>";
	
	index++;
	$("#inputCareer").val("");
	$("#careerList").append(str);
} //

function delCareer(index) {
	$("#careerDiv"+index).remove();
} // delCareer

function closeModal() {
	$(".inputBox").val("");
	$("#classField").find("option:eq(0)").prop("selected", true);
	$("#classField option").attr("disabled", false);
	
	$("#teacher-intro").text("");
	$("#careerList").children().each(function() {
		$(this).remove();
	});
	$("#careerList").hide();
	$(".addMode").hide();
	$(".updateMode").hide();
	
	$("#addProfileFrm").css("height", "480px");
	
	$("#profileForm").hide();
	
} //closeModal

function checkTeacherName() {
	var checkName = $("#teacherName").val();
	
	if(checkName == '' || checkName == null || checkName == undefined){
		alert("강사명을 입력해주세요.");
		return false;
	} // end if
	
	$.ajax({
		url:"<c:url value= '/user/teacher/check_teacherName.do'/>",
		type : "GET",
		data : {"checkName":checkName},
		dataType:"text",
		success: function (msg) {
			if(msg == 1){ // 1 존재 true
				alert("이미 사용중인 강사명입니다.");
				flag = 0;
				$("#teacherName").focus();
			}else if(msg == 0){
				alert("사용 가능합니다.");
				flag = 1;
			} // end else
		},
		error: function (data) {
			console.log(data);
		}
	}); // ajax
	
} // checkTeacherName

//미리보기 띄우는 function
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#img').attr('src', e.target.result);
        }//function
        reader.readAsDataURL(input.files[0]);
    }//end if
}//readURL

function setModal(url, teacherName) {
	// * 공통
	// 경력 사항 option 삭제
	$("#classField").children().each(function() {
		$(this).remove();
	});
	
	//이미지 비우기
	$("#img").attr("src", "http://localhost:8080/team_prj3_class4/common/images/default.png");
	
	// 카테고리 불러오기
	$.ajax({
		url:"<c:url value= '/user/teacher/get_category.do'/>",
		type : "GET",
		dataType:"json",
		success: function (category) {
			//category set
			var str = "";
			str += "<option value='none'>======== 선택 ========</option>";
			for (var i = 0; i < category.length; i++) {
				str += "<option value='"+category[i]+"'>"+category[i]+"</option>";
			}
			$("#classField").append(str);
			setModalTeacherInfo(url, teacherName);
		},
		error: function (data) {
			console.log("error!!!!!!!!!");
			console.log(data);
		}
	}); // ajax
}

function setModalTeacherInfo (url, teacherName) {
	var btnStr = "";
	if(url == "addProfile"){
		$("#mode").val("add");
		$("#teacherStatus").val("");
		$("#teacherName").attr("readonly",false);
		$("#doubleCheck").show();
		$(".addMode").show();
		$("#profileForm").show();
	} else if(url == "updateProfile"){
		$("#mode").val("update");
		
		$.ajax({
			url:"<c:url value= '/user/teacher/teacher_detail.do'/>",
			type : "GET",
			data : {"teacherName":teacherName},
			dataType:"json",
			success: function (msg) {
				//teacher Info set
				var teacherInfo = msg.list;
				$("#img").attr("src", "http://localhost:8080/team_prj3_class4/upload/teacher/"+teacherInfo.img);
				$("#teacherStatus").val(teacherInfo.status);
				$("#teacherName").val(teacherInfo.teacherName);
				$("#teacherName").attr("readonly",true);
				$("#doubleCheck").hide();
				$("#teacher-intro").text(teacherInfo.introduce);
				
				//carrer set
				var career = msg.c_list;
				var str = "";
				for (var i = 0; i < career.length; i++) {
					str += "<div class='careerDiv' id='careerDiv"+i+"'>";
					str += 		"<span class='career-span'>"+career[i]+"</span>";
					str += 		'<input type="button" value="삭제" class="btn btn-danger delCareer" id="delCareer'+i+'" onclick="delCareer('+i+')">';
					str += "</div>";
				}
				
				$("#inputCareer").val("");
				$("#careerList").append(str);
				$("#careerList").show();
				
				//category set
				var category = teacherInfo.category;
				if (category.indexOf("/") != -1) {
					category = category.replaceAll("/", "&#47;");
				}
				
				$('#classField option[value='+category+']').attr('selected','selected');
				$("#classField option").not(":selected").attr("disabled", "disabled");
				
				$(".updateMode").show();
				$("#profileForm").show();
			},
			error: function (data) {
				console.log("error");
				console.log(data);
			}
		}); // ajax
	} // checkTeacherName
}

function updateTeacherStatus() {
	var teacherName = $("#teacherName").val();
	
	$.ajax({
		url:"<c:url value= '/user/teacher/modify_teacherStatus.do'/>",
		type : "GET",
		data : {"teacherName":teacherName},
		dataType:"text",
		success: function (msg) {
			if (msg == 1) {
				alert("삭제되었습니다");
			} else {
				alert("강사 프로필 삭제에 실패했습니다"+"\n"+"진행중이거나 신청중인 강의가 있는지 확인하세요.");
			} // end else
			
			location.href="";
		},
		error: function (data) {
			console.log("error");
			console.log(data);
		}
	}); // ajax
}

function beforeCheck() {
	//value
	var mode 		 = $("#mode").val();
	var upfile 		 = $("#upfile").val();
	var teacherName  = $("#teacherName").val();
	var classField   = $("#classField").val();
	var inputCareer  = $("#careerList").children().length;
	var teacherIntro = $("#teacher-intro").val();
	var teacherStatus = $("#teacherStatus").val();
	var careerStr	 = "";
	
	if (mode == "update" && teacherStatus == 'R') {
		alert("승인이 거절된 프로필입니다.");
		return false;
	}
	
	//필수값 확인
	if(upfile == "" && mode == "add"){
		alert("이미지를 선택해주세요.");
		return false;
	} // end if
	
    if(teacherName == null || teacherName == ''){
       alert("강사명을 입력해주세요.");
       $("#teacherName").focus();
       return false;
    }	   
    
	var category=$('#classField option:selected').val();
	if(category == 'none'){
        alert("교육분야를 선택해주세요.");
        $("#classField").focus();
        return false;
    }
    
	if(inputCareer == null || inputCareer == 0){
       alert("경력사항을 입력해주세요.");
       $("#inputCareer").focus();
       return false;
    } else {
    	$(".careerDiv").find(".career-span").each(function() {
    		careerStr += $(this).text();
    		careerStr += ",";
    	});
    }  
    
    if(teacherIntro == null || teacherIntro == ''){
       alert("자기소개를 입력해주세요.");
       $("#teacherIntro").focus();
       return false;
    }  
    
    $("#teacherName").on("change", function() {
    	flag = 0;
    });
    
	if(flag == 0){
		alert("중복확인을 해주세요.");
		 return false;
	}
    
    $("#careerVal").val(careerStr);
    
	document.addTeacherForm.submit();
}

$(function(){
	$("#profileForm").hide();
	$("#careerList").hide();
	
	$(".addMode").hide();
	$(".updateMode").hide();
	
	$("#upfile").change(function() {
		var upfile = $("#upfile").val();
		
		if(upfile == ""){
			alert("이미지를 선택해주세요.");
			return false;
		} // end if
		
		if(upfile != ""){
			var fileExt = upfile.substring(upfile.lastIndexOf(".")+1);
			var reg = /gif|jpg|jpeg|png/i; // 업로드 가능 확장자.
			
			if(reg.test(fileExt) == false){
				alert("첨부 파일은 gif, jpg, png로 된 이미지만 가능합니다.");
				return false;
			} // end if
		} // end if
		readURL(this);
	}); // end click
	
	$("#addTeacherProfile").on("click", function() {
/* 		//value
		var upfile 		 = $("#upfile").val();
		var teacherName  = $("#teacherName").val();
		var classField   = $("#classField").val();
		var inputCareer  = $("#careerList").children().length;
		var teacherIntro = $("#teacher-intro").val();
		var careerStr	 = "";
		
		console.log(upfile);
		alert(111111111111111);
	   
		//필수값 확인
		if(upfile == ""){
			alert("이미지를 선택해주세요.");
			return false;
		} // end if
		
	    if(teacherName == null || teacherName == ''){
	       alert("강사명을 입력해주세요.");
	       $("#teacherName").focus();
	       return false;
	    }	   
	    
		var category=$('#classField option:selected').val();
		if(category == 'none'){
	        alert("교육분야를 선택해주세요.");
	        $("#classField").focus();
	        return false;
	    }
	    
		if(inputCareer == null || inputCareer == 0){
	       alert("경력사항을 입력해주세요.");
	       $("#inputCareer").focus();
	       return false;
	    } else {
	    	$(".careerDiv").find(".career-span").each(function() {
	    		careerStr += $(this).text();
	    		careerStr += ",";
	    	});
	    }  
	    
	    if(teacherIntro == null || teacherIntro == ''){
	       alert("자기소개를 입력해주세요.");
	       $("#teacherIntro").focus();
	       return false;
	    }  
	    
	    $("#teacherName").on("change", function() {
	    	flag = 0;
	    });
	    
		if(flag == 0){
			alert("중복확인을 해주세요.");
			 return false;
		}
	    
	    $("#careerVal").val(careerStr);
	    
	    return false; */
	});

});//ready

</script>
<link href="<c:url value="/resources/css/header.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/footer.css" />" rel="stylesheet">
</head>
<body>
<div id="wrap">
	<div id="header">
		<c:import url="../header/header.jsp"></c:import>
	</div>
	<div id="container">
		<div id="mypageTitle">마이페이지</div>
		<div id="headerTitle2">회원님의 소중한 정보들을 관리하실 수 있습니다.</div>
		<div style="padding-top: 30px; padding-bottom: 20px;">
			<%-- <c:import url="/resources/jsp/main_menu.jsp"/> --%>
			<jsp:include page="/resources/jsp/main_menu.jsp"/>
		</div>
		<div id="title3">강사 프로필 관리</div>
		<div id="title4">강사님께서 등록한 프로필을 관리합니다.</div>
		<br/>
		
		<div class="addBtn">
			<input type="button" value="프로필 추가" class="btn btn-warning" onclick="setModal('addProfile', '')"><br>
		</div>
		
		<div id="listContents">
			<table id="listTab" border="1">
				<colgroup>
					<col width="10%" />
					<col width="15%" />
					<col width="20%" />
					<col width="40%" />
					<col width="15%" />
				</colgroup>
				<thead>
					<tr style="margin: auto;">
						<th class="class-th">구분</th>
						<th class="class-th">강사명</th>
						<th class="class-th">교육분야</th>
						<th class="class-th">소갯말</th>
						<th  class="class-th">비고</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty profileList}">
							<c:forEach var="list" items="${profileList}">
							<c:choose>
								<c:when test="${ list.status eq 'Y'}">
									<c:set var="css" value="ys"/>
									<c:set var="txt" value="승인"/>
								</c:when>
								<c:when test="${ list.status eq 'N'}">
									<c:set var="css" value="rd"/>
									<c:set var="txt" value="미승인"/>
								</c:when>
								<c:when test="${ list.status eq 'R'}">
									<c:set var="css" value="ac"/>
									<c:set var="txt" value="거절"/>
								</c:when>
							</c:choose>
							
							<tr class="class-list">
								<td><span class="ico ${css}"><c:out value="${txt}"/></span></td>
								<td><c:out value="${list.teacherName }"/></td>
								<td><c:out value="${list.category }"/></td>
								<td><c:out value="${list.introduce }"/></td>
								<td><input type="button" class="btn btn-warning" value="상세보기" onclick="setModal('updateProfile', '${list.teacherName }')"></td>
							</tr>
						</c:forEach>
						</c:when>
						<c:otherwise>
						<tr class="class-list">
							<td colspan="5"  align="center">클래스가 존재하지 않습니다.<br/></td>
						</tr>
						</c:otherwise>
					</c:choose>
				</tbody>				
			</table><br>
			
			<!-- profile form -->
			<div id="profileForm">
				<div id="updateProfileFrm">
					<form name="addTeacherForm" id="addTeacherForm" action="/team_prj3_class4/user/teacher/add_teacher.do" method="post" enctype="multipart/Form-data"> 
						<input type="hidden" id="mode" name="mode" value="add">
						<input type="hidden" id="careerVal" name="careerVal" value="">
						<input type="hidden" id="teacherStatus" name="teacherStatus" value="">
						<div>
							<div class="picture-area">
								<div class="picture-panel">
									<img src="http://localhost:8080/team_prj3_class4/common/images/default.png" id="img" style="width: 98px; height: 100px"/>
								</div>
								<div class="picture-btn">
									<input type="file" value="사진등록" class="btn btn-primary" id="upfile" name="upfile"><br>
								</div>
							</div>
							<div class="teacher-info">
								<div class="teacher-info-name-area">
									<div class="teacher-info-name">
										<span>강사명</span>
										<input type="text" name="teacherName" class="inputBox" id="teacherName" value="">
										<input type="button" value="중복확인" class="btn btn-primary" id="doubleCheck" onclick="checkTeacherName()">
									</div> 
								</div>
								<div class="teacher-edu">
									<span>교육분야</span>
									<select name="category" class="classField" id="classField">
										<!-- option 추가 -->
									</select>
								</div>
								<div class="teacher-career">
									<span class="careerOption">경력사항</span>
									<input type="text" name="inputCareer" id="inputCareer" class="inputBox">
									<input type="button" value="추가" class="btn btn-primary" id="addCareer" onclick="addTeacherCareer()"/>
									<div id="careerList"><!-- 경력 --></div>
								</div>
								<div class="teacher-intro-area">
									<span>자기소개</span>
									<textarea id="teacher-intro" name="introduce"></textarea>
								</div>
								<div class="profileBtn" id="profileBtn">
									<!-- btn append area -->
									<div class="addMode">
										<input type="button" value="등록신청" class="btn btn-warning" name="btnApply" id="addTeacherProfile" onclick="beforeCheck()">
										<input type="button" value="확인" class="btn btn-warning" name="btnClose" onclick="closeModal()">
									</div>
									<div class="updateMode">
										<input type="button" value="수정" class="btn btn-warning" name="btnApply" id="addTeacherProfile"  onclick="beforeCheck()">
										<input type="button" value="삭제" class="btn btn-warning" name="btnApply" id="deleteTeacherProfile" onclick="updateTeacherStatus()">
										<input type="button" value="확인" class="btn btn-warning" name="btnClose" onclick="closeModal()">
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
			<!-- profile form -->
			
			<!-- prev & next -->
			<div style="text-align: center">
				<div style="display: inline-block;">
					<ul class="pagination ">
						<c:out value="${ indexList }" escapeXml="false"/>
					</ul>
				</div>
			</div>	
			<!-- prev & next -->
			
		</div>
	</div>
	<div id="footer">
		<c:import url="../footer/footer.jsp" />
	</div>
</div>

</body>
</html>