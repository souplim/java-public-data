package com.mvc.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.common.controller.Controller;
import com.mvc.user.service.UserService;
import com.mvc.user.vo.UserVO;

public class UpdateUserController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String path = null;
		
		UserVO vo = new UserVO();
		HttpSession session = request.getSession();
		
		// 왜 u_id가 안 넘겨질까? -> id는 session값을 가져와서 해야 함
		// vo.setU_id((String)session.getAttribute("UserVO"));
		UserVO uvo = (UserVO)session.getAttribute("loginfo"); // ${sessionScope.loginfo.u_id}를 가져오기
		
		vo.setU_id(uvo.getU_id()); 
		vo.setU_pw(request.getParameter("u_pw"));
		vo.setU_name(request.getParameter("u_name"));
		vo.setU_email(request.getParameter("u_email"));
		vo.setU_phone(request.getParameter("u_phone"));
		vo.setU_gender(request.getParameter("u_gender"));
		
		UserService service = UserService.getInstance();
		boolean result = service.userUpdate(vo);
		
		if(result) { // 수정 성공시 로그인 페이지로 이동.
			path = "/user/loginForm.do"; 
			session.invalidate();
		} else	// 수정 실패시 수정화면으로 이동. 이때 레코드의 아이디를 기준으로 조회
			path = "/user/updateUserForm.do?u_id="+vo.getU_id()+"&code=1";
		
		return path;
	}

}
