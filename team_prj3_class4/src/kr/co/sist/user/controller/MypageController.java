package kr.co.sist.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.user.domain.ClassList;
import kr.co.sist.user.service.UserMypageService;
import kr.co.sist.user.vo.ListVO;

@Controller
public class MypageController {
	@Autowired(required=false)
	private UserMypageService ums;
	
	@RequestMapping(value="user/student/mypage_list.do",method=GET)
	public String indexPage( Model model ,  HttpSession session) {
		
		String clientId = session.getAttribute("client_id").toString();
		
		ListVO lvo=new ListVO("", clientId);
		List<List<ClassList>> classList=new ArrayList<List<ClassList>>();
		List<String> lcodeList=null;
		lcodeList=ums.lcodeList(clientId);
		
		for(int i=0; i<lcodeList.size(); i++) {
			lvo.setLcode(lcodeList.get(i));
			classList.add(ums.classList(lvo));
		}//end for
		
		model.addAttribute("classList", classList);
		
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
