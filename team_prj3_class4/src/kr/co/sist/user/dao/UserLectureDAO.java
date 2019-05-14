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
	
///////////////////////////////////////////////////////////////페이징//////////////////////////////////////////////////////////////	
	public int lectureTotalCnt(Map<String, Object> param) {
		SqlSession ss = getSessionFactory().openSession();
		
		int cnt = ss.selectOne("lectureTotalCnt", param);
		ss.close();
		
		return cnt;
	} // lectureTotalCnt
///////////////////////////////////////////////////////////////페이징//////////////////////////////////////////////////////////////	
	
	public List<LectureView> selectClassApplyCnt() {
		SqlSession ss = getSessionFactory().openSession();
		List<LectureView> result = ss.selectList("selectClassApplyCnt");
				
		return result;
	} //selectClassApplyCnt
	
	//lcode로 하나의 클래스를 조회한다
	public List<LectureView> selectLecture(Map<String, Object> param) {
		SqlSession ss = getSessionFactory().openSession();
		List<LectureView> lv = ss.selectList("selectLectureInfo", param);
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
	
	//신청마감할 클래스 불러오기
	public List<String> selectApplyClassStatus(Map<String, String> map) {
		SqlSession ss = getSessionFactory().openSession();
		System.out.println(map.get("teacherName"));
		System.out.println(map.get("today"));
		List<String> list = ss.selectList("selectApplyClassStatus", map);
		ss.close();
		
		return list;
	} // updateApplyClassStatus
	
	public int updateApplyClassStatus(String lcode) {
		SqlSession ss = getSessionFactory().openSession();
		int result = 0;
		System.out.println("dao lcode : " + lcode);
		result = ss.update("updateApplyClassStatus", lcode);
		
		System.out.println(result);
		if(result == 1) {
			ss.commit();
		}//end if
		
		ss.close();
		return result;
	} // updateApplyClassStatus
	
	//진행중으로 변경할 클래스 불러오기
	public List<String> selectProgressClassStatus(Map<String, String> map) {
		SqlSession ss = getSessionFactory().openSession();
		
		System.out.println("******** selectProgressClassStatus *********");
		System.out.println(map.get("teacherName"));
		System.out.println(map.get("today"));
		List<String> list = ss.selectList("selectProgressClassStatus", map);
		ss.close();
		
		return list;
	} // updateProgressClassStatus
	
	public int updateProgressClassStatus(String lcode) {
		SqlSession ss = getSessionFactory().openSession();
		int result = 0;
		result = ss.update("updateProgressClassStatus", lcode);
		
		if(result == 1) {
			ss.commit();
		}//end if
		
		ss.close();
		return result;
	} // updateProgressClassStatus
	
	//종료로 변경할 클래스 불러오기
	public List<String> selectEndClassStatus(Map<String, String> map) {
		SqlSession ss = getSessionFactory().openSession();
		List<String> list = ss.selectList("selectEndClassStatus", map);
		ss.close();
		
		return list;
	} // updateEndClassStatus
	
	public int updateEndClassStatus(String lcode) {
		SqlSession ss = getSessionFactory().openSession();
		int result = 0;
		result = ss.update("updateEndClassStatus", lcode);
		
		if(result == 1) {
			ss.commit();
		}//end if
		
		ss.close();
		return result;
	} // updateEndClassStatus
	
	public int changeOpenClass(String lcode) {
		SqlSession ss = getSessionFactory().openSession();
		int result = 0;
		result = ss.update("changeOpenClass", lcode);
		
		if(result == 1) {
			ss.commit();
		}//end if
		
		ss.close();
		return result;
	} // changeOpenClass
	
} // class
