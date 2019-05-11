package kr.co.sist.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.vo.ListVO;
import kr.co.sist.user.domain.SearchClassList;
import kr.co.sist.user.service.SearchService;
import kr.co.sist.user.vo.SearchListVO;

@Controller
public class SearchController {
	
	SearchService ss;
	
	
	public SearchController() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext.xml");
		this.ss = ac.getBean("SearchService", SearchService.class);
	}
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@RequestMapping(value = "user/search.do", method = GET)
	public String searchPage(HttpServletRequest request, SearchListVO slvo, Model model) {
		List<SearchClassList> list = null;
		System.out.println(request.getParameter("keyword").toString()+"������");
		int totalCount = ss.totalCount(request.getParameter("keyword").toString());// �� �Խù��� ��//
		int pageScale = ss.pageScale();
		int totalPage = ss.totalPage(totalCount);// ��ü �Խù��� �����ֱ� ���� �� ������ ��
		if (slvo.getCurrentPage() == 0) { // web parameter�� ���� ���� ��
			slvo.setCurrentPage(1);
		}
		int startNum = ss.startNum(slvo.getCurrentPage());
		int endNum = ss.endNum(startNum);
		slvo.setStartNum(startNum);
		slvo.setEndNum(endNum);
		slvo.setKeyword(request.getParameter("keyword").toString());

		list = ss.searchClassList(slvo);// ����Ʈ ��� ��ȸ

		String indexList = ss.indexList(slvo.getCurrentPage(), totalPage, "search.do");
		model.addAttribute("list", list);// @@
		model.addAttribute("indexList", indexList);
		model.addAttribute("pageScale", pageScale);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", slvo.getCurrentPage());

		model.addAttribute("page", "question");// @@
		return "user/member/searchResult";
	}
	
}
