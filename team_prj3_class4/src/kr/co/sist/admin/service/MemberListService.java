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
	 * 총게시물의 수 얻기
	 * @return
	 */
	public int totalCount() {
		int cnt=0;
		cnt=a_dao.selectTotalCount();
		return cnt;
	}//totalCount
	
	/**
	 * 한페이지에 보여줄 게시물의 수 
	 * @return
	 */
	public int pageScale( ) {
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
		if(totalCount % pageScale() != 0){
			totalPage++;
		}//end if
		return totalPage;
	}//totalPage
	
	/**
	 * 선택한 인덱스 리스트에서 조회할 시작 번호
	 * @param currentPage
	 * @return
	 */
	public int startNum( int currentPage ) {
		int startNum=1;
		startNum= currentPage*pageScale()-pageScale()+1;
		return startNum;
	}//startNum
	
	/**
	 * 선택한 인덱스 리스트에서 조회할 끝번호
	 * @param startNum
	 * @return
	 */
	public int endNum(int startNum) {
		int endNum=startNum+pageScale()-1;
		return endNum;
	}//endNum

	/**
	 *  인덱스 리스트  [ << ] ...  [1][2][3] ... [ >> ]
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
			strList = strList + "[ <a href="+list_url+"?currentPage="+curpage+"> &lt;&lt; </a> ]";
		}else{
			strList = strList + "[ << ]";
		}//end else
	
		strList = strList + " ... ";
	
		// 시작페이지 번호부터 마지막페이지 번호까지 화면에 표시
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
	
		// 뒤에 페이지가 더 있는경우
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
		
		//글의 제목은 24자 까지만 보여준다.
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
