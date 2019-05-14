package kr.co.sist.user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import kr.co.sist.user.domain.Review;

@Component
public class UserLectureReviewDAO {

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
	public int reviewTotalCnt(Map<String, Object> param) {
	SqlSession ss = getSessionFactory().openSession();
	
	int cnt = ss.selectOne("reviewTotalCnt", param);
	ss.close();
	
	return cnt;
} // reviewTotalCnt
///////////////////////////////////////////////////////////////페이징//////////////////////////////////////////////////////////////		
	
	public List<Review> selectReview(Map<String, Object> map){
		SqlSession ss = getSessionFactory().openSession();
		
		System.out.println(map.get("nameList"));
		System.out.println(map.get("nameList"));
		System.out.println(map.get("nameList"));
		System.out.println(map.get("nameList"));
		System.out.println(map.get("nameList"));
		System.out.println(map.get("nameList"));
		System.out.println(map.get("nameList"));
		System.out.println(map.get("nameList"));
		System.out.println(map.get("nameList"));
		System.out.println(map.get("nameList"));
		System.out.println(map.get("nameList"));
		System.out.println(map.get("nameList"));
		System.out.println(map.get("nameList"));
		
		List<Review> list = ss.selectList("selectReview", map);
		ss.close();
		
		return list;
	} // selectReview
	
	public int selectReviewCnt (Map<String, String> map) {
		SqlSession ss = getSessionFactory().openSession();
		int cnt = 0;
		cnt = ss.selectOne("selectReviewCnt", map);
		
		return cnt;
	} // selectReviewCnt
	
	public List<String> selectTeacherName(String userId){
		SqlSession ss = getSessionFactory().openSession();
		List<String> list = ss.selectList("selectTeacherName", userId);
		ss.close();
		
		return list;
	} // selectTeacherNam
	public Review selectReviewDetail(Map<String, String> map){
		SqlSession ss = getSessionFactory().openSession();
		
		Review review = ss.selectOne("selectReviewDetail", map);
		ss.close();
		
		return review;
	}
	
} // class
