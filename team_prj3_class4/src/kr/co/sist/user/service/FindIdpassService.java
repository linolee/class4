package kr.co.sist.user.service;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import kr.co.sist.user.dao.FindIdpassDAO;
import kr.co.sist.user.vo.FindIdVO;
import kr.co.sist.user.vo.FindPassVO;
import kr.co.sist.user.vo.UpdatePassVO;

@Component
public class FindIdpassService {

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private FindIdpassDAO f_dao;

	public String searchId(FindIdVO fivo) {
		String id = "";
		id = f_dao.selectFindId(fivo);

		return id;
	}

	public boolean searchPass(HttpServletRequest request, FindPassVO fpvo) {
		boolean flag = false;
		String pass = "";

		pass = f_dao.selectFindPass(fpvo);

		if (pass != null) {
			pass = getRamdomPassword(16);
			
			//System.out.println("===========pass : " + pass);
			
			String setfrom = "coding11202@gmail.com";
			String tomail = fpvo.getEmail();
			String title = "[취미생활 공유 플랫폼 클래스 4] 임시 비밀번호 발송 입니다.";
			String content = "안녕하십니까 ? \n취미생활 공유 플랫폼 클래스 4 입니다.\n고객님께서 가입하신 메일로 임시 비밀번호 발송해 드렸습니다.\n임시 비밀번호 : " + pass;
			content += "\n\n보내드린 비밀번호로 로그인 후 회원정보 > 회원정보 수정에서 비밀번호를 수정하시기 바랍니다.\n감사합니다.";

			try {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				messageHelper.setFrom(setfrom); // 보내는사람 생략하거나 하면 정상작동을 안함
				messageHelper.setTo(tomail); // 받는사람 이메일
				messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
				messageHelper.setText(content); // 메일 내용

				UpdatePassVO upvo = new UpdatePassVO(pass, fpvo.getId());
				f_dao.updateFindPass(upvo);//임시 비밀번호 변경 적용
				
				mailSender.send(message);//메일 발송
				flag = true;
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return flag;
	}

	public static String getRamdomPassword(int len) {
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '!',
				'@', '#', '$', '*', '^', '?' };
		int idx = 0;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < len; i++) {
			idx = (int) (charSet.length * Math.random()); //
			sb.append(charSet[idx]);
		}
		return sb.toString();
	}

}
