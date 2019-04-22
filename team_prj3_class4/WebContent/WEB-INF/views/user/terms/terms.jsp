<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Class4-서비스 약관 및 정책</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- css -->
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/header.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/footer.css" />" rel="stylesheet">
<!-- google font -->
<link href="https://fonts.googleapis.com/css?family=PT+Sans"
	rel="stylesheet">
<style type="text/css">
#wrapper {
	font-family: 'PT Sans', sans-serif;
}
</style>

<!-- summerNote -->
<!-- include libraries(jQuery, bootstrap) -->
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

<!-- tab -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- include summernote css/js -->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.js"></script>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<c:import url="../header/header.jsp"></c:import>
		</div>
		<div id="container">
			<div class="areaFix">
	<div>
		<h2>서비스 약관 및 정책</h2>
	</div>
	<div id="tabs">
		<ul>
			<li><a href="#fragment-1"><span>이용약관</span></a></li>
			<li><a href="#fragment-2"><span>개인정보 보호 정책</span></a></li>
			<li><a href="#fragment-3"><span>책임의 한계와 법적고지</span></a></li>
		</ul>
		<div id="fragment-1">
			<p>
				<span style="font-size: 18pt; color: rgb(0, 0, 0);">제1장 총칙</span>
			</p>
			<p>
				<span style="color: rgb(0, 0, 0);"><br></span>
			</p>
			<p>
				<span style="font-size: 14pt; color: rgb(0, 0, 0);">제1조(목적)</span>
			</p>
			<p>
				운영하는 인터넷 관련 서비스(강좌 중개 서비스, 기타 정보 서비스, 이하 &ldquo;서비스&rdquo;)를 이용함에 있어
				&ldquo;회사&rdquo;와 이용자 및 회원의 권리?의무 및 책임사항을 규정하고 있습니다. 이를 통해 회사와 이용자는
				상호간에 알아야 할 사항을 숙지하고 원활한 소통 및 신뢰의 증진을 목적으로 합니다.
			</p>
			<p>※「PC통신, 무선, 스마트폰 모바일 웹, 앱 등을 이용하는 전자상거래에 대해서도 그 성질에 반하지 않는 한 이
				약관을 준용합니다.」</p>
			<p>
				<br>
			</p>
			<p>
				<span style="font-size: 14pt; color: rgb(0, 0, 0);">제2조(용어
					정의)</span>
			</p>
			<p>이 약관에서 사용하는 용어의 정의는 다음과 같습니다.</p>
			<p>1. &ldquo;회사&rdquo;란 클래스볼이 재화 또는 용역을 이용자에게 제공하기 위하여 컴퓨터 등
				정보통신설비를 이용하여 재화 등을 거래할 수 있도록 설정한 가상의 영업장을 말하며, 아울러 회사를 운영하는 사업자의
				의미로도 사용합니다.</p>
			<p>2. &ldquo;회원&rdquo;이란 &ldquo;회사&rdquo;의 사이트에 개인정보를 제공하여 회원등록을
				한 자로서 &ldquo;회사&rdquo;에서 제공하는 서비스를 받는 자로서 일반회원, 마스터회원(강사회원), 비회원 등을
				말합니다.</p>
			<p>3. &ldquo;이용자&rdquo;란 클래스볼 사이트에 접속하여 약관에 따라 &ldquo;서비스&rdquo;를
				받는 회원 및 비회원을 말합니다.</p>
		</div>
		<div id="fragment-2">
			<p>주식회사 클래스볼(이하 &lsquo;회사&rsquo;)은 회원의 개인정보를 보호하기 위해 최선을 다하고
				있습니다. 이를 위해서 개인정보의 보호와 관련하여 &lsquo;정보통신망 이용촉진 및 정보보호 등에 관한
				법률&rsquo;, &lsquo;개인정보 보호법&rsquo; 등 개인정보와 관련된 법령을 준수하고 있습니다. 회사는
				개인정보취급방침을 통하여 회원이 제공하는 개인정보가 어떠한 용도와 방식으로 이용되고 있으며, 개인정보보호를 위해 어떠한
				조치가 취해지고 있는지 알려드립니다.&nbsp;</p>
			<p>회사는 개인정보취급방침을 개정하는 경우 웹사이트 공지사항(또는 개별공지)을 통하여 공지할 것입니다.&nbsp;</p>
			<p>&nbsp;</p>
			<p>
				<br>
			</p>
			<p>
				<span style="font-size: 14pt; color: rgb(0, 0, 0);">제1조 수집하는
					개인정보 항목</span>
			</p>
			<p>회사는 회원가입, 상담, 서비스 신청 등등을 위해 아래와 같은 개인정보를 수집하고 있습니다.&nbsp;</p>
			<p>- 수집항목 : 이름, 생년월일, 로그인ID, 비밀번호, 비밀번호 질문과 답변, 자택 전화번호, 자택 주소,
				사무실 전화번호, 사무실 주소, 휴대전화번호, 이메일, 쿠키, 결제기록, 사업자등록번호, 계좌번호, 그 외 선택항목 등을
				수집합니다. 또한 회사의 서비스를 이용하는 과정에서 관심분야, 방문일시, 사용이력, 기기정보, 접속로그, IP주소 등이
				자동으로 수집될 수 있습니다. &nbsp;</p>
			<p>
				<br>
			</p>
			<p>
				<span style="font-size: 14pt; color: rgb(0, 0, 0);">제2조 개인정보
					수집에 대한 동의</span>
			</p>
			<p>회사는 이용자가 회원가입 시 개인정보보호정책과 이용약관에 대해 각각 &lsquo;동의&rsquo; 버튼을 클릭한
				경우 개인정보수집에 대해 동의 여부를 표시한 것으로 판단합니다.</p>
			<p>단 고객이 자신의 정확한 정보를 입력하지 않고 타인의 정보를 도용하거나 불법적인 정보를 입력한 경우 회사는
				고객을 관련법령에 따라 신고조치할 수 있으며 강제탈퇴를 시킬 수도 있습니다.&nbsp;</p>
			<p>
				<br>
			</p>
			<p>
				<span style="font-size: 14pt; color: rgb(0, 0, 0);">제3조 개인정보의
					수집 방법</span>
			</p>
			<p>회사는 홈페이지, 어플리케이션, 이메일, 고객센터, 게시판, 이벤트 참여, 제휴사로부터의 전달 등을 통해
				개인정보를 수집합니다.</p>
			<p>
				<br>
			</p>
			<p>
				<span style="font-size: 14pt; color: rgb(0, 0, 0);">제4조 개인정보
					이용목적</span>
			</p>
			<p>수집한 개인정보는 다음의 목적을 위해 활용합니다.</p>
			<p>- 본인확인, 개인식별, 불량회원의 부정이용 방지, 비인가 사용방지, 가입의사 확인, 연령 확인, 불만처리,
				중복가입여부, 계약의 체결, 이행 관리, 결제(환불)계좌, 신분증 사본(강사에게만 해당) 구매성향 분석, 접속빈도 분석,
				서비스 이용 통계분석, 공지사항 전달, 서비스 개선, 민원 관리, 청구서 발송, 이벤트 및 맞춤형 서비스 제공, 마케팅
				활동, 회사의 제휴서비스 및 상품 안내서비스, 금융거래 본인인증 및 회원관리, 초대권 발송 등의 목적으로 개인정보를
				이용합니다. &nbsp; &nbsp;</p>
			<p>&nbsp;</p>
			<p>- 회사는 회원들에게 더 나은 맞춤형 서비스를 제공하기 위해 개인정보를 활용합니다.&nbsp;</p>
			<p>- 회사는 원활하고 정확한 서비스를 제공하기 위해 SNS 업체에게 회원의 개인정보를 제공할 수 있습니다. 이
				또한 회원이 허락하는 범위 안에서만 제공됩니다. 서비스 이용을 위해 회원으로부터 권한요청이 필요할 경우 해당 SNS 업체의
				인증서비스를 통해 사전 동의를 구하고 진행할 것입니다.&nbsp;</p>
			<p>- 기타 회원이 제공한 모든 정보에 대해서 사용목적, 용도 등이 변경될 시 반드시 회원에게 사전동의를 구하고
				사용할 것입니다.&nbsp;</p>
			<p>
				<br>
			</p>
			<p>위의 모든 정보는 가입할 때의 정보 뿐만 아니라 개인정보수정으로 인한 변경된 정보 내역도 포함됩니다.&nbsp;</p>
			<p>
				<br>
			</p>
			<p>
				<span style="font-size: 14pt; color: rgb(0, 0, 0);">제5조 개인정보의
					보유 및 이용기간</span>
			</p>
			<p>
				<br>
			</p>
			<p>원칙적으로, 개인정보 수집 및 이용목적이 달성된 후에는 해당 정보를 지체 없이 파기합니다. 그러나 회사의
				회원으로서 회사에서 제공하는 서비스를 이용하는 동안에는 회원의 개인정보를 계속적으로 보유합니다. 개인정보는 로그인 후
				홈페이지 상에서 열람 및 수정이 가능하며, 탈퇴요청을 한 경우라도 분쟁 대비, 저작물의 관리 및 보호, 대금정산 등으로
				인한 거래내역의 보존 및 증빙 등을 위해 일정기간 보유할 수 있습니다. 이때 보유되는 개인정보는 그 보관의 목적으로만
				이용합니다.</p>
			<p>그리고 관계법령의 규정에 의하여 보존할 필요가 있는 경우 회사는 아래와 같이 관계법령에서 정한 일정한 기간 동안
				회원정보를 보관합니다.</p>
			<p>
				<br>
			</p>
			<p>1) 보존 항목 : 이름, 로그인ID, 비밀번호, 휴대전화번호, 회사명, 부서, 회사 전화번호, 자택전화번호,
				자택주소, 결제기록 등</p>
			<p>&nbsp; &nbsp;- 보존 근거 : 전자상거래등에서의 소비자보호에 관한 법률</p>
			<p>&nbsp; &nbsp;- 보존 기간 : 5년</p>
			<p>2) 보존 항목 : 쿠키, 세션</p>
			<p>&nbsp; &nbsp;- 보존 근거 : 회사의 서비스이용약관 및 개인정보취급방침에 동의&nbsp;</p>
			<p>&nbsp; &nbsp;- 보존 기간 : 로그아웃 시 삭제&nbsp;</p>
			<p>&nbsp;</p>
			<p>관계법령의 규정에 의하여 보존할 필요가 있는 경우 회사는 아래와 같이 관계법령에서 정한 일정한 기간 동안
				회원정보를 보관합니다.&nbsp;</p>
			<p>
				<br>
			</p>
			<p>3) 보존 항목 : 이름, E-MAIL, 휴대전화번호, 비밀번호, 이용정보, 정산정보&nbsp;</p>
			<p>&nbsp; &nbsp;- 보존 근거 : 회사의 서비스이용약관 및 개인정보보호정책에 동의&nbsp;</p>
			<p>&nbsp; &nbsp;- 보존 기간 : 회원 자격을 유지할 때가지&nbsp;</p>
			<p>4) 계약 또는 청약철회 등에 관한 기록</p>
			<p>&nbsp; &nbsp;-(전자상거래등에서의 소비자보호에 관한 법률&nbsp;</p>
			<p>&nbsp; &nbsp;- 보존 기간 : &nbsp;5년&nbsp;</p>
			<p>5) 대금결제 및 재화 등의 공급에 관한 기록</p>
			<p>&nbsp; &nbsp;- 보존 근거: 전자상거래등에서의 소비자보호에 관한 법률</p>
			<p>&nbsp; &nbsp;- 보존 기간 : 5년&nbsp;</p>
			<p>6) 소비자의 불만 또는 분쟁처리에 관한 기록</p>
			<p>&nbsp; &nbsp;- 보존 근거 : 전자상거래등에서의 소비자보호에 관한 법률 &nbsp;&nbsp;</p>
			<p>&nbsp; &nbsp;- 보존 기간 : &nbsp;3년</p>
			<p>7) 웹사이트 방문 기록</p>
			<p>&nbsp; &nbsp;- 보존 근거 : 통신비밀보호법</p>
			<p>&nbsp; &nbsp;- 보존 기간 : 3개월</p>
			<p>&nbsp;&nbsp;</p>
			<p>
				<span style="font-size: 14pt; color: rgb(0, 0, 0);">제6조 개인정보의
					파기절차 및 방법</span>
			</p>
			<p>
				<br>
			</p>
			<p>회사는 원칙적으로 개인정보 수집 및 이용목적이 달성된 후에는 해당 정보를 지체없이 파기합니다. 파기절차 및
				방법은 다음과 같습니다.</p>
			<p>
				<br>
			</p>
			<p>1) 파기절차</p>
			<p>
				<br>
			</p>
			<p>회원이 회원가입 등을 위해 입력하신 정보는 목적이 달성된 후 별도의 DB로 옮겨져(종이의 경우 별도의 서류함)
				내부 방침 및 기타 관련 법령에 의한 정보보호 사유에 따라(보유 및 이용기간 참조) 일정 기간 저장된 후 파기되어집니다.
				별도 DB로 옮겨진 개인정보는 법률에 의한 경우가 아니고서는 보유되어지는 이외의 다른 목적으로 이용되지
				않습니다.&nbsp;</p>
			<p>
				<br>
			</p>
			<p>2) 파기방법</p>
			<p>&nbsp; &nbsp;- 종이에 출력된 개인정보는 분쇄기로 분쇄하거나 소각을 통해 파기합니다.&nbsp;</p>
			<p>&nbsp; &nbsp;- 전자적 파일형태로 저장된 개인정보는 기록을 재생할 수 없는 기술적 방법을 사용하여
				삭제합니다.&nbsp;</p>
			<p>
				<br>
			</p>
			<p>
				<span style="font-size: 14pt; color: rgb(0, 0, 0);">제7조 개인정보의
					3자 제공 및 공유</span>
			</p>
			<p>
				<br>
			</p>
			<p>회사는 회원의 개인정보를 개인정보보호정책 4조에 고지한 범위 내에서 사용하며 회원의 동의 없이는 원칙적으로
				외부에 제공하지 않습니다. 다만, 아래의 경우에는 예외로 합니다.</p>
			<p>
				<br>
			</p>
			<p>- 회원이 사전에 공개 또는 제3자 제공에 동의한 경우 제공합니다.</p>
			<p>- 법령의 규정에 의거하거나, 수사 목적으로 법령에 정해진 절차와 방법에 따라 수사기관의 요구가 있는 경우
				제공합니다.&nbsp;</p>
			<p>- 회사가 제공하는 서비스를 통해 신청, 주문, 결제가 이루어진 경우 거래 당사자들 사이의 원활한 의사소통과
				거래이행을 위해 관련된 개인정보를 필요한 범위 내에서 거래 당사자(클래스 개설자)에게 제공합니다. &nbsp;</p>
		</div>
		<div id="fragment-3">
			<p>
				<span style="font-size: 18pt; color: rgb(0, 0, 0);">제1장 총칙</span>
			</p>
			<p>
				<span style="color: rgb(0, 0, 0);"><br></span>
			</p>
			<p>
				<span style="font-size: 14pt; color: rgb(0, 0, 0);">제1조(목적)</span>
			</p>
			<p>
				이 약관은 ㈜클래스볼(웹사이트 <u>www.classbowl.com</u> 이하 &ldquo;회사&rdquo;)이 제공 및
				운영하는 인터넷 관련 서비스(강좌 중개 서비스, 기타 정보 서비스, 이하 &ldquo;서비스&rdquo;)를 이용함에 있어
				&ldquo;회사&rdquo;와 이용자 및 회원의 권리?의무 및 책임사항을 규정하고 있습니다. 이를 통해 회사와 이용자는
				상호간에 알아야 할 사항을 숙지하고 원활한 소통 및 신뢰의 증진을 목적으로 합니다.
			</p>
			<p>※「PC통신, 무선, 스마트폰 모바일 웹, 앱 등을 이용하는 전자상거래에 대해서도 그 성질에 반하지 않는 한 이
				약관을 준용합니다.」</p>
			<p>
				<br>
			</p>
			<p>
				<span style="font-size: 14pt; color: rgb(0, 0, 0);">제2조(용어
					정의)</span>
			</p>
			<p>이 약관에서 사용하는 용어의 정의는 다음과 같습니다.</p>
			<p>1. &ldquo;회사&rdquo;란 클래스볼이 재화 또는 용역을 이용자에게 제공하기 위하여 컴퓨터 등
				정보통신설비를 이용하여 재화 등을 거래할 수 있도록 설정한 가상의 영업장을 말하며, 아울러 회사를 운영하는 사업자의
				의미로도 사용합니다.</p>
			<p>2. &ldquo;회원&rdquo;이란 &ldquo;회사&rdquo;의 사이트에 개인정보를 제공하여 회원등록을
				한 자로서 &ldquo;회사&rdquo;에서 제공하는 서비스를 받는 자로서 일반회원, 마스터회원(강사회원), 비회원 등을
				말합니다.</p>
			<p>3. &ldquo;이용자&rdquo;란 클래스볼 사이트에 접속하여 약관에 따라 &ldquo;서비스&rdquo;를
				받는 회원 및 비회원을 말합니다.</p>

		</div>
	</div>
</div>

	<script>
		$("#tabs").tabs();
	</script>
		</div>
		<div id="footer">
			<c:import url="../footer/footer.jsp" />
		</div>


	</div>

</body>
</html>
