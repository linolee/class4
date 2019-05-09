package kr.co.sist.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.admin.domain.QnaDetail;
import kr.co.sist.admin.domain.QnaQuestionList;
import kr.co.sist.admin.service.QnaService;
import kr.co.sist.admin.vo.ListVO;
import kr.co.sist.admin.vo.QnaAnswerVO;

@Controller
public class QuestionController {
	
	@Autowired
	private QnaService qs;
	
	@RequestMapping(value="/admin/question.do",method=GET)
	public String questionPage( ListVO lvo, Model model ) {
		List<QnaQuestionList> list = null;

		int totalCount = qs.totalCount();// �� �Խù��� ��//
		int pageScale = qs.pageScale();
		int totalPage = qs.totalPage(totalCount);// ��ü �Խù��� �����ֱ� ���� �� ������ ��
		if (lvo.getCurrentPage() == 0) { // web parameter�� ���� ���� ��
			lvo.setCurrentPage(1);
		}
		int startNum = qs.startNum(lvo.getCurrentPage());
		int endNum = qs.endNum(startNum);
		lvo.setStartNum(startNum);
		lvo.setEndNum(endNum);

		list = qs.searchQnAQuestionList(lvo);// ����Ʈ ��� ��ȸ

		String indexList = qs.indexList(lvo.getCurrentPage(), totalPage, "question.do");
		model.addAttribute("list", list);// @@
		model.addAttribute("indexList", indexList);
		model.addAttribute("pageScale", pageScale);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", lvo.getCurrentPage());

		model.addAttribute("page", "question");// @@
		return "admin/template";
	}

	@RequestMapping(value = "/admin/qnaRead.do", method = GET)
	public String qnaRead(String qnum, Model model) {
		QnaDetail qd = qs.searchQnaDetail(qnum);// ������ ������ ��ȸ
		model.addAttribute("searchData", qd);
		model.addAttribute("page", "qnaRead");
		return "admin/template";
	}

	@RequestMapping(value = "/admin/addQnaAnswer.do", method = POST)
	public String addQnaAnswer(QnaAnswerVO qavo, Model model) {
		int cnt = qs.addQnaAnswer(qavo);

		return "redirect:/admin/question.do";
	}
	
	
}
