package com.mvc.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.user.service.UserService;
import com.mvc.common.controller.Controller;
import com.mvc.user.vo.UserVO;

public class RegisterUserController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String path = null;
		
		UserVO vo = new UserVO();
		vo.setU_id(request.getParameter("u_id"));
		vo.setU_pw(request.getParameter("u_pw"));
		vo.setU_name(request.getParameter("u_name"));
		vo.setU_email(request.getParameter("u_email"));
		vo.setU_phone(request.getParameter("u_phone"));
		vo.setU_gender(request.getParameter("u_gender"));
		
		UserService service = UserService.getInstance();
		boolean result = service.userInsert(vo);
		
		if(result) { // 등록 성공시 로그인창으로 이동. 
			path = "/user/loginForm.do?code=0";
			// do먼저 거치고 jsp로 넘어가면서 메시지 안 넘어가는 것(request 범위)
			//request.setAttribute("regMsg", "회원가입이 완료되었습니다.");
		}
		else {	// 등록 실패시 수정화면으로 이동. 이 때 코드번호 넘겨서 실패인지 아닌지 검사
			path = "/user/registerForm.do?code=1";
			// 여기서 에러코드 받아서 registerUserController에서 msg set해야 함
			//request.setAttribute("regMsg", "회원가입이 실패하였습니다.");
		}
		return path;
	}
}
