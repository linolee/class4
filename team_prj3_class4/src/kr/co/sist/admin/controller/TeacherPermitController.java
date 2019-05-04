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
import kr.co.sist.admin.service.TeacherPermitService;
import kr.co.sist.admin.service.TeacherService;
import kr.co.sist.admin.vo.ListVO;

@Controller
public class TeacherPermitController {

	@Autowired
	TeacherService ts;
	@Autowired
	TeacherPermitService tps;
	
	@RequestMapping(value="/admin/teacherAuthority.do",method=GET)
	public String teacherAuthorityPage(ListVO lvo, Model model) {
		
		List<TeacherPermitDomain> list=null;
		/*ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContext2.xml");
		TeacherPermitService tps=ac.getBean(TeacherPermitService.class);*/
		
		int totalCount = tps.totalCount();//�� �Խù��� ��
		int pageScale = tps.pageScale();
		int totalPage = tps.totalPage(totalCount);//��ü �Խù��� �����ֱ� ���� �� ������ �� 
		if(lvo.getCurrentPage() == 0) { //web parameter�� ���� ���� ��
			lvo.setCurrentPage(1);
		}
		int startNum = tps.startNum(lvo.getCurrentPage());
		int endNum = tps.endNum(startNum);

		lvo.setStartNum(startNum);
		lvo.setEndNum(endNum);
		
		String indexList = tps.indexList(lvo.getCurrentPage(), totalPage, "teacherAuthority.do");
		
		
		list=tps.selectTeacherPermit(lvo);
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
