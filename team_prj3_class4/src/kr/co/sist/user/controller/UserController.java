
package kr.co.sist.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.sist.user.service.UserLoginService;
import kr.co.sist.user.service.UserPageService;
import kr.co.sist.user.vo.UserLoginVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {

	private UserLoginService uls;
	private UserPageService ups;

	public UserController() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext.xml");

		this.uls = ac.getBean("UserLoginService", UserLoginService.class);
		this.ups = ac.getBean("UserPageService", UserPageService.class);
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
	
	@RequestMapping(value = "user/member/join.do", method = GET)
	public String joinPage(HttpServletRequest request) {
		return "user/member/join";
	}// joinPage

	@RequestMapping(value = "user/member/userPage.do", method = GET)
	public String userPage(HttpSession session) {
		if (session.getAttribute("client_id") != null) {
			System.out.println(ups.clientInfo(session.getAttribute("client_id").toString()));
			
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
		// 입력받은 id와 pass로 vo를 생성
		UserLoginVO ulvo = new UserLoginVO(request.getParameter("id"), request.getParameter("pass"));
		System.out.println(ulvo);

		// 생성된 vo로 login method를 실행
		System.out.println(uls.login(ulvo, session));
		System.out.println(session.getAttribute("name"));
		//다시 원래 페이지로 돌아옴
		try {
			response.sendRedirect("/team_prj3_class4/user/main.do");
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
		session.invalidate();//세션을 지우고
		//다시 원래 페이지로 돌아옴
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

}