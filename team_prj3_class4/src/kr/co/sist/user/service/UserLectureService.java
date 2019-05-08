package kr.co.sist.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.user.dao.UserLectureDAO;
import kr.co.sist.user.domain.LectureView;
import kr.co.sist.user.domain.Review;
import kr.co.sist.user.domain.StatusCnt;

@Component
public class UserLectureService {
	@Autowired
	private UserLectureDAO l_dao;

	// 검색조건으로 클래스 조회
	private LectureView searchLecture(Map<String, String> param) {
		LectureView lv = l_dao.selectLecture(param);
		return lv;
	}//searchLecture

	// teachername으로 lcode 조회
	private List<String> searchLcode(String teacherName) {
		List<String> list = l_dao.selectLcode(teacherName);
		return list;
	}//searchLcode

	// id로 teacherName 조회
	private List<String> searchTeachername(String userId) {
		List<String> list = l_dao.selectTeachername(userId);
		return list;
	}//searchTeachername
	
	// id와 상태값으로 클래스 조회
	public List<LectureView> searchLectureInfo(String userId, String status) {
		//id로 이름을 가져온다
		List<String> tnlist = searchTeachername(userId); 
		
		List<String> l_list = new ArrayList<String>();
		List<LectureView> lvlist = new ArrayList<LectureView>();
		
		//이름 수만큼 반복하면서, lcode를 가져온다
		for(int i=0; i<tnlist.size(); i++) {
			if (!searchLcode(tnlist.get(i)).isEmpty()) {
				l_list.addAll(searchLcode(tnlist.get(i)));
			} // end for
		} //searchLectureInfo
		
		
		//lcode만큼 반복하면서 lcode와 상태값으로 클래스를 조회한다
		LectureView lv = null;
		for(int k = 0; k < l_list.size(); k++) {
			//파라미터 map에 넣어 보내기
			Map<String, String> param = new HashMap<String, String>();
			param.put("lcode", l_list.get(k));
			param.put("status", status);
			
			//클래스 조회
			lv = searchLecture(param);
			
			//데이터가 null이 아니라면 list에 add
			if (lv != null) {
				lvlist.add(lv);
			} // end if
		} // end for

		return lvlist;
	} //searchLectureInfo

	public List<LectureView> searchStudentsList(String lcode) {
		List<LectureView> s_list = l_dao.selectStudentsList(lcode);
		return s_list;
	} //searchStudentsList
	
	public List<String> searchTeacherName(String userId){
		List<String> list = l_dao.selectTeacherName(userId);
		
		return list;
	} //searchTeacherName
	
	public Map<String, Object> searchStatusCnt(List<String> tn_list){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int cnt = 0;	//totalCnt
		
		//status Cnt
		int A = 0;
		int R = 0;
		int Y = 0;
		int F = 0;
		int I = 0;
		int E = 0;
		int C = 0;	
		
		for(int i = 0; i < tn_list.size(); i++) {	//teacherName수만큼 반복
			//이름으로 클래스 상태별 카운트를 가져온다
			List<StatusCnt> cntList = l_dao.selectLectureStatus(tn_list.get(i));
			
			if (!cntList.isEmpty()) { //받아온 데이터가 존재한다면 진입
				for (int j = 0; j < cntList.size(); j++) {
					cnt += cntList.get(j).getNum();	//total
					
					//status
					if (cntList.get(j).getStatus().equals("A")) {
						A += cntList.get(j).getNum();
					} else if (cntList.get(j).getStatus().equals("R")) {
						R += cntList.get(j).getNum();
					} else if(cntList.get(j).getStatus().equals("Y")) {
						Y += cntList.get(j).getNum();
					} else if(cntList.get(j).getStatus().equals("F")) {
						F += cntList.get(j).getNum();
					} else if(cntList.get(j).getStatus().equals("I")) {
						I += cntList.get(j).getNum();
					} else if(cntList.get(j).getStatus().equals("E")) {
						E += cntList.get(j).getNum();
					} else if(cntList.get(j).getStatus().equals("C")) {
						C += cntList.get(j).getNum();
					}
				}
			} // end if
		} // end for
		
		resultMap.put("totalCnt", cnt);
		resultMap.put("A", A);
		resultMap.put("R", R);
		resultMap.put("Y", Y);
		resultMap.put("F", F);
		resultMap.put("I", I);
		resultMap.put("E", E);
		resultMap.put("C", C);
		
		return resultMap;
	} // searchStatusCnt
	 
	
} // class
