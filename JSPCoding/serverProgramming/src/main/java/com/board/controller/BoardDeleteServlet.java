package com.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.service.BoardService;
import com.board.vo.Board;

@WebServlet("/boardDelete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Board board = new Board();
		
		int	boardNum = Integer.parseInt(request.getParameter("boardNum"));
		board.setBoardNum(boardNum);
		
		BoardService boardService = BoardService.getInstance();
		boolean result = boardService.deleteBoard(board);
		
		if(result)
			response.sendRedirect("/serverProgramming/jsp/boardList.jsp");
		else {
			request.setAttribute("message", "게시글 삭제 실패!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/serverProgramming/jsp/error.jsp");
			dispatcher.forward(request, response);
		}
	}
}
