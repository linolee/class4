package kr.co.sist.user.service;

import javax.servlet.http.HttpSession;

import kr.co.sist.user.dao.UserLoginDAO;
import kr.co.sist.user.domain.LoginDomain;
import kr.co.sist.user.vo.UserLoginVO;

public class UserLoginService {
	UserLoginDAO ul_dao = UserLoginDAO.getInstance();
	public boolean login(UserLoginVO ulvo) {
		//������ VO�� ����Ͽ� DB���� ��ȸ
		LoginDomain ld = ul_dao.selectAccount(ulvo);
		if (ld != null) {//��ȸ�� ������ ���� ��, �α��� ������ ���� ��
			
		}else {//��ȸ�� ������ ���� ��, �α��� ������ Ʋ�� ��
			
		}
		
		
		return false;
	}
	
	//�Է������� ��ġ�ϸ� ������ �����ؼ� ��ȯ 
	
	

}
