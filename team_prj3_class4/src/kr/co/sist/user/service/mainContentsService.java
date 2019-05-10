package kr.co.sist.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.user.dao.MainContentsDAO;
import kr.co.sist.user.domain.Category;
import kr.co.sist.user.domain.LatestReview;
import kr.co.sist.user.domain.MainContents;
import kr.co.sist.user.domain.Recommend;

@Component
public class mainContentsService {

	@Autowired
	private MainContentsDAO mc_dao;//인터페이스
		
	public MainContents showContentsForm(String category) {
		MainContents mc=null;
		//mc=mc_dao.selectTotal();
		return mc;
	}//showContentsForm
	
	public List<String> showMenuCategory(){
		List<String> categoryList=null;
		categoryList=mc_dao.selectCategory();
		return categoryList;
	}//showMenuCategory
	
	public List<Category> searchImgCategory(){
		List<Category> imgCate=null;
		imgCate=mc_dao.selectImgCategory();
		return imgCate;
	}//searchImgCategory
	
	public List<Category> searchImgCategory1(){
		List<Category> imgCate=null;
		List<Category> imgCate1=null;
		imgCate1=new ArrayList<Category>();
		imgCate=mc_dao.selectImgCategory();
		for(int i=0; i<3; i++) {
			imgCate1.add(imgCate.get(i));
		}//end for
		return imgCate1;
	}//searchImgCategory1

	public List<Category> searchImgCategory2(){
		List<Category> imgCate=null;
		List<Category> imgCate2=null;
		imgCate2=new ArrayList<Category>();
		imgCate=mc_dao.selectImgCategory();
		for(int i=3; i<6; i++) {
			imgCate2.add(imgCate.get(i));
		}//end for
		return imgCate2;
	}//searchImgCategory2
	
	public List<Category> searchImgCategory3(){
		List<Category> imgCate=null;
		List<Category> imgCate3=null;
		imgCate3=new ArrayList<Category>();
		imgCate=mc_dao.selectImgCategory();
		for(int i=6; i<9; i++) {
			imgCate3.add(imgCate.get(i));
		}//end for
		return imgCate3;
	}//searchImgCategory3
	
	public List<Recommend> selectRecommend1(){
		List<Recommend> recommend=null;
		List<Recommend> recommend1=null;
		recommend1=new ArrayList<Recommend>();
		recommend=mc_dao.selectRecommend();
		for(int i=0; i<3; i++) {
			recommend1.add(recommend.get(i));
		}//end for
		return recommend1;
	}//selectRecommend1
	
	public List<Recommend> selectRecommend2(){
		List<Recommend> recommend=null;
		List<Recommend> recommend2=null;
		recommend2=new ArrayList<Recommend>();
		recommend=mc_dao.selectRecommend();
		for(int i=3; i<6; i++) {
			recommend2.add(recommend.get(i));
		}//end for
		return recommend2;
	}//selectRecommend2
	
	public List<Recommend> selectRecommend3(){
		List<Recommend> recommend=null;
		List<Recommend> recommend3=null;
		recommend3=new ArrayList<Recommend>();
		recommend=mc_dao.selectRecommend();
		for(int i=6; i<9; i++) {
			recommend3.add(recommend.get(i));
		}//end for
		return recommend3;
	}//selectRecommend3
	
	public List<LatestReview> selectLatestReview1(){
		List<LatestReview> latestreview=null;
		List<LatestReview> latestreview1=null;
		latestreview1=new ArrayList<LatestReview>();
		latestreview=mc_dao.selectLatestReview();
		
		LatestReview lrv=null;
		String contents="";
		for(int i=0; i<3; i++) {
			lrv=latestreview.get(i);
			contents=lrv.getContents();
			if(contents.length()>53) {
				contents=contents.substring(0, 53)+"...";
				lrv.setContents(contents);
			}//end if
			
			if(latestreview.size()>i) {
				latestreview1.add(latestreview.get(i));
			}else {
				latestreview1.add(latestreview.get(1));
			}
		}//end for
		return latestreview1;
	}//selectLatestReview1
	
	public List<LatestReview> selectLatestReview2(){
		List<LatestReview> latestreview=null;
		List<LatestReview> latestreview2=null;
		latestreview2=new ArrayList<LatestReview>();
		latestreview=mc_dao.selectLatestReview();
		for(int i=3; i<6; i++) {
			if(latestreview.size()>i) {
				latestreview2.add(latestreview.get(i));
			}else if(latestreview.size()<=i) {
				latestreview2.add(latestreview.get(1));
			}
		}//end for
		return latestreview2;
	}//selectLatestReview2

	
	
}//class
