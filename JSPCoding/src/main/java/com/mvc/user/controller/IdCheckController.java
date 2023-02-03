package com.mvc.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.user.service.UserService;
import com.mvc.common.controller.Controller;

public class IdCheckController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String u_id = request.getParameter("u_id");
		
		UserService service = UserService.getInstance();
		int result = service.userIdChk(u_id); // 중복이면 1, 아니면 0 반환
		
		request.setAttribute("resultData", result);
		return "/common/resultData";
	}

}
