package kr.co.sist.admin.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.vo.AdminLoginVO;

@Component
public class AdminLoginDAO {
private SqlSessionFactory ssf;
	
	public synchronized SqlSessionFactory getSessionFactory() {
		if(ssf == null) {
			org.apache.ibatis.logging.LogFactory.useLog4JLogging();
			
			Reader reader = null;
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
	
	public boolean adminLogin(AdminLoginVO alvo) {
		boolean flag=false;
		SqlSession ss=getSessionFactory().openSession();
		if(ss.selectOne("selectAdminLogin", alvo)!=null) {
			flag=true;
		}
		ss.close();
		System.out.println(flag);
		return flag;
	}
	
	public static void main(String[] args) {
		AdminLoginDAO aldao=new AdminLoginDAO();
		AdminLoginVO alvo=new AdminLoginVO("admin", "1234");
		aldao.adminLogin(alvo);
	}
}
