package kr.co.sist.user.domain;

public class AdminQnA {
	private String qcode, q_subject, q_contents, a_contents, q_date, a_date;
	
	@Override
	public String toString() {
		return "AdminQnA [qcode=" + qcode + ", q_subject=" + q_subject + ", q_contents=" + q_contents + ", a_contents="
				+ a_contents + ", q_date=" + q_date + ", a_date=" + a_date + "]";
	}

	public String getQcode() {
		return qcode;
	}

	public void setQcode(String qcode) {
		this.qcode = qcode;
	}

	public String getQ_subject() {
		return q_subject;
	}

	public void setQ_subject(String q_subject) {
		this.q_subject = q_subject;
	}

	public String getQ_contents() {
		return q_contents;
	}

	public void setQ_contents(String q_contents) {
		this.q_contents = q_contents;
	}

	public String getA_contents() {
		return a_contents;
	}

	public void setA_contents(String a_contents) {
		this.a_contents = a_contents;
	}

	public String getQ_date() {
		return q_date;
	}

	public void setQ_date(String q_date) {
		this.q_date = q_date;
	}

	public String getA_date() {
		return a_date;
	}

	public void setA_date(String a_date) {
		this.a_date = a_date;
	}
	
}
