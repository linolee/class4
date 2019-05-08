package kr.co.sist.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.user.dao.ReportDAO;
import kr.co.sist.user.dao.UserMypageDAO;
import kr.co.sist.user.vo.QnaVO;
import kr.co.sist.user.vo.ReportVO;

@Component
public class ReportService {
	@Autowired
	private ReportDAO r_dao;
	
	public boolean insertReport(ReportVO rvo) {
		boolean flag=false;
		flag=r_dao.insertReport(rvo);
		return flag;
	}//insertReport
	
}
