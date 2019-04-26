package kr.co.sist.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.domain.BlackListDomain;
import kr.co.sist.admin.service.BlackListService;
import kr.co.sist.admin.service.TeacherPermitService;

@Controller
public class BlackListController {
	@RequestMapping(value="/admin/blacklist.do",method=GET)
	public String blacklistPage(Model model) {
		
		List<BlackListDomain> list=null;
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext2.xml");
		BlackListService bls=ac.getBean(BlackListService.class);
		list=bls.selectBlackList();
		
		model.addAttribute("page", "blacklist");
		model.addAttribute("blackList", list);
		return "admin/template";
	}
	
}
