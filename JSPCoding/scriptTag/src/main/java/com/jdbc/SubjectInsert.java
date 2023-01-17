package com.jdbc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.subject.SubjectVO;


@WebServlet("/insert")
public class SubjectInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		SubjectVO vo = new SubjectVO();
		vo.setS_num(request.getParameter("s_num"));
		vo.setS_name(request.getParameter("s_name"));
		
		SubjectService subjectService = SubjectService.getInstance();
		
		boolean result = subjectService.subjectInsert(vo);
		
		if(result) {
			response.sendRedirect("/scriptTag/list");
		} else {
			request.setAttribute("message", "게시글 등록 실패");
			RequestDispatcher dispatcher = request.getRequestDispatcher("jdbc/error.jsp");
			dispatcher.forward(request, response);
			
			// 디버깅
//			// 예외 객체 가져오기 - 예외가 발생되면 서블렛이 request에 throwable객체 담아둠
//			Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
//			// 에러 상태코드 가져오기
//			Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status.code");
//			// 에러 발생한 서블릿 이름 가져오기
//			String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");

		}
	}
}
