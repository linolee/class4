package kr.co.sist;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.domain.QnaQuestionList;
import kr.co.sist.admin.service.QnaService;
import kr.co.sist.admin.vo.ListVO;


@Controller
public class AdminController {

	@RequestMapping(value="/admin/template.do",method=GET)
	public String mainPage() {
		return "admin/template";
	}
	
	@RequestMapping(value="/admin/question.do",method=GET)
	public String questionPage( ListVO lvo, Model model ) {
		List<QnaQuestionList> list = null;
		
		//autowired로 의존성 주입//
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext2.xml");
		QnaService qs = ac.getBean(QnaService.class);
		
		int totalCount = qs.totalCount();//총 게시물의 수
		int pageScale = qs.pageScale();
		int totalPage = qs.totalPage(totalCount);//전체 게시물을 보여주기 위한 총 페이지 수 
		if(lvo.getCurrentPage() == 0) { //web parameter에 값이 없을 때
			lvo.setCurrentPage(1);
		}
		int startNum = qs.startNum(lvo.getCurrentPage());
		int endNum = qs.endNum(startNum);
		
		lvo.setStartNum(startNum);
		lvo.setEndNum(endNum);
		
		list = qs.selectQnAQuestionList(lvo);//리스트 목록 조회
		String indexList = qs.indexList(lvo.getCurrentPage(), totalPage, "question.do");
		model.addAttribute("list", list);//@@
		model.addAttribute("indexList", indexList);
		model.addAttribute("pageScale", pageScale);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", lvo.getCurrentPage());
		
		model.addAttribute("page", "question");//@@
		return "admin/template";
	}
	
	
	@RequestMapping(value="/admin/charge.do",method=GET)
	public String chargePage() {
		
		return "admin/template.do?page=chage";
	}
	@RequestMapping(value="/admin/lecturePermit.do",method=GET)
	public String lecturePermitPage() {
		
		return "admin/template.do?page=lecture";
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
