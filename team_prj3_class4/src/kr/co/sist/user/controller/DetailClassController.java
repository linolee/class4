package kr.co.sist.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.user.domain.Addr;
import kr.co.sist.user.domain.ClassTime;
import kr.co.sist.user.domain.DetailContents;
import kr.co.sist.user.domain.JoinCount;
import kr.co.sist.user.domain.QnA;
import kr.co.sist.user.domain.ReviewDomain;
import kr.co.sist.user.domain.Star;
import kr.co.sist.user.domain.Summary;
import kr.co.sist.user.domain.TClass;
import kr.co.sist.user.service.detailClassService;


@Controller
public class DetailClassController {
			
	@RequestMapping(value="/user/classDetail/detail.do", method=GET)
	public String showDetailClass(HttpSession session,String lcode,Model model) {
		
		String id=(String) session.getAttribute("client_id");
		
		Summary summary=null;
		Star star=null;
		List<String> career,optlist,noptlist,day=null;
		DetailContents detailc=null;
		List<ReviewDomain> rvlist=null;
		List<QnA> qnalist=null;
		List<TClass> tclist=null;
		ClassTime classTime=null;
		JoinCount joinCount=null;
		String like=null;
		Addr addr=null;

		//String lcodetest="2";
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		detailClassService dcs=ac.getBean(detailClassService.class);
		summary=dcs.searchSummary(lcode);
		star=dcs.searchStar(lcode);
		career=dcs.searchCareer(lcode);
		optlist=dcs.searchOpt(lcode);
		noptlist=dcs.searchNoOpt();
		detailc=dcs.searchDeContents(lcode);
		rvlist=dcs.searchRvList(lcode);
		qnalist=dcs.searchQnaList(lcode);
		tclist=dcs.searchTclassList(lcode);
		day=dcs.searchClassday(lcode);
		classTime=dcs.searchClassTime(lcode);
		joinCount=dcs.searchJoinCount(lcode);
		like=dcs.searchLike(lcode);
		addr=dcs.searchAddr(lcode);
		
		model.addAttribute("id",id);
		
		model.addAttribute("summary",summary);
		model.addAttribute("star",star);
		model.addAttribute("career",career);
		model.addAttribute("optlist",optlist);
		model.addAttribute("noptlist",noptlist);
		model.addAttribute("detailc",detailc);
		model.addAttribute("rvlist",rvlist);
		model.addAttribute("qnalist",qnalist);
		model.addAttribute("tclist",tclist);
		model.addAttribute("day",day);
		model.addAttribute("classTime",classTime);
		model.addAttribute("joinCount",joinCount);
		model.addAttribute("like",like);
		model.addAttribute("addr",addr);
		
		System.out.println(summary);
		
		return "user/classDetail/detail";
	}//mvRecommendCalss
	
}//class

