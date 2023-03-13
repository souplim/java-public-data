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
@Log4j // aop로 로그 출력하므로 생략 가능
public class AdminBoardController {
	
	@Setter(onMethod_ = @Autowired)
	private AdminBoardService adminBoardService;
	
	@Setter(onMethod_ = @Autowired)
	private ReplyService replyService;
	
	/***************************************************************************************
	 * 글 목록 구현하기
	 ***************************************************************************************/
	@GetMapping("/board/boardList")
	public String boardList(@ModelAttribute("data") BoardVO bvo, Model model) { // "data" 명시 안하면 boardVO라는 이름으로 전달됨
		log.info("admin boardList 호출 성공");
		
		// 리스트 조회
		List<BoardVO> boardList = adminBoardService.boardList(bvo);
		model.addAttribute("boardList", boardList);
		
		// 전체 레코드수 조회
		int total = adminBoardService.boardListCnt(bvo);
		model.addAttribute("pageMaker", new PageDTO(bvo, total));
		
		// 리스트 번호 부여를 위한 속성
		// 게시판 b_num이 일괄적으로 부여되는 번호가 아닌만큼 번호 부여를 위한 변수 count 선언
		int count = total - (bvo.getPageNum()-1) * bvo.getAmount();
		model.addAttribute("count", count);
		
		return "admin/board/boardList"; // /WEB-INF/views/admin/board/boardList.jsp
	}
	
	/***************************************************************************************
	 * 글 상세 페이지 구현하기
	 ***************************************************************************************/
	@GetMapping("/board/boardDetail")
	public String boardDetail(@RequestParam("b_num") int b_num, Model model) {
		BoardVO boardDetail = adminBoardService.boardDetail(b_num);
		model.addAttribute("boardDetail", boardDetail);
		
		// 댓글 조회
		List<ReplyVO> replyList = replyService.replyList(b_num);
		model.addAttribute("replyList", replyList);
		
		return "admin/board/boardDetail";
	}
	
	/***************************************************************************************
	 * 글 삭제 구현하기
	 ***************************************************************************************/
	@GetMapping("/board/boardDelete")
	public String boardDelete(@RequestParam("b_num") int b_num, RedirectAttributes ras) {
		int result = adminBoardService.boardDelete(b_num);
		
		if(result!=1) {
			ras.addFlashAttribute("errorMsg","로그인 실패");
		}
		return "redirect:/admin/board/boardList";
	}
}
