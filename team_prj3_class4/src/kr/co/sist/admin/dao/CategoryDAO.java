package kr.co.sist.admin.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.domain.AddInnerCate;
import kr.co.sist.admin.domain.CategoryDomain;
import kr.co.sist.admin.vo.AddInnerCategory;
import kr.co.sist.admin.vo.CategoryImgVO;
import kr.co.sist.admin.vo.ListVO;

@Component
public class CategoryDAO {

	@Autowired
	private CategoryDAO c_dao;
	
	private SqlSessionFactory ssf=null;
	
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
	
	public int selectTotalCount() {
		int cnt=0;
		SqlSession ss = getSessionFactory().openSession();
		cnt=ss.selectOne("selectTotalCnt");
		ss.close();
		return cnt;
	}
	
	public List<CategoryDomain> selectAllCategory(ListVO lvo){
		List<CategoryDomain> list=null;
		SqlSession ss = getSessionFactory().openSession();
		list=ss.selectList("selectCategory", lvo);
		ss.close();
		return list;
	}
	
	public int addInnerCategory(AddInnerCategory aic) {
		int cnt=0;
		SqlSession ss = getSessionFactory().openSession();
		cnt=ss.insert("addInnerCategory", aic);
		if(cnt==1) {
			ss.commit();
		}
		ss.close();
		return cnt;
	}
	
	public List<String> selectInnerCategory(String category){
		List<String> list=null;
		SqlSession ss=getSessionFactory().openSession();
		list=ss.selectList("selectInnerCategory", category);
		ss.close();
		return list;
	}
	
	public boolean updateCategoryImg(CategoryImgVO civo) {
		boolean flag=false;
		SqlSession ss=getSessionFactory().openSession();
		int cnt=ss.update("updateCategoryImg", civo);
		if(cnt==1) {
			ss.commit();
			flag=true;
		}
		ss.close();
		return flag;
	}
	
	public static void main(String[] args) {
		CategoryDAO cdao=new CategoryDAO();
		//cdao.selectInnerCategory("음악");
		/*AddInnerCategory aic=new AddInnerCategory("게임", "메이플스토리");
		cdao.addInnerCategory(aic);*/
		/*CategoryImgVO civo=new CategoryImgVO("패션", "null");
		cdao.updateCategoryImg(civo);*/
		
	}
	
}
