package kr.co.sist.user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import kr.co.sist.user.domain.SearchClassList;
import kr.co.sist.user.vo.SearchListVO;

@Component
public class categorySearchDAO {
	
	private SqlSessionFactory ssf=null;
	
	public synchronized SqlSessionFactory getSessionFactory() {
		if(ssf==null) {
			org.apache.ibatis.logging.LogFactory.useLog4JLogging();
			
			Reader reader=null;
			try {
				//1.������ xml �ε�
				reader=Resources.getResourceAsReader("kr/co/sist/user/dao/mybatis_config.xml");
				//2.MyBatis Framework ����
				SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
				//3.DB�� ������ ��ü �ޱ�
				ssf=ssfb.build(reader);
				if(reader!=null) {reader.close();}//end if
				
			} catch (IOException e) {
				e.printStackTrace();
			}//end catch
		}//end if
		return ssf;
	}//getSessionFactory
	
	public List<SearchClassList> selectCategoryClassList(SearchListVO slvo) {
		List<SearchClassList> list = null;
		
		SqlSession ss = getSessionFactory().openSession();
		list = ss.selectList("selectCategoryClassList", slvo);
		ss.close();
		return list;
	}
	
	public int selectCategoryTotalCount(String keyword) {
		SqlSession ss = getSessionFactory().openSession();
		int cnt = ss.selectOne("selectCategoryTotalCnt", keyword);
		ss.close();
		return cnt;
	}
	
	public List<String> selectCategory() {
		SqlSession ss=getSessionFactory().openSession();
		
		List<String> categoryList=ss.selectList("selectCategoryTotal");
		ss.close();
		return categoryList;
	}
	
	
}
