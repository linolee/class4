package kr.co.sist.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.domain.LectureListDomain;
import kr.co.sist.admin.service.IndexService;
import kr.co.sist.admin.service.LectureService;
import kr.co.sist.admin.vo.ListVO;

@Controller
public class LectureController {
	
	@Autowired
	private LectureService ls;
	@Autowired
	private IndexService is;
	
	@RequestMapping(value="/admin/lecture.do",method=GET)
	public String lecturePage(ListVO lvo, Model model) {
		List<LectureListDomain> list=null;
		
		int totalCount = ls.totalCount();//총 게시물의 수
		int pageScale = is.pageScale();
		int totalPage = is.totalPage(totalCount);//전체 게시물을 보여주기 위한 총 페이지 수 
		if(lvo.getCurrentPage() == 0) { //web parameter에 값이 없을 때
			lvo.setCurrentPage(1);
		}
		int startNum = is.startNum(lvo.getCurrentPage());
		int endNum = is.endNum(startNum);
		lvo.setStartNum(startNum);
		lvo.setEndNum(endNum);
		
		list=ls.selectLectureList(lvo);
		
		String indexList = is.indexList(lvo.getCurrentPage(), totalPage, "lecture.do");
		
		model.addAttribute("page", "lecture/lecture");
		model.addAttribute("lectureList", list);
		model.addAttribute("indexList", indexList);
		model.addAttribute("pageScale", pageScale);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", lvo.getCurrentPage());
		
		return "admin/template";
	}
	
	
}
