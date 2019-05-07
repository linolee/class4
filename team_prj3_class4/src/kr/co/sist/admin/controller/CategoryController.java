package kr.co.sist.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.admin.domain.CategoryDomain;
import kr.co.sist.admin.service.CategoryService;
import kr.co.sist.admin.vo.AddInnerCategory;
import kr.co.sist.admin.vo.ListVO;


@Controller
public class CategoryController {

	@Autowired
	private CategoryService cs;
	
	@RequestMapping(value="/admin/category.do",method= {GET,POST})
	public String categoryPage(ListVO lvo, Model model, HttpServletRequest request) {
		
		String url="admin/template";
		List<CategoryDomain> list=null;
		int totalCount = cs.totalCount();//�� �Խù��� ��
		int pageScale = cs.pageScale();
		int totalPage = cs.totalPage(totalCount);//��ü �Խù��� �����ֱ� ���� �� ������ �� 
		if(lvo.getCurrentPage() == 0) { //web parameter�� ���� ���� ��
			lvo.setCurrentPage(1);
		}
		int startNum = cs.startNum(lvo.getCurrentPage());
		int endNum = cs.endNum(startNum);
		
		lvo.setStartNum(startNum);
		lvo.setEndNum(endNum);
		
		list=cs.selectAllCategory(lvo);
		
		
		
		/////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////
		///////////////// currentPage test////////////////////////////////////
		/*String curr="";
		if(request.getParameter("currentPage")!=null) {
			String pp=request.getParameter("currentPage");
			curr="?currentPage="+pp;
			System.out.println("+--+--+-+---+++-+-+-+-+-"+curr);
			System.out.println("+--+--+-+---+++-+-+-+-+-"+"category/category"+curr);
			//url="forward:/admin/category.do"+curr;
			url="/admin/category.do"+curr;
		}*/
		/////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////
		
		Map<String, List> map=new HashMap<String, List>();
		List<String> innerCateList=null;
		//////////////// �Һз� test
		for(int i=0;i<list.size();i++) {
			String cate=list.get(i).getCategory();
			innerCateList=cs.selectInnerCategory(cate);
			
			model.addAttribute("inner", innerCateList);
			// map.put(cate, inCateList);
		}
		//System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-"+map);
		//System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-"+inCateList);
		//model.addAttribute("inCateList", inCateList);
		model.addAttribute("innerCate", map);
		
		String[] innerBtn= {"btn-twitter", "btn-vine"};
		model.addAttribute("btn", innerBtn);
		
		String indexList = cs.indexList(lvo.getCurrentPage(), totalPage, "category.do");
		
		model.addAttribute("categoryList", list);
		model.addAttribute("indexList", indexList);
		model.addAttribute("pageScale", pageScale);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", lvo.getCurrentPage());
		/*model.addAttribute("page", "category/category"+curr);*/
		model.addAttribute("page", "category/category");
		/*return "admin/template";*/
		return url;
	}
	
	@ResponseBody
	@RequestMapping(value="/admin/addInnerCate.do",method=GET)
	public String addInnerCategory(@RequestParam(value="category")String category, @RequestParam(value="innerCategory")String innerCategory
											) {
		JSONObject json = null;
		AddInnerCategory aic=new AddInnerCategory(category, innerCategory);
		json=cs.addInnerCate(aic);
		//System.out.println("------+-+-+-+-+-+-+-+-+-+-+-+-+-+-"+category+"+-+-+-+-+-+-+-+"+innerCategory);
		
		return json.toJSONString();
	}

	@RequestMapping(value="/admin/cateUpload.do", method=POST)
	public String uploadImg(HttpServletRequest request) {
		
		String url="admin/template"; 
		
		try {
			if(cs.fileUploadProcess(request)) {
				url="forward:/admin/category.do";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return url;
	}
	
}