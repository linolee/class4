package kr.co.sist.user.service;

import java.util.List;

import kr.co.sist.user.domain.ClientPageInfo;
import kr.co.sist.user.vo.ChangePasswordVO;
import kr.co.sist.user.vo.UserLoginVO;

public interface UserPageService {
	public ClientPageInfo clientInfo(String client_id);
	public List<String> clientFavor(String client_id);
	public int deleteUser(String client_id);
	public int checkPassword(UserLoginVO ul_vo);
	public int changePassword(ChangePasswordVO cp_vo);
}
