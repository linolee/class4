package kr.co.sist.admin.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.dao.BlackListDAO;
import kr.co.sist.admin.domain.BlackListDomain;
import kr.co.sist.admin.vo.BlackListDetailVO;
import kr.co.sist.admin.vo.ListVO;
import kr.co.sist.admin.vo.OptionSearchVO;
import kr.co.sist.user.domain.Blacklist;

@Component
public class BlackListService {

	@Autowired
	private BlackListDAO bl_dao;
	
	// 1. ��ü �Խù� �� ���
		public int totalCount() {
			int cnt = 0;
			cnt = bl_dao.selectTotalCount();
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
	
	public List<BlackListDomain> selectBlackList(ListVO lvo){
		List<BlackListDomain> list=null;
		list=bl_dao.selectBlackList(lvo);
		return list;
	}
	
	
	/*public BlackListDetailVO bldvl(String id) {
		BlackListDAO mldao=BlackListDAO.getInstance();
		BlackListDetailVO bldvo=mldao.selectDetailBlackList(id);
		return bldvo;
	}*/
	
	///////////////////////
	public JSONObject detailBlack(String id) {
		JSONObject json=new JSONObject();
		
		BlackListDAO bldao=BlackListDAO.getInstance();
		
		BlackListDetailVO bldvo=bldao.selectDetailBlackList(id);
		
		try {
		//DB��ȸ ����� JSONObject �߰�
		json.put("idResult",  bldvo.getClient_id());
		json.put("name", URLEncoder.encode(bldvo.getName(),"UTF-8"));
		json.put("birth", bldvo.getBirth());
		json.put("gender", bldvo.getGender());
		json.put("tel", bldvo.getTel());
		json.put("inputdate", bldvo.getInputdate());
		json.put("email", bldvo.getEmail());
		json.put("reason", URLEncoder.encode(bldvo.getReason(), "UTF-8")); 
		json.put("b_date", bldvo.getB_date());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String jjj=json.toJSONString();
		System.out.println(jjj);
		return json;
	}//searchId
	
	public boolean deleteBlack(String id) {
		BlackListDAO bldao=BlackListDAO.getInstance();
		boolean flag= false;
		if(bldao.deleteBlackList(id)) {
			flag=true;
		}
		return flag;
	}
	
	public List<BlackListDomain> blackOptionSearch(OptionSearchVO osvo){
		List<BlackListDomain> list=null;
		BlackListDAO bldao=BlackListDAO.getInstance();
		list=bldao.blackOptionSearch(osvo);
		return list;
	}
	
	
	
	
	public static void main(String[] args) {
		BlackListService bls=new BlackListService();
//		bls.selectDetailBlackList("1");
//		bls.bldvl("1");
		//bls.detailBlack("2");
		bls.deleteBlack("asdf");
		
	}
		
}