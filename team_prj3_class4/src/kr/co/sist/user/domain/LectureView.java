package kr.co.sist.user.domain;

public class LectureView {

	private String lname, status, startDate, endDate, lcode, teacherName;
	private int maxMember, nowMember;
	
	
	public int getNowMember() {
		return nowMember;
	}
	public void setNowMember(int nowMember) {
		this.nowMember = nowMember;
	}
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
	public int getMaxMember() {
		return maxMember;
	}
	public void setMaxMember(int maxMember) {
		this.maxMember = maxMember;
	}
	@Override
	public String toString() {
		return "LectureView [lname=" + lname + ", status=" + status + ", startDate=" + startDate + ", endDate="
				+ endDate + ", lcode=" + lcode + ", teacherName=" + teacherName + ", maxMember=" + maxMember + "]";
	}
	
	
	
} //class
