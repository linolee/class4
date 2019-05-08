package kr.co.sist.user.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import kr.co.sist.user.vo.QnaVO;
import kr.co.sist.user.vo.ReviewVO;

@Component
public class UserQnaDAO {
	private SqlSessionFactory ssf=null;
	
	public SqlSessionFactory getSessionFactory() {
		if( ssf == null ) {
			org.apache.ibatis.logging.LogFactory.useLog4JLogging();
			
			Reader reader=null;
			try {
				//1. ������ xml�ε�
				reader = Resources.getResourceAsReader("kr/co/sist/user/dao/mybatis_config.xml");
				//2. MyBatis Framework ����
				SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
				//3. DB�� ������ ��ü �ޱ�
				ssf = ssfb.build(reader);
				if( reader != null ) { reader.close(); }//end if
				
			} catch (IOException ie) {
				ie.printStackTrace();
			}//end catch
		}//end if
		return ssf;
	}//getSqlSessionFactory
	
	public boolean insertQna(QnaVO qvo) {
		boolean flag=false;
		int cnt=0;
		SqlSession ss=getSessionFactory().openSession();
		cnt = ss.insert("insertQna", qvo);
		if(cnt != 0) {
			flag=true;
			ss.commit();
		}//end if
		ss.close();
		return flag;
	}//insertJjim
	
}//class
