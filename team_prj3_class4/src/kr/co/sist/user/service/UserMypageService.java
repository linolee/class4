package kr.co.sist.user.service;

import java.util.List;

import org.springframework.stereotype.Component;

import kr.co.sist.user.dao.UserMypageDAO;
import kr.co.sist.user.domain.CancelList;
import kr.co.sist.user.domain.ClassList;
import kr.co.sist.user.domain.QnaList;
import kr.co.sist.user.domain.ReportList;
import kr.co.sist.user.vo.ListVO;
import kr.co.sist.user.vo.StatusCntVO;
import kr.co.sist.user.vo.StatusListVO;

@Component
public class UserMypageService {
	
	private UserMypageDAO um_dao;
	
	public UserMypageService() {
		um_dao=UserMypageDAO.getInstance();
	}//UserMypageService
	
	public List<ClassList> classList(ListVO lvo){
		List<ClassList> list=null;
		
		UserMypageDAO mb_dao=UserMypageDAO.getInstance();
		list=mb_dao.selectClass(lvo);
		
		return list;
	}//classList
	
	public List<ClassList> selectStatusClass(StatusListVO slvo){
		List<ClassList> list=null;
		
		UserMypageDAO mb_dao=UserMypageDAO.getInstance();
		list=mb_dao.selectStatusClass(slvo);
		
		return list;
	}//classList
	
	public List<String> lcodeList(String clientId){
		List<String> list=null;
		
		UserMypageDAO mb_dao=UserMypageDAO.getInstance();
		list=mb_dao.selectLcode(clientId);
		
		return list;
	}//lcodeList
	
	public String reviewStatus(ListVO lvo) {
		String lcode="";
		
		UserMypageDAO um_dao=UserMypageDAO.getInstance();
		lcode=um_dao.reviewStatus(lvo);
		
		return lcode;
	}//reviewList
	
	public String jjimStatus(ListVO lvo) {
		String lcode="";
		
		UserMypageDAO um_dao=UserMypageDAO.getInstance();
		lcode=um_dao.jjimStatus(lvo);
		
		return lcode;
	}//reviewList
	
	public boolean insertJjim(ListVO lvo) {
		boolean flag=false;
		UserMypageDAO um_dao=UserMypageDAO.getInstance();
		flag=um_dao.insertJjim(lvo);
		return flag;
	}//insertJjim
	
	public boolean deleteJjim(ListVO lvo) {
		boolean flag=false;
		UserMypageDAO um_dao=UserMypageDAO.getInstance();
		flag=um_dao.deleteJjim(lvo);
		return flag;
	}//insertJjim
	
	public List<String> cancelLcodeList(String clientId){
		List<String> list=null;
		UserMypageDAO um_dao=UserMypageDAO.getInstance();
		list=um_dao.cancelLcodeList(clientId);
		return list;
	}//cancelLcodeList
	
	public List<CancelList> cancelList(ListVO lvo){
		List<CancelList> list=null;
		UserMypageDAO um_dao=UserMypageDAO.getInstance();
		list=um_dao.cancelList(lvo);
		return list;
	}//cancelList

	public List<String> qnaLcodeList(String clientId){
		List<String> list=null;
		UserMypageDAO um_dao=UserMypageDAO.getInstance();
		list=um_dao.qnaLcodeList(clientId);
		return list;
	}//qnaLcodeList
	
	public List<QnaList> qnaList(ListVO lvo){
		List<QnaList> list=null;
		UserMypageDAO um_dao=UserMypageDAO.getInstance();
		list=um_dao.qnaList(lvo);
		return list;
	}//qnaList
	
	public List<String> reportLcodeList(String clientId){
		List<String> list=null;
		UserMypageDAO um_dao=UserMypageDAO.getInstance();
		list=um_dao.reportLcodeList(clientId);
		return list;
	}//qnaLcodeList
	
	public List<ReportList> reportList(ListVO lvo){
		List<ReportList> list=null;
		UserMypageDAO um_dao=UserMypageDAO.getInstance();
		list=um_dao.reportList(lvo);
		return list;
	}//qnaList
	
	public int statusCnt(StatusCntVO ssvo) {
		int cnt=0;
		UserMypageDAO um_dao=UserMypageDAO.getInstance();
		cnt=um_dao.statusCnt(ssvo);
		return cnt;
	}//totalCount
	
	/**
	 * �� �Խù��� �� ���
	 * @return
	 */
	public int totalCount(String clientId) {
		int cnt=0;
		UserMypageDAO mb_dao=UserMypageDAO.getInstance();
		cnt=mb_dao.selectTotalCount(clientId);
		return cnt;
	}//totalCount
	
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
		strList = strList + "[ <a href="+list_url+"?currentPage="+curpage+">&lt;&lt;</a> ]";
	}else{
		strList = strList + "<img src='http://localhost:8080/team_prj3_class4/common/images/left.png'/>";
	}

	strList = strList + " ... ";

	// ���������� ��ȣ���� ������������ ��ȣ���� ȭ�鿡 ǥ��
	curpage = startpage;

	while (curpage <= endpage){
		if (curpage == current_page) {
			strList = strList + "["+current_page+"]";
		} else {
			strList = strList +"[ <a href="+list_url+"?currentPage="+curpage+">"+curpage+"</a> ]";
		}//end else

		curpage++;
	}//end while

	strList = strList + " ... ";

	// �ڿ� �������� �� �ִ°��
	if ( total_page > endpage) {
		curpage = endpage + 1; 
		strList = strList + "[ <a href="+list_url+"?currentPage="+curpage+">&gt;&gt;</a> ]";
	}else{
		strList = strList + "<img src='http://localhost:8080/team_prj3_class4/common/images/right.png'/>";
	}//end else

	return strList;
	}//indexList
	
	
}//class
