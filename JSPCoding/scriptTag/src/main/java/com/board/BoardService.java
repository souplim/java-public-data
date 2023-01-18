package com.board;

import java.sql.Connection;
import java.util.ArrayList;

import static com.board.JDBCTemplate.*;

public class BoardService {
	private static BoardService instance = null;
	
	public static BoardService getInstance() {
		if(instance == null)
			instance = new BoardService();
		return instance;
	}
	
	public ArrayList<Board> listBoard(){
		ArrayList<Board> list = new ArrayList<>();
		list = new BoardDao().listBoard();
		return list;
	}
	
	public boolean insertBoard(Board board) {
		Connection conn = null;
		boolean result = false;
		try {
			conn = getConnection();
			result = new BoardDao().insertBoard(conn, board);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return result;
	}
	
	public boolean updateBoard(Board board) {
		Connection conn = null;
		boolean result = false;
		try {
			conn = getConnection();
			result = new BoardDao().updateBoard(conn, board);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return result;
	}
	
}
