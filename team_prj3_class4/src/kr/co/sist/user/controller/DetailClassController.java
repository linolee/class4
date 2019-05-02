package kr.co.sist.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.user.domain.Star;
import kr.co.sist.user.domain.Summary;
import kr.co.sist.user.service.detailClassService;


@Controller
public class DetailClassController {
			
	@RequestMapping(value="/user/classDetail/detail.do", method=GET)
	public String showDetailClass(String lcode,Model model) {
		Summary summary=null;
		Star star=null;
		String lcodetest="2";
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		detailClassService dcs=ac.getBean(detailClassService.class);
		summary=dcs.searchSummary(lcodetest);
		star=dcs.searchStar(lcodetest);
		
		model.addAttribute("summary",summary);
		model.addAttribute("star",star);
		
		System.out.println(summary);
		
		return "user/classDetail/detail";
	}//mvRecommendCalss
	
}//class

