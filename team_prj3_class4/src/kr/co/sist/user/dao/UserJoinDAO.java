package kr.co.sist.user.dao;

import java.util.List;

import kr.co.sist.user.vo.MemberJoinVO;

public interface UserJoinDAO {
	/**
	 * DB�� �����ϴ� ī�װ� ����Ʈ�� ����
	 */
	public List<String> categoryList();
	
	/**
	 * �Էµ� ������ DB�� �Է��� ȸ������
	 */
	public void join(MemberJoinVO mjvo, String[] favors);
	
	/**
	 * �Է¹��� ���̵�� DB�� ��ȸ�ؼ� ���̵� ������ true�� ��ȯ
	 */
	public boolean checkId(String client_id);
}
