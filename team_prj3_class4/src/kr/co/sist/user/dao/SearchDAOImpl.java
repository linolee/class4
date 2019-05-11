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
import kr.co.sist.user.domain.SearchClassList;
import kr.co.sist.user.vo.SearchListVO;

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
	
	@Override
	public List<SearchClassList> selectClassList(SearchListVO slvo) {
		List<SearchClassList> list = null;
		
		SqlSession ss = getSessionFactory().openSession();
		list = ss.selectList("selectClassList", slvo);
		ss.close();
		return list;
	}
	
	@Override
	public int selectTotalCount(String keyword) {
		SqlSession ss = getSessionFactory().openSession();
		int cnt = ss.selectOne("searchTotalCnt", keyword);
		ss.close();
		return cnt;
	}
	
	
	public static void main(String[] args) {
		SearchDAOImpl sdi = new SearchDAOImpl();
		sdi.selectTotalCount("ทั");
	}
}
