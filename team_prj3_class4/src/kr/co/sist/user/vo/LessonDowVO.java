package kr.co.sist.user.vo;

public class LessonDowVO {
	private String lcode, dow;

	
	@Override
	public String toString() {
		return "LessonDowVO [lcode=" + lcode + ", dow=" + dow + "]";
	}

	public LessonDowVO(String lcode, String dow) {
		this.lcode = lcode;
		this.dow = dow;
	}

	public String getLcode() {
		return lcode;
	}

	public void setLcode(String lcode) {
		this.lcode = lcode;
	}

	public String getDow() {
		return dow;
	}

	public void setDow(String dow) {
		this.dow = dow;
	}
	
	
}
