package kr.co.sist;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.sist.user.controller.UserController;
import kr.co.sist.user.vo.UserLoginVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	UserController uc;
	public MainController() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext.xml");
		uc = ac.getBean("UserController", UserController.class);
	}
	
	@RequestMapping(value="user/main.do",method=GET)
	public String mainPage() {
		return uc.mainPage();
	}//mainPage
	
	@RequestMapping(value="user/member/loginPage.do",method=GET)
	public String loginPage() {
		return uc.loginPage();
	}//loginPage
	@RequestMapping(value="user/member/findID.do",method=GET)
	public String findIDPage() {
		return uc.findIDPage();
	}//findIDPage
	@RequestMapping(value="user/member/findPass.do",method=GET)
	public String findPassPage() {
		return uc.findPassPage();
	}//findPassPage
	
	@RequestMapping(value="user/member/join.do",method=GET)
	public String joinPage() {
		return uc.joinPage();
	}//joinPage

	@RequestMapping(value="user/member/userPage.do",method=GET)
	public String userPage() {
		return uc.userPage();
	}//userPage
	
	@RequestMapping(value="user/member/report.do",method=GET)
	public String reportPage() {
		return uc.reportPage();
	}//reportPage
	
	@RequestMapping(value="user/member/guest_report.do",method=GET)
	public String guestReportPage() {
		return uc.guestReportPage();
	}//reportPage

	@RequestMapping(value="user/terms.do",method=GET)
	public String termsPage() {
		return uc.termsPage();
	}//termsPage
	
	@RequestMapping(value="user/member/login.do",method=POST)
	public String login(HttpServletRequest request, HttpSession session) {
		return uc.login(request, session);
	}//loginPage
}
