package kr.co.sist;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping(value="/admin/template.do",method=GET)
	public String mainPage() {
		
		return "admin/template";
	}
	
	@RequestMapping(value="/admin/lecture.do",method=GET)
	public String lecturePage() {
		
		return "admin/template.do?page=lecture";
	}
	
	@RequestMapping(value="/admin/member.do",method=GET)
	public String memberPage() {
		
		return "admin/template.do?page=member";
	}

	@RequestMapping(value="/admin/teacherAuthority.do",method=GET)
	public String teacherAuthorityPage() {
		
		return "admin/template.do?page=teacherAuthority";
	}
	
	@RequestMapping(value="/admin/blacklist.do",method=GET)
	public String blacklistPage() {
		
		return "admin/template.do?page=blacklist";
	}
	
	@RequestMapping(value="/admin/category.do",method=GET)
	public String categoryPage() {
		
		return "admin/template.do?page=category";
	}
	
	@RequestMapping(value="/admin/title.do",method=GET)
	public String titlePage() {
		
		return "admin/template.do?page=title";
	}
	
	
	
}
