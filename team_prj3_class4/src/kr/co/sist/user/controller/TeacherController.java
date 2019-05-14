package kr.co.sist.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;

import org.json.simple.JSONObject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.sist.user.domain.LectureView;
import kr.co.sist.user.domain.Question;
import kr.co.sist.user.domain.Review;

import kr.co.sist.user.domain.TeacherInfo;

import kr.co.sist.user.domain.StatusCnt;
import kr.co.sist.user.service.ClassRegistService;

import kr.co.sist.user.service.UserLectureService;
import kr.co.sist.user.service.UserQuestionService;
import kr.co.sist.user.service.UserReviewService;
import kr.co.sist.user.service.UserTeacherService;
import kr.co.sist.user.vo.ListPageVO;
import kr.co.sist.user.vo.QuestionReplyVO;

@Controller
public class TeacherController {

	@Autowired
	private UserLectureService uls;
	private UserReviewService urs;
	private UserQuestionService uqs;

	@RequestMapping(value = "user/teacher/classStatus.do", method = GET)
	public String classStatusForm(@RequestParam(value = "status", required = false) String status, HttpSession session,
			Model model, ListPageVO lpvo, @RequestParam(value = "searchOption", required = false) String option,
			@RequestParam(value = "keyword", required = false) String keyword) {

		// session�뿉�꽌 �븘�씠�뵒�� �씠由꾩쓣 媛��졇�삩�떎
		String id = (String) session.getAttribute("client_id");
		String teacherName = (String) session.getAttribute("name");

		// autowired
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserLectureService uls = ac.getBean(UserLectureService.class);

		if (id != null) {

			List<String> tn_list = uls.searchTeacherName(id);

			// class status check
			for (int i = 0; i < tn_list.size(); i++) {
				uls.checkClassStatus(tn_list.get(i));
			} // end for

//////////////////////////////////////////////////////////////////////////페이징/////////////////////////////////////////////////////////////////////////////////
			if (lpvo.getCurrentPage() == 0) { // web parameter
				lpvo.setCurrentPage(1);
			} // end if
			
			int startNum = uls.startNum(lpvo.getCurrentPage());
			int endNum   = uls.endNum(startNum);
			lpvo.setStartNum(startNum);
			lpvo.setEndNum(endNum);
//////////////////////////////////////////////////////////////////////////페이징/////////////////////////////////////////////////////////////////////////////////
		
			if (status == null) {
				status = "All";
			}
			// 게시글 구하기
			List<LectureView> list = uls.searchLectureInfo(id, status, lpvo);
			int totalCount = uls.totalCount(id, status, lpvo);	//전체 게시글 수
			int pageScale  = uls.pageScale();			//한 페이지당 보여질 게시글 수
			int totalPage  = uls.totalPage(totalCount);	//총 페이지 수
			String indexList = uls.indexList(lpvo.getCurrentPage(), totalPage, "classStatus.do?status="+status);
			
			//신청 인원 구하기
			List<LectureView> applyCnt = uls.selectClassApplyCnt();
			
			// 상태값 별 게시글 카운트 구하기
			Map<String, Object> r_cnt_list = uls.searchStatusCnt(tn_list);

			model.addAttribute("l_list", list);
			model.addAttribute("applyCnt", applyCnt);
			model.addAttribute("cntList", r_cnt_list);
			model.addAttribute("indexList", indexList);
			model.addAttribute("pageScale", pageScale);
			model.addAttribute("totalCount", totalCount);
			model.addAttribute("currentPage", lpvo.getCurrentPage());

			return "user/teacher/classStatus";
			
		} else {
			return "user/member/login";
		} // end else
	} // classStatusForm
	
	@ResponseBody
	@RequestMapping(value = "user/teacher/changeOpenClass.do", method = RequestMethod.GET)
	public int changeOpenClassStatus(@RequestParam(value = "lcode") String lcode) {
		// autowired
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserLectureService uls = ac.getBean(UserLectureService.class);
		
		//서비스 호출
		int result = 0;
		result = uls.changeOpenClass(lcode);
		
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "user/teacher/apply_peoples.do", method = RequestMethod.GET)
	public List<LectureView> LecturePeoplesForm(@RequestParam(value = "classCode") String code) {

		// autowired
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserLectureService uls = ac.getBean(UserLectureService.class);

		// �겢�옒�뒪蹂� �떊泥��쁽�솴�쓣 媛��졇�삩�떎
		List<LectureView> s_list = uls.searchStudentsList(code);

		return s_list;
	}

	@RequestMapping(value="user/teacher/classRegist.do", method=GET)
	public String classRegistForm( HttpSession session, Model model ) {
		String id = (String)session.getAttribute("client_id");
		
		//autowired
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		ClassRegistService crs = ac.getBean(ClassRegistService.class);
		
		List<String> c_list = crs.searchCategorys();
		List<String> t_list = crs.searchTeacherName(id);
		
		model.addAttribute("c_list", c_list);
		model.addAttribute("t_list", t_list);

		return "user/teacher/classRegist";
	}

	//ajax로 회원상세보기
	@ResponseBody
	@RequestMapping(value="user/teacher/subCategorys.do",method=POST)
	public String memberDetailPage(String category) {
		JSONObject json = null;
		
		//autowired
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		ClassRegistService crs = ac.getBean(ClassRegistService.class);
		json = crs.searchSubCategorys(category);
		//System.out.println(json.toJSONString());
			
		return json.toJSONString();
	}
	
	@RequestMapping(value="user/teacher/addClass_process.do", method=POST)
	public String addClassProcess( HttpServletRequest request ) {
		//autowired
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		ClassRegistService crs = ac.getBean(ClassRegistService.class);
		
		try {
			crs.addLesson(request);//
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "redirect:classStatus.do";
	}
	
	
	@RequestMapping(value = "user/teacher/teacherProfile.do", method = GET)
	public String teacherProfileForm(HttpSession session, Model model, ListPageVO lpvo) {
		String id = (String) session.getAttribute("client_id");

		// autowired
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserTeacherService uts = ac.getBean(UserTeacherService.class);

		//////////////////////////////////////////////////////////////////////////페이징/////////////////////////////////////////////////////////////////////////////////
		if (lpvo.getCurrentPage() == 0) { // web parameter
		lpvo.setCurrentPage(1);
		} // end if
		
		int startNum = uts.startNum(lpvo.getCurrentPage());
		int endNum   = uts.endNum(startNum);
		lpvo.setStartNum(startNum);
		lpvo.setEndNum(endNum);
		//////////////////////////////////////////////////////////////////////////페이징/////////////////////////////////////////////////////////////////////////////////
		
		// 프로필 가져오기
		List<String> list = uts.searchTeacherProfile(id, lpvo);
		
		int totalCount = uts.totalCount(id, lpvo);	//전체 게시글 수
		int pageScale  = uts.pageScale();			//한 페이지당 보여질 게시글 수
		int totalPage  = uts.totalPage(totalCount);	//총 페이지 수
		String indexList = uts.indexList(lpvo.getCurrentPage(), totalPage, "teacherProfile.do");
		
		System.out.println("totalCount : " + totalCount);
		System.out.println("pageScale : " + pageScale);
		System.out.println("totalPage : " + totalPage);
		System.out.println("startNum : " + startNum);
		System.out.println("endNum : " + endNum);
		
		
		// 상태값 별 게시글 카운트 구하기
//		Map<String, Object> r_cnt_list = uls.searchStatusCnt(tn_list);
		
		model.addAttribute("l_list", list);
//		model.addAttribute("cntList", r_cnt_list);
		model.addAttribute("indexList", indexList);
		model.addAttribute("pageScale", pageScale);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", lpvo.getCurrentPage());




		model.addAttribute("profileList", list);

		return "user/teacher/teacherProfile";
	}

	@ResponseBody
	@RequestMapping(value = "user/teacher/check_teacherName.do", method = GET)
	public int checkTeacherName(@RequestParam(value = "checkName", required = false) String checkName) {
		// autowired
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserTeacherService uts = ac.getBean(UserTeacherService.class);

		int result = uts.searchTeacherName(checkName);

		return result;
	} // checkTeacherName

	@ResponseBody
	@RequestMapping(value = "user/teacher/get_category.do", method = GET)
	public List<String> teacherCategoryForm(Model model) {
		// autowired
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserTeacherService uts = ac.getBean(UserTeacherService.class);

		List<String> list = uts.searchTeacherCategory();

		return list;
	} // teacherCategoryForm

	@ResponseBody
	@RequestMapping(value = "user/teacher/teacher_detail.do", method = GET)
	public Map<String, Object> teacherDetail(@RequestParam(value = "teacherName") String teacherName, Model model) {
		// autowired
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserTeacherService uts = ac.getBean(UserTeacherService.class);

		Map<String, Object> resultMap = new HashMap<String, Object>();

		// teacherInfo 가져오기
		TeacherInfo list = uts.searchTeacherDetail(teacherName);

		// teacher career 가져오기
		List<String> c_list = uts.searchCareer(teacherName);

		resultMap.put("c_list", c_list);
		resultMap.put("list", list);

		return resultMap;
	} // teacherDetail

	@RequestMapping(value = "user/teacher/add_teacher.do", method = POST)
	public void addTeacherProfile(HttpServletRequest request, HttpServletResponse response, Model model,
			HttpSession session) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserTeacherService uts = ac.getBean(UserTeacherService.class);

		String id = (String) session.getAttribute("client_id");

		try {
			uts.addTeacher(request, id);
			response.sendRedirect("/team_prj3_class4/user/teacher/teacherProfile.do");
		} catch (IOException e) {
			e.printStackTrace();
		} // catch

//		return "user/teacher/teacherProfile";
	} // addTeacherProfile

	@ResponseBody
	@RequestMapping(value = "user/teacher/modify_teacherStatus.do", method = GET)
	public int modifyTeacherStatus(@RequestParam(value = "teacherName", required = false) String teacherName) {
		// autowired
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserTeacherService uts = ac.getBean(UserTeacherService.class);

		int modify = uts.searchLessonStatus(teacherName);
		return modify;

	} // modifyTeacherStatus

	@RequestMapping(value = "user/teacher/classReview.do", method = GET)
	public Map<String, Object> classReviewForm(HttpSession session, Model model, ListPageVO lpvo,
			@RequestParam(value = "fromDate", required = false) String fromDate,
			@RequestParam(value = "toDate", required = false) String toDate) {
		// autowired
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserReviewService urs = ac.getBean(UserReviewService.class);

		Map<String, Object> map = new HashMap<String, Object>();

		String id = "";
		id = (String) session.getAttribute("client_id");

		List<String> tn_list = urs.searchTeacherName(id); // id濡� �씠由꾩쓣 �뱾怨좎삩�떎

//////////////////////////////////////////////////////////////////////////페이징/////////////////////////////////////////////////////////////////////////////////
		if (lpvo.getCurrentPage() == 0) { // web parameter
		lpvo.setCurrentPage(1);
		} // end if
		
		int startNum = urs.startNum(lpvo.getCurrentPage());
		int endNum   = urs.endNum(startNum);
		lpvo.setStartNum(startNum);
		lpvo.setEndNum(endNum);
//////////////////////////////////////////////////////////////////////////페이징/////////////////////////////////////////////////////////////////////////////////

		int totalCount = urs.totalCount(id, lpvo, fromDate, toDate);	//전체 게시글 수
		int pageScale  = urs.pageScale();			//한 페이지당 보여질 게시글 수
		int totalPage  = urs.totalPage(totalCount);	//총 페이지 수
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("fromDate", fromDate);
		param.put("toDate", toDate);
		param.put("nameList", tn_list);
		param.put("lpvo", lpvo);
		
		// 게시글 구하기
		List<Review> list = urs.searchReview(param);
		String paramStr = "classReview.do";
		if (fromDate != null || toDate != null) {
			paramStr += "?fromDate="+fromDate+"&toDate="+toDate;
		}
		
		String indexList = urs.indexList(lpvo.getCurrentPage(), totalPage, paramStr);
		
		map.put("r_list", list);
		map.put("indexList", indexList);
		map.put("pageScale", pageScale);
		map.put("totalCount", totalCount);
		map.put("currentPage", lpvo.getCurrentPage());

		return map;
	} // classReviewForm

	@ResponseBody
	@RequestMapping(value = "user/teacher/review_detail.do", method = GET)
	public Review selectOneReview(@RequestParam(value = "clientId") String clientId,
			@RequestParam(value = "lcode") String lcode) {
		// autowired
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserReviewService urs = ac.getBean(UserReviewService.class);

		Review review = urs.searchReviewDetail(clientId, lcode);

		return review;
	} // selectOneReview

	@RequestMapping(value = "user/teacher/qna.do", method = GET)
	public Map<String, Object> qnaForm(HttpSession session, Model model, ListPageVO lpvo,
			@RequestParam(value = "fromDate", required = false) String fromDate,
			@RequestParam(value = "toDate", required = false) String toDate) {

		// autowired
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserQuestionService uqs = ac.getBean(UserQuestionService.class);

		Map<String, Object> map = new HashMap<String, Object>();

		String id = "";
		id = (String) session.getAttribute("client_id");

		List<String> tn_list = uqs.searchTeacherName(id); // id濡� �씠由꾨뱾�쓣 媛��졇�삩�떎
		
		//////////////////////////////////////////////////////////////////////////페이징/////////////////////////////////////////////////////////////////////////////////
		if (lpvo.getCurrentPage() == 0) { // web parameter
		lpvo.setCurrentPage(1);
		} // end if
		
		int startNum = uqs.startNum(lpvo.getCurrentPage());
		int endNum   = uqs.endNum(startNum);
		lpvo.setStartNum(startNum);
		lpvo.setEndNum(endNum);
		//////////////////////////////////////////////////////////////////////////페이징/////////////////////////////////////////////////////////////////////////////////
		
		int totalCount = uqs.totalCount(id, lpvo, fromDate, toDate);	//전체 게시글 수
		int pageScale  = uqs.pageScale();			//한 페이지당 보여질 게시글 수
		int totalPage  = uqs.totalPage(totalCount);	//총 페이지 수
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("fromDate", fromDate);
		param.put("toDate", toDate);
		param.put("nameList", tn_list);
		param.put("lpvo", lpvo);
		
		System.out.println("totalCount : " + totalCount);
		System.out.println("pageScale : " + pageScale);
		System.out.println("totalPage : " + totalPage);
		System.out.println("startNum : " + startNum);
		System.out.println("endNum : " + endNum);
		
		
		// 게시글 구하기
		List<Question> list = uqs.searchQuestion(param);
		String paramStr = "qna.do";
		if (fromDate != null || toDate != null) {
			paramStr += "?fromDate="+fromDate+"&toDate="+toDate;
		}
		
		String indexList = uqs.indexList(lpvo.getCurrentPage(), totalPage, paramStr);
		
		map.put("r_list", list);
		map.put("indexList", indexList);
		map.put("pageScale", pageScale);
		map.put("totalCount", totalCount);
		map.put("currentPage", lpvo.getCurrentPage());
		map.put("q_list", list);

		return map;
	} // qnaForm

	@ResponseBody
	@RequestMapping(value = "user/teacher/question_detail.do", method = GET)
	public Question selectOneQuestion(@RequestParam(value = "qcode") String qcode) {
		// autowired
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserQuestionService uqs = ac.getBean(UserQuestionService.class);

		Question question = uqs.searchQuestionDetail(qcode);

		return question;
	} // selectOneReview

	@ResponseBody
	@RequestMapping(value = "user/teacher/question_reply.do", method = GET)
	public int questionReply(@RequestParam(value = "qcode", required = false) String qcode,
			@RequestParam(value = "aContents", required = false) String aContents) {
		// autowired
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserQuestionService uqs = ac.getBean(UserQuestionService.class);

		QuestionReplyVO qrvo = new QuestionReplyVO();
		qrvo.setQcode(qcode);
		qrvo.setaContents(aContents);

		int reply = uqs.modifyQuestionReply(qrvo);
		System.out.println(reply);
		return reply;

	} // questionReply

	@RequestMapping(value = "user/teacher/adminQuestion.do", method = GET)
	public String adminQuestionForm() {

		return "user/teacher/adminQuestion";
	} // adminQuestion

} // class
