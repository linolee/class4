package kr.co.sist.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.service.QnaService;
import kr.co.sist.user.domain.LectureView;
import kr.co.sist.user.service.UserLectureService;

@Controller
public class TeacherController {
	
	@RequestMapping(value="user/teacher/classStatus.do", method=GET)
	public String classStatusForm(HttpSession session, Model model) {
		
		String id = "";	//나중에 세션값으로 조회하기
		id = (String)session.getAttribute("client_id");
		
		//autowired로 의존성 주입//
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserLectureService uls = ac.getBean(UserLectureService.class);
		
		List<LectureView> list = uls.searchLectureInfo(id);
		model.addAttribute("l_list", list);//@@
		
		// 서비스 호출하기
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

	@RequestMapping(value="user/teacher/classReview.do", method=GET)
	public String classReviewForm() {
		
		return "user/teacher/classReview";
	}
	
	@RequestMapping(value="user/teacher/qna.do", method=GET)
	public String qnaForm() {
		
		return "user/teacher/qna";
	}
	
	@RequestMapping(value="user/teacher/adminQuestion.do", method=GET)
	public String adminQuestionForm() {
		
		return "user/teacher/adminQuestion";
	}
	
	
}
