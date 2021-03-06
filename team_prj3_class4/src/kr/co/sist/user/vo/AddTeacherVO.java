package kr.co.sist.user.vo;

public class AddTeacherVO {
	private String teacherName, clientId, category, introduce, status, img;

	
	public AddTeacherVO() {
		super();
	}

	public AddTeacherVO(String teacherName, String clientId, String category, String introduce, String status,
			String img) {
		super();
		this.teacherName = teacherName;
		this.clientId = clientId;
		this.category = category;
		this.introduce = introduce;
		this.status = status;
		this.img = img;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "AddTeacherVO [teacherName=" + teacherName + ", clientId=" + clientId + ", category=" + category
				+ ", introduce=" + introduce + ", status=" + status + ", img=" + img + "]";
	}
	
}
