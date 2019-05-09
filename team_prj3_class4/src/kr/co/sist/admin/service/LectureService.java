package kr.co.sist.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.dao.LectureDAO;
import kr.co.sist.admin.domain.LectureListDomain;
import kr.co.sist.admin.vo.ListVO;
import kr.co.sist.admin.vo.OptionSearchVO;

@Component
public class LectureService {
	
	@Autowired(required=false)
	private LectureDAO l_dao;
	
		public int totalCount() {
			int cnt = 0;
			cnt = l_dao.selectTotalCount();
			return cnt;
		}
	
	public List<LectureListDomain> selectLectureList(ListVO lvo){
		List<LectureListDomain> list=null;
		list=l_dao.selectLectureList(lvo);
		return list;
	}
	
	public List<LectureListDomain> lectureOptionSearch(OptionSearchVO osvo){
		List<LectureListDomain> list=null;
		list=l_dao.lectureOptionSearch(osvo);
		return list;
	}
	
	/*public static void main(String[] args) {
		LectureService ls=new LectureService();
		ls.selectLectureList();
	}*/
	
	
}
