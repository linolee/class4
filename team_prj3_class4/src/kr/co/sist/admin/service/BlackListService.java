package kr.co.sist.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.dao.BlackListDAO;
import kr.co.sist.admin.domain.BlackListDomain;

@Component
public class BlackListService {

	@Autowired
	private BlackListDAO bl_dao;
	
	public List<BlackListDomain> selectBlackList(){
		List<BlackListDomain> list=null;
		list=bl_dao.selectBlackList();
		return list;
	}
}
