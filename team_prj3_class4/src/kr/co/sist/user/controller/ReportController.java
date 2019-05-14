package kr.co.sist.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.user.service.ReportService;
import kr.co.sist.user.service.UserQnaService;
import kr.co.sist.user.service.UserReportService;
import kr.co.sist.user.vo.QnaVO;
import kr.co.sist.user.vo.ReportVO;

@Controller
public class ReportController {
	@RequestMapping(value="user/student/report.do",method=GET)
	public String qnaPage( Model model ,  HttpSession session, HttpServletRequest request) {
		
		model.addAttribute("reportLcode",request.getParameter("lcode"));
		
		return "user/student/report";
	}//qnaPage
	
	@RequestMapping(value="user/student/reportProcess.do",method=GET)
	public String qnaProcess( Model model ,  HttpSession session, HttpServletRequest request) {
		//autowired로 의존성 주입//
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		ReportService rs = ac.getBean(ReportService.class);
		
		boolean insertFlag=false;
		String clientId = session.getAttribute("client_id").toString();
		String lcode=request.getParameter("lcode");
		String subject=request.getParameter("subject");
		String contents=request.getParameter("contents");
		int reportType=Integer.parseInt(request.getParameter("reportType"));
		ReportVO rvo=new ReportVO(clientId, lcode, subject, contents, reportType); 
		
		insertFlag=rs.insertReport(rvo);
		
		if(insertFlag) {
			return "redirect:/user/classDetail/detail.do?lcode="+lcode;
		}else {
			return "user/student/report";
		}//end else
	}//qnaProcess
}
