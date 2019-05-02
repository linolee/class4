package kr.co.sist.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.user.dao.DetailDAO;
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
	
}//class
