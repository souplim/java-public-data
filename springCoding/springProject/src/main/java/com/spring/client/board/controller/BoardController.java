package com.spring.client.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.client.board.service.BoardService;
import com.spring.client.board.vo.BoardVO;
import com.spring.common.vo.PageDTO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
public class BoardController {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService boardService;
	
	/***********************************************************
	 * �Խ��� �۸�� �����ϱ�(����¡ ó���κа� �˻� ���� ��� ��ȸ)
	 * ��û �ּ� : http://localhost:8080/board/boardList
	 **********************************************************/
	@RequestMapping(value="/boardList", method = RequestMethod.GET) // ���ο��� /�ٰ�
	public String boardList(@ModelAttribute BoardVO boardVO, Model model) {
		log.info("boardList ȣ�� ����");
		
		// ��ü ���ڵ� ��ȸ
		List<BoardVO> boardList = boardService.boardList(boardVO);
		model.addAttribute("boardList", boardList);
		
		// ��ü ���ڵ�� ����
		int total = boardService.boardListCnt(boardVO);
	    // ����¡ ó��
		model.addAttribute("pageMaker", new PageDTO(boardVO, total)); // new PageDTO(CommonVO ���� Ŭ������ �ν��Ͻ�(BoardVO), �� ���ڵ��)
		return "board/boardList"; // /WEB-INF/views/board/boardList.jsp // ��ȯ������ �� ����(prefix�� /�پ�����)
	}
	
	/***********************************************************
	 * �Խ��� �۾��� �� ����ϱ�
	 * ��û �ּ� : http://localhost:8080/board/writeForm
	 **********************************************************/
	@RequestMapping(value="/writeForm", method = RequestMethod.GET) 
	public String writeForm() {
		log.info("writeForm ȣ�� ����");
		return "board/writeForm"; // /WEB-INF/views/board/writeForm.jsp 
	}
	
	/***********************************************************
	 * �۾��� �����ϱ�
	 * ��û �ּ� : http://localhost:8080/board/boardInsert
	 **********************************************************/
	@RequestMapping(value="/boardInsert", method = RequestMethod.POST) 
	public String boardInsert(BoardVO boardVO, Model model) throws Exception {
		log.info("boardInsert ȣ�� ����");
		
		int result = 0;
		String url = "";
		
		result = boardService.boardInsert(boardVO);
		if(result==1)
			url = "/board/boardList"; // ������ �ҷ� �ٽ� ��ȸ�ϰ� ������ �ϱ� ������ jsp�� �ƴ� ���� ȣ��
		else
			url = "/board/writeForm";
		
		return "redirect:"+url; // jsp �������� ������ ���� �ʰ� ���� ã��
	}
	
	/***********************************************************
	 * �Խ��� �� ������ �����ϱ�
	 * ��û �ּ� : http://localhost:8080/board/boardDetail
	 **********************************************************/
	@GetMapping("/boardDetail")
	public String boardDetail(@RequestParam("b_num") int b_num, Model model) throws Exception {
		log.info("boardDetail ȣ�� ����");
		
		BoardVO boardVO = boardService.boardDetail(b_num);
		model.addAttribute("boardVO", boardVO);
		return "board/boardDetail"; // /WEB-INF/views/board/boardDetail.jsp
	}
	
	/***********************************************************
	 * ��й�ȣ Ȯ�� �����ϱ�
	 * @param b_num: ���α� ���θ� Ȯ���� �Խñ� ��ȣ
	 * @param b_pwd: �Է��� ��й�ȣ
	 * @return int�� result�� 0 �Ǵ� 1�� ������ ���� �ְ�,
	 * 		   String���� result���� "����(��ġ)" �Ǵ� "����(����ġ)"�� ������ ���� ����(���� ���ڿ� ����)
	 * ���� : @ResponseBody�� ���޵� �並 ���ؼ� ����ϴ� ���� �ƴ϶� HTTP Response Body�� ���� ����ϴ� ���(ajax ��û�� ���)
	 * 		 produces �Ӽ��� ������ �̵�� Ÿ�԰� ���õ� ������ �����ϴµ� ����� ���� ����Ʈ Ÿ���� ����
	 **********************************************************/
	@ResponseBody
	@RequestMapping(value="/pwdConfirm", method = RequestMethod.POST, produces="text/plain; charset=UTF-8")
	public String pwdConfirm(BoardVO boardVO) {
		log.info("pwdConfirm ȣ�� ����");
		String value = "";
		
		// �Է� ������ ���� ���°� ����(1 or 0)
		int result = boardService.pwdConfirm(boardVO);
		if(result==1)
			value="����";
		else
			value="����";
		log.info("result=" + result);
		
		return value; // value�� ��ü�� �������� ���
	}
	
	/***********************************************************
	 * �Խ��� ���� �� ����ϱ�
	 * ��û �ּ� : http://localhost:8080/board/updateForm
	 **********************************************************/
	@RequestMapping("/updateForm")
	public String updateForm(@RequestParam("b_num") int b_num, Model model) {
		log.info("updateForm ȣ�� ����");
		
		BoardVO boardVO = boardService.boardDetail(b_num);
		model.addAttribute("boardVO", boardVO);
		return "board/updateForm"; // /WEB-INF/views/board/updateForm.jsp
	}
	
	/***********************************************************
	 * �� ���� �ϱ�
	 * ��û �ּ� : http://localhost:8080/board/boardUpdate
	 * ���� ���� -> �Ķ���͸� �޾Ƽ� redirect�� ����(if update�� ���� ������ detail.jsp�� �� ��) get��ĸ� ����
	 * RedirectAttriutes ��ü�� �����̷�Ʈ ����(return "redirect:/���")�� 
	 * �ѹ��� ���Ǵ� �����͸� ������ �� �ִ� addFlashAttribute() ��� ����� �����Ѵ�.
	 * addFlashAttribute() �޼���� ���������� ���۵Ǳ�� ������, URI �󿡴� ������ �ʴ� ������ �������� ���·� ���޵ȴ�.
	 **********************************************************/
	@RequestMapping(value="/boardUpdate", method = RequestMethod.POST) 
	public String boardUpdate(BoardVO boardVO, RedirectAttributes ras) throws Exception {
		log.info("boardUpdate ȣ�� ����");
		
		int result = 0;
		String url = "";
		
		result = boardService.boardUpdate(boardVO);
		
		// �����̷�Ʈ �ϴ� ������ �� ������ �� �ִ� �޼���
		// �׷��� ���ΰ�ħ �ϸ� ������
		// ras.addFlashAttribute("b_num", boardVO.getB_num());
		
		if(result==1) { // ������ �ҷ� �ٽ� ��ȸ�ϰ� ������ �ϱ� ������ jsp�� �ƴ� ���� ȣ��
			url = "/board/boardDetail?b_num="+boardVO.getB_num(); 
//			url = "/board/boardDetail";
		} else {
			url = "/board/updateForm?b_num="+boardVO.getB_num(); 
//			url = "/board/updateForm";
		}
		return "redirect:"+url; // jsp �������� ������ ���� �ʰ� ���� ã��
	}

	/***********************************************************
	 * �Խñ� �����ϱ�
	 * ��û �ּ� : http://localhost:8080/board/boardDelete
	 **********************************************************/
	@RequestMapping("/boardDelete")
//	public String boardDelete(@ModelAttribute("b_num") int b_num) throws Exception {
	public String boardDelete(BoardVO boardVO) throws Exception {
		log.info("boardDelete ȣ�� ����");
			
		int result = 0;
		String url = "";
		
//		result = boardService.boardDelete(b_num);
		result = boardService.boardDelete(boardVO);
		
		if(result==1)
			url = "/board/boardList";
		else
			url = "/board/boardDetail/?b_num="+boardVO.getB_num();
		
		return "redirect:"+url; // jsp �������� ������ ���� �ʰ� ���� ã��
	}
	
	
	/***********************************************************
	 * �� ���� �� ��� ���� �����ϱ�
	 * @param int
	 **********************************************************/
	@ResponseBody
	@RequestMapping(value="/replyCnt")
	public String replyCnt(@RequestParam("b_num") int b_num) {
		log.info("replyCnt ȣ�� ����");
		
		int result = 0;
		result = boardService.replyCnt(b_num);
		
		return String.valueOf(result);
	}
}
