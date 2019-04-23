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

#listContents{ height: 400px; padding-top: 6px;}
#listTab{ border-top: 1px solid #333; border-spacing: 0px;}

#addProfile{ position: absolute; top: 220px; left: 500px; }
#addProfileFrm{ border: 1px solid #333333; background-color: #FFFFFF; padding: 10px;}
#updateProfile{ position: absolute; top: 220px; left: 500px; }
#updateProfileFrm{ border: 1px solid #333333; background-color: #FFFFFF; padding: 10px;}
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

</head>
<body>
<div id="wrap">

	<div id="container">
		<div id="mypageTitle">마이페이지</div>
		<div id="headerTitle2">회원님의 소중한 정보들을 관리하실 수 있습니다.</div>
		<div style="padding-top: 30px; padding-bottom: 20px;">
			<c:import url="/resources/jsp/main_menu.jsp"/>
		</div>
		<div id="title3">강사 프로필 관리</div>
		<div id="title4">강사님께서 등록한 프로필을 관리합니다.</div>
		<br/>
		<div id="listContents">
			<table id="listTab" border="1">
				<tr style="height: 45px; background-color: #F3F3F3">
					<th width="200">프로필명</th>
					<th width="200">교육분야</th>
					<th width="600">소갯말</th>
					<th width="150">비고</th>
				</tr>
				<tr style="text-align: center; height: 35px;">
					<td>-</td>
					<td>-</td>
					<td>-</td>
					<td><a href="#void" onclick="viewImport('updateProfile')">자세히 보기</a></td>
				</tr>
			</table><br>
			<input type="button" value="프로필 추가" class="btn" style="float: right;" onclick="viewImport('addProfile')"><br>
			
			<div id="addProfile">
				<c:import url="add_profile.jsp"/>
			</div>
			<div id="updateProfile">
				<c:import url="update_profile.jsp"/>
			</div>
		</div>
	</div>
</div>

</body>
</html>