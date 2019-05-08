package kr.co.sist.admin.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.domain.MemberDetail;
import kr.co.sist.admin.domain.MemberLesson;
import kr.co.sist.admin.domain.MemberListDomain;
import kr.co.sist.admin.domain.TeacherIntro;
import kr.co.sist.admin.vo.AddBlackVO;
import kr.co.sist.admin.vo.ListVO;
import kr.co.sist.admin.vo.OptionSearchVO;

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
	public List<String> memberBlack(ListVO lvo) {
		List<String> list=null;
		
		SqlSession ss=getSessionFactory().openSession();
		list=ss.selectList("memberBlack", lvo);
		ss.close();
		return list;
	}

/*	public String teacherInfo(String ID) {
		
		SqlSession ss=getSessionFactory().openSession();
		String chkTeacher=ss.selectOne("teacherInfo", ID);

		ss.close();
		return chkTeacher;
	}*/


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
		ss.close();
		return cnt;
	}
	
	public int ifBlack(String id) {
		int cnt=0;
		SqlSession ss=getSessionFactory().openSession();
		cnt=ss.selectOne("ifBlack", id);
		ss.close();
		return cnt;
	}
	
	public List<TeacherIntro> teacherIntro(String teacherName){
		List<TeacherIntro> list=null;
		SqlSession ss=getSessionFactory().openSession();
		list=ss.selectList("selectIntro", teacherName);
		ss.close();
		return list;
	}
	
	public List<MemberListDomain> memberOptionSearch(OptionSearchVO osvo){
		List<MemberListDomain> list=null;
		SqlSession ss=getSessionFactory().openSession();
		list=ss.selectList("memberOptionSearch", osvo);
		ss.close();
		return list;
	}
	
	public static void main(String[] args) {
		MemberListDAO adao=new MemberListDAO();
		OptionSearchVO osvo=new OptionSearchVO();
		//osvo.setCurrentPage(1);
		osvo.setEndNum(5);
		osvo.setStartNum(1);
		osvo.setOption("name");
		osvo.setKeyword("백인재");
		
		
		adao.memberOptionSearch(osvo);
		
		/*ListVO lvo=new ListVO();
		lvo.setCurrentPage(1);
		lvo.setStartNum(1);
		lvo.setEndNum(10);
		adao.selectAllMember(lvo);*/
	}

	
} // class
