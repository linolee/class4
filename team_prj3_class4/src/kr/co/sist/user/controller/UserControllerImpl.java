package kr.co.sist.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.user.service.UserLoginService;
import kr.co.sist.user.vo.UserLoginVO;

/**
 * Handles requests for the application home page.
 */
public class UserControllerImpl implements kr.co.sist.user.controller.UserController{
	private UserLoginService uls;
	public UserControllerImpl(UserLoginService uls) {
		this.uls = uls;
	}
	
	public String mainPage() {
		
		return "main";
	}//mainPage
	
	public String loginPage() {
		
		return "user/member/login";
	}//loginPage
	public String findIDPage() {
		
		return "user/member/findID";
	}//findIDPage
	public String findPassPage() {
		
		return "user/member/findPass";
	}//findPassPage
	
	public String joinPage() {
		
		return "user/member/join";
	}//joinPage

	public String userPage() {
		
		return "user/member/userPage";
	}//userPage
	
	public String reportPage() {
		
		return "user/member/report";
	}//reportPage
	
	public String guestReportPage() {
		
		return "user/member/guest_report";
	}//reportPage

	public String termsPage() {
		
		return "user/terms/terms";
	}//termsPage
	
	public String login(HttpServletRequest request, HttpServletResponse response) {
		//입력받은 id와 pass로 vo를 생성
		UserLoginVO ulvo = new UserLoginVO(request.getParameter("id"), request.getParameter("pass"));
		System.out.println(ulvo);
	
		//생성된 vo로 login method를 실행
		System.out.println(uls.login(ulvo));
		return "main";
	}//loginPage
}
