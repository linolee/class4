package kr.co.sist.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface UserController {
	public String mainPage();
	public String loginPage();
	public String findIDPage();
	public String findPassPage();
	public String joinPage();
	public String userPage();
	public String reportPage();
	public String guestReportPage();
	public String termsPage();
	public String login(HttpServletRequest request, HttpSession session);
}
