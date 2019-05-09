package kr.co.sist.user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.admin.domain.QnaDetail;
import kr.co.sist.admin.domain.QnaQuestionList;
import kr.co.sist.admin.vo.ListVO;
import kr.co.sist.admin.vo.QnaAnswerVO;

public class SearchDAOImpl implements SearchDAO {
	
	private SqlSessionFactory ssf=null;
	
	public SearchDAOImpl() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}
	
	public SqlSessionFactory getSessionFactory() {
		if( ssf == null) {
			
			Reader reader=null;
			try {
				reader=Resources.getResourceAsReader("kr/co/sist/user/dao/mybatis_config.xml");
				SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
				ssf=ssfb.build(reader);
				if( reader != null ){ reader.close(); }//end if
			}catch(IOException ie) {
				ie.printStackTrace();
			}//end catch
		}//end if
		return ssf;
	}//getSqlSessionFactory
	
	public List<QnaQuestionList> selectQnAQuestionList(ListVO lvo){
		List<QnaQuestionList> list = null;
		
		SqlSession ss = getSessionFactory().openSession();
		list = ss.selectList("selectQnaQuestionList", lvo);
		ss.close();
		return list;
	}
	
	public int selectTotalCount() {
		SqlSession ss = getSessionFactory().openSession();
		int cnt = ss.selectOne("qnaTotalCnt");
		ss.close();
		return cnt;
	}
	
	public QnaDetail selectQnaDetail(String qnum){
		QnaDetail qd = null;
		SqlSession ss = getSessionFactory().openSession();
		qd = ss.selectOne("qnaDetail", qnum);
		ss.close();
		return qd;
	}
	
	public int updateQnaAnswer(QnaAnswerVO qavo){
		SqlSession ss = getSessionFactory().openSession();
		int cnt = ss.update("updateQnaAcontent", qavo);
		ss.commit();
		ss.close();
		return cnt;
	}
	
}
