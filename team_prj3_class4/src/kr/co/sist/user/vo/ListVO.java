package kr.co.sist.user.vo;

public class ListVO {
	private String lcode, clientId;

	public ListVO() {
	}

	public ListVO(String lcode, String clientId) {
		this.lcode = lcode;
		this.clientId = clientId;
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
