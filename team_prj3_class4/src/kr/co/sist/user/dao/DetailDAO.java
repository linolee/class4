package kr.co.sist.user.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

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
	
	public Summary selectSummary(String lcode) {
		Summary summary=null;
		
		SqlSession ss=getSessionFactory().openSession();
		summary=ss.selectOne("kr.co.sist.user.detailC.selectSummary",lcode);
		ss.close();
		return summary;
	}//selectSummary
	
	public Star selectStar(String lcode) {
		Star star=null;
		
		SqlSession ss=getSessionFactory().openSession();
		star=ss.selectOne("selectStar", lcode);
		ss.close();
		return star;
	}//selectSummary
	
/*	public static void main(String[] args) {
		DetailDAO d_dao=new DetailDAO();
			System.out.println(d_dao.selectSummary("2"));
		System.out.println(d_dao.selectStar("2"));
		
	}//main
*/
}//class
