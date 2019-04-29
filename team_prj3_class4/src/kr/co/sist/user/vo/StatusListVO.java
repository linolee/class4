package kr.co.sist.user.vo;

public class StatusListVO {
	private String lcode, clientId, pageStatus;

	public StatusListVO(String lcode, String clientId, String pageStatus) {
		this.lcode = lcode;
		this.clientId = clientId;
		this.pageStatus = pageStatus;
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

	public String getpageStatus() {
		return pageStatus;
	}

	public void setpageStatus(String pageStatus) {
		this.pageStatus = pageStatus;
	}
}
