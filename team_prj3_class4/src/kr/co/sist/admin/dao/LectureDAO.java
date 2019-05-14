package kr.co.sist.admin.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.domain.LectureListDomain;
import kr.co.sist.admin.vo.LectureStatusVO;
import kr.co.sist.admin.vo.ListVO;
import kr.co.sist.admin.vo.OptionSearchVO;

@Component
public class LectureDAO {

	private SqlSessionFactory ssf=null;
	private static LectureDAO l_dao;

	public static LectureDAO getInstance() {
		if(l_dao == null) {
			l_dao=new LectureDAO();
		}
		return l_dao;
	}
	
	public synchronized SqlSessionFactory getSessionFactory() {
		if(ssf==null) {
			Reader reader=null;
			try {
				reader=Resources.getResourceAsReader("kr/co/sist/admin/mapper/admin_config.xml");
				SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
				ssf=ssfb.build(reader);
				if(reader!=null) {reader.close();}
			} catch(IOException ie) {
				ie.printStackTrace();
			} // end catch
		} // end if
		return ssf;
	}
	
	public List<LectureListDomain> selectLectureList(ListVO lvo){
		List<LectureListDomain> list=null;
		
		SqlSession ss=getSessionFactory().openSession();
		ss.update("endStatus1");//리스트 조회 전 강의 끝나는 날짜 받아서 종료 또는 취소로 만들어주는 쿼리를 수행//
		ss.update("endStatus2");//리스트 조회 전 강의 끝나는 날짜 받아서 종료 또는 취소로 만들어주는 쿼리를 수행
		ss.commit();
		
		list=ss.selectList("selectLectureList", lvo);
		
		ss.close();
		return list;
	}
	
	public int selectTotalCount() {
		SqlSession ss = getSessionFactory().openSession();
		int cnt = ss.selectOne("lectureTotalCnt");
		ss.close();
		return cnt;
	}
	
	public List<LectureListDomain> lectureStatusSearch(LectureStatusVO lsvo){
		List<LectureListDomain> list=null;
		SqlSession ss=getSessionFactory().openSession();
		list=ss.selectList("lectureStatusSearch", lsvo);
		ss.close();
		return list;
	}
	
		
	public List<LectureListDomain> lectureOptionSearch(OptionSearchVO osvo){
		List<LectureListDomain> list=null;
		SqlSession ss=getSessionFactory().openSession();
		list=ss.selectList("lectureOptionSearch", osvo);
		ss.close();
		
		return list;
	}
	public static void main(String[] args) {
		LectureDAO ldao=new LectureDAO();
		/*LectureStatusVO lsvo=new LectureStatusVO();
		lsvo.setCurrentPage(1);
		lsvo.setStartNum(1);
		lsvo.setEndNum(10);
		lsvo.setStatus("F");*/
		ldao.selectTotalCount();
	}
}
