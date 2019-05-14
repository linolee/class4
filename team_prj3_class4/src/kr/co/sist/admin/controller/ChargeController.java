package kr.co.sist.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.domain.ChargeAllList;
import kr.co.sist.admin.domain.ChargeDetail;
import kr.co.sist.admin.domain.ChargeDetailList;
import kr.co.sist.admin.domain.LessonInfo;
import kr.co.sist.admin.service.ChargeService;
import kr.co.sist.admin.vo.ListChargeDetailVO;
import kr.co.sist.admin.vo.ListVO;


@Controller
public class ChargeController {
	
	@Autowired
	private ChargeService cs;

	@RequestMapping(value = "/admin/charge.do", method = GET)
	public String chargePage(ListVO lvo, Model model, HttpSession session) {
		
		String loginChk=(String)session.getAttribute("loginFlag");
		if("true"!=loginChk) {
			return "redirect:/admin/AdminLogin.do";
		}
		
		List<ChargeAllList> list = null;

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
		cs.closeLessonClosure(lcode);
		return "redirect:/admin/charge.do";
	}
	
	@RequestMapping(value = "/admin/chargeRead.do", method = GET)
	public String chargeRead(String rcode, Model model) {
		ChargeDetail cd = cs.searchChargeDetail(rcode);// 원글의 내용을 조회
		model.addAttribute("searchData", cd);
		model.addAttribute("page", "chargeRead");
		return "admin/template";
	}
	
	@RequestMapping(value = "/admin/chargeRefuse.do", method = POST)
	public String chargeRefuse(String refuse, String rcode, Model model) {
		if(refuse.equals("Y")) {
			cs.applyReport(rcode);
		}else {
			cs.rejectReport(rcode);
		}
		return "redirect:/admin/charge.do";
	}
	
}
