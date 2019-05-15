package kr.co.sist.admin.service;

import java.io.File;
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
	
	// 1. 占쎌읈筌ｏ옙 野껊슣�뻻�눧占� 占쎈땾 占쎈섯疫뀐옙
			public int totalCount() {
				int cnt = 0;
				cnt = c_dao.selectTotalCount();
				return cnt;
			}

			// 2. 占쎈립 占쎌넅筌롫똻肉� 癰귣똻肉э쭪占� 野껊슣�뻻�눧�눘�벥 占쎈땾
			public int pageScale() {
				int pageScale = 1;

				return pageScale;
			}

			// 3. �룯占� 占쎈읂占쎌뵠筌욑옙 占쎈땾 �뤃�뗫릭疫뀐옙
			public int totalPage(int totalCount) {
				int totalPage = totalCount / pageScale();
				if (totalCount % pageScale() != 0) {
					totalPage++;
				}

				return totalPage;
			}

			// 4. 占쎈뻻占쎌삂 占쎈읂占쎌뵠筌욑옙 甕곕뜇�깈 �뤃�뗫릭疫뀐옙
			// current_page占쎈퓠 占쎈뎡占쎌뵬 占쎈뻻占쎌삂 甕곕뜇�깈占쎈뮉 占쎈뼎占쎌뵬筌욊쑬�뼄. 1-> 1, 2->11, 3->21 ,,,
			public int startNum(int currentPage) {
				int startNum = 1;
				startNum = currentPage * pageScale() - pageScale() + 1;
				return startNum;
			}

			// 5. 占쎄국甕곕뜇�깈 占쎈섯疫뀐옙
			public int endNum(int startNum) {
				int endNum = startNum + pageScale() - 1;

				return endNum;
			}
			
			/**
			 * 占쎌뵥占쎈쑔占쎈뮞 �뵳�딅뮞占쎈뱜 [ << ] ... [1][2][3] ... [ >> ]
			 * 
			 * @param current_page
			 * @param total_page
			 * @param list_url
			 * @return
			 */
			// 占쎌겱占쎌삺 野껊슣�뻻占쎈솇占쎌벥 占쎈읂占쎌뵠筌욑옙 占쎌뵥占쎈쑔占쎈뮞 占쎄퐬占쎌젟
			public String indexList(int current_page, int total_page, String list_url) {
				int pagenumber; // 占쎌넅筌롫똻肉� 癰귣똻肉э쭪占� 占쎈읂占쎌뵠筌욑옙 占쎌뵥占쎈쑔占쎈뮞 占쎈땾
				int startpage; // 占쎌넅筌롫똻肉� 癰귣똻肉э쭪占� 占쎈뻻占쎌삂占쎈읂占쎌뵠筌욑옙 甕곕뜇�깈
				int endpage; // 占쎌넅筌롫똻肉� 癰귣똻肉э쭪占� 筌띾뜆占쏙쭕�맪�읂占쎌뵠筌욑옙 甕곕뜇�깈
				int curpage; // 占쎌뵠占쎈짗占쎈릭�⑥쥙�쁽 占쎈릭占쎈뮉 占쎈읂占쎌뵠筌욑옙 甕곕뜇�깈

				String strList = ""; // �뵳�뗪쉘占쎈쭍 占쎈읂占쎌뵠筌욑옙 占쎌뵥占쎈쑔占쎈뮞 �뵳�딅뮞占쎈뱜

				pagenumber = 10; // 占쎈립 占쎌넅筌롫똻�벥 占쎈읂占쎌뵠筌욑옙 占쎌뵥占쎈쑔占쎈뮞 占쎈땾

				// 占쎈뻻占쎌삂 占쎈읂占쎌뵠筌욑옙甕곕뜇�깈 �뤃�뗫릭疫뀐옙
				startpage = ((current_page - 1) / pagenumber) * pagenumber + 1;

				// 筌띾뜆占쏙쭕占� 占쎈읂占쎌뵠筌욑옙甕곕뜇�깈 �뤃�뗫릭疫뀐옙
				endpage = (((startpage - 1) + pagenumber) / pagenumber) * pagenumber;

				// �룯占� 占쎈읂占쎌뵠筌욑옙 占쎈땾揶쏉옙 �④쑴沅쏉옙留� 筌띾뜆占쏙쭕�맪�읂占쎌뵠筌욑옙 甕곕뜇�깈癰귣��뼄 占쎌삂占쎌뱽野껋럩�뒭

				// �룯占� 占쎈읂占쎌뵠筌욑옙 占쎈땾揶쏉옙 筌띾뜆占쏙쭕�맪�읂占쎌뵠筌욑옙 甕곕뜇�깈揶쏉옙 占쎈쭡

				if (total_page <= endpage) {
					endpage = total_page;
				} // end if

				// 筌ｃ꺂苡뀐쭪占� 占쎈읂占쎌뵠筌욑옙 占쎌뵥占쎈쑔占쎈뮞 占쎌넅筌롫똻�뵠 占쎈툡占쎈빒野껋럩�뒭
				if (current_page > pagenumber) {
					curpage = startpage - 1; // 占쎈뻻占쎌삂占쎈읂占쎌뵠筌욑옙 甕곕뜇�깈癰귣��뼄 1 占쎌읅占쏙옙 占쎈읂占쎌뵠筌욑옙嚥∽옙 占쎌뵠占쎈짗
					strList = strList + "<li class='page-item'><a class='page-link' href=" + list_url + "?currentPage=" + curpage + ">Prev</a></li>";
				} else {
					strList = strList + "<li class='page-item'><a class='page-link' href='#'>Prev</a></li>";
					
				}

				// 占쎈뻻占쎌삂占쎈읂占쎌뵠筌욑옙 甕곕뜇�깈�겫占쏙옙苑� 筌띾뜆占쏙쭕�맪�읂占쎌뵠筌욑옙 甕곕뜇�깈繹먮슣占� 占쎌넅筌롫똻肉� 占쎈ご占쎈뻻
				curpage = startpage;

				while (curpage <= endpage) {
					if (curpage == current_page) {
						strList = strList + "<li class='page-item active'><a class='page-link' href='#'>"+current_page+"</a>";
					} else {
						strList = strList + "<li class='page-item'><a class='page-link' href=" + list_url + "?currentPage="+curpage+">"+curpage+"</a></li>";
					} // end else

					curpage++;
				} // end while

				// 占쎈츟占쎈퓠 占쎈읂占쎌뵠筌욑옙揶쏉옙 占쎈쐭 占쎌뿳占쎈뮉野껋럩�뒭
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
		
		String fsl = File.separator;
		String root = request.getSession().getServletContext().getRealPath(fsl);
		String rootPath = root + "/upload/category" + fsl;
		
		MultipartRequest mr=new MultipartRequest(request, rootPath, 1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
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
		
		String fsl = File.separator;
		String root = request.getSession().getServletContext().getRealPath(fsl);
		String rootPath = root + "/upload/category" + fsl;
		
		MultipartRequest mr=new MultipartRequest(request, rootPath,1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
		
		
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
