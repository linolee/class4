package kr.co.sist.user.vo;

public class memberReportVO {
	private String client_id, q_subject, q_contents;

	public memberReportVO(String client_id, String q_subject, String q_contents) {
		super();
		this.client_id = client_id;
		this.q_subject = q_subject;
		this.q_contents = q_contents;
	}

	public String getClient_id() {
		return client_id;
	}

	public String getQ_subject() {
		return q_subject;
	}

	public String getQ_contents() {
		return q_contents;
	}

	@Override
	public String toString() {
		return "memberReportVO [client_id=" + client_id + ", q_subject=" + q_subject + ", q_contents=" + q_contents
				+ "]";
	}

}
