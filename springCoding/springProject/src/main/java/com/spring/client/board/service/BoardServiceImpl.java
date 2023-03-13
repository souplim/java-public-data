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
	
	// �� ��� ����
	@Override
	public List<BoardVO> boardList(BoardVO boardVO) {
		List<BoardVO> list = null;
		list = boardDao.boardList(boardVO);
		return list;
	}
	
	// ��ü ���ڵ� �� ����
	@Override
	public int boardListCnt(BoardVO boardVO) {
		return boardDao.boardListCnt(boardVO);
	}

	// �� �Է� ����
	@Override
	public int boardInsert(BoardVO boardVO) throws Exception {
		int result = 0;
		
		/* ���ܸ� �߻���ų �ڵ� �ۼ� */
		boardVO.setB_num(0);
		if(boardVO.getB_num() == 0)
			throw new IllegalArgumentException("0�� ���� ����� �� �����ϴ�.");
		
		if(boardVO.getFile().getSize() > 0) { // ���ε��� ������ �����ϸ�(������ ũ���)
			String fileName = FileUploadUtil.fileUpload(boardVO.getFile(), "board"); // board_1658205347977_cat.jpg
			boardVO.setB_file(fileName); // ���ε� ���ϸ� ����
			
			String thumbName = FileUploadUtil.makeThumbnail(fileName); // thumbnail_board_1658205347977_cat.jpg
			boardVO.setB_thumb(thumbName);  // thumbnail ���ϸ� ����
		}
		
		result = boardDao.boardInsert(boardVO);
		return result;
	}

	// �� �� ����
	@Override
	public BoardVO boardDetail(int b_num) {
		BoardVO boardVO = null;
		
		// ��ȸ�� ����(�Խñ� ��ȸ ���� �������Ѿ� ��)
		boardDao.readCntUpdate(b_num);
			
		// �Խñ� ��ȸ
		boardVO = boardDao.boardDetail(b_num);
		if(boardVO!=null) {
			// ��� ���๮�� �� �� ��� �±׷� ����
			boardVO.setB_content(boardVO.getB_content().toString().replaceAll("\n", "<br/>"));
		}
		
		return boardVO;
	}
	
	// ��й�ȣ Ȯ�� ����
	@Override
	public int pwdConfirm(BoardVO boardVO) {
		int result = 0;
		result = boardDao.pwdConfirm(boardVO);
		return result;
	}

	// �� ���� ȭ��
	@Override
	public BoardVO UpdateForm(int b_num) throws Exception {
		BoardVO updateData = null;
		updateData = boardDao.boardDetail(b_num); // boardDetail�� ���๮�� ó�� ������ ���� �޼��� ������
		return updateData;
	}
	
	//�� ���� ����
	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		int count = 0;
		
		if(!boardVO.getFile().isEmpty()) { // ���Ӱ� ���ε��� ����(file)�� �����ϸ�
			if(!boardVO.getB_file().isEmpty()) { // ���� ����(b_file)�� �����ϸ�
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

	// �� ���� ����
	@Override
//	public int boardDelete(int b_num) { 
// ������ �� boardDetail���� hidden���� �������� ������ boardVO�� ���� �ʰ� num���� �޴´ٸ� boardDetail���� �ٽ� �ҷ��ͼ� ��������� ��
	public int boardDelete(BoardVO boardVO) throws Exception {
		int count = 0;
		
		// �Ű������� b_num�� �������� ��
		/* BoardVO boardVO = boardDao.boardDetail(b_num);
		boardVO.setB_file(boardVO.getB_file());
		boardVO.setB_thumb(boardVO.getB_thumb()); */
		
		if(!boardVO.getB_file().isEmpty()) { // b_file �ʵ��� ���� null�̰ų� ""�� �ƴϸ�(�̹��� ���� �����ϸ�)
			FileUploadUtil.fileDelete(boardVO.getB_file());
			FileUploadUtil.fileDelete(boardVO.getB_thumb());
		}
		
		count = boardDao.boardDelete(boardVO.getB_num());
		return count;
	}

	// �ش� �Խù��� ��� ���� ���� Ȯ��
	// ����� �����ϸ� ��� ���� ��ȯ, �����ϸ� 0�� ��ȯ
	@Override
	public int replyCnt(int b_num) {
		int result = 0;
		result = replyDao.replyCnt(b_num);
		return result;
	}

}
