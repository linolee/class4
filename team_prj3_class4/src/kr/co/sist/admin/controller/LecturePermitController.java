package kr.co.sist.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.admin.domain.LecturePermitDomain;
import kr.co.sist.admin.service.IndexService;
import kr.co.sist.admin.service.LecturePermitService;
import kr.co.sist.admin.service.QnaService;
import kr.co.sist.admin.vo.ListVO;

@Controller
public class LecturePermitController {

	@Autowired
	private LecturePermitService lps;
	@Autowired
	private IndexService is;
	
	@RequestMapping(value="/admin/lecturePermit.do",method=GET)
	public String lecturePermitPage(ListVO lvo, Model model) {
		List<LecturePermitDomain> list=null;
		
		int totalCount = lps.totalCount();//총 게시물의 수
		int pageScale = is.pageScale();
		int totalPage = is.totalPage(totalCount);//전체 게시물을 보여주기 위한 총 페이지 수 
		if(lvo.getCurrentPage() == 0) { //web parameter에 값이 없을 때
			lvo.setCurrentPage(1);
		}
		int startNum = is.startNum(lvo.getCurrentPage());
		int endNum = is.endNum(startNum);
		lvo.setStartNum(startNum);
		lvo.setEndNum(endNum);
		
		list = lps.selectLecturePermit(lvo);
		String indexList = is.indexList(lvo.getCurrentPage(), totalPage, "lecturePermit.do");
		
		model.addAttribute("indexList", indexList);
		model.addAttribute("pageScale", pageScale);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", lvo.getCurrentPage());
		model.addAttribute("page", "lecturePermit/lecturePermit");
		model.addAttribute("lecturePermit", list);
		return "admin/template";
	}
	
	@ResponseBody
	@RequestMapping(value="admin/lecturePermitDetail.do", method=GET)
	public String lecturePermitDetail(String lcode) {
		JSONObject json = null;
		
		json=lps.lecturePermitDetail(lcode);
		
		return json.toJSONString();
	}
	
	@ResponseBody
	@RequestMapping(value="/admin/lecturePermission.do", method=GET)
	public void lecturePermission(String lcode) {
		lps.lecturePermission(lcode);
	}
	
	@ResponseBody
	@RequestMapping(value="/admin/lectureRefuse.do", method=GET)
	public void lectureRefuse(String lcode) {
		lps.lectureRefuse(lcode);
	}
		
	
}
