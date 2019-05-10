package kr.co.sist.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.dao.AdminLoginDAO;
import kr.co.sist.admin.vo.AdminLoginVO;
import kr.co.sist.admin.vo.StatsVO;

@Component
public class AdminLoginService {
	@Autowired
	private AdminLoginDAO al_dao;
	
	public boolean adminLogin(AdminLoginVO alvo) {
		boolean flag=false;
		if(al_dao.adminLogin(alvo)) {
			flag=true;
		}
		return flag;
	}
	
	public StatsVO templateStats(){
		StatsVO svo=new StatsVO();
		
		int today=al_dao.today();
		int month=al_dao.month();
		
		int totalTeacher=al_dao.totalTeacher();
		int totalLecture=al_dao.totalLecture();
		int ingLecture=al_dao.ingLecture();
		int totalCategory=al_dao.totalCategory();
		int totalClient=al_dao.totalClient();
		int todayClient=al_dao.todayClient(today);
		int monthClient=al_dao.monthClient(month);
		int exitClient=al_dao.exitClient();
		
		svo.setTotalTeacher(totalTeacher);
		svo.setTotalLecture(totalLecture);
		svo.setIngLecture(ingLecture);
		svo.setTotalCategory(totalCategory);
		svo.setTotalClient(totalClient);
		svo.setTodayClient(todayClient);
		svo.setMonthClient(monthClient);
		svo.setExitClient(exitClient);
		
		return svo;
	}
	
}
