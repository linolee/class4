package kr.co.sist.user.service;

import java.util.List;

import kr.co.sist.user.dao.UserJoinDAO;
import kr.co.sist.user.dao.UserJoinDAOImpl;

public class UserJoinServiceImpl implements UserJoinService {

	private UserJoinDAO uj_dao;
	private static int maxRowNum = 3;
	
	public UserJoinServiceImpl(UserJoinDAO uj_dao) {
		this.uj_dao = uj_dao;
	}
	
	/* 
	 * DB에서 불러온 Category List를 화면에 표시하기 위해 n*maxRowNum배열로 만들어서 반환
	 */
	@Override
	public String[][] CategoryMapping() {
		List<String> categoryList = uj_dao.categoryList();
		//List를 maxRowNum으로 나눈 몫을 올림 하면 행수가 나옴. 
		String[][] categoryMaping = new String[(int)Math.ceil((double)categoryList.size()/maxRowNum)][maxRowNum]; 
		int rowNum = 0;
		int columnNum = 0;
		for (String category : categoryList) {
			if (rowNum == maxRowNum) {//열수가 4가 되면
				rowNum = 0;//열수는 0으로 초기화
				columnNum ++;//행수는 1 추가
			}
			categoryMaping[columnNum][rowNum] = category;//categoryMapping에 category값을 넣어주고
			rowNum++;//열수를 더해준다
			
		}
		return categoryMaping;
	}
	
	public static void main(String[] args) {
		UserJoinServiceImpl ujs = new UserJoinServiceImpl(new UserJoinDAOImpl());
		String[][] categoryMapping = ujs.CategoryMapping(); 
		for (int i = 0; i < categoryMapping.length; i++) {
			for (int j = 0; j < categoryMapping[i].length; j++) {
				System.out.print(categoryMapping[i][j]+"/");
			}
			System.out.println();
		}
	}

}
