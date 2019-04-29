package kr.co.sist.user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.user.domain.Blacklist;
import kr.co.sist.user.domain.Client;
import kr.co.sist.user.domain.DeletedUser;
import kr.co.sist.user.vo.UserLoginVO;

public class LoginDaoImpl implements LoginDAO{
		
		private SqlSessionFactory ssf=null;
		
		public LoginDaoImpl() {
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
		
		public Client selectClient(UserLoginVO ulvo){
			SqlSession ss=getSessionFactory().openSession();
			
			Client client=ss.selectOne("selectClient", ulvo);
			
			ss.close();
			return client;
		}//selectMainNotice
		
		

		@Override
		public Blacklist selectBlacklist(String userId) {
			SqlSession ss=getSessionFactory().openSession();
			
			Blacklist blacklist=ss.selectOne("selectBlacklist", userId);
			
			ss.close();
			return blacklist;
		}

		@Override
		public DeletedUser selectDeletedUser(String userId) {
			SqlSession ss=getSessionFactory().openSession();
			
			DeletedUser deletedUser=ss.selectOne("selectDeletedUser", userId);
			
			ss.close();
			return deletedUser;
		}
		
		public static void main(String[] args) {
			LoginDaoImpl ldi = new LoginDaoImpl();
			System.out.println(ldi.selectBlacklist("1"));
			System.out.println(ldi.selectDeletedUser("2"));
			List<String> list = new ArrayList<String>();
			list.add("1");
			list.add("2");
			list.add("3");
			list.add("4");
			list.add("5");
			System.out.println(list.get(4));
		}
		
	}//class

