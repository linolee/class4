package kr.co.sist.admin.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.domain.TeacherDetailDomain;
import kr.co.sist.admin.domain.TeacherPermitDomain;
import kr.co.sist.admin.vo.ListVO;

@Component
public class TeacherPermitDAO {
	private SqlSessionFactory ssf=null;
	
	private static TeacherPermitDAO tp_dao;
	
	public static TeacherPermitDAO getInstance() {
		if(tp_dao == null) {
			tp_dao=new TeacherPermitDAO();
		}//end if
		return tp_dao;
	}//getInstance
	
	
	
	
	public synchronized SqlSessionFactory getSessionFactory() {
		if(ssf==null) {
			Reader reader=null;
			try {
				//1. ������ xml �ε�
				reader = Resources.getResourceAsReader("kr/co/sist/admin/mapper/admin_config.xml");
				//2. ByBatis Framwork ����
				SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
				//3. MyBatis Framework�� DB ������ ��ü ��� ( ��ü�� �ϳ��� ���� )
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
	
	public List<TeacherPermitDomain> selectTeacherPermit(ListVO lvo){
		List<TeacherPermitDomain> list=null;
		
		SqlSession ss=getSessionFactory().openSession();
		list=ss.selectList("selectTeacherPermit", lvo);
		ss.close();
		return list;
	}
	
	public int selectTotalCount() {
		SqlSession ss = getSessionFactory().openSession();
		int cnt = ss.selectOne("teacherPermitTotalCnt");
		ss.close();
		return cnt;
	}
	
	/**
	 * �����û���̺��� �����͸� �����Ѵ�
	 * @param id
	 * @return
	 */
	public boolean delTeacherPermit(String id) {
		boolean flag=false;
		
		SqlSession ss = getSessionFactory().openSession();
		int cnt=ss.delete("delTeacherPermit", id);
		if(cnt==1) {
			flag=true;
			ss.commit();
		}
		
		return flag;
	}
	
	/**
	 * ���� �����ÿ� client���̺��� status�� Y�� �����Ѵ�
	 * @param id
	 * @return
	 */
	public boolean updateTeacherPermitStat(String id) {
		boolean flag=false;
		
		SqlSession ss = getSessionFactory().openSession();
		int cnt=ss.update("updateTeacherPermitStat", id);
		if(cnt==1) {
			flag=true;
			ss.commit();
		}
		return flag;
	}
	
	
	
} // class