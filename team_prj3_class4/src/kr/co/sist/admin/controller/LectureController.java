package kr.co.sist.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.admin.dao.LectureDAO;
import kr.co.sist.admin.domain.LectureListDomain;
import kr.co.sist.admin.service.IndexService;
import kr.co.sist.admin.service.LectureService;
import kr.co.sist.admin.vo.LectureStatusVO;
import kr.co.sist.admin.vo.ListVO;
import kr.co.sist.admin.vo.OptionSearchVO;

@Controller
public class LectureController {
	
	@Autowired
	private LectureService ls;
	@Autowired
	private IndexService is;
	
	@RequestMapping(value="/admin/lecture.do",method=GET)
	public String lecturePage(ListVO lvo, Model model, HttpSession session, 
			@RequestParam(value="searchOption", required=false)String option, 
			@RequestParam(value="keyword", required=false)String keyword,
			@RequestParam(value="status", required=false)String status) {
		
		String loginChk=(String)session.getAttribute("loginFlag");
		if("true"!=loginChk) {
			return "redirect:/admin/AdminLogin.do";
		}
		
		List<LectureListDomain> list=null;
		
		int totalCount = ls.totalCount();
		int pageScale = is.pageScale();
		int totalPage = is.totalPage(totalCount); 
		if(lvo.getCurrentPage() == 0) {
			lvo.setCurrentPage(1);
		}
		int startNum = is.startNum(lvo.getCurrentPage());
		int endNum = is.endNum(startNum);
		lvo.setStartNum(startNum);
		lvo.setEndNum(endNum);
		
		list=ls.selectLectureList(lvo);
		
		if(null!=option && null!=keyword) {
			list=null;
			OptionSearchVO osvo=new OptionSearchVO();
			osvo.setOption(option);
			osvo.setKeyword(keyword);
			osvo.setCurrentPage(lvo.getCurrentPage());
			osvo.setStartNum(startNum);
			osvo.setEndNum(endNum);
			list=ls.lectureOptionSearch(osvo);
		}
		
		LectureStatusVO lsvo=null;
		if(null!=status) {
			list=null;
			lsvo=new LectureStatusVO();
			lsvo.setStatus(status);
			lsvo.setCurrentPage(lvo.getCurrentPage());
			lsvo.setStartNum(startNum);
			lsvo.setEndNum(endNum);
			list=ls.lectureStatusSearch(lsvo);
		}
		
		String indexList = is.indexList(lvo.getCurrentPage(), totalPage, "lecture.do");
		System.out.println("-+++-+--++-+-+-+-+-+-+++-+-+-+-+-");
		System.out.println("-+++-+--++-+-+-+-+-+-+++-+-+-+-+-");
		System.out.println(lvo.getCurrentPage());
		System.out.println(totalPage);
		System.out.println(indexList);
		System.out.println("-+++-+--++-+-+-+-+-+-+++-+-+-+-+-");
		System.out.println("-+++-+--++-+-+-+-+-+-+++-+-+-+-+-");
		model.addAttribute("page", "lecture/lecture");
		model.addAttribute("lectureList", list);
		model.addAttribute("indexList", indexList);
		model.addAttribute("pageScale", pageScale);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", lvo.getCurrentPage());
		
		return "admin/template";
	}
	
}
