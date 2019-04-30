package kr.co.sist.user.dao;


import java.util.List;

import kr.co.sist.user.domain.LectureView;


public interface LectureDAO {

	public List<String> selectLecture(String teacher_name);
	
} // interface
