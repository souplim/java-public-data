package com.mvc.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.common.controller.Controller;
import com.mvc.user.service.UserService;
import com.mvc.user.vo.UserVO;

public class DetailUserController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String path = null;
		//String u_id = request.getParameter("u_id"); // user의 id
		
		HttpSession session = request.getSession();
		UserVO uvo = (UserVO)session.getAttribute("loginfo");
		
		if(uvo==null) {
			path = "/user/loginForm.do";
		} else {
			String u_id = uvo.getU_id();
			
			UserService service = UserService.getInstance();
			
			UserVO data = service.userDetail(u_id);
			request.setAttribute("detail", data);	
			
			path = "/user/detailUser";
		}
		
		return path;
	}
}
