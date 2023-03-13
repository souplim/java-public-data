package com.spring.admin.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.admin.board.service.AdminBoardService;
import com.spring.client.board.vo.BoardVO;
import com.spring.client.reply.service.ReplyService;
import com.spring.client.reply.vo.ReplyVO;
import com.spring.common.vo.PageDTO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/admin/*")
@Log4j // aop�� �α� ����ϹǷ� ���� ����
public class AdminBoardController {
	
	@Setter(onMethod_ = @Autowired)
	private AdminBoardService adminBoardService;
	
	@Setter(onMethod_ = @Autowired)
	private ReplyService replyService;
	
	/***************************************************************************************
	 * �� ��� �����ϱ�
	 ***************************************************************************************/
	@GetMapping("/board/boardList")
	public String boardList(@ModelAttribute("data") BoardVO bvo, Model model) { // "data" ��� ���ϸ� boardVO��� �̸����� ���޵�
		log.info("admin boardList ȣ�� ����");
		
		// ����Ʈ ��ȸ
		List<BoardVO> boardList = adminBoardService.boardList(bvo);
		model.addAttribute("boardList", boardList);
		
		// ��ü ���ڵ�� ��ȸ
		int total = adminBoardService.boardListCnt(bvo);
		model.addAttribute("pageMaker", new PageDTO(bvo, total));
		
		// ����Ʈ ��ȣ �ο��� ���� �Ӽ�
		// �Խ��� b_num�� �ϰ������� �ο��Ǵ� ��ȣ�� �ƴѸ�ŭ ��ȣ �ο��� ���� ���� count ����
		int count = total - (bvo.getPageNum()-1) * bvo.getAmount();
		model.addAttribute("count", count);
		
		return "admin/board/boardList"; // /WEB-INF/views/admin/board/boardList.jsp
	}
	
	/***************************************************************************************
	 * �� �� ������ �����ϱ�
	 ***************************************************************************************/
	@GetMapping("/board/boardDetail")
	public String boardDetail(@RequestParam("b_num") int b_num, Model model) {
		BoardVO boardDetail = adminBoardService.boardDetail(b_num);
		model.addAttribute("boardDetail", boardDetail);
		
		// ��� ��ȸ
		List<ReplyVO> replyList = replyService.replyList(b_num);
		model.addAttribute("replyList", replyList);
		
		return "admin/board/boardDetail";
	}
	
	/***************************************************************************************
	 * �� ���� �����ϱ�
	 ***************************************************************************************/
	@GetMapping("/board/boardDelete")
	public String boardDelete(@RequestParam("b_num") int b_num, RedirectAttributes ras) {
		int result = adminBoardService.boardDelete(b_num);
		
		if(result!=1) {
			ras.addFlashAttribute("errorMsg","�α��� ����");
		}
		return "redirect:/admin/board/boardList";
	}
}
