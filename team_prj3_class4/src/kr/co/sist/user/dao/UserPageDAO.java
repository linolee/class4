package kr.co.sist.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.sist.user.domain.ClientPageInfo;
import kr.co.sist.user.vo.ChangePasswordVO;

public interface UserPageDAO {
	public ClientPageInfo selectClientInfo(String client_id); 
	public List<String> selectClientFavor(String client_id);
	public int deleteUser(String client_id);
	public int changePassword(ChangePasswordVO cp_vo);
}
