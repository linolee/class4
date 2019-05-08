package kr.co.sist.user.domain;

public class StatusCnt {

	private int num;
	private String status;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "StatusCnt [num=" + num + ", status=" + status + "]";
	}
	
} // class
