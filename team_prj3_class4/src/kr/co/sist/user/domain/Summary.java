package kr.co.sist.user.domain;

public class Summary {
	private String banner_img,lname,lintro,teacher_name,address,img;
	private int max_member, class_time;
	public String getBanner_img() {
		return banner_img;
	}
	public void setBanner_img(String banner_img) {
		this.banner_img = banner_img;
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
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getMax_member() {
		return max_member;
	}
	public void setMax_member(int max_member) {
		this.max_member = max_member;
	}
	public int getClass_time() {
		return class_time;
	}
	public void setClass_time(int class_time) {
		this.class_time = class_time;
	}
	@Override
	public String toString() {
		return "Summary [banner_img=" + banner_img + ", lname=" + lname + ", lintro=" + lintro + ", teacher_name="
				+ teacher_name + ", address=" + address + ", img=" + img + ", max_member=" + max_member
				+ ", class_time=" + class_time + "]";
	}
	
	
}
