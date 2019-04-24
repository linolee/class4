package kr.co.sist.admin.service;

import java.util.List;

import kr.co.sist.admin.dao.MemberListDAO;
import kr.co.sist.admin.domain.MemberListDomain;

public class MemberListService {

	public List<MemberListDomain> selectAllMember(){
		List<MemberListDomain> list=null;
		
		MemberListDAO a_dao=MemberListDAO.getInstance();
		
		list= a_dao.selectAllMember();
		
/*		MemberDomain md=null;
		for(int i=0;i<list.size();i++) {
			md=list.get(i);
			
			
			
			System.out.println(md.getClient_id()+" / "+ md.getName()+"/ "+md.getBirth()+" / "+md.getGender()+" / "+md.getEmail());
		}*/
		
		return list;
	}
	
	
/*	public static void main(String[] args) {
		System.out.println(AdminDAO.getInstance().getSessionFactory());
		AdminService as=new AdminService();
		as.selectAllMember();
	}*/
	
	
	
	
	
}
