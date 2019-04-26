package kr.co.sist.user.service;

import kr.co.sist.user.vo.MemberJoinVO;

public interface UserJoinService {
	public String[][] CategoryMapping();
	public boolean memberJoin(MemberJoinVO mjvo, String[] favors);
}
