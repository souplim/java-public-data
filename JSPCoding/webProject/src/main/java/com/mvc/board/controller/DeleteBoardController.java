package com.mvc.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.board.service.BoardService;
import com.mvc.common.controller.Controller;

public class DeleteBoardController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String path = null;
		
		String num = request.getParameter("num");
		
		BoardService service = BoardService.getInstance();
		service.boardDelete(num);

		path = "/board/getBoardList.do";
		
		return path;
	}
}
