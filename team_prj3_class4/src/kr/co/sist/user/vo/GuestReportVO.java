package kr.co.sist.user.vo;

public class GuestReportVO {
	private String guest_email, q_subject, q_contents;

	public GuestReportVO(String guest_email, String q_subject, String q_contents) {
		super();
		this.guest_email = guest_email;
		this.q_subject = q_subject;
		this.q_contents = q_contents;
	}

	public String getGuest_email() {
		return guest_email;
	}

	public String getQ_subject() {
		return q_subject;
	}

	public String getQ_contents() {
		return q_contents;
	}

	@Override
	public String toString() {
		return "GuestReportVO [guest_email=" + guest_email + ", q_subject=" + q_subject + ", q_contents=" + q_contents
				+ "]";
	}
	
	
}
