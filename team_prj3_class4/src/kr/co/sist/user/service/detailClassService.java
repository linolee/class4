package kr.co.sist.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.user.dao.DetailDAO;
import kr.co.sist.user.domain.DetailContents;
import kr.co.sist.user.domain.QnA;
import kr.co.sist.user.domain.ReviewDomain;
import kr.co.sist.user.domain.Star;
import kr.co.sist.user.domain.Summary;

@Component
public class detailClassService {

	@Autowired
	private DetailDAO d_dao;
		
	public DetailDAO showContents(String lcode) {
		DetailDAO d_dao=null;
		return d_dao;
	}//showContentsForm
	
	public Summary searchSummary(String lcode){
		Summary summary=null;
		summary=d_dao.selectSummary(lcode);
		return summary;
	}//showMenuCategory
	
	public Star searchStar(String lcode){
		Star star=null;
		star=d_dao.selectStar(lcode);
		return star;
	}//showMenuCategory
	
	public List<String> searchCareer(String lcode){
		List<String> careerlist=null;
		careerlist=d_dao.selectCareer(lcode);
		
		return careerlist;
	}//showMenuCategory
	
	public DetailContents searchContents(String lcode) {
		DetailContents dc=null;
		dc=d_dao.selectContents(lcode);
		return dc;
	}//searchContents
	
	public List<String> searchOpt(String lcode) {
		List<String> optlist=null;
		optlist=d_dao.selectOpt(lcode);
		return optlist;
	}//searchOpt
	
	public List<String> searchNoOpt() {
		List<String> noptlist=null;
		noptlist=d_dao.selectNoOpt();
		return noptlist;
	}//searchNoOpt
	
	public List<ReviewDomain> searchRvList(String lcode){
		List<ReviewDomain> rvlist=null;
		rvlist=d_dao.selectReviewList(lcode);
		return rvlist;
	}//searchRvList
	
	public List<QnA> searchQnaList(String lcode) {
		List<QnA> qnalist=null;
		qnalist=d_dao.selectQnaList(lcode);
		return qnalist;
	}//searchQnaList
	
}//class
