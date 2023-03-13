package com.spring.client.board.dao; // ó���� Mapper(Dao)�� ������ ��Ű�� ���� �־�� ����ó�� ��

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.client.board.vo.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j // pom.xml�� <scope>runtime</scope>�� �ּ�ó�� �Ǿ��־�� ��
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardDao boardDao;
	
	/* @Test
	public void testBoardList() {
		log.info("------------------------------");
		log.info("boardList() �޼��� ����");
		
		List<BoardVO> list = boardDao.boardList();
		for(BoardVO vo : list)
			log.info(vo);
	} */
	
	/* @Test
	public void testBoardList() {
		log.info("------------------------------");
		log.info("boardList(BoardVO boardVO) �޼��� ����");
		
		BoardVO boardVO = new BoardVO();
		
		boardVO.setPageNum(1); // ������ ��ȣ ����
		boardVO.setAmount(10); // �� �������� ������ ������ ��
		
		boardVO.setSearch("b_title"); // �̸�����
		boardVO.setKeyword("�Խ���"); // ����� ���Ե� �� �˻�
		
		List<BoardVO> list = boardDao.boardList(boardVO);
		for(BoardVO vo : list)
			log.info(vo);
		
		log.info("���ڵ� ��: "+boardDao.boardListCnt(boardVO));
	} */
	
	/* @Test
	public void testBoardInsert() {
		log.info("------------------------------");
		log.info("boardInsert() �޼��� ����");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setB_name("�ڼ���");
		boardVO.setB_title("�Խ���");
		boardVO.setB_content("�Խ��� ����");
		boardVO.setB_pwd("1234");
		
		int count = boardDao.boardInsert(boardVO);
		log.info("�Էµ� ���� ��: "+count);
	} */
	
	/* @Test
	public void testBoardDetail() {
		log.info("------------------------------");
		log.info("boardDetail() �޼��� ����");

		BoardVO boardVO = boardDao.boardDetail(8);
		log.info(boardVO);
	} */
	
	/* @Test
	public void testReadCntUpdate() {
		log.info("------------------------------");
		log.info("readCntUpdate() �޼��� ����");
		
		boardDao.readCntUpdate(132);
		BoardVO boardVO = new BoardVO();
		boardVO.setB_num(132);
		log.info(boardVO.getReadcnt());
	} */
	
	/* @Test
	public void testBoardUpdate() {
		log.info("------------------------------");
		log.info("boardUpdate() �޼��� ����");
		BoardVO boardVO = new BoardVO();
		boardVO.setB_title("�Խ���5");
		boardVO.setB_content("�Խ��� ����5");
		boardVO.setB_pwd("4321");
		boardVO.setB_num(2);
		int count = boardDao.boardUpdate(boardVO);
		log.info("������ ���� ��:"+count);
	} */
	
	/* @Test
	public void testBoardDelete() {
		log.info("------------------------------");
		log.info("boardDelete() �޼��� ����");
		
		int count = boardDao.boardDelete(3);
		log.info("������ ���� ��:"+count);
		
	} */
	
	/* @Test
	public void testPwdConfirm() {
		log.info("------------------------------");
		log.info("pwdConfirm() �޼��� ����");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setB_num(1);
		boardVO.setB_pwd("1234");
		int result = boardDao.pwdConfirm(boardVO);
		
		log.info("result : " + result);
	} */
}
