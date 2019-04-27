package kr.co.sist.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.domain.BlackListDomain;
import kr.co.sist.admin.service.BlackListService;
import kr.co.sist.admin.vo.ListVO;

@Controller
public class BlackListController {
	@RequestMapping(value="/admin/blacklist.do",method=GET)
	public String blacklistPage(ListVO lvo, Model model) {
		
		List<BlackListDomain> list=null;
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext2.xml");
		BlackListService bls=ac.getBean(BlackListService.class);
		
		int totalCount = bls.totalCount();//�� �Խù��� ��
		int pageScale = bls.pageScale();
		int totalPage = bls.totalPage(totalCount);//��ü �Խù��� �����ֱ� ���� �� ������ �� 
		if(lvo.getCurrentPage() == 0) { //web parameter�� ���� ���� ��
			lvo.setCurrentPage(1);
		}
		int startNum = bls.startNum(lvo.getCurrentPage());
		int endNum = bls.endNum(startNum);
		lvo.setStartNum(startNum);
		lvo.setEndNum(endNum);
		
		list=bls.selectBlackList(lvo);
		String indexList = bls.indexList(lvo.getCurrentPage(), totalPage, "blacklist.do");
		model.addAttribute("page", "blacklist");
		model.addAttribute("blackList", list);
		model.addAttribute("indexList", indexList);
		model.addAttribute("pageScale", pageScale);
		model.addAttribute("totalCount", totalCount);
		return "admin/template";
	}
	
}
