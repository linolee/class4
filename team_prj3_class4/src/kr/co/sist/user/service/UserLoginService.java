package kr.co.sist.user.service;

import javax.servlet.http.HttpSession;

import kr.co.sist.user.dao.UserLoginDAO;
import kr.co.sist.user.domain.LoginDomain;
import kr.co.sist.user.vo.UserLoginVO;

public class UserLoginService {
	UserLoginDAO ul_dao = UserLoginDAO.getInstance();
	public boolean login(UserLoginVO ulvo) {
		//생성된 VO를 사용하여 DB에서 조회
		LoginDomain ld = ul_dao.selectAccount(ulvo);
		if (ld != null) {//조회된 정보가 있을 때, 로그인 정보가 맞을 때
			
		}else {//조회된 정보가 없을 때, 로그인 정보가 틀릴 때
			
		}
		
		
		return false;
	}
	
	//입력정보가 일치하면 세션을 생성해서 반환 
	
	

}
