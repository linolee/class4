package kr.co.sist.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.dao.LecturePermitDAO;
import kr.co.sist.admin.domain.LecturePermitDomain;
import kr.co.sist.admin.vo.ListVO;

@Component
public class LecturePermitService {

	@Autowired
	private LecturePermitDAO lp_dao;
	
	// 1. 전체 게시물 수 얻기
		public int totalCount() {
			int cnt = 0;
			cnt = lp_dao.selectTotalCount();
			return cnt;
		}

	public List<LecturePermitDomain> selectLecturePermit(ListVO lvo){
		List<LecturePermitDomain> list=null;
		list=lp_dao.selectLecturePermit(lvo);
		return list;
	}
}
