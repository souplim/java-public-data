package com.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.vo.Board;

@WebServlet("/boardDetail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int boardNum = Integer.parseInt(request.getParameter("boardNum")) ;
		String boardWriter = request.getParameter("boardWriter");
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		
		Board board = new Board();
		board.setBoardNum(boardNum);
		board.setBoardWriter(boardWriter);
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		
		request.setAttribute("board", board);
		RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath()+"/jsp/boardUpdateForm.jsp"); 
		dispatcher.forward(request, response); 
	}
}
