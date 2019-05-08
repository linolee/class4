package kr.co.sist.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.dao.LectureDAO;
import kr.co.sist.admin.domain.LectureListDomain;
import kr.co.sist.admin.vo.ListVO;

@Component
public class LectureService {
	
	@Autowired(required=false)
	private LectureDAO l_dao;
	
	// 1. ��ü �Խù� �� ���
		public int totalCount() {
			int cnt = 0;
			cnt = l_dao.selectTotalCount();
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
				strList = strList + "<li class='page-item'><a class='page-link' href=" + list_url + "?currentPage=" + curpage + ">Prev</a></li>";
			} else {
				strList = strList + "<li class='page-item'><a class='page-link' href='#'>Prev</a></li>";
				
			}

			// ���������� ��ȣ���� ������������ ��ȣ���� ȭ�鿡 ǥ��
			curpage = startpage;

			while (curpage <= endpage) {
				if (curpage == current_page) {
					strList = strList + "<li class='page-item active'><a class='page-link' href='#'>"+current_page+"</a>";
				} else {
					strList = strList + "<li class='page-item'><a class='page-link' href=" + list_url + "?currentPage="+curpage+">"+curpage+"</a></li>";
				} // end else

				curpage++;
			} // end while

			// �ڿ� �������� �� �ִ°��
			if (total_page > endpage) {
				curpage = endpage + 1;
				strList = strList + "<li class='page-item'><a class='page-link' href="+list_url+"?currentPage="+curpage+">Next</a></li>";
			} else {
				strList = strList + "<li class='page-item'><a class='page-link' href='#'>Next</a></li>";
			} // end else

			return strList;
		}// indexList
	
	
	public List<LectureListDomain> selectLectureList(ListVO lvo){
		List<LectureListDomain> list=null;
		
		LectureListDomain lld=new LectureListDomain();
		
		
/*		String lessonStatus=lld.getStatus();
		
		if(lessonStatus=="A") {
			lld.setStatus("���� ���");
		} else if(lessonStatus=="R") {
			lld.setStatus("�غ���");
		} else if(lessonStatus=="Y") {
			lld.setStatus("����");
		} else if(lessonStatus=="F") {
			lld.setStatus("����");
		} else if(lessonStatus=="I") {
			lld.setStatus("������");
		} else if(lessonStatus=="E") {
			lld.setStatus("����");
		} else if(lessonStatus=="C") {
			lld.setStatus("���");
		} */
		
		
/*		switch(lessonStatus) {
			case "A" :
				 lld.setStatus("���� ���");
			case "R" :
				lld.setStatus("�غ���");
			case "Y" :
				lld.setStatus("����");
			case "F" :
				lld.setStatus("����");
			case "I" :
				lld.setStatus("������");
			case "E" :
				lld.setStatus("����");
			case "C" :
				lld.setStatus("���");
		} // switch
*/		
		
		list=l_dao.selectLectureList(lvo);
		
		
		
		
		
		return list;
	}
	
	/*public static void main(String[] args) {
		LectureService ls=new LectureService();
		ls.selectLectureList();
	}*/
	
	
}
