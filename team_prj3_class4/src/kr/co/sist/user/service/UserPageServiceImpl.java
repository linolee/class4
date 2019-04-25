package kr.co.sist.user.service;

import kr.co.sist.user.dao.UserPageDAO;
import kr.co.sist.user.domain.ClientInfo;

public class UserPageServiceImpl implements UserPageService {
	private UserPageDAO up_dao;
	public UserPageServiceImpl(UserPageDAO up_dao) {
		this.up_dao = up_dao;
	}
	
	public ClientInfo clientInfo(String client_id) {
		ClientInfo clientInfo = up_dao.selectClientInfo(client_id);
		return clientInfo;
	}
	
}
