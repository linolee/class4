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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.admin.domain.TeacherPermitDomain;
import kr.co.sist.admin.service.IndexService;
import kr.co.sist.admin.service.TeacherPermitService;
import kr.co.sist.admin.service.TeacherService;
import kr.co.sist.admin.vo.ListVO;
import kr.co.sist.admin.vo.OptionSearchVO;

@Controller
public class TeacherPermitController {

	@Autowired
	private TeacherService ts;
	@Autowired
	private TeacherPermitService tps;
	@Autowired
	private IndexService is;
	
	@RequestMapping(value="/admin/teacherAuthority.do",method=GET)
	public String teacherAuthorityPage(ListVO lvo, Model model,
			@RequestParam(value="searchOption", required=false)String option, 
			@RequestParam(value="keyword", required=false)String keyword) {
		
		List<TeacherPermitDomain> list=null;
		/*ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext2.xml");
		TeacherPermitService tps=ac.getBean(TeacherPermitService.class);*/
		
		int totalCount = tps.totalCount();//총 게시물의 수
		int pageScale = is.pageScale();
		int totalPage = is.totalPage(totalCount);//전체 게시물을 보여주기 위한 총 페이지 수 
		if(lvo.getCurrentPage() == 0) { //web parameter에 값이 없을 때
			lvo.setCurrentPage(1);
		}
		int startNum = is.startNum(lvo.getCurrentPage());
		int endNum = is.endNum(startNum);

		lvo.setStartNum(startNum);
		lvo.setEndNum(endNum);
		list=tps.selectTeacherPermit(lvo);
		
		OptionSearchVO osvo=new OptionSearchVO();
		if(null!=option && null!=keyword) {
			osvo.setOption(option);
			osvo.setKeyword(keyword);
			osvo.setCurrentPage(lvo.getCurrentPage());
			osvo.setStartNum(startNum);
			osvo.setEndNum(endNum);
			list=tps.teacherPermitOptionSearch(osvo);
		}
		
		
		
		
		
		String indexList = is.indexList(lvo.getCurrentPage(), totalPage, "teacherAuthority.do");
		
		
		model.addAttribute("indexList", indexList);
		model.addAttribute("pageScale", pageScale);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", lvo.getCurrentPage());
		model.addAttribute("page", "teacherAuthority/teacherAuthority");
		model.addAttribute("teacherPermitList", list);
		return "admin/template";
	}
	
	@ResponseBody
	@RequestMapping(value="/admin/teacherPermitDetail.do", method=GET)
	public String teacherDetailPage(@RequestParam("tName") String teacherName) {
		JSONObject json=null;
		json=ts.selectDeatailTeacher(teacherName);
		return json.toJSONString();
	}
	
	@ResponseBody
	@RequestMapping(value="/admin/teacherPermission", method=GET)
	public void teacherPermission(String id) {
		tps.teacherPermission(id);
	}
	
	@ResponseBody
	@RequestMapping(value="/admin/teacherRefuse", method=GET)
	public void teacherRefuse(String id) {
		tps.teacherRefuse(id);
	}
	
}
