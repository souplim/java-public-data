package com.redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/firstRedirect")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * response.setContentType("text/html;charset=UTF-8"); // 같은 context 명을 사용하기에 생략
	 * 가능 // response.sendRedirect("/servletExample/secondRedirect?name=Younghee");
	 * response.sendRedirect("secondRedirect?name=Younghee"); }
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// 같은 context 명을 사용하기에 생략 가능
		request.setAttribute("address","서울특별시 영등포구 의사당대로 1");
		response.sendRedirect("secondRedirect");
	}
}
