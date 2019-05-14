package kr.co.sist.user.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.user.dao.UserLectureDAO;
import kr.co.sist.user.domain.LectureView;
import kr.co.sist.user.domain.Review;
import kr.co.sist.user.domain.StatusCnt;
import kr.co.sist.user.vo.LectureViewVO;
import kr.co.sist.user.vo.ListPageVO;

@Component
public class UserLectureService {
	@Autowired
	private UserLectureDAO l_dao;

	// 1. 총 게시글 수 가져오기
	public int totalCount(String userId, String status, ListPageVO lpvo) {
		int cnt = 0;
		
		//id로 이름을 가져온다
		List<String> tnlist = searchTeachername(userId); 
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("nameList", tnlist);
		param.put("status", status);
		param.put("lpvo", lpvo);
					
		cnt = l_dao.lectureTotalCnt(param);
		return cnt;
	}
	
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
	// ���� �Խ����� ������ �ε��� ����
	public String indexList(int current_page, int total_page, String list_url) {
		int pagenumber; // 페이지 번호
		int startpage;  // 시작 페이지
		int endpage;    // 마지막 페이지
		int curpage;    // 현재 페이지

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
			strList = strList + "<li class='page-item'><a class='page-link' href=" + list_url + "&currentPage=" + curpage + ">Prev</a></li>";
		} else {
			strList = strList + "<li class='page-item'><a class='page-link' href='#'>Prev</a></li>";
			
		}

		curpage = startpage;

		while (curpage <= endpage) {
			if (curpage == current_page) {
				strList = strList + "<li class='page-item active'><a class='page-link' href='#'>"+current_page+"</a>";
			} else {
				strList = strList + "<li class='page-item'><a class='page-link' href=" + list_url + "&currentPage="+curpage+">"+curpage+"</a></li>";
			} // end else

			curpage++;
		} // end while

		// �ڿ� �������� �� �ִ°��
		if (total_page > endpage) {
			curpage = endpage + 1;
			strList = strList + "<li class='page-item'><a class='page-link' href="+list_url+"&currentPage="+curpage+">Next</a></li>";
		} else {
			strList = strList + "<li class='page-item'><a class='page-link' href='#'>Next</a></li>";
		} // end else

		return strList;
	}// indexList	
	
	
	// 검색조건으로 클래스 조회
	private List<LectureView> searchLecture(Map<String, Object> param) {
		List<LectureView> lv = l_dao.selectLecture(param);
		return lv;
	}//searchLecture

	// teachername으로 lcode 조회
	private List<String> searchLcode(String teacherName) {
		List<String> list = l_dao.selectLcode(teacherName);
		return list;
	}//searchLcode

	// id로 teacherName 조회
	private List<String> searchTeachername(String userId) {
		List<String> list = l_dao.selectTeachername(userId);
		return list;
	}//searchTeachername
	
	// id와 상태값으로 클래스 조회
	public List<LectureView> searchLectureInfo(String userId, String status, ListPageVO lpvo) {
		//id로 이름을 가져온다
		List<String> tnlist = searchTeachername(userId); 
		
		//파라미터 map에 넣어 보내기
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("nameList", tnlist);
		param.put("status", status);
		param.put("lpvo", lpvo);
			
		//클래스 조회
		List<LectureView> classList = searchLecture(param);

		return classList;
	} //searchLectureInfo

	public List<LectureView> searchStudentsList(String lcode) {
		List<LectureView> s_list = l_dao.selectStudentsList(lcode);
		return s_list;
	} //searchStudentsList
	
	public List<String> searchTeacherName(String userId){
		List<String> list = l_dao.selectTeacherName(userId);
		
		return list;
	} //searchTeacherName
	
	public List<LectureView> selectClassApplyCnt() {
		List<LectureView> result = l_dao.selectClassApplyCnt();
		
		return result;
	}
	
	public Map<String, Object> searchStatusCnt(List<String> tn_list){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int cnt = 0;	//totalCnt
		
		//status Cnt
		int A = 0;
		int R = 0;
		int Y = 0;
		int F = 0;
		int I = 0;
		int E = 0;
		int C = 0;	
		
		for(int i = 0; i < tn_list.size(); i++) {	//teacherName수만큼 반복
			//이름으로 클래스 상태별 카운트를 가져온다
			List<StatusCnt> cntList = l_dao.selectLectureStatus(tn_list.get(i));
			
			if (!cntList.isEmpty()) { //받아온 데이터가 존재한다면 진입
				for (int j = 0; j < cntList.size(); j++) {
					cnt += cntList.get(j).getNum();	//total
					
					//status
					if (cntList.get(j).getStatus().equals("A")) {
						A += cntList.get(j).getNum();
					} else if (cntList.get(j).getStatus().equals("R")) {
						R += cntList.get(j).getNum();
					} else if(cntList.get(j).getStatus().equals("Y")) {
						Y += cntList.get(j).getNum();
					} else if(cntList.get(j).getStatus().equals("F")) {
						F += cntList.get(j).getNum();
					} else if(cntList.get(j).getStatus().equals("I")) {
						I += cntList.get(j).getNum();
					} else if(cntList.get(j).getStatus().equals("E")) {
						E += cntList.get(j).getNum();
					} else if(cntList.get(j).getStatus().equals("C")) {
						C += cntList.get(j).getNum();
					}
				}
			} // end if
		} // end for
		
		resultMap.put("totalCnt", cnt);
		resultMap.put("A", A);
		resultMap.put("R", R);
		resultMap.put("Y", Y);
		resultMap.put("F", F);
		resultMap.put("I", I);
		resultMap.put("E", E);
		resultMap.put("C", C);
		
		return resultMap;
	} // searchStatusCnt
	
	
	public void checkClassStatus(String teacherName) {
		/* # 조건
		 - 시작일 기준 : 
		   > 신청마감
		     (상태가 '오픈(Y)'이며, 신청 마감일이 오늘보다 작은 경우)
		   > 진행중
		      (상태가 '오픈(Y)또는 마감(F)이고, 오늘 날짜가 시작일보다 같거나 크면서 종료일자보다 작은 경우)

		 - 종료일 기준 : 종료 (오늘 날짜가 종료일보다 큰 경우)*/
		
		//today
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ("yyyy-MM-dd", Locale.KOREA );
		Date currentTime = new Date();
		String today = mSimpleDateFormat.format(currentTime);

		//신청마감 체크
		List<String> applyClassList = selectApplyClassStatus(teacherName, today);
		if (!applyClassList.isEmpty()) {
			for (int i = 0; i < applyClassList.size(); i++) {
				int result = 0;
				
				//update 쿼리 실행
				result = l_dao.updateApplyClassStatus(applyClassList.get(i));
			}
		}
		
		//진행중 체크
		List<String> progressClassList = selectProgressClassStatus(teacherName, today);
		if (!progressClassList.isEmpty()) {
			for (int i = 0; i < progressClassList.size(); i++) {
				//update 쿼리 실행
				l_dao.updateProgressClassStatus(progressClassList.get(i));
			}
		}
				
		//종료 체크
		List<String> endClassList = selectEndClassStatus(teacherName, today);
		if (!endClassList.isEmpty()) {
			for (int i = 0; i < endClassList.size(); i++) {
				//update 쿼리 실행
				l_dao.updateEndClassStatus(endClassList.get(i));
			}
		}
	}
	 
	// 신청마감할 클래스 불러오기
	public List<String> selectApplyClassStatus(String teacherName, String today) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("teacherName", teacherName);
		map.put("today", today);
		List<String> list = l_dao.selectApplyClassStatus(map);
				
		return list;
	} // updateApplyClassStatus
	
	public int updateApplyClassStatus(String lcode) {
		int result = 0;
		result = l_dao.updateApplyClassStatus(lcode);
		
		return result;
	}
	
	// 진행중으로 변경할 클래스 불러오기
	public List<String> selectProgressClassStatus(String teacherName, String today) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("teacherName", teacherName);
		map.put("today", today);
		List<String> list = l_dao.selectProgressClassStatus(map);
		
		return list;
	} // updateProgressClassStatus
	
	public int updateProgressClassStatus(String lcode) {
		int result = 0;
		result = l_dao.updateProgressClassStatus(lcode);
		
		return result;
	}
	
	// 종료로 변경할 클래스 불러오기
	public List<String> selectEndClassStatus(String teacherName, String today) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("teacherName", teacherName);
		map.put("today", today);
		List<String> list = l_dao.selectEndClassStatus(map);
		
		return list;
	} // updateEndClassStatus
	
	public int updateEndClassStatus(String lcode) {
		int result = 0;
		result = l_dao.updateEndClassStatus(lcode);
		
		return result;
	}
	
	public int changeOpenClass(String lcode) {
		int result = 0;
		result = l_dao.changeOpenClass(lcode);
		
		return result;
	}
	
	
} // class
