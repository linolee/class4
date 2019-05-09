package kr.co.sist.user.service;

import java.util.List;

import kr.co.sist.user.dao.UserPageDAO;
import kr.co.sist.user.domain.ClientPageInfo;
import kr.co.sist.user.vo.ChangePasswordVO;
import kr.co.sist.user.vo.MemberFavorVO;
import kr.co.sist.user.vo.MemberUpdateVO;
import kr.co.sist.user.vo.UserLoginVO;

public class UserPageServiceImpl implements UserPageService {
	private UserPageDAO up_dao;
	public UserPageServiceImpl(UserPageDAO up_dao) {
		this.up_dao = up_dao;
	}
	
	public ClientPageInfo clientInfo(String client_id) {
		ClientPageInfo clientInfo = up_dao.selectClientInfo(client_id);
		return clientInfo;
	}
	
	public List<String> clientFavor(String client_id) {
		List<String> clientFavor = up_dao.selectClientFavor(client_id);
		return clientFavor;
	}
	
	@Override
	public int deleteUser(String client_id) {
		int cnt = up_dao.deleteUser(client_id);
		return cnt;
	}
	
	@Override
	public int checkPassword(UserLoginVO ul_vo) {
		int cnt = up_dao.checkPassword(ul_vo);
		return cnt;
	}
	
	@Override
	public int changePassword(ChangePasswordVO cp_vo) {
		int cnt = up_dao.changePassword(cp_vo);
		return cnt;
	}
	
	@Override
	public int memberUpdate(MemberUpdateVO mu_vo) {
		int cnt = up_dao.memberUpdate(mu_vo);
		return cnt;
	}
	
	@Override
	public int favorUpdate(String client_id, String[] favors) {
		up_dao.favorDelete(client_id);
		int cnt = up_dao.favorInsert(client_id, favors);
		return cnt;
	}
	
}
