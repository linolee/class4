package kr.co.sist.admin.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.dao.TeacherDAO;
import kr.co.sist.admin.domain.TeacherCareer;
import kr.co.sist.admin.domain.TeacherDetailDomain;
import kr.co.sist.admin.domain.TeacherDomain;
import kr.co.sist.admin.domain.TeacherLesson;
import kr.co.sist.admin.vo.ListVO;

@Component
public class TeacherService {

	@Autowired
	private TeacherDAO t_dao;
	
	public int totalCount() {
		int cnt=0;
		cnt=t_dao.teacherTotalCount();
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
			
		public List<TeacherDomain> selectAllTeacher(ListVO lvo){
			List<TeacherDomain> list=null;
			list=t_dao.selectAllTeacher(lvo);
			return list;
		}
			
		public JSONObject selectDeatailTeacher(String teacherName) {
			JSONObject json=new JSONObject();
			JSONArray json_arr=new JSONArray();
			JSONArray json_arr2=new JSONArray();
			TeacherDAO tdao=new TeacherDAO();
			TeacherDetailDomain tdd=tdao.selectTeacherDetail(teacherName);
			List<TeacherLesson> listLesson=null;
			List<TeacherCareer> listCareer=null;
			listLesson=tdao.selectLesson(teacherName);
			listCareer=tdao.selectCareer(teacherName);
			
		try {
			json.put("tId", tdd.getClientId());
			json.put("tCate", URLEncoder.encode(tdd.getCategory(),"UTF-8"));
			json.put("tName", URLEncoder.encode(tdd.getName(),"UTF-8"));
			json.put("tTName",URLEncoder.encode(tdd.getTeacherName(), "UTF-8"));
			json.put("tGender", tdd.getGender());
			json.put("tBirth", tdd.getBirth());
			json.put("tTel", tdd.getTel());
			json.put("tInputdate", tdd.getInputdate());
			json.put("tEmail", tdd.getEmail());
			json.put("tIntroduce", URLEncoder.encode(tdd.getIntroduce(),"UTF-8"));		

			
			JSONObject json_temp=null;
			JSONObject json_temp2=null;
			
			if(!listLesson.isEmpty()) {
				for(int i=0; i<listLesson.size();i++) {
					json_temp=new JSONObject();
					json_temp.put("lessonName", URLEncoder.encode(listLesson.get(i).getLname(), "UTF-8"));
					//json_temp.put("lessonName", listLesson.get(i).getLname());
					json_temp.put("lessonStatus", listLesson.get(i).getStatus());
					json_arr.add(json_temp);
					System.out.println("----------------------------------------- lesson : "+listLesson.get(i).getLname());
				}
			}
			
			json.put("lessonList", json_arr);
			
			if(!listCareer.isEmpty()) {
				for(int i=0; i<listCareer.size();i++) {
					json_temp2=new JSONObject();
					/*json_temp2.put("career", URLEncoder.encode(listCareer.get(i).getCareer(), "UTF-8"));*/
					json_temp2.put("career", URLEncoder.encode(listCareer.get(i).getCareer(), "UTF-8"));
					
					System.out.println("--------------------------------- career : "+listCareer.get(i));
					
					json_arr2.add(json_temp2);
				}
			}
			
			json.put("careerList", json_arr2);
			
			////////////////////////// JSONArray 1개로 합칠 수 있으면 합치자 !!
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			//System.out.println("-------------------------"+json.toJSONString());
			return json;
		}
			
		public static void main(String[] args) {
			TeacherService ts=new TeacherService();
			ts.selectDeatailTeacher("백인재");
		}
}
