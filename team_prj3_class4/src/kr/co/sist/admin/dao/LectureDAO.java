package kr.co.sist.admin.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
	

	
}
