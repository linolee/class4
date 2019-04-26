package kr.co.sist.user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
	public void join() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		UserJoinDAOImpl ujd = new UserJoinDAOImpl();
		System.out.println(ujd.categoryList());
	}
	
}