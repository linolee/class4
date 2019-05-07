package kr.co.sist;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.domain.ChargeAllList;
import kr.co.sist.admin.domain.ChargeDetail;
import kr.co.sist.admin.domain.ChargeDetailList;
import kr.co.sist.admin.domain.LessonInfo;
import kr.co.sist.admin.domain.QnaDetail;
import kr.co.sist.admin.domain.QnaQuestionList;
import kr.co.sist.admin.service.ChargeService;
import kr.co.sist.admin.service.QnaService;
import kr.co.sist.admin.vo.ListChargeDetailVO;
import kr.co.sist.admin.vo.ListVO;
import kr.co.sist.admin.vo.QnaAnswerVO;

@Controller
public class AdminController {


	@RequestMapping(value="/admin/template.do",method= {GET,POST})
	public String mainPage(Model model) {

		return "admin/template";
	}


	@RequestMapping(value = "/admin/AdminLogin.do", method = GET)
	public String loginPage(Model model) {
		return "admin/AdminLogin";
	}

	@RequestMapping(value="/admin/question.do",method=GET)
	public String questionPage( ListVO lvo, Model model ) {
		List<QnaQuestionList> list = null;

		// autowired로 의존성 주입//
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext2.xml");
		QnaService qs = ac.getBean(QnaService.class);

		int totalCount = qs.totalCount();// 총 게시물의 수//
		int pageScale = qs.pageScale();
		int totalPage = qs.totalPage(totalCount);// 전체 게시물을 보여주기 위한 총 페이지 수
		if (lvo.getCurrentPage() == 0) { // web parameter에 값이 없을 때
			lvo.setCurrentPage(1);
		}
		int startNum = qs.startNum(lvo.getCurrentPage());
		int endNum = qs.endNum(startNum);
		lvo.setStartNum(startNum);
		lvo.setEndNum(endNum);

		list = qs.searchQnAQuestionList(lvo);// 리스트 목록 조회

		String indexList = qs.indexList(lvo.getCurrentPage(), totalPage, "question.do");
		model.addAttribute("list", list);// @@
		model.addAttribute("indexList", indexList);
		model.addAttribute("pageScale", pageScale);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", lvo.getCurrentPage());

		model.addAttribute("page", "question");// @@
		return "admin/template";
	}

	@RequestMapping(value = "/admin/qnaRead.do", method = GET)
	public String qnaRead(String qnum, Model model) {

		// autowired로 의존성 주입////
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext2.xml");
		QnaService qs = ac.getBean(QnaService.class);

		QnaDetail qd = qs.searchQnaDetail(qnum);// 원글의 내용을 조회
		model.addAttribute("searchData", qd);
		model.addAttribute("page", "qnaRead");
		return "admin/template";
	}

	@RequestMapping(value = "/admin/addQnaAnswer.do", method = POST)
	public String addQnaAnswer(QnaAnswerVO qavo, Model model) {
		// autowired로 의존성 주입////
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext2.xml");
		QnaService qs = ac.getBean(QnaService.class);

		int cnt = qs.addQnaAnswer(qavo);

		// model.addAttribute("page", page);
		// return "forward:question.do";
		// return "redirect:/admin/template.do";
		// return "admin/template";
		return "redirect:/admin/question.do";
	}

	@RequestMapping(value = "/admin/charge.do", method = GET)
	public String chargePage(ListVO lvo, Model model) {
		List<ChargeAllList> list = null;

		// autowired로 의존성 주입//
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext2.xml");
		ChargeService cs = ac.getBean(ChargeService.class);

		int totalCount = cs.totalCount();// 총 게시물의 수//
		int pageScale = cs.pageScale();
		int totalPage = cs.totalPage(totalCount);// 전체 게시물을 보여주기 위한 총 페이지 수
		if (lvo.getCurrentPage() == 0) { // web parameter에 값이 없을 때
			lvo.setCurrentPage(1);
		}
		int startNum = cs.startNum(lvo.getCurrentPage());
		int endNum = cs.endNum(startNum);
		lvo.setStartNum(startNum);
		lvo.setEndNum(endNum);

		list = cs.searchChargeAllList(lvo);// 리스트 목록 조회

		String indexList = cs.indexList(lvo.getCurrentPage(), totalPage, "charge.do");
		model.addAttribute("list", list);// @@
		model.addAttribute("indexList", indexList);
		model.addAttribute("pageScale", pageScale);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", lvo.getCurrentPage());
		
		model.addAttribute("page", "charge");
		return "admin/template";
	}
	
	//chargeReadList
	@RequestMapping(value = "/admin/chargeReadList.do", method = GET)
	public String chargeReadList(String lcode, ListChargeDetailVO lcdvo ,Model model) {
		List<ChargeDetailList> detailList = null;
		
		// autowired로 의존성 주입////
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext2.xml");
		ChargeService cs = ac.getBean(ChargeService.class);

		int totalCount = cs.chargeDetailTotalCount(lcode);// 총 게시물의 수//
		int pageScale = cs.pageScale();
		int totalPage = cs.totalPage(totalCount);// 전체 게시물을 보여주기 위한 총 페이지 수
		if (lcdvo.getCurrentPage() == 0) { // web parameter에 값이 없을 때
			lcdvo.setCurrentPage(1);
		}
		int startNum = cs.startNum(lcdvo.getCurrentPage());
		int endNum = cs.endNum(startNum);
		lcdvo.setStartNum(startNum);
		lcdvo.setEndNum(endNum);
		lcdvo.setLcode(lcode);
		
		LessonInfo li = cs.searchChargeDetailLessonInfo(lcode);
		detailList = cs.searchChargeDetailList(lcdvo);
		
		String indexList = cs.indexList(lcdvo.getCurrentPage(), totalPage, "chargeReadList.do", lcode);
		model.addAttribute("detailList", detailList);// @@
		model.addAttribute("indexList", indexList);
		model.addAttribute("pageScale", pageScale);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", lcdvo.getCurrentPage());
		model.addAttribute("lessonInfo", li);
		
		model.addAttribute("page", "chargeReadList");
		return "admin/template";
	}
	
	@RequestMapping(value = "/admin/lessonClosure.do", method = POST)
	public String lessonClosure(String lcode, Model model) {
		// autowired로 의존성 주입////
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext2.xml");
		ChargeService cs = ac.getBean(ChargeService.class);

		cs.removeLessonClosure(lcode);
		return "redirect:/admin/charge.do";
	}
	
	@RequestMapping(value = "/admin/chargeRead.do", method = GET)
	public String chargeRead(String rcode, Model model) {

		// autowired로 의존성 주입////
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext2.xml");
		ChargeService cs = ac.getBean(ChargeService.class);

		ChargeDetail cd = cs.searchChargeDetail(rcode);// 원글의 내용을 조회
		model.addAttribute("searchData", cd);
		model.addAttribute("page", "chargeRead");
		return "admin/template";
	}
	
	@RequestMapping(value = "/admin/chargeRefuse.do", method = POST)
	public String chargeRefuse(String refuse, String rcode, Model model) {
		// autowired로 의존성 주입////
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext2.xml");
		ChargeService cs = ac.getBean(ChargeService.class);
		
		if(refuse.equals("Y")) {
			cs.applyReport(rcode);
		}else {
			cs.removeReport(rcode);
		}
		return "redirect:/admin/charge.do";
	}
	
	
	
	
	@RequestMapping(value = "/admin/category.do", method = GET)
	public String categoryPage(Model model) {

		model.addAttribute("page", "category");
		return "admin/template";
	}

	@RequestMapping(value = "/admin/title.do", method = GET)
	public String titlePage(Model model) {

		model.addAttribute("page", "title");
		return "admin/template";
	}

}
