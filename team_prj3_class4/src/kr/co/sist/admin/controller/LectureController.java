package kr.co.sist.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.domain.LectureListDomain;
import kr.co.sist.admin.service.LectureService;

@Controller
public class LectureController {

	@RequestMapping(value="/admin/lecture.do",method=GET)
	public String lecturePage(Model model) {
		List<LectureListDomain> list=null;
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext2.xml");
		LectureService ls=ac.getBean(LectureService.class);
		list=ls.selectLectureList();
		
		model.addAttribute("page", "lecture");
		model.addAttribute("lectureList", list);
		
		return "admin/template";
	}
	
	
}
