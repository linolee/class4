package kr.co.sist.user.domain;

public class LoginDomain {
	private String client_id, name, status;

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserLoginService [client_id=" + client_id + ", name=" + name + ", status=" + status + "]";
	}

	

	
}
