package kr.co.sist.user.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import kr.co.sist.user.vo.FindIdVO;
import kr.co.sist.user.vo.FindPassVO;
import kr.co.sist.user.vo.UpdatePassVO;

@Component
public class FindIdpassDAO {
	
	private SqlSessionFactory ssf = null;

	public SqlSessionFactory getSessionFactory() {
		if (ssf == null) {
			org.apache.ibatis.logging.LogFactory.useLog4JLogging();

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
	}// getSqlSessionFactory
	
	public String selectFindId(FindIdVO fivo) {
		String id = "";
		
		SqlSession ss = getSessionFactory().openSession();
		id = ss.selectOne("selectFindId", fivo);
		ss.close();
		
		return id;
	}
	
	public String selectFindPass(FindPassVO fpvo) {
		String id = "";
		
		SqlSession ss = getSessionFactory().openSession();
		id = ss.selectOne("selectFindPass", fpvo);
		ss.close();
		
		return id;
	}
	
	public int updateFindPass(UpdatePassVO upvo) {
		int cnt = -1;
		
		SqlSession ss = getSessionFactory().openSession();
		cnt = ss.update("updateFindPass", upvo);
		ss.commit();
		ss.close();
		
		return cnt;
	}
	
}
