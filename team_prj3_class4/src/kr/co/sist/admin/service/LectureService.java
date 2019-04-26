package kr.co.sist.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.dao.LectureDAO;
import kr.co.sist.admin.domain.LectureListDomain;

@Component
public class LectureService {
	
	@Autowired(required=false)
	private LectureDAO l_dao;
	
	public LectureService() {
		l_dao=LectureDAO.getInstance();
	}
	
	public List<LectureListDomain> selectLectureList(){
		List<LectureListDomain> list=null;
		list=l_dao.selectLectureList();
		return list;
	}
	
	public static void main(String[] args) {
		LectureService ls=new LectureService();
		ls.selectLectureList();
	}
	
	
}
