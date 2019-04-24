
package kr.co.sist.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.user.service.UserLoginService;
import kr.co.sist.user.vo.UserLoginVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {

	private UserLoginService uls;

	public UserController() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext.xml");

		this.uls = ac.getBean("UserLoginService", UserLoginService.class);
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

	@RequestMapping(value = "user/member/join.do", method = GET)
	public String joinPage() {

		return "user/member/join";
	}// joinPage

	@RequestMapping(value = "user/member/userPage.do", method = GET)
	public String userPage() {

		return "user/member/userPage";
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
	public String login(HttpServletRequest request, HttpSession session) {
		// 입력받은 id와 pass로 vo를 생성
		UserLoginVO ulvo = new UserLoginVO(request.getParameter("id"), request.getParameter("pass"));
		System.out.println(ulvo);

		// 생성된 vo로 login method를 실행
		System.out.println(uls.login(ulvo, session));
		System.out.println(session.getAttribute("name"));
		session.invalidate();
		return "main";
	}// loginPage

}