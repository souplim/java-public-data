package com.mvc.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.common.controller.Controller;

public class LogoutController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession(false);
		if(session!=null&&session.getAttribute("loginfo")!=null) {
			session.invalidate();
		}else {
			request.setAttribute("errorMsg", "로그인 정보가 없습니다.");
		}

		return "/board/getBoardList.do";
		//return "/user/loginForm.do";
	}
}
