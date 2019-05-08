package kr.co.sist.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.admin.domain.BlackListDomain;
import kr.co.sist.admin.service.BlackListService;
import kr.co.sist.admin.vo.ListVO;
import kr.co.sist.admin.vo.OptionSearchVO;

@Controller
public class BlackListController {
	
	@Autowired
	private BlackListService bls;
	
	@RequestMapping(value="/admin/blacklist.do",method={GET,POST})
	public String blacklistPage(ListVO lvo, Model model, HttpServletRequest request,
			@RequestParam(value="searchOption", required=false)String option, 
			@RequestParam(value="keyword", required=false)String keyword) {
		
		String id=request.getParameter("hdnBlack");
		
		List<BlackListDomain> list=null;
		
		String url="/admin/template";	
		if((id!=null)) {
			if (bls.deleteBlack(id)) {
				url="forward:/admin/template.do";
			}
		}
		
		int totalCount = bls.totalCount();
		int pageScale = bls.pageScale();
		int totalPage = bls.totalPage(totalCount);
		if(lvo.getCurrentPage() == 0) {
			lvo.setCurrentPage(1);
		}
		int startNum = bls.startNum(lvo.getCurrentPage());
		int endNum = bls.endNum(startNum);
		lvo.setStartNum(startNum);
		lvo.setEndNum(endNum);
		list=bls.selectBlackList(lvo);
		
		OptionSearchVO osvo=new OptionSearchVO();
		if(null!=option && null!=keyword) {
			osvo.setOption(option);
			osvo.setKeyword(keyword);
			osvo.setCurrentPage(lvo.getCurrentPage());
			osvo.setStartNum(startNum);
			osvo.setEndNum(endNum);
			list=bls.blackOptionSearch(osvo);
		}
		
		
		String indexList = bls.indexList(lvo.getCurrentPage(), totalPage, "blacklist.do");
		model.addAttribute("page", "blacklist/blacklist");
		model.addAttribute("blackList", list);
		model.addAttribute("indexList", indexList);
		model.addAttribute("pageScale", pageScale);
		model.addAttribute("currentPage", lvo.getCurrentPage());
		model.addAttribute("totalCount", totalCount);
		return url;
	}
	
	
	@ResponseBody
	@RequestMapping(value= "/admin/blackDetail.do", method= {GET,POST})
	public String AjaxView(@RequestParam("userID") String id){
		JSONObject json = null;
		
		json = bls.detailBlack(id);

		return json.toJSONString();
	}
	
}
