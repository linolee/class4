package kr.co.sist.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.sist.user.dao.LectureDAO;

public class UserLectureServiceImpl implements UserLectureService {
	
	private LectureDAO l_dao;
	
	public UserLectureServiceImpl(LectureDAO l_dao) {
		this.l_dao = l_dao;
	} // UserLectureServiceImpl
	
	@Override
	public Map<String, Object> selectLectureList() {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		
		//컨트롤러에서 받아온 값을 넘겨야해
		//그렇다면 서비스도 파라미터로 String 을 받아와야겠지
		
		//* 순서
		// 1. 컨트롤러에서 요청 받음 -> 세션에 있는 이름 값을 서비스에게 넘겨서(파라미터) 조회하는 메소드 호출
		// 2. 서비스에서는 dao를 호출 -> 컨트롤러로 부터 넘겨받은 string 넘기기 (파라미터)
		// 3. dao에서는 db에서 값 조회 후(mapper), 다시 서비스로 넘겨줌
		// 4. 서비스에서는 리스트를 받으면 해당 리스트만큼 for문 돌면서 lcode를 가져온 뒤,
		// 5. 해당 lcode로 신청자수를 조회 -> dao에서 카운트 가져오는 쿼리 호출
		// 6. 둘다 map에 각각 담은 뒤, return
		// 7. 컨트롤러도 jsp(front)로 return
		// 8. jsp에서 forEach로 화면에 뿌려줌
		List<String> list = l_dao.selectLecture("");	
		
		
		
		return resultMap;
	} // selectLectureList

	
	
} // 
