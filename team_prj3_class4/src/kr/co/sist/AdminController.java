package kr.co.sist;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.service.AdminLoginService;
import kr.co.sist.admin.vo.StatsVO;

@Controller
public class AdminController {

	@Autowired
	AdminLoginService als;
	
	@RequestMapping(value="/admin/template.do",method= {GET,POST})
	public String mainPage(Model model, HttpSession session) {

		String loginChk=(String)session.getAttribute("loginFlag");
		if("true"!=loginChk) {
			return "admin/AdminLogin";
		}
		
		StatsVO svo=new StatsVO();
		svo=als.templateStats();
		
		model.addAttribute("stats", svo);
		
		return "admin/template";
	}

}
