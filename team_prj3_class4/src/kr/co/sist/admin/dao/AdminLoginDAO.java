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
	
	// 총 강사 수
	public int totalTeacher() {
		SqlSession ss=getSessionFactory().openSession();
		int cnt=ss.selectOne("totalTeacher");
		ss.close();
		return cnt;
	}
	
	// 전체 강좌 수
	public int totalLecture() {
		SqlSession ss=getSessionFactory().openSession();
		int cnt=ss.selectOne("totalLecture");
		ss.close();
		return cnt;
	}
	
	// 진행중인 강좌 수
	public int ingLecture() {
		SqlSession ss=getSessionFactory().openSession();
		int cnt=ss.selectOne("ingLecture");
		ss.close();
		return cnt;
	}
	
	// 총 카테고리 수
	public int totalCategory() {
		SqlSession ss=getSessionFactory().openSession();
		int cnt=ss.selectOne("totalCategory");
		ss.close();
		return cnt;
	}
	
	// 총 회원 수
	public int totalClient() {
		SqlSession ss=getSessionFactory().openSession();
		int cnt=ss.selectOne("totalClient");
		ss.close();
		return cnt;
	}
	
	// 오늘 가입한 회원 수
	public int todayClient(int today) {
		SqlSession ss=getSessionFactory().openSession();
		int cnt=ss.selectOne("todayClient", today);
		return cnt;
	}
	
	// 이번달 가입한 회원 수
	public int monthClient(int month) {
		SqlSession ss=getSessionFactory().openSession();
		int cnt=ss.selectOne("monthClient", month);
		return cnt;
	}
	
	// 오늘 날짜 구하기
	public int today() {
		SqlSession ss=getSessionFactory().openSession();
		int cnt=ss.selectOne("today");
		return cnt;
	}
	
	// 이번달 구하기
	public int month() {
		SqlSession ss=getSessionFactory().openSession();
		int cnt=ss.selectOne("month");
		return cnt;
	}
	
	// 탈퇴한 회원 수
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
