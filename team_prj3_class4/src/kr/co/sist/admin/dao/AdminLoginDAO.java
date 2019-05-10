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
		//System.out.println(flag);
		return flag;
	}
	
	// �� ���� ��
	public int totalTeacher() {
		SqlSession ss=getSessionFactory().openSession();
		int cnt=ss.selectOne("totalTeacher");
		ss.close();
		return cnt;
	}
	
	// ��ü ���� ��
	public int totalLecture() {
		SqlSession ss=getSessionFactory().openSession();
		int cnt=ss.selectOne("totalLecture");
		ss.close();
		return cnt;
	}
	
	// �������� ���� ��
	public int ingLecture() {
		SqlSession ss=getSessionFactory().openSession();
		int cnt=ss.selectOne("ingLecture");
		ss.close();
		return cnt;
	}
	
	// �� ī�װ� ��
	public int totalCategory() {
		SqlSession ss=getSessionFactory().openSession();
		int cnt=ss.selectOne("totalCategory");
		ss.close();
		return cnt;
	}
	
	// �� ȸ�� ��
	public int totalClient() {
		SqlSession ss=getSessionFactory().openSession();
		int cnt=ss.selectOne("totalClient");
		ss.close();
		return cnt;
	}
	
	// ���� ������ ȸ�� ��
	public int todayClient(int today) {
		SqlSession ss=getSessionFactory().openSession();
		int cnt=ss.selectOne("todayClient", today);
		return cnt;
	}
	
	// �̹��� ������ ȸ�� ��
	public int monthClient(int month) {
		SqlSession ss=getSessionFactory().openSession();
		int cnt=ss.selectOne("monthClient", month);
		return cnt;
	}
	
	// ���� ��¥ ���ϱ�
	public int today() {
		SqlSession ss=getSessionFactory().openSession();
		int cnt=ss.selectOne("today");
		return cnt;
	}
	
	// �̹��� ���ϱ�
	public int month() {
		SqlSession ss=getSessionFactory().openSession();
		int cnt=ss.selectOne("month");
		return cnt;
	}
	
	// Ż���� ȸ�� ��
	public int exitClient() {
		SqlSession ss=getSessionFactory().openSession();
		int cnt=ss.selectOne("exitClient");
		return cnt;
	}
	
	public String findEaddress(String id) {
		SqlSession ss=getSessionFactory().openSession();
		String email=ss.selectOne("findEaddress", id);
		return email;
	}
	
	public static void main(String[] args) {
		AdminLoginDAO aldao=new AdminLoginDAO();
		/*AdminLoginVO alvo=new AdminLoginVO("admin", "1234");
		aldao.adminLogin(alvo);*/
		System.out.println(aldao.findEaddress("test2"));
	}
}
