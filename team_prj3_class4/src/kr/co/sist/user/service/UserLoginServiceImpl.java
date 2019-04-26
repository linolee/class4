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
		
		//생성된 VO를 사용하여 DB에서 조회
		//클라이언트에서 조회
		Client client = l_dao.selectClient(ulvo);//Client에는 id, name, status가 저장되어있다.
		//조회된 값이 없을 때
		if (client == null) {
			System.out.println("아이디, 비밀번호를 다시 입력해주세요");
			return login_fail;
		}
		//블랙리스트에서 조회
		Blacklist blacklist = l_dao.selectBlacklist(ulvo.getId());
		//삭제리스트에서 조회
		DeletedUser deletedUser = l_dao.selectDeletedUser(ulvo.getId());
		//블랙리스트에 있을 때
		if (blacklist != null) {
			System.out.println("차단된 아이디입니다.");
			return login_blacklist;
		}
		//삭제리스트에 있을 때
		if (deletedUser != null) {
			System.out.println("삭제된 아이디입니다.");
			return login_deletedUser;
		}
		
		//여기까지 왔으면 올바른 정보로 로그인 한 것이므로 세션을 생성한다
		
		session.setAttribute("name", client.getName());
		session.setAttribute("client_id", client.getClient_id());
		System.out.println("로그인 성공");
		return login_success;
	}
	
	//입력정보가 일치하면 세션을 생성해서 반환 
	
	

}
