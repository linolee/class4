package kr.co.sist.admin.service;

import java.util.List;

import kr.co.sist.admin.dao.AdminDAO;
import kr.co.sist.admin.domain.MemberDomain;

public class AdminService {

	public List<MemberDomain> selectMember(){
		List<MemberDomain> list=null;
		
		AdminDAO a_dao=AdminDAO.getInstance();
		
		list= a_dao.selectMember();
		
		return list;
	}
	
	
}
