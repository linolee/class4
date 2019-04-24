package kr.co.sist.user.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.user.domain.LoginDomain;
import kr.co.sist.user.vo.UserLoginVO;

public class LoginDaoImpl implements LoginDAO{
		
		private SqlSessionFactory ssf=null;
		
		public LoginDaoImpl() {
			org.apache.ibatis.logging.LogFactory.useLog4JLogging();
		}
		
		public synchronized SqlSessionFactory getSessionFactory() {
			if( ssf == null) {
				
				Reader reader=null;
				try {
					//1. ������ xml�ε�
					reader=Resources.getResourceAsReader("kr/co/sist/user/dao/mybatis_config.xml");
					//2. MyBatis Framework ����
					SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
					//3. DB�� ������ ��ü �ޱ�
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
			LoginDaoImpl user_dao = new LoginDaoImpl();
//			user_dao.selectAccount(new UserLoginVO("linolee", "1234"));
			LoginDomain ld = user_dao.selectAccount(new UserLoginVO("linolee", "1234"));
			ld = user_dao.selectAccount(new UserLoginVO("linolee", "1222"));
			
			System.out.println(ld);
//			System.out.println(ld.getClient_id()+"/"+ld.getName()+"/"+ld.getStatus());
			
		}
		
	}//class








