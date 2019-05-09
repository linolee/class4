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

import kr.co.sist.user.domain.Question;
import kr.co.sist.user.domain.Review;
import kr.co.sist.user.vo.QuestionReplyVO;

@Component
public class UserLectureQuestionDAO {

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
	
	public List<Question> selectQuestion (Map<String, String> map){
		SqlSession ss = getSessionFactory().openSession();
		List<Question> list = ss.selectList("selectQuestion",map);
		ss.close();
		
		return list;
	} // selectQuestion
	
	
	public List<String> selectTeacherName(String userId){
		SqlSession ss = getSessionFactory().openSession();
		List<String> list = ss.selectList("selectTeacherName", userId);
		ss.close();
		
		return list;
	} // selectTeacherName

	public int selectQusetionCnt (Map<String, String> map) {
		SqlSession ss = getSessionFactory().openSession();
		int cnt = 0;
		cnt = ss.selectOne("selectQusetionCnt", map);
		
		return cnt;
	} // selectReviewCnt
	
	public Question selectQuestionDetail(String qcode) {
		SqlSession ss = getSessionFactory().openSession();
		Question question = ss.selectOne("selectQuestionDetail", qcode);
		
		return question;
	} //selectQuestionDetail
	
	public int updateQuestionReply(QuestionReplyVO qrvo) {
		SqlSession ss = getSessionFactory().openSession();
		int cnt = ss.update("updateQuestionReply", qrvo);
		if (cnt == 1) {
			ss.commit();
		}
		ss.close();		
		System.out.println(cnt);
		return cnt;
	} // updateQuestionReply
	
	public static void main(String[] args) {
		UserLectureQuestionDAO ulq_dao = new UserLectureQuestionDAO();	
		System.out.println(ulq_dao.updateQuestionReply(new QuestionReplyVO()));
	}
	
} // class
