package kr.co.sist.user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.user.vo.MemberFavorVO;
import kr.co.sist.user.vo.MemberJoinVO;

public class UserJoinDAOImpl implements UserJoinDAO{

	
	private SqlSessionFactory ssf=null;
	
	public UserJoinDAOImpl() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}
	
	public SqlSessionFactory getSessionFactory() {
		if( ssf == null) {
			
			Reader reader=null;
			try {
				reader=Resources.getResourceAsReader("kr/co/sist/user/dao/mybatis_config.xml");
				SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
				ssf=ssfb.build(reader);
				if( reader != null ){ reader.close(); }//end if
			}catch(IOException ie) {
				ie.printStackTrace();
			}//end catch
		}//end if
		return ssf;
	}//getSqlSessionFactory

	
	@Override
	public List<String> categoryList() {
		SqlSession ss=getSessionFactory().openSession();
		
		List<String> categoryList=ss.selectList("selectCategory");
		ss.close();
		return categoryList;
	}

	@Override
	public void join(MemberJoinVO mjvo, String[] favors) {
		int cnt = 0;
		SqlSession ss=getSessionFactory().openSession();
		cnt = ss.insert("memberJoin", mjvo);
		if(cnt == 1) {
			ss.commit();
		}//end if
		
		for (String favor : favors) {
			MemberFavorVO mfvo = new MemberFavorVO(mjvo.getClient_id(), favor);
			ss.insert("memberFavor", mfvo);
			ss.commit();
		}
		
		
		ss.close();
	}
	
	public void inputFavors(String[] favors) {
		SqlSession ss=getSessionFactory().openSession();
		for (String favor : favors) {
			MemberFavorVO mfvo = new MemberFavorVO("dddd", favor);
			ss.insert("memberFavor", mfvo);
			ss.commit();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("하이");
		UserJoinDAOImpl ujd = new UserJoinDAOImpl();
		ujd.inputFavors(new String[] {"음악", "아트", "핸드메이드"});
	}
	
}
