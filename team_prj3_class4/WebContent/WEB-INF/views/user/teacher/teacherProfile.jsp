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
	$(function(){
		$("#addProfile").hide();
		$("#updateProfile").hide();
		$("[name='btnClose']").click(function() {
			$("#addProfile").hide();
			$("#updateProfile").hide();
		});
	
	});//ready
	function viewImport( url ) {
		if(url == "addProfile"){
			$("#addProfile").show();
		}
		if(url == "updateProfile"){
			$("#updateProfile").show();
		}
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
		<div id="listContents">
			<table id="listTab" border="1">
				<colgroup>
					<col width="10%" />
					<col width="20%" />
					<col width="50%" />
					<col width="20%" />
				</colgroup>
				<thead>
					<tr style="margin: auto;">
						<th class="class-th">프로필명</th>
						<th class="class-th">교육분야</th>
						<th class="class-th">소갯말</th>
						<th  class="class-th">비고</th>
					</tr>
					<tr class="class-list">
						<td>-</td>
						<td>-</td>
						<td>-</td>
						<td>
							<input type="button" class="btn btn-warning" value="자세히 보기" onclick="viewImport('updateProfile')">
						</td>
					</tr>
				</thead>
				<tbody>
					<tr class="class-list">
						<td colspan="5"  align="center">클래스가 존재하지 않습니다.<br/></td>
					</tr>
				</tbody>				
			</table><br>
			<div class="addBtn">
				<input type="button" value="프로필 추가" class="btn btn-warning" onclick="viewImport('addProfile')"><br>
			</div>
			
			<div id="addProfile">
				<c:import url="add_profile.jsp"/>
			</div>
			<div id="updateProfile">
				<c:import url="update_profile.jsp"/>
			</div>
		</div>
	</div>
	<div id="footer">
		<c:import url="../footer/footer.jsp" />
	</div>
</div>

</body>
</html>