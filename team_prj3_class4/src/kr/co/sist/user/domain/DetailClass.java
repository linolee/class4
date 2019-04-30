package kr.co.sist.user.domain;

import java.util.List;

public class DetailClass {
	private String img, title, tName, loc, classTime, maxPersonal, tMemo, deadLine, tProfile, curriculum, tIntroduce;
	private int star, starCnt, likeCnt;
	private List<QnA> anqList;
	private List<TClass> tclassList;
	private List<ReviewDomain> reviewDomainList;
	private List<ClassDate> classdateList;
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getClassTime() {
		return classTime;
	}
	public void setClassTime(String classTime) {
		this.classTime = classTime;
	}
	public String getMaxPersonal() {
		return maxPersonal;
	}
	public void setMaxPersonal(String maxPersonal) {
		this.maxPersonal = maxPersonal;
	}
	public String gettMemo() {
		return tMemo;
	}
	public void settMemo(String tMemo) {
		this.tMemo = tMemo;
	}
	public String getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
	}
	public String gettProfile() {
		return tProfile;
	}
	public void settProfile(String tProfile) {
		this.tProfile = tProfile;
	}
	public String getCurriculum() {
		return curriculum;
	}
	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}
	public String gettIntroduce() {
		return tIntroduce;
	}
	public void settIntroduce(String tIntroduce) {
		this.tIntroduce = tIntroduce;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public int getStarCnt() {
		return starCnt;
	}
	public void setStarCnt(int starCnt) {
		this.starCnt = starCnt;
	}
	public int getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
	public List<QnA> getAnqList() {
		return anqList;
	}
	public void setAnqList(List<QnA> anqList) {
		this.anqList = anqList;
	}
	public List<TClass> getTclassList() {
		return tclassList;
	}
	public void setTclassList(List<TClass> tclassList) {
		this.tclassList = tclassList;
	}
	public List<ReviewDomain> getReviewDomainList() {
		return reviewDomainList;
	}
	public void setReviewDomainList(List<ReviewDomain> ReviewDomainList) {
		this.reviewDomainList = ReviewDomainList;
	}
	public List<ClassDate> getClassdateList() {
		return classdateList;
	}
	public void setClassdateList(List<ClassDate> classdateList) {
		this.classdateList = classdateList;
	}
	
}
