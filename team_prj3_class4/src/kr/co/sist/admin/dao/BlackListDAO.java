package kr.co.sist.admin.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.domain.BlackListDomain;
import kr.co.sist.admin.vo.BlackListDetailVO;
import kr.co.sist.admin.vo.ListVO;

@Component
public class BlackListDAO {
	
	private static BlackListDAO bl_dao;
	private SqlSessionFactory ssf=null;
	
	public static BlackListDAO getInstance() {
		if(bl_dao == null) {
			bl_dao=new BlackListDAO();
		}//end if
		return bl_dao;
	}//getInstance
	
	
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
	
	public List<BlackListDomain> selectBlackList(ListVO lvo){
		List<BlackListDomain> list=null;
		
		SqlSession ss = getSessionFactory().openSession();
		list = ss.selectList("selectBlackList", lvo);
		ss.close();
		
		return list;
	}
	
	
	public int selectTotalCount() {
		SqlSession ss = getSessionFactory().openSession();
		int cnt = ss.selectOne("blackTotalCnt");
		ss.close();
		return cnt;
	}
	
	public BlackListDetailVO selectDetailBlackList(String id){
		BlackListDetailVO mldvo=null;
		mldvo=new BlackListDetailVO();
		
		SqlSession ss=getSessionFactory().openSession();

		mldvo=ss.selectOne("selectDetailBlackList", id);
		//System.out.println(mldvo.getClient_id()+"/"+mldvo.getB_date());
		ss.close();

		return mldvo;
	}
	
	public boolean deleteBlackList(String id) {
		boolean flag=false;
		
		SqlSession ss=getSessionFactory().openSession();
		int del=ss.delete("deleteBlackList", id);
		if(del==1) {
			flag=true;
			ss.commit();
		}
		ss.close();
		return flag;
	}
	
	
	public static void main(String[] args) {
		BlackListDAO bldao=new BlackListDAO();
		//bldao.selectDetailBlackList("1");
		bldao.deleteBlackList("blacklist10");
	}
	
	
} // class