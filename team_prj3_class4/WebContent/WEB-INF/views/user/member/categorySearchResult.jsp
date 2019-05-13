<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>당신을 위한 수업★Class4★</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- css -->
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/header.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/footer.css" />"
	rel="stylesheet">
<!-- google font -->
<link href="https://fonts.googleapis.com/css?family=PT+Sans"
	rel="stylesheet">
<!-- Bootstrap core CSS -->
<link
	href="<c:url value="/resources/startbootstrap-modern-business-gh-pages/vendor/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link
	href="<c:url value="/resources/startbootstrap-modern-business-gh-pages/css/modern-business.css" />"
	rel="stylesheet">
<!-- CSS -->
<!-- Bootstrap core CSS -->
<link
	href="<c:url value="/resources/startbootstrap-modern-business-gh-pages/vendor/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link
	href="<c:url value="/resources/startbootstrap-modern-business-gh-pages/css/modern-business.css" />"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

</head>
<style type="text/css">
body {
	padding-top: 0px;
}
</style>
<script type="text/javascript">
	$(function() {
		$("[name=keyword]").val("${keyword}");
	});
</script>

<body>
	<div id="wrapper">
		<div id="header">
			<c:import url="../header/header.jsp"></c:import>
		</div>

		<!-- Page Content -->
		<div class="container">

			<!-- Page Heading/Breadcrumbs -->
			<h3 class="mt-4 mb-3">
				"${keyword}" 카테고리 검색결과
			</h3>
			<div class="container my-5">
				<div class="card text-center">
					<div class="card-header">
						<c:if test="${empty list }">
							검색 결과가 없습니다.
						</c:if>
			<div class="row">
			<c:forEach var="listItem" items="${list }">
				<div class="col-lg-4 col-sm-6 portfolio-item">
					<div class="card h-100">
						<a href="/team_prj3_class4/user/classDetail/detail.do?lcode=${listItem.lcode }">
						<img class="card-img-top" style="width: 350px; height: 220px;"
							src="<c:url value="/upload/lessonMain/${listItem.main_img }"/>" onerror="this.src='<c:url value="/upload/lessonMain/noImage.png"/>'"></a>
						<div class="card-body">
							<h4 class="card-title">
								<a href="/team_prj3_class4/user/classDetail/detail.do?lcode=${listItem.lcode }">${listItem.lname }</a>
							</h4>
							<p class="card-text">
								${listItem.teacher_name}<br>
							</p>
							<p class="card-text">
								${listItem.category}>${listItem.inner_category}<br>
							</p>
							<p class="card-text">
								${listItem.start_date}~${listItem.end_date}
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
			</div>
						<c:forEach var="category" items="${categoryList }">
						<input type="button" class="btn btn-secondary my-1" value="${category }">
						</c:forEach>
					</div>
				</div>
			</div>
			<%-- <h3 class="mt-4 mb-3">
				"${keyword}" 클래스명 검색결과
			</h3>
			<c:if test="${empty list }">
			<div class="container my-5">
				<div class="card text-center">
					<div class="card-header">
						검색 결과가 없습니다.
					</div>
				</div>
			</div>
			</c:if> --%>

			<div style="text-align: center">
			<div style="display: inline-block;">
				<ul class="pagination ">
					<c:out value="${ indexList }" escapeXml="false" />
					<!-- escapeXml은 c:out으로 태그를 출력하게 만든다 -->
				</ul>
			</div>
		</div>

		</div>
		<!-- /.container -->

		<div id="footer">
			<c:import url="../footer/footer.jsp" />
		</div>
	</div>
</body>
</html>

