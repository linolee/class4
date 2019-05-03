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
			
		public List<TeacherDomain> selectAllTeacher(ListVO lvo){
			List<TeacherDomain> list=null;
			list=t_dao.selectAllTeacher(lvo);
			return list;
		}
			
		public JSONObject selectDeatailTeacher(String teacherName) {
			JSONObject json=new JSONObject();
			JSONArray json_arr=new JSONArray();
			JSONArray json_arr2=new JSONArray();
			
			TeacherDetailDomain tdd=t_dao.selectTeacherDetail(teacherName);
			List<TeacherLesson> listLesson=null;
			List<TeacherCareer> listCareer=null;
			
//		try {
			json.put("tId", tdd.getClientId());
			json.put("tCate", tdd.getCategory());
			json.put("tName", tdd.getName());
			json.put("tTName", tdd.getTeacherName());
			json.put("tGender", tdd.getGender());
			json.put("tBirth", tdd.getBirth());
			json.put("tTel", tdd.getTel());
			json.put("tInputdate", tdd.getInputdate());
			json.put("tEmail", tdd.getEmail());
			json.put("tIntroduce", tdd.getIntroduce());
			
			JSONObject json_temp=null;
			JSONObject json_temp2=null;
			
			/*if(!listLesson.isEmpty()) {
				for(int i=0; i<listLesson.size();i++) {
					json_temp=new JSONObject();
					json_temp.put("lessonName", URLEncoder.encode(listLesson.get(i).getLesson(),"UTF-8"));
					json_temp.put("lessonStatus", listLesson.get(i).getStatus());
					json_arr.add(json_temp);

				}
			}
			
			json.put("lessonList", json_arr);
			
			if(!listCareer.isEmpty()) {
				for(int i=0; i<listCareer.size();i++) {
					json_temp2=new JSONObject();
					json_temp2.put("career", URLEncoder.encode(listCareer.get(i).getCareer(), "UTF-8"));
					json_arr2.add(json_temp2);
				}
			}
			
			json.put("carrerList", json_arr2);*/
			
			////////////////////////// JSONArray 1���� ��ĥ �� ������ ��ġ�� !!
			
/*		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}*/
			
			return json;
		}
			
			
}
