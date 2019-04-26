package kr.co.sist.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.domain.TeacherPermitDomain;
import kr.co.sist.admin.service.MemberListService;
import kr.co.sist.admin.service.TeacherPermitService;

@Controller
public class TeacherPermitController {

	@RequestMapping(value="/admin/teacherAuthority.do",method=GET)
	public String teacherAuthorityPage(Model model) {
		
		List<TeacherPermitDomain> list=null;
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext2.xml");
		TeacherPermitService tps=ac.getBean(TeacherPermitService.class);
		list=tps.selectTeacherPermit();
		
		model.addAttribute("page", "teacherAuthority");
		model.addAttribute("teacherPermitList", list);
		return "admin/template";
	}
}
