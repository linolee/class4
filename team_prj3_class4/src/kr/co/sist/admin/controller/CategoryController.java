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
public class CategoryController {

	@RequestMapping(value="/admin/category.do",method=GET)
	public String categoryPage(Model model) {
		
		model.addAttribute("page", "category/category");
		return "admin/template";
	}
}
