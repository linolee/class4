package kr.co.sist.user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import kr.co.sist.user.vo.ClassRegistVO;
import kr.co.sist.user.vo.LessonDowVO;
import kr.co.sist.user.vo.LoptVO;

@Component
public class ClassRegistDAO {
	
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
	
	
	public List<String> selectCategorys() {
		List<String> list = null;
		
		SqlSession ss = getSessionFactory().openSession();
		list = ss.selectList("selectCategorys");
		ss.close();
		
		return list;
	}
	
	
	public List<String> selectSubCategorys(String category) {
		List<String> list = null;
		
		SqlSession ss = getSessionFactory().openSession();
		list = ss.selectList("selectSubCategorys", category);
		ss.close();
		
		return list;
	}
	
	public List<String> selectTeacherName(String id) {
		List<String> list = null;
		
		SqlSession ss = getSessionFactory().openSession();
		list = ss.selectList("selectTeacherNames", id);
		ss.close();
		
		return list;
	}
	
	public int insertLesson(ClassRegistVO crvo) {
		int cnt = -1;
		
		SqlSession ss = getSessionFactory().openSession();
		cnt = ss.insert("insertLesson", crvo);
		ss.commit();
		ss.close();
		
		return cnt;
	}
	
	public String selectNowLessonCode() {
		String nowLessonCode = "";
		
		SqlSession ss = getSessionFactory().openSession();
		nowLessonCode = ss.selectOne("selectNowLessonCode");
		ss.close();
		
		return nowLessonCode;
	}
	
	public int insertLopt(LoptVO lvo) {
		int cnt = -1;
		
		SqlSession ss = getSessionFactory().openSession();
		cnt = ss.insert("insertLopt", lvo);
		ss.commit();
		ss.close();
		
		return cnt;
	}
	public int insertLessonDow(LessonDowVO ldvo) {
		int cnt = -1;
		
		SqlSession ss = getSessionFactory().openSession();
		cnt = ss.insert("insertLessonDow", ldvo);
		ss.commit();
		ss.close();
		
		return cnt;
	}
}
