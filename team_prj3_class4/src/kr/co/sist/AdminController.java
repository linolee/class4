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
import kr.co.sist.admin.vo.ListVO;


@Controller
public class AdminController {

	@RequestMapping(value="/admin/template.do",method=GET)
	public String mainPage(Model model) {
		
		return "admin/template";
	}
	
	@RequestMapping(value="/admin/AdminLogin.do", method=GET)
	public String loginPage(Model model) {
		return "admin/AdminLogin";
	}
	
	@RequestMapping(value="/admin/question.do",method=GET)
	public String questionPage( ListVO lvo, Model model ) {
		List<QnaQuestionList> list = null;
		
		//autowired�� ������ ����//
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext2.xml");
		QnaService qs = ac.getBean(QnaService.class);
		
		int totalCount = qs.totalCount();//�� �Խù��� ��
		int pageScale = qs.pageScale();
		int totalPage = qs.totalPage(totalCount);//��ü �Խù��� �����ֱ� ���� �� ������ �� 
		if(lvo.getCurrentPage() == 0) { //web parameter�� ���� ���� ��
			lvo.setCurrentPage(1);
		}
		int startNum = qs.startNum(lvo.getCurrentPage());
		int endNum = qs.endNum(startNum);
		lvo.setStartNum(startNum);
		lvo.setEndNum(endNum);

		list = qs.selectQnAQuestionList(lvo);//����Ʈ ��� ��ȸ
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
	public String chargePage(Model model) {
		
		
		model.addAttribute("page", "charge");
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
