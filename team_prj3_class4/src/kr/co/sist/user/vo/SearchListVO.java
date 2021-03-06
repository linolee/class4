package kr.co.sist.user.vo;

public class SearchListVO {
	private int startNum, endNum, currentPage;
	private String keyword;
	
	public SearchListVO() {
	}
	
	public SearchListVO(int startNum, int endNum, int currentPage, String keyword) {
		super();
		this.startNum = startNum;
		this.endNum = endNum;
		this.currentPage = currentPage;
		this.keyword = keyword;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
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
