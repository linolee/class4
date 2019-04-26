package kr.co.sist.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.domain.LecturePermitDomain;
import kr.co.sist.admin.service.LecturePermitService;
import kr.co.sist.admin.service.QnaService;

@Controller
public class LecturePermitController {

	@RequestMapping(value="/admin/lecturePermit.do",method=GET)
	public String lecturePermitPage(Model model) {
		List<LecturePermitDomain> list=null;
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext2.xml");
		LecturePermitService lps = ac.getBean(LecturePermitService.class);
		list = lps.selectLecturePermit();
		
		model.addAttribute("page", "lecturePermit");
		model.addAttribute("lecturePermit", list);
		return "admin/template";
	}
}
