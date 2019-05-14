package kr.co.sist.user.vo;

public class UpdatePassVO {
	private String pass, id;
	
	public UpdatePassVO(String pass, String id) {
		super();
		this.pass = pass;
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
