package com.dispatcher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet3
 */
@WebServlet("/firstDispatcher")
public class FirstServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		// get 방식
//		RequestDispatcher dispatch = request.getRequestDispatcher("secondDispatcher?language=java&name=kh&address=seoul");
//		dispatch.forward(request, response); // 이동
		
		// 속성 설정하기 위해 dispatch 사용 -> 속성을 second에 공유 가능
		// get 방님 아님
		request.setAttribute("language", "java");
		request.setAttribute("name", "홍길동");
		request.setAttribute("address", "테헤란로");
		RequestDispatcher dispatch = request.getRequestDispatcher("secondDispatcher");
		dispatch.forward(request, response);
	}
}
