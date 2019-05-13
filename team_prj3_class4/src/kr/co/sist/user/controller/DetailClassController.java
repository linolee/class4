package kr.co.sist.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.admin.domain.QnaQuestionList;
import kr.co.sist.user.domain.Addr;
import kr.co.sist.user.domain.ClassTime;
import kr.co.sist.user.domain.DetailContents;
import kr.co.sist.user.domain.JoinCount;
import kr.co.sist.user.domain.QnA;
import kr.co.sist.user.domain.ReviewDomain;
import kr.co.sist.user.domain.Star;
import kr.co.sist.user.domain.Summary;
import kr.co.sist.user.domain.TClass;
import kr.co.sist.user.service.UserLoginService;
import kr.co.sist.user.service.detailClassService;
import kr.co.sist.user.vo.ListVO;
import kr.co.sist.user.vo.UserLoginVO;


@Controller
public class DetailClassController {
			
	@RequestMapping(value="/user/classDetail/detail.do", method=GET)
	public String showDetailClass(kr.co.sist.admin.vo.ListVO listvo,HttpSession session,String lcode,Model model) {
		
		String id=(String) session.getAttribute("client_id");

		Summary summary=null;
		Star star=null;
		List<String> career,optlist,noptlist,day=null;
		DetailContents detailc=null;
		List<ReviewDomain> rvlist=null;
		
		List<QnA> qnalist=null;
		List<TClass> tclist=null;
		ClassTime classTime=null;
		JoinCount joinCount=null;
		String like=null;
		Addr addr=null;

		//String lcodetest="2";
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		detailClassService dcs=ac.getBean(detailClassService.class);
		
		int totalCount = dcs.RtotalCount();// �� �Խù��� ��//
		int pageScale = dcs.RpageScale();
		int totalPage = dcs.RtotalPage(totalCount);// ��ü �Խù��� �����ֱ� ���� �� ������ ��
		if (listvo.getCurrentPage() == 0) { // web parameter�� ���� ���� ��
			listvo.setCurrentPage(1);
		}
		int startNum = dcs.RstartNum(listvo.getCurrentPage());
		int endNum = dcs.RendNum(startNum);
		listvo.setStartNum(startNum);
		listvo.setEndNum(endNum);
		rvlist = dcs.searchRvList(lcode);
		
		summary=dcs.searchSummary(lcode);
		star=dcs.searchStar(lcode);
		career=dcs.searchCareer(lcode);
		optlist=dcs.searchOpt(lcode);
		noptlist=dcs.searchNoOpt();
		detailc=dcs.searchDeContents(lcode);
		rvlist=dcs.searchRvList(lcode);
		qnalist=dcs.searchQnaList(lcode);
		tclist=dcs.searchTclassList(lcode);
		day=dcs.searchClassday(lcode);
		classTime=dcs.searchClassTime(lcode);
		joinCount=dcs.searchJoinCount(lcode);
		like=dcs.searchLike(lcode);
		addr=dcs.searchAddr(lcode);
		
		model.addAttribute("id",id);
		
		model.addAttribute("summary",summary);
		model.addAttribute("star",star);
		model.addAttribute("career",career);
		model.addAttribute("optlist",optlist);
		model.addAttribute("noptlist",noptlist);
		model.addAttribute("detailc",detailc);
		model.addAttribute("rvlist",rvlist);
		model.addAttribute("qnalist",qnalist);
		model.addAttribute("tclist",tclist);
		model.addAttribute("day",day);
		model.addAttribute("classTime",classTime);
		model.addAttribute("joinCount",joinCount);
		model.addAttribute("like",like);
		model.addAttribute("addr",addr);
		
		System.out.println(summary);
		
		return "user/classDetail/detail";
	}//mvRecommendCalss
	
	@ResponseBody
	@RequestMapping(value="user/student/classJoin.do", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public String classJoin(Model model, HttpSession session, String lcode) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		detailClassService dcs=ac.getBean(detailClassService.class);
		String clientId = session.getAttribute("client_id").toString();
		boolean updateJoinStudent=false;
		ListVO lvo=new ListVO(lcode, clientId);
		String sendjs=null;
		boolean joinStatus=(dcs.joinStatus(lvo)!=null);
		if(joinStatus) { //����� ������ ��û�ѻ���=>update cancel
			updateJoinStudent=dcs.cancelJoin(lvo);
			if(updateJoinStudent){
				sendjs="���";
			}//end if
		}else { //�׷��� ������ ��û���ѻ��·� =>��û
			updateJoinStudent=dcs.insertJoin(lvo);
			if(updateJoinStudent) {
				sendjs="��û";
			}//end if
		}//end else
		return sendjs;
	}//classJoin
	
	@RequestMapping(value = "user/member/popuplogin.do", method = POST, produces="text/plain;charset=UTF-8")
	public void login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext.xml");
		UserLoginService uls = ac.getBean("UserLoginService", UserLoginService.class);
		// �Է¹��� id�� pass�� vo�� ����
		UserLoginVO ulvo = new UserLoginVO(request.getParameter("id"), request.getParameter("pass"));

		// ������ vo�� login method�� ����
		int loginResult = uls.login(ulvo, session);
		String lcode=request.getParameter("lcode");
		String loginPath = "";
		switch (loginResult) {
		case UserLoginService.login_success:
			loginPath = "/team_prj3_class4/user/classDetail/detail.do?lcode="+lcode;
			break;
		case UserLoginService.login_blacklist:
			loginPath = "/team_prj3_class4/user/classDetail/detail.do?lcode="+lcode;
			//loginPath = "/team_prj3_class4/user/member/loginPage.do?result=black";
			break;
		case UserLoginService.login_deletedUser:
			loginPath = "/team_prj3_class4/user/classDetail/detail.do?lcode="+lcode;
			//loginPath = "/team_prj3_class4/user/member/loginPage.do?result=deleted";
			break;
		case UserLoginService.login_fail:
			loginPath = "/team_prj3_class4/user/classDetail/detail.do?lcode="+lcode;
			//loginPath = "/team_prj3_class4/user/member/loginPage.do?result=fail";
			break;
		}
		
		System.out.println(uls.login(ulvo, session));
		System.out.println(session.getAttribute("name"));
		//�ٽ� ���� �������� ���ƿ�
		try {
			response.sendRedirect(loginPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// login
}//class

