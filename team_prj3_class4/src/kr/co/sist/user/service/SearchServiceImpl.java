package kr.co.sist.user.service;

import java.text.SimpleDateFormat;
import java.util.List;

import kr.co.sist.user.dao.SearchDAO;
import kr.co.sist.user.domain.SearchClassList;
import kr.co.sist.user.vo.SearchListVO;

public class SearchServiceImpl implements SearchService {
	SearchDAO s_dao;
	public SearchServiceImpl(SearchDAO s_dao) {
		this.s_dao = s_dao;
	}
	
	@Override
	public int totalCount(String keyword) {
		int cnt = 0;
		cnt = s_dao.selectTotalCount(keyword);
		return cnt;
	}
	
	@Override
	// 2. 한 화면에 보여질 게시물의 수
	public int pageScale() {
		int pageScale = 6;

		return pageScale;
	}
	
	@Override
	// 3. 총 페이지 수 구하기
	public int totalPage(int totalCount) {
		int totalPage = totalCount / pageScale();
		if (totalCount % pageScale() != 0) {
			totalPage++;
		}

		return totalPage;
	}

	@Override
	// 4. 시작 페이지 번호 구하기
	// current_page에 따라 시작 번호는 달라진다. 1-> 1, 2->11, 3->21 ,,,
	public int startNum(int currentPage) {
		int startNum = 1;
		startNum = currentPage * pageScale() - pageScale() + 1;
		return startNum;
	}

	@Override
	// 5. 끝번호 얻기
	public int endNum(int startNum) {
		int endNum = startNum + pageScale() - 1;

		return endNum;
	}
	
	/**
	 * 인덱스 리스트 [ << ] ... [1][2][3] ... [ >> ]
	 * 
	 * @param current_page
	 * @param total_page
	 * @param list_url
	 * @return
	 */
	@Override
	// 현재 게시판의 페이지 인덱스 설정
	public String indexList(int current_page, int total_page, String list_url, String keyword) {
		int pagenumber; // 화면에 보여질 페이지 인덱스 수
		int startpage; // 화면에 보여질 시작페이지 번호
		int endpage; // 화면에 보여질 마지막페이지 번호
		int curpage; // 이동하고자 하는 페이지 번호

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
			strList = strList + "<li class='page-item'><a class='page-link' href=" + list_url + "?currentPage=" + curpage + "&keyword="+ keyword + ">Prev</a></li>";
		} else {
			strList = strList + "<li class='page-item'><a class='page-link' href='#'>Prev</a></li>";
			
		}

		// 시작페이지 번호부터 마지막페이지 번호까지 화면에 표시
		curpage = startpage;

		while (curpage <= endpage) {
			if (curpage == current_page) {
				strList = strList + "<li class='page-item active'><a class='page-link' href='#'>"+current_page+"</a>";
			} else {
				strList = strList + "<li class='page-item'><a class='page-link' href=" + list_url + "?currentPage="+curpage + "&keyword=" + keyword+">"+curpage+"</a></li>";
			} // end else

			curpage++;
		} // end while

		// 뒤에 페이지가 더 있는경우
		if (total_page > endpage) {
			curpage = endpage + 1;
			strList = strList + "<li class='page-item'><a class='page-link' href="+list_url+"?currentPage="+curpage+ "&keyword=" + keyword+">Next</a></li>";
		} else {
			strList = strList + "<li class='page-item'><a class='page-link' href='#'>Next</a></li>";
		} // end else

		return strList;
	}// indexList

	@Override
	public List<SearchClassList> searchClassList(SearchListVO slvo) {
		List<SearchClassList> list = s_dao.selectClassList(slvo);
		for (SearchClassList searchClassList : list) {
			searchClassList.setStart_date(searchClassList.getStart_date().substring(0, 10));
			searchClassList.setEnd_date(searchClassList.getEnd_date().substring(0, 10));
			searchClassList.setDue_date(searchClassList.getDue_date().substring(0, 10));
		}
		return list;
	}

	@Override
	public List<String> searchCateogory(String keyword) {
		return s_dao.selectCategoryList(keyword);
	}
}
