package kr.co.sist.user.dao;

import kr.co.sist.user.vo.GuestReportVO;
import kr.co.sist.user.vo.memberReportVO;

public interface UserReportDAO {
	public int guestReportSubmit(GuestReportVO grvo);
	public int memberReportSubmit(memberReportVO mrvo);

}
