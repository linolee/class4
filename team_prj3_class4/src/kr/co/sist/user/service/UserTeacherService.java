package kr.co.sist.user.service;

import java.io.File;
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
	
//////////////////////////////////////////////////////////////////////////�럹�씠吏�/////////////////////////////////////////////////////////////////	
	//1. 珥� 寃뚯떆湲� �닔 媛��졇�삤湲�
	public int totalCount(String userId, ListPageVO lpvo) {
		int cnt = 0;
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", userId);
		param.put("lpvo", lpvo);
		
		cnt = ut_dao.teacherProfileTotalCnt(param);
		
		return cnt;
	} // totalCount
	
	// 2. �럹�씠吏� �떦 蹂댁뿬吏� 寃뚯떆湲� �닔
	public int pageScale() {
		int pageScale = 10;
		
		return pageScale;
	}
	
	// 3. 珥� �럹�씠吏� 援ы븯湲�
	public int totalPage(int totalCount) {
		int totalPage = totalCount / pageScale();
		
		if (totalCount % pageScale() != 0) {
			totalPage++;
		}
	
		return totalPage;
	}
	
	// 4. �떆�옉 �럹�씠吏� 怨꾩궛
	// +1�� 泥ロ럹�씠吏�媛� 0�씠�굹 10�씠 �븘�땲�씪 1�씠�굹 11濡� �븯湲� �쐞�븿�엫 1-> 1, 2->11, 3->21 ,,,
	public int startNum(int currentPage) {
		int startNum = 1;
		startNum = currentPage * pageScale() - pageScale() + 1;
		return startNum;
	}
	
	// 5. �걹 �럹�씠吏� 怨꾩궛
	// -1�� 泥ロ럹�씠吏�媛� 1�씠�굹 11 �벑怨� 媛숈쓣�븣 1~10, 11~20�쑝濡� 吏��젙�븯湲� �쐞�븿�엫
	public int endNum(int startNum) {
		int endNum = startNum + pageScale() - 1;
		return endNum;
	}
	
	/**
	* 占싸듸옙占쏙옙 占쏙옙占쏙옙트 [ << ] ... [1][2][3] ... [ >> ]
	* 
	* @param current_page
	* @param total_page
	* @param list_url
	* @return
	*/
	public String indexList(int current_page, int total_page, String list_url) {
		int pagenumber; // �럹�씠吏� 踰덊샇
		int startpage; // �떆�옉 �럹�씠吏�
		int endpage; // 留덉�留� �럹�씠吏�
		int curpage; // �쁽�옱 �럹�씠吏�
		
		String strList = "";
		
		pagenumber = 10; // �럹�씠吏��떦 蹂댁씪 寃뚯떆湲� �닔
		
		// �떆�옉 �럹�씠吏� 怨꾩궛
		startpage = ((current_page - 1) / pagenumber) * pagenumber + 1;
		
		// 留덉�留� �럹�씠吏� 怨꾩궛
		endpage = (((startpage - 1) + pagenumber) / pagenumber) * pagenumber;
		
		//珥� �럹�씠吏�媛� 留덉�留됲럹�씠吏�蹂대떎 �옉嫄곕굹 媛숈쓣 寃쎌슦,
		//�걹 �럹�씠吏��뒗 留덉�留� �럹�씠吏�
		if (total_page <= endpage) {
		endpage = total_page;
		} // end if
		
		
		//�쁽�옱 �럹�씠吏�媛� 寃뚯떆湲� �닔蹂대떎 �겢 寃쎌슦
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

//////////////////////////////////////////////////////////////////////////�럹�씠吏�/////////////////////////////////////////////////////////////////	


	
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
		
		String fsl = File.separator;
		String root = request.getSession().getServletContext().getRealPath(fsl);
		String rootPath = root + "/upload/teacher" + fsl;
		
		MultipartRequest mr = new MultipartRequest(request,rootPath,1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
		
		
		AddTeacherVO atvo = new AddTeacherVO();
		atvo.setTeacherName(mr.getParameter("teacherName"));
		atvo.setClientId(id);
		atvo.setCategory(mr.getParameter("category"));
		atvo.setIntroduce(mr.getParameter("introduce"));
		atvo.setStatus("N");
		
		//�뙆�씪 �벑濡앹쓣 �븳 寃쎌슦�뿉留� 媛앹껜�뿉 媛믪쓣 �뀑�똿�빐以��떎
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
				String careerVal = mr.getParameter("careerVal");	//寃쎈젰

				//留뚯빟 �닔�젙紐⑤뱶�씪硫�, 湲곗〈�뿉 �벑濡앺뻽�뜕 寃쎈젰�� �긽�깭媛믪쓣 蹂�寃쏀빐以��떎.
				if (mr.getParameter("mode").equals("update")) {
					int result = ut_dao.updateCareer(mr.getParameter("teacherName"));
				}
				
				//罹먮━�뼱 �뀒�씠釉붿뿉 寃쎈젰 異붽�
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
	
	// 媛뺤궗�봽濡쒗븘 �궘�젣�떆 �긽�깭 蹂�寃�
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
	
	// 媛뺤쓽媛� 吏꾪뻾以묒씠嫄곕굹 �떊泥�留덇컧�씤吏� 議고쉶
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
