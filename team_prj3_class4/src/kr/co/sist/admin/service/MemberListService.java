package kr.co.sist.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.dao.MemberListDAO;
import kr.co.sist.admin.domain.MemberListDomain;
import kr.co.sist.admin.vo.MemberIdxVO;

@Component
public class MemberListService {

	@Autowired
	private MemberListDAO a_dao; 
	
	public List<MemberListDomain> selectAllMember(){
		List<MemberListDomain> list=null;
		
		a_dao=MemberListDAO.getInstance();
		
		list= a_dao.selectAllMember();
		
		return list;
	}
	
	public String chkTeacher(String ID) {
		String chkTeacher="";
		a_dao=MemberListDAO.getInstance();
		
		chkTeacher=a_dao.teacherInfo(ID);
		
		return chkTeacher;
	}
	


	/**
	 * �ѰԽù��� �� ���
	 * @return
	 */
	public int totalCount() {
		int cnt=0;
		cnt=a_dao.selectTotalCount();
		return cnt;
	}//totalCount
	
	/**
	 * ���������� ������ �Խù��� �� 
	 * @return
	 */
	public int pageScale( ) {
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
		if(totalCount % pageScale() != 0){
			totalPage++;
		}//end if
		return totalPage;
	}//totalPage
	
	/**
	 * ������ �ε��� ����Ʈ���� ��ȸ�� ���� ��ȣ
	 * @param currentPage
	 * @return
	 */
	public int startNum( int currentPage ) {
		int startNum=1;
		startNum= currentPage*pageScale()-pageScale()+1;
		return startNum;
	}//startNum
	
	/**
	 * ������ �ε��� ����Ʈ���� ��ȸ�� ����ȣ
	 * @param startNum
	 * @return
	 */
	public int endNum(int startNum) {
		int endNum=startNum+pageScale()-1;
		return endNum;
	}//endNum

	/**
	 *  �ε��� ����Ʈ  [ << ] ...  [1][2][3] ... [ >> ]
	 * @param current_page
	 * @param total_page
	 * @param list_url
	 * @return
	 */
	public String indexList(int current_page, int total_page, String list_url) {
	int pagenumber; // ȭ�鿡 ������ ������ �ε��� ��
	int startpage; // ȭ�鿡 ������ ���������� ��ȣ
	int endpage; // ȭ�鿡 ������ ������������ ��ȣ
	int curpage; // �̵��ϰ��� �ϴ� ������ ��ȣ

		String strList=""; // ���ϵ� ������ �ε��� ����Ʈ
	
		pagenumber = 10; // �� ȭ���� ������ �ε��� �� 
	
		// ���� ��������ȣ ���ϱ�
		startpage = ((current_page - 1) / pagenumber) * pagenumber + 1;
	
		// ������ ��������ȣ ���ϱ�
		endpage = (((startpage - 1) + pagenumber) / pagenumber) * pagenumber;
	
		// �� ������ ���� ���� ������������ ��ȣ���� ������� 
		// �� ������ ���� ������������ ��ȣ�� ��
	
		if (total_page <= endpage){
			endpage = total_page;
		}//end if
	
		// ù��° ������ �ε��� ȭ���� �ƴѰ��
		if ( current_page > pagenumber) {
			curpage = startpage - 1; // ���������� ��ȣ���� 1 ���� �������� �̵�
			strList = strList + "[ <a href="+list_url+"?currentPage="+curpage+"> &lt;&lt; </a> ]";
		}else{
			strList = strList + "[ << ]";
		}//end else
	
		strList = strList + " ... ";
	
		// ���������� ��ȣ���� ������������ ��ȣ���� ȭ�鿡 ǥ��
		curpage = startpage;
	
		while (curpage <= endpage){
			if (curpage == current_page) {
				strList = strList + "[ "+current_page+" ]";
			} else {
				strList = strList +"[ <a href="+list_url+"?currentPage="+curpage+">"+curpage+"</a> ]";
			}//end else
	
			curpage++;
		}//end while
	
		strList = strList + " ... ";
	
		// �ڿ� �������� �� �ִ°��
		if ( total_page > endpage) {
			curpage = endpage + 1;
			strList = strList + "[ <a href="+list_url+"?currentPage="+curpage+"> &gt;&gt; </a> ]";
		}else{
			strList = strList + "[ >> ]";
		}//end else
	
			return strList;
	}//indexList
	
/*	public List<MemberListDomain> searchDiaryList(MemberIdxVO mldxVO){
		List<MemberListDomain> list=null;
		list=a_dao.selectList(mldxVO);
		
		//���� ������ 24�� ������ �����ش�.
		MemberListDomain mld=null;
		String subject="";
		for(int i=0 ; i < list.size() ; i++) {
			mld=list.get(i);
			subject=mld.getSubject();
			}//end if
			
		}//end for
		
		return list;
	}//searchDiaryList
*/	
	
	

	public static void main(String[] args) {
		
		MemberListService mls=new MemberListService();
		System.out.println(mls.chkTeacher("in11202"));
	}

}
