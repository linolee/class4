package kr.co.sist.user.vo;

public class qnaListVO {
	private String qcode, lcode, clientId;

	public qnaListVO(String qcode, String lcode, String clientId) {
		this.qcode = qcode;
		this.lcode = lcode;
		this.clientId = clientId;
	}

	public String getQcode() {
		return qcode;
	}

	public void setQcode(String qcode) {
		this.qcode = qcode;
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
	
}
