package com.spring.client.board.dao;

import java.util.List;

import com.spring.client.board.vo.BoardVO;

public interface BoardDao {
	
//	public List<BoardVO> boardList();
	public List<BoardVO> boardList(BoardVO boardVO); /* �˻� ���� ����Ʈ */
	public int boardListCnt(BoardVO boardVO); /* ����¡�� ���� ��ü ���ڵ� ���� ��ȯ */
	public int boardInsert(BoardVO boardVO);
	public BoardVO boardDetail(int b_num);
	public int readCntUpdate(int b_num); /* �Խ��� ��ȸ�� ���� */
	
	public int pwdConfirm(BoardVO boardVO);
	public int boardUpdate(BoardVO boardVO);
	public int boardDelete(int b_num);
}
