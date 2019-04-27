package kr.co.sist.admin.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.domain.MemberListDomain;
import kr.co.sist.admin.vo.ListVO;
import kr.co.sist.admin.vo.MemberIdxVO;

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
	

	public static void main(String[] args) {
		/*System.out.println(AdminDAO.getInstance().getSessionFactory());*/
		MemberListDAO adao=new MemberListDAO();
		/*adao.selectAllMember();*/
		/*System.out.println(adao.selectTotalCount());
		System.out.println(adao.teacherInfo("in11202"));*/
		System.out.println(adao.selectTotalCount());
		
	}

	
} // class
