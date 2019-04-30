package kr.co.sist.user.domain;

public class QnA {
	private String memberId,title,Qcode;

	public String getQcode() {
		return Qcode;
	}
	public void setQcode(String qcode) {
		Qcode = qcode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
