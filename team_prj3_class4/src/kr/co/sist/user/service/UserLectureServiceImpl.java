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
		
		
		//��Ʈ�ѷ����� �޾ƿ� ���� �Ѱܾ���
		//�׷��ٸ� ���񽺵� �Ķ���ͷ� String �� �޾ƿ;߰���
		
		//* ����
		// 1. ��Ʈ�ѷ����� ��û ���� -> ���ǿ� �ִ� �̸� ���� ���񽺿��� �Ѱܼ�(�Ķ����) ��ȸ�ϴ� �޼ҵ� ȣ��
		// 2. ���񽺿����� dao�� ȣ�� -> ��Ʈ�ѷ��� ���� �Ѱܹ��� string �ѱ�� (�Ķ����)
		// 3. dao������ db���� �� ��ȸ ��(mapper), �ٽ� ���񽺷� �Ѱ���
		// 4. ���񽺿����� ����Ʈ�� ������ �ش� ����Ʈ��ŭ for�� ���鼭 lcode�� ������ ��,
		// 5. �ش� lcode�� ��û�ڼ��� ��ȸ -> dao���� ī��Ʈ �������� ���� ȣ��
		// 6. �Ѵ� map�� ���� ���� ��, return
		// 7. ��Ʈ�ѷ��� jsp(front)�� return
		// 8. jsp���� forEach�� ȭ�鿡 �ѷ���
		List<String> list = l_dao.selectLecture("");	
		
		
		
		return resultMap;
	} // selectLectureList

	
	
} // 
