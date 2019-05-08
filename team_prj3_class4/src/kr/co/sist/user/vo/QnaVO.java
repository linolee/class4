package kr.co.sist.user.vo;

public class QnaVO {
	private String lcode, clientId, subject, contents;

	public QnaVO(String lcode, String clientId, String subject, String contents) {
		this.lcode = lcode;
		this.clientId = clientId;
		this.subject = subject;
		this.contents = contents;
	}

	public String getLcode() {
		return lcode;
	}

	public void setLcode(String lcode) {
		this.lcode = lcode;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
}
