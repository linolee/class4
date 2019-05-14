package kr.co.sist.user.domain;

import java.sql.Date;

public class ClassTime {
	private Date start_date,end_date;
	private int start_time, end_time, start_time2, end_time2;
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public int getStart_time() {
		return start_time;
	}
	public void setStart_time(int start_time) {
		this.start_time = start_time;
	}
	public int getEnd_time() {
		return end_time;
	}
	public void setEnd_time(int end_time) {
		this.end_time = end_time;
	}
	public int getStart_time2() {
		return start_time2;
	}
	public void setStart_time2(int start_time2) {
		this.start_time2 = start_time2;
	}
	public int getEnd_time2() {
		return end_time2;
	}
	public void setEnd_time2(int end_time2) {
		this.end_time2 = end_time2;
	}
	
 }