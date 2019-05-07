package kr.co.sist.user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import kr.co.sist.user.domain.CancelList;
import kr.co.sist.user.domain.ClassList;
import kr.co.sist.user.domain.QnaList;
import kr.co.sist.user.domain.ReportList;
import kr.co.sist.user.vo.ListVO;
import kr.co.sist.user.vo.ReviewVO;
import kr.co.sist.user.vo.StatusCntVO;
import kr.co.sist.user.vo.StatusListVO;
import kr.co.sist.user.vo.TotalVO;

@Component
public class UserMypageDAO {
	private SqlSessionFactory ssf=null;
	
	public SqlSessionFactory getSessionFactory() {
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
	
	public String reviewStatus(ListVO lvo) {
		String lcode="";
		SqlSession ss=getSessionFactory().openSession();
		lcode=ss.selectOne("reviewStatus", lvo);
		ss.close();
		return lcode;
	}//reviewList
	
	public boolean insertReview(ReviewVO rvo) {
		boolean flag=false;
		int cnt=0;
		SqlSession ss=getSessionFactory().openSession();
		cnt = ss.insert("insertReview", rvo);
		if(cnt != 0) {
			flag=true;
			ss.commit();
		}//end if
		ss.close();
		return flag;
	}//insertJjim
	
	public String jjimStatus(ListVO lvo) {
		String lcode="";
		SqlSession ss=getSessionFactory().openSession();
		lcode=ss.selectOne("jjimStatus", lvo);
		ss.close();
		return lcode;
	}//reviewList
	
	public boolean insertJjim(ListVO lvo) {
		boolean flag=false;
		int cnt=0;
		SqlSession ss=getSessionFactory().openSession();
		cnt = ss.insert("insertJjim", lvo);
		if(cnt != 0) {
			flag=true;
			ss.commit();
		}//end if
		ss.close();
		return flag;
	}//insertJjim
	
	public int jjimTotalCnt(String clientId) {
		SqlSession ss=getSessionFactory().openSession();
		
		int cnt=ss.selectOne("jjimTotalCnt",clientId);
		ss.close();
		return cnt;
	}//selectTotalCount
	
	public int cancelTotalCnt(String clientId) {
		SqlSession ss=getSessionFactory().openSession();
		
		int cnt=ss.selectOne("cancelTotalCnt",clientId);
		ss.close();
		return cnt;
	}//selectTotalCount
	
	public int qnaTotalCnt(String clientId) {
		SqlSession ss=getSessionFactory().openSession();
		
		int cnt=ss.selectOne("qnaTotalCnt",clientId);
		ss.close();
		return cnt;
	}//selectTotalCount
	
	public int reportTotalCnt(String clientId) {
		SqlSession ss=getSessionFactory().openSession();
		
		int cnt=ss.selectOne("reportTotalCnt",clientId);
		ss.close();
		return cnt;
	}//selectTotalCount
	
	public boolean deleteJjim(ListVO lvo) {
		boolean flag=false;
		int cnt=0;
		SqlSession ss=getSessionFactory().openSession();
		cnt = ss.delete("deleteJjim", lvo);
		if(cnt != 0) {
			flag=true;
			ss.commit();
		}//end if
		ss.close();
		return flag;
	}//insertJjim
	
	public List<String> cancelLcodeList(String clientId) {
		List<String> list=null;
		SqlSession ss=getSessionFactory().openSession();
		list=ss.selectList("cancelLcodeList", clientId);
		ss.close();
		return list;
	}//cancelLcodeList
	
	public List<CancelList> cancelList(ListVO lvo) {
		List<CancelList> list=null;
		SqlSession ss=getSessionFactory().openSession();
		list=ss.selectList("cancelList", lvo);
		ss.close();
		return list;
	}//cancelList
	
	public List<String> qnaLcodeList(String clientId) {
		List<String> list=null;
		SqlSession ss=getSessionFactory().openSession();
		list=ss.selectList("qnaLcodeList", clientId);
		ss.close();
		return list;
	}//qnaLcodeList
	
	public List<QnaList> qnaList(ListVO lvo) {
		List<QnaList> list=null;
		SqlSession ss=getSessionFactory().openSession();
		list=ss.selectList("qnaList", lvo);
		ss.close();
		return list;
	}//qnaList
	
	public List<String> reportLcodeList(String clientId) {
		List<String> list=null;
		SqlSession ss=getSessionFactory().openSession();
		list=ss.selectList("reportLcodeList", clientId);
		ss.close();
		return list;
	}//qnaLcodeList
	
	public List<ReportList> reportList(ListVO lvo) {
		List<ReportList> list=null;
		SqlSession ss=getSessionFactory().openSession();
		list=ss.selectList("reportList", lvo);
		ss.close();
		return list;
	}//qnaList
	
	public int selectTotalCount(TotalVO tvo) {
		SqlSession ss=getSessionFactory().openSession();
		
		int cnt=ss.selectOne("listTotalCnt", tvo);
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
