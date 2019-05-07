package kr.co.sist.user.vo;

public class ReviewVO {
	private String clientId, lcode, contents;
	private int score;
	public ReviewVO(String clientId, String lcode, String contents, int score) {
		this.clientId = clientId;
		this.lcode = lcode;
		this.contents = contents;
		this.score = score;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
