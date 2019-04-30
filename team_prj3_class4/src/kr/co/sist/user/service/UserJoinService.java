package kr.co.sist.user.service;

import kr.co.sist.user.vo.MemberJoinVO;

public interface UserJoinService {
	public String[][] CategoryMapping();
	public boolean memberJoin(MemberJoinVO mjvo, String[] favors);
	public boolean checkId(String client_id);
	public boolean checkTel(String tel);
	public boolean checkEmail(String email);
}
