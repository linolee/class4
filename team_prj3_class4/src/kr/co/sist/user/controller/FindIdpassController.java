package kr.co.sist.user.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.user.service.FindIdpassService;
import kr.co.sist.user.vo.FindIdVO;
import kr.co.sist.user.vo.FindPassVO;

@Controller
public class FindIdpassController {
	@Autowired
	private FindIdpassService fis;
	
	@RequestMapping(value = "user/member/findID.do", method = GET)
	public String findIDPage() {

		return "user/member/findID2";////
	}// findIDPage

	//id 찾기 결과
	@RequestMapping(value = "user/member/findIDResult.do", method = POST)
	public String findIDResultPage(HttpServletRequest request, Model m) {
		FindIdVO fivo = new FindIdVO(request.getParameter("name"), request.getParameter("email"));
		String id = fis.searchId(fivo);
		
		m.addAttribute("id", id);
		m.addAttribute("name", fivo.getName());
		m.addAttribute("email", fivo.getEmail());
		
		return "user/member/findIDResult";//
	}// findIDPage

	@RequestMapping(value = "user/member/findPass.do", method = GET)
	public String findPassPage() {

		return "user/member/findPass2";
	}// findPassPage
	
	//비밀번호 찾기 결과
	@RequestMapping(value = "user/member/findPassResult.do", method = POST)
	public String findPassResultPage(HttpServletRequest request, Model m) {
		FindPassVO fpvo = new FindPassVO(request.getParameter("id"), request.getParameter("name"), request.getParameter("email"));
		boolean flag = fis.searchPass(request, fpvo);
		
		//System.out.println("pass : " + flag);
		
		m.addAttribute("flag", flag);
		m.addAttribute("email", fpvo.getEmail());
		
		return "user/member/findPassResult";//
	}// findIDPage
}
