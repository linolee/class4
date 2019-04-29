package kr.co.sist.user.service;

import javax.servlet.http.HttpSession;

import kr.co.sist.user.dao.LoginDAO;
import kr.co.sist.user.dao.LoginDaoImpl;
import kr.co.sist.user.domain.Client;
import kr.co.sist.user.vo.UserLoginVO;

public interface UserLoginService {
	public static int login_success = 0;
	public static int login_fail = 1;
	public static int login_blacklist = 2;
	public static int login_deletedUser= 3;
	
	public int login(UserLoginVO ulvo, HttpSession session);
}
