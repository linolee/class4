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
import kr.co.sist.admin.vo.OptionSearchVO;

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

		
	public int ifBlack(String id) {
		int chkBlack=a_dao.ifBlack(id);
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
	
	public List<MemberListDomain> memberOptionSearch(OptionSearchVO osvo){
		List<MemberListDomain> list=null;
		list=a_dao.memberOptionSearch(osvo);
		return list;
	}
	
	

}
