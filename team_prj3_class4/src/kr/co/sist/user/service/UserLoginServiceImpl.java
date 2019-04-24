package kr.co.sist.user.service;

import javax.servlet.http.HttpSession;

import kr.co.sist.user.dao.LoginDAO;
import kr.co.sist.user.dao.LoginDaoImpl;
import kr.co.sist.user.domain.LoginDomain;
import kr.co.sist.user.vo.UserLoginVO;

public class UserLoginServiceImpl implements UserLoginService{
	private LoginDAO l_dao;
	
	public UserLoginServiceImpl(LoginDAO l_dao) {
		this.l_dao = l_dao;
	}
	
	public boolean login(UserLoginVO ulvo) {
		
		//생성된 VO를 사용하여 DB에서 조회
		LoginDomain ld = l_dao.selectAccount(ulvo);
		if (ld != null) {//조회된 정보가 있을 때, 로그인 정보가 맞을 때
			//status를 확인
			//정지/탈퇴 된 아이디일 경우 경고창으로 보내기
			//정지/탈퇴 된 아이디가 아닐 경우 세션을 생성
		}else {//조회된 정보가 없을 때, 로그인 정보가 틀릴 때
			//로그인 창으로 다시 보내기 
		}
		
		
		return false;
	}
	
	//입력정보가 일치하면 세션을 생성해서 반환 
	
	

}
