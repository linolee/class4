package kr.co.sist.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.user.domain.SearchClassList;
import kr.co.sist.user.service.categorySearchService;
import kr.co.sist.user.vo.SearchListVO;

@Controller
public class CategorySearchController {
	
	
	@RequestMapping(value = "user/categorySearch.do", method = GET)
	public String searchPage(HttpServletRequest request, SearchListVO slvo, Model model) {
		List<SearchClassList> list = null;
		List<String> categoryList = null;
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		categorySearchService css=ac.getBean(categorySearchService.class);
		
		int totalCount = css.totalCount(request.getParameter("keyword").toString());// 총 게시물의 수//
		int pageScale = css.pageScale();
		int totalPage = css.totalPage(totalCount);// 전체 게시물을 보여주기 위한 총 페이지 수
		if (slvo.getCurrentPage() == 0) { // web parameter에 값이 없을 때
			slvo.setCurrentPage(1);
		}
		int startNum = css.startNum(slvo.getCurrentPage());
		int endNum = css.endNum(startNum);
		slvo.setStartNum(startNum);
		slvo.setEndNum(endNum);
		slvo.setKeyword(request.getParameter("keyword").toString());

		list = css.searchClassList(slvo);

		String indexList = css.indexList(slvo.getCurrentPage(), totalPage, "categorySearch.do", slvo.getKeyword());
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("list", list);// @@
		model.addAttribute("indexList", indexList);
		model.addAttribute("pageScale", pageScale);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", slvo.getCurrentPage());
		model.addAttribute("keyword", slvo.getKeyword());

		model.addAttribute("page", "question");// @@
		return "user/member/categorySearchResult";
	}
	
}
