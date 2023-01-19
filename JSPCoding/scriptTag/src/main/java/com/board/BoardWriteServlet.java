package com.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/boardInsert")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Board board = new Board();
		
		String boardWriter = request.getParameter("boardWriter​");
		String boardTitle = request.getParameter("boardTitle​​");
		String boardContent = request.getParameter("boardContent​");
		
		board.setBoardWriter(boardWriter);
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		
		BoardService boardService = BoardService.getInstance();
		boolean result = boardService.insertBoard(board);
		
		if(result)
			response.sendRedirect("board/boardList.jsp");
		else {
			request.setAttribute("message", "게시글 등록 실패!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/board/error.jsp");
			dispatcher.forward(request, response);
		}
	}

}
