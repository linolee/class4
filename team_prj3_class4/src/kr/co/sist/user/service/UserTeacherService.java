package kr.co.sist.user.service;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.sist.user.dao.UserLectureQuestionDAO;
import kr.co.sist.user.dao.UserTeacherDAO;
import kr.co.sist.user.domain.TeacherInfo;
import kr.co.sist.user.vo.AddTeacherVO;
import kr.co.sist.user.vo.CareerVO;
import kr.co.sist.user.vo.ListPageVO;
import kr.co.sist.user.vo.QuestionReplyVO;

@Component
public class UserTeacherService {
	@Autowired
	private UserTeacherDAO ut_dao;
	
//////////////////////////////////////////////////////////////////////////페이징/////////////////////////////////////////////////////////////////	
	//1. 총 게시글 수 가져오기
	public int totalCount(String userId, ListPageVO lpvo) {
		int cnt = 0;
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", userId);
		param.put("lpvo", lpvo);
		
		cnt = ut_dao.teacherProfileTotalCnt(param);
		
		return cnt;
	} // totalCount
	
	// 2. 페이지 당 보여질 게시글 수
	public int pageScale() {
		int pageScale = 10;
		
		return pageScale;
	}
	
	// 3. 총 페이지 구하기
	public int totalPage(int totalCount) {
		int totalPage = totalCount / pageScale();
		
		if (totalCount % pageScale() != 0) {
			totalPage++;
		}
	
		return totalPage;
	}
	
	// 4. 시작 페이지 계산
	// +1은 첫페이지가 0이나 10이 아니라 1이나 11로 하기 위함임 1-> 1, 2->11, 3->21 ,,,
	public int startNum(int currentPage) {
		int startNum = 1;
		startNum = currentPage * pageScale() - pageScale() + 1;
		return startNum;
	}
	
	// 5. 끝 페이지 계산
	// -1은 첫페이지가 1이나 11 등과 같을때 1~10, 11~20으로 지정하기 위함임
	public int endNum(int startNum) {
		int endNum = startNum + pageScale() - 1;
		return endNum;
	}
	
	/**
	* �ε��� ����Ʈ [ << ] ... [1][2][3] ... [ >> ]
	* 
	* @param current_page
	* @param total_page
	* @param list_url
	* @return
	*/
	public String indexList(int current_page, int total_page, String list_url) {
		int pagenumber; // 페이지 번호
		int startpage; // 시작 페이지
		int endpage; // 마지막 페이지
		int curpage; // 현재 페이지
		
		String strList = "";
		
		pagenumber = 10; // 페이지당 보일 게시글 수
		
		// 시작 페이지 계산
		startpage = ((current_page - 1) / pagenumber) * pagenumber + 1;
		
		// 마지막 페이지 계산
		endpage = (((startpage - 1) + pagenumber) / pagenumber) * pagenumber;
		
		//총 페이지가 마지막페이지보다 작거나 같을 경우,
		//끝 페이지는 마지막 페이지
		if (total_page <= endpage) {
		endpage = total_page;
		} // end if
		
		
		//현재 페이지가 게시글 수보다 클 경우
		if (current_page > pagenumber) {
			curpage = startpage - 1;
			strList = strList + "<li class='page-item'><a class='page-link' href=" + list_url + "?currentPage="
			+ curpage + ">Prev</a></li>";
		} else {
//			strList = strList + "<li class='page-item'><a class='page-link' href='#'>Prev</a></li>";
		}
		
		curpage = startpage;
		
		while (curpage <= endpage) {
			if (curpage == current_page) {
				strList = strList + "<li class='page-item active'><a class='page-link' href='#'>" + current_page + "</a>";
			} else {
				strList = strList + "<li class='page-item'><a class='page-link' href=" + list_url + "?currentPage="
				+ curpage + ">" + curpage + "</a></li>";
			} // end else
		
			curpage++;
		} // end while
		
		if (total_page > endpage) {
			curpage = endpage + 1;
			strList = strList + "<li class='page-item'><a class='page-link' href=" + list_url + "?currentPage="
			+ curpage + ">Next</a></li>";
		} else {
//			strList = strList + "<li class='page-item'><a class='page-link' href='#'>Next</a></li>";
		} // end else
		
		return strList;
	}// indexList

//////////////////////////////////////////////////////////////////////////페이징/////////////////////////////////////////////////////////////////	


	
	public int searchTeacherName(String teacherName) {
		int cnt = ut_dao.selectTeacherName(teacherName);

		return cnt;
		
	} // searchTeacherName
	
	public List<String> searchTeacherCategory(){
		List<String> list = ut_dao.selectTeacherCategory();
		
		return list;
		
	} // searchTeacherCategory
	
	public int addTeacher(HttpServletRequest request, String id) throws IOException {
		int cnt = 0;
		
		MultipartRequest mr = new MultipartRequest(request,
				"C:/Users/owner/git/class4/team_prj3_class4/WebContent/upload/teacher",
				1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
		
		
		AddTeacherVO atvo = new AddTeacherVO();
		atvo.setTeacherName(mr.getParameter("teacherName"));
		atvo.setClientId(id);
		atvo.setCategory(mr.getParameter("category"));
		atvo.setIntroduce(mr.getParameter("introduce"));
		atvo.setStatus("N");
		
		//파일 등록을 한 경우에만 객체에 값을 셋팅해준다
		if (mr.getFilesystemName("upfile") != null) {
			atvo.setImg(mr.getFilesystemName("upfile"));
		}

		try {
			if (mr.getParameter("mode").equals("update")) {
				cnt = ut_dao.updateTeacher(atvo);
			} else {
				//insert
				cnt = ut_dao.insertTeacher(atvo);
			}
			
			if (cnt == 1) {
				String careerVal = mr.getParameter("careerVal");	//경력

				//만약 수정모드라면, 기존에 등록했던 경력은 상태값을 변경해준다.
				if (mr.getParameter("mode").equals("update")) {
					int result = ut_dao.updateCareer(mr.getParameter("teacherName"));
				}
				
				//캐리어 테이블에 경력 추가
		        String[] words = careerVal.split(",");
		        for(int i = 0; i < words.length; i++) {
		        	CareerVO cvo = new CareerVO();
		        	cvo.setCareer(words[i]);
		        	cvo.setTeacherName(mr.getParameter("teacherName"));
		        	ut_dao.insertCareer(cvo);
		        } // end for
			} // end if
		
			request.setAttribute("list", atvo);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return cnt;
	} // addTeacher
	
	// 강사프로필 삭제시 상태 변경
	public int modifyTeacherStatus(String teacherName){
		int cnt = ut_dao.updateTeacherStatus(teacherName);
		return cnt;
	} // modifyTeacherStatus
	
	public List<String> searchTeacherProfile(String userId, ListPageVO lpvo){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", userId);
		param.put("lpvo", lpvo);
		
		List<String> list = ut_dao.selectTeacherProfile(param);
		return list;
		
	} // searchTeacherProfile
	
	public TeacherInfo searchTeacherDetail(String teacherName){
		TeacherInfo list = ut_dao.selectTeacherDetail(teacherName);
		
		return list;
	} // searchTeacherDetail
	
	public List<String> searchCareer(String teacherName){
		List<String> list = ut_dao.selectCareer(teacherName);
		
		return list;
	} // searchCareer
	
	// 강의가 진행중이거나 신청마감인지 조회
	public int searchLessonStatus(String teacherName) {
		int result = 0;
		int cnt = ut_dao.selectLessonStatus(teacherName);

		if (cnt == 0) {
		 modifyTeacherStatus(teacherName);
		 result = 1;
		} // end if

		return result;
	} // searchLessonStatus
	
} // class
