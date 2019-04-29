package kr.co.sist.user.domain;

import java.util.List;

public class MainContents {
	private List<Category> listCategory;
	private List<RecommendClass> listRecommed;
	private List<ReviewClass> listReview;
	String[] mainImgArr, categoryArr;
	
	public List<Category> getListCategory() {
		return listCategory;
	}
	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}
	public List<RecommendClass> getListRecommed() {
		return listRecommed;
	}
	public void setListRecommed(List<RecommendClass> listRecommed) {
		this.listRecommed = listRecommed;
	}
	public List<ReviewClass> getListReview() {
		return listReview;
	}
	public void setListReview(List<ReviewClass> listReview) {
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
