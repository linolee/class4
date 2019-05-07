package kr.co.sist.admin.vo;

public class CategoryImgVO {
	private String category, img;
	
	public CategoryImgVO() {
	}

	public CategoryImgVO(String category, String img) {
		this.category = category;
		this.img = img;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
}
