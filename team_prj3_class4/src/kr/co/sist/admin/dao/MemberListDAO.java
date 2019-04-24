package kr.co.sist.admin.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.admin.domain.MemberListDomain;
import kr.co.sist.admin.vo.MemberIdxVO;

public class MemberListDAO {

	private  static MemberListDAO m_dao;
	private SqlSessionFactory ssf;
	
	public static MemberListDAO getInstance() {
		
		if(m_dao==null) {
			/*org.apache.ibatis.logging.LogFactory.useLog4JLogging();*/
			m_dao=new MemberListDAO();
		}
		return m_dao;
	}
	
	public synchronized SqlSessionFactory getSessionFactory() {
		Reader r=null;
		
		try {
			
			r=Resources.getResourceAsReader("kr/co/sist/admin/mapper/admin_config.xml");
			SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
			
			ssf=ssfb.build(r);
			if(r!=null) {r.close();}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ssf;
	}
	
	public List<MemberListDomain> selectAllMember() {
		List<MemberListDomain> list=null;

		MemberListDAO.m_dao=MemberListDAO.getInstance();
		SqlSession ss=m_dao.getSessionFactory().openSession();

		list=ss.selectList("selectClient");
		/*for(int i=0;i<list.size();i++) {
			System.out.println(1);
		}*/
		MemberListDomain md=null;

		for(int i=0;i<list.size();i++) {
			md=list.get(i);
			System.out.println(md.getClient_id()+" / "+ md.getName()+"/ "+md.getBirth()+" / "+md.getGender()+" / "+md.getEmail());

		}
		ss.close();
		return list;
	}

	public int selectTotalCount() {

		MemberListDAO.m_dao=MemberListDAO.getInstance();
		SqlSession ss=getSessionFactory().openSession();
		int cnt=ss.selectOne("clientTotalCnt");
		ss.close();

		return cnt;
	} // selectTotalCount
	
/*	public List<MemberListDomain> selectList(MemberIdxVO mIdxVO){
		List<MemberListDomain> list=null;
		SqlSession ss=getSessionFactory().openSession();
		list=ss.selectList("diaryList",dv);
		ss.close();
		return list;
	}//selectList
*/	
	
	


	public static void main(String[] args) {
		/*System.out.println(AdminDAO.getInstance().getSessionFactory());*/
		MemberListDAO adao=new MemberListDAO();
		/*adao.selectAllMember();*/
		System.out.println(adao.selectTotalCount());
	}

	
} // class
