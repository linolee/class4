package kr.co.sist.user.domain;

public class LectureView {

	private String lname, status, startDate, endDate, lcode, teacherName, tel, name, clientId;
	private int maxMember, nowMember;
	
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getLcode() {
		return lcode;
	}
	public void setLcode(String lcode) {
		this.lcode = lcode;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public int getMaxMember() {
		return maxMember;
	}
	public void setMaxMember(int maxMember) {
		this.maxMember = maxMember;
	}
	public int getNowMember() {
		return nowMember;
	}
	public void setNowMember(int nowMember) {
		this.nowMember = nowMember;
	}
	@Override
	public String toString() {
		return "LectureView [lname=" + lname + ", status=" + status + ", startDate=" + startDate + ", endDate="
				+ endDate + ", lcode=" + lcode + ", teacherName=" + teacherName + ", tel=" + tel + ", name=" + name
				+ ", clientId=" + clientId + ", maxMember=" + maxMember + ", nowMember=" + nowMember + "]";
	}

} //class
