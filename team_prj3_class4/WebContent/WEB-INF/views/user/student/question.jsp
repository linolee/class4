<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/spring_mvc_prj/common/main_v190130.css">
<link href="<c:url value="/resources/css/header.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/footer.css" />" rel="stylesheet">
<style type="text/css">
body{font-family:Dotum, "돋움", verdana, sans-serif;font-size:12px;color:#666;background-color:#fff;min-width:960px}
body, ul, ol, li, dt, dl, dd, div, h1, h2, h3, h4, h5, h6, p, form, fieldset, blockquote, iframe, input, object, table, tr, th, td, select, textarea{margin:0;padding:0;font-family:Dotum, "돋움", verdana, sans-serif;font-size:12px;color:#666}
th{text-align: left}
.agree{border-top:1px solid #d4d4d4;text-align:center;font-size:13px;color:#777;padding:20px 0 40px 0}
.agree input{margin:0 5px -2px 0;vertical-align:middle}
.agree label{display:inline-block;vertical-align:middle}

.a_info{width:620px;margin:0 0 20px 106px}
.a_info dt{font-weight:bold;color:#777;font-size:13px;padding-bottom:7px}
.a_info dd p, .a_info dd{color:#777;font-size:13px;line-height:1.4em;width:100%;overflow:hidden}
.a_info dd span.bul_num{float:left;margin-left:-15px}
.a_info dd{padding-left:15px}
.a_info dd p{width:100%;overflow:hidden}
.a_info dd p span{float:left;margin-left:-9px}
.a_info dd p{padding-left:9px}

.a_info2{width:620px;margin:0 0 20px 106px}
.a_info2 dt{font-weight:bold;color:#777;margin-bottom:5px}

/*file_input*/
.input_filewrap {width:700px; } 
.file_text { width:489px; height:38px; background-color:#fff; border:1px solid #d6d6d6; color:#777; padding-left:15px;vertical-align:middle} /* 2017-01-18 수정 */
.file_wrap {width:100px; height:38px;  background:url(//www.afreecatv.com/images/help/btn_file.gif) 0 0 no-repeat;display:inline-block;vertical-align:middle}
.file_add {filter:alpha(opacity:0); opacity:0; width:100px; height:38px;cursor:pointer }

p.btn_write{text-align:right}
p.btn_write button{width:58px;height:21px;background:url(//www.afreecatv.com/images/help/btn_write.gif) 0 0 no-repeat;margin-top:10px}

.form_area{padding-top: 20px;}
.form_area .t1 span{background-position:0 -90px}
.form_area .t1 select{width:208px}
.form_area .t2 span{background-position:0 12px}
.form_area .t2 select{width:208px}
.form_area .t3 span{background-position:0 -138px}
.form_area .t3 .input_txt{width:193px}
.form_area .t4 span{background-position:0 -193px}
.form_area .t4 .input_txt{width:193px}
.form_area .t4 select{width:208px;margin-left:4px}
.form_area .t4 *{vertical-align:middle}
.form_area2 .t5 span, .form_area .t5 span{background-position:0 -239px}
.form_area2 .t5 .input_txt, .form_area .t5 .input_txt{width:439px}
.form_area2 .t6 span, .form_area .t6 span{background-position:0 -288px}
.form_area .t7 span{background-position:0 -28px}
.form_area .t7 td div{margin-top:10px}
.form_area .t7 td div select{width:624px;height:98px}
.form_area .t7 td .input_txt{width:607px}

.btn_area_line, .btn_area{text-align:center}
.btn_area_line button, .btn_area button{width:125px;height:40px;background:url(//www.afreecatv.com/images/help/btn_img.gif) -99999px -999999px no-repeat;cursor:pointer;margin:0 2px 0 3px}

.form_area .t7 td .fadd_info {padding:7px 0 6px; position:relative; width:610px;}
.form_area .t7 td .fadd_info .info {}
.form_area .t7 td .fadd_info .filedelete {position:absolute; right:0; top:0; }
.form_area .t7 td .fadd_info .filedelete a {width:100px; height:26px; display:block; overflow:hidden; text-indent:-1111px; background:url(//www.afreecatv.com/images/help/btn_filedelete.gif) 0 0 no-repeat; }
.form_area .t7 td .fadd2 {width:588px; height:76px; margin-bottom:10px; padding:10px; border:1px solid #d6d6d6; background:#fff;}
.form_area .t7 td .fadd2 span {display:block; padding:0 0 7px;}
.form_area .t7 td .fadd2 input {vertical-align:middle;}

.form_area .t8 span{background-position:0 -338px}
.form_area .t8 select{width:208px}

.form_area2 .t9 th span{background-position:0 -400px;margin-top:20px}
.form_area2 tr.t9 td div {    margin-top: 10px;}
.form_area2 tr.t9 td div select {    height: 40px;    width: 624px;border: 1px solid #d6d6d6;}
.form_area2 tr.t9 td .a_info{margin:0}
.form_area2 .form_textarea{word-break: break-all; display: inline; overflow: auto;  border: 1px solid #d6d6d6; BACKGROUND-COLOR: #FFFFFF; font-size:12px;width:618px; height:361px;resize:none;padding:15px}

.form_area td{padding-bottom:10px}
.form_area td select{height:36px;border:1px solid #d6d6d6;}
.form_area td span.sp{margin:0 14px}
.input_txt{border:1px solid #d6d6d6;height:28px;padding:5px 0 0 15px;background-color:#fff;line-height:2.5em}
.form_area textarea{border:1px solid #d6d6d6;padding:10px 0 0 15px;resize:none;width:695px;height:206px}

.a_info{width:620px;margin:0 0 20px 106px}
.a_info dt{font-weight:bold;color:#777;font-size:13px;padding-bottom:7px}
.a_info dd p, .a_info dd{color:#777;font-size:13px;line-height:1.4em;width:100%;overflow:hidden}
.a_info dd span.bul_num{float:left;margin-left:-15px}
.a_info dd{padding-left:15px}
.a_info dd p{width:100%;overflow:hidden}
.a_info dd p span{float:left;margin-left:-9px}
.a_info dd p{padding-left:9px}

.a_info2{width:620px;margin:0 0 20px 106px}
.a_info2 dt{font-weight:bold;color:#777;margin-bottom:5px}

.agree{border-top:1px solid #d4d4d4;text-align:center;font-size:13px;color:#777;padding:20px 0 40px 0}
.agree input{margin:0 5px -2px 0;vertical-align:middle}
.agree label{display:inline-block;vertical-align:middle}
#wrap{ margin: 0px auto; width: 1100px; height: 1000px;}
#container{ margin: 0px auto; width: 1100px; min-height: 740px;}
.questionContent{background-color: #F4F4F4; padding-left: 100px;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#writeButton").click(function(){
			
			$("#actionForm").submit();
			
		});
	});//ready
</script>
</head>
<body>
<div id="wrap">
	<div id="header">
		<c:import url="../header/header.jsp"></c:import>
	</div>
	<div id="container">
		<div id="content" class="help">
		<div class="sub_area">
			<div class="stop_area">
				<h4><img src="//res.afreecatv.com/images/help/img_ask.jpg" alt="1:1문의하기" /></h4>
			</div>
			<div class="questionContent">
			<div class="form_area">
				<form id="actionForm" name="actionForm" method="post" action="qnaProcess.do" style="margin:0px;" >
				<input type="hidden" id="customerEmail" name="customerEmail" value=""/>
				<input type="hidden" id="attach" name="attach" />
				<input type="hidden" id="attachListJSON" name="attachListJSON"/>
				<input type="hidden" id="customerId" name="customerId" value="guest"/>
				<table cellspacing="0" cellpadding="0">
					<colgroup><col width="106" /><col width="242" /><col width="59" /><col width="*" /></colgroup>
					<tr class="t1">
						<th><span>문의유형</span></th>
						<td>
							<select id="SELECT0" name="SELECT0" onchange="ChangeCategory0(this.options[this.selectedIndex].value);">
								<option value="0">-----문의유형선택-----</option>
								<option value="1">강의관련</option>
								<option value="2">취소관련</option>
								<option value="3">계정관련</option>
								<option value="4">기타관련</option>
							</select>
						</td>
					</tr>
					<tr class="t3">
						<th><span>아이디</span></th>
						<td colspan="3"><input type="text" value="${client_id }" class="input_txt" id="memberid" name="customerName" readonly /><span class="sp">로그인이 되지 않았을 경우 GUEST로 표기 됩니다.</span></td>
					</tr>
					<tr class="t5">
						<th><span>제목</span></th>
						<td colspan="3"><input type="text" class="input_txt" id="questionTitle" name="subject" /></td>
					</tr>
					<tr class="t6">
						<th ><span>내용</span></th>

						<td colspan="3"><textarea name='contents' id="questionContents" placeholder="" onfocus="javascript:setBlank();" >문의 내용을 상세히 적어 주시면 감사하겠습니다.

※ 개인정보 보호를 위해 신분증과 같은 개인정보 항목을 첨부하실 경우,
    주민등록번호 뒷자리가 노출 되지 않도록 첨부 해 주시기 바랍니다.</textarea></td>
					</tr>
					<tr class="t7">
						<th><span>첨부파일</span></th>
						<td colspan="3">
							<input type="hidden" id="enableFileExtension" name="enableFileExtension" value="jpg;jpeg;gif;doc;zip;docx;xls;pdf;png;bmp;txt" />
							<div class="input_filewrap">
								<input type="text"  id="file_route" class="file_text" readonly="readonly" title="첨부된 파일경로" />
								<em class="file_wrap">
									<input type="file" id="btnAddAttach" class="file_add" name="Attach" onChange="javascript:autoUpload(document.attachForm.Attach.value);"/>
								</em>
							</div>
							<div class="fadd_info">
							<em class="info">10M 이상 첨부파일은 jacob729@naver.com 로 첨부해서 접수 해주시기 바랍니다.</em>
							<span class="filedelete"><a href="#n" id="deleteBtn" name="deleteBtn" >파일삭제</a></span>
							</div>
							<div class="fadd">
								<select size="4" id="attachList" name="attachList" id="attachList" ></select>
							</div>
							<iframe id="mnHiddenFrame" name="mnHiddenFrame" style="display:none;" ></iframe>
						</td>
					</tr>
				</table>
				</form>
				<dl class="a_info">
					<dt>1:1 문의 유의사항</dt>
					<dd><span class="bul_num">1)</span>접수 된 내용은 최초 접수 건부터 순차적으로 답변 해 드리고 있으며, 문의량이 급증하거나 확인이
						필요한 문의의 경우 답변이 지연 될 수 있으니 양해 부탁 드립니다.
					</dd>
					<dd><span  class="bul_num">2)</span>이메일을 통한 통화시간 예약 문의 등 전화 상담 요청은 불가하오니 양해 부탁 드립니다.</dd>
					<dd><span  class="bul_num">3)</span>불량이용자 신고 안내 사항
						<p><span>-</span>증거자료가 첨부되어야 접수가 가능합니다.</p>
						<p><span>-</span>운영원칙의 위반 정도에 따라 경고부터 이용정지까지 처리 될 수 있으며, 음란물 및 운영원칙 위반
							정도가 심할 경우 경고 없이 바로 이용정지 될 수 있습니다.</p>
						<p><span>-</span>타인을 비방하거나 고의적인 허위 신고의 경우 신고자 또한 제재를 받을 수 있습니다.</p>
					</dd>
				</dl>
				<dl class="a_info2">
				<dt>안내 사항 </dt>
				<dd>- 고객상담 업무를 처리하기 위해 최소한의 개인정보만을 수집하고 있습니다.</dd>
				</dl>
				<dl class="a_info2">
				<dt>개인정보의 수집항목 및 이용목적</dt>
				<dd>- 수집 항목 : 아이디</dd>
				<dd>- 이용 목적 : 고객 불만 또는 분쟁 처리 해결을 위함</dd>
				</dl>
				<dl class="a_info2">
				<dt>개인정보의 보유 및 이용기간</dt>
				<dd>- 보관 목적 : 문의 접수 및 고객 불만 해결을 위해 일정 기간 보관 됩니다.</dd>
				<dd>- 보관 기간 : 3년</dd>
				</dl>
				<p class="a_info">※ 고객센터로 문의/신고 시 회원님께서 추가로 입력하시는 개인정보가 있을 수 있습니다.</p>

				<p class="agree"><input type="checkbox" id="ag" name="agree" /><label for="ag">위 입력정보를 이메일 상담을 위하여 수집하는 것에 동의합니다</label></p>
			</div>
			<div class="btn_area">
				<button type="button" class="btn_ok" id="writeButton" name="writeButton" ><span class="blind">확인</span></button><button type="button" class="btn_cancel" id="cancelButton" name="cancelButton" ><span class="blind">취소</span></button>
			</div>
			</div>

		</div>
	</div>
	
	</div>
	<div id="footer">
		<c:import url="../footer/footer.jsp" />
	</div>
</div>
</body>
</html>