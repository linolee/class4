package kr.co.sist.user.domain;

public class DeletedUser {
	private String client_id, d_date;

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getD_date() {
		return d_date;
	}

	public void setD_date(String d_date) {
		this.d_date = d_date;
	}

	@Override
	public String toString() {
		return "DeletedUser [client_id=" + client_id + ", d_date=" + d_date + "]";
	}

}
