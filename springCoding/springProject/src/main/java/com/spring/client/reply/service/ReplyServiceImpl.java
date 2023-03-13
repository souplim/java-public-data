package com.spring.client.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.client.reply.dao.ReplyDao;
import com.spring.client.reply.vo.ReplyVO;

import lombok.Setter;

@Service // 인스턴스 만들어짐
public class ReplyServiceImpl implements ReplyService {

	@Setter(onMethod_ = @Autowired) // 의존객체 주입
	private ReplyDao replyDao;

	// 글목록 구현
	@Override
	public List<ReplyVO> replyList(Integer b_num) {
		List<ReplyVO> list = null;
		list = replyDao.replyList(b_num);
		return list;
	}

	// 글입력 구현
	@Override
	public int replyInsert(ReplyVO rvo) {
		int result = 0;
		result = replyDao.replyInsert(rvo);
		return result;
	}

	// 댓글 비밀번호 확인 구현
	@Override
	public int pwdConfirm(ReplyVO rvo) {
		int result = 0;
		result = replyDao.pwdConfirm(rvo);
		return result;
	}
	
	// 글 수정 구현
	@Override
	public int replyUpdate(ReplyVO rvo) {
		int result = 0;
		result = replyDao.replyUpdate(rvo);
		return result;
	}

	// 글 삭제 구현
	@Override
	public int replyDelete(Integer r_num) {
		int result = 0;
		result = replyDao.replyDelete(r_num);
		return result;
	}
	
}
