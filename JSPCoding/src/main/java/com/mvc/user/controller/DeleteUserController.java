package com.mvc.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.common.controller.Controller;
import com.mvc.user.service.UserService;
import com.mvc.user.vo.UserVO;

public class DeleteUserController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String path = null;
		HttpSession session = request.getSession();
		
		UserVO uvo = (UserVO)session.getAttribute("loginfo");
		String u_id = uvo.getU_id();
		
		UserService service = UserService.getInstance();
		boolean result = service.UserDelete(u_id);
		
		if(result) {
			path = "/user/loginForm.do";
			session.invalidate();
		} else
			path = "/user/detailUser.do";
		
		return path;
	}
}
