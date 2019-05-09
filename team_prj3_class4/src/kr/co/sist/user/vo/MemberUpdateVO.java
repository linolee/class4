package kr.co.sist.user.vo;

public class MemberUpdateVO {
	private String client_id, email, tel;

	public MemberUpdateVO(String client_id, String email, String tel) {
		super();
		this.client_id = client_id;
		this.email = email;
		this.tel = tel;
	}

	public String getClient_id() {
		return client_id;
	}

	public String getEmail() {
		return email;
	}

	public String getTel() {
		return tel;
	}

	@Override
	public String toString() {
		return "MemberUpdateVO [client_id=" + client_id + ", email=" + email + ", tel=" + tel + "]";
	}

}
