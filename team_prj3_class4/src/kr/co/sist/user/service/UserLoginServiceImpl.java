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
		
		//������ VO�� ����Ͽ� DB���� ��ȸ
		LoginDomain ld = l_dao.selectAccount(ulvo);
		if (ld != null) {//��ȸ�� ������ ���� ��, �α��� ������ ���� ��
			//status�� Ȯ��
			//����/Ż�� �� ���̵��� ��� ���â���� ������
			//����/Ż�� �� ���̵� �ƴ� ��� ������ ����
		}else {//��ȸ�� ������ ���� ��, �α��� ������ Ʋ�� ��
			//�α��� â���� �ٽ� ������ 
		}
		
		
		return false;
	}
	
	//�Է������� ��ġ�ϸ� ������ �����ؼ� ��ȯ 
	
	

}
