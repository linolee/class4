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

	// 1. ��ü �Խù� �� ���
		public int totalCount() {
			int cnt = 0;
			cnt = a_dao.selectTotalCount();
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
		
	public int ifBlack(String id) {
		int chkBlack=a_dao.ifBlack(id);
		//int chkTeacher=a_dao.ifTeacher(id);
		//StringBuilder chkBlackT=new StringBuilder();
		
/*		if(chkBlack==1) {
			chkBlackT
			.append("<a data-toggle='modal' href='#modalAddBlackList' onclick='addBlack(")
			.append(id)
			.append(")'><span class='badge badge-warning'>������Ʈ ���</span></a>");
		}*/
		
		/*if(chkTeacher==1) {
			chkBlackTeacher
			.append("<a data-toggle='modal' href='#teacherInfo' onclick='addBlack(")
			.append(id)
			.append(")'><span class='badge badge-primary'>��������</span></a>");
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
			.append(")'><span class='badge badge-warning'>������Ʈ ���</span></a>").toString());
		}
		return list2;
	}
	
	//ȸ�� �󼼺���
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
