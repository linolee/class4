<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	function addAnswer() {
		qcode = $("#qcode").val();
		acontents = $("#acontents").val();
		
		if(acontents == ""){
			alert("답변을 입력해주세요.");
			return;
		}
		
		alert("답변이 등록되었습니다.");
		//location.href="addQnaAnswer.do?qcode="+qcode+"&acontents="+acontents;
		$("#frm").submit();
	}

</script>

<!--  -->
                <div class="card">
                  <div class="card-header">
                    <i class="fa fa-align-justify"></i> 고객센터 - 문의관리</div>
                  <div class="card-body">
               		 
                    <table class="table table-responsive-sm">
                      <thead>
                        <tr style="border-bottom: 5px solid; border-top: 5px solid #444444; background-color: gray;" >
                          <th width="100px" >제목</th>
                          <th width="500px"><c:out value="${ searchData.q_subject }"/></th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>작성자</td>
                          <td><c:out value="${ searchData.client_id }"/></td>
                        </tr>
                        <tr height="250px">
                          <td>내용</td>
                          <td><c:out value="${ searchData.q_contents }"/></td>
                        </tr>
                        <tr style="border-bottom: 5px solid; border-top: 5px solid #444444; background-color: gray;">
                          	<c:choose>
								<c:when test="${ searchData.a_date eq null }">
									<td colspan="2">답변을 입력해주세요</td>
								</c:when>
								<c:otherwise>
									<td colspan="2">답변</td>
								</c:otherwise>
							</c:choose>
<!--                      <td>답변제목</td>
                          <td>안녕하세요 답변입니다</td> -->
                        </tr>
                        <tr height="250px">
                       		<c:choose>
								<c:when test="${ searchData.a_date eq null }">
									<td>내용</td>
									<td>
										<form id="frm" action="addQnaAnswer.do" method="post">
                							<input type="hidden" id="qcode" name="qcode" value="${ param.qnum }">
											<textarea id="acontents" name="acontents" class="form-control" rows="10" style="min-width: 100%;" placeholder="답변을 입력해주세요."></textarea>
               							</form>
									</td>
								</c:when>
								<c:otherwise>
									<td>내용</td>
									<td><c:out value="${ searchData.a_contents }"/></td>
								</c:otherwise>
							</c:choose>
<%--                           <td>내용</td>
                          <td><c:out value="${ searchData.a_contents }"/></td> --%>
                        </tr>
                      </tbody>
                    </table>
                    <div style="text-align: right">
                    <div style="display: inline-block;">
                    <ul class="pagination "  >
                      <li class="page-item">
                        <a class="page-link" href="#" onclick="history.back()">목록</a>
                      </li>
                      <c:if test="${ searchData.a_date eq null }">
	                      <li class="page-item">
	                        <a class="page-link" href="#" onclick="addAnswer()">등록</a>
	                      </li>
                      </c:if>
                    </ul>
                    </div>
                    </div>
                  </div>
                </div>

<!--  -->
