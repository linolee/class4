package kr.co.sist.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeacherController {
	
	@RequestMapping(value="user/teacher/classStatus.do", method=GET)
	public String classStatusForm() {
		
		return "user/teacher/classStatus";
	}
	
	@RequestMapping(value="user/teacher/classRegist.do", method=GET)
	public String classRegistForm() {
		
		return "user/teacher/classRegist";
	}
	
	@RequestMapping(value="user/teacher/teacherProfile.do", method=GET)
	public String teacherProfileForm() {
		
		return "user/teacher/teacherProfile";
	}
	
	
}
