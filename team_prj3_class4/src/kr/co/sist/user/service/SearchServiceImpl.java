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
	// 2. �� ȭ�鿡 ������ �Խù��� ��
	public int pageScale() {
		int pageScale = 6;

		return pageScale;
	}
	
	@Override
	// 3. �� ������ �� ���ϱ�
	public int totalPage(int totalCount) {
		int totalPage = totalCount / pageScale();
		if (totalCount % pageScale() != 0) {
			totalPage++;
		}

		return totalPage;
	}

	@Override
	// 4. ���� ������ ��ȣ ���ϱ�
	// current_page�� ���� ���� ��ȣ�� �޶�����. 1-> 1, 2->11, 3->21 ,,,
	public int startNum(int currentPage) {
		int startNum = 1;
		startNum = currentPage * pageScale() - pageScale() + 1;
		return startNum;
	}

	@Override
	// 5. ����ȣ ���
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
	@Override
	// ���� �Խ����� ������ �ε��� ����
	public String indexList(int current_page, int total_page, String list_url, String keyword) {
		int pagenumber; // ȭ�鿡 ������ ������ �ε��� ��
		int startpage; // ȭ�鿡 ������ ���������� ��ȣ
		int endpage; // ȭ�鿡 ������ ������������ ��ȣ
		int curpage; // �̵��ϰ��� �ϴ� ������ ��ȣ

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
			strList = strList + "<li class='page-item'><a class='page-link' href=" + list_url + "?currentPage=" + curpage + "&keyword="+ keyword + ">Prev</a></li>";
		} else {
			strList = strList + "<li class='page-item'><a class='page-link' href='#'>Prev</a></li>";
			
		}

		// ���������� ��ȣ���� ������������ ��ȣ���� ȭ�鿡 ǥ��
		curpage = startpage;

		while (curpage <= endpage) {
			if (curpage == current_page) {
				strList = strList + "<li class='page-item active'><a class='page-link' href='#'>"+current_page+"</a>";
			} else {
				strList = strList + "<li class='page-item'><a class='page-link' href=" + list_url + "?currentPage="+curpage + "&keyword=" + keyword+">"+curpage+"</a></li>";
			} // end else

			curpage++;
		} // end while

		// �ڿ� �������� �� �ִ°��
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
		}
		return list;
	}
}
