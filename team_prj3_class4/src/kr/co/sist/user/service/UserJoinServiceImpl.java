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
	 * DB���� �ҷ��� Category List�� ȭ�鿡 ǥ���ϱ� ���� n*maxRowNum�迭�� ���� ��ȯ
	 */
	@Override
	public String[][] CategoryMapping() {
		List<String> categoryList = uj_dao.categoryList();
		//List�� maxRowNum���� ���� ���� �ø� �ϸ� ����� ����. 
		String[][] categoryMaping = new String[(int)Math.ceil((double)categoryList.size()/maxRowNum)][maxRowNum]; 
		int rowNum = 0;
		int columnNum = 0;
		for (String category : categoryList) {
			if (rowNum == maxRowNum) {//������ 4�� �Ǹ�
				rowNum = 0;//������ 0���� �ʱ�ȭ
				columnNum ++;//����� 1 �߰�
			}
			categoryMaping[columnNum][rowNum] = category;//categoryMapping�� category���� �־��ְ�
			rowNum++;//������ �����ش�
			
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
