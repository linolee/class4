package kr.co.sist.user.domain;

import java.sql.Date;

public class QnA {
	private String qcode,id,title,status;
	private Date inputdate;
	
	public String getQcode() {
		return qcode;
	}
	public void setQcode(String qcode) {
		this.qcode = qcode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getInputdate() {
		return inputdate;
	}
	public void setInputdate(Date inputdate) {
		this.inputdate = inputdate;
	}
	
}
