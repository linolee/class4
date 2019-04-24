package kr.co.sist.user.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.user.domain.LoginDomain;
import kr.co.sist.user.vo.UserLoginVO;

public interface LoginDAO {
	private static UserLoginDAO ul_dao;
	private SqlSessionFactory ssf=null;
	
	private UserLoginDAO() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}//DAO
	
	public static UserLoginDAO getInstance() {
		if( ul_dao == null ) {
			ul_dao=new UserLoginDAO();
		}//end if
		return ul_dao;
	}//getInstance
	
	public synchronized SqlSessionFactory getSessionFactory() {
		if( ssf == null) {
			
			Reader reader=null;
			try {
				//1. 설정용 xml로딩
				reader=Resources.getResourceAsReader("kr/co/sist/user/dao/mybatis_config.xml");
				//2. MyBatis Framework 생성
				SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
				//3. DB와 연동된 객체 받기
				ssf=ssfb.build(reader);
				if( reader != null ){ reader.close(); }//end if
					
			}catch(IOException ie) {
				ie.printStackTrace();
			}//end catch
		}//end if
		return ssf;
	}//getSqlSessionFactory
	
	public LoginDomain selectAccount(UserLoginVO ulvo){
		SqlSession ss=getSessionFactory().openSession();
		
		LoginDomain ld=ss.selectOne("selectAccount", ulvo);
		
		ss.close();
		
		return ld;
	}//selectMainNotice
	
	
	public static void main(String[] args) {
		UserLoginDAO user_dao = new UserLoginDAO();
//		user_dao.selectAccount(new UserLoginVO("linolee", "1234"));
		LoginDomain ld = user_dao.selectAccount(new UserLoginVO("linolee", "1234"));
		ld = user_dao.selectAccount(new UserLoginVO("linolee", "1222"));
		
		System.out.println(ld);
//		System.out.println(ld.getClient_id()+"/"+ld.getName()+"/"+ld.getStatus());
		
	}
	
}
