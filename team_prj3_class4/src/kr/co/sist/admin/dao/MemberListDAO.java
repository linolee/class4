package kr.co.sist.admin.dao;

import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	
	public List<AddBlackVO> insertBlack(String id, String reason, String date){
		List<AddBlackVO> list=null;
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		String time1 = format1.format(time);
		SqlSession ss=getSessionFactory().openSession();
		// map이용해야됨
		list=ss.selectList("addBlackList", id, reason, time1);
		return list;
	}
	
	

	public static void main(String[] args) {
		/*System.out.println(AdminDAO.getInstance().getSessionFactory());*/
		MemberListDAO adao=new MemberListDAO();
		/*adao.selectAllMember();*/
		/*System.out.println(adao.selectTotalCount());
		System.out.println(adao.teacherInfo("in11202"));*/
		//System.out.println(adao.selectTotalCount());
		
	}

	
} // class
