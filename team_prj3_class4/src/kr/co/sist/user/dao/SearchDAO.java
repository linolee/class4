package kr.co.sist.user.dao;

import java.util.List;

import kr.co.sist.user.domain.SearchClassList;
import kr.co.sist.user.vo.SearchListVO;

public interface SearchDAO {
	public List<SearchClassList> selectClassList(SearchListVO slvo);
	public int selectTotalCount(String keyword);
	public List<String> selectCategoryList(String keyword);
}
