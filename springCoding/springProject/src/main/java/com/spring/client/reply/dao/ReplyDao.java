package com.spring.client.reply.dao;

import java.util.List;

import com.spring.client.reply.vo.ReplyVO;

public interface ReplyDao {
	public List<ReplyVO> replyList(Integer b_num); // ��ü�� ǥ��
	public int replyInsert(ReplyVO rvo);
	public int pwdConfirm(ReplyVO rvo);
	public int replyUpdate(ReplyVO rvo);
	public int replyDelete(Integer r_num);
	public int replyCnt(int b_num);
}
