package kr.co.sist.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.user.domain.LectureView;
import kr.co.sist.user.domain.Question;
import kr.co.sist.user.domain.Review;
import kr.co.sist.user.domain.StatusCnt;
import kr.co.sist.user.service.UserLectureService;
import kr.co.sist.user.service.UserQuestionService;
import kr.co.sist.user.service.UserReviewService;
import kr.co.sist.user.vo.ListPageVO;
@Controller
public class TeacherController {
	
	@RequestMapping(value="user/teacher/classStatus.do", method=GET)
	public String classStatusForm(@RequestParam(value="status", required=false) String status, HttpSession session, Model model) {
		//session�뿉�꽌 �븘�씠�뵒�� �씠由꾩쓣 媛��졇�삩�떎
		String id = "";	
		String teacherName = "";
		id = (String)session.getAttribute("client_id");
		teacherName = (String)session.getAttribute("name");
		
		//autowired
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserLectureService uls = ac.getBean(UserLectureService.class);
		
		if (id != null) {	
		//id�� status濡� �겢�옒�뒪 �쁽�솴�쓣 媛��졇�삩�떎
		List<LectureView> list = uls.searchLectureInfo(id, status);
		
		//�븘�씠�뵒濡� �씠由꾩쓣 媛��졇�삩�떎.
		//�븘�씠�뵒�떦 �뿬�윭媛쒖쓽 �봽濡쒗븘�쓣 �궗�슜�븷 �닔 �엳�쑝誘�濡�, List�뿉 �떞�뒗�떎.
		List<String> tn_list = uls.searchTeacherName(id);
		
		//�씠由꾩쑝濡� �긽�깭蹂� 移댁슫�듃瑜� �뱾怨좎삩�떎.
		Map<String, Object> r_cnt_list = uls.searchStatusCnt(tn_list);
		
		model.addAttribute("l_list", list);
		model.addAttribute("cntList", r_cnt_list);

		return "user/teacher/classStatus";
      }else {
          return "user/member/login";		
      } // end else
	} //classStatusForm
	

	@ResponseBody
	@RequestMapping(value="user/teacher/apply_peoples.do", method=RequestMethod.GET)
	public List<LectureView> LecturePeoplesForm(@RequestParam(value="classCode") String code) {

		//autowired
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserLectureService uls = ac.getBean(UserLectureService.class);
		
		//�겢�옒�뒪蹂� �떊泥��쁽�솴�쓣 媛��졇�삩�떎
		List<LectureView> s_list = uls.searchStudentsList(code);
		
		return s_list;
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
	public Map<String, Object> classReviewForm(HttpSession session, Model model, ListPageVO lpvo, 
			@RequestParam(value="fromDate", required=false) String fromDate, @RequestParam(value="toDate", required=false) String toDate) {
		//autowired
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserReviewService urs = ac.getBean(UserReviewService.class);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		String id = "";	
		id = (String)session.getAttribute("client_id");
		
		List<String> tn_list = urs.searchTeacherName(id); // id濡� �씠由꾩쓣 �뱾怨좎삩�떎
		
		List<Review> r_list = new ArrayList<Review>();
		int cnt = 0;
		
		//諛쏆븘�삩 �씠由� �닔留뚰겮 諛섎났
		for(int i = 0; i < tn_list.size(); i++) {
			Map<String, String> dateMap = new HashMap<String, String>();
			dateMap.put("fromDate", fromDate);
			dateMap.put("toDate", toDate);
			dateMap.put("tn_list", tn_list.get(i));
			
			//寃��깋媛믪쓣 �떞�� map�쓣 �꽆湲대떎
			List<Review> tmpList = urs.searchReview(dateMap);
			if (!tmpList.isEmpty()) { //tmpList媛� 鍮� 媛믪씠 �븘�땲�씪硫� 吏꾩엯
				r_list.addAll(tmpList); // r_list�뿉 add
				cnt += urs.searchReviewCnt(dateMap);	//由щ럭 移댁슫�듃 援ы븯湲�
			} // end if
		} // end for
		
		//Paging
		int pageScale = urs.pageScale(); // 占쏙옙 화占썽에 占쏙옙占쏙옙占쏙옙 占쌉시뱄옙占쏙옙 占쏙옙
		int totalPage=urs.totalPage(cnt); //占쏙옙 占쌉시뱄옙占쏙옙 占쏙옙占쏙옙占쌍깍옙 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙
		if(lpvo.getCurrentPage() == 0) { //web parameter占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙
			lpvo.setCurrentPage(1); //1占쏙옙占쏙옙占쏙옙 占쏙옙회占쌔억옙 占싹므뤄옙 1占쏙옙 占쏙옙占쏙옙
		}//end if
		
		int startNum = urs.startNum(lpvo.getCurrentPage());// 占쏙옙占쌜뱄옙호
		int endNum = urs.endNum(startNum);//占쏙옙占쏙옙호
		
		lpvo.setStartNum(startNum);
		lpvo.setEndNum(endNum);
		
		String indexList=urs.indexList(lpvo.getCurrentPage(), totalPage, "classReview.do");
		
		map.put("r_list", r_list);
		map.put("cnt", cnt);
		map.put("indexList", indexList);
		
		return map;
	} // classReviewForm
	
	@ResponseBody
	@RequestMapping(value="user/teacher/review_detail.do", method=GET)
	public Review selectOneReview(@RequestParam(value="clientId") String clientId, @RequestParam(value="lcode")String lcode){
		//autowired
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserReviewService urs = ac.getBean(UserReviewService.class);
		
		Review review = urs.searchReviewDetail(clientId, lcode);
		
		return review;
	} //selectOneReview
	
	@RequestMapping(value="user/teacher/qna.do", method=GET)
	public Map<String, Object> qnaForm(HttpSession session, Model model,
		@RequestParam(value="fromDate", required=false) String fromDate, @RequestParam(value="toDate", required=false) String toDate) {
		
		//autowired
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserQuestionService uqs = ac.getBean(UserQuestionService.class);
		
		Map<String, Object> map = new HashMap<String, Object>();
			
		String id = "";	
		id = (String)session.getAttribute("client_id");
		
		List<String> tn_list = uqs.searchTeacherName(id); // id濡� �씠由꾨뱾�쓣 媛��졇�삩�떎
		
		List<Question> q_list = new ArrayList<Question>();
		int cnt = 0;	//移댁슫�듃瑜� �떞�쓣 蹂��닔 珥덇린�솕
		
		//teacherName�닔留뚰겮 諛섎났
		for(int i = 0; i < tn_list.size(); i++) {	
			Map<String, String> dateMap = new HashMap<String, String>();
			dateMap.put("fromDate", fromDate);
			dateMap.put("toDate", toDate);
			dateMap.put("tn_list", tn_list.get(i));
			
			//寃��깋 議곌굔媛믪쓣 �떞�� map�쓣 蹂대궡�꽌 �빐�떦�븯�뒗 吏덈Ц湲� 由ъ뒪�듃瑜� 媛��졇�삩�떎
			List<Question> tmpList = uqs.searchQuestion(dateMap);
			
			//諛쏆븘�삩 �뜲�씠�꽣媛� 議댁옱�븯硫� 吏꾩엯
			if (!tmpList.isEmpty()) { 
				q_list.addAll(tmpList);
				cnt += uqs.searchQuestionCnt(dateMap);
			} // end if
		} // end for

		model.addAttribute("q_list", q_list);
		model.addAttribute("cntList", cnt);		
		
		map.put("q_list", q_list);
		map.put("cntList", cnt);
		
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="user/teacher/question_detail.do", method=GET)
	public Question selectOneQuestion(@RequestParam(value="qcode") String qcode){
		//autowired
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		UserQuestionService uqs = ac.getBean(UserQuestionService.class);
		
		Question question = uqs.searchQuestionDetail(qcode);
		
		return question;
	} //selectOneReview	
	
	@RequestMapping(value="user/teacher/adminQuestion.do", method=GET)
	public String adminQuestionForm() {
		
		return "user/teacher/adminQuestion";
	}
	
} // class
