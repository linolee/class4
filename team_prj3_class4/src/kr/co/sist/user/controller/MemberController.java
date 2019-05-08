
package kr.co.sist.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.user.domain.ClientPageInfo;
import kr.co.sist.user.service.UserJoinService;
import kr.co.sist.user.service.UserLoginService;
import kr.co.sist.user.service.UserPageService;
import kr.co.sist.user.service.UserReportService;
import kr.co.sist.user.vo.GuestReportVO;
import kr.co.sist.user.vo.MemberJoinVO;
import kr.co.sist.user.vo.UserLoginVO;
import kr.co.sist.user.vo.memberReportVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {

	private UserLoginService uls;
	private UserPageService ups;
	private UserJoinService ujs;
	private UserReportService urs;

	public MemberController() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext.xml");

		this.uls = ac.getBean("UserLoginService", UserLoginService.class);
		this.ups = ac.getBean("UserPageService", UserPageService.class);
		this.ujs = ac.getBean("UserJoinService", UserJoinService.class);
		this.urs = ac.getBean("UserReportService", UserReportService.class);
	}

	@RequestMapping(value = "user/main.do", method = GET)
	public String mainPage() {

		return "main";
	}// mainPage

	@RequestMapping(value = "user/member/loginPage.do", method = GET)
	public String loginPage() {

		return "user/member/login";
	}// loginPage

	@RequestMapping(value = "user/member/findID.do", method = GET)
	public String findIDPage() {

		return "user/member/findID";
	}// findIDPage

	@RequestMapping(value = "user/member/findPass.do", method = GET)
	public String findPassPage() {

		return "user/member/findPass";
	}// findPassPage

	@RequestMapping(value = "user/member/joinAgreement.do", method = GET)
	public String joinAgreementPage() {

		return "user/member/joinAgreement";
	}// joinAgreementPage
	
	@RequestMapping(value = "user/member/join.do", method = POST)
	public String joinPage(HttpServletRequest request, Model model) {
		model.addAttribute("categoryMapping", ujs.CategoryMapping());
		String[] emailDomainList = {"naver.com","google.com","daum.net", "hanmail.com", "hotmail.com", "sist.com"};
		model.addAttribute("emailDomainList", emailDomainList);
		return "user/member/join";
	}// joinPage

	@ResponseBody
	@RequestMapping(value = "user/member/checkId.do", method = POST)
	public String checkId(HttpServletRequest request) {
		JSONObject json = new JSONObject();
		if (ujs.checkId(request.getParameter("client_id"))) {//�Է��� ���̵� �̹� �����Ѵٸ�
			json.put("checkId", true);
		}else {
			json.put("checkId", false);
		}
		return json.toJSONString();
	}
	
	@ResponseBody
	@RequestMapping(value = "user/member/checkTel.do", method = POST)
	public String checkTel(HttpServletRequest request) {
		JSONObject json = new JSONObject();
		if (ujs.checkTel(request.getParameter("tel"))) {//�Է��� ���̵� �̹� �����Ѵٸ�
			json.put("checkTel", true);
		}else {
			json.put("checkTel", false);
		}
		return json.toJSONString();
	}
	
	@ResponseBody
	@RequestMapping(value = "user/member/checkEmail.do", method = POST)
	public String checkEmail(HttpServletRequest request) {
		JSONObject json = new JSONObject();
		if (ujs.checkEmail(request.getParameter("email"))) {//�Է��� ���̵� �̹� �����Ѵٸ�
			json.put("checkEmail", true);
		}else {
			json.put("checkEmail", false);
		}
		return json.toJSONString();
	}
	@ResponseBody
	@RequestMapping(value = "user/member/guestReportSubmit.do", method = POST)
	public String guestReportSubmint(HttpServletRequest request) {
		JSONObject json = new JSONObject();
		if (urs.guestReportSubmit(new GuestReportVO(request.getParameter("guest_email"),
				request.getParameter("q_subject"), request.getParameter("q_contents")))) {//�Է��� �����ߴٸ�
			json.put("resultFlag", true);
		}else {
			json.put("resultFlag", false);
		}
		return json.toJSONString();
	}
	@ResponseBody
	@RequestMapping(value = "user/member/memberReportSubmit.do", method = POST)
	public String memberReportSubmint(HttpServletRequest request, HttpSession session) {
		JSONObject json = new JSONObject();
		if (urs.memberReportSubmit(new memberReportVO(session.getAttribute("client_id").toString(),
				request.getParameter("q_subject"), request.getParameter("q_contents")))) {//�Է��� �����ߴٸ�
			json.put("resultFlag", true);
		}else {
			json.put("resultFlag", false);
		}
		return json.toJSONString();
	}
	
	@RequestMapping(value = "user/member/memberJoin.do", method = POST)
	public String join(HttpServletRequest request, Model model) {
		//�Ѱ��� parameter ������ VO�� ����
		MemberJoinVO mjvo = new MemberJoinVO(request.getParameter("client_id"), request.getParameter("pass"), request.getParameter("name"),
				request.getParameterValues("birth")[0]+request.getParameterValues("birth")[1]+request.getParameterValues("birth")[2],
				request.getParameter("gender"), request.getParameterValues("email")[0]+"@"+request.getParameterValues("email")[0],
				"N", request.getParameterValues("tel")[0]+"-"+request.getParameterValues("tel")[1]+"-"+request.getParameterValues("tel")[2]);
		ujs.memberJoin(mjvo, request.getParameterValues("favors"));
		return "main";
	}// joinPage

	@RequestMapping(value = "user/member/userPage.do", method = GET)
	public String userPage(HttpServletRequest request ,HttpServletResponse response, HttpSession session, Model model) {
		if (session.getAttribute("client_id") != null) {
			String client_id = session.getAttribute("client_id").toString();
			ClientPageInfo clientInfo = ups.clientInfo(client_id);
			model.addAttribute("clientInfo", clientInfo);
			List<String> clientFavor = ups.clientFavor(client_id);
			model.addAttribute("client_favor", clientFavor);
			return "user/member/userPage";
		}else {
			return "user/member/login";
		}
	}// userPage

	@RequestMapping(value = "user/member/report.do", method = GET)
	public String reportPage() {

		return "user/member/report";
	}// reportPage

	@RequestMapping(value = "user/member/guest_report.do", method = GET)
	public String guestReportPage() {

		return "user/member/guest_report";
	}// reportPage

	@RequestMapping(value = "user/terms.do", method = GET)
	public String termsPage() {

		return "user/terms/terms";
	}// termsPage

	@RequestMapping(value = "user/member/login.do", method = POST)
	public void login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// �Է¹��� id�� pass�� vo�� ����
		UserLoginVO ulvo = new UserLoginVO(request.getParameter("id"), request.getParameter("pass"));

		// ������ vo�� login method�� ����
		int loginResult = uls.login(ulvo, session);
		String loginPath = "";
		switch (loginResult) {
		case UserLoginService.login_success:
			loginPath = "/team_prj3_class4/user/main.do";
			break;
		case UserLoginService.login_blacklist:
			loginPath = "/team_prj3_class4/user/member/loginPage.do?result=black";
			break;
		case UserLoginService.login_deletedUser:
			loginPath = "/team_prj3_class4/user/member/loginPage.do?result=deleted";
			break;
		case UserLoginService.login_fail:
			loginPath = "/team_prj3_class4/user/member/loginPage.do?result=fail";
			break;

		}
		
		System.out.println(uls.login(ulvo, session));
		System.out.println(session.getAttribute("name"));
		//�ٽ� ���� �������� ���ƿ�
		try {
			response.sendRedirect(loginPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// login
	
	@RequestMapping(value = "user/member/testSession.do", method = GET)
	public void testSession(HttpSession session, HttpServletResponse response) {
		System.out.println(session.getAttribute("name"));
		System.out.println(session.getAttribute("client_id"));
		try {
			response.sendRedirect("/team_prj3_class4/user/main.do");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// testSession
	
	@RequestMapping(value = "user/member/logout.do", method = GET)
	public String logout(HttpServletRequest request, HttpSession session) {
		session.invalidate();//������ �����
		//�ٽ� ���� �������� ���ƿ�
		String referer = request.getHeader("Referer");
		return "redirect:"+referer;
	}// logout
	
	@RequestMapping(value = "user/teacher/teacherPage.do", method = GET)
	public void teacherPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		try {
			response.sendRedirect("/team_prj3_class4/user/teacher/classStatus.do");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// teacherPage
	
	@RequestMapping(value = "user/search.do", method = GET)
	public String searchResult() {
		return "user/member/searchResult";
	}
	

}