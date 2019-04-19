package kr.co.sist;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	@RequestMapping(value="/main.do",method=GET)
	public String mainPage() {
		
		return "main";
	}//mainPage
	
	@RequestMapping(value="/login.do",method=GET)
	public String loginPage() {
		
		return "user/login";
	}//loginPage
	@RequestMapping(value="/findID.do",method=GET)
	public String findIDPage() {
		
		return "user/findID";
	}//findIDPage
	@RequestMapping(value="/findPass.do",method=GET)
	public String findPassPage() {
		
		return "user/findPass";
	}//findPassPage
	
	@RequestMapping(value="/join.do",method=GET)
	public String joinPage() {
		
		return "user/join";
	}//joinPage

	@RequestMapping(value="/userPage.do",method=GET)
	public String userPage() {
		
		return "user/userPage";
	}//userPage
	
	@RequestMapping(value="/report.do",method=GET)
	public String reportPage() {
		
		return "user/report";
	}//reportPage

	@RequestMapping(value="/terms.do",method=GET)
	public String termsPage() {
		
		return "terms/terms";
	}//termsPage
	
}
