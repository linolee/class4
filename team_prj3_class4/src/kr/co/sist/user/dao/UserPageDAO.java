package kr.co.sist.user.dao;

import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.sist.user.domain.ClientInfo;

public interface UserPageDAO {
	public SqlSessionFactory getSessionFactory();
	public ClientInfo selectClientInfo(String client_id); 
	
}
