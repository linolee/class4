package kr.co.sist.user.dao;

import java.util.List;

public interface UserJoinDAO {
	/**
	 * DB�� �����ϴ� ī�װ� ����Ʈ�� ����
	 */
	public List<String> categoryList();
	
	/**
	 * �Էµ� ������ DB�� �Է��� ȸ������
	 */
	public void join();
}
