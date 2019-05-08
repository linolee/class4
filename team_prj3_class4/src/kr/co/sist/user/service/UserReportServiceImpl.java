package kr.co.sist.user.service;

import kr.co.sist.user.dao.UserReportDAO;
import kr.co.sist.user.vo.GuestReportVO;
import kr.co.sist.user.vo.memberReportVO;

public class UserReportServiceImpl implements UserReportService {

	private UserReportDAO ur_dao;
	
	public UserReportServiceImpl(UserReportDAO ur_dao) {
		this.ur_dao = ur_dao;
	}

	@Override
	public boolean guestReportSubmit(GuestReportVO grvo) {
		if (ur_dao.guestReportSubmit(grvo) == 1) {//�Է��� ���������� ó���Ǹ�
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean memberReportSubmit(memberReportVO mrvo) {
		if (ur_dao.memberReportSubmit(mrvo) == 1) {//�Է��� ���������� ó���Ǹ�
			return true;
		}else {
			return false;
		}
	}
	
}
