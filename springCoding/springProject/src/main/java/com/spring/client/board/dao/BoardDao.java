package com.spring.client.board.dao;

import java.util.List;

import com.spring.client.board.vo.BoardVO;

public interface BoardDao {
	
//	public List<BoardVO> boardList();
	public List<BoardVO> boardList(BoardVO boardVO); /* 검색 포함 리스트 */
	public int boardListCnt(BoardVO boardVO); /* 페이징을 위한 전체 레코드 개수 반환 */
	public int boardInsert(BoardVO boardVO);
	public BoardVO boardDetail(int b_num);
	public int readCntUpdate(int b_num); /* 게시판 조회수 증가 */
	
	public int pwdConfirm(BoardVO boardVO);
	public int boardUpdate(BoardVO boardVO);
	public int boardDelete(int b_num);
}
