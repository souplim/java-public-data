package com.spring.client.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.client.board.dao.BoardDao;
import com.spring.client.board.vo.BoardVO;
import com.spring.client.reply.dao.ReplyDao;
import com.spring.common.file.FileUploadUtil;

import lombok.Setter;

@Service
public class BoardServiceImpl implements BoardService {

	@Setter(onMethod_ = @Autowired)
	private BoardDao boardDao;
	
	@Setter(onMethod_ = @Autowired)
	private ReplyDao replyDao;
	
	// 글 목록 구현
	@Override
	public List<BoardVO> boardList(BoardVO boardVO) {
		List<BoardVO> list = null;
		list = boardDao.boardList(boardVO);
		return list;
	}
	
	// 전체 레코드 수 구현
	@Override
	public int boardListCnt(BoardVO boardVO) {
		return boardDao.boardListCnt(boardVO);
	}

	// 글 입력 구현
	@Override
	public int boardInsert(BoardVO boardVO) throws Exception {
		int result = 0;
		
		/* 예외를 발생시킬 코드 작성 */
		/* boardVO.setB_num(0);
		if(boardVO.getB_num() == 0)
			throw new IllegalArgumentException("0번 글은 등록할 수 없습니다."); */
		
		if(boardVO.getFile().getSize() > 0) { // 업로드할 파일이 존재하면(파일의 크기로)
			String fileName = FileUploadUtil.fileUpload(boardVO.getFile(), "board"); // board_1658205347977_cat.jpg
			boardVO.setB_file(fileName); // 업로드 파일명 설정
			
			String thumbName = FileUploadUtil.makeThumbnail(fileName); // thumbnail_board_1658205347977_cat.jpg
			boardVO.setB_thumb(thumbName);  // thumbnail 파일명 설정
		}
		
		result = boardDao.boardInsert(boardVO);
		return result;
	}

	// 글 상세 구현
	@Override
	public BoardVO boardDetail(int b_num) {
		BoardVO boardVO = null;
		
		// 조회수 증가(게시글 조회 전에 증가시켜야 함)
		boardDao.readCntUpdate(b_num);
			
		// 게시글 조회
		boardVO = boardDao.boardDetail(b_num);
		if(boardVO!=null) {
			// 모든 개행문자 한 줄 띄기 태그로 변경
			boardVO.setB_content(boardVO.getB_content().toString().replaceAll("\n", "<br/>"));
		}
		
		return boardVO;
	}
	
	// 비밀번호 확인 구현
	@Override
	public int pwdConfirm(BoardVO boardVO) {
		int result = 0;
		result = boardDao.pwdConfirm(boardVO);
		return result;
	}

	// 글 수정 화면
	@Override
	public BoardVO UpdateForm(int b_num) throws Exception {
		BoardVO updateData = null;
		updateData = boardDao.boardDetail(b_num); // boardDetail의 개행문자 처리 때문에 새로 메서드 생성함
		return updateData;
	}
	
	//글 수정 구현
	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		int count = 0;
		
		if(!boardVO.getFile().isEmpty()) { // 새롭게 업로드할 파일(file)이 존재하면
			if(!boardVO.getB_file().isEmpty()) { // 기존 파일(b_file)이 존재하면
				FileUploadUtil.fileDelete(boardVO.getB_file());
				FileUploadUtil.fileDelete(boardVO.getB_thumb());
			}
			
			String fileName = FileUploadUtil.fileUpload(boardVO.getFile(), "board");
			boardVO.setB_file(fileName);
			
			String thumbName = FileUploadUtil.makeThumbnail(fileName);
			boardVO.setB_thumb(thumbName);
		}
		
		count = boardDao.boardUpdate(boardVO);
		return count;
	}

	// 글 삭제 구현
	@Override
//	public int boardDelete(int b_num) { 
// 삭제할 때 boardDetail에서 hidden으로 가져오기 때문에 boardVO로 받지 않고 num으로 받는다면 boardDetail에서 다시 불러와서 삭제해줘야 함
	public int boardDelete(BoardVO boardVO) throws Exception {
		int count = 0;
		
		// 매개변수로 b_num을 가져왔을 때
		/* BoardVO boardVO = boardDao.boardDetail(b_num);
		boardVO.setB_file(boardVO.getB_file());
		boardVO.setB_thumb(boardVO.getB_thumb()); */
		
		if(!boardVO.getB_file().isEmpty()) { // b_file 필드의 값이 null이거나 ""이 아니면(이미지 파일 존재하면)
			FileUploadUtil.fileDelete(boardVO.getB_file());
			FileUploadUtil.fileDelete(boardVO.getB_thumb());
		}
		
		count = boardDao.boardDelete(boardVO.getB_num());
		return count;
	}

	// 해당 게시물의 댓글 존재 여부 확인
	// 댓글이 존재하면 댓글 수를 반환, 존재하면 0을 반환
	@Override
	public int replyCnt(int b_num) {
		int result = 0;
		result = replyDao.replyCnt(b_num);
		return result;
	}

}
