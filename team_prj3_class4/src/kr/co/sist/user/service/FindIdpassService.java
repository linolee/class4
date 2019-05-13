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
			String title = "[��̻�Ȱ ���� �÷��� Ŭ���� 4] �ӽ� ��й�ȣ �߼� �Դϴ�.";
			String content = "�ȳ��Ͻʴϱ� ? \n��̻�Ȱ ���� �÷��� Ŭ���� 4 �Դϴ�.\n���Բ��� �����Ͻ� ���Ϸ� �ӽ� ��й�ȣ �߼��� ��Ƚ��ϴ�.\n�ӽ� ��й�ȣ : " + pass;
			content += "\n\n�����帰 ��й�ȣ�� �α��� �� ȸ������ > ȸ������ �������� ��й�ȣ�� �����Ͻñ� �ٶ��ϴ�.\n�����մϴ�.";

			try {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				messageHelper.setFrom(setfrom); // �����»�� �����ϰų� �ϸ� �����۵��� ����
				messageHelper.setTo(tomail); // �޴»�� �̸���
				messageHelper.setSubject(title); // ���������� ������ �����ϴ�
				messageHelper.setText(content); // ���� ����

				UpdatePassVO upvo = new UpdatePassVO(pass, fpvo.getId());
				f_dao.updateFindPass(upvo);//�ӽ� ��й�ȣ ���� ����
				
				mailSender.send(message);//���� �߼�
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
