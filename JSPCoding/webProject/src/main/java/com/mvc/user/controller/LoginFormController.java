package com.mvc.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.common.controller.Controller;

public class LoginFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String path = null;
		String code = request.getParameter("code"); // 정상적 접근인지 실패인지
		
		HttpSession session = request.getSession(false);
		if(session!=null&&session.getAttribute("loginfo")!=null) {
			request.setAttribute("errorMsg", "이미 로그인한 상태입니다.");
			path = "/board/getBoardList.do";
		} else if(code.equals("0")) {
			request.setAttribute("regMsg", "회원가입이 완료되었습니다.");
			path = "/user/loginForm";
		} else {
			path = "/user/loginForm";
		}
		return path;
	}

}
