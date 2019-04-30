package kr.co.sist.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import kr.co.sist.admin.domain.MemberDetail;
import kr.co.sist.admin.domain.MemberLesson;
import kr.co.sist.admin.domain.MemberListDomain;
import kr.co.sist.admin.service.MemberListService;
import kr.co.sist.admin.vo.ListVO;

@Controller
public class MemberListController {
	
	@Autowired
	MemberListService mls;
	
	@RequestMapping(value="/admin/member.do",method=GET)
	public String memberPage(ListVO lvo, Model model) {
		
		List<MemberListDomain> list=null;
		
		int totalCount = mls.totalCount();//�� �Խù��� ��
		int pageScale = mls.pageScale();
		int totalPage = mls.totalPage(totalCount);//��ü �Խù��� �����ֱ� ���� �� ������ �� 
		if(lvo.getCurrentPage() == 0) { //web parameter�� ���� ���� ��
			lvo.setCurrentPage(1);
		}
		int startNum = mls.startNum(lvo.getCurrentPage());
		int endNum = mls.endNum(startNum);
		
		lvo.setStartNum(startNum);
		lvo.setEndNum(endNum);

		list=mls.selectAllMember(lvo);
		String indexList = mls.indexList(lvo.getCurrentPage(), totalPage, "member.do");
		model.addAttribute("memberList", list);
		model.addAttribute("indexList", indexList);
		model.addAttribute("pageScale", pageScale);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", lvo.getCurrentPage());
		
		model.addAttribute("page", "member/member");
		return "admin/template";
	}
	
	//ajax�� ȸ���󼼺���
	@ResponseBody
	@RequestMapping(value="/admin/memberDetail.do",method=GET)
	public String memberDetailPage(String id) {
		JSONObject json = null;
		
		json = mls.searchMemberDetail(id);
		//System.out.println(json.toJSONString());
		
		return json.toJSONString();
	}
	
	@ResponseBody
	@RequestMapping(value="/admin/addBlack.do",method=GET)
	public String addBlack(String id, String reason) {
		JSONObject json = null;
		
		// ������Ʈ������ ���� �޾Ƽ� ����Ʈ ���� �����ؾ���
		//json = mls.searchMemberDetail(id);
		//System.out.println(json.toJSONString());
		
		return json.toJSONString();
	}
	
}