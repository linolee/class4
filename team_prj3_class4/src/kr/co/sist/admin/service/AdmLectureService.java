package kr.co.sist.admin.service;

import kr.co.sist.admin.dao.LectureDAO;

public class AdmLectureService {

	private LectureDAO l_dao;
	
	public AdmLectureService() {
		l_dao=LectureDAO.getInstance();
	}
	

	
	
}
