package kr.co.sist.user.domain;

import java.sql.Date;

public class ClassTime {
	private Date date;
	private String startTime, endTime;
	private int newPersonal, maxPersonal;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getNewPersonal() {
		return newPersonal;
	}
	public void setNewPersonal(int newPersonal) {
		this.newPersonal = newPersonal;
	}
	public int getMaxPersonal() {
		return maxPersonal;
	}
	public void setMaxPersonal(int maxPersonal) {
		this.maxPersonal = maxPersonal;
	}
}
