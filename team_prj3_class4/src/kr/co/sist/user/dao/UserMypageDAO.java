package kr.co.sist.user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.user.domain.ClassList;
import kr.co.sist.user.vo.ListVO;
import kr.co.sist.user.vo.StatusCntVO;
import kr.co.sist.user.vo.StatusListVO;

public class UserMypageDAO {
	private static UserMypageDAO um_dao;
	private SqlSessionFactory ssf=null;
	
	private UserMypageDAO() {
	}//UserMypageDAO
	
	public static UserMypageDAO getInstance() {
		if( um_dao == null ) {
			um_dao = new UserMypageDAO();
		}//end if
		return um_dao;
	}//getInstance
	
	public synchronized SqlSessionFactory getSessionFactory() {
		if( ssf == null ) {
			org.apache.ibatis.logging.LogFactory.useLog4JLogging();
			
			Reader reader=null;
			try {
				//1. 설정용 xml로딩
				reader = Resources.getResourceAsReader("kr/co/sist/user/dao/mybatis_config.xml");
				//2. MyBatis Framework 생성
				SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
				//3. DB와 연동된 객체 받기
				ssf = ssfb.build(reader);
				if( reader != null ) { reader.close(); }//end if
				
			} catch (IOException ie) {
				ie.printStackTrace();
			}//end catch
		}//end if
		return ssf;
	}//getSqlSessionFactory
	
	public List<ClassList> selectClass(ListVO lvo){
		List<ClassList> list=null;
		SqlSession ss=getSessionFactory().openSession();
		list=ss.selectList("classList", lvo);
		ss.close();
		return list;
	}//selectClass
	
	public List<ClassList> selectStatusClass(StatusListVO slvo){
		List<ClassList> list=null;
		SqlSession ss=getSessionFactory().openSession();
		list=ss.selectList("statusClassList", slvo);
		ss.close();
		return list;
	}//selectClass
	
	public List<String> selectLcode(String clientId){
		List<String> list=null;
		SqlSession ss=getSessionFactory().openSession();
		list=ss.selectList("lcodeList", clientId);
		ss.close();
		return list;
	}//selectLcode
	
	public int selectTotalCount(String clientId) {
		SqlSession ss=getSessionFactory().openSession();
		
		int cnt=ss.selectOne("listTotalCnt", clientId);
		ss.close();
		return cnt;
	}//selectTotalCount
	
	public int statusCnt(StatusCntVO ssvo) {
		SqlSession ss=getSessionFactory().openSession();
		
		int cnt=ss.selectOne("statusCnt", ssvo);
		ss.close();
		return cnt;
	}//selectTotalCount
}//class
