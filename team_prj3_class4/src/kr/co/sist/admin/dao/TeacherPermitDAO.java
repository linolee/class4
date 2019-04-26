package kr.co.sist.admin.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.domain.TeacherPermitDomain;

@Component
public class TeacherPermitDAO {
	private SqlSessionFactory ssf=null;
	
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
	
	public List<TeacherPermitDomain> selectTeacherPermit(){
		List<TeacherPermitDomain> list=null;
		
		SqlSession ss=getSessionFactory().openSession();
		list=ss.selectList("selectTeacherPermit");
		ss.close();
		return list;
	}
	
	public static void main(String[] args) {
		TeacherPermitDAO tpdao=new TeacherPermitDAO();
		tpdao.selectTeacherPermit();
		System.out.println("hi");
	}
	
	
} // class