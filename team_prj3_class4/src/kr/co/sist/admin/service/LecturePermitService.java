package kr.co.sist.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.dao.LecturePermitDAO;
import kr.co.sist.admin.domain.LecturePermitDomain;

@Component
public class LecturePermitService {

	@Autowired
	private LecturePermitDAO lp_dao;
	
	public List<LecturePermitDomain> selectLecturePermit(){
		List<LecturePermitDomain> list=null;
		list=lp_dao.selectLecturePermit();
		return list;
	}
}
