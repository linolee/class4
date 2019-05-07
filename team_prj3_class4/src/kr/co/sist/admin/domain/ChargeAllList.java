package kr.co.sist.admin.domain;

public class ChargeAllList {
	private String lcode, lname, teacher_name, status;
	private int all_report, apply_report;
	public String getLcode() {
		return lcode;
	}
	public void setLcode(String lcode) {
		this.lcode = lcode;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getAll_report() {
		return all_report;
	}
	public void setAll_report(int all_report) {
		this.all_report = all_report;
	}
	public int getApply_report() {
		return apply_report;
	}
	public void setApply_report(int apply_report) {
		this.apply_report = apply_report;
	}
	
}
