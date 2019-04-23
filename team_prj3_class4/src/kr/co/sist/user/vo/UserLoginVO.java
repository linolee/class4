package kr.co.sist.user.vo;

public class UserLoginVO {
	private String Id, pass;

	public UserLoginVO(String id, String pass) {
		super();
		Id = id;
		this.pass = pass;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "UserLoginVO [Id=" + Id + ", pass=" + pass + "]";
	}

	
}
