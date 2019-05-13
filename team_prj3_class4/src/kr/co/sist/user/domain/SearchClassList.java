package kr.co.sist.user.domain;

public class SearchClassList {
	private String lcode, teacher_name, category, inner_category, lname, status, start_date, end_date, main_img;
	private int max_member, cur_member;
	
	public int getMax_member() {
		return max_member;
	}

	public void setMax_member(int max_member) {
		this.max_member = max_member;
	}

	public int getCur_member() {
		return cur_member;
	}

	public void setCur_member(int cur_member) {
		this.cur_member = cur_member;
	}

	public String getMain_img() {
		return main_img;
	}

	public void setMain_img(String main_img) {
		this.main_img = main_img;
	}

	public String getLcode() {
		return lcode;
	}

	public void setLcode(String lcode) {
		this.lcode = lcode;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getInner_category() {
		return inner_category;
	}

	public void setInner_category(String inner_category) {
		this.inner_category = inner_category;
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

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	
	
}
