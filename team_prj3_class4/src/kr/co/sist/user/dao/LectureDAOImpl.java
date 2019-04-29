package kr.co.sist.user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.user.domain.LectureView;

public class LectureDAOImpl implements LectureDAO {

	private SqlSessionFactory ssf = null;

	public LectureDAOImpl() {
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
	}// getSqlSessionFactory

	
	//클래스 현황 들고오기
	@Override
	public List<String> selectLecture(String teacher_name) {
		SqlSession ss = getSessionFactory().openSession();
		List<String> list = ss.selectList("selectLectureInfo", teacher_name);
		System.out.println(ss.selectList("selectLectureInfo", teacher_name));
		ss.close();
		
		return list;
	}

	public static void main(String[] args) {
		LectureDAOImpl l = new LectureDAOImpl();
		System.out.println(l.selectLecture("곽쌍용"));
	}

} // class
