package kr.co.sist.user.domain;

public class Question {

	private String lname, qcode, status, name, subject, qDate, aDate, teacherName, lcode, contents, clientId, aContents;
	private int num;
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getQcode() {
		return qcode;
	}
	public void setQcode(String qcode) {
		this.qcode = qcode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getqDate() {
		return qDate;
	}
	public void setqDate(String qDate) {
		this.qDate = qDate;
	}
	public String getaDate() {
		return aDate;
	}
	public void setaDate(String aDate) {
		this.aDate = aDate;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getLcode() {
		return lcode;
	}
	public void setLcode(String lcode) {
		this.lcode = lcode;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getaContents() {
		return aContents;
	}
	public void setaContents(String aContents) {
		this.aContents = aContents;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "Question [lname=" + lname + ", qcode=" + qcode + ", status=" + status + ", name=" + name + ", subject="
				+ subject + ", qDate=" + qDate + ", aDate=" + aDate + ", teacherName=" + teacherName + ", lcode="
				+ lcode + ", contents=" + contents + ", clientId=" + clientId + ", aContents=" + aContents + ", num="
				+ num + "]";
	}

} // class
