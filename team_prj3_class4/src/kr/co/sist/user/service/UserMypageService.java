package kr.co.sist.user.service;

import java.util.List;

import org.springframework.stereotype.Component;

import kr.co.sist.user.dao.UserMypageDAO;
import kr.co.sist.user.domain.ClassList;
import kr.co.sist.user.vo.ListVO;

@Component
public class UserMypageService {
	public List<ClassList> classList(ListVO lvo){
		List<ClassList> list=null;
		
		UserMypageDAO mb_dao=UserMypageDAO.getInstance();
		list=mb_dao.selectClass(lvo);
		
		return list;
	}//classList
	
	public List<String> lcodeList(String clientId){
		List<String> list=null;
		
		UserMypageDAO mb_dao=UserMypageDAO.getInstance();
		list=mb_dao.selectLcode(clientId);
		
		return list;
	}//lcodeList
}//class
