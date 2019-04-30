package kr.co.sist.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.user.domain.CancelList;
import kr.co.sist.user.domain.ClassList;
import kr.co.sist.user.domain.ClientPageInfo;
import kr.co.sist.user.domain.QnaList;
import kr.co.sist.user.domain.ReportList;
import kr.co.sist.user.service.UserMypageService;
import kr.co.sist.user.vo.ListPageVO;
import kr.co.sist.user.vo.ListVO;
import kr.co.sist.user.vo.StatusCntVO;
import kr.co.sist.user.vo.StatusListVO;

@Controller
public class MypageController {
	@Autowired(required=false)
	private UserMypageService ums;
	
	@RequestMapping(value="user/student/mypage_list.do",method=GET)
	public String indexPage( Model model ,  HttpSession session, HttpServletRequest request, ListPageVO lpvo) {
		
		if (session.getAttribute("client_id") != null) {
			String clientId = session.getAttribute("client_id").toString();
			ListVO lvo=new ListVO("", clientId);
			StatusListVO slvo=new StatusListVO("", clientId, "");
			List<List<ClassList>> classList=new ArrayList<List<ClassList>>();
			List<List<ClassList>> classStatusList=new ArrayList<List<ClassList>>();
			List<String> lcodeList=null;
			lcodeList=ums.lcodeList(clientId);
			for(int i=0; i<lcodeList.size(); i++) {
				lvo.setLcode(lcodeList.get(i));
				classList.add(ums.classList(lvo));
				if( !(request.getParameter("status") == null) ) {
					slvo.setLcode(lcodeList.get(i));
					slvo.setpageStatus(request.getParameter("status"));
					if( !(ums.selectStatusClass(slvo)==null) && !"[]".equals(ums.selectStatusClass(slvo).toString()) ) {
							classStatusList.add(ums.selectStatusClass(slvo));
					}//end if
				}//end if
			}//end for
			model.addAttribute("classList", classList);
			model.addAttribute("classStatusList", classStatusList);
			
			StatusCntVO ssvo=new StatusCntVO(clientId, "Y");
			for(int i=1; i<5; i++) {
				switch (i) {
				case 1:
					ssvo.setStatus("Y");
					break;
				case 2:
					ssvo.setStatus("I");
					break;
				case 3:
					ssvo.setStatus("X");
					break;
				case 4:
					ssvo.setStatus("C");
					break;
				}//end switch
					
				int statusCnt = ums.statusCnt(ssvo);
				model.addAttribute("statusCnt"+i, statusCnt);
			}//end for
			
			int totalCount=ums.totalCount(clientId); //총 게시물의 수
			int pageScale=ums.pageScale(); //한 화면에 보여줄 게시물의 수
			int totalPage=ums.totalPage(totalCount); //총 게시물을 보여주기 위한 총 페이지 수
			if(lpvo.getCurrentPage() == 0) { //web parameter에 값이 없을 때
				lpvo.setCurrentPage(1); //1번부터 조회해야 하므로 1로 설정
			}//end if
			
			int startNum=ums.startNum(lpvo.getCurrentPage());//시작번호
			int endNum=ums.endNum(startNum);//끝번호
			
			lpvo.setStartNum(startNum);
			lpvo.setEndNum(endNum);
			
			String indexList=ums.indexList(lpvo.getCurrentPage(), totalPage, "mypage_list.do");
			
			model.addAttribute("indexList",indexList);
			model.addAttribute("pageScale",pageScale);
			model.addAttribute("totalCount",totalCount);
			model.addAttribute("currentPage",lpvo.getCurrentPage());
			
			return "user/student/mypage_list";
		}else {
			return "user/member/login";
		}//end else
	}//indexPage
	
	@RequestMapping(value="user/student/mypage_assess.do", method=GET)
	public String mypageAssess(Model model ,  HttpSession session) {
		String clientId = session.getAttribute("client_id").toString();
		ListVO lvo=new ListVO("", clientId);
		List<List<ClassList>> reviewList=new ArrayList<List<ClassList>>();
		List<String> reviewStatus=new ArrayList<String>();
		List<String> lcodeList=null;
		lcodeList=ums.lcodeList(clientId);
		for(int i=0; i<lcodeList.size(); i++) {
			lvo.setLcode(lcodeList.get(i));
			reviewList.add(ums.classList(lvo));
			reviewStatus.add(ums.reviewStatus(lvo));
		}//end for
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("reviewStatus", reviewStatus);
		
		return "user/student/mypage_assess";
	}//useRequest
	
	@RequestMapping(value="user/student/mypage_jjim.do", method=GET)
	public String mypageJjim(Model model ,  HttpSession session, HttpServletRequest request) {
		boolean updateJjim=false;
		String clientId = session.getAttribute("client_id").toString();
		ListVO lvo=new ListVO("", clientId);
		if(!(request.getParameter("addJjim")==null)) {
			lvo.setLcode(request.getParameter("addJjim"));
			updateJjim=ums.insertJjim(lvo);
		}//end if
		if(!(request.getParameter("cancelJjim")==null)) {
			lvo.setLcode(request.getParameter("cancelJjim"));
			updateJjim=ums.deleteJjim(lvo);
		}//end if
		List<List<ClassList>> jjimList=new ArrayList<List<ClassList>>();
		List<String> jjimStatus=new ArrayList<String>();
		List<String> lcodeList=null;
		lcodeList=ums.lcodeList(clientId);
		for(int i=0; i<lcodeList.size(); i++) {
			lvo.setLcode(lcodeList.get(i));
			jjimList.add(ums.classList(lvo));
			jjimStatus.add(ums.jjimStatus(lvo));
		}//end for
		model.addAttribute("jjimList", jjimList);
		model.addAttribute("jjimStatus", jjimStatus);
		model.addAttribute("updateJjim", updateJjim);
		return "user/student/mypage_jjim";
	}//useRequest
	@RequestMapping(value="user/student/mypage_cancel.do", method=GET)
	public String mypageCancel(Model model, HttpSession session) {
		String clientId = session.getAttribute("client_id").toString();
		ListVO lvo=new ListVO("", clientId);
		List<List<CancelList>> cancelList=new ArrayList<List<CancelList>>();
		List<String> lcodeList=null;
		lcodeList=ums.cancelLcodeList(clientId);
		for(int i=0; i<lcodeList.size(); i++) {
			lvo.setLcode(lcodeList.get(i));
			cancelList.add(ums.cancelList(lvo));
		}//end for
		model.addAttribute("cancelList", cancelList);
		
		return "user/student/mypage_cancel";
	}//useRequest
	@RequestMapping(value="user/student/mypage_q&a.do", method=GET)
	public String mypageQA(Model model, HttpSession session) {
		String clientId = session.getAttribute("client_id").toString();
		ListVO lvo=new ListVO("", clientId);
		List<List<QnaList>> qnaList=new ArrayList<List<QnaList>>();
		List<String> lcodeList=null;
		lcodeList=ums.qnaLcodeList(clientId);
		for(int i=0; i<lcodeList.size(); i++) {
			lvo.setLcode(lcodeList.get(i));
			qnaList.add(ums.qnaList(lvo));
		}//end for
		model.addAttribute("qnaList", qnaList);
		
		return "user/student/mypage_q&a";
	}//useRequest
	
	@RequestMapping(value="user/student/mypage_report.do", method=GET)
	public String mypageReport(Model model, HttpSession session) {
		String clientId = session.getAttribute("client_id").toString();
		ListVO lvo=new ListVO("", clientId);
		List<List<ReportList>> reportList=new ArrayList<List<ReportList>>();
		List<String> lcodeList=null;
		lcodeList=ums.reportLcodeList(clientId);
		for(int i=0; i<lcodeList.size(); i++) {
			lvo.setLcode(lcodeList.get(i));
			reportList.add(ums.reportList(lvo));
		}//end for
		model.addAttribute("reportList", reportList);
		
		return "user/student/mypage_report";
	}//useRequest
}
