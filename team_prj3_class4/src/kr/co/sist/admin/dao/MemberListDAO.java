package kr.co.sist.admin.dao;

import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.domain.MemberDetail;
import kr.co.sist.admin.domain.MemberLesson;
import kr.co.sist.admin.domain.MemberListDomain;
import kr.co.sist.admin.vo.AddBlackVO;
import kr.co.sist.admin.vo.ListVO;

@Component
public class MemberListDAO {

	private SqlSessionFactory ssf;
	
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
	
	public List<MemberListDomain> selectAllMember(ListVO lvo) {
		List<MemberListDomain> list=null;

		SqlSession ss=getSessionFactory().openSession();
		list=ss.selectList("selectClient", lvo);
		ss.close();
		return list;
	}

	public String teacherInfo(String ID) {
		
		SqlSession ss=getSessionFactory().openSession();
		String chkTeacher=ss.selectOne("teacherInfo", ID);

		ss.close();
		return chkTeacher;
	}


	public int selectTotalCount() {
		SqlSession ss=getSessionFactory().openSession();
		int cnt=ss.selectOne("clientTotalCnt");
		ss.close();
		return cnt;
	} // selectTotalCount
	
	//회원 상세조회 DB작업
	public MemberDetail selectDetailMember(String id) {
		SqlSession ss=getSessionFactory().openSession();
		MemberDetail md=ss.selectOne("selectClientDetail", id);
		ss.close();
		return md;
	}
	
	//회원 수강 강의 상세조회 DB작업
	public List<MemberLesson> selectMemberLesson(String id) {
		List<MemberLesson> list = null;
		SqlSession ss=getSessionFactory().openSession();
		list=ss.selectList("selectClientLesson", id);
		ss.close();
		return list;
	}
	
	public int insertBlack(AddBlackVO abvo){
		int cnt=0;
		SqlSession ss=getSessionFactory().openSession();
		cnt=ss.insert("addBlackList", abvo);
		if(cnt==1) {
			ss.commit();
		}
		return cnt;
	}
	
	public int ifBlack(String id) {
		int cnt=0;
		SqlSession ss=getSessionFactory().openSession();
		cnt=ss.selectOne("ifBlack", id);
		return cnt;
	}
	
	public int ifTeacher(String id) {
		int cnt=0;
		SqlSession ss=getSessionFactory().openSession();
		cnt=ss.selectOne("ifTeacher", id);
		return cnt;
	}
	
	

	public static void main(String[] args) {
		MemberListDAO adao=new MemberListDAO();
		/*adao.selectAllMember();*/
		/*System.out.println(adao.selectTotalCount());
		System.out.println(adao.teacherInfo("in11202"));*/
		//System.out.println(adao.selectTotalCount());
		/*AddBlackVO abvo=null;
		abvo=new AddBlackVO("test", "그냥", "20120303");*/
		//System.out.println(adao.ifBlack("dateTT"));
		System.out.println(adao.ifTeacher("test"));
		
	}

	
} // class
