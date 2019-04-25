package kr.co.sist.admin.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.admin.domain.LectureListDomain;
import kr.co.sist.admin.domain.MemberListDomain;

public class LectureDAO {

	private static LectureDAO l_dao;
	private SqlSessionFactory ssf=null;
	
	public static LectureDAO getInstance() {
		if(l_dao==null) {
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
	
	public List<LectureListDomain> selectLectureList(){
		List<LectureListDomain> list=null;
		
		SqlSession ss=getSessionFactory().openSession();
		list=ss.selectList("selectLectureList");
		
		LectureListDomain lld=null;

		for(int i=0;i<list.size();i++) {
			lld=list.get(i);
			System.out.println(lld.getLcode()+" / "+lld.getCategory());

		}
		
		ss.close();
		return list;
	}
	
	public static void main(String[] args) {
		LectureDAO ldao=new LectureDAO();
		ldao.selectLectureList();
	}
	
}
