package kr.co.sist.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.admin.service.AdminLoginService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.json.simple.JSONObject;

@Controller
public class MailController {
	
	@Autowired
	private AdminLoginService als;

	@RequestMapping(value="/admin/mail.do", method=GET)
	public String mailPage(Model model) {
		
		model.addAttribute("page", "mail/mail");
		return "admin/template";
	}
	
	@ResponseBody
	@RequestMapping(value="/admin/findEaddress.do", method=GET)
	public String findEaddress(String id) {
		JSONObject json=null;
		json=als.findEaddress(id);
		return json.toJSONString();
	}
}
