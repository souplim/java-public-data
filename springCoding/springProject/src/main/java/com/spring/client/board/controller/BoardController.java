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
	 * 게시판 글목록 구현하기(페이징 처리부분과 검색 제외 목록 조회)
	 * 요청 주소 : http://localhost:8080/board/boardList
	 **********************************************************/
	@RequestMapping(value="/boardList", method = RequestMethod.GET) // 매핑에는 /붙고
	public String boardList(@ModelAttribute BoardVO boardVO, Model model) {
		log.info("boardList 호출 성공");
		
		// 전체 레코드 조회
		List<BoardVO> boardList = boardService.boardList(boardVO);
		model.addAttribute("boardList", boardList);
		
		// 전체 레코드수 구현
		int total = boardService.boardListCnt(boardVO);
	    // 페이징 처리
		model.addAttribute("pageMaker", new PageDTO(boardVO, total)); // new PageDTO(CommonVO 하위 클래스의 인스턴스(BoardVO), 총 레코드수)
		return "board/boardList"; // /WEB-INF/views/board/boardList.jsp // 반환형에는 안 붙음(prefix에 /붙어있음)
	}
	
	/***********************************************************
	 * 게시판 글쓰기 폼 출력하기
	 * 요청 주소 : http://localhost:8080/board/writeForm
	 **********************************************************/
	@RequestMapping(value="/writeForm", method = RequestMethod.GET) 
	public String writeForm() {
		log.info("writeForm 호출 성공");
		return "board/writeForm"; // /WEB-INF/views/board/writeForm.jsp 
	}
	
	/***********************************************************
	 * 글쓰기 구현하기
	 * 요청 주소 : http://localhost:8080/board/boardInsert
	 **********************************************************/
	@RequestMapping(value="/boardInsert", method = RequestMethod.POST) 
	public String boardInsert(BoardVO boardVO, Model model) throws Exception {
		log.info("boardInsert 호출 성공");
		
		int result = 0;
		String url = "";
		
		result = boardService.boardInsert(boardVO);
		if(result==1)
			url = "/board/boardList"; // 매핑을 불러 다시 조회하게 만들어야 하기 때문에 jsp가 아닌 매핑 호출
		else
			url = "/board/writeForm";
		
		return "redirect:"+url; // jsp 페이지로 포워드 하지 않고 매핑 찾음
	}
	
	/***********************************************************
	 * 게시판 상세 페이지 구현하기
	 * 요청 주소 : http://localhost:8080/board/boardDetail
	 **********************************************************/
	@GetMapping("/boardDetail")
	public String boardDetail(@RequestParam("b_num") int b_num, Model model) throws Exception {
		log.info("boardDetail 호출 성공");
		
		BoardVO boardVO = boardService.boardDetail(b_num);
		model.addAttribute("boardVO", boardVO);
		return "board/boardDetail"; // /WEB-INF/views/board/boardDetail.jsp
	}
	
	/***********************************************************
	 * 비밀번호 확인 구현하기
	 * @param b_num: 본인글 여부를 확인할 게시글 번호
	 * @param b_pwd: 입력한 비밀번호
	 * @return int로 result를 0 또는 1을 리턴할 수도 있고,
	 * 		   String으로 result값을 "성공(일치)" 또는 "실패(불일치)"를 리턴할 수도 있음(현재 문자열 리턴)
	 * 참고 : @ResponseBody는 전달된 뷰를 통해서 출력하는 것이 아니라 HTTP Response Body에 직접 출력하는 방식(ajax 요청시 사용)
	 * 		 produces 속성은 지정한 미디어 타입과 관련된 응답을 생성하는데 사용한 실제 컨텐트 타입을 보장
	 **********************************************************/
	@ResponseBody
	@RequestMapping(value="/pwdConfirm", method = RequestMethod.POST, produces="text/plain; charset=UTF-8")
	public String pwdConfirm(BoardVO boardVO) {
		log.info("pwdConfirm 호출 성공");
		String value = "";
		
		// 입력 성공에 대한 상태값 저장(1 or 0)
		int result = boardService.pwdConfirm(boardVO);
		if(result==1)
			value="성공";
		else
			value="실패";
		log.info("result=" + result);
		
		return value; // value값 자체를 브라우저에 출력
	}
	
	/***********************************************************
	 * 게시판 수정 폼 출력하기
	 * 요청 주소 : http://localhost:8080/board/updateForm
	 **********************************************************/
	@RequestMapping("/updateForm")
	public String updateForm(@RequestParam("b_num") int b_num, Model model) {
		log.info("updateForm 호출 성공");
		
		BoardVO boardVO = boardService.boardDetail(b_num);
		model.addAttribute("boardVO", boardVO);
		return "board/updateForm"; // /WEB-INF/views/board/updateForm.jsp
	}
	
	/***********************************************************
	 * 글 수정 하기
	 * 요청 주소 : http://localhost:8080/board/boardUpdate
	 * 수정 로직 -> 파라미터를 받아서 redirect로 가면(if update후 값을 가지고 detail.jsp로 갈 때) get방식만 가능
	 * RedirectAttriutes 객체는 리다이렉트 시점(return "redirect:/경로")에 
	 * 한번만 사용되는 데이터를 전송할 수 있는 addFlashAttribute() 라는 기능을 지원한다.
	 * addFlashAttribute() 메서드는 브라우저까지 전송되기는 하지만, URI 상에는 보이지 않는 숨겨진 데이터의 형태로 전달된다.
	 **********************************************************/
	@RequestMapping(value="/boardUpdate", method = RequestMethod.POST) 
	public String boardUpdate(BoardVO boardVO, RedirectAttributes ras) throws Exception {
		log.info("boardUpdate 호출 성공");
		
		int result = 0;
		String url = "";
		
		result = boardService.boardUpdate(boardVO);
		
		// 리다이렉트 하는 시점에 값 전송할 수 있는 메서드
		// 그러나 새로고침 하면 에러남
		// ras.addFlashAttribute("b_num", boardVO.getB_num());
		
		if(result==1) { // 매핑을 불러 다시 조회하게 만들어야 하기 때문에 jsp가 아닌 매핑 호출
			url = "/board/boardDetail?b_num="+boardVO.getB_num(); 
//			url = "/board/boardDetail";
		} else {
			url = "/board/updateForm?b_num="+boardVO.getB_num(); 
//			url = "/board/updateForm";
		}
		return "redirect:"+url; // jsp 페이지로 포워드 하지 않고 매핑 찾음
	}

	/***********************************************************
	 * 게시글 삭제하기
	 * 요청 주소 : http://localhost:8080/board/boardDelete
	 **********************************************************/
	@RequestMapping("/boardDelete")
//	public String boardDelete(@ModelAttribute("b_num") int b_num) throws Exception {
	public String boardDelete(BoardVO boardVO) throws Exception {
		log.info("boardDelete 호출 성공");
			
		int result = 0;
		String url = "";
		
//		result = boardService.boardDelete(b_num);
		result = boardService.boardDelete(boardVO);
		
		if(result==1)
			url = "/board/boardList";
		else
			url = "/board/boardDetail/?b_num="+boardVO.getB_num();
		
		return "redirect:"+url; // jsp 페이지로 포워드 하지 않고 매핑 찾음
	}
	
	
	/***********************************************************
	 * 글 삭제 전 댓글 개수 구현하기
	 * @param int
	 **********************************************************/
	@ResponseBody
	@RequestMapping(value="/replyCnt")
	public String replyCnt(@RequestParam("b_num") int b_num) {
		log.info("replyCnt 호출 성공");
		
		int result = 0;
		result = boardService.replyCnt(b_num);
		
		return String.valueOf(result);
	}
}
