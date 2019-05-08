package kr.co.sist.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.user.dao.UserMypageDAO;
import kr.co.sist.user.dao.UserQnaDAO;
import kr.co.sist.user.vo.ListVO;
import kr.co.sist.user.vo.QnaVO;

@Component
public class UserQnaService {
	@Autowired
	private UserQnaDAO uq_dao;
	
	public boolean insertQna(QnaVO qvo) {
		boolean flag=false;
		flag=uq_dao.insertQna(qvo);
		return flag;
	}//insertQna
	
}//class
