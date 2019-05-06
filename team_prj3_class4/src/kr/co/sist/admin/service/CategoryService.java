package kr.co.sist.admin.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.sist.admin.dao.CategoryDAO;
import kr.co.sist.admin.domain.CategoryDomain;
import kr.co.sist.admin.vo.AddInnerCategory;
import kr.co.sist.admin.vo.CategoryImgVO;
import kr.co.sist.admin.vo.ListVO;


@Component
public class CategoryService {
	
	@Autowired
	private CategoryDAO c_dao;
	
	// 1. 전체 게시물 수 얻기
			public int totalCount() {
				int cnt = 0;
				cnt = c_dao.selectTotalCount();
				return cnt;
			}

			// 2. 한 화면에 보여질 게시물의 수
			public int pageScale() {
				int pageScale = 1;

				return pageScale;
			}

			// 3. 총 페이지 수 구하기
			public int totalPage(int totalCount) {
				int totalPage = totalCount / pageScale();
				if (totalCount % pageScale() != 0) {
					totalPage++;
				}

				return totalPage;
			}

			// 4. 시작 페이지 번호 구하기
			// current_page에 따라 시작 번호는 달라진다. 1-> 1, 2->11, 3->21 ,,,
			public int startNum(int currentPage) {
				int startNum = 1;
				startNum = currentPage * pageScale() - pageScale() + 1;
				return startNum;
			}

			// 5. 끝번호 얻기
			public int endNum(int startNum) {
				int endNum = startNum + pageScale() - 1;

				return endNum;
			}
			
			/**
			 * 인덱스 리스트 [ << ] ... [1][2][3] ... [ >> ]
			 * 
			 * @param current_page
			 * @param total_page
			 * @param list_url
			 * @return
			 */
			// 현재 게시판의 페이지 인덱스 설정
			public String indexList(int current_page, int total_page, String list_url) {
				int pagenumber; // 화면에 보여질 페이지 인덱스 수
				int startpage; // 화면에 보여질 시작페이지 번호
				int endpage; // 화면에 보여질 마지막페이지 번호
				int curpage; // 이동하고자 하는 페이지 번호

				String strList = ""; // 리턴될 페이지 인덱스 리스트

				pagenumber = 10; // 한 화면의 페이지 인덱스 수

				// 시작 페이지번호 구하기
				startpage = ((current_page - 1) / pagenumber) * pagenumber + 1;

				// 마지막 페이지번호 구하기
				endpage = (((startpage - 1) + pagenumber) / pagenumber) * pagenumber;

				// 총 페이지 수가 계산된 마지막페이지 번호보다 작을경우

				// 총 페이지 수가 마지막페이지 번호가 됨

				if (total_page <= endpage) {
					endpage = total_page;
				} // end if

				// 첫번째 페이지 인덱스 화면이 아닌경우
				if (current_page > pagenumber) {
					curpage = startpage - 1; // 시작페이지 번호보다 1 적은 페이지로 이동
					strList = strList + "<li class='page-item'><a class='page-link' href=" + list_url + "?currentPage=" + curpage + ">Prev</a></li>";
				} else {
					strList = strList + "<li class='page-item'><a class='page-link' href='#'>Prev</a></li>";
					
				}

				// 시작페이지 번호부터 마지막페이지 번호까지 화면에 표시
				curpage = startpage;

				while (curpage <= endpage) {
					if (curpage == current_page) {
						strList = strList + "<li class='page-item active'><a class='page-link' href='#'>"+current_page+"</a>";
					} else {
						strList = strList + "<li class='page-item'><a class='page-link' href=" + list_url + "?currentPage="+curpage+">"+curpage+"</a></li>";
					} // end else

					curpage++;
				} // end while

				// 뒤에 페이지가 더 있는경우
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
				"C:/Users/in112/git/class4/team_prj3_class4/WebContent/upload/category/",
						1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
			CategoryImgVO civo=new CategoryImgVO(mr.getParameter("category"), mr.getFilesystemName("img"));
			/*CategoryImgVO civo=new CategoryImgVO();
			civo.setCategory(request.getParameter("hdnCateName"));
			civo.setImg(request.getParameter("foo"));*/
		
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
	
	
	/*public static void main(String[] args) {
		CategoryService cs=new CategoryService(); 
		
	}*/
}
