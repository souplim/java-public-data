package com.spring.client.reply.dao; 
// 단위테스트의 패키지는 테스트할 자바 패키지와 같아야 함
// 그래서 dao의 import문 없음

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

	@Setter(onMethod_ = @Autowired) // replyDao를 먼저 선언하고 @Setter 가져와야 함
	private ReplyDao replyDao;
	
	/* @Test
	public void testReplyList() {
		log.info("replyList() 메서드 실행");
		
		List<ReplyVO> list = replyDao.replyList(1);
		for(ReplyVO vo : list)
			log.info(vo);
	} */
	
	/* @Test
	public void testReplyInsert() {
		log.info("replyInsert() 메서드 실행");
		
		ReplyVO rvo = new ReplyVO();
		rvo.setB_num(1);
		rvo.setR_name("임은재");
		rvo.setR_content("프로젝트 시작");
		rvo.setR_pwd("1234");
		
		int result = replyDao.replyInsert(rvo);
		log.info("입력결과 : " + result);
	} */
	
	/* @Test
	public void testPwdConfirm() {
		log.info("pwdConfirm() 메서드 실행");
		
		ReplyVO rvo = new ReplyVO();
		rvo.setR_num(1);
		rvo.setR_pwd("1234");
		
		int result = replyDao.pwdConfirm(rvo);
		log.info("입력결과 : "+result);
	} */
	
	/* @Test
	public void testReplyUpdate() {
		log.info("replyUpdate() 메서드 실행");
		
		ReplyVO rvo = new ReplyVO();
		rvo.setR_content("댓글 수정");
		rvo.setR_pwd("1234");
		rvo.setR_num(1);
		
		int result = replyDao.replyUpdate(rvo);
		log.info("입력결과 : "+result);
	} */
	
	/* @Test
	public void testReplyDelete() {
		log.info("replyDelete() 메서드 실행");
		
		int result = replyDao.replyDelete(9);
		log.info("입력결과 : " + result);
	} */
	
	/* @Test
	public void testReplyCnt() {
		log.info("replyCnt() 메서드 실행");
		
		int result = replyDao.replyCnt(1);
		log.info("입력결과 : " + result);
	} */
}
