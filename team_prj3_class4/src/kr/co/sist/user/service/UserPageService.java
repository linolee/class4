package kr.co.sist.user.service;

import java.util.List;

import kr.co.sist.user.domain.ClientPageInfo;

public interface UserPageService {
	public ClientPageInfo clientInfo(String client_id);
	public List<String> clientFavor(String client_id);
	public int deleteUser(String client_id);
}
