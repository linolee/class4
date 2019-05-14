package kr.co.sist.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.service.TitleService;

@Controller
public class TitleController {
	
	@Autowired
	private TitleService ts;
	
	@RequestMapping(value="/admin/title.do",method=GET)
	public String titlePage(Model model, HttpSession session) {
		
		String loginChk=(String)session.getAttribute("loginFlag");
		if("true"!=loginChk) {
			return "redirect:/admin/AdminLogin.do";
		}
		
		model.addAttribute("page", "title/title");
		return "admin/template";
	}
	
	@RequestMapping(value="admin/titleUpload.do", method=POST)
	public String titleUpload(HttpServletRequest request) {
		String url="admin/template";
		
		try {
			if(ts.titleImgUpload(request)) {
				url="redirect:/admin/title.do"; // 파라미터 없앨때는 redirect 사용
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return url;
	}
	
}
