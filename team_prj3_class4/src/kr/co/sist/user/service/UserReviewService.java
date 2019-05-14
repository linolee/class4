package kr.co.sist.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.user.dao.UserLectureReviewDAO;
import kr.co.sist.user.domain.Review;
import kr.co.sist.user.vo.ListPageVO;

@Component
public class UserReviewService {
	@Autowired
	private UserLectureReviewDAO ultr_dao;
	
//////////////////////////////////////////////////////////////////////////페이징/////////////////////////////////////////////////////////////////	
	// 1. 총 게시글 수 가져오기
	public int totalCount(String userId, ListPageVO lpvo, String fromDate, String toDate) {
		int cnt = 0;
		
		//id로 이름을 가져온다
		List<String> tnlist = searchTeacherName(userId); 
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("nameList", tnlist);
		param.put("lpvo", lpvo);
		param.put("fromDate", fromDate);
		param.put("toDate", toDate);
					
		cnt = ultr_dao.reviewTotalCnt(param);
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

		String currentPageStr = "?";
		if (list_url.contains("Date")) {
			//Date란 단어가 포함되어있으면...
			currentPageStr = "&";
		}
		//현재 페이지가 게시글 수보다 클 경우
		if (current_page > pagenumber) {
			curpage = startpage - 1;
			strList = strList + "<li class='page-item'><a class='page-link' href=" + list_url + currentPageStr + "currentPage=" + curpage + ">Prev</a></li>";
		} else {
//			strList = strList + "<li class='page-item'><a class='page-link' href='#'>Prev</a></li>";
			
		}

		curpage = startpage;

		while (curpage <= endpage) {
			if (curpage == current_page) {
				strList = strList + "<li class='page-item active'><a class='page-link' href='#'>"+current_page+"</a>";
			} else {
				strList = strList + "<li class='page-item'><a class='page-link' href=" + list_url + currentPageStr + "currentPage="+curpage+">"+curpage+"</a></li>";
			} // end else

			curpage++;
		} // end while

		// �ڿ� �������� �� �ִ°��
		if (total_page > endpage) {
			curpage = endpage + 1;
			strList = strList + "<li class='page-item'><a class='page-link' href="+list_url+"?currentPage="+curpage+">Next</a></li>";
		} else {
//			strList = strList + "<li class='page-item'><a class='page-link' href='#'>Next</a></li>";
		} // end else

		return strList;
	}// indexList	
	
//////////////////////////////////////////////////////////////////////////페이징/////////////////////////////////////////////////////////////////	
	
	public List<Review> searchReview(Map<String, Object> map) {
		List<Review> list = ultr_dao.selectReview(map);
		
		return list;
	}//searchReview
	
	public int searchReviewCnt(Map<String, String> map) {
		int cnt = ultr_dao.selectReviewCnt(map);
		
		return cnt;
	}
	
	public List<String> searchTeacherName(String userId){
		List<String> list = ultr_dao.selectTeacherName(userId);
		
		return list;
	} //searchTeacherName
	
	public Review searchReviewDetail(String clientId, String lcode){
		Map<String, String> map = new HashMap<String, String>();
		map.put("clientId", clientId);
		map.put("lcode", lcode);
		
		Review review = ultr_dao.selectReviewDetail(map);
		
		return review;
	} // searchReviewDetail

	
} // class
