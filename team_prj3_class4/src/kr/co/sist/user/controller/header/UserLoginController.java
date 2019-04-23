package kr.co.sist.user.controller.header;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.user.service.UserLoginService;
import kr.co.sist.user.vo.UserLoginVO;
@Controller
public class UserLoginController {
	@RequestMapping(value="user/member/login.do",method=POST)
	public String login(HttpServletRequest request, HttpServletResponse response) {
		//입력받은 id와 pass로 vo를 생성
		UserLoginVO ulvo = new UserLoginVO(request.getParameter("id"), request.getParameter("pass"));
		System.out.println(ulvo);
	
		//생성된 vo로 login method를 실행
		UserLoginService uls = new UserLoginService();
		System.out.println(uls.login(ulvo));
		return "main";
	}//loginPage
}
