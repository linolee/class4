package kr.co.sist.user.vo;

public class LoptVO {
	private String opt, lcode;
	
	@Override
	public String toString() {
		return "LoptVO [opt=" + opt + ", lcode=" + lcode + "]";
	}

	public LoptVO(String opt, String lcode) {
		this.opt = opt;
		this.lcode = lcode;
	}

	public String getOpt() {
		return opt;
	}

	public void setOpt(String opt) {
		this.opt = opt;
	}

	public String getLcode() {
		return lcode;
	}

	public void setLcode(String lcode) {
		this.lcode = lcode;
	}
	
	
}
