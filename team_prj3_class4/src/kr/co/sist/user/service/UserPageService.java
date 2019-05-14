package kr.co.sist.user.service;

import java.util.List;

import kr.co.sist.user.domain.AdminQnA;
import kr.co.sist.user.domain.ClientPageInfo;
import kr.co.sist.user.domain.SearchClassList;
import kr.co.sist.user.vo.ChangePasswordVO;
import kr.co.sist.user.vo.MemberFavorVO;
import kr.co.sist.user.vo.MemberUpdateVO;
import kr.co.sist.user.vo.SearchListVO;
import kr.co.sist.user.vo.UserLoginVO;

public interface UserPageService {
	public ClientPageInfo clientInfo(String client_id);
	public List<String> clientFavor(String client_id);
	public int deleteUser(String client_id);
	public int checkPassword(UserLoginVO ul_vo);
	public int changePassword(ChangePasswordVO cp_vo);
	public int memberUpdate(MemberUpdateVO mu_vo);
	public int favorUpdate(String client_id, String[] favors);
	public int totalCount(String client_id);
	public int pageScale();
	public int totalPage(int totalCount);
	public int startNum(int currentPage);
	public int endNum(int startNum);
	public String indexList(int current_page, int total_page, String list_url, String client_id);
	public List<AdminQnA> searchQnaList(SearchListVO slvo);
}
