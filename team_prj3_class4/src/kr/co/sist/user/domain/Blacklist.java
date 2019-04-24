package kr.co.sist.user.domain;

public class Blacklist {
	private String client_id, reason, b_date;

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

	public String getB_date() {
		return b_date;
	}

	public void setB_date(String b_date) {
		this.b_date = b_date;
	}

	@Override
	public String toString() {
		return "Blacklist [client_id=" + client_id + ", reason=" + reason + ", b_date=" + b_date + "]";
	}

	
}
