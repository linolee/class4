package kr.co.sist.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.user.service.UserMypageService;
import kr.co.sist.user.vo.ListVO;

@Controller
public class MypageController {
	@Autowired(required=false)
	private UserMypageService ums;
	
	@RequestMapping(value="user/student/mypage_list.do",method=GET)
	public String indexPage( Model model ) {
		
		ListVO lvo=new ListVO("1", "test");
		model.addAttribute("classList", ums.classList(lvo));
		
		return "user/student/mypage_list";
	}//indexPage
	
	@RequestMapping(value="user/student/mypage_assess.do", method=GET)
	public String mypageAssess() {
		return "user/student/mypage_assess";
	}//useRequest
	@RequestMapping(value="user/student/mypage_jjim.do", method=GET)
	public String mypageJjim() {
		return "user/student/mypage_jjim";
	}//useRequest
	@RequestMapping(value="user/student/mypage_cancel.do", method=GET)
	public String mypageCancel() {
		return "user/student/mypage_cancel";
	}//useRequest
	@RequestMapping(value="user/student/mypage_q&a.do", method=GET)
	public String mypageQA() {
		return "user/student/mypage_q&a";
	}//useRequest
	@RequestMapping(value="user/student/mypage_report.do", method=GET)
	public String mypageReport() {
		return "user/student/mypage_report";
	}//useRequest
}
