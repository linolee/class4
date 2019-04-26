package kr.co.sist.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.dao.TeacherPermitDAO;
import kr.co.sist.admin.domain.TeacherPermitDomain;

@Component
public class TeacherPermitService {

	@Autowired
	private TeacherPermitDAO tp_dao;
	
	public List<TeacherPermitDomain> selectTeacherPermit(){
		List<TeacherPermitDomain> list=null;
		list=tp_dao.selectTeacherPermit();
		return list;
	}
}
