package kr.co.sist.user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.user.domain.AdminQnA;
import kr.co.sist.user.domain.ClientPageInfo;
import kr.co.sist.user.vo.ChangePasswordVO;
import kr.co.sist.user.vo.MemberFavorVO;
import kr.co.sist.user.vo.MemberUpdateVO;
import kr.co.sist.user.vo.SearchListVO;
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
	
	@Override
	public int memberUpdate(MemberUpdateVO mu_vo) {
		SqlSession ss=getSessionFactory().openSession();
		int cnt = ss.update("memberUpdate", mu_vo);
		if (cnt == 1) {
			ss.commit();
		}
		ss.close();
		return cnt;
	}
	
	@Override
	public int favorDelete(String client_id) {
		SqlSession ss=getSessionFactory().openSession();
		int cnt = ss.delete("favorDelete", client_id);
		ss.commit();
		ss.close();
		return cnt;
	}
	
	@Override
	public int favorInsert(String client_id, String[] favors) {
		SqlSession ss=getSessionFactory().openSession();
		int cnt=0;
		for (String favor : favors) {
			MemberFavorVO mfvo = new MemberFavorVO(client_id, favor);
			cnt = ss.insert("memberFavor", mfvo);
			if(cnt == 1) {
				ss.commit();
			}//end if
		}
		return cnt;
	}
	@Override
	public List<AdminQnA> selectQnaList(SearchListVO slvo){
		List<AdminQnA> list = null;
		SqlSession ss=getSessionFactory().openSession();
		list = ss.selectList("selectAdminQnaList", slvo);
		return list;
	}
	
	@Override
	public int selectTotalCount(String client_id) {
		SqlSession ss=getSessionFactory().openSession();
		return ss.selectOne("adminQnaTotalCnt", client_id);
	}
	
	public static void main(String[] args) {
		UserPageDAOImpl upd = new UserPageDAOImpl();
		System.out.println(upd.selectTotalCount("linolee"));
		List<AdminQnA> list = upd.selectQnaList(new SearchListVO(6, 10, 2, "linolee"));
		for (AdminQnA adminQnA : list) {
			System.out.println(adminQnA);
		}
//		System.out.println(upd.checkPassword(new UserLoginVO("linolee", "1234")));
//		System.out.println(upd.selectClientFavor("linolee"));
	}

}
