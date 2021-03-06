package kr.co.sist.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.sist.user.domain.AdminQnA;
import kr.co.sist.user.domain.ClientPageInfo;
import kr.co.sist.user.domain.SearchClassList;
import kr.co.sist.user.vo.ChangePasswordVO;
import kr.co.sist.user.vo.MemberFavorVO;
import kr.co.sist.user.vo.MemberUpdateVO;
import kr.co.sist.user.vo.SearchListVO;
import kr.co.sist.user.vo.UserLoginVO;

public interface UserPageDAO {
	public ClientPageInfo selectClientInfo(String client_id); 
	public List<String> selectClientFavor(String client_id);
	public int deleteUser(String client_id);
	public int checkPassword(UserLoginVO ul_vo);
	public int changePassword(ChangePasswordVO cp_vo);
	public int memberUpdate(MemberUpdateVO mu_vo);
	public int favorDelete(String client_id);
	public int favorInsert(String client_id, String[] favors);
	public List<AdminQnA> selectQnaList(SearchListVO slvo);
	public int selectTotalCount(String client_id);
}
