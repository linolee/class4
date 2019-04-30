package kr.co.sist.admin.vo;
public class AddBlackVO {
	public String client_id, reason, sysdate;

	public AddBlackVO(String client_id, String reason, String sysdate) {
		this.client_id = client_id;
		this.reason = reason;
		this.sysdate = sysdate;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSysdate() {
		return sysdate;
	}

	public void setSysdate(String sysdate) {
		this.sysdate = sysdate;
	}
	
}
