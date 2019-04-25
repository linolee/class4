package kr.co.sist.user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.user.domain.ClientInfo;

public class UserPageDAOImpl implements UserPageDAO {

	private SqlSessionFactory ssf = null;

	public UserPageDAOImpl() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}

	@Override
	public SqlSessionFactory getSessionFactory() {

		if (ssf == null) {

			Reader reader = null;
			try {
				reader = Resources.getResourceAsReader("kr/co/sist/user/dao/mybatis_config.xml");
				SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
				ssf = ssfb.build(reader);
				if (reader != null) {
					reader.close();
				} // end if
			} catch (IOException ie) {
				ie.printStackTrace();
			} // end catch
		} // end if
		return ssf;
	}

	@Override
	public ClientInfo selectClientInfo(String client_id) {
		SqlSession ss=getSessionFactory().openSession();
		
		ClientInfo clientInfo=ss.selectOne("selectClientInfo", client_id);
		
		ss.close();
		return clientInfo;
	}
	
	@Override
	public List<String> selectClientFavor(String client_id){
		SqlSession ss=getSessionFactory().openSession();
		
		List<String> clientFavor=ss.selectList("selectClientFavor", client_id);
		
		ss.close();
		
		return clientFavor;
	}
	
	public static void main(String[] args) {
		UserPageDAOImpl upd = new UserPageDAOImpl();
		System.out.println(upd.selectClientFavor("linolee"));
	}

}
