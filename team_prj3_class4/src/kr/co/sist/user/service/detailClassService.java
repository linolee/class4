package kr.co.sist.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.user.dao.DetailDAO;
import kr.co.sist.user.domain.Addr;
import kr.co.sist.user.domain.ClassTime;
import kr.co.sist.user.domain.DetailContents;
import kr.co.sist.user.domain.Join;
import kr.co.sist.user.domain.JoinCount;
import kr.co.sist.user.domain.QnA;
import kr.co.sist.user.domain.ReviewDomain;
import kr.co.sist.user.domain.Star;
import kr.co.sist.user.domain.Summary;
import kr.co.sist.user.domain.TClass;
import kr.co.sist.user.vo.ListVO;
import kr.co.sist.user.vo.ReviewListVO;

@Component
public class detailClassService {

	@Autowired
	private DetailDAO d_dao;
	
	public List<String> olist;
		
	public DetailDAO showContents(String lcode) {
		DetailDAO d_dao=null;
		return d_dao;
	}//showContentsForm
	
	public Summary searchSummary(String lcode){
		Summary summary=null;
		summary=d_dao.selectSummary(lcode);
		return summary;
	}//showMenuCategory
	
	public Star searchStar(String lcode){
		Star star=null;
		star=d_dao.selectStar(lcode);
		return star;
	}//showMenuCategory
	
	public List<String> searchCareer(String lcode){
		List<String> careerlist=null;
		careerlist=d_dao.selectCareer(lcode);
		
		return careerlist;
	}//showMenuCategory
	
	public DetailContents searchDeContents(String lcode) {
		DetailContents detailc=null;
		detailc=d_dao.selectDeContents(lcode);
		return detailc;
	}//searchContents
	
	public List<String> searchOpt(String lcode) {
		List<String> optlist=null;
		optlist=d_dao.selectOpt(lcode);
		olist=d_dao.selectOpt(lcode);
		return optlist;
	}//searchOpt
	
	public List<String> searchNoOpt() {
		List<String> noptlist=null;
		noptlist=d_dao.selectNoOpt();
		for(int a=0; a<olist.size(); a++) {
			for(int b=0; b<noptlist.size(); b++) {
				if(noptlist.get(b).equals(olist.get(a)) ) {
					noptlist.remove(olist.get(a));
				}//end if
			}//end for
		}//end for
		return noptlist;
	}//searchNoOpt
	
	public List<ReviewDomain> searchRvList(ReviewListVO rvlistvo){
		List<ReviewDomain> rvlist=null;
		rvlist=d_dao.selectReviewList(rvlistvo);
		return rvlist;
	}//searchRvList
	
	// 1. 전체 게시물 수 얻기
	public int RtotalCount(String lcode) {
		int cnt = 0;
		cnt = d_dao.selectRTotalCount(lcode);
		return cnt;
	}

	// 2. 한 화면에 보여질 게시물의 수
	public int RpageScale() {
		int pageScale = 6;

		return pageScale;
	}

	// 3. 총 페이지 수 구하기
	public int RtotalPage(int totalCount) {
		int totalPage = totalCount / RpageScale();
		if (totalCount % RpageScale() != 0) {
			totalPage++;
		}

		return totalPage;
	}

	// 4. 시작 페이지 번호 구하기
	// current_page에 따라 시작 번호는 달라진다. 1-> 1, 2->11, 3->21 ,,,
	public int RstartNum(int currentPage) {
		int startNum = 1;
		startNum = currentPage * RpageScale() - RpageScale() + 1;
		return startNum;
	}

	// 5. 끝번호 얻기
	public int RendNum(int startNum) {
		int endNum = startNum + RpageScale() - 1;

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
	// 현재 게시판의 페이지 인덱스 설정
	public String RindexList(int current_page, int total_page, String list_url,String lcode) {
		int pagenumber; // 화면에 보여질 페이지 인덱스 수
		int startpage; // 화면에 보여질 시작페이지 번호
		int endpage; // 화면에 보여질 마지막페이지 번호
		int curpage; // 이동하고자 하는 페이지 번호

		String strList = ""; // 리턴될 페이지 인덱스 리스트

		pagenumber = 5; // 한 화면의 페이지 인덱스 수

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
			strList = strList + "<li class='page-item'>[<a class='page-link' href=" + list_url + "&currentPage=" + curpage + "#review"+">Prev</a>]</li>";
		} else {
			strList = strList + "<li class='page-item'>[<a class='page-link' href='#review'>Prev</a>]</li>";
			
		}

		// 시작페이지 번호부터 마지막페이지 번호까지 화면에 표시
		curpage = startpage;

		while (curpage <= endpage) {
			if (curpage == current_page) {
				strList = strList + "<li class='page-item active'>[<a class='page-link' href='#review'>"+current_page+"</a>]";
			} else {
				strList = strList + "<li class='page-item'>[<a class='page-link' href=" + list_url + "&currentPage="+curpage+"#review"+">"+curpage+ "</a>]</li>";
			} // end else

			curpage++;
		} // end while

		// 뒤에 페이지가 더 있는경우
		if (total_page > endpage) {
			curpage = endpage + 1;
			strList = strList + "<li class='page-item'>[<a class='page-link' href="+list_url+"&currentPage="+curpage+"#review"+">Next</a>]</li>";
		} else {
			strList = strList + "<li class='page-item'>[<a class='page-link' href='#review'>Next</a>]</li>";
		} // end else

		return strList;
	}// indexList
	
	public List<QnA> searchQnaList(String lcode) {
		List<QnA> qnalist=null;
		qnalist=d_dao.selectQnaList(lcode);
		return qnalist;
	}//searchQnaList
	
	// 1. 전체 게시물 수 얻기
	public int QtotalCount() {
		int qcnt = 0;
		qcnt = d_dao.selectQTotalCount();
		return qcnt;
	}

	// 2. 한 화면에 보여질 게시물의 수
	public int QpageScale() {
		int qpageScale = 1;

		return qpageScale;
	}

	// 3. 총 페이지 수 구하기
	public int QtotalPage(int qtotalCount) {
		int qtotalPage = qtotalCount / QpageScale();
		if (qtotalCount % QpageScale() != 0) {
			qtotalPage++;
		}

		return qtotalPage;
	}

	// 4. 시작 페이지 번호 구하기
	// current_page에 따라 시작 번호는 달라진다. 1-> 1, 2->11, 3->21 ,,,
	public int QstartNum(int qcurrentPage) {
		int qstartNum = 1;
		qstartNum = qcurrentPage * QpageScale() - QpageScale() + 1;
		return qstartNum;
	}

	// 5. 끝번호 얻기
	public int qendNum(int qstartNum) {
		int qendNum = qstartNum + QpageScale() - 1;

		return qendNum;
	}
	
	/**
	 * 인덱스 리스트 [ << ] ... [1][2][3] ... [ >> ]
	 * 
	 * @param current_page
	 * @param total_page
	 * @param list_url
	 * @return
	 */
	// 현재 게시판의 페이지 인덱스 설정
	public String indexList(int qcurrent_page, int qtotal_page, String qlist_url) {
		int qpagenumber; // 화면에 보여질 페이지 인덱스 수
		int qstartpage; // 화면에 보여질 시작페이지 번호
		int qendpage; // 화면에 보여질 마지막페이지 번호
		int qcurpage; // 이동하고자 하는 페이지 번호

		String qstrList = ""; // 리턴될 페이지 인덱스 리스트

		qpagenumber = 5; // 한 화면의 페이지 인덱스 수

		// 시작 페이지번호 구하기
		qstartpage = ((qcurrent_page - 1) / qpagenumber) * qpagenumber + 1;

		// 마지막 페이지번호 구하기
		qendpage = (((qstartpage - 1) + qpagenumber) / qpagenumber) * qpagenumber;

		// 총 페이지 수가 계산된 마지막페이지 번호보다 작을경우

		// 총 페이지 수가 마지막페이지 번호가 됨

		if (qtotal_page <= qendpage) {
			qendpage = qtotal_page;
		} // end if

		// 첫번째 페이지 인덱스 화면이 아닌경우
		if (qcurrent_page > qpagenumber) {
			qcurpage = qstartpage - 1; // 시작페이지 번호보다 1 적은 페이지로 이동
			qstrList = qstrList + "<li class='page-item'><a class='page-link' href=" + qlist_url + "?currentPage=" + qcurpage + ">Prev</a></li>";
		} else {
			qstrList = qstrList + "<li class='page-item'><a class='page-link' href='#'>Prev</a></li>";
			
		}

		// 시작페이지 번호부터 마지막페이지 번호까지 화면에 표시
		qcurpage = qstartpage;

		while (qcurpage <= qendpage) {
			if (qcurpage == qcurrent_page) {
				qstrList = qstrList + "<li class='page-item active'><a class='page-link' href='#'>"+qcurrent_page+"</a>";
			} else {
				qstrList = qstrList + "<li class='page-item'><a class='page-link' href=" + qlist_url + "?currentPage="+qcurpage+">"+qcurpage+"</a></li>";
			} // end else

			qcurpage++;
		} // end while

		// 뒤에 페이지가 더 있는경우
		if (qtotal_page > qendpage) {
			qcurpage = qendpage + 1;
			qstrList = qstrList + "<li class='page-item'><a class='page-link' href="+qlist_url+"?currentPage="+qcurpage+">Next</a></li>";
		} else {
			qstrList = qstrList + "<li class='page-item'><a class='page-link' href='#'>Next</a></li>";
		} // end else

		return qstrList;
	}// indexList
	
	public List<TClass> searchTclassList(String lcode) {
		List<TClass> tclist=null;
		tclist=d_dao.selectTclassList(lcode);
		return tclist;
	}//searchTclassList

 	public List<String> searchClassday(String lcode) {
		List<String> day=null;
		day=d_dao.selectClassday(lcode);
		return day;
	}//searchClassday

 	public ClassTime searchClassTime(String lcode) {
		ClassTime classTime=null;
		classTime=d_dao.selectClassTime(lcode);
		return classTime;
	}//searchClassTime

 	public JoinCount searchJoinCount(String lcode) {
		JoinCount joinCount=null;
		joinCount=d_dao.selectJoinCount(lcode);
		return joinCount;
	}//searchJoinCount

 	public String searchLike(String lcode) {
		String like=null;
		like=d_dao.selectLike(lcode);
		return like;
	}//searchLike
 	
 	public Addr searchAddr(String lcode) {
 		Addr addr=null;
 		addr=d_dao.selectBar(lcode);
 		return addr;
 	}//searchAddr
 	
 	public Join joinStatus(ListVO lvo) {
 		Join joinStatus=null;
 		joinStatus=d_dao.joinStatus(lvo);
 		return joinStatus;
 	}//joinStatus
 	
	public boolean insertJoin(ListVO lvo) {
		boolean flag=false;
		flag=d_dao.insertJoin(lvo);
		return flag;
	}//insertJoin
	
	public boolean updateJoin(ListVO lvo) {
		boolean flag=false;
		flag=d_dao.updateJoin(lvo);
		return flag;
	}//insertJoin
	
	public boolean cancelJoin(ListVO lvo) {
		boolean flag=false;
		flag=d_dao.cancelJoin(lvo);
		return flag;
	}//cancelJoin

	
}//class
