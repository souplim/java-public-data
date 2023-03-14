package com.spring.admin.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.client.board.dao.BoardDao;
import com.spring.client.board.vo.BoardVO;

import lombok.Setter;

@Service
public class AdminBoardServiceImpl implements AdminBoardService {

	@Setter(onMethod_ = @Autowired)
	private BoardDao boardDao;

	@Override
	public List<BoardVO> boardList(BoardVO bvo) {
		List<BoardVO> aList = null;
		
		aList = boardDao.boardList(bvo);
		return aList;
	}

	@Override
	public int boardListCnt(BoardVO bvo) {
		int countNum = 0;
		countNum = boardDao.boardListCnt(bvo);
		return countNum;
	}

	@Override
	public BoardVO boardDetail(int b_num) {
		BoardVO bvo = boardDao.boardDetail(b_num);
		return bvo;
	}

	@Override
	public int boardDelete(int b_num) {
		int result = boardDao.boardDelete(b_num);
		return result;
	}
	
	
}
