package kr.co.sist.user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import kr.co.sist.user.domain.Category;
import kr.co.sist.user.domain.LatestReview;
import kr.co.sist.user.domain.Recommend;

@Component
public class MainContentsDAO {
	
	private SqlSessionFactory ssf=null;
	
	public synchronized SqlSessionFactory getSessionFactory() {
		if(ssf==null) {
			org.apache.ibatis.logging.LogFactory.useLog4JLogging();
			
			Reader reader=null;
			try {
				//1.설정용 xml 로딩
				reader=Resources.getResourceAsReader("kr/co/sist/user/dao/mybatis_config.xml");
				//2.MyBatis Framework 생성
				SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
				//3.DB와 연동된 객체 받기
				ssf=ssfb.build(reader);
				if(reader!=null) {reader.close();}//end if
				
			} catch (IOException e) {
				e.printStackTrace();
			}//end catch
		}//end if
		return ssf;
	}//getSessionFactory
	
	public List<String> selectCategory() {
		List<String> category=null;
		
		SqlSession ss=getSessionFactory().openSession();
		category=ss.selectList("selectCategoryList");
		ss.close();
		return category;
	}//selectCategory
	
	public String selectCategoryCnt(){
		String cnt="";
		
		SqlSession ss=getSessionFactory().openSession();
		cnt = ss.selectOne("selectCategoryListCnt") ;
		ss.close();
		return cnt;
	}
	
	
	public List<Category> selectImgCategory(){
		List<Category> imgCate=null;
		
		SqlSession ss=getSessionFactory().openSession();
		imgCate=ss.selectList("selectCategoryImgList");
		ss.close();
		return imgCate;
	}//selectImgCategory
	
	
	
	
	public List<Recommend> selectRecommend(){
		List<Recommend> recommend=null;
		
		SqlSession ss=getSessionFactory().openSession();
		recommend=ss.selectList("selectRecommend");
		ss.close();
		return recommend;
	}//selectRecommend
	
	public String selectRecommendCnt(){
		String cnt="";
		
		SqlSession ss=getSessionFactory().openSession();
		cnt=ss.selectOne("selectRecommendCnt");
		ss.close();
		return cnt;
	}
	
	
	public List<LatestReview> selectLatestReview(){
		List<LatestReview> latestreview=null;
		
		SqlSession ss=getSessionFactory().openSession();
		latestreview=ss.selectList("selectLatestReview");
		ss.close();
		return latestreview;
	}
	
	public String selectLatestReviewCnt(){
		String cnt="";
		
		SqlSession ss=getSessionFactory().openSession();
		cnt=ss.selectOne("selectLatestReviewCnt");
		ss.close();
		return cnt;
	}

/*	public static void main(String[] args) {
		MainContentsDAO m_dao=new MainContentsDAO();
		List<String> category=m_dao.selectCategory();
		System.out.println(category);
		
	}//main
*/	
	
}//class
