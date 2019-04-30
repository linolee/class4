package kr.co.sist.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.user.dao.UserLectureDAO;
import kr.co.sist.user.domain.LectureView;

@Component
public class UserLectureService {
	@Autowired
	private UserLectureDAO l_dao;

	// lcode로 클래스 현황 들고오기
	private LectureView searchLecture(String lcode) {
		LectureView lv = l_dao.selectLecture(lcode);
		return lv;
	}

	// teachername으로 lcode 조회
	private List<String> searchLcode(String teacherName) {
		List<String> list = l_dao.selectLcode(teacherName);
		return list;
	}

	// id로 teacherName 조회
	private List<String> searchTeachername(String userId) {
		List<String> list = l_dao.selectTeachername(userId);
		return list;
	}
	
	// id로 teacherName 조회 >>> teachername으로 lcode 조회 >> lcode로 클래스 현황
	public List<LectureView> searchLectureInfo(String userId) {
		List<String> tnlist = searchTeachername(userId);
		List<String> l_list = new ArrayList<String>();
		List<LectureView> lvlist = new ArrayList<LectureView>();
		
		for(int i=0; i<tnlist.size(); i++) {
			l_list.addAll(searchLcode(tnlist.get(i)));
		}
		
		LectureView lv = null;
		for(int k=0; k<l_list.size(); k++) {
			lv = searchLecture(l_list.get(k));
			lvlist.add(lv);
		}

		return lvlist;
	}
	
	
	
	

} //
