<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--  -->
                <div class="card">
                  <div class="card-header">
                    <i class="fa fa-align-justify"></i> 강의 조회</div>
                  <div class="card-body">
               		 
               		 <div class='searchbox'>
    <form name="membersearchf" class="form-inline" action="<?php echo $link_url;?>">
        <input type="hidden" name="orderby" value="<?php echo $xorderby;?>" />
        <select name="where" class="form-control input-sm">
            <option value="userNM">이름</option>
            <option value="userID">아이디</option>
        </select>
        <div class="input-group input-group-sm">
            <input type="text" name="keyword" value="" class="form-control input-search" placeholder="검색어">
            <span class="input-group-btn">
                <button type="submit" class="btn btn-info" title="검색"><i class="glyphicon glyphicon-search"></i></button>
            </span>
        </div>
    </form>
</div>

               		 
                    <table class="table table-responsive-sm">
                      <thead>
                        <tr>
                          <th width="100px">강의코드</th>
                          <th width="100px">카테고리</th>
                          <th width="500px" align="center">강의명</th>
                          <th width="200px">강사명</th>
                          <th width="100px">진행상황</th>
                          <th width="100px">비고</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>A0001</td>
                          <td>기타</td>
                          <td>스윙스와 함께하는 돈까스 맛있게 먹는법</td>
                           <td>스윙스</td>
                          <td>
                            <span class="badge badge-success">진행중</span>
                          </td>
                           <td>
                           <form method="get" action="./member.jsp" class="form-inline">
                          <a data-toggle="modal" href="#reportModal"><span class="badge badge-primary">상세정보</span></a> 
                          </form>
                          </td> 
                        </tr>
                        <tr>
                          <td>BC0001</td>
                          <td>어학</td>
                          <td>키미노 나마에와..?</td>
                           <td>나카지마 쇼고</td>
                          <td>
                            <span class="badge badge-secondary">종료</span>
                          </td>
                           <td>
                           <form method="get" action="./member.jsp" class="form-inline">
                          <a data-toggle="modal" href="#reportModal"><span class="badge badge-primary">상세정보</span></a> 
                          </form>
                          </td> 
                        </tr>
                        <tr>
                          <td>A0002</td>
                          <td>스포츠</td>
                          <td>그것이 알고싶다!! 호날두 vs 메시</td>
                           <td>축잘알</td>
                          <td>
                            <span class="badge badge-warning">승인대기</span>
                          </td>
                           <td>
                           <form method="get" action="./member.jsp" class="form-inline">
                          <a data-toggle="modal" href="#reportModal"><span class="badge badge-primary">상세정보</span></a> 
                          </form>
                          </td> 
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
            

<!--  -->
