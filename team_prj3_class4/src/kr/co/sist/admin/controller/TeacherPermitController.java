package kr.co.sist.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.domain.TeacherPermitDomain;
import kr.co.sist.admin.service.TeacherPermitService;
import kr.co.sist.admin.vo.ListVO;

@Controller
public class TeacherPermitController {

	@RequestMapping(value="/admin/teacherAuthority.do",method=GET)
	public String teacherAuthorityPage(ListVO lvo, Model model) {
		
		List<TeacherPermitDomain> list=null;
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext2.xml");
		TeacherPermitService tps=ac.getBean(TeacherPermitService.class);
		
		int totalCount = tps.totalCount();//총 게시물의 수
		int pageScale = tps.pageScale();
		int totalPage = tps.totalPage(totalCount);//전체 게시물을 보여주기 위한 총 페이지 수 
		if(lvo.getCurrentPage() == 0) { //web parameter에 값이 없을 때
			lvo.setCurrentPage(1);
		}
		int startNum = tps.startNum(lvo.getCurrentPage());
		int endNum = tps.endNum(startNum);

		lvo.setStartNum(startNum);
		lvo.setEndNum(endNum);
		
		String indexList = tps.indexList(lvo.getCurrentPage(), totalPage, "teacherAuthority.do");
		
		
		list=tps.selectTeacherPermit(lvo);
		model.addAttribute("indexList", indexList);
		model.addAttribute("pageScale", pageScale);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", lvo.getCurrentPage());
		model.addAttribute("page", "teacherAuthority/teacherAuthority");
		model.addAttribute("teacherPermitList", list);
		return "admin/template";
	}
}
