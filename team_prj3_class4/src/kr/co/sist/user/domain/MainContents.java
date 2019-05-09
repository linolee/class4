package kr.co.sist.user.domain;

import java.util.List;

public class MainContents {
	private List<Category> listCategory;
	private List<Recommend> listRecommed;
	private List<LatestReview> listReview;
	String[] mainImgArr, categoryArr;
	
	public List<Category> getListCategory() {
		return listCategory;
	}
	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}
	public List<Recommend> getListRecommed() {
		return listRecommed;
	}
	public void setListRecommed(List<Recommend> listRecommed) {
		this.listRecommed = listRecommed;
	}
	public List<LatestReview> getListReview() {
		return listReview;
	}
	public void setListReview(List<LatestReview> listReview) {
		this.listReview = listReview;
	}
	public String[] getMainImgArr() {
		return mainImgArr;
	}
	public void setMainImgArr(String[] mainImgArr) {
		this.mainImgArr = mainImgArr;
	}
	public String[] getCategoryArr() {
		return categoryArr;
	}
	public void setCategoryArr(String[] categoryArr) {
		this.categoryArr = categoryArr;
	}
	
}
