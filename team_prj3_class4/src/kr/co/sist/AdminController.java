package kr.co.sist;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.domain.MemberListDomain;
import kr.co.sist.admin.domain.QnaQuestionList;
import kr.co.sist.admin.service.MemberListService;
import kr.co.sist.admin.service.QnaService;


@Controller
public class AdminController {

	@RequestMapping(value="/admin/template.do",method=GET)
	public String mainPage(Model model) {
		
		return "admin/template";
	}
	
	@RequestMapping(value="/admin/question.do",method=GET)
	public String questionPage( Model model ) {
		List<QnaQuestionList> list = null;
		
		//autowired로 의존성 주입//
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext2.xml");
		QnaService qs = ac.getBean(QnaService.class);
		list = qs.selectQnAQuestionList();
		
		model.addAttribute("page", "question");
		model.addAttribute("list", list);
		return "admin/template";
	}
	
	@RequestMapping(value="/admin/charge.do",method=GET)
	public String chargePage(Model model) {
		
		
		model.addAttribute("page", "charge");
		return "admin/template";
	}
	@RequestMapping(value="/admin/lecturePermit.do",method=GET)
	public String lecturePermitPage(Model model) {
		
		
		model.addAttribute("page", "lecturePermit");
		return "admin/template";
	}
	@RequestMapping(value="/admin/lecture.do",method=GET)
	public String lecturePage(Model model) {
		
		
		model.addAttribute("page", "lecture");
		return "admin/template";
	}
	
	

	@RequestMapping(value="/admin/teacherAuthority.do",method=GET)
	public String teacherAuthorityPage(Model model) {
		
		
		model.addAttribute("page", "teacherAuthority");
		return "admin/template";
	}
	
	@RequestMapping(value="/admin/blacklist.do",method=GET)
	public String blacklistPage(Model model) {
		
		
		model.addAttribute("page", "blacklist");
		return "admin/template";
	}
	
	@RequestMapping(value="/admin/category.do",method=GET)
	public String categoryPage(Model model) {
		
		
		model.addAttribute("page", "category");
		return "admin/template";
	}
	
	@RequestMapping(value="/admin/title.do",method=GET)
	public String titlePage(Model model) {
		
		
		model.addAttribute("page", "title");
		return "admin/template";
	}
	
	
	
}
