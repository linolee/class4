package kr.co.sist.user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import kr.co.sist.user.domain.LectureView;
import kr.co.sist.user.domain.StatusCnt;

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

	
	//lcode로 하나의 클래스를 조회한다
	public LectureView selectLecture(Map<String, String> param) {
		SqlSession ss = getSessionFactory().openSession();
		LectureView lv = ss.selectOne("selectLectureInfo", param);
		ss.close();
		
		return lv;
	} // selectLecture
	
	//teachername으로 lcode를 가져온다
	public List<String> selectLcode(String teacherName) {
		SqlSession ss = getSessionFactory().openSession();
		List<String> list = ss.selectList("selectLcode", teacherName);
		ss.close();
		
		return list;
	} // selectLcode
	
	//id로 teacherName 조회
	public List<String> selectTeachername(String userId) {
		SqlSession ss = getSessionFactory().openSession();
		List<String> list = ss.selectList("selectTeachername", userId);
		ss.close();
		
		return list;
	} // selectTeachername
	
	public List<LectureView> selectStudentsList(String lcode){
		SqlSession ss = getSessionFactory().openSession();
		List<LectureView> list = ss.selectList("selectStudentsList", lcode);
		ss.close();
		return list;		
	} // selectStudentsList
	
	public List<StatusCnt> selectLectureStatus(String teacherName){
		SqlSession ss = getSessionFactory().openSession();
		List<StatusCnt> list = ss.selectList("selectLectureStatus", teacherName);
		ss.close();		
		return list;
	} // selectLectureStatus
	
	public List<String> selectTeacherName(String userId){
		SqlSession ss = getSessionFactory().openSession();
		List<String> list = ss.selectList("selectTeacherName", userId);
		ss.close();
		
		return list;
	} // selectTeacherName
	
} // class
