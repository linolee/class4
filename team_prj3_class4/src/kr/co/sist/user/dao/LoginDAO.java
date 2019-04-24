package kr.co.sist.user.dao;

import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.sist.user.domain.Blacklist;
import kr.co.sist.user.domain.Client;
import kr.co.sist.user.domain.DeletedUser;
import kr.co.sist.user.vo.UserLoginVO;

public interface LoginDAO {
	public SqlSessionFactory getSessionFactory();
	public Client selectClient(UserLoginVO ulvo);
	public Blacklist selectBlacklist(String userId);
	public DeletedUser selectDeletedUser(String userId);

}
