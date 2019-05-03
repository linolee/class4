package kr.co.sist.user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import kr.co.sist.user.domain.DetailContents;
import kr.co.sist.user.domain.QnA;
import kr.co.sist.user.domain.ReviewDomain;
import kr.co.sist.user.domain.Star;
import kr.co.sist.user.domain.Summary;

@Component
public class DetailDAO {
	
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
	
	public Summary selectSummary(String lcode) {
		Summary summary=null;
		
		SqlSession ss=getSessionFactory().openSession();
		summary=ss.selectOne("selectSummary",lcode);
		ss.close();
		return summary;
	}//selectSummary
	
	public Star selectStar(String lcode) {
		Star star=null;
		
		SqlSession ss=getSessionFactory().openSession();
		star=ss.selectOne("selectStar", lcode);
		ss.close();
		return star;
	}//selectStar
	
	public List<String> selectCareer(String lcode){
		List<String> list=null;
		
		SqlSession ss=getSessionFactory().openSession();
		list=ss.selectList("selectCareerList", lcode);
		ss.close();
		return list;
	}//selectCareer
	
/*	public DetailContents selectContents(String lcode) {
		DetailContents dc=null;
		
		SqlSession ss=getSessionFactory().openSession();
		dc=ss.selectOne("selectContents", lcode);
		ss.close();
		return dc;
	}//selectContents
*/	
	public List<String> selectOpt(String lcode) {
		List<String> optList=null;
		
		SqlSession ss=getSessionFactory().openSession();
		optList=ss.selectList("selectOpt",lcode);
		ss.close();
		return optList;
	}//selectOpt
	
	public List<String> selectNoOpt() {
		List<String> noptList=null;
		
		SqlSession ss=getSessionFactory().openSession();
		noptList=ss.selectList("selectNoOpt");
		ss.close();
		return noptList;
	}//selectNoOpt
	
	public List<ReviewDomain> selectReviewList(String lcode){
		List<ReviewDomain> rvList=null;
		
		SqlSession ss=getSessionFactory().openSession();
		rvList=ss.selectList("selectReviewList", lcode);
		ss.close();
		return rvList;
	}//selectReviewList
	
	public List<QnA> selectQnaList(String lcode){
		List<QnA> qnaList=null;
		
		SqlSession ss=getSessionFactory().openSession();
		qnaList=ss.selectList("selectQnaList", lcode);
		ss.close();
		return qnaList;
	}//selectQnaList
	
	
/*	public static void main(String[] args) {
		DetailDAO d_dao=new DetailDAO();
			System.out.println(d_dao.selectSummary("2"));
		System.out.println(d_dao.selectStar("2"));
		
	}//main
*/
}//class
