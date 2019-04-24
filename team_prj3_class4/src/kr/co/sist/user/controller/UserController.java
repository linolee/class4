package kr.co.sist.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
	
	@RequestMapping(value="user/main.do",method=GET)
	public String mainPage() {
		
		return "main";
	}//mainPage
	
	@RequestMapping(value="user/member/loginPage.do",method=GET)
	public String loginPage() {
		
		return "user/member/login";
	}//loginPage
	@RequestMapping(value="user/member/findID.do",method=GET)
	public String findIDPage() {
		
		return "user/member/findID";
	}//findIDPage
	@RequestMapping(value="user/member/findPass.do",method=GET)
	public String findPassPage() {
		
		return "user/member/findPass";
	}//findPassPage
	
	@RequestMapping(value="user/member/join.do",method=GET)
	public String joinPage() {
		
		return "user/member/join";
	}//joinPage

	@RequestMapping(value="user/member/userPage.do",method=GET)
	public String userPage() {
		
		return "user/member/userPage";
	}//userPage
	
	@RequestMapping(value="user/member/report.do",method=GET)
	public String reportPage() {
		
		return "user/member/report";
	}//reportPage
	
	@RequestMapping(value="user/member/guest_report.do",method=GET)
	public String guestReportPage() {
		
		return "user/member/guest_report";
	}//reportPage

	@RequestMapping(value="user/terms.do",method=GET)
	public String termsPage() {
		
		return "user/terms/terms";
	}//termsPage
	
	@RequestMapping(value="user/mainContents/mainContents.do",method=GET)
	public String mainContentPage() {
		
		return "user/mainContents/mainContents";
	}//termsPage
	
}
