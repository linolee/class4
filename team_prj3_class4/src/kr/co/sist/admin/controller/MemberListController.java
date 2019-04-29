package kr.co.sist.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import kr.co.sist.admin.domain.MemberListDomain;
import kr.co.sist.admin.service.MemberListService;
import kr.co.sist.admin.vo.ListVO;

@Controller
public class MemberListController {
	
	@RequestMapping(value="/admin/member.do",method=GET)
	public String memberPage(ListVO lvo, Model model) {
		
		List<MemberListDomain> list=null;
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext2.xml");
		MemberListService mls=ac.getBean(MemberListService.class);
		
		int totalCount = mls.totalCount();//총 게시물의 수
		int pageScale = mls.pageScale();
		int totalPage = mls.totalPage(totalCount);//전체 게시물을 보여주기 위한 총 페이지 수 
		if(lvo.getCurrentPage() == 0) { //web parameter에 값이 없을 때
			lvo.setCurrentPage(1);
		}
		int startNum = mls.startNum(lvo.getCurrentPage());
		int endNum = mls.endNum(startNum);

		
		
		lvo.setStartNum(startNum);
		lvo.setEndNum(endNum);

		
		list=mls.selectAllMember(lvo);
		String indexList = mls.indexList(lvo.getCurrentPage(), totalPage, "member.do");
		model.addAttribute("memberList", list);
		model.addAttribute("indexList", indexList);
		model.addAttribute("pageScale", pageScale);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", lvo.getCurrentPage());
		
		model.addAttribute("page", "member/member");
		return "admin/template";
	}
}