<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Libre+Baskerville|Nanum+Myeongjo" rel="stylesheet"> 
<link rel="stylesheet" type="text/css" href="http://211.63.89.148:8080/team_prj3_class4/resources/css/main_v190130.css">
<style type="text/css">
#wrap{ margin: 0px auto; width: 1100px; height: 860px;}
#mypageTitle{font-family:NanumGothic, '돋움', dotum, Helvetica, sans-serif; 
         font-size: 50px; font-weight:bold; color:#2B2B2B;  text-align: left; top: 40px; left: 290px;}
#headerTitle2{font-size: 30px; font-weight: normal; color:#757575; text-align: left;
         top: 40px; left: 290px;}
#title3{font-family:NanumGothic, '돋움', dotum, Helvetica, sans-serif; font-size: 35px; color:#555555; font-weight: bold;}
#title4{font-family:NanumGothic, '돋움', dotum, Helvetica, sans-serif; color:#757575; }

#container{ margin: 0px auto; width: 1100px; min-height: 600px;}
.baseTd1{ padding-left: 5px; height: 48px; width: 150px; font-weight: bold; border-bottom: 1px solid #BBBBBB; }
.baseTd2{ width: 950px; border-bottom: 1px solid #BBBBBB; }
.baseTd3{ padding-left: 5px; height: 96px; width: 150px; font-weight: bold; border-bottom: 1px solid #BBBBBB; }
.baseTd4{ padding-left: 5px; height: 400px; width: 150px; font-weight: bold; border-bottom: 1px solid #BBBBBB; }

.inputLine{ width: 700px; height: 34px; }
.inputDate{ width: 220px; height: 34px; }
.inputTime{ margin-left: 5px; width: 50px; height: 34px; }
.inputPerson{ margin-left: 5px; width: 80px; height: 34px; }
.remark{ font-size: 9px; color: #FF0000; }
.category{ width: 180px; height: 34px;  margin-right: 5px; }
.inputAddr{ width: 260px; height: 34px; }
.btn2{ width: 120px; height: 34px; background-color: #555555; color: #EEEEEE; font-weight: bold; border: 1px solid #333; }
.btn3{ width: 200px; height: 50px; color: #EEEEEE; font-weight: bold; border: 0px; }

</style>
<!-- summernote 관련 library 시작 -->
<!-- include libraries(jQuery, bootstrap) -->
<!-- <link href="http://localhost:8080/javaee_termprj3/common/summernote/bootstrap.css" rel="stylesheet"> -->
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/summernote/bootstrap.css"/>" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="http://211.63.89.148:8080/team_prj3_class4/resources/summernote/bootstrap.js"></script>

<!-- include summernote css/js -->
<link href="http://211.63.89.148:8080/team_prj3_class4/resources/summernote/summernote-lite.css" rel="stylesheet">
<script src="http://211.63.89.148:8080/team_prj3_class4/resources/summernote/summernote-lite.js"></script>
<script src="http://211.63.89.148:8080/team_prj3_class4/resources/summernote/lang/summernote-ko-KR.js"></script>
<script type="text/javascript">
function addClass() {
   
   //value
   var className = $("#className").val();
   var classSimpleInfo = $("#classSimpleInfo").val();
   var startDate = $("#startDate").val();
   var endDate = $("#endDate").val();
   var finDate = $("#finDate").val();
   var minPerson = $("#minPerson").val();
   var maxPerson = $("#maxPerson").val();
   var classInfo = $("#classInfo").val();
   var classCurriculum = $("#classCurriculum").val();
   var classTogether = $("#classTogether").val();
   var etc = $("#etc").val();
   var classAddr1 = $("#classAddr1").val();
   var classAddr2 = $("#classAddr2").val();
   var topBannerImg = $("#topBannerImg").val();
   var mainBannerImg = $("#mainBannerImg").val();
   
   //필수값 확인
   var category=$('#teacherProfile option:selected').val();
	if(category=='none'){
       alert("강사 프로필을 선택해주세요. (프로필이 없다면 프로필을 먼저 만들어주세요)");
       $("#teacherProfile").focus();
       return;
   }
   
    if(className == null || className == ''){
       alert("클래스 이름을 입력해주세요.");
       $("#className").focus();
       return;
    }
   
    if(classSimpleInfo == null || classSimpleInfo == ''){
       alert("간단 소개를 입력해주세요.");
       $("#classSimpleInfo").focus();
       return;
    }
    
    if(startDate == null || startDate == ''){
       alert("시작 일자를 선택해주세요.");
       $("#startDate").focus();
       return;
    }
   
    if(endDate == null || endDate == ''){
       alert("종료 일자를 선택해주세요.");
       $("#endDate").focus();
       return;
    }
   
    var sDate = new Date(startDate);   //시작일자
    var eDate = new Date(endDate);      //종료일자
    if (sDate > eDate) {
       alert("시작일자는 종료일자보다 클 수 없습니다.");
       return;
    }
    
    if ($("input:checkbox[name='chkWeek']:checked").length == 0) {
        alert("요일을 선택해주세요.");
        return;
     }
   
    
    if(minPerson == null || minPerson == ''){
       alert("최소인원을 입력해주세요.");
       $("#minPerson").focus();
       return;
    }
   
    if(maxPerson == null || maxPerson == ''){
       alert("최대인원을 입력해주세요.");
       $("#maxPerson").focus();
       return;
    }
    	
    if( parseInt(maxPerson) < parseInt(minPerson)){
       alert("최소인원은 최대인원보다 많을 수 없습니다.\n최소인원 : "+minPerson+"최대인원 : "+maxPerson);
       $("#minPerson").focus();
       return;
    }
    
    if(finDate == null || finDate == ''){
       alert("신청마감일을 선택해주세요.");
       $("#finDate").focus();
       return;
    } 
    
    var category=$('#mainCategory option:selected').val();
	if(category=='none'){
        alert("카테고리를 선택해주세요.");
        $("#mainCategory").focus();
        return;
    }
    
     var subCategory=$('#subCategory option:selected').val();
	if(subCategory=='none'){
        alert("서브 카테고리를 선택해주세요.");
        $("#subCategory").focus();
        return;
    } 

    if(classInfo == null || classInfo == ''){
       alert("클래스 소개를 입력해주세요.");
       return;
    }
    
    if(topBannerImg == null || topBannerImg == ''){
       alert("배너사진을 추가해주세요.");
       return;
    }
   
    if(mainBannerImg == null || mainBannerImg == ''){
       alert("대표사진을 추가해주세요.");
       return;
    }

    if(classAddr1 == null || classAddr1 == ''){
       alert("주소를 입력해주세요.");
       return;
    }
   
    if(classAddr2 == null || classAddr2 == ''){
       alert("나머지 주소를 입력해주세요.");
       return;
    }
   
   $("#frm").submit();
   
} // addClass

function cancelClass() {
	if(confirm("클래스 등록을 취소하시겠습니까?")){
		location.href="classStatus.do";
	}
}

   $(function() {
      $('.summernote').summernote({
         placeholder: '이벤트를 작성해 주세요', 
           tabsize: 2,
           height: 280,
           width: 700,
           lang: 'ko-KR'
      });
   });
</script>
<!-- summernote 관련 library 끝 -->
<script type="text/javascript">
function setSubCategory() {
	var category = $("#mainCategory option:selected").val();
	
 	var queryString = "category="+category;
 	$.ajax({
		url: "subCategorys.do",
		data: queryString,
		type: "post",
		dataType: "json",
		error: function(xhr) {
			alert("세부 카테고리 조회 실패");
			console.log(xhr.status + "/" + xhr.statusText);
		},
		success:function( json ){
	 		$("#subCategory *").remove();
			var output = "<option value='none'>--서브카테고리선택--</option>";
			if( json.subCategoryList.length != 0){
 				for(var i=0; i<json.subCategoryList.length; i++){
					output += "<option value='"+ decodeURIComponent(json.subCategoryList[i].subCategoryName) +"'>"+ decodeURIComponent(json.subCategoryList[i].subCategoryName)+"</option>";
					$("#subCategory").append(output);
					output = "";
				} 
			}
			if( json.subCategoryList.length == 0){
				$("#subCategory").append(output);
				output = "";
			}
		}
	});//ajax 
}
</script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    function searchAddr() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    //document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    //document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                //document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("classAddr1").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("classAddr2").focus();
            }
        }).open();
    }
</script>

<link href="<c:url value="/resources/css/header.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/footer.css" />" rel="stylesheet">


</head>
<body>
<div id="wrap">
   <div id="header">
      <c:import url="../header/header.jsp"></c:import>
   </div>
   <form id="frm" action="addClass_process.do" method="post" enctype="multipart/form-data">
   <div id="container">
      <div id="mypageTitle">마이페이지</div>
      <div id="headerTitle2">회원님의 소중한 정보들을 관리하실 수 있습니다.</div>
      <div style="padding-top: 30px; padding-bottom: 20px;">
         <c:import url="/resources/jsp/main_menu.jsp"/>
      </div>
      <div id="title3">클래스 등록</div>
      <div id="title4">클래스를 등록하실 수 있습니다. 해당 항목에 내용을 입력해주세요.</div>
      <br/>
      <hr color="#888888">
      <table>
         <tr>
            <td class="baseTd1">강사프로필</td>
            <td class="baseTd2">
            	<select name="teacherProfile" class="category" id="teacherProfile">
                  <option value="none">--강사프로필선택--</option>
                  <c:forEach var="tlist" items="${ t_list }">
                  	<option value="${ tlist }"><c:out value="${ tlist }"/></option>
                  </c:forEach>
            	</select>
            </td>
         </tr>
         <tr>
            <td class="baseTd1">클래스 이름</td>
            <td class="baseTd2"><input type="text" id="className" name="className" class="inputLine" placeholder="예시) 내 손으로 직접 만드는 가죽 지갑 클래스"></td>
         </tr>
         <tr>
            <td class="baseTd1">클래스 간단소개</td>
            <td class="baseTd2"><input type="text" id="classSimpleInfo" name="classSimpleInfo" class="inputLine" placeholder="예시) 카드 및 동전 수납이 가능한 리얼 가죽 카드 지갑을 만들어 보아요 ~(50자 이내)"></td>
         </tr>
         <tr>
            <td rowspan="2" class="baseTd3">클래스 날짜구성</td>
            <td>
               <input type="date" id="startDate" name="startDate" class="inputDate">부터
               <input type="date" id="endDate" name="endDate" class="inputDate">까지
            </td>
         </tr>
         <tr>
            <td class="baseTd2">
               <input type="checkbox" name="chkWeek" value="월">월 
               <input type="checkbox" name="chkWeek" value="화">화 
               <input type="checkbox" name="chkWeek" value="수">수 
               <input type="checkbox" name="chkWeek" value="목">목 
               <input type="checkbox" name="chkWeek" value="금">금 
               <input type="checkbox" name="chkWeek" value="토">토 
               <input type="checkbox" name="chkWeek" value="일">일 
               <select name="startHour" class="inputTime">
                  <c:forEach var="time" begin="01" end="24" step="1">
                  <option value="${ time }"><c:out value="${ time }"/></option>
                  </c:forEach>
               </select>시
               <select name="startMin" class="inputTime">
                  <c:forEach var="time" begin="00" end="60" step="1">
                  <option value="${ time }"><c:out value="${ time }"/></option>
                  </c:forEach>
               </select>분 ~ 
               <select name="endHour" class="inputTime">
                  <c:forEach var="time" begin="01" end="24" step="1">
                  <option value="${ time }"><c:out value="${ time }"/></option>
                  </c:forEach>
               </select>시
               <select name="endMin" class="inputTime">
                  <c:forEach var="time" begin="00" end="60" step="1">
                  <option value="${ time }"><c:out value="${ time }"/></option>
                  </c:forEach>
               </select>분
               <input type="number" id="minPerson" name="minPerson" class="inputPerson" placeholder="최소        명">
               <input type="number" id="maxPerson" name="maxPerson" class="inputPerson" placeholder="최대        명">
            </td>
         </tr>
         <tr>
            <td class="baseTd1">신청 마감일</td>
            <td class="baseTd2">
               <input type="date" id="finDate" name="finDate" class="inputDate" style="float: left; margin-right: 5px;">
               <span class="remark">신청마감일은 최소한 클래스 시작일 1일전으로 설정해주세요.<br>신청마감일 저녁 6시를 기준으로 클래스 예약신청이 마감됩니다.</span>
            </td>
         </tr>
         <tr>
            <td class="baseTd1">카테고리</td>
            <td class="baseTd2">
               <select name="mainCategory" class="category" id="mainCategory" onchange="setSubCategory()">
                  <option value="none">--카테고리선택--</option>
                  <c:forEach var="clist" items="${ c_list }">
                  	<option value="${ clist }"><c:out value="${ clist }"/></option>
                  </c:forEach>
               </select>
               <select name="subCategory" class="category" id="subCategory">
                  <option value="none">--서브카테고리선택--</option>
               </select>
            </td>
         </tr>
         <tr>
            <td class="baseTd4">클래스를 소개해요</td>
            <td class="baseTd2">
               <textarea name="classInfo" class="summernote" id="classInfo"></textarea>
            </td>
         </tr>
         <tr>
            <td class="baseTd4">이렇게 진행해요</td>
            <td class="baseTd2">
               <textarea name="classCurriculum" class="summernote" id="classCurriculum"></textarea>
            </td>
         </tr>
         <tr>
            <td class="baseTd4">함께하고 싶어요</td>
            <td class="baseTd2">
               <textarea name="classTogether" class="summernote" id="classTogether"></textarea>
            </td>
         </tr>
         <tr>
            <td class="baseTd1">포함/불포함 사항</td>
            <td class="baseTd2">
               <input type="checkbox" name="include1" value="장비대여">장비대여
               <input type="checkbox" name="include1" value="주차장" style="margin-left: 10px;">주차장
               <input type="checkbox" name="include1" value="강좌" style="margin-left: 10px;">강좌
               <input type="checkbox" name="include1" value="식사" style="margin-left: 10px;">식사
               <input type="checkbox" name="include1" value="차량" style="margin-left: 10px;">차량
               <input type="checkbox" name="include1" value="숙소" style="margin-left: 10px;">숙소
               <span class="remark"> * 포함되는 사항을 체크해주세요.</span>
            </td>
         </tr>
         <tr>
            <td class="baseTd1">기타사항</td>
            <td class="baseTd2">
               <input type="text" id="etc" name="etc" class="inputLine" placeholder="기타사항을 입력해주세요">
            </td>
         </tr>
         <tr>
            <td rowspan="2" class="baseTd3">상단배너 등록</td>
            <td><input type="file" id="topBannerImg" name="topBannerImg" class="inputLine"></td>
         </tr>
         <tr>
            <td class="baseTd2"><span class="remark"> * 권장사이즈 : 가로 2000픽셀, 세로 532픽셀(가로가 긴 이미지 추천)</span></td>
         </tr>
         <tr>
            <td rowspan="2" class="baseTd3">대표이미지 등록</td>
            <td><input type="file" id="mainBannerImg" name="mainBannerImg" class="inputLine"></td>
         </tr>
         <tr>
            <td class="baseTd2"><span class="remark"> * 권장사이즈 : 가로 250픽셀, 세로 250픽셀(정사각형 이미지 추천)</span></td>
         </tr>
         <tr>
            <td class="baseTd1">클래스 장소</td>
            <td class="baseTd2">
               <input type="text" id="classAddr1" name="classAddr1" class="inputAddr" readonly="readonly" placeholder="주소를 검색해주세요." style="background-color: #DEDEDE">
               <input type="button" value="주소검색" class="btn2" onclick="searchAddr()">
               <input type="text" id="classAddr2" name="classAddr2" class="inputAddr" placeholder="나머지 주소를 입력해주세요.">
            </td>
         </tr>
         <tr>
            <td class="baseTd1">클래스 상태</td>
            <td class="baseTd2">
               <span style="float: left; margin-right: 10px;">
                  <input type="radio" name="classState" value="준비중"> 준비중 - 클래스 개설 준비 상태<br>
                  <span style="color: #999999">클래스 등록은 되지만 일반회원들에게 노출되지 않습니다.</span>
               </span>
               <span>
                  <input type="radio" name="classState" value="오픈" checked="checked"> 오픈 - 클래스 바로 개설<br>
                  <span style="color: #999999">일반회원들에게 노출이 되어 클래스 신청이 가능합니다.</span>
               </span>
            </td>
         </tr>
      </table>
      <div style="margin-top: 20px; margin-bottom: 50px; text-align: right;">
         <input type="button" value="취소하기" class="btn3" style="background-color: #747474" onclick="cancelClass()">
         <input type="button" id="btnAdd" value="등록하기" class="btn3" style="background-color: #FF6C6C" onclick="addClass()"/>
      </div>
   </div>
   </form>
   <div id="footer">
      <c:import url="../footer/footer.jsp"/>
   </div>
</div>

</body>
</html>