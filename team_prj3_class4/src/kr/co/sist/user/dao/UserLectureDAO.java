package kr.co.sist.user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import kr.co.sist.user.domain.LectureView;

@Component
public class UserLectureDAO {

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

	
	//lcode로 클래스 현황 들고오기
	public LectureView selectLecture(String lcode) {
		SqlSession ss = getSessionFactory().openSession();
		LectureView lv = ss.selectOne("selectLectureInfo", lcode);
		ss.close();
		
		return lv;
	}
	
	//teachername으로 lcode 조회
	public List<String> selectLcode(String teacherName) {
		SqlSession ss = getSessionFactory().openSession();
		List<String> list = ss.selectList("selectLcode", teacherName);
		ss.close();
		
		return list;
	}
	
	//id로 teacherName 조회
	public List<String> selectTeachername(String userId) {
		SqlSession ss = getSessionFactory().openSession();
		List<String> list = ss.selectList("selectTeachername", userId);
		ss.close();
		
		return list;
	}
	
} // class
