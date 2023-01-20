package com.board.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.board.dao.BoardDao;
import com.board.vo.Board;

import static com.board.common.JDBCTemplate.*;

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
		Connection conn = getConnection();
		boolean result = false;
		result = new BoardDao().insertBoard(conn, board);

		if(result){
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
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
	
	public boolean deleteBoard(Board board) {
		Connection conn = null;
		boolean result = false;
		try {
			conn = getConnection();
			result = new BoardDao().deleteBoard(conn, board);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return result;
	}	
}