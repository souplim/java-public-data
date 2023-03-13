package com.spring.client.board.dao; // 처리할 Mapper(Dao)와 동일한 패키지 내에 있어야 정상처리 됨

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
@Log4j // pom.xml에 <scope>runtime</scope>가 주석처리 되어있어야 함
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardDao boardDao;
	
	/* @Test
	public void testBoardList() {
		log.info("------------------------------");
		log.info("boardList() 메서드 실행");
		
		List<BoardVO> list = boardDao.boardList();
		for(BoardVO vo : list)
			log.info(vo);
	} */
	
	/* @Test
	public void testBoardList() {
		log.info("------------------------------");
		log.info("boardList(BoardVO boardVO) 메서드 실행");
		
		BoardVO boardVO = new BoardVO();
		
		boardVO.setPageNum(1); // 페이지 번호 설정
		boardVO.setAmount(10); // 한 페이지에 보여줄 데이터 수
		
		boardVO.setSearch("b_title"); // 이름에서
		boardVO.setKeyword("게시판"); // 노력이 포함된 글 검색
		
		List<BoardVO> list = boardDao.boardList(boardVO);
		for(BoardVO vo : list)
			log.info(vo);
		
		log.info("레코드 수: "+boardDao.boardListCnt(boardVO));
	} */
	
	/* @Test
	public void testBoardInsert() {
		log.info("------------------------------");
		log.info("boardInsert() 메서드 실행");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setB_name("박설희");
		boardVO.setB_title("게시판");
		boardVO.setB_content("게시판 예제");
		boardVO.setB_pwd("1234");
		
		int count = boardDao.boardInsert(boardVO);
		log.info("입력된 행의 수: "+count);
	} */
	
	/* @Test
	public void testBoardDetail() {
		log.info("------------------------------");
		log.info("boardDetail() 메서드 실행");

		BoardVO boardVO = boardDao.boardDetail(8);
		log.info(boardVO);
	} */
	
	/* @Test
	public void testReadCntUpdate() {
		log.info("------------------------------");
		log.info("readCntUpdate() 메서드 실행");
		
		boardDao.readCntUpdate(132);
		BoardVO boardVO = new BoardVO();
		boardVO.setB_num(132);
		log.info(boardVO.getReadcnt());
	} */
	
	/* @Test
	public void testBoardUpdate() {
		log.info("------------------------------");
		log.info("boardUpdate() 메서드 실행");
		BoardVO boardVO = new BoardVO();
		boardVO.setB_title("게시판5");
		boardVO.setB_content("게시판 예제5");
		boardVO.setB_pwd("4321");
		boardVO.setB_num(2);
		int count = boardDao.boardUpdate(boardVO);
		log.info("수정된 행의 수:"+count);
	} */
	
	/* @Test
	public void testBoardDelete() {
		log.info("------------------------------");
		log.info("boardDelete() 메서드 실행");
		
		int count = boardDao.boardDelete(3);
		log.info("삭제된 행의 수:"+count);
		
	} */
	
	/* @Test
	public void testPwdConfirm() {
		log.info("------------------------------");
		log.info("pwdConfirm() 메서드 실행");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setB_num(1);
		boardVO.setB_pwd("1234");
		int result = boardDao.pwdConfirm(boardVO);
		
		log.info("result : " + result);
	} */
}
