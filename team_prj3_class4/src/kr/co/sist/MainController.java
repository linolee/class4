package kr.co.sist;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.user.domain.Category;
import kr.co.sist.user.domain.LatestReview;
import kr.co.sist.user.domain.Recommend;
import kr.co.sist.user.service.mainContentsService;


@Controller
public class MainController {
		
	@RequestMapping(value="/user/mainContents/mainContents.do", method = GET)
	public String showContentsForm(Model model) {
		List<String> categoryList=null;
		List<Category> imgCate=null;
		List<Category> imgCate1=null;
		List<Category> imgCate2=null;
		List<Category> imgCate3=null;
		List<Recommend> recommend1=null;
		List<Recommend> recommend2=null;
		List<Recommend> recommend3=null;
		List<LatestReview> latestreview1=null;
		List<LatestReview> latestreview2=null;
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/ApplicationContextMainC.xml");
		mainContentsService mcs=ac.getBean(mainContentsService.class);
		categoryList=mcs.showMenuCategory();
		imgCate=mcs.searchImgCategory();
		imgCate1=mcs.searchImgCategory1();
		imgCate2=mcs.searchImgCategory2();
		imgCate3=mcs.searchImgCategory3();
		recommend1=mcs.selectRecommend1();
		recommend2=mcs.selectRecommend2();
		recommend3=mcs.selectRecommend3();
		latestreview1=mcs.selectLatestReview1();
		latestreview2=mcs.selectLatestReview2();
		
		model.addAttribute("clist",categoryList);
		model.addAttribute("imgCate",imgCate);
		model.addAttribute("imgCate1",imgCate1);
		model.addAttribute("imgCate2",imgCate2);
		model.addAttribute("imgCate3",imgCate3);
		model.addAttribute("recommend1",recommend1);
		model.addAttribute("recommend2",recommend2);
		model.addAttribute("recommend3",recommend3);
		model.addAttribute("latestreview1",latestreview1);
		model.addAttribute("latestreview2",latestreview2);
		
		return "user/mainContents/mainContents";
	}//showContentsForm
	/*의존성 주입 AdminController.java*/
	
	/*@RequestMapping(value="/user/searchClass.do", method=GET)
	public String mvCategoryPage(String category, Model model) {
		return "";
	}//mvCategoryPage
	
	@RequestMapping(value="/user/recommend.do", method=GET)
	public String mvRecommendCalss(Model model) {
		return "";
	}//mvRecommendCalss
	*/
}//class

