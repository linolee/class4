package kr.co.sist.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.admin.domain.TeacherDomain;
import kr.co.sist.admin.service.IndexService;
import kr.co.sist.admin.service.TeacherService;
import kr.co.sist.admin.vo.ListVO;
import kr.co.sist.admin.vo.OptionSearchVO;

@Controller
public class TteacherController {

	@Autowired
	private TeacherService ts;
	@Autowired
	private IndexService is;
	
	@RequestMapping(value="/admin/teacher.do",method=GET)
	public String teacherPage(Model model, ListVO lvo, HttpSession session,
			@RequestParam(value="searchOption", required=false)String option, 
			@RequestParam(value="keyword", required=false)String keyword) {
		
		String loginChk=(String)session.getAttribute("loginFlag");
		if("true"!=loginChk) {
			return "redirect:/admin/AdminLogin.do";
		}

		List<TeacherDomain> list=null;
		
		int totalCount = ts.totalCount();//총 게시물의 수
		int pageScale = is.pageScale();
		int totalPage = is.totalPage(totalCount);//전체 게시물을 보여주기 위한 총 페이지 수 
		if(lvo.getCurrentPage() == 0) { //web parameter에 값이 없을 때
			lvo.setCurrentPage(1);
		}
		int startNum = is.startNum(lvo.getCurrentPage());
		int endNum = is.endNum(startNum);
		
		lvo.setStartNum(startNum);
		lvo.setEndNum(endNum);
		
		list=ts.selectAllTeacher(lvo);
		
		OptionSearchVO osvo=new OptionSearchVO();
		if(null!=option && null!=keyword) {
			osvo.setOption(option);
			osvo.setKeyword(keyword);
			osvo.setCurrentPage(lvo.getCurrentPage());
			osvo.setStartNum(startNum);
			osvo.setEndNum(endNum);
			list=ts.teacherOptionSearch(osvo);
		}
		
		String indexList = is.indexList(lvo.getCurrentPage(), totalPage, "teacher.do");
		
		model.addAttribute("teacherList", list);
		model.addAttribute("indexList", indexList);
		model.addAttribute("pageScale", pageScale);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", lvo.getCurrentPage());
		
		model.addAttribute("page", "teacher/teacher");
		return "admin/template";
	}
	
	@ResponseBody
	@RequestMapping(value="/admin/teacherDetail.do", method=GET)
	public String teacherDetailPage(@RequestParam("teacherName") String teacherName) {
		JSONObject json=null;
		json=ts.selectDeatailTeacher(teacherName);
		return json.toJSONString();
	}
	
}
