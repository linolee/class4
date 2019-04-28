package kr.co.sist.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.domain.LecturePermitDomain;
import kr.co.sist.admin.service.LecturePermitService;
import kr.co.sist.admin.service.QnaService;
import kr.co.sist.admin.vo.ListVO;

@Controller
public class LecturePermitController {

	@RequestMapping(value="/admin/lecturePermit.do",method=GET)
	public String lecturePermitPage(ListVO lvo, Model model) {
		List<LecturePermitDomain> list=null;
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext2.xml");
		LecturePermitService lps = ac.getBean(LecturePermitService.class);
		
		int totalCount = lps.totalCount();//총 게시물의 수
		int pageScale = lps.pageScale();
		int totalPage = lps.totalPage(totalCount);//전체 게시물을 보여주기 위한 총 페이지 수 
		if(lvo.getCurrentPage() == 0) { //web parameter에 값이 없을 때
			lvo.setCurrentPage(1);
		}
		int startNum = lps.startNum(lvo.getCurrentPage());
		int endNum = lps.endNum(startNum);
		lvo.setStartNum(startNum);
		lvo.setEndNum(endNum);
		
		list = lps.selectLecturePermit(lvo);
		String indexList = lps.indexList(lvo.getCurrentPage(), totalPage, "lecturePermit.do");
		
		model.addAttribute("indexList", indexList);
		model.addAttribute("pageScale", pageScale);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", lvo.getCurrentPage());
		model.addAttribute("page", "lecturePermit");
		model.addAttribute("lecturePermit", list);
		return "admin/template";
	}
}
