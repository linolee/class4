package kr.co.sist.admin.vo;

public class StatsVO {
	private int totalTeacher, totalLecture, ingLecture, totalCategory, totalClient, todayClient,
	monthClient, exitClient;

	public int getTotalTeacher() {
		return totalTeacher;
	}

	public void setTotalTeacher(int totalTeacher) {
		this.totalTeacher = totalTeacher;
	}

	public int getTotalLecture() {
		return totalLecture;
	}

	public void setTotalLecture(int totalLecture) {
		this.totalLecture = totalLecture;
	}

	public int getIngLecture() {
		return ingLecture;
	}

	public void setIngLecture(int ingLecture) {
		this.ingLecture = ingLecture;
	}

	public int getTotalCategory() {
		return totalCategory;
	}

	public void setTotalCategory(int totalCategory) {
		this.totalCategory = totalCategory;
	}

	public int getTotalClient() {
		return totalClient;
	}

	public void setTotalClient(int totalClient) {
		this.totalClient = totalClient;
	}

	public int getTodayClient() {
		return todayClient;
	}

	public void setTodayClient(int todayClient) {
		this.todayClient = todayClient;
	}

	public int getMonthClient() {
		return monthClient;
	}

	public void setMonthClient(int monthClient) {
		this.monthClient = monthClient;
	}

	public int getExitClient() {
		return exitClient;
	}

	public void setExitClient(int exitClient) {
		this.exitClient = exitClient;
	}
	
}
