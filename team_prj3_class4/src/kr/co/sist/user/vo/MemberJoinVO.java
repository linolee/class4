package kr.co.sist.user.vo;

import java.util.Arrays;

public class MemberJoinVO {
	private String client_id, pass, name, birth, gender, email, status, tel;
	private String[] favors;

	public MemberJoinVO(String client_id, String pass, String name, String birth, String gender, String email,
			String status, String tel, String[] favors) {
		super();
		this.client_id = client_id;
		this.pass = pass;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.email = email;
		this.status = status;
		this.tel = tel;
		this.favors = favors;
	}

	public String getClient_id() {
		return client_id;
	}

	public String getPass() {
		return pass;
	}

	public String getName() {
		return name;
	}

	public String getBirth() {
		return birth;
	}

	public String getGender() {
		return gender;
	}

	public String getEmail() {
		return email;
	}

	public String getStatus() {
		return status;
	}

	public String getTel() {
		return tel;
	}

	public String[] getFavors() {
		return favors;
	}

	@Override
	public String toString() {
		return "MemberJoinVO [client_id=" + client_id + ", pass=" + pass + ", name=" + name + ", birth=" + birth
				+ ", gender=" + gender + ", email=" + email + ", status=" + status + ", tel=" + tel + ", favors="
				+ Arrays.toString(favors) + "]";
	}

}
