package kr.co.sist.user.service;

import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import kr.co.sist.user.dao.LoginDAO;
import kr.co.sist.user.dao.LoginDaoImpl;
import kr.co.sist.user.domain.Blacklist;
import kr.co.sist.user.domain.Client;
import kr.co.sist.user.domain.DeletedUser;
import kr.co.sist.user.vo.UserLoginVO;

public class UserLoginServiceImpl implements UserLoginService{
	private LoginDAO l_dao;
	public static int login_success = 0;
	public static int login_fail = 1;
	public static int login_blacklist = 2;
	public static int login_deletedUser= 3;
	
	public UserLoginServiceImpl(LoginDAO l_dao) {
		this.l_dao = l_dao;
	}
	
	public int login(UserLoginVO ulvo, HttpSession session) {
		
		//������ VO�� ����Ͽ� DB���� ��ȸ
		//Ŭ���̾�Ʈ���� ��ȸ
		Client client = l_dao.selectClient(ulvo);//Client���� id, name, status�� ����Ǿ��ִ�.
		//��ȸ�� ���� ���� ��
		if (client == null) {
			System.out.println("���̵�, ��й�ȣ�� �ٽ� �Է����ּ���");
			return login_fail;
		}
		//������Ʈ���� ��ȸ
		Blacklist blacklist = l_dao.selectBlacklist(ulvo.getId());
		//��������Ʈ���� ��ȸ
		DeletedUser deletedUser = l_dao.selectDeletedUser(ulvo.getId());
		//������Ʈ�� ���� ��
		if (blacklist != null) {
			System.out.println("���ܵ� ���̵��Դϴ�.");
			return login_blacklist;
		}
		//��������Ʈ�� ���� ��
		if (deletedUser != null) {
			System.out.println("������ ���̵��Դϴ�.");
			return login_deletedUser;
		}
		
		//������� ������ �ùٸ� ������ �α��� �� ���̹Ƿ� ������ �����Ѵ�
		
		session.setAttribute("name", client.getName());
		session.setAttribute("client_id", client.getClient_id());
		System.out.println("�α��� ����");
		return login_success;
	}
	
	//�Է������� ��ġ�ϸ� ������ �����ؼ� ��ȯ 
	
	

}
