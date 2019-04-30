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
<script src="http://localhost:8080/team_prj3_class4/resources/summernote/bootstrap.js"></script>

<!-- include summernote css/js -->
<link href="http://localhost:8080/team_prj3_class4/resources/summernote/summernote-lite.css" rel="stylesheet">
<script src="http://localhost:8080/team_prj3_class4/resources/summernote/summernote-lite.js"></script>
<script src="http://localhost:8080/team_prj3_class4/resources/summernote/lang/summernote-ko-KR.js"></script>
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
    if(className == null || className == ''){
       alert("클래스 이름을 입력해주세요.");
       $("#className").focus();
       return false;
    }
   
    if(classSimpleInfo == null || classSimpleInfo == ''){
       alert("간단 소개를 입력해주세요.");
       $("#classSimpleInfo").focus();
       return false;
    }
    
    if(startDate == null || startDate == ''){
       alert("시작 일자를 선택해주세요.");
       $("#startDate").focus();
       return false;
    }
   
    if(endDate == null || endDate == ''){
       alert("종료 일자를 선택해주세요.");
       $("#endDate").focus();
       return false;
    }
   
    if ($("input:checkbox[name='chkWeek']:checked").length == 0) {
        alert("요일을 선택해주세요.");
        return false;
     }
   
    var sDate = new Date(startDate);   //시작일자
    var eDate = new Date(endDate);      //종료일자
    if (sDate > eDate) {
       alert("시작일자는 종료일자보다 클 수 없습니다.");
       return false;
    }
    
    if(minPerson == null || minPerson == ''){
       alert("최소인원을 입력해주세요.");
       $("#minPerson").focus();
       return false;
    }
   
    if(maxPerson == null || maxPerson == ''){
       alert("최대인원을 입력해주세요.");
       $("#maxPerson").focus();
       return false;
    }

    if(maxPerson < minPerson){
       alert("최소인원은 최대인원보다 많을 수 없습니다.");
       $("#minPerson").focus();
       return false;
    }
    
    if(finDate == null || finDate == ''){
       alert("신청마감일을 선택해주세요.");
       $("#finDate").focus();
       return false;
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
       return false;
    }
   
    if(classCurriculum == null || classCurriculum == ''){
       alert("진행 방법을 입력해주세요.");
       return false;
    }
   
    if(classTogether == null || classTogether == ''){
       alert("함께하고 싶어요 항목을 입력해주세요.");
       return false;
    }
   
    if ($("input:checkbox[name='include1']:checked").length == 0) {
       alert("포함/불포함 사항을 선택해주세요.");
       return false;
    }
    
    if(etc == null || etc == ''){
       alert("기타사항을 입력해주세요.");
       $("#etc").focus();
       return false;
    } 
    
    if(topBannerImg == null || topBannerImg == ''){
       alert("배너사진을 추가해주세요.");
       return false;
    }
   
    if(mainBannerImg == null || mainBannerImg == ''){
       alert("대표사진을 추가해주세요.");
       return false;
    }

    if(classAddr1 == null || classAddr1 == ''){
       alert("주소를 입력해주세요.");
       return false;
    }
   
    if(classAddr2 == null || classAddr2 == ''){
       alert("나머지 주소를 입력해주세요.");
       return false;
    }
   
  	var classState = $("input[name='classState']:checked").val();
    if(classState == null || classState == ''){
       alert("클래스상태를 선택해주세요.");
   }
   
} // addClass



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
         <c:import url="/resources/jsp/main_menu.jsp"/>
      </div>
      <div id="title3">클래스 등록</div>
      <div id="title4">클래스를 등록하실 수 있습니다. 해당 항목에 내용을 입력해주세요.</div>
      <br/>
      <hr color="#888888">
      <table>
         <tr>
            <td class="baseTd1">클래스 이름</td>
            <td class="baseTd2"><input type="text" id="className" class="inputLine" placeholder="예시) 내 손으로 직접 만드는 가죽 지갑 클래스"></td>
         </tr>
         <tr>
            <td class="baseTd1">클래스 간단소개</td>
            <td class="baseTd2"><input type="text" id="classSimpleInfo" class="inputLine" placeholder="예시) 카드 및 동전 수납이 가능한 리얼 가죽 카드 지갑을 만들어 보아요 ~(50자 이내)"></td>
         </tr>
         <tr>
            <td rowspan="2" class="baseTd3">클래스 날짜구성</td>
            <td>
               <input type="date" id="startDate" class="inputDate">부터
               <input type="date" id="endDate" class="inputDate">까지
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
               </select>
               <select name="startMin" class="inputTime">
                  <c:forEach var="time" begin="00" end="60" step="1">
                  <option value="${ time }"><c:out value="${ time }"/></option>
                  </c:forEach>
               </select> ~ 
               <select name="endHour" class="inputTime">
                  <c:forEach var="time" begin="01" end="24" step="1">
                  <option value="${ time }"><c:out value="${ time }"/></option>
                  </c:forEach>
               </select>
               <select name="endMin" class="inputTime">
                  <c:forEach var="time" begin="00" end="60" step="1">
                  <option value="${ time }"><c:out value="${ time }"/></option>
                  </c:forEach>
               </select>
               <input type="text" id="minPerson" class="inputPerson" placeholder="최소        명">
               <input type="text" id="maxPerson" class="inputPerson" placeholder="최대        명">
            </td>
         </tr>
         <tr>
            <td class="baseTd1">신청 마감일</td>
            <td class="baseTd2">
               <input type="date" id="finDate" class="inputDate" style="float: left; margin-right: 5px;">
               <span class="remark">신청마감일은 최소한 클래스 시작일 1일전으로 설정해주세요.<br>신청마감일 저녁 6시를 기준으로 클래스 예약신청이 마감됩니다.</span>
            </td>
         </tr>
         <tr>
            <td class="baseTd1">카테고리</td>
            <td class="baseTd2">
               <select name="mainCategory" class="category" id="mainCategory">
                  <option value="none">카테고리선택</option>
                  <option value="a">어쩌구</option>
                  <option value="b">저쩌구</option>
               </select>
               <select name="subCategory" class="category" id="subCategory">
                  <option value="none">서브카테고리</option>
                  <option value="1">어절씨구</option>
                  <option value="2">저절씨구</option>
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
               <input type="text" id="etc" class="inputLine" placeholder="기타사항을 입력해주세요">
            </td>
         </tr>
         <tr>
            <td rowspan="2" class="baseTd3">상단배너 등록</td>
            <td><input type="file" id="topBannerImg" class="inputLine"></td>
         </tr>
         <tr>
            <td class="baseTd2"><span class="remark"> * 권장사이즈 : 가로 2000픽셀, 세로 532픽셀(가로가 긴 이미지 추천)</span></td>
         </tr>
         <tr>
            <td rowspan="2" class="baseTd3">대표이미지 등록</td>
            <td><input type="file" id="mainBannerImg" class="inputLine"></td>
         </tr>
         <tr>
            <td class="baseTd2"><span class="remark"> * 권장사이즈 : 가로 250픽셀, 세로 250픽셀(정사각형 이미지 추천)</span></td>
         </tr>
         <tr>
            <td class="baseTd1">클래스 장소</td>
            <td class="baseTd2">
               <input type="text" id="classAddr1" class="inputAddr" readonly="readonly" placeholder="주소를 검색해주세요." style="background-color: #DEDEDE">
               <input type="button" value="주소검색" class="btn2">
               <input type="text" id="classAddr2" class="inputAddr" placeholder="나머지 주소를 검색해주세요.">
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
                  <input type="radio" name="classState" value="오픈"> 오픈 - 클래스 바로 개설<br>
                  <span style="color: #999999">일반회원들에게 노출이 되어 클래스 신청이 가능합니다.</span>
               </span>
            </td>
         </tr>
      </table>
      <div style="margin-top: 20px; margin-bottom: 50px; text-align: right;">
         <input type="button" value="취소하기" class="btn3" style="background-color: #747474">
         <input type="button" value="등록하기" class="btn3" style="background-color: #FF6C6C" onclick="addClass()"/>
      </div>
   </div>
   <div id="footer">
      <c:import url="../footer/footer.jsp"/>
   </div>
</div>

</body>
</html>