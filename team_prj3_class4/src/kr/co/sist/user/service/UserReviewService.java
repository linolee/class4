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
	 * ���������� ������ �Խù��� ��
	 * @return
	 */
	public int pageScale() {
		int pageScale=10;
		return pageScale;
	}//pageScale
	
	/**
	 * ��� �Խù��� �����ֱ����� ������ ��
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
	 * ������ �ε��� ����Ʈ���� ��ȸ�� ���� ��ȣ
	 * @param currentPage
	 * @return
	 */
	public int startNum(int currentPage) {
		int startNum=1;
		startNum=currentPage*pageScale()-pageScale()+1;
		return startNum;
	}//startNum
	
	/**
	 * ������ �ε��� ����Ʈ���� ��ȸ�� �� ��ȣ
	 * @param startNum
	 * @return
	 */
	public int endNum(int startNum) {
		int endNum=startNum+pageScale()-1;
		return endNum;
	}//endNum
	
	/**
	 * �ε��� ����Ʈ [<<] ... [1] [2] [3] ... [>>]
	 * @param current_page
	 * @param total_page
	 * @param list_url
	 * @return
	 */
	public String indexList(int current_page, int total_page, String list_url) {
		int pagenumber; // ȭ�鿡 ������ ������ �ε��� ��
		int startpage;  // ȭ�鿡 ������ ���������� ��ȣ
		int endpage;    // ȭ�鿡 ������ ������������ ��ȣ
		int curpage; 	// �̵��ϰ��� �ϴ� ������ ��ȣ

		String strList = ""; // ���ϵ� ������ �ε��� ����Ʈ

		pagenumber = 10; // �� ȭ���� ������ �ε��� ��

		// ���� ��������ȣ ���ϱ�
		startpage = ((current_page - 1) / pagenumber) * pagenumber + 1;

		// ������ ��������ȣ ���ϱ�
		endpage = (((startpage - 1) + pagenumber) / pagenumber) * pagenumber;

		// �� ������ ���� ���� ������������ ��ȣ���� �������

		// �� ������ ���� ������������ ��ȣ�� ��

		if (total_page <= endpage) {
			endpage = total_page;
		} // end if

		// ù��° ������ �ε��� ȭ���� �ƴѰ��
		if (current_page > pagenumber) {
			curpage = startpage - 1; // ���������� ��ȣ���� 1 ���� �������� �̵�
			strList = strList + "[ <a href=" + list_url + "?currentPage=" + curpage + ">&lt;&lt;</a> ]";
		} else {
			strList = strList
					+ "<img src='http://localhost:8080/team_prj3_class4/resources/img/btn_page_nate_prev.gif'/>";
		}

		strList = strList + " ... ";

		// ���������� ��ȣ���� ������������ ��ȣ���� ȭ�鿡 ǥ��
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

		// �ڿ� �������� �� �ִ°��
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