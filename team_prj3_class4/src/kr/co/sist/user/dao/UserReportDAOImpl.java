package kr.co.sist.user.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.user.vo.GuestReportVO;
import kr.co.sist.user.vo.memberReportVO;

public class UserReportDAOImpl implements UserReportDAO{
	private SqlSessionFactory ssf = null;

	public UserReportDAOImpl() {
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
	public int guestReportSubmit(GuestReportVO grvo) {
		int cnt = 0;
		SqlSession ss=getSessionFactory().openSession();
		cnt = ss.insert("guestReportSubmit", grvo);
		if(cnt == 1) {
			ss.commit();
		}//end if
		return cnt;
	}
	
	@Override
	public int memberReportSubmit(memberReportVO mrvo) {
		int cnt = 0;
		SqlSession ss=getSessionFactory().openSession();
		cnt = ss.insert("memberReportSubmit", mrvo);
		if(cnt == 1) {
			ss.commit();
		}//end if
		return cnt;
	}

	public static void main(String[] args) {
		UserReportDAOImpl ur_dao = new UserReportDAOImpl();
		System.out.println(ur_dao.guestReportSubmit(new GuestReportVO("linolee@naver.com", "Èþ±¸Èþ±¸", "·Î±×ÀÎÀÌ ¾Ó´ë¿© ¤Ð¤Ð¤Ð¤Ð¤Ð¤Ð¤Ð¤Ð¤Ð¤Ð¤Ð¤Ð")));
	}
}
