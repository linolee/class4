package kr.co.sist.admin.service;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.dao.AdminLoginDAO;

@Component
public class MailService {
	
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private AdminLoginDAO al_dao;
	
	// 아이디로 메일주소 찾기
	public JSONObject findEaddress(String id) {
		String email=al_dao.findEaddress(id);
		JSONObject json=new JSONObject();
		if(null!=email) {
			json.put("email", email);
		}
		return json;
	}
	
	public void sendEmail(HttpServletRequest request, String email, String emailTitle, String emailContent) {
		
		String setfrom="coding11202@gmail.com";         
	    String tomail=email;
	    String title=emailTitle;
	    String content=emailContent;
	   
	    try {
	      MimeMessage message = mailSender.createMimeMessage();
	      MimeMessageHelper messageHelper 
	                        = new MimeMessageHelper(message, true, "UTF-8");
	      messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
	      messageHelper.setTo(tomail);     // 받는사람 이메일
	      messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
	      messageHelper.setText(content);  // 메일 내용
	     
	      mailSender.send(message);
	    } catch(Exception e){
	      System.out.println(e);
	    }
	
	}
}
