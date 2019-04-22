package kr.co.sist.admin.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.admin.domain.MemberDomain;

public class AdminDAO {

	private  static AdminDAO a_dao;
	private SqlSessionFactory ssf;
	
	public static AdminDAO getInstance() {
		
		if(a_dao==null) {
			/*org.apache.ibatis.logging.LogFactory.useLog4JLogging();*/
			a_dao=new AdminDAO();
		}
		return a_dao;
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
	
	public List<MemberDomain> selectMember() {
		List<MemberDomain> list=null;
		
		AdminDAO.a_dao=AdminDAO.getInstance();
		SqlSession ss=a_dao.getSessionFactory().openSession();
		
		list=ss.selectList("selectClient");
		/*for(int i=0;i<list.size();i++) {
			System.out.println(1);
		}*/
		MemberDomain md=null;
		
		for(int i=0;i<list.size();i++) {
			md=list.get(i);
			System.out.println(md.getClient_id()+" / "+ md.getName()+"/ "+md.getBirth()+" / "+md.getGender()+" / "+md.getEmail());
			
		}
		ss.close();
		return list;
	}



	public static void main(String[] args) {
		/*System.out.println(AdminDAO.getInstance().getSessionFactory());*/
		AdminDAO adao=new AdminDAO();
		adao.selectMember();
	}

	
} // class
