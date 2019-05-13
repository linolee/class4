package kr.co.sist.user.vo;

public class ClassRegistVO {
	private String teacher_name, category, inner_category, lname, lintro, 
	contents, curriculum, others, main_img, banner_img,
	start_date, end_date, due_date, address, address2, together;
	
	private int start_time, end_time, max_member, min_member;

	
	
	@Override
	public String toString() {
		return "ClassRegistVO [teacher_name=" + teacher_name + ", category=" + category + ", inner_category="
				+ inner_category + ", lname=" + lname + ", lintro=" + lintro + ", contents=" + contents
				+ ", curriculum=" + curriculum + ", others=" + others + ", main_img=" + main_img + ", banner_img="
				+ banner_img + ", start_date=" + start_date + ", end_date=" + end_date + ", due_date=" + due_date
				+ ", address=" + address + ", address2=" + address2 + ", together=" + together + ", start_time="
				+ start_time + ", end_time=" + end_time + ", max_member=" + max_member + ", min_member=" + min_member
				+ "]";
	}

	public ClassRegistVO(String teacher_name, String category, String inner_category, String lname, String lintro,
			String contents, String curriculum, String others, String main_img, String banner_img, String start_date,
			String end_date, String due_date, String address, String address2, String together, int start_time,
			int end_time, int max_member, int min_member) {
		super();
		this.teacher_name = teacher_name;
		this.category = category;
		this.inner_category = inner_category;
		this.lname = lname;
		this.lintro = lintro;
		this.contents = contents;
		this.curriculum = curriculum;
		this.others = others;
		this.main_img = main_img;
		this.banner_img = banner_img;
		this.start_date = start_date;
		this.end_date = end_date;
		this.due_date = due_date;
		this.address = address;
		this.address2 = address2;
		this.together = together;
		this.start_time = start_time;
		this.end_time = end_time;
		this.max_member = max_member;
		this.min_member = min_member;
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

	public String getLintro() {
		return lintro;
	}

	public void setLintro(String lintro) {
		this.lintro = lintro;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public String getMain_img() {
		return main_img;
	}

	public void setMain_img(String main_img) {
		this.main_img = main_img;
	}

	public String getBanner_img() {
		return banner_img;
	}

	public void setBanner_img(String banner_img) {
		this.banner_img = banner_img;
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

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getTogether() {
		return together;
	}

	public void setTogether(String together) {
		this.together = together;
	}

	public int getStart_time() {
		return start_time;
	}

	public void setStart_time(int start_time) {
		this.start_time = start_time;
	}

	public int getEnd_time() {
		return end_time;
	}

	public void setEnd_time(int end_time) {
		this.end_time = end_time;
	}

	public int getMax_member() {
		return max_member;
	}

	public void setMax_member(int max_member) {
		this.max_member = max_member;
	}

	public int getMin_member() {
		return min_member;
	}

	public void setMin_member(int min_member) {
		this.min_member = min_member;
	}
	
	
}
