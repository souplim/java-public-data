package com.mvc.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.common.controller.Controller;
import com.mvc.user.service.UserService;

public class UserPasswdCheckController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String u_id = request.getParameter("u_id");
		String u_pw = request.getParameter("u_pw");
		
		UserService service = UserService.getInstance();
		int result = service.userPasswdChk(u_id, u_pw);
		
		request.setAttribute("resultData", result);
		return "/common/resultData";
	}

}
