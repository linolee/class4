package kr.co.sist.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.user.dao.SearchDAO;
import kr.co.sist.user.service.SearchService;

@Controller
public class SearchController {
	
	SearchService ss;
	
	
	public SearchController() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext.xml");
		this.ss = ac.getBean("SearchService", SearchService.class);
	}
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@RequestMapping(value = "user/search.do", method = GET)
	public String searchResult() {
		return "user/member/searchResult";
	}
	
}
