package kr.co.sist.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.user.dao.MainContentsDAO;
import kr.co.sist.user.domain.MainContents;

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
	
}//class
