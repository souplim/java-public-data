package com.spring.client.reply.dao; 
// �����׽�Ʈ�� ��Ű���� �׽�Ʈ�� �ڹ� ��Ű���� ���ƾ� ��
// �׷��� dao�� import�� ����

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.client.reply.vo.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	@Setter(onMethod_ = @Autowired) // replyDao�� ���� �����ϰ� @Setter �����;� ��
	private ReplyDao replyDao;
	
	/* @Test
	public void testReplyList() {
		log.info("replyList() �޼��� ����");
		
		List<ReplyVO> list = replyDao.replyList(1);
		for(ReplyVO vo : list)
			log.info(vo);
	} */
	
	/* @Test
	public void testReplyInsert() {
		log.info("replyInsert() �޼��� ����");
		
		ReplyVO rvo = new ReplyVO();
		rvo.setB_num(1);
		rvo.setR_name("������");
		rvo.setR_content("������Ʈ ����");
		rvo.setR_pwd("1234");
		
		int result = replyDao.replyInsert(rvo);
		log.info("�Է°�� : " + result);
	} */
	
	/* @Test
	public void testPwdConfirm() {
		log.info("pwdConfirm() �޼��� ����");
		
		ReplyVO rvo = new ReplyVO();
		rvo.setR_num(1);
		rvo.setR_pwd("1234");
		
		int result = replyDao.pwdConfirm(rvo);
		log.info("�Է°�� : "+result);
	} */
	
	/* @Test
	public void testReplyUpdate() {
		log.info("replyUpdate() �޼��� ����");
		
		ReplyVO rvo = new ReplyVO();
		rvo.setR_content("��� ����");
		rvo.setR_pwd("1234");
		rvo.setR_num(1);
		
		int result = replyDao.replyUpdate(rvo);
		log.info("�Է°�� : "+result);
	} */
	
	/* @Test
	public void testReplyDelete() {
		log.info("replyDelete() �޼��� ����");
		
		int result = replyDao.replyDelete(9);
		log.info("�Է°�� : " + result);
	} */
	
	/* @Test
	public void testReplyCnt() {
		log.info("replyCnt() �޼��� ����");
		
		int result = replyDao.replyCnt(1);
		log.info("�Է°�� : " + result);
	} */
}
