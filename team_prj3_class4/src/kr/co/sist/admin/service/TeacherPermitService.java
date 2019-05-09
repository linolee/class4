package kr.co.sist.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.dao.TeacherPermitDAO;
import kr.co.sist.admin.domain.TeacherPermitDomain;
import kr.co.sist.admin.vo.ListVO;
import kr.co.sist.admin.vo.OptionSearchVO;

@Component
public class TeacherPermitService {

	@Autowired
	private TeacherPermitDAO tp_dao;
	
	// 1. 전체 게시물 수 얻기
		public int totalCount() {
			int cnt = 0;
			cnt = tp_dao.selectTotalCount();
			return cnt;
		}

	public List<TeacherPermitDomain> selectTeacherPermit(ListVO lvo){
		List<TeacherPermitDomain> list=null;
		list=tp_dao.selectTeacherPermit(lvo);
		return list;
	}
	
	public void teacherRefuse(String id){
		TeacherPermitDAO tpdao=TeacherPermitDAO.getInstance();
		tpdao.teacherRefuse(id); 
	}
	
	public void teacherPermission(String id) {
		TeacherPermitDAO tpdao=TeacherPermitDAO.getInstance();
		tpdao.teacherPermission(id);
	}
	
	public List<TeacherPermitDomain> teacherPermitOptionSearch(OptionSearchVO osvo){
		List<TeacherPermitDomain> list=null;
		TeacherPermitDAO tpdao=TeacherPermitDAO.getInstance();
		list=tpdao.teacherPermitOptionSearch(osvo);
		return list;
	}
	
}