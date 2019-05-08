package kr.co.sist.admin.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.domain.ChargeAllList;
import kr.co.sist.admin.domain.ChargeDetail;
import kr.co.sist.admin.domain.ChargeDetailList;
import kr.co.sist.admin.domain.LessonInfo;
import kr.co.sist.admin.vo.ListChargeDetailVO;
import kr.co.sist.admin.vo.ListVO;

@Component
public class ChargeDAO {

private SqlSessionFactory ssf=null;
	
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

	public List<ChargeAllList> selectChargeAllList(ListVO lvo){
		List<ChargeAllList> list = null;
		
		SqlSession ss = getSessionFactory().openSession();
		ss.update("endStatus1");//����Ʈ ��ȸ �� ���� ������ ��¥ �޾Ƽ� ���� �Ǵ� ��ҷ� ������ִ� ������ ����
		ss.update("endStatus2");//����Ʈ ��ȸ �� ���� ������ ��¥ �޾Ƽ� ���� �Ǵ� ��ҷ� ������ִ� ������ ����
		ss.commit();//
		
		list = ss.selectList("selectChargeAllList", lvo);
		ss.close();
		return list;
	}
	
	public int selectTotalCount() {
		SqlSession ss = getSessionFactory().openSession();
		int cnt = ss.selectOne("chargeTotalCnt");
		ss.close();
		return cnt;
	}
	
	public List<ChargeDetailList> selectChargeDetailList(ListChargeDetailVO lcdvo){
		List<ChargeDetailList> list = null;
		
		SqlSession ss = getSessionFactory().openSession();
		list = ss.selectList("selectChargeDetailList", lcdvo);
		ss.close();
		return list;
	}
	
	public int selectChargeDetailTotalCount(String lcode) {
		SqlSession ss = getSessionFactory().openSession();
		int cnt = ss.selectOne("chargeDetailTotalCnt", lcode);
		ss.close();
		return cnt;
	}
	
	public LessonInfo selectChargeDetailLessonInfo(String lcode) {
		SqlSession ss = getSessionFactory().openSession();
		LessonInfo li = ss.selectOne("chargeDetailLessonInfo", lcode);
		ss.close();
		return li;
	}
	
	public int updateLessonClosure(String lcode) {
		SqlSession ss = getSessionFactory().openSession();
		int cnt = ss.delete("updateLessonClosure", lcode);
		ss.commit();
		ss.close();
		return cnt;
	}
	
	public ChargeDetail selectChargeDetail(String rcode) {
		SqlSession ss = getSessionFactory().openSession();
		ChargeDetail cd = ss.selectOne("selectChargeDetail", rcode);
		ss.close();
		return cd;
	}
	
	public int deleteReport(String rcode) {
		SqlSession ss = getSessionFactory().openSession();
		int cnt = ss.delete("deleteReport", rcode);
		ss.commit();
		ss.close();
		return cnt;
	}
	
	public int updateReport(String rcode) {
		SqlSession ss = getSessionFactory().openSession();
		int cnt = ss.delete("updateReport", rcode);
		ss.commit();
		ss.close();
		return cnt;
	}
	
	
}
