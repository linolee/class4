package kr.co.sist.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;
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

import kr.co.sist.user.domain.Addr;
import kr.co.sist.user.domain.ClassTime;
import kr.co.sist.user.domain.DetailContents;
import kr.co.sist.user.domain.Join;
import kr.co.sist.user.domain.JoinCount;
import kr.co.sist.user.domain.QnA;
import kr.co.sist.user.domain.ReviewDomain;
import kr.co.sist.user.domain.Star;
import kr.co.sist.user.domain.Summary;
import kr.co.sist.user.domain.TClass;
import kr.co.sist.user.service.UserLoginService;
import kr.co.sist.user.service.detailClassService;
import kr.co.sist.user.vo.ListVO;
import kr.co.sist.user.vo.ReviewListVO;
import kr.co.sist.user.vo.UserLoginVO;


@Controller
public class DetailClassController {
			
	@RequestMapping(value="/user/classDetail/detail.do", method=GET)
	public String showDetailClass(HttpSession session,String lcode,Model model, ReviewListVO rvlistvlo) {
		
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

		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		detailClassService dcs=ac.getBean(detailClassService.class);
		
		int rtotalCount = dcs.RtotalCount(lcode);// 총 게시물의 수//
		int rpageScale = dcs.RpageScale();
		int rtotalPage = dcs.RtotalPage(rtotalCount);// 전체 게시물을 보여주기 위한 총 페이지 수
		if (rvlistvlo.getCurrentPage() == 0) { // web parameter에 값이 없을 때
			rvlistvlo.setCurrentPage(1);
		}
		int startNum = dcs.RstartNum(rvlistvlo.getCurrentPage());
		int endNum = dcs.RendNum(startNum);
		rvlistvlo.setStartNum(startNum);
		rvlistvlo.setEndNum(endNum);
		rvlistvlo.setLcode(lcode);
		
		rvlist = dcs.searchRvList(rvlistvlo);
		String indexList = dcs.RindexList(rvlistvlo.getCurrentPage(), rtotalPage, "detail.do?lcode="+lcode, rvlistvlo.getLcode());
		
		
		
		
		summary=dcs.searchSummary(lcode);
		star=dcs.searchStar(lcode);
		career=dcs.searchCareer(lcode);
		optlist=dcs.searchOpt(lcode);
		noptlist=dcs.searchNoOpt();
		detailc=dcs.searchDeContents(lcode);
		//rvlist=dcs.searchRvList(lcode);
		qnalist=dcs.searchQnaList(lcode);
		tclist=dcs.searchTclassList(lcode);
		day=dcs.searchClassday(lcode);
		classTime=dcs.searchClassTime(lcode);
		joinCount=dcs.searchJoinCount(lcode);
		like=dcs.searchLike(lcode);
		addr=dcs.searchAddr(lcode);

		
		/*String clientId="";
		clientId = session.getAttribute("client_id").toString();
		ListVO lvo=new ListVO(lcode, clientId);
		joinStatus=(dcs.joinStatus(lvo)!=null);*/
		//true 결과가 있으면 신청한상태=>update cancel

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
		
		model.addAttribute("indexList",indexList);
		model.addAttribute("rpageScale",rpageScale);
		model.addAttribute("totalCount", rtotalCount);
		model.addAttribute("currentPage", rvlistvlo.getCurrentPage());
		model.addAttribute("keyword", rvlistvlo.getLcode());
		model.addAttribute("page", "question");// @@
		
		if(id != null) {
			ListVO lvo=new ListVO(lcode, id);
			Join joinStatus3=null;
			joinStatus3=dcs.joinStatus(lvo);
			model.addAttribute("joinStatus3",joinStatus3);
		}
		
		
		//System.out.println(summary);
		
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
		
		Join joinStatus2=null;
		joinStatus2=dcs.joinStatus(lvo);
		
		String sendjs=null;
		boolean joinStatus=(dcs.joinStatus(lvo)!=null);
		if(joinStatus2.getStatus().equals("Y")) { //결과가 있으면 신청한상태=>update cancel
			updateJoinStudent=dcs.cancelJoin(lvo);
			if(updateJoinStudent){
				sendjs="취소";
			}//end if
		}else if(joinStatus2.getStatus().equals("C")) {
			updateJoinStudent=dcs.updateJoin(lvo);
			if(updateJoinStudent) {
				sendjs="다시신청";
			}//end if
		}else { //그렇지 않으면 신청안한상태로 =>신청
			updateJoinStudent=dcs.insertJoin(lvo);
			if(updateJoinStudent) {
				sendjs="신청";
			}//end if
		}//end else
	
		
		model.addAttribute("joinStatus2",joinStatus2);
		model.addAttribute("joinStatus",joinStatus);
		return sendjs;
	}//classJoin
	
	@RequestMapping(value = "user/member/popuplogin.do", method = POST, produces="text/plain;charset=UTF-8")
	public void login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext.xml");
		UserLoginService uls = ac.getBean("UserLoginService", UserLoginService.class);
		// 입력받은 id와 pass로 vo를 생성
		UserLoginVO ulvo = new UserLoginVO(request.getParameter("id"), request.getParameter("pass"));

		// 생성된 vo로 login method를 실행
		int loginResult = uls.login(ulvo, session);
		String lcode=request.getParameter("lcode");
		String loginPath = "";
		switch (loginResult) {
		case UserLoginService.login_success:
			loginPath = "/team_prj3_class4/user/classDetail/detail.do?lcode="+lcode;
			break;
		/*case UserLoginService.login_success:
			loginPath = "/team_prj3_class4/user/main.do";
			break;
		case UserLoginService.login_blacklist:
			loginPath = "/team_prj3_class4/user/member/loginPage.do?result=black&id="+request.getParameter("id");
			break;
		case UserLoginService.login_deletedUser:
			loginPath = "/team_prj3_class4/user/member/loginPage.do?result=deleted&id="+request.getParameter("id");
			break;
		case UserLoginService.login_fail:
			loginPath = "/team_prj3_class4/user/member/loginPage.do?result=fail&id="+request.getParameter("id");
			break;*/
		case UserLoginService.login_blacklist:
			loginPath = "/team_prj3_class4/user/member/loginPage.do?result=black&id="+request.getParameter("id");
			//loginPath = "/team_prj3_class4/user/member/loginPage.do?result=black";
			break;
		case UserLoginService.login_deletedUser:
			loginPath = "/team_prj3_class4/user/member/loginPage.do?result=deleted&id="+request.getParameter("id");
			//loginPath = "/team_prj3_class4/user/member/loginPage.do?result=deleted";
			break;
		case UserLoginService.login_fail:
			/*try {
				PrintWriter out=response.getWriter();
				out=response.getWriter();
				out.println("<script>");
				out.println("alert('다시 시도해보세용');");
				out.println("history.go(-1);");
				out.println("</script>");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			*/
			loginPath = "/team_prj3_class4/user/member/loginPage.do?result=fail&id="+request.getParameter("id");
			//loginPath = "/team_prj3_class4/user/member/loginPage.do?result=fail";
			break;
		}
		
		//System.out.println(uls.login(ulvo, session));
		//System.out.println(session.getAttribute("name"));
		//다시 원래 페이지로 돌아옴
		try {
			response.sendRedirect(loginPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// login
}//class

