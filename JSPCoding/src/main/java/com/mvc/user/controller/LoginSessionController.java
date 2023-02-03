package com.mvc.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.common.controller.Controller;
import com.mvc.user.service.UserService;
import com.mvc.user.vo.UserVO;

public class LoginSessionController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String path = null;
		
		// 로그인 폼에서 받아온 ID와 PW를 담아
		String u_id = request.getParameter("u_id");
		String u_pw = request.getParameter("u_pw");
		
		// 세션에 담을 데이터(아이디, 접속상태, 이름)를 받아서 객체에 저장
		UserService service = UserService.getInstance();
		UserVO data = service.logInfoCheck(u_id,u_pw);
		
		// 세션 객체에 데이터 담은 객체 저장
		if(data!=null) {
			if(data.getU_st()==0) {
				HttpSession session = request.getSession();
				session.setAttribute("loginfo", data);
				session.setMaxInactiveInterval(1800);
				path = "/board/getBoardList.do";
			}else if(data.getU_st()==1){
				request.setAttribute("errorMsg", "이 사이트에서 탈퇴한 회원입니다.");
				path = "/user/loginForm";
			}else if(data.getU_st()==9) {
				HttpSession session = request.getSession();
				session.setAttribute("loginfo", data);
				session.setMaxInactiveInterval(1800);
				path = "/user/getUserList.do";
			}
		}else {
			request.setAttribute("errorMsg", "해당하는 회원 정보가 존재하지 않습니다. 아이디나 비밀번호를 확인하세요.");
			path = "/user/loginForm";
		}
		
		return path;
	}

}
