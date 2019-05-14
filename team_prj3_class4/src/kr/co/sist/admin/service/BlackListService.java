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
	
	// 1. 전체 게시물 수 얻기
		public int totalCount() {
			int cnt = 0;
			cnt = bl_dao.selectTotalCount();
			return cnt;
		}

	public List<BlackListDomain> selectBlackList(ListVO lvo){
		List<BlackListDomain> list=null;
		list=bl_dao.selectBlackList(lvo);
		return list;
	}
	
	public JSONObject detailBlack(String id) {
		JSONObject json=new JSONObject();
		
		BlackListDAO bldao=BlackListDAO.getInstance();
		
		BlackListDetailVO bldvo=bldao.selectDetailBlackList(id);
		
		try {
		//DB조회 결과를 JSONObject 추가
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
		bls.deleteBlack("asdf");
	}
}