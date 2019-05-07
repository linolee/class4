package kr.co.sist.user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

@Component
public class MainContentsDAO {
	
	private SqlSessionFactory ssf=null;
	
	public synchronized SqlSessionFactory getSessionFactory() {
		if(ssf==null) {
			org.apache.ibatis.logging.LogFactory.useLog4JLogging();
			
			Reader reader=null;
			try {
				//1.������ xml �ε�
				reader=Resources.getResourceAsReader("kr/co/sist/user/dao/mybatis_config.xml");
				//2.MyBatis Framework ����
				SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
				//3.DB�� ������ ��ü �ޱ�
				ssf=ssfb.build(reader);
				if(reader!=null) {reader.close();}//end if
				
			} catch (IOException e) {
				e.printStackTrace();
			}//end catch
		}//end if
		return ssf;
	}//getSessionFactory
	
	public List<String> selectCategory() {
		List<String> category=null;
		
		SqlSession ss=getSessionFactory().openSession();
		category=ss.selectList("selectCategoryList");
		ss.close();
		return category;
	}//selectCategory

	public static void main(String[] args) {
		MainContentsDAO m_dao=new MainContentsDAO();
		List<String> category=m_dao.selectCategory();
		System.out.println(category);
		
	}//main
	
}
