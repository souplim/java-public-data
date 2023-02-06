package com.mvc.user.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.common.controller.Controller;
import com.mvc.user.service.UserService;
import com.mvc.user.vo.UserVO;

public class GetUserListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		UserService service = UserService.getInstance();
		ArrayList<UserVO> list = service.userList();
		request.setAttribute("list", list);
		
		return "/user/getUserList";
	}

}
