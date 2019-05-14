package kr.co.sist.user.vo;

public class ReviewListVO {
	private int startNum, endNum, currentPage;
	private String lcode;
	
	public ReviewListVO() {
	}
	
	public ReviewListVO(int startNum, int endNum, int currentPage, String lcode) {
		super();
		this.startNum = startNum;
		this.endNum = endNum;
		this.currentPage = currentPage;
		this.lcode = lcode;
	}

	public String getLcode() {
		return lcode;
	}

	public void setLcode(String lcode) {
		this.lcode = lcode;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
}
