package kr.co.sist.user.service;

import javax.servlet.http.HttpSession;

import kr.co.sist.user.dao.LoginDAO;
import kr.co.sist.user.dao.LoginDaoImpl;
import kr.co.sist.user.domain.Client;
import kr.co.sist.user.vo.UserLoginVO;

public class UserLoginServiceImpl implements UserLoginService{
	private LoginDAO l_dao;
	
	public UserLoginServiceImpl(LoginDAO l_dao) {
		this.l_dao = l_dao;
	}
	
	public String login(UserLoginVO ulvo) {
		
		//������ VO�� ����Ͽ� DB���� ��ȸ
		Client ld = l_dao.selectClient(ulvo);//LoginDomain���� id, name, status�� ����Ǿ��ִ�.
		if (ld != null) {//��ȸ�� ������ ���� ��, �α��� ������ ���� ��
			//status�� Ȯ��
			//����/Ż�� �� ���̵��� ��� ���â���� ������
			if ("".equals(ld.getStatus())) {
				
			}
			//����/Ż�� �� ���̵� �ƴ� ��� ������ ����
		}else {//��ȸ�� ������ ���� ��, �α��� ������ Ʋ�� ��
			//�α��� â���� �ٽ� ������ 
		}
		
		
		return "";
	}
	
	//�Է������� ��ġ�ϸ� ������ �����ؼ� ��ȯ 
	
	

}
