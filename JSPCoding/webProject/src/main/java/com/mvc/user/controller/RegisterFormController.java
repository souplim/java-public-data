package com.mvc.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.common.controller.Controller;

public class RegisterFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String code = request.getParameter("code"); // 정상적 접근인지 실패인지
		
		if(code==null) {
			return "/user/registerForm"; // forward 시킬 jsp 문서
		} else {
			request.setAttribute("regMsg", "회원가입이 실패하였습니다.");
			return "/user/registerForm"; // forward 시킬 jsp 문서
		}
		
	}
}
