package kr.co.sist.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import kr.co.sist.admin.domain.BlackListDomain;
import kr.co.sist.admin.service.BlackListService;
import kr.co.sist.admin.vo.ListVO;

@Controller
public class BlackListController {
	
	@Autowired
	private BlackListService bls;
	
	@RequestMapping(value="/admin/blacklist.do",method={GET,POST})
	public String blacklistPage(ListVO lvo, Model model, HttpServletRequest request) {
		
		String id=request.getParameter("hdnBlack");
		
		List<BlackListDomain> list=null;
		
		System.out.println(id);
		String url="/admin/template";	
		if((id!=null)) {
			if (bls.deleteBlack(id)) {
				url="forward:/admin/template.do";
				//request.setAttribute(name, o);
			}
		}
		
		int totalCount = bls.totalCount();//총 게시물의 수
		int pageScale = bls.pageScale();
		int totalPage = bls.totalPage(totalCount);//전체 게시물을 보여주기 위한 총 페이지 수 
		if(lvo.getCurrentPage() == 0) { //web parameter에 값이 없을 때
			lvo.setCurrentPage(1);
		}
		int startNum = bls.startNum(lvo.getCurrentPage());
		int endNum = bls.endNum(startNum);
		lvo.setStartNum(startNum);
		lvo.setEndNum(endNum);
		list=bls.selectBlackList(lvo);
		
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
		
		/*ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext2.xml");
		BlackListService bls=ac.getBean(BlackListService.class);*/
		
		json = bls.detailBlack(id);

		return json.toJSONString();
	}
	
}
