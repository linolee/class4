package kr.co.sist.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeacherPermitController {

	@RequestMapping(value="/admin/teacherAuthority.do",method=GET)
	public String teacherAuthorityPage(Model model) {
		
		
		model.addAttribute("page", "teacherAuthority");
		return "admin/template";
	}
}
