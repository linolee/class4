package kr.co.sist;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {


	@RequestMapping(value="/admin/template.do",method= {GET,POST})
	public String mainPage(Model model) {

		return "admin/template";//
	}

}
