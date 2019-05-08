package kr.co.sist;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.user.service.mainContentsService;


@Controller
public class MainController {
		
	@RequestMapping(value="/user/mainContents/mainContents.do", method = GET)
	public String showContentsForm(Model model) {
		List<String> categoryList=null;
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		mainContentsService mcs=ac.getBean(mainContentsService.class);
		categoryList=mcs.showMenuCategory();
		
		model.addAttribute("clist",categoryList);
		
		return "user/mainContents/mainContents";
	}//showContentsForm
	/*의존성 주입 AdminController.java*/
	
	@RequestMapping(value="/user/searchClass.do", method=GET)
	public String mvCategoryPage(String category, Model model) {
		return "";
	}//mvCategoryPage
	
	@RequestMapping(value="/user/recommend.do", method=GET)
	public String mvRecommendCalss(Model model) {
		return "";
	}//mvRecommendCalss
	
/*	@RequestMapping(value="/user/classDetail/detail.do", method=GET)
	public String mvDetailClass(String lcode,Model model) {
		return "user/classDetail/detail";
	}//mvRecommendCalss
*/	
}//class

