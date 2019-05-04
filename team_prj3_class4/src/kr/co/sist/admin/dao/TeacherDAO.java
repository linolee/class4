package kr.co.sist.admin.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.domain.TeacherCareer;
import kr.co.sist.admin.domain.TeacherDetailDomain;
import kr.co.sist.admin.domain.TeacherDomain;
import kr.co.sist.admin.domain.TeacherLesson;
import kr.co.sist.admin.vo.ListVO;

@Component
public class TeacherDAO {

private SqlSessionFactory ssf;
	
	private static TeacherDAO t_dao;
	
	public static TeacherDAO getInstance() {
		if(t_dao==null) {
			t_dao=new TeacherDAO();
		}
		return t_dao;
	}


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
	
	public int teacherTotalCount() {
		SqlSession ss=getSessionFactory().openSession();
		int cnt=ss.selectOne("teacherTotalCnt");
		ss.close();
		return cnt;
	}
	
	public List<TeacherDomain> selectAllTeacher(ListVO lvo){
		List<TeacherDomain> list=null;
		
		SqlSession ss=getSessionFactory().openSession();
		list=ss.selectList("selectTeacher", lvo);
		ss.close();
		return list;
	}
	
	public TeacherDetailDomain selectTeacherDetail(String teacherName) {
		SqlSession ss=getInstance().getSessionFactory().openSession();
		TeacherDetailDomain tdd=ss.selectOne("selectDetailTeacher", teacherName);
		ss.close();
		return tdd;
	}
	
	public List<TeacherCareer> selectCareer(String teacherName){
		List<TeacherCareer> list=null;
		SqlSession ss=getSessionFactory().openSession();
		list=ss.selectList("selectTeacherCareer", teacherName);
		ss.close();
		return list;
	}
	
	public List<TeacherLesson> selectLesson(String teacherName){
		List<TeacherLesson> list=null;
		SqlSession ss=getSessionFactory().openSession();
		list=ss.selectList("selectTeacherLesson", teacherName);
		ss.close();
		return list;
	}
	
	
	public static void main(String[] args) {
		TeacherDAO tdao=new TeacherDAO();
		
		//System.out.println(tdao.selectTeacherDetail("백인재").getCategory());
		//System.out.println(tdao.selectCareer("백인재"));
		System.out.println(tdao.selectLesson("백인재"));
		
	}
}
