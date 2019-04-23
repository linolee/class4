package kr.co.sist.user.controller.header;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class UserLoginController {
	@RequestMapping(value="user/member/login.do",method=POST)
	public String login() {
		System.out.println("로그인 메소드 실행");
		return "main";
	}//loginPage
}
