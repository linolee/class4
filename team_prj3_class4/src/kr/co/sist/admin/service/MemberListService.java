package kr.co.sist.admin.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.dao.MemberListDAO;
import kr.co.sist.admin.domain.MemberDetail;
import kr.co.sist.admin.domain.MemberLesson;
import kr.co.sist.admin.domain.MemberListDomain;
import kr.co.sist.admin.domain.TeacherCareer;
import kr.co.sist.admin.domain.TeacherIntro;
import kr.co.sist.admin.vo.AddBlackVO;
import kr.co.sist.admin.vo.ListVO;

@Component
public class MemberListService {

	@Autowired
	private MemberListDAO a_dao;

	// 1. 전체 게시물 수 얻기
		public int totalCount() {
			int cnt = 0;
			cnt = a_dao.selectTotalCount();
			return cnt;
		}

		// 2. 한 화면에 보여질 게시물의 수
		public int pageScale() {
			int pageScale = 10;

			return pageScale;
		}

		// 3. 총 페이지 수 구하기
		public int totalPage(int totalCount) {
			int totalPage = totalCount / pageScale();
			if (totalCount % pageScale() != 0) {
				totalPage++;
			}

			return totalPage;
		}

		// 4. 시작 페이지 번호 구하기
		// current_page에 따라 시작 번호는 달라진다. 1-> 1, 2->11, 3->21 ,,,
		public int startNum(int currentPage) {
			int startNum = 1;
			startNum = currentPage * pageScale() - pageScale() + 1;
			return startNum;
		}

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
		// 현재 게시판의 페이지 인덱스 설정
		public String indexList(int current_page, int total_page, String list_url) {
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
				strList = strList + "<li class='page-item'><a class='page-link' href=" + list_url + "?currentPage=" + curpage + ">Prev</a></li>";
			} else {
				strList = strList + "<li class='page-item'><a class='page-link' href='#'>Prev</a></li>";
				
			}

			// 시작페이지 번호부터 마지막페이지 번호까지 화면에 표시
			curpage = startpage;

			while (curpage <= endpage) {
				if (curpage == current_page) {
					strList = strList + "<li class='page-item active'><a class='page-link' href='#'>"+current_page+"</a>";
				} else {
					strList = strList + "<li class='page-item'><a class='page-link' href=" + list_url + "?currentPage="+curpage+">"+curpage+"</a></li>";
				} // end else

				curpage++;
			} // end while

			// 뒤에 페이지가 더 있는경우
			if (total_page > endpage) {
				curpage = endpage + 1;
				strList = strList + "<li class='page-item'><a class='page-link' href="+list_url+"?currentPage="+curpage+">Next</a></li>";
			} else {
				strList = strList + "<li class='page-item'><a class='page-link' href='#'>Next</a></li>";
			} // end else

			return strList;
		}// indexList
		
	public int ifBlack(String id) {
		int chkBlack=a_dao.ifBlack(id);
		//int chkTeacher=a_dao.ifTeacher(id);
		//StringBuilder chkBlackT=new StringBuilder();
		
/*		if(chkBlack==1) {
			chkBlackT
			.append("<a data-toggle='modal' href='#modalAddBlackList' onclick='addBlack(")
			.append(id)
			.append(")'><span class='badge badge-warning'>블랙리스트 등록</span></a>");
		}*/
		
		/*if(chkTeacher==1) {
			chkBlackTeacher
			.append("<a data-toggle='modal' href='#teacherInfo' onclick='addBlack(")
			.append(id)
			.append(")'><span class='badge badge-primary'>강사정보</span></a>");
		}*/
		
		
		//return chkBlackT.toString();
		return chkBlack;
	}

	public List<MemberListDomain> selectAllMember(ListVO lvo) {
		List<MemberListDomain> list = null;
		list = a_dao.selectAllMember(lvo);
		return list;
	}
	public List<String> memberBlack(ListVO lvo) {
		StringBuilder dx= new StringBuilder();
		
		List<String> list = null;
		List<String> list2=new ArrayList<String>();
		list = a_dao.memberBlack(lvo);
		
		for(int i=0;i<list.size();i++) {
			list2.add(dx
			.append("<a data-toggle='modal' href='#modalAddBlackList' onclick='addBlack(")
			.append(list.get(i))
			.append(")'><span class='badge badge-warning'>블랙리스트 등록</span></a>").toString());
		}
		return list2;
	}
	
	//회원 상세보기
	public JSONObject searchMemberDetail(String id) {
		JSONObject json = new JSONObject();
		JSONArray json_arr = new JSONArray();
		
		MemberDetail md=a_dao.selectDetailMember(id);
		List<MemberLesson> list = null;
		list=a_dao.selectMemberLesson(id);
		
		try {
			json.put("jid", md.getClient_id());
			json.put("jname", URLEncoder.encode(md.getName(),"UTF-8"));
			json.put("jbirth", md.getBirth());
			json.put("jgender", md.getGender());
			json.put("jtel", md.getTel());
			json.put("jinputdate", md.getInputdate());
			json.put("jemail", md.getEmail());
			
			JSONObject json_temp = null;
			if(!list.isEmpty()) {
				for(int i=0; i<list.size(); i++) {
					json_temp = new JSONObject();
					json_temp.put("lessonName", URLEncoder.encode(list.get(i).getLname(),"UTF-8"));
					json_temp.put("lessonStatus", list.get(i).getStatus());
					json_arr.add(json_temp);
				}
			}
			json.put("lessonList", json_arr);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	
	public JSONObject addBlack(AddBlackVO abvo) {
		
		JSONObject json=new JSONObject();
		int cnt=0;
		
		cnt=a_dao.insertBlack(abvo);
		json.put("result", cnt==1);
		
		return json;
	}
	
	
	

}
