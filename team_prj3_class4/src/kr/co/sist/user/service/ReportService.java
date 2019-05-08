package kr.co.sist.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.user.dao.ReportDAO;
import kr.co.sist.user.dao.UserMypageDAO;

@Component
public class ReportService {
	@Autowired
	private ReportDAO r_dao;
}
