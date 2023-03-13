package com.spring.client.board.service;

import java.util.List;

import com.spring.client.board.vo.BoardVO;

public interface BoardService {
	
	public List<BoardVO> boardList(BoardVO boardVO);
	public int boardListCnt(BoardVO boardVO);
	public int boardInsert(BoardVO boardVO) throws Exception;
	public BoardVO boardDetail(int b_num);
	
	public int pwdConfirm(BoardVO boardVO);
	public BoardVO UpdateForm(int b_num) throws Exception;
	public int boardUpdate(BoardVO boardVO) throws Exception;
//	public int boardDelete(int b_num) throws Exception;
	public int boardDelete(BoardVO boardVO) throws Exception;
	
	public int replyCnt(int b_num);
}
