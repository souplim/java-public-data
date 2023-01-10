package com.location;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet2
 */
@WebServlet("/secondLocation")
public class SecondServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("name"); // 요청 받아온 정보 중 name 가져와라
		int age = Integer.parseInt(request.getParameter("age"));
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html><html><head><meta charset='UTF-8' />");
		out.println("<title>location 예제</title>");
		out.println("<link rel='icon' href='data:,'></head>");
		out.println("<body><div>location을 이용한 redirect 실습입니다.</div>");
		out.println("<div>이름 : "+name+"</div>");
		out.println("<div>나이 : "+age+"</div>");
		out.println("</body></html>");
	}
}
