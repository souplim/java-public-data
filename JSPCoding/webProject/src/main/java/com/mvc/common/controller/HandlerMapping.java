package com.mvc.common.controller;

import java.util.HashMap;
import java.util.Map;

import com.mvc.board.controller.DeleteBoardController;
import com.mvc.board.controller.DetailBoardController;
import com.mvc.board.controller.GetBoardListController;
import com.mvc.board.controller.InsertBoardController;
import com.mvc.board.controller.InsertFormController;
import com.mvc.board.controller.UpdateFormController;
import com.mvc.board.dao.UpdateBoardController;

public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		//					매핑정보(key) 구현클래스(value)
		mappings = new HashMap<String, Controller>();
		
		// 답변형 게시판 처리
		mappings.put("/board/getBoardList.do", new GetBoardListController()); /* 게시판 리스트 */
		mappings.put("/board/insertForm.do", new InsertFormController()); /* 게시판 입력폼 */
		mappings.put("/board/insertBoard.do", new InsertBoardController()); /* 게시판 등록 */
		mappings.put("/board/detailBoard.do", new DetailBoardController()); /* 게시판 상세페이지 */
		
		mappings.put("/board/updateForm.do", new UpdateFormController()); /* 게시판 수정폼 */
		mappings.put("/board/updateBoard.do", new UpdateBoardController()); /* 게시판 수정 */
		mappings.put("/board/deleteBoard.do", new DeleteBoardController()); /* 게시판 삭제 */
	}
	
	public Controller getController(String path) { // 게시판리스트일 경우 path="/board/getBoardList.do"
		// mappings.get("/board/getBoardList.do") => new GetBoardListController()의 주소값 반환
		return mappings.get(path); // key값 넣으면 value 반환 (어떤 로직인지)				   
	}
}
