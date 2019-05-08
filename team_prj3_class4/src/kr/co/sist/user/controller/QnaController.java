package kr.co.sist.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.user.service.UserQnaService;
import kr.co.sist.user.vo.QnaVO;

@Controller
public class QnaController {
		
		@RequestMapping(value="user/student/question.do",method=GET)
		public String qnaPage( Model model ,  HttpSession session, HttpServletRequest request) {
			
			model.addAttribute("qnaLcode",request.getParameter("lcode"));
			
			return "user/student/question";
		}//qnaPage
		
		@RequestMapping(value="user/student/qnaProcess.do",method=GET)
		public String qnaProcess( Model model ,  HttpSession session, HttpServletRequest request) {
			//autowired로 의존성 주입//
			ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
			UserQnaService ums = ac.getBean(UserQnaService.class);
			
			boolean insertFlag=false;
			String clientId = session.getAttribute("client_id").toString();
			String lcode=request.getParameter("lcode");
			String subject=request.getParameter("subject");
			String contents=request.getParameter("contents");
			QnaVO qvo=new QnaVO(lcode, clientId, subject, contents); 
			
			insertFlag=ums.insertQna(qvo);
			
			if(insertFlag) {
				return "/user/classDetail/detail";
			}else {
				return "user/student/question";
			}//end else
		}//qnaProcess
}//class
