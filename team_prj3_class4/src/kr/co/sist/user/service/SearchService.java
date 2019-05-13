package kr.co.sist.user.service;

import java.util.List;

import kr.co.sist.user.domain.SearchClassList;
import kr.co.sist.user.vo.SearchListVO;

public interface SearchService {
	public int totalCount(String keyword);
	public int pageScale();
	public int totalPage(int totalCount);
	public int startNum(int currentPage);
	public int endNum(int startNum);
	public String indexList(int current_page, int total_page, String list_url, String keyword);
	public List<SearchClassList> searchClassList(SearchListVO slvo);
	public List<String> searchCateogory(String keyword);
}
