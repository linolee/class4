package kr.co.sist.user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.user.domain.ClientPageInfo;
import kr.co.sist.user.vo.ChangePasswordVO;
import kr.co.sist.user.vo.UserLoginVO;

public class UserPageDAOImpl implements UserPageDAO {

	private SqlSessionFactory ssf = null;

	public UserPageDAOImpl() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}

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
	public ClientPageInfo selectClientInfo(String client_id) {
		SqlSession ss=getSessionFactory().openSession();
		
		ClientPageInfo clientInfo=ss.selectOne("selectClientPageInfo", client_id);
		
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
	
	@Override
	public int deleteUser(String client_id) {
		SqlSession ss=getSessionFactory().openSession();
		int cnt = ss.insert("deleteUser", client_id);
		if (cnt == 1) {
			ss.commit();
		}
		ss.close();
		return cnt;
	}
	
	@Override
	public int checkPassword(UserLoginVO ul_vo) {
		int cnt;
		SqlSession ss=getSessionFactory().openSession();
		if (ss.selectOne("checkPassword", ul_vo) == null) {
			cnt = 0;
		}else {
			cnt = 1;
		}
		ss.close();
		return cnt;
	}
	
	@Override
	public int changePassword(ChangePasswordVO cp_vo) {
		SqlSession ss=getSessionFactory().openSession();
		int cnt = ss.update("changePassword", cp_vo);
		if (cnt == 1) {
			ss.commit();
		}
		ss.close();
		return cnt;
	}
	
	public static void main(String[] args) {
		UserPageDAOImpl upd = new UserPageDAOImpl();
		System.out.println(upd.checkPassword(new UserLoginVO("linolee", "1234")));
//		System.out.println(upd.selectClientFavor("linolee"));
	}

}
