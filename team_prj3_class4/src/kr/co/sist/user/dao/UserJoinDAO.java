package kr.co.sist.user.dao;

import java.util.List;

import kr.co.sist.user.vo.MemberJoinVO;

public interface UserJoinDAO {
	/**
	 * DB에 존재하는 카테고리 리스트를 리턴
	 */
	public List<String> categoryList();
	
	/**
	 * 입력된 정보를 DB에 입력해 회원가입
	 */
	public void join(MemberJoinVO mjvo, String[] favors);
	
	/**
	 * 입력받은 아이디로 DB를 조회해서 아이디가 있으면 true를 반환
	 */
	public boolean checkId(String client_id);
}
