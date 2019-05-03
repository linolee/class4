package kr.co.sist.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.user.domain.DetailContents;
import kr.co.sist.user.domain.QnA;
import kr.co.sist.user.domain.ReviewDomain;
import kr.co.sist.user.domain.Star;
import kr.co.sist.user.domain.Summary;
import kr.co.sist.user.service.detailClassService;


@Controller
public class DetailClassController {
			
	@RequestMapping(value="/user/classDetail/detail.do", method=GET)
	public String showDetailClass(String lcode,Model model) {
		Summary summary=null;
		Star star=null;
		List<String> career,optlist,noptlist=null;
		DetailContents dcontents=null;
		List<ReviewDomain> rvlist=null;
		List<QnA> qnalist=null;
		
		String lcodetest="2";
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		detailClassService dcs=ac.getBean(detailClassService.class);
		summary=dcs.searchSummary(lcodetest);
		star=dcs.searchStar(lcodetest);
		career=dcs.searchCareer(lcodetest);
		optlist=dcs.searchOpt(lcodetest);
		noptlist=dcs.searchNoOpt();
		dcontents=dcs.searchContents(lcodetest);
		rvlist=dcs.searchRvList(lcodetest);
		qnalist=dcs.searchQnaList(lcodetest);
		
		model.addAttribute("summary",summary);
		model.addAttribute("star",star);
		model.addAttribute("career",career);
		model.addAttribute("optlist",optlist);
		model.addAttribute("noptlist",noptlist);
		model.addAttribute("dcontents",dcontents);
		model.addAttribute("rvlist",rvlist);
		model.addAttribute("qnalist",qnalist);
		
		System.out.println(summary);
		
		return "user/classDetail/detail";
	}//mvRecommendCalss
	
}//class

