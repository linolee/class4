package kr.co.sist.admin.domain;

public class MemberListDomain {
	private String client_id, name, birth, gender, email;

	public MemberListDomain(String client_id, String name, String birth, String gender, String email) {
		this.client_id = client_id;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.email = email;
	}

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

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
