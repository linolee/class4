package kr.co.sist.user.service;

import javax.servlet.http.HttpSession;

import kr.co.sist.user.dao.LoginDAO;
import kr.co.sist.user.dao.LoginDaoImpl;
import kr.co.sist.user.domain.Client;
import kr.co.sist.user.vo.UserLoginVO;

public interface UserLoginService {
	public String login(UserLoginVO ulvo, HttpSession session);
}
