package kr.co.sist.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.admin.domain.MemberListDomain;
import kr.co.sist.admin.service.IndexService;
import kr.co.sist.admin.service.MemberListService;
import kr.co.sist.admin.vo.AddBlackVO;
import kr.co.sist.admin.vo.ListVO;
import kr.co.sist.admin.vo.OptionSearchVO;

@Controller
public class MemberListController {
	
	@Autowired
	private MemberListService mls;
	@Autowired
	private IndexService is;
	
	@RequestMapping(value="/admin/member.do",method=GET)
	public String memberPage(ListVO lvo, Model model, 
			@RequestParam(value="searchOption", required=false)String option, 
			@RequestParam(value="keyword", required=false)String keyword) {
		
		List<MemberListDomain> list=null;
		int totalCount = mls.totalCount();//총 게시물의 수
		int pageScale = is.pageScale();
		int totalPage = is.totalPage(totalCount);//전체 게시물을 보여주기 위한 총 페이지 수 
		if(lvo.getCurrentPage() == 0) { //web parameter에 값이 없을 때
			lvo.setCurrentPage(1);
		}
		int startNum = is.startNum(lvo.getCurrentPage());
		int endNum = is.endNum(startNum);
		
		lvo.setStartNum(startNum);
		lvo.setEndNum(endNum);
		
		list=mls.selectAllMember(lvo);

		
		
		OptionSearchVO osvo=new OptionSearchVO();
		if(null!=option && null!=keyword) {
			osvo.setOption(option);
			osvo.setKeyword(keyword);
			osvo.setCurrentPage(lvo.getCurrentPage());
			osvo.setStartNum(startNum);
			osvo.setEndNum(endNum);
			list=mls.memberOptionSearch(osvo);
		}
		
		
		String indexList = is.indexList(lvo.getCurrentPage(), totalPage, "member.do");
		
		model.addAttribute("memberList", list);
		model.addAttribute("indexList", indexList);
		model.addAttribute("pageScale", pageScale);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", lvo.getCurrentPage());
		
		model.addAttribute("page", "member/member");
		return "admin/template";
	}
	
	//ajax로 회원상세보기
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
	public String addBlack(@RequestParam(value="id", required=false)String id, @RequestParam(value="reason", required=false)String reason) {
		JSONObject json = null;
		/*SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");*/
		SimpleDateFormat format1 = new SimpleDateFormat ("yyyy-MM-dd");
		Date date = new Date();
		String time = format1.format(date);
		//System.out.println("------------------"+"id="+id+"  reason="+reason);
		//System.out.println("-------------------"+time);
		AddBlackVO abvo=new AddBlackVO(id, reason, time);
		
		json=mls.addBlack(abvo);
		
		// 쿼리스트링으로 값을 받아서 딜리트 쿼리 실행해야함
		//json = mls.searchMemberDetail(id);
		//System.out.println(json.toJSONString());
		
		return json.toJSONString();
	}
	
}