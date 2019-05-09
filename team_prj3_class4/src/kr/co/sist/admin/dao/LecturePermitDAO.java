package kr.co.sist.admin.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.domain.LecturePermitDomain;
import kr.co.sist.admin.vo.ListVO;
import kr.co.sist.admin.vo.OptionSearchVO;

@Component
public class LecturePermitDAO {

private SqlSessionFactory ssf=null;

private static LecturePermitDAO lp_dao;

	public static LecturePermitDAO getInstance() {
		if(lp_dao == null) {
			lp_dao=new LecturePermitDAO();
		}//end if
		return lp_dao;
	}//getInstance


	
	public synchronized SqlSessionFactory getSessionFactory() {
		if(ssf == null) {
			org.apache.ibatis.logging.LogFactory.useLog4JLogging();
			
			Reader reader = null;
			try {
				//1. 설정용 xml 로딩
				reader = Resources.getResourceAsReader("kr/co/sist/admin/mapper/admin_config.xml");
				//2. ByBatis Framwork 생성
				SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
				//3. MyBatis Framework와 DB 연동한 객체 얻기 ( 객체를 하나로 관리 )
				ssf = ssfb.build(reader);
				if(reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		return ssf;
	}
	
	public List<LecturePermitDomain> selectLecturePermit(ListVO lvo){
		List<LecturePermitDomain> list=null;
		
		SqlSession ss=getSessionFactory().openSession();
		list=ss.selectList("selectLecturePermit", lvo);
		ss.close();
		
		return list;
	}
	
	public int selectTotalCount() {
		SqlSession ss = getSessionFactory().openSession();
		int cnt = ss.selectOne("lecturePermitTotalCnt");
		ss.close();
		return cnt;
	}
	
	public boolean lecturePermission(String lcode) {
		boolean flag=false;
		SqlSession ss = getSessionFactory().openSession();
		int cnt=ss.update("lecturePermission", lcode);
		if(cnt==1) {
			flag=true;
			ss.commit();
		}
		ss.close();
		return flag;
	}
	
	public boolean lectureRefuse(String lcode) {
		boolean flag=false;
		SqlSession ss = getSessionFactory().openSession();
		int cnt=ss.update("lectureRefuse", lcode);
		if(cnt==1) {
			flag=true;
			ss.commit();
		}
		ss.close();
		return flag;
	}
	
	public List<LecturePermitDomain> lecturePermitOptionSearch(OptionSearchVO osvo){
		List<LecturePermitDomain> list=null;
		SqlSession ss=getSessionFactory().openSession();
		list=ss.selectList("lecturePermitOptionSearch", osvo);
		ss.close();
		return list;
	}
}
