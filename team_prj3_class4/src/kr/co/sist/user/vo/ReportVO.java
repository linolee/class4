package kr.co.sist.user.vo;

public class ReportVO {
	private String clientId, lcode, subject, contents;
	private int reportType;
	public ReportVO(String clientId, String lcode, String subject, String contents, int reportType) {
		this.clientId = clientId;
		this.lcode = lcode;
		this.subject = subject;
		this.contents = contents;
		this.reportType = reportType;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getReportType() {
		return reportType;
	}
	public void setReportType(int reportType) {
		this.reportType = reportType;
	}

}//class
