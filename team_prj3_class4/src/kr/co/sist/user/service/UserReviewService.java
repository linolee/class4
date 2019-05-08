package kr.co.sist.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.user.dao.UserLectureReviewDAO;
import kr.co.sist.user.domain.Review;

@Component
public class UserReviewService {
	@Autowired
	private UserLectureReviewDAO ultr_dao;
	
	public List<Review> searchReview(Map<String, String> map) {
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
	}
	
	/**
	 * 한페이지에 보여줄 게시물의 수
	 * @return
	 */
	public int pageScale() {
		int pageScale=10;
		return pageScale;
	}//pageScale
	
	/**
	 * 모든 게시물을 보여주기위한 페이지 수
	 * @param totalCount
	 * @return
	 */
	public int totalPage(int totalCount) {
		int totalPage=totalCount/pageScale();
		if(totalCount % pageScale() !=0){
			totalPage++;
		}//end if
		return totalPage;
	}//totalPage
	
	/**
	 * 선택한 인덱스 리스트에서 조회할 시작 번호
	 * @param currentPage
	 * @return
	 */
	public int startNum(int currentPage) {
		int startNum=1;
		startNum=currentPage*pageScale()-pageScale()+1;
		return startNum;
	}//startNum
	
	/**
	 * 선택한 인덱스 리스트에서 조회할 끝 번호
	 * @param startNum
	 * @return
	 */
	public int endNum(int startNum) {
		int endNum=startNum+pageScale()-1;
		return endNum;
	}//endNum
	
	/**
	 * 인덱스 리스트 [<<] ... [1] [2] [3] ... [>>]
	 * @param current_page
	 * @param total_page
	 * @param list_url
	 * @return
	 */
	public String indexList(int current_page, int total_page, String list_url) {
		int pagenumber; // 화면에 보여질 페이지 인덱스 수
		int startpage;  // 화면에 보여질 시작페이지 번호
		int endpage;    // 화면에 보여질 마지막페이지 번호
		int curpage; 	// 이동하고자 하는 페이지 번호

		String strList = ""; // 리턴될 페이지 인덱스 리스트

		pagenumber = 10; // 한 화면의 페이지 인덱스 수

		// 시작 페이지번호 구하기
		startpage = ((current_page - 1) / pagenumber) * pagenumber + 1;

		// 마지막 페이지번호 구하기
		endpage = (((startpage - 1) + pagenumber) / pagenumber) * pagenumber;

		// 총 페이지 수가 계산된 마지막페이지 번호보다 작을경우

		// 총 페이지 수가 마지막페이지 번호가 됨

		if (total_page <= endpage) {
			endpage = total_page;
		} // end if

		// 첫번째 페이지 인덱스 화면이 아닌경우
		if (current_page > pagenumber) {
			curpage = startpage - 1; // 시작페이지 번호보다 1 적은 페이지로 이동
			strList = strList + "[ <a href=" + list_url + "?currentPage=" + curpage + ">&lt;&lt;</a> ]";
		} else {
			strList = strList
					+ "<img src='http://localhost:8080/team_prj3_class4/resources/img/btn_page_nate_prev.gif'/>";
		}

		strList = strList + " ... ";

		// 시작페이지 번호부터 마지막페이지 번호까지 화면에 표시
		curpage = startpage;

		while (curpage <= endpage) {
			if (curpage == current_page) {
				strList = strList + "[" + current_page + "]";
			} else {
				strList = strList + "[ <a href=" + list_url + "?currentPage=" + curpage + ">" + curpage + "</a> ]";
			} // end else

			curpage++;
		} // end while

		strList = strList + " ... ";

		// 뒤에 페이지가 더 있는경우
		if (total_page > endpage) {
			curpage = endpage + 1;
			strList = strList + "[ <a href=" + list_url + "?currentPage=" + curpage + ">&gt;&gt;</a> ]";
		} else {
			strList = strList
					+ "<img src='http://localhost:8080/team_prj3_class4/resources/img/btn_page_nate_next.gif'/>";
		} // end else

		return strList;
	}//indexList
	
} // class
