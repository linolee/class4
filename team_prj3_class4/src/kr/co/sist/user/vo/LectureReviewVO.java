package kr.co.sist.user.vo;

public class LectureReviewVO {

	private String LectureName, title, writer, hiredate;
	private int num;
	
	public LectureReviewVO(String lectureName, String title, String writer, String hiredate, int num) {
		super();
		LectureName = lectureName;
		this.title = title;
		this.writer = writer;
		this.hiredate = hiredate;
		this.num = num;
	}
	public String getLectureName() {
		return LectureName;
	}
	public void setLectureName(String lectureName) {
		LectureName = lectureName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
	
} // class
