package kr.co.sist.admin.vo;

public class AdminLoginVO {
	private String adminId, pass;

	public AdminLoginVO(String adminId, String pass) {
		this.adminId = adminId;
		this.pass = pass;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}


	
}
