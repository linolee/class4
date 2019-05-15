package kr.co.sist.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.user.dao.UserMypageDAO;
import kr.co.sist.user.domain.CancelList;
import kr.co.sist.user.domain.ClassList;
import kr.co.sist.user.domain.QnaList;
import kr.co.sist.user.domain.ReportList;
import kr.co.sist.user.vo.ListVO;
import kr.co.sist.user.vo.QnaStatusVO;
import kr.co.sist.user.vo.ReportStatusVO;
import kr.co.sist.user.vo.ReviewVO;
import kr.co.sist.user.vo.StatusCntVO;
import kr.co.sist.user.vo.StatusListVO;
import kr.co.sist.user.vo.TotalVO;
import kr.co.sist.user.vo.qnaListVO;

@Component
public class UserMypageService {
	@Autowired
	private UserMypageDAO um_dao;
	
	public List<ClassList> classList(ListVO lvo){
		List<ClassList> list=null;
		
		list=um_dao.selectClass(lvo);
		
		return list;
	}//classList
	
	public List<ClassList> jjimList(String lcode){
		List<ClassList> list=null;
		
		list=um_dao.jjimList(lcode);
		
		return list;
	}//classList
	
	public List<ClassList> selectStatusClass(StatusListVO slvo){
		List<ClassList> list=null;
		
		list=um_dao.selectStatusClass(slvo);
		
		return list;
	}//classList
	
	public List<String> lcodeList(String clientId){
		List<String> list=null;
		
		list=um_dao.selectLcode(clientId);
		
		return list;
	}//lcodeList
	
	public String reviewStatus(ListVO lvo) {
		String lcode="";
		
		lcode=um_dao.reviewStatus(lvo);
		
		return lcode;
	}//reviewList

	public boolean insertReview(ReviewVO rvo) {
		boolean flag=false;
		flag=um_dao.insertReview(rvo);
		return flag;
	}//insertJjim
	
	public List<String> jjimLcodeList(String clientId){
		List<String> list=null;
		
		list=um_dao.jjimLcodeList(clientId);
		
		return list;
	}//lcodeList
	
	public String jjimStatus(ListVO lvo) {
		String lcode="";
		
		lcode=um_dao.jjimStatus(lvo);
		
		return lcode;
	}//reviewList
	
	public boolean insertJjim(ListVO lvo) {
		boolean flag=false;
		flag=um_dao.insertJjim(lvo);
		return flag;
	}//insertJjim
	
	public int jjimTotalCnt(String clientId) {
		int cnt=0;
		cnt=um_dao.jjimTotalCnt(clientId);
		return cnt;
	}//totalCount
	
	public int cancelTotalCnt(String clientId) {
		int cnt=0;
		cnt=um_dao.cancelTotalCnt(clientId);
		return cnt;
	}//totalCount
	
	public int qnaTotalCnt(String clientId) {
		int cnt=0;
		cnt=um_dao.qnaTotalCnt(clientId);
		return cnt;
	}//totalCount
	
	public int qnaStatusCnt(QnaStatusVO qsvo) {
		int cnt=0;
		cnt=um_dao.qnaStatusCnt(qsvo);
		return cnt;
	}//totalCount
	
	public int reportTotalCnt(String clientId) {
		int cnt=0;
		cnt=um_dao.reportTotalCnt(clientId);
		return cnt;
	}//totalCount
	
	public boolean deleteJjim(ListVO lvo) {
		boolean flag=false;
		flag=um_dao.deleteJjim(lvo);
		return flag;
	}//insertJjim
	
	public List<String> cancelLcodeList(String clientId){
		List<String> list=null;
		list=um_dao.cancelLcodeList(clientId);
		return list;
	}//cancelLcodeList
	
	public List<CancelList> cancelList(ListVO lvo){
		List<CancelList> list=null;
		list=um_dao.cancelList(lvo);
		return list;
	}//cancelList

	public List<String> qnaLcodeList(String clientId){
		List<String> list=null;
		list=um_dao.qnaLcodeList(clientId);
		return list;
	}//qnaLcodeList
	
	public List<String> qnaQcodeList(String clientId){
		List<String> list=null;
		list=um_dao.qnaQcodeList(clientId);
		return list;
	}//qnaLcodeList
	
	public List<QnaList> qnaList(qnaListVO qlvo){
		List<QnaList> list=null;
		list=um_dao.qnaList(qlvo);
		return list;
	}//qnaList
	
	public String selectAnswer(String qcode){
		String answer=um_dao.selectAnswer(qcode);
		return answer;
	}//qnaList
	
	public List<String> reportLcodeList(String clientId){
		List<String> list=null;
		list=um_dao.reportLcodeList(clientId);
		return list;
	}//qnaLcodeList
	
	public List<ReportList> reportList(ListVO lvo){
		List<ReportList> list=null;
		list=um_dao.reportList(lvo);
		return list;
	}//qnaList
	
	public int reportStatusCnt(ReportStatusVO rsvo) {
		int cnt=0;
		cnt=um_dao.reportStatusCnt(rsvo);
		return cnt;
	}//reportStatusCnt
	
	public int statusCnt(StatusCntVO ssvo) {
		int cnt=0;
		cnt=um_dao.statusCnt(ssvo);
		return cnt;
	}//totalCount
	
	/**
	 * 총 게시물의 수 얻기
	 * @return
	 */
	public int totalCount(TotalVO tvo) {
		int cnt=0;
		cnt=um_dao.selectTotalCount(tvo);
		return cnt;
	}//totalCount
	
	/**
	 * 한페이지에 보여줄 게시물의 수
	 * @return
	 */
	public int pageScale() {
		int pageScale=5;
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
	int startpage; // 화면에 보여질 시작페이지 번호
	int endpage; // 화면에 보여질 마지막페이지 번호
	int curpage; // 이동하고자 하는 페이지 번호

	String strList=""; // 리턴될 페이지 인덱스 리스트

	pagenumber = 10; // 한 화면의 페이지 인덱스 수 

	// 시작 페이지번호 구하기
	startpage = ((current_page - 1) / pagenumber) * pagenumber + 1;

	// 마지막 페이지번호 구하기
	endpage = (((startpage - 1) + pagenumber) / pagenumber) * pagenumber;

	// 총 페이지 수가 계산된 마지막페이지 번호보다 작을경우 

	// 총 페이지 수가 마지막페이지 번호가 됨


	if (total_page <= endpage){
		endpage = total_page;
	}//end if

	// 첫번째 페이지 인덱스 화면이 아닌경우
	if ( current_page > pagenumber) {
		curpage = startpage - 1; // 시작페이지 번호보다 1 적은 페이지로 이동
		strList = strList + "[ <a href="+list_url+"currentPage="+curpage+">&lt;&lt;</a> ]";
	}else{
		strList = strList + "<img src='http://localhost:8080/team_prj3_class4/common/images/left.png'/>";
	}

	strList = strList + " ... ";

	// 시작페이지 번호부터 마지막페이지 번호까지 화면에 표시
	curpage = startpage;

	while (curpage <= endpage){
		if (curpage == current_page) {
			strList = strList + "["+current_page+"]";
		} else {
			strList = strList +"[ <a href="+list_url+"currentPage="+curpage+">"+curpage+"</a> ]";
		}//end else

		curpage++;
	}//end while

	strList = strList + " ... ";

	// 뒤에 페이지가 더 있는경우
	if ( total_page > endpage) {
		curpage = endpage + 1; 
		strList = strList + "[ <a href="+list_url+"currentPage="+curpage+">&gt;&gt;</a> ]";
	}else{
		strList = strList + "<img src='http://localhost:8080/team_prj3_class4/common/images/right.png'/>";
	}//end else

	return strList;
	}//indexList
	
	
}//class
