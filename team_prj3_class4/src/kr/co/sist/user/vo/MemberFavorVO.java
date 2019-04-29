package kr.co.sist.user.vo;

public class MemberFavorVO {
	private String client_id, favor;

	public String getClient_id() {
		return client_id;
	}

	public String getFavor() {
		return favor;
	}

	public MemberFavorVO(String client_id, String favor) {
		super();
		this.client_id = client_id;
		this.favor = favor;
	}

	@Override
	public String toString() {
		return "MemberFavorVO [client_id=" + client_id + ", favor=" + favor + "]";
	}

}
