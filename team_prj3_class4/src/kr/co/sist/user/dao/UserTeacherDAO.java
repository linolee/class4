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

import kr.co.sist.user.domain.TeacherInfo;
import kr.co.sist.user.vo.AddTeacherVO;
import kr.co.sist.user.vo.CareerVO;

@Component
public class UserTeacherDAO {

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
	
	public int selectTeacherName(String teacherName) {
		SqlSession ss = getSessionFactory().openSession();
		int cnt = ss.selectOne("selectCheckTeacherName", teacherName);
		ss.close();	
		
		return cnt;
	} // updateQuestionReply
	
	public List<String> selectTeacherCategory(){
		SqlSession ss = getSessionFactory().openSession();
		List<String> list = ss.selectList("selectTeacherCategory");
		ss.close();
		
		return list;
		
	} // selectTeacherCategory 
	
	public int insertTeacher(AddTeacherVO atvo) {
		int cnt = 0;
		SqlSession ss=getSessionFactory().openSession();
		cnt = ss.insert("insertTeacher", atvo);	
		if(cnt == 1) {
			ss.commit();
		}//end if
		return cnt;
	} // insertTeacher
	
	public int updateTeacher(AddTeacherVO atvo) {
		int cnt = 0;
		SqlSession ss = getSessionFactory().openSession();
		cnt = ss.insert("updateTeacher", atvo);	
		if(cnt == 1) {
			ss.commit();
		}//end if
		return cnt;
	} // insertTeacher
	
	public int updateTeacherStatus(String teacherName) {
		int cnt = 0;
		SqlSession ss=getSessionFactory().openSession();
		cnt = ss.update("updateTeacherStatus", teacherName);
		if(cnt == 1) {
			ss.commit();
		}//end if
		return cnt;		
	} // updateTeacherStatus
	
	public int insertCareer(CareerVO cvo) {
		int cnt = 0;
		SqlSession ss=getSessionFactory().openSession();		
		cnt = ss.insert("insertCareer", cvo);
		if(cnt == 1) {
			ss.commit();
		}//end if
		return cnt;		
	
	} //insertCareer
	
	public List<String> selectTeacherProfile(Map<String, Object> param){
		SqlSession ss = getSessionFactory().openSession();		
		List<String> list = ss.selectList("selectTeacherList", param);
		ss.close();
		
		return list;
	} // selectTeacherProfile
	
	public TeacherInfo selectTeacherDetail(String teacherName){
		SqlSession ss = getSessionFactory().openSession();		
		TeacherInfo list = ss.selectOne("selectTeacherDetail", teacherName);
		ss.close();
		
		return list;
	} // selectTeacherDetail
	
	public List<String> selectCareer(String teacherName){
		SqlSession ss = getSessionFactory().openSession();		
		List<String> list = ss.selectList("selectCareer", teacherName);
		ss.close();
		
		return list;
	} // selectCareer
	
	public int updateCareer(String teacherName) {
		SqlSession ss = getSessionFactory().openSession();
		
		int result = 0;
		result = ss.update("updateCareer", teacherName);
		
		if(result > 0) {
			ss.commit();
		}//end if
		
		ss.close();
		
		return result;
	} // updateCareer
	
	public int selectLessonStatus(String teacherName) {
		SqlSession ss = getSessionFactory().openSession();
		
		int result = 0;
		result = ss.selectOne("selectLessonStatus", teacherName);
		ss.close();
		
		return result;
	} // selectLessonStatus
	
	public int teacherProfileTotalCnt(Map<String, Object> param) {
		SqlSession ss = getSessionFactory().openSession();
		
		int result = 0;
		result = ss.selectOne("teacherProfileTotalCnt", param);
		ss.close();
		
		return result;
	} // teacherProfileTotalCnt
	
} // class
