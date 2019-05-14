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
	
	// ���̵�� �����ּ� ã��
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
	      messageHelper.setFrom(setfrom);  // �����»�� �����ϰų� �ϸ� �����۵��� ����
	      messageHelper.setTo(tomail);     // �޴»�� �̸���
	      messageHelper.setSubject(title); // ���������� ������ �����ϴ�
	      messageHelper.setText(content);  // ���� ����
	     
	      mailSender.send(message);
	    } catch(Exception e){
	      System.out.println(e);
	    }
	
	}
}
