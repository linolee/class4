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

@Controller
public class MemberListController {
	
	@RequestMapping(value="/admin/member.do",method=GET)
	public String memberPage(Model model) {
		
		List<MemberListDomain> list=null;
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext2.xml");
		MemberListService mls=ac.getBean(MemberListService.class);
		list=mls.selectAllMember();
		
		model.addAttribute("page", "member");
		model.addAttribute("memberList", list);
		
		return "admin/template";
	}
}
