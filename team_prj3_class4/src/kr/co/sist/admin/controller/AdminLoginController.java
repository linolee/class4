package kr.co.sist.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import kr.co.sist.admin.service.AdminLoginService;
import kr.co.sist.admin.vo.AdminLoginVO;

@Controller
public class AdminLoginController {
	
	@Autowired
	private AdminLoginService als;
	
	
	@RequestMapping(value="/admin/AdminLogin.do", method=GET)
	public String loginPage(Model model) {
		return "admin/AdminLogin";
	}
	
	@RequestMapping(value="/admin/AdminLoginProcess.do", method=POST)
	public String adminLogin(@RequestParam("loginId")String loginId, @RequestParam("loginPass")String loginPass) {
		String url="/admin/AdminLogin";
		
		AdminLoginVO alvo=new AdminLoginVO(loginId, loginPass);
		if(als.adminLogin(alvo)) {
			url="/admin/template";
		}
		
		return url;
	}
}