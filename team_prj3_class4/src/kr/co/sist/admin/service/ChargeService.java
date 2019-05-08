package kr.co.sist.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.dao.ChargeDAO;
import kr.co.sist.admin.domain.ChargeAllList;
import kr.co.sist.admin.domain.ChargeDetail;
import kr.co.sist.admin.domain.ChargeDetailList;
import kr.co.sist.admin.domain.LessonInfo;
import kr.co.sist.admin.vo.ListChargeDetailVO;
import kr.co.sist.admin.vo.ListVO;

@Component
public class ChargeService {

	@Autowired
	private ChargeDAO c_dao;

	// 1. ��ü �Խù� �� ���
	public int totalCount() {
		int cnt = 0;
		cnt = c_dao.selectTotalCount();
		return cnt;
	}
	
	// 1-1. ��ü �Խù� �� ���(ChargeDetailList)
	public int chargeDetailTotalCount(String lcode) {
		int cnt = 0;
		cnt = c_dao.selectChargeDetailTotalCount(lcode);
		return cnt;
	}

	// 2. �� ȭ�鿡 ������ �Խù��� ��
	public int pageScale() {
		int pageScale = 10;

		return pageScale;
	}

	// 3. �� ������ �� ���ϱ�
	public int totalPage(int totalCount) {
		int totalPage = totalCount / pageScale();
		if (totalCount % pageScale() != 0) {
			totalPage++;
		}

		return totalPage;
	}

	// 4. ���� ������ ��ȣ ���ϱ�
	// current_page�� ���� ���� ��ȣ�� �޶�����. 1-> 1, 2->11, 3->21 ,,,
	public int startNum(int currentPage) {
		int startNum = 1;
		startNum = currentPage * pageScale() - pageScale() + 1;
		return startNum;
	}

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
	// ���� �Խ����� ������ �ε��� ����
	public String indexList(int current_page, int total_page, String list_url) {
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
			strList = strList + "<li class='page-item'><a class='page-link' href=" + list_url + "?currentPage="
					+ curpage + ">Prev</a></li>";
		} else {
			strList = strList + "<li class='page-item'><a class='page-link' href='#'>Prev</a></li>";

		}

		// ���������� ��ȣ���� ������������ ��ȣ���� ȭ�鿡 ǥ��
		curpage = startpage;

		while (curpage <= endpage) {
			if (curpage == current_page) {
				strList = strList + "<li class='page-item active'><a class='page-link' href='#'>" + current_page
						+ "</a>";
			} else {
				strList = strList + "<li class='page-item'><a class='page-link' href=" + list_url + "?currentPage="
						+ curpage + ">" + curpage + "</a></li>";
			} // end else

			curpage++;
		} // end while

		// �ڿ� �������� �� �ִ°��
		if (total_page > endpage) {
			curpage = endpage + 1;
			strList = strList + "<li class='page-item'><a class='page-link' href=" + list_url + "?currentPage="
					+ curpage + ">Next</a></li>";
		} else {
			strList = strList + "<li class='page-item'><a class='page-link' href='#'>Next</a></li>";
		} // end else

		return strList;
	}// indexList
	
	public String indexList(int current_page, int total_page, String list_url, String lcode) {
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
			strList = strList + "<li class='page-item'><a class='page-link' href=" + list_url + "?currentPage="
					+ curpage + "&lcode=" + lcode + ">Prev</a></li>";
		} else {
			strList = strList + "<li class='page-item'><a class='page-link' href='#'>Prev</a></li>";

		}

		// ���������� ��ȣ���� ������������ ��ȣ���� ȭ�鿡 ǥ��
		curpage = startpage;

		while (curpage <= endpage) {
			if (curpage == current_page) {
				strList = strList + "<li class='page-item active'><a class='page-link' href='#'>" + current_page
						+ "</a>";
			} else {
				strList = strList + "<li class='page-item'><a class='page-link' href=" + list_url + "?currentPage="
						+ curpage + "&lcode=" + lcode + ">" + curpage + "</a></li>";
			} // end else

			curpage++;
		} // end while

		// �ڿ� �������� �� �ִ°��
		if (total_page > endpage) {
			curpage = endpage + 1;
			strList = strList + "<li class='page-item'><a class='page-link' href=" + list_url + "?currentPage="
					+ curpage + "&lcode=" + lcode + ">Next</a></li>";
		} else {
			strList = strList + "<li class='page-item'><a class='page-link' href='#'>Next</a></li>";
		} // end else

		return strList;
	}// indexList
	
	

	public List<ChargeAllList> searchChargeAllList(ListVO lvo) {
		List<ChargeAllList> list = null;
		list = c_dao.selectChargeAllList(lvo);
		return list;
	}
	
	public List<ChargeDetailList> searchChargeDetailList(ListChargeDetailVO lcdvo) {
		List<ChargeDetailList> list = null;
		list = c_dao.selectChargeDetailList(lcdvo);
		return list;
	}
	
	public LessonInfo searchChargeDetailLessonInfo(String lcode) {
		LessonInfo li = c_dao.selectChargeDetailLessonInfo(lcode);
		return li;
	}
	
	public int closeLessonClosure(String lcode) {
		int cnt = c_dao.updateLessonClosure(lcode);
		return cnt;
	}
	
	public ChargeDetail searchChargeDetail(String rcode) {
		ChargeDetail cd = c_dao.selectChargeDetail(rcode);
		return cd;
	}

	public int removeReport(String rcode) {
		int cnt = c_dao.deleteReport(rcode);
		return cnt;
	}
	
	public int applyReport(String rcode) {
		int cnt = c_dao.updateReport(rcode);
		return cnt;
	}
}
