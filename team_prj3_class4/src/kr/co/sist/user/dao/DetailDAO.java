package kr.co.sist.user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import kr.co.sist.user.domain.Addr;
import kr.co.sist.user.domain.ClassTime;
import kr.co.sist.user.domain.DetailContents;
import kr.co.sist.user.domain.Join;
import kr.co.sist.user.domain.JoinCount;
import kr.co.sist.user.domain.QnA;
import kr.co.sist.user.domain.ReviewDomain;
import kr.co.sist.user.domain.Star;
import kr.co.sist.user.domain.Summary;
import kr.co.sist.user.domain.TClass;
import kr.co.sist.user.vo.ListVO;

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
	
	public DetailContents selectDeContents(String lcode) {
		DetailContents detailc=null;
		
		SqlSession ss=getSessionFactory().openSession();
		detailc=ss.selectOne("selectDeContents", lcode);
		ss.close();
		return detailc;
	}//selectContents
	
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
	
	public int selectRTotalCount() {
		int cnt=0;
		SqlSession ss = getSessionFactory().openSession();
		cnt=ss.selectOne("selectReviewTotalCnt");
		ss.close();
		return cnt;
	}//selectRTotalCount
	
	public List<QnA> selectQnaList(String lcode){
		List<QnA> qnaList=null;
		
		SqlSession ss=getSessionFactory().openSession();
		qnaList=ss.selectList("selectQnaList", lcode);
		ss.close();
		return qnaList;
	}//selectQnaList
	
	public int selectQTotalCount() {
		int cnt=0;
		SqlSession ss = getSessionFactory().openSession();
		cnt=ss.selectOne("selectQnaTotalCnt");
		ss.close();
		return cnt;
	}//selectRTotalCount
	
	public List<TClass> selectTclassList(String lcode){
		List<TClass> tclist=null;

 		SqlSession ss=getSessionFactory().openSession();
		tclist=ss.selectList("selectTclass", lcode);
		ss.close();
		return tclist;
	}//selectTclassList

 	public List<String> selectClassday(String lcode) {
		List<String> day=null;

 		SqlSession ss=getSessionFactory().openSession();
		day=ss.selectList("selectDay",lcode);
		ss.close();
		return day;
	}//selectClassday

 	public ClassTime selectClassTime(String lcode){
 		ClassTime classTime=null;

 		SqlSession ss=getSessionFactory().openSession();
 		classTime=ss.selectOne("selectClassTime", lcode);
		ss.close();
		return classTime;
	}//selectClassTime


 	public JoinCount selectJoinCount(String lcode) {
		JoinCount joinCount=null;

 		SqlSession ss=getSessionFactory().openSession();
		joinCount=ss.selectOne("selectJoinCount", lcode);
		ss.close();
		return joinCount;
	}//selectJoinCount

 	public String selectLike(String lcode) {
		String like=null;

 		SqlSession ss=getSessionFactory().openSession();
		like=ss.selectOne("selectLike", lcode);
		ss.close();
		return like;
	}//selectLike

	public Addr selectBar(String lcode) {
		Addr addr=null;
		
		SqlSession ss=getSessionFactory().openSession();
		addr=ss.selectOne("selectAddr", lcode);
		ss.close();
		return addr;
	}//selectBar
	
	public Join joinStatus(ListVO lvo) {
		Join status=null;
		SqlSession ss=getSessionFactory().openSession();
		status=ss.selectOne("selectID",lvo);
		ss.close();
		return status;
	}//joinStatus
	
	public boolean insertJoin(ListVO lvo) {
		boolean flag=false;
		int cnt=0;
		SqlSession ss=getSessionFactory().openSession();
		cnt = ss.insert("insertJoin", lvo);
		if(cnt != 0) {
			flag=true;
			ss.commit();
		}//end if
		ss.close();
		return flag;
	}//insertJoin
	
	public boolean cancelJoin(ListVO lvo) {
		boolean flag=false;
		int cnt=0;
		SqlSession ss=getSessionFactory().openSession();
		cnt = ss.delete("updateJoin", lvo);
		if(cnt != 0) {
			flag=true;
			ss.commit();
		}//end if
		ss.close();
		return flag;
	}//cancelJoin
	
	
/*	public static void main(String[] args) {
		DetailDAO d_dao=new DetailDAO();
			System.out.println(d_dao.selectSummary("2"));
		System.out.println(d_dao.selectStar("2"));
		
	}//main
*/
}//class
