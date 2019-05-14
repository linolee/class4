package kr.co.sist.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.admin.service.MailService;

@Controller
public class MailController {
	
	@Autowired
	private MailService ms;

	@RequestMapping(value="/admin/mail.do", method= {GET,POST})
	public String mailPage(Model model, HttpSession session) {
		
		String loginChk=(String)session.getAttribute("loginFlag");
		if("true"!=loginChk) {
			return "redirect:/admin/AdminLogin.do";
		}
		
		model.addAttribute("page", "mail/mail");
		return "admin/template";
	}
	
	@ResponseBody
	@RequestMapping(value="/admin/findEaddress.do", method=GET)
	public String findEaddress(String id) {
		JSONObject json=null;
		json=ms.findEaddress(id);
		return json.toJSONString();
	}
	
	@RequestMapping(value="/admin/sendEmail.do", method=POST)
	public String sendEmail(HttpServletRequest request, String email, String title, String content) {
		
		ms.sendEmail(request, email, title, content);
		
		return "redirect:/admin/mail.do";
	}
}
