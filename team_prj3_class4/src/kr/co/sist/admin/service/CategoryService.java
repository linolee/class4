package kr.co.sist.admin.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.sist.admin.dao.CategoryDAO;
import kr.co.sist.admin.domain.CategoryDomain;
import kr.co.sist.admin.vo.AddInnerCategory;
import kr.co.sist.admin.vo.CategoryImgVO;
import kr.co.sist.admin.vo.InnerCategoryVO;
import kr.co.sist.admin.vo.ListVO;


@Component
public class CategoryService {
	
	@Autowired
	private CategoryDAO c_dao;
	
	// 1. �쟾泥� 寃뚯떆臾� �닔 �뼸湲�
			public int totalCount() {
				int cnt = 0;
				cnt = c_dao.selectTotalCount();
				return cnt;
			}

			// 2. �븳 �솕硫댁뿉 蹂댁뿬吏� 寃뚯떆臾쇱쓽 �닔
			public int pageScale() {
				int pageScale = 1;

				return pageScale;
			}

			// 3. 珥� �럹�씠吏� �닔 援ы븯湲�
			public int totalPage(int totalCount) {
				int totalPage = totalCount / pageScale();
				if (totalCount % pageScale() != 0) {
					totalPage++;
				}

				return totalPage;
			}

			// 4. �떆�옉 �럹�씠吏� 踰덊샇 援ы븯湲�
			// current_page�뿉 �뵲�씪 �떆�옉 踰덊샇�뒗 �떖�씪吏꾨떎. 1-> 1, 2->11, 3->21 ,,,
			public int startNum(int currentPage) {
				int startNum = 1;
				startNum = currentPage * pageScale() - pageScale() + 1;
				return startNum;
			}

			// 5. �걹踰덊샇 �뼸湲�
			public int endNum(int startNum) {
				int endNum = startNum + pageScale() - 1;

				return endNum;
			}
			
			/**
			 * �씤�뜳�뒪 由ъ뒪�듃 [ << ] ... [1][2][3] ... [ >> ]
			 * 
			 * @param current_page
			 * @param total_page
			 * @param list_url
			 * @return
			 */
			// �쁽�옱 寃뚯떆�뙋�쓽 �럹�씠吏� �씤�뜳�뒪 �꽕�젙
			public String indexList(int current_page, int total_page, String list_url) {
				int pagenumber; // �솕硫댁뿉 蹂댁뿬吏� �럹�씠吏� �씤�뜳�뒪 �닔
				int startpage; // �솕硫댁뿉 蹂댁뿬吏� �떆�옉�럹�씠吏� 踰덊샇
				int endpage; // �솕硫댁뿉 蹂댁뿬吏� 留덉�留됲럹�씠吏� 踰덊샇
				int curpage; // �씠�룞�븯怨좎옄 �븯�뒗 �럹�씠吏� 踰덊샇

				String strList = ""; // 由ы꽩�맆 �럹�씠吏� �씤�뜳�뒪 由ъ뒪�듃

				pagenumber = 10; // �븳 �솕硫댁쓽 �럹�씠吏� �씤�뜳�뒪 �닔

				// �떆�옉 �럹�씠吏�踰덊샇 援ы븯湲�
				startpage = ((current_page - 1) / pagenumber) * pagenumber + 1;

				// 留덉�留� �럹�씠吏�踰덊샇 援ы븯湲�
				endpage = (((startpage - 1) + pagenumber) / pagenumber) * pagenumber;

				// 珥� �럹�씠吏� �닔媛� 怨꾩궛�맂 留덉�留됲럹�씠吏� 踰덊샇蹂대떎 �옉�쓣寃쎌슦

				// 珥� �럹�씠吏� �닔媛� 留덉�留됲럹�씠吏� 踰덊샇媛� �맖

				if (total_page <= endpage) {
					endpage = total_page;
				} // end if

				// 泥ル쾲吏� �럹�씠吏� �씤�뜳�뒪 �솕硫댁씠 �븘�땶寃쎌슦
				if (current_page > pagenumber) {
					curpage = startpage - 1; // �떆�옉�럹�씠吏� 踰덊샇蹂대떎 1 �쟻�� �럹�씠吏�濡� �씠�룞
					strList = strList + "<li class='page-item'><a class='page-link' href=" + list_url + "?currentPage=" + curpage + ">Prev</a></li>";
				} else {
					strList = strList + "<li class='page-item'><a class='page-link' href='#'>Prev</a></li>";
					
				}

				// �떆�옉�럹�씠吏� 踰덊샇遺��꽣 留덉�留됲럹�씠吏� 踰덊샇源뚯� �솕硫댁뿉 �몴�떆
				curpage = startpage;

				while (curpage <= endpage) {
					if (curpage == current_page) {
						strList = strList + "<li class='page-item active'><a class='page-link' href='#'>"+current_page+"</a>";
					} else {
						strList = strList + "<li class='page-item'><a class='page-link' href=" + list_url + "?currentPage="+curpage+">"+curpage+"</a></li>";
					} // end else

					curpage++;
				} // end while

				// �뮘�뿉 �럹�씠吏�媛� �뜑 �엳�뒗寃쎌슦
				if (total_page > endpage) {
					curpage = endpage + 1;
					strList = strList + "<li class='page-item'><a class='page-link' href="+list_url+"?currentPage="+curpage+">Next</a></li>";
				} else {
					strList = strList + "<li class='page-item'><a class='page-link' href='#'>Next</a></li>";
				} // end else

				return strList;
			}// indexList
	
	public List<CategoryDomain> selectAllCategory(ListVO lvo) {
		List<CategoryDomain> list=null;
		list=c_dao.selectAllCategory(lvo);
		return list;
	}
	
	public List<String> selectInnerCategory(String category){
		List<String> list=null;
		list=c_dao.selectInnerCategory(category);
		return list;
	}
	
	public JSONObject addInnerCate(AddInnerCategory aic) {
		
		JSONObject json=new JSONObject();
		int cnt=0;
		cnt=c_dao.addInnerCategory(aic);
		json.put("add", cnt==1);
		
		return json;
	}
	
	
	public boolean fileUploadProcess(HttpServletRequest request) throws IOException{
		boolean flag=false;
		MultipartRequest mr=new MultipartRequest(request, 
				"C:/Users/sist/git/class4/team_prj3_class4/WebContent/upload/category/",
						1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
		/*MultipartRequest mr=new MultipartRequest(request, 
				"C:/Users/in112/git/class4/team_prj3_class4/WebContent/upload/category",
				1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());*/
		
			CategoryImgVO civo=new CategoryImgVO(mr.getParameter("hdnCateName"), mr.getFilesystemName("file"));

			try {
				if(c_dao.updateCategoryImg(civo)) {
					request.setAttribute("inputData", civo);
					flag=true;
				}
			}catch(DataAccessException das) {
				das.printStackTrace();
			}//end if
		return flag;
	}//fileUploadProcess
	
	public boolean addNewCategory(HttpServletRequest request ) throws IOException {
		boolean flag=false;
		
		/*MultipartRequest mr=new MultipartRequest(request, 
				"C:/Users/in112/git/class4/team_prj3_class4/WebContent/upload/category",
						1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());*/
		MultipartRequest mr=new MultipartRequest(request, 
				"C:/Users/sist/git/class4/team_prj3_class4/WebContent/upload/category/",
				1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
		
		
		String categoryName=mr.getParameter("newCateHdn");
		String categoryImg=mr.getFilesystemName("file2");
		if(null==categoryImg) {
			categoryImg="default.jpg";
		}
		
		CategoryImgVO civo=new CategoryImgVO(categoryName, categoryImg);
		try {
			if(c_dao.insertNewCategory(civo)) {
				InnerCategoryVO icvo=new InnerCategoryVO();
				icvo.setCategory(mr.getParameter("newCateHdn"));
				
				String[] paramArray=mr.getParameterValues("sCateHdn");
				if(null!=paramArray) {
					for(int i=0;i<paramArray.length;i++) {
						icvo.setInnercategory(paramArray[i]);
						c_dao.insertInnerCategory(icvo);
					} // for
				} // if
				flag=true;
			}
		}catch(DataAccessException das) {
			das.printStackTrace();
		}//end if
		return flag;
	}
	
	/*public static void main(String[] args) {
		CategoryService cs=new CategoryService(); 
		
	}*/
}
