<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% response.setContentType("text/html"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HI</title>
<style type="text/css">
#file, #file2, #file3 { display:none; } 	
.titleImg, .categoryImg{width:900px; height:300px; width:100%; height:100%;}
.upCategoryImg{width:900px;height:300px}
.upCategoryImg2{width:600px;height:200px}
</style>

<link href="<c:url value="/resources/admin/css/style.css" />" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="<c:url value="/resources/admin/js/bootstrap.min.js" />"></script>
	
<!-- 구글 태그 매니져  -->	
<!-- Global site tag (gtag.js) - Google Analytics-->
<!-- <script async="" src="https://www.googletagmanager.com/gtag/js?id=UA-118965717-3"></script> -->	

	
	
	
	
	
<script type="text/javascript">

$(function(){
	$("#logout").click(function() {
		if(confirm("로그아웃 하시겠습니까?")){
			location.href="AdminLogin.do";
		};
	});
 	$(document).on('click', 'a[href="#"]', function(e){
		e.preventDefault();
	});
	$(document).on('click', 'a[href="#void"]', function(e){
		e.preventDefault();
	});
	
});

</script>
    
</head>
	
  <body class="app header-fixed sidebar-fixed aside-menu-fixed sidebar-lg-show">
<div class="sidebar">

        <nav class="sidebar-nav">
          <ul class="nav">
            <li class="nav-title">고객센터</li>
            <li class="nav-item">
              <!-- <a class="nav-link" href="template.do?page=question"> -->
              <a class="nav-link" href="question.do"> 
                <i class="nav-icon icon-drop"></i> 문의관리</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="charge.do">
                <i class="nav-icon icon-pencil"></i> 신고관리</a>
            </li>
            <li class="nav-title">강의관리</li>
            <li class="nav-item nav-dropdown">
              <a class="nav-link nav-dropdown-toggle" href="lecturePermit.do">
                <i class="nav-icon icon-puzzle"></i> 강의 개설 승인</a>

            </li>
            <li class="nav-item nav-dropdown">
              <a class="nav-link nav-dropdown-toggle" href="lecture.do">
                <i class="nav-icon icon-cursor"></i> 강의 조회</a>
            </li>
           
            <li class="nav-title">회원관리</li>
            <li class="nav-item nav-dropdown">
              <a class="nav-link nav-dropdown-toggle" href="member.do" >
                <i class="nav-icon icon-star" ></i> 회원 조회</a>
              <a class="nav-link nav-dropdown-toggle" href="teacher.do">
                <i class="nav-icon icon-star"></i> 강사 조회 </a>
              <a class="nav-link nav-dropdown-toggle" href="teacherAuthority.do">
                <i class="nav-icon icon-star"></i> 강사 권한 승인 </a>
              <a class="nav-link nav-dropdown-toggle" href="blacklist.do">
                <i class="nav-icon icon-star"></i> 블랙리스트</a>
                
            <li class="nav-title">기타</li>
            <li class="nav-item nav-dropdown">
              <a class="nav-link nav-dropdown-toggle" href="category.do">
                <i class="nav-icon icon-star"></i> 카테고리</a>
              <a class="nav-link nav-dropdown-toggle" href="title.do">
                <i class="nav-icon icon-star"></i> 타이틀</a>
          </ul>
        </nav>
      </div>
  </body>

<div id="container" class="main">
  
      <ol class="breadcrumb">
          <li class="breadcrumb-item">
		        <a href="template.do">SIST Class4 Group1</a>
		        <span>:: 2019 Web Project</span>
          </li>
          <li class="breadcrumb-menu d-md-down-none">
            <div class="btn-group" role="group" aria-label="Button group">
                <input type="button" id="logout" value="Logout" class="btn" />
            </div>
          </li>
        </ol>
	
	<div class="container-fluid">
	
	<c:if test="${ not empty page }">
		<c:import url="${ page }.jsp"/>
	</c:if>
	<c:if test="${ empty page }">
		
		
              <div class="animated fadeIn">
            <div class="row">
              <div class="col-sm-6 col-lg-3">
                <div class="card text-white bg-primary">
                  <div class="card-body pb-0">
                    <div class="btn-group float-right">
                      <button class="btn btn-transparent dropdown-toggle p-0" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="icon-settings"></i>
                      </button>
                      <div class="dropdown-menu dropdown-menu-right">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <a class="dropdown-item" href="#">Something else here</a>
                      </div>
                    </div>
                    <div class="text-value">352명</div>
                    <div>총 회원 수</div>
                  </div>
                  <div class="chart-wrapper mt-3 mx-3" style="height:70px;">
                    <canvas class="chart" id="card-chart1" height="70"></canvas>
                  </div>
                </div>
              </div>
              <!-- /.col-->
              <div class="col-sm-6 col-lg-3">
                <div class="card text-white bg-info">
                  <div class="card-body pb-0">
                    <button class="btn btn-transparent p-0 float-right" type="button">
                      <i class="icon-location-pin"></i>
                    </button>
                    <div class="text-value">2명</div>
                    <div>오늘 가입자 수</div>
                  </div>
                  <div class="chart-wrapper mt-3 mx-3" style="height:70px;">
                    <canvas class="chart" id="card-chart2" height="70"></canvas>
                  </div>
                </div>
              </div>
              <!-- /.col-->
              <div class="col-sm-6 col-lg-3">
                <div class="card text-white bg-warning">
                  <div class="card-body pb-0">
                    <div class="btn-group float-right">
                      <button class="btn btn-transparent dropdown-toggle p-0" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="icon-settings"></i>
                      </button>
                      <div class="dropdown-menu dropdown-menu-right">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <a class="dropdown-item" href="#">Something else here</a>
                      </div>
                    </div>
                    <div class="text-value">222</div>
                    <div>진행중인 강좌 수</div>
                  </div>
                  <div class="chart-wrapper mt-3" style="height:70px;">
                    <canvas class="chart" id="card-chart3" height="70"></canvas>
                  </div>
                </div>
              </div>
              <!-- /.col-->
              <div class="col-sm-6 col-lg-3">
                <div class="card text-white bg-danger">
                  <div class="card-body pb-0">
                    <div class="btn-group float-right">
                      <button class="btn btn-transparent dropdown-toggle p-0" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="icon-settings"></i>
                      </button>
                      <div class="dropdown-menu dropdown-menu-right">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <a class="dropdown-item" href="#">Something else here</a>
                      </div>
                    </div>
                    <div class="text-value">100</div>
                    <div>총 강사 수</div>
                  </div>
                  <div class="chart-wrapper mt-3 mx-3" style="height:70px;">
                    <canvas class="chart" id="card-chart4" height="70"></canvas>
                  </div>
                </div>
              </div>
              <!-- /.col-->
            </div>
            <!-- /.row-->
            <div class="card">
              <div class="card-body">
                <div class="row">
                  <div class="col-sm-5">
                    <h4 class="card-title mb-0">Traffic</h4>
                    <div class="small text-muted">November 2017</div>
                  </div>
                  <!-- /.col-->
                  <div class="col-sm-7 d-none d-md-block">
                    <button class="btn btn-primary float-right" type="button">
                      <i class="icon-cloud-download"></i>
                    </button>
                    <div class="btn-group btn-group-toggle float-right mr-3" data-toggle="buttons">
                      <label class="btn btn-outline-secondary">
                        <input id="option1" type="radio" name="options" autocomplete="off"> Day
                      </label>
                      <label class="btn btn-outline-secondary active">
                        <input id="option2" type="radio" name="options" autocomplete="off" checked=""> Month
                      </label>
                      <label class="btn btn-outline-secondary">
                        <input id="option3" type="radio" name="options" autocomplete="off"> Year
                      </label>
                    </div>
                  </div>
                  <!-- /.col-->
                </div>
                <!-- /.row-->
                <div class="chart-wrapper" style="height:300px;margin-top:40px;">
                  <canvas class="chart" id="main-chart" height="300"></canvas>
                </div>
              </div>
              <div class="card-footer">
                <div class="row text-center">
                  <div class="col-sm-12 col-md mb-sm-2 mb-0">
                    <div class="text-muted">Visits</div>
                    <strong>29.703 Users (40%)</strong>
                    <div class="progress progress-xs mt-2">
                      <div class="progress-bar bg-success" role="progressbar" style="width: 40%" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                  </div>
                  <div class="col-sm-12 col-md mb-sm-2 mb-0">
                    <div class="text-muted">Unique</div>
                    <strong>24.093 Users (20%)</strong>
                    <div class="progress progress-xs mt-2">
                      <div class="progress-bar bg-info" role="progressbar" style="width: 20%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                  </div>
                  <div class="col-sm-12 col-md mb-sm-2 mb-0">
                    <div class="text-muted">Pageviews</div>
                    <strong>78.706 Views (60%)</strong>
                    <div class="progress progress-xs mt-2">
                      <div class="progress-bar bg-warning" role="progressbar" style="width: 60%" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                  </div>
                  <div class="col-sm-12 col-md mb-sm-2 mb-0">
                    <div class="text-muted">New Users</div>
                    <strong>22.123 Users (80%)</strong>
                    <div class="progress progress-xs mt-2">
                      <div class="progress-bar bg-danger" role="progressbar" style="width: 80%" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                  </div>
                  <div class="col-sm-12 col-md mb-sm-2 mb-0">
                    <div class="text-muted">Bounce Rate</div>
                    <strong>40.15%</strong>
                    <div class="progress progress-xs mt-2">
                      <div class="progress-bar" role="progressbar" style="width: 40%" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!-- /.card-->
            <div class="row">
              <div class="col-sm-6 col-lg-3">
                <div class="brand-card">
                  <div class="brand-card-header bg-facebook">
                    <i class="fa fa-facebook"></i>
                    <div class="chart-wrapper">
                      <canvas id="social-box-chart-1" height="90"></canvas>
                    </div>
                  </div>
                  <div class="brand-card-body">
                    <div>
                      <div class="text-value">89k</div>
                      <div class="text-uppercase text-muted small">friends</div>
                    </div>
                    <div>
                      <div class="text-value">459</div>
                      <div class="text-uppercase text-muted small">feeds</div>
                    </div>
                  </div>
                </div>
              </div>
              <!-- /.col-->
              <div class="col-sm-6 col-lg-3">
                <div class="brand-card">
                  <div class="brand-card-header bg-twitter">
                    <i class="fa fa-twitter"></i>
                    <div class="chart-wrapper">
                      <canvas id="social-box-chart-2" height="90"></canvas>
                    </div>
                  </div>
                  <div class="brand-card-body">
                    <div>
                      <div class="text-value">973k</div>
                      <div class="text-uppercase text-muted small">followers</div>
                    </div>
                    <div>
                      <div class="text-value">1.792</div>
                      <div class="text-uppercase text-muted small">tweets</div>
                    </div>
                  </div>
                </div>
              </div>
              <!-- /.col-->
              <div class="col-sm-6 col-lg-3">
                <div class="brand-card">
                  <div class="brand-card-header bg-linkedin">
                    <i class="fa fa-linkedin"></i>
                    <div class="chart-wrapper">
                      <canvas id="social-box-chart-3" height="90"></canvas>
                    </div>
                  </div>
                  <div class="brand-card-body">
                    <div>
                      <div class="text-value">500+</div>
                      <div class="text-uppercase text-muted small">contacts</div>
                    </div>
                    <div>
                      <div class="text-value">292</div>
                      <div class="text-uppercase text-muted small">feeds</div>
                    </div>
                  </div>
                </div>
              </div>
              <!-- /.col-->
              <div class="col-sm-6 col-lg-3">
                <div class="brand-card">
                  <div class="brand-card-header bg-google-plus">
                    <i class="fa fa-google-plus"></i>
                    <div class="chart-wrapper">
                      <canvas id="social-box-chart-4" height="90"></canvas>
                    </div>
                  </div>
                  <div class="brand-card-body">
                    <div>
                      <div class="text-value">894</div>
                      <div class="text-uppercase text-muted small">followers</div>
                    </div>
                    <div>
                      <div class="text-value">92</div>
                      <div class="text-uppercase text-muted small">circles</div>
                    </div>
                  </div>
                </div>
              </div>
              <!-- /.col-->
            </div>
            <!-- /.row-->
            <div class="row">
              <div class="col-md-12">
                <div class="card">
                  <div class="card-header">Traffic & Sales</div>
                  <div class="card-body">
                    <div class="row">
                      <div class="col-sm-6">
                        <div class="row">
                          <div class="col-sm-6">
                            <div class="callout callout-info">
                              <small class="text-muted">New Clients</small>
                              <br>
                              <strong class="h4">9,123</strong>
                              <div class="chart-wrapper">
                                <canvas id="sparkline-chart-1" width="100" height="30"></canvas>
                              </div>
                            </div>
                          </div>
                          <!-- /.col-->
                          <div class="col-sm-6">
                            <div class="callout callout-danger">
                              <small class="text-muted">Recuring Clients</small>
                              <br>
                              <strong class="h4">22,643</strong>
                              <div class="chart-wrapper">
                                <canvas id="sparkline-chart-2" width="100" height="30"></canvas>
                              </div>
                            </div>
                          </div>
                          <!-- /.col-->
                        </div>
                        <!-- /.row-->
                        <hr class="mt-0">
                        <div class="progress-group mb-4">
                          <div class="progress-group-prepend">
                            <span class="progress-group-text">Monday</span>
                          </div>
                          <div class="progress-group-bars">
                            <div class="progress progress-xs">
                              <div class="progress-bar bg-info" role="progressbar" style="width: 34%" aria-valuenow="34" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                            <div class="progress progress-xs">
                              <div class="progress-bar bg-danger" role="progressbar" style="width: 78%" aria-valuenow="78" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                          </div>
                        </div>
                        <div class="progress-group mb-4">
                          <div class="progress-group-prepend">
                            <span class="progress-group-text">Tuesday</span>
                          </div>
                          <div class="progress-group-bars">
                            <div class="progress progress-xs">
                              <div class="progress-bar bg-info" role="progressbar" style="width: 56%" aria-valuenow="56" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                            <div class="progress progress-xs">
                              <div class="progress-bar bg-danger" role="progressbar" style="width: 94%" aria-valuenow="94" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                          </div>
                        </div>
                        <div class="progress-group mb-4">
                          <div class="progress-group-prepend">
                            <span class="progress-group-text">Wednesday</span>
                          </div>
                          <div class="progress-group-bars">
                            <div class="progress progress-xs">
                              <div class="progress-bar bg-info" role="progressbar" style="width: 12%" aria-valuenow="12" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                            <div class="progress progress-xs">
                              <div class="progress-bar bg-danger" role="progressbar" style="width: 67%" aria-valuenow="67" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                          </div>
                        </div>
                        <div class="progress-group mb-4">
                          <div class="progress-group-prepend">
                            <span class="progress-group-text">Thursday</span>
                          </div>
                          <div class="progress-group-bars">
                            <div class="progress progress-xs">
                              <div class="progress-bar bg-info" role="progressbar" style="width: 43%" aria-valuenow="43" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                            <div class="progress progress-xs">
                              <div class="progress-bar bg-danger" role="progressbar" style="width: 91%" aria-valuenow="91" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                          </div>
                        </div>
                        <div class="progress-group mb-4">
                          <div class="progress-group-prepend">
                            <span class="progress-group-text">Friday</span>
                          </div>
                          <div class="progress-group-bars">
                            <div class="progress progress-xs">
                              <div class="progress-bar bg-info" role="progressbar" style="width: 22%" aria-valuenow="22" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                            <div class="progress progress-xs">
                              <div class="progress-bar bg-danger" role="progressbar" style="width: 73%" aria-valuenow="73" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                          </div>
                        </div>
                        <div class="progress-group mb-4">
                          <div class="progress-group-prepend">
                            <span class="progress-group-text">Saturday</span>
                          </div>
                          <div class="progress-group-bars">
                            <div class="progress progress-xs">
                              <div class="progress-bar bg-info" role="progressbar" style="width: 53%" aria-valuenow="53" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                            <div class="progress progress-xs">
                              <div class="progress-bar bg-danger" role="progressbar" style="width: 82%" aria-valuenow="82" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                          </div>
                        </div>
                        <div class="progress-group mb-4">
                          <div class="progress-group-prepend">
                            <span class="progress-group-text">Sunday</span>
                          </div>
                          <div class="progress-group-bars">
                            <div class="progress progress-xs">
                              <div class="progress-bar bg-info" role="progressbar" style="width: 9%" aria-valuenow="9" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                            <div class="progress progress-xs">
                              <div class="progress-bar bg-danger" role="progressbar" style="width: 69%" aria-valuenow="69" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <!-- /.col-->
                      <div class="col-sm-6">
                        <div class="row">
                          <div class="col-sm-6">
                            <div class="callout callout-warning">
                              <small class="text-muted">Pageviews</small>
                              <br>
                              <strong class="h4">78,623</strong>
                              <div class="chart-wrapper">
                                <canvas id="sparkline-chart-3" width="100" height="30"></canvas>
                              </div>
                            </div>
                          </div>
                          <!-- /.col-->
                          <div class="col-sm-6">
                            <div class="callout callout-success">
                              <small class="text-muted">Organic</small>
                              <br>
                              <strong class="h4">49,123</strong>
                              <div class="chart-wrapper">
                                <canvas id="sparkline-chart-4" width="100" height="30"></canvas>
                              </div>
                            </div>
                          </div>
                          <!-- /.col-->
                        </div>
                        <!-- /.row-->
                        <hr class="mt-0">
                        <div class="progress-group">
                          <div class="progress-group-header">
                            <i class="icon-user progress-group-icon"></i>
                            <div>Male</div>
                            <div class="ml-auto font-weight-bold">43%</div>
                          </div>
                          <div class="progress-group-bars">
                            <div class="progress progress-xs">
                              <div class="progress-bar bg-warning" role="progressbar" style="width: 43%" aria-valuenow="43" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                          </div>
                        </div>
                        <div class="progress-group mb-5">
                          <div class="progress-group-header">
                            <i class="icon-user-female progress-group-icon"></i>
                            <div>Female</div>
                            <div class="ml-auto font-weight-bold">37%</div>
                          </div>
                          <div class="progress-group-bars">
                            <div class="progress progress-xs">
                              <div class="progress-bar bg-warning" role="progressbar" style="width: 43%" aria-valuenow="43" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                          </div>
                        </div>
                        <div class="progress-group">
                          <div class="progress-group-header align-items-end">
                            <i class="icon-globe progress-group-icon"></i>
                            <div>Organic Search</div>
                            <div class="ml-auto font-weight-bold mr-2">191.235</div>
                            <div class="text-muted small">(56%)</div>
                          </div>
                          <div class="progress-group-bars">
                            <div class="progress progress-xs">
                              <div class="progress-bar bg-success" role="progressbar" style="width: 56%" aria-valuenow="56" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                          </div>
                        </div>
                        <div class="progress-group">
                          <div class="progress-group-header align-items-end">
                            <i class="icon-social-facebook progress-group-icon"></i>
                            <div>Facebook</div>
                            <div class="ml-auto font-weight-bold mr-2">51.223</div>
                            <div class="text-muted small">(15%)</div>
                          </div>
                          <div class="progress-group-bars">
                            <div class="progress progress-xs">
                              <div class="progress-bar bg-success" role="progressbar" style="width: 15%" aria-valuenow="15" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                          </div>
                        </div>
                        <div class="progress-group">
                          <div class="progress-group-header align-items-end">
                            <i class="icon-social-twitter progress-group-icon"></i>
                            <div>Twitter</div>
                            <div class="ml-auto font-weight-bold mr-2">37.564</div>
                            <div class="text-muted small">(11%)</div>
                          </div>
                          <div class="progress-group-bars">
                            <div class="progress progress-xs">
                              <div class="progress-bar bg-success" role="progressbar" style="width: 11%" aria-valuenow="11" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                          </div>
                        </div>
                        <div class="progress-group">
                          <div class="progress-group-header align-items-end">
                            <i class="icon-social-linkedin progress-group-icon"></i>
                            <div>LinkedIn</div>
                            <div class="ml-auto font-weight-bold mr-2">27.319</div>
                            <div class="text-muted small">(8%)</div>
                          </div>
                          <div class="progress-group-bars">
                            <div class="progress progress-xs">
                              <div class="progress-bar bg-success" role="progressbar" style="width: 8%" aria-valuenow="8" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <!-- /.col-->
                    </div>
                    <!-- /.row-->
                    <br>
                  </div>
                </div>
              </div>
              <!-- /.col-->
            </div>
            <!-- /.row-->
          </div>
		
		
		
		
		
		
		
		
		
		
		
	</c:if>
	
	
		<br/><br/>
	</div>
	<!-- 메인 -->
	
	
</div>
	

</body>
</html>	