package kr.co.sist.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.sist.user.domain.ClientPageInfo;

public interface UserPageDAO {
	public ClientPageInfo selectClientInfo(String client_id); 
	public List<String> selectClientFavor(String client_id);
	public int deleteUser(String client_id);
}
