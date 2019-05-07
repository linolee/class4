package kr.co.sist.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TitleController {
	
	@RequestMapping(value="/admin/title.do",method=GET)
	public String titlePage(Model model) {
		
		
		model.addAttribute("page", "title/title");
		return "admin/template";
	}
	
}
