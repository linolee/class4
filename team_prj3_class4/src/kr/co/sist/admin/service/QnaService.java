package kr.co.sist.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.admin.dao.QnaDAO;
import kr.co.sist.admin.domain.QnaQuestionList;

@Component
public class QnaService {

	@Autowired
	private QnaDAO d_dao;
	
	public List<QnaQuestionList> selectQnAQuestionList(){
		List<QnaQuestionList> list = null;
		list = d_dao.selectQnAQuestionList();
		return list;
	}
	
}
