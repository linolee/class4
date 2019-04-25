package kr.co.sist.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.sist.user.domain.ClientInfo;

public interface UserPageDAO {
	public SqlSessionFactory getSessionFactory();
	public ClientInfo selectClientInfo(String client_id); 
	public List<String> selectClientFavor(String client_id);
}
