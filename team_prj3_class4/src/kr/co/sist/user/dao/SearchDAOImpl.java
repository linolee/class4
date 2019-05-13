package kr.co.sist.user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
		ss.update("endStatus1");//����Ʈ ��ȸ �� ���� ������ ��¥ �޾Ƽ� ���� �Ǵ� ��ҷ� ������ִ� ������ ����
		ss.update("endStatus2");//����Ʈ ��ȸ �� ���� ������ ��¥ �޾Ƽ� ���� �Ǵ� ��ҷ� ������ִ� ������ ����
		ss.commit();////
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
	
	@Override
	public List<String> selectCategoryList(String keyword) {
		SqlSession ss=getSessionFactory().openSession();
		
		List<String> categoryList=ss.selectList("searchCategory", keyword);
		ss.close();
		return categoryList;
	}
	
	public static void main(String[] args) {
		SearchDAOImpl sdi = new SearchDAOImpl();
		sdi.selectTotalCount("��");
	}
}
