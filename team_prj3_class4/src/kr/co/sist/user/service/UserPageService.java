package kr.co.sist.user.service;

import java.util.List;

import kr.co.sist.user.domain.ClientInfo;

public interface UserPageService {
	public ClientInfo clientInfo(String client_id);
	public List<String> clientFavor(String client_id);
}
