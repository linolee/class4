package kr.co.sist.user.service;

import kr.co.sist.user.vo.GuestReportVO;
import kr.co.sist.user.vo.memberReportVO;

public interface UserReportService {
	public boolean guestReportSubmit(GuestReportVO grvo);
	public boolean memberReportSubmit(memberReportVO mrvo);
}
