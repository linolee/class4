package kr.co.sist.admin.vo;

public class AddInnerCategory {
	private String category, innerCategory;
	
	public AddInnerCategory(String category, String innerCategory) {
		this.category = category;
		this.innerCategory = innerCategory;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getInnerCategory() {
		return innerCategory;
	}

	public void setInnerCategory(String innerCategory) {
		this.innerCategory = innerCategory;
	}
	
}
