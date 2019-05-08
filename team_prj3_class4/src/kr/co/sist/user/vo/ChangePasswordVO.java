package kr.co.sist.user.vo;

public class ChangePasswordVO {
	private String client_id, password;

	@Override
	public String toString() {
		return "ChangePasswordVO [client_id=" + client_id + ", password=" + password + "]";
	}

	public ChangePasswordVO(String client_id, String password) {
		super();
		this.client_id = client_id;
		this.password = password;
	}

	public String getClient_id() {
		return client_id;
	}

	public String getPassword() {
		return password;
	}
	
	
}
