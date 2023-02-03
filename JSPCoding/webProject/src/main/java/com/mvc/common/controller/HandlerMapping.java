package com.mvc.common.controller;

import java.util.HashMap;
import java.util.Map;

import com.mvc.board.controller.DeleteBoardController;
import com.mvc.board.controller.DetailBoardController;
import com.mvc.board.controller.GetBoardListController;
import com.mvc.board.controller.InsertBoardController;
import com.mvc.board.controller.InsertFormController;
import com.mvc.board.controller.PasswdCheckController;
import com.mvc.board.controller.ReplyFormController;
import com.mvc.board.controller.UpdateFormController;
import com.mvc.board.controller.UpdateBoardController;
import com.mvc.user.controller.DeleteUserController;
import com.mvc.user.controller.DetailUserController;
import com.mvc.user.controller.GetUserListController;
import com.mvc.user.controller.IdCheckController;
import com.mvc.user.controller.LoginFormController;
import com.mvc.user.controller.LoginSessionController;
import com.mvc.user.controller.LogoutController;
import com.mvc.user.controller.RegisterFormController;
import com.mvc.user.controller.RegisterUserController;
import com.mvc.user.controller.UpdateUserController;
import com.mvc.user.controller.UpdateUserFormController;
import com.mvc.user.controller.UserPasswdCheckController;

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
		mappings.put("/board/passwdCheck.do", new PasswdCheckController()); /* 게시판 비밀번호 확인 */
		mappings.put("/board/updateForm.do", new UpdateFormController()); /* 게시판 수정폼 */
		mappings.put("/board/updateBoard.do", new UpdateBoardController()); /* 게시판 수정 */
		mappings.put("/board/deleteBoard.do", new DeleteBoardController()); /* 게시판 삭제 */
		mappings.put("/board/replyForm.do", new ReplyFormController()); /* 답변 등록 화면 */

		// 회원가입
		mappings.put("/user/registerForm.do", new RegisterFormController()); /* 회원가입 폼 */
		mappings.put("/user/registerUser.do", new RegisterUserController()); /* 회원가입 등록 */
		mappings.put("/user/idCheck.do", new IdCheckController()); /* 회원가입 아이디 중복 확인 */
		mappings.put("/user/loginForm.do", new LoginFormController()); /* 로그인 폼 */
		mappings.put("/user/logout.do", new LogoutController()); /* 로그인 폼 */
		mappings.put("/user/loginSession.do", new LoginSessionController()); /* 로그인 */
		mappings.put("/user/detailUser.do", new DetailUserController()); /* 회원정보 상세페이지 */
		mappings.put("/user/userPasswdCheck.do", new UserPasswdCheckController()); /* 회원정보 수정 비밀번호 확인 */
		mappings.put("/user/updateUserForm.do", new UpdateUserFormController()); /* 회원정보 수정 폼 */
		mappings.put("/user/updateUser.do", new UpdateUserController()); /* 회원정보 수정 */
		mappings.put("/user/deleteUser.do", new DeleteUserController()); /* 회원 탈퇴 */
		
		mappings.put("/user/getUserList.do", new GetUserListController()); /* 관리자 페이지 - 회원 리스트 출력 */
		// 세션을 체크한 뒤에 세션의 아이디 정보가 관리자 아이디와 일치하면 유저 리스트를 받아서 getUserList.jsp 뷰에 출력한다.
		
	}
	
	public Controller getController(String path) { // 게시판리스트일 경우 path="/board/getBoardList.do"
		// mappings.get("/board/getBoardList.do") => new GetBoardListController()의 주소값 반환
		return mappings.get(path); // key값 넣으면 value 반환 (어떤 로직인지). 맵핑 잘못 주면 ctrl nullException		   
	}
}
