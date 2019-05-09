package kr.co.sist.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.user.domain.CancelList;
import kr.co.sist.user.domain.ClassList;
import kr.co.sist.user.domain.QnaList;
import kr.co.sist.user.domain.ReportList;
import kr.co.sist.user.service.UserMypageService;
import kr.co.sist.user.vo.ListPageVO;
import kr.co.sist.user.vo.ListVO;
import kr.co.sist.user.vo.QnaStatusVO;
import kr.co.sist.user.vo.ReportStatusVO;
import kr.co.sist.user.vo.ReviewVO;
import kr.co.sist.user.vo.StatusCntVO;
import kr.co.sist.user.vo.StatusListVO;
import kr.co.sist.user.vo.TotalVO;

@Controller
public class MypageController {
	
	@RequestMapping(value="user/student/mypage_list.do",method=GET)
	public String indexPage( Model model ,  HttpSession session, HttpServletRequest request, ListPageVO lpvo) {
		//autowired로 의존성 주입//
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserMypageService ums = ac.getBean(UserMypageService.class);
		if (session.getAttribute("client_id") != null) {
			String clientId = session.getAttribute("client_id").toString();
			ListVO lvo=new ListVO("", clientId);
			StatusListVO slvo=new StatusListVO("", clientId, "");
			List<List<ClassList>> classList=new ArrayList<List<ClassList>>();
			List<List<ClassList>> classStatusList=new ArrayList<List<ClassList>>();
			List<String> lcodeList=null;
			TotalVO tvo=new TotalVO(clientId, "Y");
			lcodeList=ums.lcodeList(clientId);
			int totalCount=0;
			
			if( request.getParameter("status")==null) {
				tvo.setStatus("Y");
				totalCount=ums.totalCount(tvo);
				tvo.setStatus("X");
				totalCount=totalCount+ums.totalCount(tvo);
				tvo.setStatus("C");
				totalCount=totalCount+ums.totalCount(tvo);
			}//end if
			if( !(request.getParameter("status") == null) ) {
				tvo.setStatus(request.getParameter("status"));
				totalCount=ums.totalCount(tvo); //총 게시물의 수
			}//end if
			
			int pageScale=ums.pageScale(); //한 화면에 보여줄 게시물의 수
			int totalPage=ums.totalPage(totalCount); //총 게시물을 보여주기 위한 총 페이지 수
			if(lpvo.getCurrentPage() == 0) { //web parameter에 값이 없을 때
				lpvo.setCurrentPage(1); //1번부터 조회해야 하므로 1로 설정
			}//end if
			
			int startNum=ums.startNum(lpvo.getCurrentPage());//시작번호
			int endNum=ums.endNum(startNum);//끝번호
			
			if(endNum>lcodeList.size()) {
				endNum=lcodeList.size();
			}//end if
			
			lpvo.setStartNum(startNum);
			lpvo.setEndNum(endNum);
			for(int i=startNum-1; i<endNum; i++) {
				lvo.setLcode(lcodeList.get(i));
				classList.add(ums.classList(lvo));
			}//end for
			if( !(request.getParameter("status") == null) ) {
				for(int i=startNum-1; i<lcodeList.size(); i++) {
					lvo.setLcode(lcodeList.get(i));
					classList.add(ums.classList(lvo));
					slvo.setLcode(lcodeList.get(i));
					slvo.setpageStatus(request.getParameter("status"));
					if( !(ums.selectStatusClass(slvo)==null) && !"[]".equals(ums.selectStatusClass(slvo).toString()) ) {
						if(!(classStatusList.size()>4)) {
							classStatusList.add(ums.selectStatusClass(slvo));
						}//end if
					}//end if
				}//end for
			}//end if
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
			
			String indexList=ums.indexList(lpvo.getCurrentPage(), totalPage, "mypage_list.do?");
			if( !(request.getParameter("status")==null) ) {
				indexList=ums.indexList(lpvo.getCurrentPage(), totalPage, "mypage_list.do?status="+request.getParameter("status")+"&");
				
			}//end if
			
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
	public String mypageAssess(Model model ,  HttpSession session, HttpServletRequest request, ListPageVO lpvo) {
		//autowired로 의존성 주입//
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserMypageService ums = ac.getBean(UserMypageService.class);
		String clientId = session.getAttribute("client_id").toString();
		ListVO lvo=new ListVO("", clientId);
		List<List<ClassList>> reviewList=new ArrayList<List<ClassList>>();
		List<String> reviewStatus=new ArrayList<String>();
		List<String> lcodeList=null;
		int toDate=0;
		int fromDate=0;
		if(!(request.getParameter("toDate")==null)) {
			toDate=Integer.parseInt(request.getParameter("toDate").replaceAll("-", ""));
		}
		if(!(request.getParameter("fromDate")==null)) {
			fromDate=Integer.parseInt(request.getParameter("fromDate").replaceAll("-", ""));
		}
		
		int allTotalCount=0;
		int readyTotalCount=0;
		int endTotalCount=0;
		int totalCount=0;
		
		
		lcodeList=ums.lcodeList(clientId);
		if(!(request.getParameter("status")==null)) {
			if(request.getParameter("status").equals("R")) {
				for(int i=0; i<lcodeList.size(); i++) {
					lvo.setLcode(lcodeList.get(i));
					if(ums.reviewStatus(lvo)==null) {
						readyTotalCount++;
					}//end if
				}//end for
				totalCount=readyTotalCount;
			}//end if
			if(request.getParameter("status").equals("E")) {
				for(int i=0; i<lcodeList.size(); i++) {
					lvo.setLcode(lcodeList.get(i));
					if(!(ums.reviewStatus(lvo)==null)) {
						endTotalCount++;
					}//end if
				}//end for
				totalCount=endTotalCount;
			}//end if
		}//end if
		if(request.getParameter("status")==null) {
			for(int i=0; i<lcodeList.size(); i++) {
				allTotalCount++;
			}//end for
			totalCount=allTotalCount;
		}//end if
		
		int pageScale=ums.pageScale(); //한 화면에 보여줄 게시물의 수
		int totalPage=ums.totalPage(totalCount); //총 게시물을 보여주기 위한 총 페이지 수
		if(lpvo.getCurrentPage() == 0) { //web parameter에 값이 없을 때
			lpvo.setCurrentPage(1); //1번부터 조회해야 하므로 1로 설정
		}//end if
		
		int startNum=ums.startNum(lpvo.getCurrentPage());//시작번호
		int endNum=ums.endNum(startNum);//끝번호
		
		if(endNum>lcodeList.size()) {
			endNum=lcodeList.size();
		}//end if
		lpvo.setStartNum(startNum);
		lpvo.setEndNum(endNum);
		
		if(!(request.getParameter("status")==null)) {
			if(request.getParameter("status").equals("R")) {
				for(int i=startNum-1; i<lcodeList.size(); i++) {
					lvo.setLcode(lcodeList.get(i));
					if(!(reviewList.size()>4)) {
						if(ums.reviewStatus(lvo)==null) {
							if(!(request.getParameter("toDate")==null)) {
								if(Integer.parseInt(ums.classList(lvo).get(i).getStartDate().replaceAll("-", ""))>=fromDate
										&&Integer.parseInt(ums.classList(lvo).get(i).getEndDate().replaceAll("-", ""))<=toDate ) {
									reviewList.add(ums.classList(lvo));
									reviewStatus.add(ums.reviewStatus(lvo));
								}//end if
							}//end if
							if(request.getParameter("toDate")==null) {
								reviewList.add(ums.classList(lvo));
								reviewStatus.add(ums.reviewStatus(lvo));
							}//end if
						}//end if
					}//end if
				}//end for
			}//end if
			if(request.getParameter("status").equals("E")) {
				for(int i=startNum-1; i<lcodeList.size(); i++) {
					lvo.setLcode(lcodeList.get(i));
					if(!(ums.reviewStatus(lvo)==null)) {
						if(!(reviewList.size()>4)) {
							if(!(request.getParameter("toDate")==null)) {
								if(Integer.parseInt(ums.classList(lvo).get(i).getStartDate().replaceAll("-", ""))>=fromDate
										&&Integer.parseInt(ums.classList(lvo).get(i).getEndDate().replaceAll("-", ""))<=toDate ) {
									reviewList.add(ums.classList(lvo));
									reviewStatus.add(ums.reviewStatus(lvo));
								}//end if
							}//end if
							if(request.getParameter("toDate")==null) {
								reviewList.add(ums.classList(lvo));
								reviewStatus.add(ums.reviewStatus(lvo));
							}//end if
						}//end if
					}//end if
				}//end for
			}//end if
		}//end if
		if(request.getParameter("status")==null) {
			for(int i=startNum-1; i<lcodeList.size(); i++) {
				lvo.setLcode(lcodeList.get(i));
				if(!(reviewList.size()>4)) {
					if(!(request.getParameter("toDate")==null)) {
						if(Integer.parseInt(ums.classList(lvo).get(0).getStartDate().replaceAll("-", ""))>=fromDate
								&&Integer.parseInt(ums.classList(lvo).get(0).getEndDate().replaceAll("-", ""))<=toDate ) {
							reviewList.add(ums.classList(lvo));
							reviewStatus.add(ums.reviewStatus(lvo));
						}//end if
					}//end if
					if(request.getParameter("toDate")==null) {
						reviewList.add(ums.classList(lvo));
						reviewStatus.add(ums.reviewStatus(lvo));
					}//end if
				}//end if
			}//end for
		}//end if
		
		String indexList=ums.indexList(lpvo.getCurrentPage(), totalPage, "mypage_assess.do?");
		if( !(request.getParameter("status")==null) ) {
			if(request.getParameter("toDate")==null) {
				indexList=ums.indexList(lpvo.getCurrentPage(), totalPage, "mypage_assess.do?status="+request.getParameter("status")+"&");
			}//end if
			if(!(request.getParameter("toDate")==null)) {
				indexList=ums.indexList(lpvo.getCurrentPage(), totalPage, "mypage_assess.do?status="+request.getParameter("status")
												+"&toDate="+toDate+"&fromDate="+fromDate+"&");
			}//end if
		}//end if
		if( !(request.getParameter("toDate")==null) ) {
			if(request.getParameter("status")==null) {
				indexList=ums.indexList(lpvo.getCurrentPage(), totalPage, "mypage_assess.do?toDate="+request.getParameter("toDate")
											+"&fromDate"+request.getParameter("fromDate")+"&");
			}//end if
			if(!(request.getParameter("status")==null)) {
				indexList=ums.indexList(lpvo.getCurrentPage(), totalPage, "mypage_assess.do?status="+request.getParameter("status")
				+"&toDate="+toDate+"&fromDate="+fromDate+"&");
			}//end if
		}//end if
		
		model.addAttribute("indexList",indexList);
		model.addAttribute("pageScale",pageScale);
		model.addAttribute("totalCount",totalCount);
		model.addAttribute("currentPage",lpvo.getCurrentPage());
		
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("reviewStatus", reviewStatus);
		
		return "user/student/mypage_assess";
	}//useRequest
	
	@ResponseBody
	@RequestMapping(value="user/student/mypage_assessWriter.do", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public String mypage_assessWriter(Model model, HttpSession session, String lcode, String review, String point) {
		int lessonPoint=Integer.parseInt(point);
		//autowired로 의존성 주입//
		String aa="";
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserMypageService ums = ac.getBean(UserMypageService.class);
		String clientId = session.getAttribute("client_id").toString();
		ListVO lvo=new ListVO(lcode, clientId);
		ReviewVO rvo=new ReviewVO(clientId, lcode, review, lessonPoint);
		if( !(ums.reviewStatus(lvo)==null) ) {
		}//end if
		if( (ums.reviewStatus(lvo)==null) ) {
			ums.insertReview(rvo);
			aa="성공";
		}//end if
		
		return aa;
	}//searchDetail
	
	@RequestMapping(value="user/student/mypage_jjim.do", method=GET)
	public String mypageJjim(Model model ,  HttpSession session, HttpServletRequest request, ListPageVO lpvo) {
		//autowired로 의존성 주입//
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserMypageService ums = ac.getBean(UserMypageService.class);
		boolean updateJjim=false;
		String clientId = session.getAttribute("client_id").toString();
		ListVO lvo=new ListVO("", clientId);
		List<List<ClassList>> jjimList=new ArrayList<List<ClassList>>();
		List<String> jjimStatus=new ArrayList<String>();
		List<String> lcodeList=null;
		lcodeList=ums.jjimLcodeList(clientId);
		
		int toDate=0;
		int fromDate=0;
		if(!(request.getParameter("toDate")==null)) {
			toDate=Integer.parseInt(request.getParameter("toDate").replaceAll("-", ""));
		}
		if(!(request.getParameter("fromDate")==null)) {
			fromDate=Integer.parseInt(request.getParameter("fromDate").replaceAll("-", ""));
		}
		
		
		int totalCount=ums.jjimTotalCnt(clientId);
		if(!(request.getParameter("toDate")==null)) {
			totalCount=0;
			for(int i=0; i<lcodeList.size(); i++) {
				lvo.setLcode(lcodeList.get(i));
				if(Integer.parseInt(ums.classList(lvo).get(0).getStartDate().replaceAll("-", ""))>=fromDate
						&&Integer.parseInt(ums.classList(lvo).get(0).getEndDate().replaceAll("-", ""))<=toDate ) {
					totalCount++;
				}//end if
			}//end if
		}//end if
		int pageScale=ums.pageScale(); //한 화면에 보여줄 게시물의 수
		int totalPage=ums.totalPage(totalCount); //총 게시물을 보여주기 위한 총 페이지 수
		if(lpvo.getCurrentPage() == 0) { //web parameter에 값이 없을 때
			lpvo.setCurrentPage(1); //1번부터 조회해야 하므로 1로 설정
		}//end if
		
		int startNum=ums.startNum(lpvo.getCurrentPage());//시작번호
		int endNum=ums.endNum(startNum);//끝번호
		
		if(endNum>lcodeList.size()) {
			endNum=lcodeList.size();
		}//end if
		
		lpvo.setStartNum(startNum);
		lpvo.setEndNum(endNum);
		if(!(request.getParameter("addJjim")==null)) {
			lvo.setLcode(request.getParameter("addJjim"));
			updateJjim=ums.insertJjim(lvo);
		}//end if
		if(!(request.getParameter("cancelJjim")==null)) {
			lvo.setLcode(request.getParameter("cancelJjim"));
			updateJjim=ums.deleteJjim(lvo);
		}//end if
		for(int i=startNum-1; i<endNum; i++) {
			lvo.setLcode(lcodeList.get(i));
			if(!(request.getParameter("toDate")==null)) {
				if(Integer.parseInt(ums.classList(lvo).get(0).getStartDate().replaceAll("-", ""))>=fromDate
						&&Integer.parseInt(ums.classList(lvo).get(0).getEndDate().replaceAll("-", ""))<=toDate ) {
					jjimList.add(ums.classList(lvo));
					jjimStatus.add(ums.jjimStatus(lvo));
				}//end if
			}//end if
			if(request.getParameter("toDate")==null) {
				jjimList.add(ums.classList(lvo));
				jjimStatus.add(ums.jjimStatus(lvo));
			}//end if
		}//end for
		
		
		String indexList=ums.indexList(lpvo.getCurrentPage(), totalPage, "mypage_jjim.do?");
		if(!(request.getParameter("toDate")==null)) {
			indexList=ums.indexList(lpvo.getCurrentPage(), totalPage, "mypage_jjim.do?toDate="
										+request.getParameter("toDate")
										+"&fromDate"+request.getParameter("fromDate")+"&");
		}//end if
		
		model.addAttribute("indexList",indexList);
		model.addAttribute("pageScale",pageScale);
		model.addAttribute("totalCount",totalCount);
		model.addAttribute("currentPage",lpvo.getCurrentPage());
		
		model.addAttribute("jjimList", jjimList);
		model.addAttribute("jjimStatus", jjimStatus);
		model.addAttribute("updateJjim", updateJjim);
		return "user/student/mypage_jjim";
	}//useRequest
	
	@ResponseBody
	@RequestMapping(value="user/student/jjimHeart.do", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public String jjimHeart(Model model, HttpSession session, String lcode) {
		//autowired로 의존성 주입//
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserMypageService ums = ac.getBean(UserMypageService.class);
		String clientId = session.getAttribute("client_id").toString();
		boolean updateJjim = false;
		ListVO lvo=new ListVO(lcode, clientId);
		String jjim="";
		String status=ums.jjimStatus(lvo);
		if( !(status==null) ) {
			updateJjim=ums.deleteJjim(lvo);
			if(updateJjim) {
				jjim="♡";
			}//end if
		}//end if
		if( status==null ) {
			updateJjim=ums.insertJjim(lvo);
			if(updateJjim) {
				jjim="♥";
			}//end if
		}//end if
		return jjim;
	}//searchDetail
	@RequestMapping(value="user/student/mypage_cancel.do", method=GET)
	public String mypageCancel(Model model, HttpSession session, ListPageVO lpvo, HttpServletRequest request) {
		//autowired로 의존성 주입//
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserMypageService ums = ac.getBean(UserMypageService.class);
		String clientId = session.getAttribute("client_id").toString();
		ListVO lvo=new ListVO("", clientId);
		List<List<CancelList>> cancelList=new ArrayList<List<CancelList>>();
		List<String> lcodeList=null;
		lcodeList=ums.cancelLcodeList(clientId);
		
		int toDate=0;
		int fromDate=0;
		if(!(request.getParameter("toDate")==null)) {
			toDate=Integer.parseInt(request.getParameter("toDate").replaceAll("-", ""));
		}//end if
		if(!(request.getParameter("fromDate")==null)) {
			fromDate=Integer.parseInt(request.getParameter("fromDate").replaceAll("-", ""));
		}//end if
		
		int totalCount=ums.cancelTotalCnt(clientId);
		if(!(request.getParameter("toDate")==null)) {
			totalCount=0;
			for(int i=0; i<lcodeList.size(); i++) {
				lvo.setLcode(lcodeList.get(i));
				if(Integer.parseInt(ums.cancelList(lvo).get(0).getStartDate().replaceAll("-", ""))>=fromDate
						&&Integer.parseInt(ums.cancelList(lvo).get(0).getEndDate().replaceAll("-", ""))<=toDate ) {
					totalCount++;
				}//end if
			}//end if
		}//end if
		
		int pageScale=ums.pageScale(); //한 화면에 보여줄 게시물의 수
		int totalPage=ums.totalPage(totalCount); //총 게시물을 보여주기 위한 총 페이지 수
		if(lpvo.getCurrentPage() == 0) { //web parameter에 값이 없을 때
			lpvo.setCurrentPage(1); //1번부터 조회해야 하므로 1로 설정
		}//end if
		
		int startNum=ums.startNum(lpvo.getCurrentPage());//시작번호
		int endNum=ums.endNum(startNum);//끝번호
		
		if(endNum>lcodeList.size()) {
			endNum=lcodeList.size();
		}//end if
		
		lpvo.setStartNum(startNum);
		lpvo.setEndNum(endNum);
		
		for(int i=startNum-1; i<endNum; i++) {
			lvo.setLcode(lcodeList.get(i));
			if(!(request.getParameter("toDate")==null)) {
				if(Integer.parseInt(ums.cancelList(lvo).get(0).getStartDate().replaceAll("-", ""))>=fromDate
						&&Integer.parseInt(ums.cancelList(lvo).get(0).getEndDate().replaceAll("-", ""))<=toDate ) {
					cancelList.add(ums.cancelList(lvo));
				}//end if
			}//end if
			if(request.getParameter("toDate")==null) {
				cancelList.add(ums.cancelList(lvo));
			}//end if
		}//end for
		
		String indexList=ums.indexList(lpvo.getCurrentPage(), totalPage, "mypage_cancel.do?");
		
		if(!(request.getParameter("toDate")==null)) {
			indexList=ums.indexList(lpvo.getCurrentPage(), totalPage, "mypage_cancel.do?toDate="
										+request.getParameter("toDate")
										+"&fromDate"+request.getParameter("fromDate")+"&");
		}//end if
		
		model.addAttribute("indexList",indexList);
		model.addAttribute("pageScale",pageScale);
		model.addAttribute("totalCount",totalCount);
		model.addAttribute("currentPage",lpvo.getCurrentPage());
		
		model.addAttribute("cancelList", cancelList);
		
		return "user/student/mypage_cancel";
	}//useRequest
	
	
	@RequestMapping(value="user/student/mypage_q&a.do", method=GET)
	public String mypageQA(Model model, HttpSession session, ListPageVO lpvo, HttpServletRequest request) {
		//autowired로 의존성 주입//
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserMypageService ums = ac.getBean(UserMypageService.class);
		String clientId = session.getAttribute("client_id").toString();
		ListVO lvo=new ListVO("", clientId);
		List<List<QnaList>> qnaList=new ArrayList<List<QnaList>>();
		List<String> lcodeList=null;
		lcodeList=ums.qnaLcodeList(clientId);
		
		int toDate=0;
		int fromDate=0;
		if(!(request.getParameter("toDate")==null)) {
			toDate=Integer.parseInt(request.getParameter("toDate").replaceAll("-", ""));
		}//end if
		if(!(request.getParameter("fromDate")==null)) {
			fromDate=Integer.parseInt(request.getParameter("fromDate").replaceAll("-", ""));
		}//end if
		
		QnaStatusVO qsvo=new QnaStatusVO(clientId, "");
		int totalCount=ums.qnaTotalCnt(clientId);
		if(!(request.getParameter("toDate")==null)) {
			totalCount=0;
			for(int i=0; i<lcodeList.size(); i++) {
				lvo.setLcode(lcodeList.get(i));
				if(Integer.parseInt(ums.qnaList(lvo).get(0).getqDate().replaceAll("-", "").substring(0,8))>=fromDate
						&&Integer.parseInt(ums.qnaList(lvo).get(0).getqDate().replaceAll("-", "").substring(0,8))<=toDate ) {
					totalCount++;
				}//end if
			}//end if
		}//end if
		if(!(request.getParameter("status")==null)) {
			qsvo.setStatus(request.getParameter("status"));
			totalCount=ums.qnaStatusCnt(qsvo);
		}//end if
		
		int pageScale=ums.pageScale(); //한 화면에 보여줄 게시물의 수
		int totalPage=ums.totalPage(totalCount); //총 게시물을 보여주기 위한 총 페이지 수
		if(lpvo.getCurrentPage() == 0) { //web parameter에 값이 없을 때
			lpvo.setCurrentPage(1); //1번부터 조회해야 하므로 1로 설정
		}//end if
		
		int startNum=ums.startNum(lpvo.getCurrentPage());//시작번호
		int endNum=ums.endNum(startNum);//끝번호
		
		if(endNum>lcodeList.size()) {
			endNum=lcodeList.size();
		}//end if
		
		lpvo.setStartNum(startNum);
		lpvo.setEndNum(endNum);
		
		if(request.getParameter("status")==null){
			for(int i=startNum-1; i<endNum; i++) {
				lvo.setLcode(lcodeList.get(i));
				if(!(request.getParameter("toDate")==null)) {
					if(Integer.parseInt(ums.qnaList(lvo).get(0).getqDate().replaceAll("-", "").substring(0,8))>=fromDate
							&&Integer.parseInt(ums.qnaList(lvo).get(0).getqDate().replaceAll("-", "").substring(0,8))<=toDate ) {
						qnaList.add(ums.qnaList(lvo));
					}//end if
				}//end if
				if(request.getParameter("toDate")==null) {
					qnaList.add(ums.qnaList(lvo));
				}//end if
			}//end for
		}//end if
		if(!(request.getParameter("status")==null)) {
			for(int i=startNum-1; i<endNum; i++) {
				lvo.setLcode(lcodeList.get(i));
				if(request.getParameter("status").equals("Y")) {
					if(ums.qnaList(lvo).get(i).getStatus().equals("Y")) {
						if(!(request.getParameter("toDate")==null)) {
							if(Integer.parseInt(ums.qnaList(lvo).get(0).getqDate().replaceAll("-", "").substring(0,8))>=fromDate
									&&Integer.parseInt(ums.qnaList(lvo).get(0).getqDate().replaceAll("-", "").substring(0,8))<=toDate ) {
								qnaList.add(ums.qnaList(lvo));
							}//end if
						}//end if
						if(request.getParameter("toDate")==null) {
							qnaList.add(ums.qnaList(lvo));
						}//end if
					}//end if
				}//end if
				if(request.getParameter("status").equals("N")) {
					if(ums.qnaList(lvo).get(i).getStatus().equals("N")) {
						if(!(request.getParameter("toDate")==null)) {
							if(Integer.parseInt(ums.qnaList(lvo).get(0).getqDate().replaceAll("-", "").substring(0,8))>=fromDate
									&&Integer.parseInt(ums.qnaList(lvo).get(0).getqDate().replaceAll("-", "").substring(0,8))<=toDate ) {
								qnaList.add(ums.qnaList(lvo));
							}//end if
						}//end if
						if(request.getParameter("toDate")==null) {
							qnaList.add(ums.qnaList(lvo));
						}//end if
					}//end if
				}//end if
			}//end for
		}//end if
		
		String indexList=ums.indexList(lpvo.getCurrentPage(), totalPage, "mypage_q&a.do?");
		
		if( !(request.getParameter("status")==null) ) {
			if(request.getParameter("toDate")==null) {
				indexList=ums.indexList(lpvo.getCurrentPage(), totalPage, "mypage_q&a.do?status="+request.getParameter("status")+"&");
			}//end if
			if(!(request.getParameter("toDate")==null)) {
				indexList=ums.indexList(lpvo.getCurrentPage(), totalPage, "mypage_q&a.do?status="+request.getParameter("status")
												+"&toDate="+toDate+"&fromDate="+fromDate+"&");
			}//end if
		}//end if
		if( !(request.getParameter("toDate")==null) ) {
			if(request.getParameter("status")==null) {
				indexList=ums.indexList(lpvo.getCurrentPage(), totalPage, "mypage_q&a.do?toDate="+request.getParameter("toDate")
											+"&fromDate"+request.getParameter("fromDate")+"&");
			}//end if
			if(!(request.getParameter("status")==null)) {
				indexList=ums.indexList(lpvo.getCurrentPage(), totalPage, "mypage_q&a.do?status="+request.getParameter("status")
				+"&toDate="+toDate+"&fromDate="+fromDate+"&");
			}//end if
		}//end if
		
		if(!(request.getParameter("status")==null)) {
			indexList=ums.indexList(lpvo.getCurrentPage(), totalPage, "mypage_q&a.do?status"+request.getParameter("status")+"&");
		}//end if
		
		model.addAttribute("indexList",indexList);
		model.addAttribute("pageScale",pageScale);
		model.addAttribute("totalCount",totalCount);
		model.addAttribute("currentPage",lpvo.getCurrentPage());
		
		model.addAttribute("qnaList", qnaList);
		
		return "user/student/mypage_q&a";
	}//useRequest
	
	@RequestMapping(value="user/student/mypage_report.do", method=GET)
	public String mypageReport(Model model, HttpSession session, ListPageVO lpvo, HttpServletRequest request) {
		//autowired로 의존성 주입//
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserMypageService ums = ac.getBean(UserMypageService.class);
		String clientId = session.getAttribute("client_id").toString();
		ListVO lvo=new ListVO("", clientId);
		List<List<ReportList>> reportList=new ArrayList<List<ReportList>>();
		List<String> lcodeList=null;
		lcodeList=ums.reportLcodeList(clientId);
		
		int toDate=0;
		int fromDate=0;
		if(!(request.getParameter("toDate")==null)) {
			toDate=Integer.parseInt(request.getParameter("toDate").replaceAll("-", ""));
		}//end if
		if(!(request.getParameter("fromDate")==null)) {
			fromDate=Integer.parseInt(request.getParameter("fromDate").replaceAll("-", ""));
		}//end if
		
		ReportStatusVO rsvo=new ReportStatusVO(clientId, "");
		int totalCount=ums.reportTotalCnt(clientId);
		
		if(!(request.getParameter("toDate")==null)) {
			totalCount=0;
			for(int i=0; i<lcodeList.size(); i++) {
				lvo.setLcode(lcodeList.get(i));
				if(Integer.parseInt(ums.reportList(lvo).get(0).getrDate().replaceAll("-", "").substring(0,8))>=fromDate
						&&Integer.parseInt(ums.reportList(lvo).get(0).getrDate().replaceAll("-", "").substring(0,8))<=toDate ) {
					totalCount++;
				}//end if
			}//end if
		}//end if
		
		if(!(request.getParameter("status")==null)) {
			rsvo.setStatus(request.getParameter("status"));
			totalCount=ums.reportStatusCnt(rsvo);
		}//end if
		
		int pageScale=ums.pageScale(); //한 화면에 보여줄 게시물의 수
		int totalPage=ums.totalPage(totalCount); //총 게시물을 보여주기 위한 총 페이지 수
		if(lpvo.getCurrentPage() == 0) { //web parameter에 값이 없을 때
			lpvo.setCurrentPage(1); //1번부터 조회해야 하므로 1로 설정
		}//end if
		
		int startNum=ums.startNum(lpvo.getCurrentPage());//시작번호
		int endNum=ums.endNum(startNum);//끝번호
		
		if(endNum>lcodeList.size()) {
			endNum=lcodeList.size();
		}//end if
		
		lpvo.setStartNum(startNum);
		lpvo.setEndNum(endNum);
		
		
		if(request.getParameter("status")==null){
			for(int i=startNum-1; i<endNum; i++) {
				lvo.setLcode(lcodeList.get(i));
				if(!(request.getParameter("toDate")==null)) {
					if(Integer.parseInt(ums.qnaList(lvo).get(0).getqDate().replaceAll("-", "").substring(0,8))>=fromDate
							&&Integer.parseInt(ums.qnaList(lvo).get(0).getqDate().replaceAll("-", "").substring(0,8))<=toDate ) {
						reportList.add(ums.reportList(lvo));
					}//end if
				}//end if
				if(request.getParameter("toDate")==null) {
					reportList.add(ums.reportList(lvo));
				}//end if
			}//end for
		}//end if
		
		if(!(request.getParameter("status")==null)) {
			for(int i=startNum-1; i<endNum; i++) {
				lvo.setLcode(lcodeList.get(i));
				if(request.getParameter("status").equals("Y")) {
					if(ums.reportList(lvo).get(i).getStatus().equals("Y")) {
						if(!(request.getParameter("toDate")==null)) {
							if(Integer.parseInt(ums.qnaList(lvo).get(0).getqDate().replaceAll("-", "").substring(0,8))>=fromDate
									&&Integer.parseInt(ums.qnaList(lvo).get(0).getqDate().replaceAll("-", "").substring(0,8))<=toDate ) {
								reportList.add(ums.reportList(lvo));
							}//end if
						}//end if
						if(request.getParameter("toDate")==null) {
							reportList.add(ums.reportList(lvo));
						}//end if
					}//end if
				}//end if
				if(request.getParameter("status").equals("N")) {
					if(ums.reportList(lvo).get(i).getStatus().equals("N")) {
						if(!(request.getParameter("toDate")==null)) {
							if(Integer.parseInt(ums.qnaList(lvo).get(0).getqDate().replaceAll("-", "").substring(0,8))>=fromDate
									&&Integer.parseInt(ums.qnaList(lvo).get(0).getqDate().replaceAll("-", "").substring(0,8))<=toDate ) {
								reportList.add(ums.reportList(lvo));
							}//end if
						}//end if
						if(request.getParameter("toDate")==null) {
							reportList.add(ums.reportList(lvo));
						}//end if
					}//end if
				}//end if
			}//end for
		}//end if
		
		String indexList=ums.indexList(lpvo.getCurrentPage(), totalPage, "mypage_report.do?");
		
		if( !(request.getParameter("status")==null) ) {
			if(request.getParameter("toDate")==null) {
				indexList=ums.indexList(lpvo.getCurrentPage(), totalPage, "mypage_report.do?status="+request.getParameter("status")+"&");
			}//end if
			if(!(request.getParameter("toDate")==null)) {
				indexList=ums.indexList(lpvo.getCurrentPage(), totalPage, "mypage_report.do?status="+request.getParameter("status")
												+"&toDate="+toDate+"&fromDate="+fromDate+"&");
			}//end if
		}//end if
		if( !(request.getParameter("toDate")==null) ) {
			if(request.getParameter("status")==null) {
				indexList=ums.indexList(lpvo.getCurrentPage(), totalPage, "mypage_report.do?toDate="+request.getParameter("toDate")
											+"&fromDate"+request.getParameter("fromDate")+"&");
			}//end if
			if(!(request.getParameter("status")==null)) {
				indexList=ums.indexList(lpvo.getCurrentPage(), totalPage, "mypage_report.do?status="+request.getParameter("status")
				+"&toDate="+toDate+"&fromDate="+fromDate+"&");
			}//end if
		}//end if
		
		if(!(request.getParameter("status")==null)) {
			indexList=ums.indexList(lpvo.getCurrentPage(), totalPage, "mypage_report.do?status"+request.getParameter("status")+"&");
		}//end if
		
		model.addAttribute("indexList",indexList);
		model.addAttribute("pageScale",pageScale);
		model.addAttribute("totalCount",totalCount);
		model.addAttribute("currentPage",lpvo.getCurrentPage());
		
		model.addAttribute("reportList", reportList);
		
		return "user/student/mypage_report";
	}//useRequest
}//class
