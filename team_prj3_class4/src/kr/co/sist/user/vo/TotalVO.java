package kr.co.sist.user.vo;

public class TotalVO {
	private String clientId,status;

	
	public TotalVO(String clientId, String status) {
		this.clientId = clientId;
		this.status = status;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
