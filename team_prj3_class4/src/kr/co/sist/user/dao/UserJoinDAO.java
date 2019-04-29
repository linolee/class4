package kr.co.sist.user.dao;

import java.util.List;

public interface UserJoinDAO {
	/**
	 * DB에 존재하는 카테고리 리스트를 리턴
	 */
	public List<String> categoryList();
	
	/**
	 * 입력된 정보를 DB에 입력해 회원가입
	 */
	public void join();
}
