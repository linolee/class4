package kr.co.sist.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.dao.AdminLoginDAO;
import kr.co.sist.admin.vo.AdminLoginVO;

@Component
public class AdminLoginService {
	@Autowired
	private AdminLoginDAO al_dao;
	
	public boolean adminLogin(AdminLoginVO alvo) {
		boolean flag=false;
		if(al_dao.adminLogin(alvo)) {
			flag=true;
		}
		return flag;
	}
	
}
