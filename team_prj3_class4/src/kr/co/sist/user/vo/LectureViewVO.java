package kr.co.sist.user.vo;

public class LectureViewVO {

	private String name, startDate, endDate;
	private int minPeople, maxPeople, status;
	
	public LectureViewVO(String name, String startDate, String endDate, int minPeople, int maxPeople, int status) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.minPeople = minPeople;
		this.maxPeople = maxPeople;
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getMinPeople() {
		return minPeople;
	}
	public void setMinPeople(int minPeople) {
		this.minPeople = minPeople;
	}
	public int getMaxPeople() {
		return maxPeople;
	}
	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
} // class
